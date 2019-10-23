package com.sambaash.platform.product.wrapper;

import java.util.HashMap;
import java.util.List;

import com.sambaash.platform.srv.model.Course;
import com.sambaash.platform.srv.model.Product;

public class ProductDetailWrapper {
	
	String productName;
	Product product;
	Course course;
	List<String> courseList;
	HashMap<Long, List<String>> outcomeDetailsList;
	HashMap<Long, List<String>> moduleDetailsList;
	HashMap<Long, List<String>> scheduleDetailsList;
	HashMap<Long, List<String>> outlineDetailsList;
	HashMap<Long, List<String>> personaDetailsList;
	HashMap<Long, List<String>> graduationCriteriaDetailsList;
	HashMap<Long, List<String>> certificateDetailsList;
	HashMap<Long, List<String>> feeDetailsList;
	HashMap<Long, List<String>> miscfeeDetailsList;
	HashMap<Long, HashMap<Long, List<String>>> selffeeDetailsList;
	HashMap<Long, HashMap<Long, List<String>>> compfeeDetailsList;
	HashMap<Long, HashMap<Long, List<String>>> mobilefeeFundList;
	HashMap<Long, HashMap<Long, List<String>>> mobilecompfeeFundList;
	HashMap<Long, List<String>> fundingDetailsList;
	HashMap<Long, List<String>> competencyDetailsList;
	HashMap<Long, List<String>> frameworkDetailsList;
	
	public ProductDetailWrapper() {
		super();
	}
	public ProductDetailWrapper(Product product, Course course,
			HashMap<Long, List<String>> outcomeDetailsList,
			HashMap<Long, List<String>> moduleDetailsList,
			HashMap<Long, List<String>> scheduleDetailsList,
			HashMap<Long, List<String>> outlineDetailsList,
			HashMap<Long, List<String>> personaDetailsList,
			HashMap<Long, List<String>> graduationCriteriaDetailsList,
			HashMap<Long, List<String>> certificateDetailsList,
			HashMap<Long, List<String>> feeDetailsList,
			HashMap<Long, List<String>> miscfeeDetailsList,
			HashMap<Long, HashMap<Long, List<String>>> selffeeDetailsList,
			HashMap<Long, HashMap<Long, List<String>>> compfeeDetailsList,
			HashMap<Long, HashMap<Long, List<String>>> mobilefeeFundList,
			HashMap<Long, HashMap<Long, List<String>>> mobilecompfeeFundList,
			HashMap<Long, List<String>> fundingDetailsList,
			HashMap<Long, List<String>> competencyDetailsList,
			HashMap<Long, List<String>> frameworkDetailsList) {
		super();
		this.product = product;
		this.course = course;
		this.outcomeDetailsList = outcomeDetailsList;
		this.moduleDetailsList = moduleDetailsList;
		this.scheduleDetailsList = scheduleDetailsList;
		this.outlineDetailsList = outlineDetailsList;
		this.personaDetailsList = personaDetailsList;
		this.graduationCriteriaDetailsList = graduationCriteriaDetailsList;
		this.certificateDetailsList = certificateDetailsList;
		this.feeDetailsList = feeDetailsList;
		this.miscfeeDetailsList = miscfeeDetailsList;
		this.selffeeDetailsList = selffeeDetailsList;
		this.compfeeDetailsList = compfeeDetailsList;
		this.mobilefeeFundList = mobilefeeFundList;
		this.mobilecompfeeFundList = mobilecompfeeFundList;
		this.fundingDetailsList = fundingDetailsList;
		this.competencyDetailsList = competencyDetailsList;
		this.frameworkDetailsList = frameworkDetailsList;
	}

	public HashMap<Long, List<String>> getModuleDetailsList() {
		return moduleDetailsList;
	}

	public void setModuleDetailsList(HashMap<Long, List<String>> moduleDetailsList) {
		this.moduleDetailsList = moduleDetailsList;
	}

	public HashMap<Long, List<String>> getScheduleDetailsList() {
		return scheduleDetailsList;
	}

	public void setScheduleDetailsList(
			HashMap<Long, List<String>> scheduleDetailsList) {
		this.scheduleDetailsList = scheduleDetailsList;
	}

