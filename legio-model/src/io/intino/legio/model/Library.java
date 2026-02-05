package io.intino.legio.model;

import io.intino.magritte.framework.Layer;
import io.intino.magritte.framework.Node;
import io.intino.magritte.framework.loaders.StringLoader;
import io.intino.magritte.framework.tags.Terminal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public abstract class Library extends Layer implements Terminal {
	protected String groupId;
	protected String artifactId;
	protected String version;

	public Library(Node node) {
		super(node);
	}

	public String groupId() {
		return this.groupId;
	}

	public String artifactId() {
		return this.artifactId;
	}

	public String version() {
		return this.version;
	}

	public Library groupId(String value) {
		this.groupId = value;
		return this;
	}

	public Library artifactId(String value) {
		this.artifactId = value;
		return this;
	}

	public Library version(String value) {
		this.version = value;
		return this;
	}

	protected Map<String, List<?>> variables$() {
		Map<String, List<?>> map = new LinkedHashMap();
		map.put("groupId", new ArrayList(Collections.singletonList(this.groupId)));
		map.put("artifactId", new ArrayList(Collections.singletonList(this.artifactId)));
		map.put("version", new ArrayList(Collections.singletonList(this.version)));
		return map;
	}

	protected void load$(String name, List<?> values) {
		super.load$(name, values);
		if (name.equalsIgnoreCase("groupId")) {
			this.groupId = (String)StringLoader.load(values, this).get(0);
		} else if (name.equalsIgnoreCase("artifactId")) {
			this.artifactId = (String)StringLoader.load(values, this).get(0);
		} else if (name.equalsIgnoreCase("version")) {
			this.version = (String)StringLoader.load(values, this).get(0);
		}

	}

	protected void set$(String name, List<?> values) {
		super.set$(name, values);
		if (name.equalsIgnoreCase("groupId")) {
			this.groupId = (String)values.get(0);
		} else if (name.equalsIgnoreCase("artifactId")) {
			this.artifactId = (String)values.get(0);
		} else if (name.equalsIgnoreCase("version")) {
			this.version = (String)values.get(0);
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
}
