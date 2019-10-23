package com.sambaash.platform.portlet.spblogs.wrapper;

import java.util.List;
public class AllChannelWrapper {
	
	private long vocabularyId;

	private String vocabularyName;
	
	private List<ChannelWrapper> channelWrappers;

	public long getVocabularyId() {
		return vocabularyId;
	}

	public void setVocabularyId(long vocabularyId) {
		this.vocabularyId = vocabularyId;
	}

	public String getVocabularyName() {
		return vocabularyName;
	}

	public void setVocabularyName(String vocabularyName) {
		this.vocabularyName = vocabularyName;
	}

	public List<ChannelWrapper> getChannelWrappers() {
		return channelWrappers;
	}

	public void setChannelWrappers(List<ChannelWrapper> channelWrappers) {
		this.channelWrappers = channelWrappers;
	}
	
}
