package com.sambaash.platform.pe.jaxb;

import com.liferay.portal.kernel.util.Validator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlElement;
public class PEOutcomeList {

	private List<PEOutcome> list;
	private Map<Long, PEOutcome> map;

	public List<PEOutcome> getList() {

		if (list == null) {
			list = new ArrayList<PEOutcome>();
		}

		return list;
	}

	public PEOutcome getOutcome(long ruleId) {
		Map<Long, PEOutcome> map = getMap();
		if(map.isEmpty()){
			prepareMap();
		}
		return map.get(ruleId);
	}

	@XmlElement(name ="outcome")
	public void setList(List<PEOutcome> list) {
		this.list = list;

		prepareMap();
	}

	private void prepareMap() {
		List<PEOutcome>list = getList();
		Map<Long, PEOutcome> map = getMap();

		for (PEOutcome outcome : list) {
			map.put(outcome.getRuleId(), outcome);
		}
	}

	private Map<Long, PEOutcome> getMap() {
		if (Validator.isNull(map)) {
			map = new HashMap<Long, PEOutcome>();
		}

		return map;
	}
}