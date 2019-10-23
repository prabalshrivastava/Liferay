package com.sambaash.platform.model.microservice.pricing.dto;

import com.sambaash.platform.model.microservice.pricing.enums.PriceCategory;
import com.sambaash.platform.model.microservice.pricing.enums.PriceType;

import java.util.*;

public class PriceCalculationInputDto {
	private String programmeScheduleCode;
	private String scheduleCode;
	private PriceType programmeType;
	private Integer fullUnitNumber;
	private Integer halfUnitNumber;
	private Integer lawUnitNumber;
	private Date date;
	private List<String> priceSchemeCode;
	private String action;
	private String promoCode;
	private List<SubjectDto> subjects;
	private List<String> priceSubTypes;
	private String baseCurrency;
	private String baseCurrencyCode;
	private String roundingScale;
	private String roundingMode;
	private String purposeForExchangeRate;
	private PriceCategory priceCategory;
	private Set<String> subjectTypes = new HashSet<>();
	public String getRoundingScale() {
		return roundingScale;
	}
	public void setRoundingScale(String roundingScale) {
		this.roundingScale = roundingScale;
	}
	public String getRoundingMode() {
		return roundingMode;
	}
	public void setRoundingMode(String roundingMode) {
		this.roundingMode = roundingMode;
	}
	private Map<String, Integer> subjectTypeIntegerMap = new HashMap<>();
	private Map<String, List<Long>> transactionFeeMap = new HashMap<>();
	public String getProgrammeScheduleCode() {
		return programmeScheduleCode;
	}
	public void setProgrammeScheduleCode(String programmeScheduleCode) {
		this.programmeScheduleCode = programmeScheduleCode;
	}
	public String getScheduleCode() {
		return scheduleCode;
	}
	public void setScheduleCode(String scheduleCode) {
		this.scheduleCode = scheduleCode;
	}
	public PriceType getProgrammeType() {
		return programmeType;
	}
	public void setProgrammeType(PriceType programmeType) {
		this.programmeType = programmeType;
	}
	public Integer getFullUnitNumber() {
		return fullUnitNumber;
	}
	public void setFullUnitNumber(Integer fullUnitNumber) {
		this.fullUnitNumber = fullUnitNumber;
	}
	public Integer getHalfUnitNumber() {
		return halfUnitNumber;
	}
	public void setHalfUnitNumber(Integer halfUnitNumber) {
		this.halfUnitNumber = halfUnitNumber;
	}
	public Integer getLawUnitNumber() {
		return lawUnitNumber;
	}
	public void setLawUnitNumber(Integer lawUnitNumber) {
		this.lawUnitNumber = lawUnitNumber;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public List<String> getPriceSchemeCode() {
		return priceSchemeCode;
	}
	public void setPriceSchemeCode(List<String> priceSchemeCode) {
		this.priceSchemeCode = priceSchemeCode;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getPromoCode() {
		return promoCode;
	}
	public void setPromoCode(String promoCode) {
		this.promoCode = promoCode;
	}
	public List<SubjectDto> getSubjects() {
		return subjects;
	}
	public void setSubjects(List<SubjectDto> subjects) {
		this.subjects = subjects;
	}
	public List<String> getPriceSubTypes() {
		return priceSubTypes;
	}
	public void setPriceSubTypes(List<String> priceSubTypes) {
		this.priceSubTypes = priceSubTypes;
	}
	public String getBaseCurrency() {
		return baseCurrency;
	}
	public void setBaseCurrency(String baseCurrency) {
		this.baseCurrency = baseCurrency;
	}
	public String getBaseCurrencyCode() {
		return baseCurrencyCode;
	}
	public void setBaseCurrencyCode(String baseCurrencyCode) {
		this.baseCurrencyCode = baseCurrencyCode;
	}
	public PriceCategory getPriceCategory() {
		return priceCategory;
	}
	public void setPriceCategory(PriceCategory priceCategory) {
		this.priceCategory = priceCategory;
	}
	public Set<String> getSubjectTypes() {
		return subjectTypes;
	}
	public void setSubjectTypes(Set<String> subjectTypes) {
		this.subjectTypes = subjectTypes;
	}
	public Map<String, Integer> getSubjectTypeIntegerMap() {
		return subjectTypeIntegerMap;
	}
	public void setSubjectTypeIntegerMap(Map<String, Integer> subjectTypeIntegerMap) {
		this.subjectTypeIntegerMap = subjectTypeIntegerMap;
	}
	public Map<String, List<Long>> getTransactionFeeMap() {
		return transactionFeeMap;
	}
	public void setTransactionFeeMap(Map<String, List<Long>> transactionFeeMap) {
		this.transactionFeeMap = transactionFeeMap;
	}
	public String getPurposeForExchangeRate() {
		return purposeForExchangeRate;
	}
	public void setPurposeForExchangeRate(String purposeForExchangeRate) {
		this.purposeForExchangeRate = purposeForExchangeRate;
	}

}
