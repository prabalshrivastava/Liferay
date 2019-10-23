package com.sambaash.platform.portlet.datapatcing.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.portlet.PortletRequest;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.sambaash.platform.constant.SambaashConstants.EXCEL;
import com.sambaash.platform.exception.FileFormatException;
import com.sambaash.platform.srv.model.Product;
import com.sambaash.platform.srv.processbuilder.model.PEProcessState;
import com.sambaash.platform.srv.processbuilder.service.PEProcessStateLocalServiceUtil;
import com.sambaash.platform.srv.service.ProductLocalServiceUtil;

public class ClosedDateBatchUploadHelper {

	private PortletRequest request;
	private List<String> errors = new ArrayList<String>();
	private List<String> msgs = new ArrayList<String>();

	public ClosedDateBatchUploadHelper(PortletRequest request) {
		this.request = request;

	}

	public void bulkupload() throws FileNotFoundException, IOException,
			FileFormatException {
		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);
		UploadPortletRequest uploadPortletRequest = PortalUtil
				.getUploadPortletRequest(request);
		File[] files = uploadPortletRequest.getFiles("file");
		File file = files[0];
		Workbook wb = null;
		if (file.getName().endsWith(EXCEL.EXTENSION)) {
			wb = readFileXlsx(new FileInputStream(file));
		} else if (file.getName().endsWith(EXCEL.EXTENSION_OLD)) {
			wb = readFileXls(new FileInputStream(file));
		} else {
			throw new FileFormatException(
					FileFormatException.FILE_TYPE_EXCEPTION);
		}

		if (wb == null) {
			throw new FileFormatException(
					FileFormatException.METADATA_EXCEPTION);
		}

		Sheet sheet = wb.getSheetAt(0);
		for (int i = 1; i <= sheet.getLastRowNum(); i++) {
			Row row = sheet.getRow(i);
			if (row == null) {
				continue;
			}
			processRow(row, themeDisplay);
		}

	}

	public void processRow(Row row, ThemeDisplay themeDisplay) {
		try {
			errorsExists = false;
			long processStateId = getLongCellValue(row.getCell(0));
			String closedDate = getDateCellValue(row.getCell(1));

			// Validate

			if (Validator.isNull(processStateId)) {
				addError("Process State Id is required", row);
				return;
			} else {
				try {

					PEProcessState peProcessState = PEProcessStateLocalServiceUtil
							.fetchPEProcessState(processStateId);

					if (peProcessState.getClosedStageId() != 0) {
						peProcessState
								.setClosedDate(getDate4rDDMMYYYY(closedDate));
						PEProcessStateLocalServiceUtil
								.updatePEProcessState(peProcessState);
					} else {
						addError(
								"This application is still in open state hence we are not closing it. Process State Id = "
										+ processStateId, row);
					}

				} catch (Exception e) {
					_log.error(e);
					addError(
							"Error while finding record with Process State Id  = "
									+ processStateId, row);
					return;
				}
			}

			if (!errorsExists) {
				try {

					addMsg("Update success", row);

				} catch (Exception e) {
					_log.error(e);
					addError("Failed", row);
				}
			}

		} catch (UnsupportedOperationException e) {
			_log.error(e);
			addError("Cell Type not supported.Row=", row);
		} catch (Exception e) {
			_log.error(e);
			addError("Error while processing row", row);
		}

	}

	public static Date getDate4rDDMMYYYY(String str) {
		if (Validator.isNotNull(str)) {
			try {
				String format = "dd/MM/yyyy";
				SimpleDateFormat df = new SimpleDateFormat(format);
				Date date = df.parse(str);
				return date;
			} catch (Exception ex) {
				_log.error("Error while format String to date. String=" + str);
			}

		}
		return null;
	}

	public static String getDateStrddMMYYYY(Date date) {
		String dateStr = "";
		String format = "dd/MM/yyyy";
		if (date != null) {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			dateStr = sdf.format(date);
		}
		return dateStr;
	}

	boolean errorsExists = false;

	private void addError(String msg, Row row) {
		errorsExists = true;
		getErrors().add("Row No = " + (row.getRowNum() + 1) + "  " + msg);
	}

	private void addMsg(String msg, Row row) {
		getMsgs().add("Row No = " + (row.getRowNum() + 1) + "  " + msg);
	}

	public long getLongCellValue(Cell cell) {
		String val = getCellValue(cell);
		long longVal = (long) GetterUtil.getDouble(val);
		return longVal;
	}

	public String getCellValue(Cell cell) {
		if (cell == null || cell.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
			return StringPool.BLANK;
		}
		if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
			return cell.getStringCellValue();
		} else if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
			return "" + cell.getNumericCellValue();
		} else {
			throw new UnsupportedOperationException("Cell type not supported");
		}
	}

	public String getDateCellValue(Cell cell) {
		if (cell == null || cell.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
			return StringPool.BLANK;
		}
		if (HSSFCell.CELL_TYPE_NUMERIC == cell.getCellType()
				&& DateUtil.isCellDateFormatted(cell)) {
			Date date = cell.getDateCellValue();
			return getDateStrddMMYYYY(date);
		} else {
			throw new UnsupportedOperationException("Cell type not supported");
		}
	}

	public static HSSFWorkbook readFileXls(InputStream inputStream)
			throws IOException {
		return new HSSFWorkbook(inputStream);
	}

	public static XSSFWorkbook readFileXlsx(InputStream inputStream)
			throws IOException {
		return new XSSFWorkbook(inputStream);
	}

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

	public List<String> getMsgs() {
		return msgs;
	}

	public void setMsgs(List<String> msgs) {
		this.msgs = msgs;
	}

	private static final Log _log = LogFactoryUtil
			.getLog(ClosedDateBatchUploadHelper.class);
}
