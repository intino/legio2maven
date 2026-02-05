//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package io.intino.legio.model;

import io.intino.magritte.framework.Layer;
import io.intino.magritte.framework.Node;
import io.intino.magritte.framework.loaders.StringLoader;
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

public class RunConfiguration extends Layer implements Terminal {
	protected String mainClass;
	protected String vmOptions;
	protected List<Argument> argumentList = new ArrayList();

	public RunConfiguration(Node node) {
		super(node);
	}

	public String mainClass() {
		return this.mainClass;
	}

	public String vmOptions() {
		return this.vmOptions;
	}

	public RunConfiguration mainClass(String value) {
		this.mainClass = value;
		return this;
	}

	public RunConfiguration vmOptions(String value) {
		this.vmOptions = value;
		return this;
	}

	public List<Argument> argumentList() {
		return Collections.unmodifiableList(this.argumentList);
	}

	public Argument argument(int index) {
		return this.argumentList.get(index);
	}

	public List<Argument> argumentList(Predicate<Argument> predicate) {
		return (List) this.argumentList().stream().filter(predicate).collect(Collectors.toList());
	}

	public Argument argument(Predicate<Argument> predicate) {
		return this.argumentList().stream().filter(predicate).findFirst().orElse(null);
	}

	protected java.util.List<io.intino.magritte.framework.Node> componentList$() {
		java.util.Set<io.intino.magritte.framework.Node> components = new java.util.LinkedHashSet<>(super.componentList$());
		new java.util.ArrayList<>(argumentList).forEach(c -> components.add(c.core$()));
		return new java.util.ArrayList<>(components);
	}


	protected Map<String, List<?>> variables$() {
		Map<String, List<?>> map = new LinkedHashMap();
		map.put("mainClass", new ArrayList(Collections.singletonList(this.mainClass)));
		map.put("vmOptions", new ArrayList(Collections.singletonList(this.vmOptions)));
		return map;
	}

	protected void addNode$(Node node) {
		super.addNode$(node);
		if (node.is("Argument")) {
			this.argumentList.add((Argument) node.as(Argument.class));
		}

	}

	protected void removeNode$(Node node) {
		super.removeNode$(node);
		if (node.is("Argument")) {
			this.argumentList.remove(node.as(Argument.class));
		}

	}

	protected void load$(String name, List<?> values) {
		super.load$(name, values);
		if (name.equalsIgnoreCase("mainClass")) {
			this.mainClass = (String) StringLoader.load(values, this).get(0);
		} else if (name.equalsIgnoreCase("vmOptions")) {
			this.vmOptions = (String) StringLoader.load(values, this).get(0);
		}

	}

	protected void set$(String name, List<?> values) {
		super.set$(name, values);
		if (name.equalsIgnoreCase("mainClass")) {
			this.mainClass = (String) values.get(0);
		} else if (name.equalsIgnoreCase("vmOptions")) {
			this.vmOptions = (String) values.get(0);
		}

	}

	public Create create() {
		return new Create((String) null);
	}

	public Create create(String name) {
		return new Create(name);
	}

	public Clear clear() {
		return new Clear();
	}

	public LegioGraph graph() {
		return (LegioGraph) this.core$().graph().as(LegioGraph.class);
	}

	public class Create {
		protected final String name;

		public Create(String name) {
			this.name = name;
		}

		public Argument argument(String name, String value) {
			Argument newElement = (Argument) RunConfiguration.this.core$().graph().concept(Argument.class).createNode(this.name, RunConfiguration.this.core$()).as(Argument.class);
			newElement.core$().set(newElement, "name", Collections.singletonList(name));
			newElement.core$().set(newElement, "value", Collections.singletonList(value));
			return newElement;
		}
	}

	public class Clear {
		public void argument(java.util.function.Predicate<Argument> filter) {
			new java.util.ArrayList<>(argumentList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
		}
	}
}
