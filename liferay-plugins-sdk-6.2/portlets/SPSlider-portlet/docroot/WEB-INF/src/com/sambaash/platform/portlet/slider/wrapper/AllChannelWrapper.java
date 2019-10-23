package com.sambaash.platform.portlet.slider.wrapper;

import java.util.List;
public class AllChannelWrapper {

	public List<ChannelWrapper> getChannelWrappers() {
		return channelWrappers;
	}

	public long getVocabularyId() {
		return vocabularyId;
	}

	public String getVocabularyName() {
		return vocabularyName;
	}

	public void setChannelWrappers(List<ChannelWrapper> channelWrappers) {
		this.channelWrappers = channelWrappers;
	}

	public void setVocabularyId(long vocabularyId) {
		this.vocabularyId = vocabularyId;
	}

	public void setVocabularyName(String vocabularyName) {
		this.vocabularyName = vocabularyName;
	}

	private List<ChannelWrapper> channelWrappers;
	private long vocabularyId;
	private String vocabularyName;

}