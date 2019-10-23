package com.sambaash.platform.portlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import org.jets3t.service.S3Service;
import org.jets3t.service.S3ServiceException;
import org.jets3t.service.impl.rest.httpclient.RestS3Service;
import org.jets3t.service.model.S3Bucket;
import org.jets3t.service.model.S3Object;
import org.jets3t.service.security.AWSCredentials;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.sambaash.platform.scheduler.SPScheduledJob;

public class LogManagingJob extends SPScheduledJob {

	@Override
	public void executeJob() {
		try {
			_log.debug("ExcuteJob invoked.");
			DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			S3Bucket s3bucket = null;
			Date date = new Date();
			Calendar cal = Calendar.getInstance();
			String currentDate = sdf.format(date) + "/";
			String filePattern = null, current = null, currentSubStr = null, splChar = null;
			boolean inputPattern = false;
			Path p;

			Map<String, Object> s3Details = super.getExtrasMap();

			String accessKey = s3Details.get("accessKeyId").toString();
			String secretKey = s3Details.get("secretAccessKey").toString();
			String bucketName = s3Details.get("bucketName").toString();
			String logFilePath = s3Details.get("logFilePath").toString();
			String rootFolder = s3Details.get("rootFolder").toString() + "/";
			boolean creationDate = Boolean.parseBoolean(s3Details.get(
					"creationDate").toString());
			boolean deleteFile = Boolean.parseBoolean(s3Details.get(
					"deleteFile").toString());

			AWSCredentials credentials = AWSCredentials(accessKey, secretKey);

			S3Service s3Service = new RestS3Service(credentials);

			s3bucket = s3Service.getBucket(bucketName);

			// TODO: splitting the logfilepath by comma and process each path
			String[] listOfFilesUser = logFilePath.split(",", -1);

			outerloop: for (int j = 0; j < listOfFilesUser.length; j++) {

				int position = listOfFilesUser[j].lastIndexOf("/");
				int count = 0;
				String fileNameUser = listOfFilesUser[j]
						.substring(position + 1);

				Pattern pattern = Pattern.compile("[^A-Za-z0-9]");
				Matcher m = pattern.matcher(fileNameUser);
				if (m.find()) {
					splChar = Character
							.toString(fileNameUser.charAt(m.start()));
				}
				int position1 = fileNameUser.indexOf(splChar);
				int position2 = fileNameUser.lastIndexOf(splChar);

				if (position1 == position2) {
					inputPattern = false;
				} else {
					inputPattern = true;
					filePattern = fileNameUser.substring(position1 + 1,
							position2);
					m = pattern.matcher(filePattern);
					if (m.find()) {
						splChar = Character.toString(filePattern.charAt(m
								.start()));
					}
					DateFormat df = new SimpleDateFormat(filePattern);
					current = df.format(cal.getTime());

					if (Validator.isNotNull(splChar)) {
						filePattern = current.substring(current
								.lastIndexOf(splChar) + 1);
						currentSubStr = current.substring(0,
								current.lastIndexOf(splChar) + 1);
					} else {
						filePattern = current;
						currentSubStr = "";
					}
				}

				String folderpath = listOfFilesUser[j].substring(0, position);
				File folder = new File(folderpath);
				File[] listOfFiles = folder.listFiles();

				if (inputPattern) {

					for (int k = Integer.parseInt(filePattern); k >= 1; k--) {

						for (int i = 0; i < listOfFiles.length; i++) {

							File file = listOfFiles[i];

							if (fileNameUser.startsWith(file.getName()
									.substring(0, position1 + 1))) {

								fileNameUser = fileNameUser.substring(0,
										position1 + 1)
										+ currentSubStr
										+ k
										+ fileNameUser.substring(position2);

								if (fileNameUser.equalsIgnoreCase(file
										.getName())) {

									if (!creationDate) {
										count = 0;
										moveFiles(folder, file, rootFolder,
												currentDate, s3Service,
												s3bucket, deleteFile);
									} else {
										p = Paths.get(file.getAbsolutePath());
										BasicFileAttributes attributes = Files
												.getFileAttributeView(
														p,
														BasicFileAttributeView.class)
												.readAttributes();
										Date fileCreationDate = new Date(
												attributes.creationTime().to(
														TimeUnit.MILLISECONDS));
										if (fileCreationDate.compareTo(sdf
												.parse(sdf.format(date))) < 0) {
											count = 0;
											moveFiles(folder, file, rootFolder,
													currentDate, s3Service,
													s3bucket, deleteFile);
										}
									}
								} else {
									if (fileNameUser.startsWith(file.getName()
											.substring(0, position1 + 1))) {
										if (i == listOfFiles.length-1) {
											count++;
										}
										if (count == 2) {
											break outerloop;
										}
									}
								}
							}
						}
					}

				}

				else {
					for (int i = 0; i < listOfFiles.length; i++) {

						File file = listOfFiles[i];

						if (fileNameUser.equalsIgnoreCase(file.getName())) {

							p = Paths.get(file.getAbsolutePath());
							BasicFileAttributes attributes = Files
									.getFileAttributeView(p,
											BasicFileAttributeView.class)
									.readAttributes();
							Date fileCreationDate = new Date(attributes
									.creationTime().to(TimeUnit.MILLISECONDS));

							if (fileCreationDate.compareTo(sdf.parse(sdf
									.format(date))) < 0) {
								moveFiles(folder, file, rootFolder,
										currentDate, s3Service, s3bucket,
										deleteFile);
							}
						}

					}

				}

			}
		} catch (S3ServiceException e) {
			_log.error(e);

		} catch (FileNotFoundException e) {
			_log.error(e);

		} catch (Exception e) {
			_log.error(e);

		}

	}

	public void moveFiles(File folder, File file, String rootFolder,
			String currentDate, S3Service s3Service, S3Bucket s3bucket,
			boolean deleteFile) throws FileNotFoundException,
			S3ServiceException {

		File fileData = new File(folder + "/" + file.getName());
		S3Object s3inputfile = new S3Object(file.getName());
		s3inputfile.setKey(rootFolder + currentDate + s3inputfile.getKey());
		s3inputfile.setDataInputStream(new FileInputStream(fileData));
		s3inputfile.setContentLength(fileData.length());
		s3Service.putObject(s3bucket, s3inputfile);

		_log.debug("File has been stored to s3 " + file.getAbsolutePath());
		if (deleteFile) {
			file.delete();
		}

	}

	public static AWSCredentials AWSCredentials(String accessKey,
			String secretKey) {
		return new AWSCredentials(accessKey, secretKey);
	}

	private static Log _log = LogFactoryUtil.getLog(LogManagingJob.class);
}
