package io.intino.legio.model;

public class Server  extends io.intino.magritte.framework.Layer implements io.intino.magritte.framework.tags.Terminal {
	protected Type type;

	public enum Type {
		Dev, Pre, Pro, Demo;
	}

	public Server(io.intino.magritte.framework.Node node) {
		super(node);
	}

	public Type type() {
		return type;
	}

	public Server type(Type value) {
		this.type = value;
		return (Server) this;
	}

	@Override
	protected java.util.Map<String, java.util.List<?>> variables$() {
		java.util.Map<String, java.util.List<?>> map = new java.util.LinkedHashMap<>();
		map.put("type", new java.util.ArrayList(java.util.Collections.singletonList(this.type)));
		return map;
	}

	@Override
	protected void load$(String name, java.util.List<?> values) {
		super.load$(name, values);
		if (name.equalsIgnoreCase("type")) this.type = io.intino.magritte.framework.loaders.WordLoader.load(values, Type.class, this).get(0);
	}

	@Override
	protected void set$(String name, java.util.List<?> values) {
		super.set$(name, values);
		if (name.equalsIgnoreCase("type")) this.type = (Type) values.get(0);
	}

	public io.intino.legio.model.LegioGraph graph() {
		return (io.intino.legio.model.LegioGraph) core$().graph().as(io.intino.legio.model.LegioGraph.class);
	}
}