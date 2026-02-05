
package io.intino.legio.model;

import io.intino.magritte.framework.Layer;
import io.intino.magritte.framework.Node;
import io.intino.magritte.framework.loaders.StringLoader;
import io.intino.magritte.framework.tags.Component;
import io.intino.magritte.framework.tags.Terminal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Parameter extends Layer implements Component, Terminal {
	protected String name;
	protected String defaultValue;
	protected String description;
	protected ArchetypeRoot _archetypeRoot;

	public Parameter(Node node) {
		super(node);
	}

	public String name() {
		return this.name;
	}

	public String defaultValue() {
		return this.defaultValue;
	}

	public String description() {
		return this.description;
	}

	public Parameter name(String value) {
		this.name = value;
		return this;
	}

	public Parameter defaultValue(String value) {
		this.defaultValue = value;
		return this;
	}

	public Parameter description(String value) {
		this.description = value;
		return this;
	}

	public ArchetypeRoot asArchetypeRoot() {
		Layer as = this.a$(ArchetypeRoot.class);
		return as != null ? (ArchetypeRoot)as : (ArchetypeRoot)this.core$().addAspect(ArchetypeRoot.class);
	}

	public boolean isArchetypeRoot() {
		return this.core$().is(ArchetypeRoot.class);
	}

	public void removeArchetypeRoot() {
		this.core$().removeAspect(ArchetypeRoot.class);
	}

	protected Map<String, List<?>> variables$() {
		Map<String, List<?>> map = new LinkedHashMap();
		map.put("name", new ArrayList(Collections.singletonList(this.name)));
		map.put("defaultValue", new ArrayList(Collections.singletonList(this.defaultValue)));
		map.put("description", new ArrayList(Collections.singletonList(this.description)));
		return map;
	}

	protected void load$(String name, List<?> values) {
		super.load$(name, values);
		if (name.equalsIgnoreCase("name")) {
			this.name = (String)StringLoader.load(values, this).get(0);
		} else if (name.equalsIgnoreCase("defaultValue")) {
			this.defaultValue = (String)StringLoader.load(values, this).get(0);
		} else if (name.equalsIgnoreCase("description")) {
			this.description = (String)StringLoader.load(values, this).get(0);
		}

	}

	protected void set$(String name, List<?> values) {
		super.set$(name, values);
		if (name.equalsIgnoreCase("name")) {
			this.name = (String)values.get(0);
		} else if (name.equalsIgnoreCase("defaultValue")) {
			this.defaultValue = (String)values.get(0);
		} else if (name.equalsIgnoreCase("description")) {
			this.description = (String)values.get(0);
		}

	}

	public Create create() {
		return new Create((String)null);
	}

	public Create create(String name) {
		return new Create(name);
	}

	public LegioGraph graph() {
		return (LegioGraph)this.core$().graph().as(LegioGraph.class);
	}

	public class Create {
		protected final String name;

		public Create(String name) {
			this.name = name;
		}
	}

	public static class ArchetypeRoot extends Layer implements Terminal {
		protected Parameter _parameter;

		public ArchetypeRoot(Node node) {
			super(node);
		}

		public String name() {
			return this._parameter.name();
		}

		public String defaultValue() {
			return this._parameter.defaultValue();
		}

		public String description() {
			return this._parameter.description();
		}

		public ArchetypeRoot name(String value) {
			this._parameter.name(value);
			return this;
		}

		public ArchetypeRoot defaultValue(String value) {
			this._parameter.defaultValue(value);
			return this;
		}

		public ArchetypeRoot description(String value) {
			this._parameter.description(value);
			return this;
		}

		public Parameter asParameter() {
			return (Parameter)this.a$(Parameter.class);
		}

		protected Map<String, List<?>> variables$() {
			Map<String, List<?>> map = new LinkedHashMap();
			return map;
		}

		protected void load$(String name, List<?> values) {
			super.load$(name, values);
		}

		protected void set$(String name, List<?> values) {
			super.set$(name, values);
		}

		protected void sync$(Layer layer) {
			super.sync$(layer);
			if (layer instanceof Parameter) {
				this._parameter = (Parameter)layer;
			}

		}

		public LegioGraph graph() {
			return (LegioGraph)this.core$().graph().as(LegioGraph.class);
		}
	}
}