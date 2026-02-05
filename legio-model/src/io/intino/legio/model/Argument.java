package io.intino.legio.model;

public class Argument  extends io.intino.magritte.framework.Layer implements io.intino.magritte.framework.tags.Component, io.intino.magritte.framework.tags.Terminal {
	protected String name;
	protected String value;

	public Argument(io.intino.magritte.framework.Node node) {
		super(node);
	}

	public String name() {
		return name;
	}

	public String value() {
		return value;
	}

	public Argument name(String value) {
		this.name = value;
		return (Argument) this;
	}

	public Argument value(String value) {
		this.value = value;
		return (Argument) this;
	}

	@Override
	protected java.util.Map<String, java.util.List<?>> variables$() {
		java.util.Map<String, java.util.List<?>> map = new java.util.LinkedHashMap<>();
		map.put("name", new java.util.ArrayList(java.util.Collections.singletonList(this.name)));
		map.put("value", new java.util.ArrayList(java.util.Collections.singletonList(this.value)));
		return map;
	}

	@Override
	protected void load$(String name, java.util.List<?> values) {
		super.load$(name, values);
		if (name.equalsIgnoreCase("name")) this.name = io.intino.magritte.framework.loaders.StringLoader.load(values, this).get(0);
		else if (name.equalsIgnoreCase("value")) this.value = io.intino.magritte.framework.loaders.StringLoader.load(values, this).get(0);
	}

	@Override
	protected void set$(String name, java.util.List<?> values) {
		super.set$(name, values);
		if (name.equalsIgnoreCase("name")) this.name = (String) values.get(0);
		else if (name.equalsIgnoreCase("value")) this.value = (String) values.get(0);
	}

	public io.intino.legio.model.LegioGraph graph() {
		return (io.intino.legio.model.LegioGraph) core$().graph().as(io.intino.legio.model.LegioGraph.class);
	}
}