	public HashMap<Long, List<String>> getPersonaDetailsList() {
		return personaDetailsList;
	}

	public void setPersonaDetailsList(HashMap<Long, List<String>> personaDetailsList) {
		this.personaDetailsList = personaDetailsList;
	}

	public List<String> getCourseList() {
		return courseList;
	}

	public void setCourseList(List<String> courseList) {
		this.courseList = courseList;
	}

	public HashMap<Long, List<String>> getGraduationCriteriaDetailsList() {
		return graduationCriteriaDetailsList;
	}

	public void setGraduationCriteriaDetailsList(
			HashMap<Long, List<String>> graduationCriteriaDetailsList) {
		this.graduationCriteriaDetailsList = graduationCriteriaDetailsList;
	}

	public HashMap<Long, List<String>> getCertificateDetailsList() {
		return certificateDetailsList;
	}

	public void setCertificateDetailsList(
			HashMap<Long, List<String>> certificateDetailsList) {
		this.certificateDetailsList = certificateDetailsList;
	}

	public HashMap<Long, List<String>> getFundingDetailsList() {
		return fundingDetailsList;
	}

	public void setFundingDetailsList(HashMap<Long, List<String>> fundingDetailsList) {
		this.fundingDetailsList = fundingDetailsList;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public HashMap<Long, List<String>> getOutcomeDetailsList() {
		return outcomeDetailsList;
	}

	public void setOutcomeDetailsList(HashMap<Long, List<String>> outcomeDetailsList) {
		this.outcomeDetailsList = outcomeDetailsList;
	}

	public HashMap<Long, List<String>> getOutlineDetailsList() {
		return outlineDetailsList;
	}

	public void setOutlineDetailsList(HashMap<Long, List<String>> outlineDetailsList) {
		this.outlineDetailsList = outlineDetailsList;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public HashMap<Long, List<String>> getCompetencyDetailsList() {
		return competencyDetailsList;
	}

	public void setCompetencyDetailsList(
			HashMap<Long, List<String>> competencyDetailsList) {
		this.competencyDetailsList = competencyDetailsList;
	}

	public HashMap<Long, List<String>> getFrameworkDetailsList() {
		return frameworkDetailsList;
	}

	public void setFrameworkDetailsList(
			HashMap<Long, List<String>> frameworkDetailsList) {
		this.frameworkDetailsList = frameworkDetailsList;
	}
	public HashMap<Long, List<String>> getMiscfeeDetailsList() {
		return miscfeeDetailsList;
	}
	public void setMiscfeeDetailsList(HashMap<Long, List<String>> miscfeeDetailsList) {
		this.miscfeeDetailsList = miscfeeDetailsList;
	}
	public HashMap<Long, HashMap<Long, List<String>>> getSelffeeDetailsList() {
		return selffeeDetailsList;
	}
	public void setSelffeeDetailsList(
			HashMap<Long, HashMap<Long, List<String>>> selffeeDetailsList) {
		this.selffeeDetailsList = selffeeDetailsList;
	}
	public HashMap<Long, HashMap<Long, List<String>>> getCompfeeDetailsList() {
		return compfeeDetailsList;
	}
	public void setCompfeeDetailsList(
			HashMap<Long, HashMap<Long, List<String>>> compfeeDetailsList) {
		this.compfeeDetailsList = compfeeDetailsList;
	}
	public HashMap<Long, List<String>> getFeeDetailsList() {
		return feeDetailsList;
	}
	public void setFeeDetailsList(HashMap<Long, List<String>> feeDetailsList) {
		this.feeDetailsList = feeDetailsList;
	}
	public HashMap<Long, HashMap<Long, List<String>>> getMobilefeeFundList() {
		return mobilefeeFundList;
	}
	public void setMobilefeeFundList(
			HashMap<Long, HashMap<Long, List<String>>> mobilefeeFundList) {
		this.mobilefeeFundList = mobilefeeFundList;
	}
	public HashMap<Long, HashMap<Long, List<String>>> getMobilecompfeeFundList() {
		return mobilecompfeeFundList;
	}
	public void setMobilecompfeeFundList(
			HashMap<Long, HashMap<Long, List<String>>> mobilecompfeeFundList) {
		this.mobilecompfeeFundList = mobilecompfeeFundList;
	}

}