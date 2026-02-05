
package io.intino.legio.model;

import io.intino.magritte.framework.Layer;
import io.intino.magritte.framework.Node;
import io.intino.magritte.framework.loaders.StringLoader;
import io.intino.magritte.framework.loaders.WordLoader;
import io.intino.magritte.framework.tags.Terminal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Repository extends Layer implements Terminal {
	protected String identifier;
	protected List<Type> typeList = new ArrayList<>();
	protected Release release;
	protected Snapshot snapshot;

	public Repository(Node node) {
		super(node);
	}

	public String identifier() {
		return this.identifier;
	}

	public Repository identifier(String value) {
		this.identifier = value;
		return this;
	}

	public List<Type> typeList() {
		return Collections.unmodifiableList(this.typeList);
	}

	public Type type(int index) {
		return (Type)this.typeList.get(index);
	}

	public List<Type> typeList(Predicate<Type> predicate) {
		return (List)this.typeList().stream().filter(predicate).collect(Collectors.toList());
	}

	public Type type(Predicate<Type> predicate) {
		return this.typeList().stream().filter(predicate).findFirst().orElse(null);
	}

	public Release release() {
		return this.release;
	}

	public Snapshot snapshot() {
		return this.snapshot;
	}

	protected List<Node> componentList$() {
		Set<Node> components = new LinkedHashSet(super.componentList$());
		(new ArrayList<>(this.typeList)).forEach((c) -> components.add(c.core$()));
		if (this.release != null) {
			components.add(this.release.core$());
		}

		if (this.snapshot != null) {
			components.add(this.snapshot.core$());
		}

		return new ArrayList<>(components);
	}

	protected Map<String, List<?>> variables$() {
		Map<String, List<?>> map = new LinkedHashMap();
		map.put("identifier", new ArrayList<>(Collections.singletonList(this.identifier)));
		return map;
	}

	protected void addNode$(Node node) {
		super.addNode$(node);
		if (node.is("Repository$Type")) {
			this.typeList.add((Type)node.as(Type.class));
		}

		if (node.is("Repository$Release")) {
			this.release = (Release)node.as(Release.class);
		}

		if (node.is("Repository$Snapshot")) {
			this.snapshot = (Snapshot)node.as(Snapshot.class);
		}

	}

	protected void removeNode$(Node node) {
		super.removeNode$(node);
		if (node.is("Repository$Type")) {
			this.typeList.remove(node.as(Type.class));
		}

		if (node.is("Repository$Release")) {
			this.release = null;
		}

		if (node.is("Repository$Snapshot")) {
			this.snapshot = null;
		}

	}

	protected void load$(String name, List<?> values) {
		super.load$(name, values);
		if (name.equalsIgnoreCase("identifier")) {
			this.identifier = (String)StringLoader.load(values, this).get(0);
		}

	}

	protected void set$(String name, List<?> values) {
		super.set$(name, values);
		if (name.equalsIgnoreCase("identifier")) {
			this.identifier = (String)values.get(0);
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

		public Release release(String url) {
			Release newElement = (Release)Repository.this.core$().graph().concept(Release.class).createNode(this.name, Repository.this.core$()).as(Release.class);
			newElement.core$().set(newElement, "url", Collections.singletonList(url));
			return newElement;
		}

		public Snapshot snapshot(String url) {
			Snapshot newElement = (Snapshot)Repository.this.core$().graph().concept(Snapshot.class).createNode(this.name, Repository.this.core$()).as(Snapshot.class);
			newElement.core$().set(newElement, "url", Collections.singletonList(url));
			return newElement;
		}
	}

	public abstract static class Type extends Layer implements Terminal {
		protected String url;
		protected UpdatePolicy updatePolicy;

		public Type(Node node) {
			super(node);
		}

		public String url() {
			return this.url;
		}

		public UpdatePolicy updatePolicy() {
			return this.updatePolicy;
		}

		public Type url(String value) {
			this.url = value;
			return this;
		}

		public Type updatePolicy(UpdatePolicy value) {
			this.updatePolicy = value;
			return this;
		}

		protected Map<String, List<?>> variables$() {
			Map<String, List<?>> map = new LinkedHashMap();
			map.put("url", new ArrayList<>(Collections.singletonList(this.url)));
			map.put("updatePolicy", new ArrayList<>(Collections.singletonList(this.updatePolicy)));
			return map;
		}

		protected void load$(String name, List<?> values) {
			super.load$(name, values);
			if (name.equalsIgnoreCase("url")) {
				this.url = (String)StringLoader.load(values, this).get(0);
			} else if (name.equalsIgnoreCase("updatePolicy")) {
				this.updatePolicy = (UpdatePolicy)WordLoader.load(values, UpdatePolicy.class, this).get(0);
			}

		}

		protected void set$(String name, List<?> values) {
			super.set$(name, values);
			if (name.equalsIgnoreCase("url")) {
				this.url = (String)values.get(0);
			} else if (name.equalsIgnoreCase("updatePolicy")) {
				this.updatePolicy = (UpdatePolicy)values.get(0);
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

		public static enum UpdatePolicy {
			Always,
			Daily,
			Never;
		}

		public class Create {
			protected final String name;

			public Create(String name) {
				this.name = name;
			}
		}
	}

	public static class Release extends Type implements Terminal {
		protected UpdatePolicy updatePolicy;

		public Release(Node node) {
			super(node);
		}

		protected Map<String, List<?>> variables$() {
			Map<String, List<?>> map = new LinkedHashMap(super.variables$());
			return map;
		}

		protected void load$(String name, List<?> values) {
			super.load$(name, values);
		}

		protected void set$(String name, List<?> values) {
			super.set$(name, values);
		}

		public LegioGraph graph() {
			return (LegioGraph)this.core$().graph().as(LegioGraph.class);
		}

		public static enum UpdatePolicy {
			Always,
			Daily,
			Never;
		}
	}

	public static class Snapshot extends Type implements Terminal {
		protected UpdatePolicy updatePolicy;

		public Snapshot(Node node) {
			super(node);
		}

		protected Map<String, List<?>> variables$() {
			Map<String, List<?>> map = new LinkedHashMap(super.variables$());
			return map;
		}

		protected void load$(String name, List<?> values) {
			super.load$(name, values);
		}

		protected void set$(String name, List<?> values) {
			super.set$(name, values);
		}

		public LegioGraph graph() {
			return (LegioGraph)this.core$().graph().as(LegioGraph.class);
		}

		public static enum UpdatePolicy {
			Always,
			Daily,
			Never;
		}
	}
}
