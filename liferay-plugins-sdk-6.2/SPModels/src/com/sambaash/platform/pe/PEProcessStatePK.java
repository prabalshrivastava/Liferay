package com.sambaash.platform.pe;


public class PEProcessStatePK {

	private long userIdProcess;
	private long classNameId;
	private long classPK;
	private long processId;
	
	public PEProcessStatePK(long userId, long classNameId, long classPK, long pdId){
		this.userIdProcess = userId;
		this.classNameId = classNameId;
		this.classPK = classPK;
		this.processId = pdId;
	}
	
	public long getClassNameId() {
		return classNameId;
	}
	public void setClassNameId(long classNameId) {
		this.classNameId = classNameId;
	}
	public long getClassPK() {
		return classPK;
	}
	public void setClassPK(long classPK) {
		this.classPK = classPK;
	}
	public long getProcessId() {
		return processId;
	}
	public void setProcessId(long pdId) {
		this.processId = pdId;
	}

	public long getUserIdProcess() {
		return userIdProcess;
	}

	public void setUserIdProcess(long userIdProcess) {
		this.userIdProcess = userIdProcess;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PEProcessStatePK [userIdProcess=");
		builder.append(userIdProcess);
		builder.append(", classNameId=");
		builder.append(classNameId);
		builder.append(", classPK=");
		builder.append(classPK);
		builder.append(", processId=");
		builder.append(processId);
		builder.append("]");
		return builder.toString();
	}
}
