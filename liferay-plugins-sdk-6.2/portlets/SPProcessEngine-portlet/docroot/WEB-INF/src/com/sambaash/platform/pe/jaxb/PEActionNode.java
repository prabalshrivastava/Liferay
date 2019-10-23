package com.sambaash.platform.pe.jaxb;

public abstract class PEActionNode extends SingleOutputNodeImpl {

	

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ActionNode [");

		if (config != null) {
			builder.append("config=");
			builder.append(config);
			builder.append(", ");
		}
		if (super.toString() != null) {
			builder.append("toString()=");
			builder.append(super.toString());
		}

		builder.append("]");
		return builder.toString();
	}

	private PEActionConfig config;

}