package io.intino.legio.model;

import io.intino.magritte.framework.Layer;
import io.intino.magritte.framework.Node;
import io.intino.magritte.framework.loaders.BooleanLoader;
import io.intino.magritte.framework.loaders.DoubleLoader;
import io.intino.magritte.framework.loaders.IntegerLoader;
import io.intino.magritte.framework.loaders.NodeLoader;
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

public class Artifact extends Layer implements Terminal {
	protected String groupId;
	protected String version;
	protected String description;
	protected License license;
	protected List<Dsl> dslList = new ArrayList();
	protected Model model;
	protected Box box;
	protected DataHub dataHub;
	protected Archetype archetype;
	protected Imports imports;
	protected WebImports webImports;
	protected Code code;
	protected List<IntinoPlugin> intinoPluginList = new ArrayList();
	protected Package package$;
	protected List<Parameter> parameterList = new ArrayList();
	protected Distribution distribution;
	protected QualityAnalytics qualityAnalytics;
	protected List<Deployment> deploymentList = new ArrayList();

	public Artifact(Node node) {
		super(node);
	}

	public String groupId() {
		return this.groupId;
	}

	public String version() {
		return this.version;
	}

	public String description() {
		return this.description;
	}

	public Artifact groupId(String value) {
		this.groupId = value;
		return this;
	}

	public Artifact version(String value) {
		this.version = value;
		return this;
	}

	public Artifact description(String value) {
		this.description = value;
		return this;
	}

	public License license() {
		return this.license;
	}

	public List<Dsl> dslList() {
		return Collections.unmodifiableList(this.dslList);
	}

	public Dsl dsl(int index) {
		return (Dsl) this.dslList.get(index);
	}

	public List<Dsl> dslList(Predicate<Dsl> predicate) {
		return (List) this.dslList().stream().filter(predicate).collect(Collectors.toList());
	}

	public Dsl dsl(Predicate<Dsl> predicate) {
		return (Dsl) this.dslList().stream().filter(predicate).findFirst().orElse(null);
	}

	public Model model() {
		return this.model;
	}

	public Box box() {
		return this.box;
	}

	public DataHub dataHub() {
		return this.dataHub;
	}

	public Archetype archetype() {
		return this.archetype;
	}

	public Imports imports() {
		return this.imports;
	}

	public WebImports webImports() {
		return this.webImports;
	}

	public Code code() {
		return this.code;
	}

	public List<IntinoPlugin> intinoPluginList() {
		return Collections.unmodifiableList(this.intinoPluginList);
	}

	public IntinoPlugin intinoPlugin(int index) {
		return (IntinoPlugin) this.intinoPluginList.get(index);
	}

	public List<IntinoPlugin> intinoPluginList(Predicate<IntinoPlugin> predicate) {
		return (List) this.intinoPluginList().stream().filter(predicate).collect(Collectors.toList());
	}

	public IntinoPlugin intinoPlugin(Predicate<IntinoPlugin> predicate) {
		return (IntinoPlugin) this.intinoPluginList().stream().filter(predicate).findFirst().orElse(null);
	}

	public Package package$() {
		return this.package$;
	}

	public List<Parameter> parameterList() {
		return Collections.unmodifiableList(this.parameterList);
	}

	public Parameter parameter(int index) {
		return (Parameter) this.parameterList.get(index);
	}

	public List<Parameter> parameterList(Predicate<Parameter> predicate) {
		return (List) this.parameterList().stream().filter(predicate).collect(Collectors.toList());
	}

	public Parameter parameter(Predicate<Parameter> predicate) {
		return (Parameter) this.parameterList().stream().filter(predicate).findFirst().orElse(null);
	}

	public Distribution distribution() {
		return this.distribution;
	}

	public QualityAnalytics qualityAnalytics() {
		return this.qualityAnalytics;
	}

	public List<Deployment> deploymentList() {
		return Collections.unmodifiableList(this.deploymentList);
	}

	public Deployment deployment(int index) {
		return (Deployment) this.deploymentList.get(index);
	}

	public List<Deployment> deploymentList(Predicate<Deployment> predicate) {
		return (List) this.deploymentList().stream().filter(predicate).collect(Collectors.toList());
	}

	public Deployment deployment(Predicate<Deployment> predicate) {
		return (Deployment) this.deploymentList().stream().filter(predicate).findFirst().orElse(null);
	}

	protected List<Node> componentList$() {
		Set<Node> components = new LinkedHashSet(super.componentList$());
		if (this.license != null) {
			components.add(this.license.core$());
		}
		new java.util.ArrayList<>(dslList).forEach(c -> components.add(c.core$()));
		if (this.model != null) {
			components.add(this.model.core$());
		}

		if (this.box != null) {
			components.add(this.box.core$());
		}

		if (this.dataHub != null) {
			components.add(this.dataHub.core$());
		}

		if (this.archetype != null) {
			components.add(this.archetype.core$());
		}

		if (this.imports != null) {
			components.add(this.imports.core$());
		}

		if (this.webImports != null) {
			components.add(this.webImports.core$());
		}

		if (this.code != null) {
			components.add(this.code.core$());
		}

		(new ArrayList<>(this.intinoPluginList)).forEach((c) -> components.add(c.core$()));
		if (this.package$ != null) {
			components.add(this.package$.core$());
		}

		(new ArrayList<>(this.parameterList)).forEach((c) -> components.add(c.core$()));
		if (this.distribution != null) {
			components.add(this.distribution.core$());
		}

		if (this.qualityAnalytics != null) {
			components.add(this.qualityAnalytics.core$());
		}

		(new ArrayList<>(this.deploymentList)).forEach((c) -> components.add(c.core$()));
		return new ArrayList(components);
	}

	protected Map<String, List<?>> variables$() {
		Map<String, List<?>> map = new LinkedHashMap();
		map.put("groupId", new ArrayList(Collections.singletonList(this.groupId)));
		map.put("version", new ArrayList(Collections.singletonList(this.version)));
		map.put("description", new ArrayList(Collections.singletonList(this.description)));
		return map;
	}

	protected void addNode$(Node node) {
		super.addNode$(node);
		if (node.is("Artifact$License")) {
			this.license = (License) node.as(License.class);
		}

		if (node.is("Artifact$Dsl")) {
			this.dslList.add((Dsl) node.as(Dsl.class));
		}

		if (node.is("Artifact$Model")) {
			this.model = (Model) node.as(Model.class);
		}

		if (node.is("Artifact$Box")) {
			this.box = (Box) node.as(Box.class);
		}

		if (node.is("Artifact$DataHub")) {
			this.dataHub = (DataHub) node.as(DataHub.class);
		}

		if (node.is("Artifact$Archetype")) {
			this.archetype = (Archetype) node.as(Archetype.class);
		}

		if (node.is("Artifact$Imports")) {
			this.imports = (Imports) node.as(Imports.class);
		}

		if (node.is("Artifact$WebImports")) {
			this.webImports = (WebImports) node.as(WebImports.class);
		}

		if (node.is("Artifact$Code")) {
			this.code = (Code) node.as(Code.class);
		}

		if (node.is("Artifact$IntinoPlugin")) {
			this.intinoPluginList.add((IntinoPlugin) node.as(IntinoPlugin.class));
		}

		if (node.is("Artifact$Package")) {
			this.package$ = (Package) node.as(Package.class);
		}

		if (node.is("Parameter")) {
			this.parameterList.add((Parameter) node.as(Parameter.class));
		}

		if (node.is("Artifact$Distribution")) {
			this.distribution = (Distribution) node.as(Distribution.class);
		}

		if (node.is("Artifact$QualityAnalytics")) {
			this.qualityAnalytics = (QualityAnalytics) node.as(QualityAnalytics.class);
		}

		if (node.is("Artifact$Deployment")) {
			this.deploymentList.add((Deployment) node.as(Deployment.class));
		}

	}

	protected void removeNode$(Node node) {
		super.removeNode$(node);
		if (node.is("Artifact$License")) {
			this.license = null;
		}

		if (node.is("Artifact$Dsl")) {
			this.dslList.remove(node.as(Dsl.class));
		}

		if (node.is("Artifact$Model")) {
			this.model = null;
		}

		if (node.is("Artifact$Box")) {
			this.box = null;
		}

		if (node.is("Artifact$DataHub")) {
			this.dataHub = null;
		}

		if (node.is("Artifact$Archetype")) {
			this.archetype = null;
		}

		if (node.is("Artifact$Imports")) {
			this.imports = null;
		}

		if (node.is("Artifact$WebImports")) {
			this.webImports = null;
		}

		if (node.is("Artifact$Code")) {
			this.code = null;
		}

		if (node.is("Artifact$IntinoPlugin")) {
			this.intinoPluginList.remove(node.as(IntinoPlugin.class));
		}

		if (node.is("Artifact$Package")) {
			this.package$ = null;
		}

		if (node.is("Parameter")) {
			this.parameterList.remove(node.as(Parameter.class));
		}

		if (node.is("Artifact$Distribution")) {
			this.distribution = null;
		}

		if (node.is("Artifact$QualityAnalytics")) {
			this.qualityAnalytics = null;
		}

		if (node.is("Artifact$Deployment")) {
			this.deploymentList.remove(node.as(Deployment.class));
		}

	}

	protected void load$(String name, List<?> values) {
		super.load$(name, values);
		if (name.equalsIgnoreCase("groupId")) {
			this.groupId = (String) StringLoader.load(values, this).get(0);
		} else if (name.equalsIgnoreCase("version")) {
			this.version = (String) StringLoader.load(values, this).get(0);
		} else if (name.equalsIgnoreCase("description")) {
			this.description = (String) StringLoader.load(values, this).get(0);
		}

	}

	protected void set$(String name, List<?> values) {
		super.set$(name, values);
		if (name.equalsIgnoreCase("groupId")) {
			this.groupId = (String) values.get(0);
		} else if (name.equalsIgnoreCase("version")) {
			this.version = (String) values.get(0);
		} else if (name.equalsIgnoreCase("description")) {
			this.description = (String) values.get(0);
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

		public License license(License.Type type) {
			License newElement = (License) Artifact.this.core$().graph().concept(License.class).createNode(this.name, Artifact.this.core$()).as(License.class);
			newElement.core$().set(newElement, "type", Collections.singletonList(type));
			return newElement;
		}

		public Dsl dsl(String name, String version) {
			Dsl newElement = (Dsl) Artifact.this.core$().graph().concept(Dsl.class).createNode(this.name, Artifact.this.core$()).as(Dsl.class);
			newElement.core$().set(newElement, "name", Collections.singletonList(name));
			newElement.core$().set(newElement, "version", Collections.singletonList(version));
			return newElement;
		}

		public Model model(String language, String version, String sdkVersion) {
			Model newElement = (Model) Artifact.this.core$().graph().concept(Model.class).createNode(this.name, Artifact.this.core$()).as(Model.class);
			newElement.core$().set(newElement, "language", Collections.singletonList(language));
			newElement.core$().set(newElement, "version", Collections.singletonList(version));
			newElement.core$().set(newElement, "sdkVersion", Collections.singletonList(sdkVersion));
			return newElement;
		}

		public Box box(String language, String version) {
			Box newElement = (Box) Artifact.this.core$().graph().concept(Box.class).createNode(this.name, Artifact.this.core$()).as(Box.class);
			newElement.core$().set(newElement, "language", Collections.singletonList(language));
			newElement.core$().set(newElement, "version", Collections.singletonList(version));
			return newElement;
		}

		public DataHub dataHub(String groupId, String artifactId, String version) {
			DataHub newElement = (DataHub) Artifact.this.core$().graph().concept(DataHub.class).createNode(this.name, Artifact.this.core$()).as(DataHub.class);
			newElement.core$().set(newElement, "groupId", Collections.singletonList(groupId));
			newElement.core$().set(newElement, "artifactId", Collections.singletonList(artifactId));
			newElement.core$().set(newElement, "version", Collections.singletonList(version));
			return newElement;
		}

		public Archetype archetype(String groupId, String artifactId, String version) {
			Archetype newElement = (Archetype) Artifact.this.core$().graph().concept(Archetype.class).createNode(this.name, Artifact.this.core$()).as(Archetype.class);
			newElement.core$().set(newElement, "groupId", Collections.singletonList(groupId));
			newElement.core$().set(newElement, "artifactId", Collections.singletonList(artifactId));
			newElement.core$().set(newElement, "version", Collections.singletonList(version));
			return newElement;
		}

		public Imports imports() {
			Imports newElement = (Imports) Artifact.this.core$().graph().concept(Imports.class).createNode(this.name, Artifact.this.core$()).as(Imports.class);
			return newElement;
		}

		public WebImports webImports() {
			WebImports newElement = (WebImports) Artifact.this.core$().graph().concept(WebImports.class).createNode(this.name, Artifact.this.core$()).as(WebImports.class);
			return newElement;
		}

		public Code code() {
			Code newElement = (Code) Artifact.this.core$().graph().concept(Code.class).createNode(this.name, Artifact.this.core$()).as(Code.class);
			return newElement;
		}

		public IntinoPlugin intinoPlugin(String groupId, String artifactId, String version) {
			IntinoPlugin newElement = (IntinoPlugin) Artifact.this.core$().graph().concept(IntinoPlugin.class).createNode(this.name, Artifact.this.core$()).as(IntinoPlugin.class);
			newElement.core$().set(newElement, "groupId", Collections.singletonList(groupId));
			newElement.core$().set(newElement, "artifactId", Collections.singletonList(artifactId));
			newElement.core$().set(newElement, "version", Collections.singletonList(version));
			return newElement;
		}

		public Package package$(Package.Mode mode) {
			Package newElement = (Package) Artifact.this.core$().graph().concept(Package.class).createNode(this.name, Artifact.this.core$()).as(Package.class);
			newElement.core$().set(newElement, "mode", Collections.singletonList(mode));
			return newElement;
		}

		public Parameter parameter(String name) {
			Parameter newElement = (Parameter) Artifact.this.core$().graph().concept(Parameter.class).createNode(this.name, Artifact.this.core$()).as(Parameter.class);
			newElement.core$().set(newElement, "name", Collections.singletonList(name));
			return newElement;
		}

		public Distribution distribution() {
			Distribution newElement = (Distribution) Artifact.this.core$().graph().concept(Distribution.class).createNode(this.name, Artifact.this.core$()).as(Distribution.class);
			return newElement;
		}

		public QualityAnalytics qualityAnalytics(String url) {
			QualityAnalytics newElement = (QualityAnalytics) Artifact.this.core$().graph().concept(QualityAnalytics.class).createNode(this.name, Artifact.this.core$()).as(QualityAnalytics.class);
			newElement.core$().set(newElement, "url", Collections.singletonList(url));
			return newElement;
		}

		public Deployment deployment(Server server, RunConfiguration runConfiguration) {
			Deployment newElement = (Deployment) Artifact.this.core$().graph().concept(Deployment.class).createNode(this.name, Artifact.this.core$()).as(Deployment.class);
			newElement.core$().set(newElement, "server", Collections.singletonList(server));
			newElement.core$().set(newElement, "runConfiguration", Collections.singletonList(runConfiguration));
			return newElement;
		}
	}

	public class Clear {
		public void dsl(Predicate<Dsl> filter) {
			(new ArrayList<>(Artifact.this.dslList())).stream().filter(filter).forEach(Layer::delete$);
		}

		public void intinoPlugin(Predicate<IntinoPlugin> filter) {
			(new ArrayList<>(Artifact.this.intinoPluginList())).stream().filter(filter).forEach(Layer::delete$);
		}

		public void parameter(Predicate<Parameter> filter) {
			(new ArrayList<>(Artifact.this.parameterList())).stream().filter(filter).forEach(Layer::delete$);
		}

		public void deployment(Predicate<Deployment> filter) {
			(new ArrayList<>(Artifact.this.deploymentList())).stream().filter(filter).forEach(Layer::delete$);
		}
	}

	public static class License extends Layer implements Terminal {
		protected Type type;

		public License(Node node) {
			super(node);
		}

		public Type type() {
			return this.type;
		}

		public License type(Type value) {
			this.type = value;
			return this;
		}

		protected Map<String, List<?>> variables$() {
			Map<String, List<?>> map = new LinkedHashMap();
			map.put("type", new ArrayList(Collections.singletonList(this.type)));
			return map;
		}

		protected void load$(String name, List<?> values) {
			super.load$(name, values);
			if (name.equalsIgnoreCase("type")) {
				this.type = (Type) WordLoader.load(values, Type.class, this).get(0);
			}

		}

		protected void set$(String name, List<?> values) {
			super.set$(name, values);
			if (name.equalsIgnoreCase("type")) {
				this.type = (Type) values.get(0);
			}

		}

		public LegioGraph graph() {
			return (LegioGraph) this.core$().graph().as(LegioGraph.class);
		}

		public static enum Type {
			GPL,
			BSD,
			LGPL;
		}
	}

	public static class Dsl extends Layer implements Terminal {
		protected String name;
		protected String version;
		protected Builder builder;
		protected OutputDsl outputDsl;

		public Dsl(Node node) {
			super(node);
		}

		public String name() {
			return this.name;
		}

		public String version() {
			return this.version;
		}

		public Dsl name(String value) {
			this.name = value;
			return this;
		}

		public Dsl version(String value) {
			this.version = value;
			return this;
		}

		public Builder builder() {
			return this.builder;
		}

		public OutputDsl outputDsl() {
			return this.outputDsl;
		}

		protected List<Node> componentList$() {
			Set<Node> components = new LinkedHashSet(super.componentList$());
			if (this.builder != null) {
				components.add(this.builder.core$());
			}

			if (this.outputDsl != null) {
				components.add(this.outputDsl.core$());
			}

			return new ArrayList(components);
		}

		protected Map<String, List<?>> variables$() {
			Map<String, List<?>> map = new LinkedHashMap();
			map.put("name", new ArrayList(Collections.singletonList(this.name)));
			map.put("version", new ArrayList(Collections.singletonList(this.version)));
			return map;
		}

		protected void addNode$(Node node) {
			super.addNode$(node);
			if (node.is("Artifact$Dsl$Builder")) {
				this.builder = (Builder) node.as(Builder.class);
			}

			if (node.is("Artifact$Dsl$OutputDsl")) {
				this.outputDsl = (OutputDsl) node.as(OutputDsl.class);
			}

		}

		protected void removeNode$(Node node) {
			super.removeNode$(node);
			if (node.is("Artifact$Dsl$Builder")) {
				this.builder = null;
			}

			if (node.is("Artifact$Dsl$OutputDsl")) {
				this.outputDsl = null;
			}

		}

		protected void load$(String name, List<?> values) {
			super.load$(name, values);
			if (name.equalsIgnoreCase("name")) {
				this.name = (String) StringLoader.load(values, this).get(0);
			} else if (name.equalsIgnoreCase("version")) {
				this.version = (String) StringLoader.load(values, this).get(0);
			}

		}

		protected void set$(String name, List<?> values) {
			super.set$(name, values);
			if (name.equalsIgnoreCase("name")) {
				this.name = (String) values.get(0);
			} else if (name.equalsIgnoreCase("version")) {
				this.version = (String) values.get(0);
			}

		}

		public Create create() {
			return new Create((String) null);
		}

		public Create create(String name) {
			return new Create(name);
		}

		public LegioGraph graph() {
			return (LegioGraph) this.core$().graph().as(LegioGraph.class);
		}

		public class Create {
			protected final String name;

			public Create(String name) {
				this.name = name;
			}

			public Builder builder() {
				Builder newElement = (Builder) Dsl.this.core$().graph().concept(Builder.class).createNode(this.name, Dsl.this.core$()).as(Builder.class);
				return newElement;
			}

			public OutputDsl outputDsl() {
				OutputDsl newElement = (OutputDsl) Dsl.this.core$().graph().concept(OutputDsl.class).createNode(this.name, Dsl.this.core$()).as(OutputDsl.class);
				return newElement;
			}
		}

		public static class Builder extends Layer implements Terminal {
			protected String groupId;
			protected String artifactId;
			protected String version;
			protected String generationPackage;
			protected List<Exclude> exclude = new ArrayList();

			public Builder(Node node) {
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

			public String generationPackage() {
				return this.generationPackage;
			}

			public List<Exclude> exclude() {
				return this.exclude;
			}

			public Builder groupId(String value) {
				this.groupId = value;
				return this;
			}

			public Builder artifactId(String value) {
				this.artifactId = value;
				return this;
			}

			public Builder version(String value) {
				this.version = value;
				return this;
			}

			public Builder generationPackage(String value) {
				this.generationPackage = value;
				return this;
			}

			protected Map<String, List<?>> variables$() {
				Map<String, List<?>> map = new LinkedHashMap();
				map.put("groupId", new ArrayList(Collections.singletonList(this.groupId)));
				map.put("artifactId", new ArrayList(Collections.singletonList(this.artifactId)));
				map.put("version", new ArrayList(Collections.singletonList(this.version)));
				map.put("generationPackage", new ArrayList(Collections.singletonList(this.generationPackage)));
				map.put("exclude", this.exclude);
				return map;
			}

			protected void load$(String name, List<?> values) {
				super.load$(name, values);
				if (name.equalsIgnoreCase("groupId")) {
					this.groupId = (String) StringLoader.load(values, this).get(0);
				} else if (name.equalsIgnoreCase("artifactId")) {
					this.artifactId = (String) StringLoader.load(values, this).get(0);
				} else if (name.equalsIgnoreCase("version")) {
					this.version = (String) StringLoader.load(values, this).get(0);
				} else if (name.equalsIgnoreCase("generationPackage")) {
					this.generationPackage = (String) StringLoader.load(values, this).get(0);
				} else if (name.equalsIgnoreCase("exclude")) {
					this.exclude = WordLoader.load(values, Exclude.class, this);
				}

			}

			protected void set$(String name, List<?> values) {
				super.set$(name, values);
				if (name.equalsIgnoreCase("groupId")) {
					this.groupId = (String) values.get(0);
				} else if (name.equalsIgnoreCase("artifactId")) {
					this.artifactId = (String) values.get(0);
				} else if (name.equalsIgnoreCase("version")) {
					this.version = (String) values.get(0);
				} else if (name.equalsIgnoreCase("generationPackage")) {
					this.generationPackage = (String) values.get(0);
				} else if (name.equalsIgnoreCase("exclude")) {
					this.exclude = new ArrayList(values);
				}

			}

			public LegioGraph graph() {
				return (LegioGraph) this.core$().graph().as(LegioGraph.class);
			}

			public static enum Exclude {
				ExcludeCodeBaseGeneration,
				ExcludeLanguageGeneration;
			}
		}

		public static class OutputDsl extends Layer implements Terminal {
			protected String name;
			protected Runtime runtime;
			protected Builder builder;

			public OutputDsl(Node node) {
				super(node);
			}

			public String name() {
				return this.name;
			}

			public OutputDsl name(String value) {
				this.name = value;
				return this;
			}

			public Runtime runtime() {
				return this.runtime;
			}

			public Builder builder() {
				return this.builder;
			}

			protected List<Node> componentList$() {
				Set<Node> components = new LinkedHashSet(super.componentList$());
				if (this.runtime != null) {
					components.add(this.runtime.core$());
				}

				if (this.builder != null) {
					components.add(this.builder.core$());
				}

				return new ArrayList(components);
			}

			protected Map<String, List<?>> variables$() {
				Map<String, List<?>> map = new LinkedHashMap();
				map.put("name", new ArrayList(Collections.singletonList(this.name)));
				return map;
			}

			protected void addNode$(Node node) {
				super.addNode$(node);
				if (node.is("Artifact$Dsl$OutputDsl$Runtime")) {
					this.runtime = (Runtime) node.as(Runtime.class);
				}

				if (node.is("Artifact$Dsl$OutputDsl$Builder")) {
					this.builder = (Builder) node.as(Builder.class);
				}

			}

			protected void removeNode$(Node node) {
				super.removeNode$(node);
				if (node.is("Artifact$Dsl$OutputDsl$Runtime")) {
					this.runtime = null;
				}

				if (node.is("Artifact$Dsl$OutputDsl$Builder")) {
					this.builder = null;
				}

			}

			protected void load$(String name, List<?> values) {
				super.load$(name, values);
				if (name.equalsIgnoreCase("name")) {
					this.name = (String) StringLoader.load(values, this).get(0);
				}

			}

			protected void set$(String name, List<?> values) {
				super.set$(name, values);
				if (name.equalsIgnoreCase("name")) {
					this.name = (String) values.get(0);
				}

			}

			public Create create() {
				return new Create((String) null);
			}

			public Create create(String name) {
				return new Create(name);
			}

			public LegioGraph graph() {
				return (LegioGraph) this.core$().graph().as(LegioGraph.class);
			}

			public class Create {
				protected final String name;

				public Create(String name) {
					this.name = name;
				}

				public Runtime runtime(String groupId, String artifactId, String version) {
					Runtime newElement = (Runtime) OutputDsl.this.core$().graph().concept(Runtime.class).createNode(this.name, OutputDsl.this.core$()).as(Runtime.class);
					newElement.core$().set(newElement, "groupId", Collections.singletonList(groupId));
					newElement.core$().set(newElement, "artifactId", Collections.singletonList(artifactId));
					newElement.core$().set(newElement, "version", Collections.singletonList(version));
					return newElement;
				}

				public Builder builder(String groupId, String artifactId, String version) {
					Builder newElement = (Builder) OutputDsl.this.core$().graph().concept(Builder.class).createNode(this.name, OutputDsl.this.core$()).as(Builder.class);
					newElement.core$().set(newElement, "groupId", Collections.singletonList(groupId));
					newElement.core$().set(newElement, "artifactId", Collections.singletonList(artifactId));
					newElement.core$().set(newElement, "version", Collections.singletonList(version));
					return newElement;
				}
			}

			public static class Runtime extends Library implements Terminal {
				protected ArtifactVersionFollower _artifactVersionFollower;

				public Runtime(Node node) {
					super(node);
				}

				public ArtifactVersionFollower asArtifactVersionFollower() {
					Layer as = this.a$(ArtifactVersionFollower.class);
					return as != null ? (ArtifactVersionFollower) as : (ArtifactVersionFollower) this.core$().addAspect(ArtifactVersionFollower.class);
				}

				public boolean isArtifactVersionFollower() {
					return this.core$().is(ArtifactVersionFollower.class);
				}

				public void removeArtifactVersionFollower() {
					this.core$().removeAspect(ArtifactVersionFollower.class);
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

				public Create create() {
					return new Create((String) null);
				}

				public Create create(String name) {
					return new Create(name);
				}

				public LegioGraph graph() {
					return (LegioGraph) this.core$().graph().as(LegioGraph.class);
				}

				public class Create extends Library.Create {
					public Create(String name) {
						super(name);
					}
				}

				public static class ArtifactVersionFollower extends Layer implements Terminal {
					protected String version;
					protected Runtime _runtime;

					public ArtifactVersionFollower(Node node) {
						super(node);
					}

					public String version() {
						return this.version;
					}

					public ArtifactVersionFollower version(String value) {
						this.version = value;
						return this;
					}

					public Runtime asRuntime() {
						return (Runtime) this.a$(Runtime.class);
					}

					protected Map<String, List<?>> variables$() {
						Map<String, List<?>> map = new LinkedHashMap();
						map.put("version", new ArrayList(Collections.singletonList(this.version)));
						return map;
					}

					protected void load$(String name, List<?> values) {
						super.load$(name, values);
						if (name.equalsIgnoreCase("version")) {
							this.version = (String) StringLoader.load(values, this).get(0);
						}

					}

					protected void set$(String name, List<?> values) {
						super.set$(name, values);
						if (name.equalsIgnoreCase("version")) {
							this.version = (String) values.get(0);
						}

					}

					protected void sync$(Layer layer) {
						super.sync$(layer);
						if (layer instanceof Runtime) {
							this._runtime = (Runtime) layer;
						}

					}

					public LegioGraph graph() {
						return (LegioGraph) this.core$().graph().as(LegioGraph.class);
					}
				}
			}

			public static class Builder extends Library implements Terminal {
				protected ArtifactVersionFollower _artifactVersionFollower;

				public Builder(Node node) {
					super(node);
				}

				public ArtifactVersionFollower asArtifactVersionFollower() {
					Layer as = this.a$(ArtifactVersionFollower.class);
					return as != null ? (ArtifactVersionFollower) as : (ArtifactVersionFollower) this.core$().addAspect(ArtifactVersionFollower.class);
				}

				public boolean isArtifactVersionFollower() {
					return this.core$().is(ArtifactVersionFollower.class);
				}

				public void removeArtifactVersionFollower() {
					this.core$().removeAspect(ArtifactVersionFollower.class);
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

				public Create create() {
					return new Create((String) null);
				}

				public Create create(String name) {
					return new Create(name);
				}

				public LegioGraph graph() {
					return (LegioGraph) this.core$().graph().as(LegioGraph.class);
				}

				public class Create extends Library.Create {
					public Create(String name) {
						super( name);
					}
				}

				public static class ArtifactVersionFollower extends Layer implements Terminal {
					protected String version;
					protected Builder _builder;

					public ArtifactVersionFollower(Node node) {
						super(node);
					}

					public String version() {
						return this.version;
					}

					public ArtifactVersionFollower version(String value) {
						this.version = value;
						return this;
					}

					public Builder asBuilder() {
						return (Builder) this.a$(Builder.class);
					}

					protected Map<String, List<?>> variables$() {
						Map<String, List<?>> map = new LinkedHashMap();
						map.put("version", new ArrayList(Collections.singletonList(this.version)));
						return map;
					}

					protected void load$(String name, List<?> values) {
						super.load$(name, values);
						if (name.equalsIgnoreCase("version")) {
							this.version = (String) StringLoader.load(values, this).get(0);
						}

					}

					protected void set$(String name, List<?> values) {
						super.set$(name, values);
						if (name.equalsIgnoreCase("version")) {
							this.version = (String) values.get(0);
						}

					}

					protected void sync$(Layer layer) {
						super.sync$(layer);
						if (layer instanceof Builder) {
							this._builder = (Builder) layer;
						}

					}

					public LegioGraph graph() {
						return (LegioGraph) this.core$().graph().as(LegioGraph.class);
					}
				}
			}
		}
	}

	public static class Model extends Layer implements Terminal {
		protected String language;
		protected String version;
		protected String sdkVersion;
		protected String sdk;
		protected String effectiveVersion;
		protected String outLanguage;
		protected List<Exclude> exclude = new ArrayList();

		public Model(Node node) {
			super(node);
		}

		public String language() {
			return this.language;
		}

		public String version() {
			return this.version;
		}

		public String sdkVersion() {
			return this.sdkVersion;
		}

		public String sdk() {
			return this.sdk;
		}

		public String effectiveVersion() {
			return this.effectiveVersion;
		}

		public String outLanguage() {
			return this.outLanguage;
		}

		public List<Exclude> exclude() {
			return this.exclude;
		}

		public Model language(String value) {
			this.language = value;
			return this;
		}

		public Model version(String value) {
			this.version = value;
			return this;
		}

		public Model sdkVersion(String value) {
			this.sdkVersion = value;
			return this;
		}

		public Model sdk(String value) {
			this.sdk = value;
			return this;
		}

		public Model effectiveVersion(String value) {
			this.effectiveVersion = value;
			return this;
		}

		public Model outLanguage(String value) {
			this.outLanguage = value;
			return this;
		}

		protected Map<String, List<?>> variables$() {
			Map<String, List<?>> map = new LinkedHashMap();
			map.put("language", new ArrayList(Collections.singletonList(this.language)));
			map.put("version", new ArrayList(Collections.singletonList(this.version)));
			map.put("sdkVersion", new ArrayList(Collections.singletonList(this.sdkVersion)));
			map.put("sdk", new ArrayList(Collections.singletonList(this.sdk)));
			map.put("effectiveVersion", new ArrayList(Collections.singletonList(this.effectiveVersion)));
			map.put("outLanguage", new ArrayList(Collections.singletonList(this.outLanguage)));
			map.put("exclude", this.exclude);
			return map;
		}

		protected void load$(String name, List<?> values) {
			super.load$(name, values);
			if (name.equalsIgnoreCase("language")) {
				this.language = (String) StringLoader.load(values, this).get(0);
			} else if (name.equalsIgnoreCase("version")) {
				this.version = (String) StringLoader.load(values, this).get(0);
			} else if (name.equalsIgnoreCase("sdkVersion")) {
				this.sdkVersion = (String) StringLoader.load(values, this).get(0);
			} else if (name.equalsIgnoreCase("sdk")) {
				this.sdk = (String) StringLoader.load(values, this).get(0);
			} else if (name.equalsIgnoreCase("effectiveVersion")) {
				this.effectiveVersion = (String) StringLoader.load(values, this).get(0);
			} else if (name.equalsIgnoreCase("outLanguage")) {
				this.outLanguage = (String) StringLoader.load(values, this).get(0);
			} else if (name.equalsIgnoreCase("exclude")) {
				this.exclude = WordLoader.load(values, Exclude.class, this);
			}

		}

		protected void set$(String name, List<?> values) {
			super.set$(name, values);
			if (name.equalsIgnoreCase("language")) {
				this.language = (String) values.get(0);
			} else if (name.equalsIgnoreCase("version")) {
				this.version = (String) values.get(0);
			} else if (name.equalsIgnoreCase("sdkVersion")) {
				this.sdkVersion = (String) values.get(0);
			} else if (name.equalsIgnoreCase("sdk")) {
				this.sdk = (String) values.get(0);
			} else if (name.equalsIgnoreCase("effectiveVersion")) {
				this.effectiveVersion = (String) values.get(0);
			} else if (name.equalsIgnoreCase("outLanguage")) {
				this.outLanguage = (String) values.get(0);
			} else if (name.equalsIgnoreCase("exclude")) {
				this.exclude = new ArrayList(values);
			}

		}

		public LegioGraph graph() {
			return (LegioGraph) this.core$().graph().as(LegioGraph.class);
		}

		public static enum Exclude {
			ExcludeFrameworkCode,
			ExcludeLanguageCode;
		}
	}

	public static class Box extends Layer implements Terminal {
		protected String language;
		protected String version;
		protected String sdk;
		protected String effectiveVersion;
		protected String targetPackage;

		public Box(Node node) {
			super(node);
		}

		public String language() {
			return this.language;
		}

		public String version() {
			return this.version;
		}

		public String sdk() {
			return this.sdk;
		}

		public String effectiveVersion() {
			return this.effectiveVersion;
		}

		public String targetPackage() {
			return this.targetPackage;
		}

		public Box language(String value) {
			this.language = value;
			return this;
		}

		public Box version(String value) {
			this.version = value;
			return this;
		}

		public Box sdk(String value) {
			this.sdk = value;
			return this;
		}

		public Box effectiveVersion(String value) {
			this.effectiveVersion = value;
			return this;
		}

		public Box targetPackage(String value) {
			this.targetPackage = value;
			return this;
		}

		protected Map<String, List<?>> variables$() {
			Map<String, List<?>> map = new LinkedHashMap();
			map.put("language", new ArrayList(Collections.singletonList(this.language)));
			map.put("version", new ArrayList(Collections.singletonList(this.version)));
			map.put("sdk", new ArrayList(Collections.singletonList(this.sdk)));
			map.put("effectiveVersion", new ArrayList(Collections.singletonList(this.effectiveVersion)));
			map.put("targetPackage", new ArrayList(Collections.singletonList(this.targetPackage)));
			return map;
		}

		protected void load$(String name, List<?> values) {
			super.load$(name, values);
			if (name.equalsIgnoreCase("language")) {
				this.language = (String) StringLoader.load(values, this).get(0);
			} else if (name.equalsIgnoreCase("version")) {
				this.version = (String) StringLoader.load(values, this).get(0);
			} else if (name.equalsIgnoreCase("sdk")) {
				this.sdk = (String) StringLoader.load(values, this).get(0);
			} else if (name.equalsIgnoreCase("effectiveVersion")) {
				this.effectiveVersion = (String) StringLoader.load(values, this).get(0);
			} else if (name.equalsIgnoreCase("targetPackage")) {
				this.targetPackage = (String) StringLoader.load(values, this).get(0);
			}

		}

		protected void set$(String name, List<?> values) {
			super.set$(name, values);
			if (name.equalsIgnoreCase("language")) {
				this.language = (String) values.get(0);
			} else if (name.equalsIgnoreCase("version")) {
				this.version = (String) values.get(0);
			} else if (name.equalsIgnoreCase("sdk")) {
				this.sdk = (String) values.get(0);
			} else if (name.equalsIgnoreCase("effectiveVersion")) {
				this.effectiveVersion = (String) values.get(0);
			} else if (name.equalsIgnoreCase("targetPackage")) {
				this.targetPackage = (String) values.get(0);
			}

		}

		public LegioGraph graph() {
			return (LegioGraph) this.core$().graph().as(LegioGraph.class);
		}
	}

	public static class DataHub extends Imports.Dependency implements Terminal {
		public DataHub(Node node) {
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
			return (LegioGraph) this.core$().graph().as(LegioGraph.class);
		}
	}

	public static class Archetype extends Imports.Dependency implements Terminal {
		public Archetype(Node node) {
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
			return (LegioGraph) this.core$().graph().as(LegioGraph.class);
		}
	}

	public static class Imports extends Layer implements Terminal {
		protected List<Dependency> dependencyList = new ArrayList();
		protected List<Compile> compileList = new ArrayList();
		protected List<Runtime> runtimeList = new ArrayList();
		protected List<Provided> providedList = new ArrayList();
		protected List<Test> testList = new ArrayList();
		protected List<Web> webList = new ArrayList();

		public Imports(Node node) {
			super(node);
		}

		public List<Dependency> dependencyList() {
			return Collections.unmodifiableList(this.dependencyList);
		}

		public Dependency dependency(int index) {
			return (Dependency) this.dependencyList.get(index);
		}

		public List<Dependency> dependencyList(Predicate<Dependency> predicate) {
			return (List) this.dependencyList().stream().filter(predicate).collect(Collectors.toList());
		}

		public Dependency dependency(Predicate<Dependency> predicate) {
			return (Dependency) this.dependencyList().stream().filter(predicate).findFirst().orElse(null);
		}

		public List<Compile> compileList() {
			return Collections.unmodifiableList(this.compileList);
		}

		public Compile compile(int index) {
			return (Compile) this.compileList.get(index);
		}

		public List<Compile> compileList(Predicate<Compile> predicate) {
			return (List) this.compileList().stream().filter(predicate).collect(Collectors.toList());
		}

		public Compile compile(Predicate<Compile> predicate) {
			return (Compile) this.compileList().stream().filter(predicate).findFirst().orElse(null);
		}

		public List<Runtime> runtimeList() {
			return Collections.unmodifiableList(this.runtimeList);
		}

		public Runtime runtime(int index) {
			return (Runtime) this.runtimeList.get(index);
		}

		public List<Runtime> runtimeList(Predicate<Runtime> predicate) {
			return (List) this.runtimeList().stream().filter(predicate).collect(Collectors.toList());
		}

		public Runtime runtime(Predicate<Runtime> predicate) {
			return (Runtime) this.runtimeList().stream().filter(predicate).findFirst().orElse(null);
		}

		public List<Provided> providedList() {
			return Collections.unmodifiableList(this.providedList);
		}

		public Provided provided(int index) {
			return (Provided) this.providedList.get(index);
		}

		public List<Provided> providedList(Predicate<Provided> predicate) {
			return (List) this.providedList().stream().filter(predicate).collect(Collectors.toList());
		}

		public Provided provided(Predicate<Provided> predicate) {
			return (Provided) this.providedList().stream().filter(predicate).findFirst().orElse(null);
		}

		public List<Test> testList() {
			return Collections.unmodifiableList(this.testList);
		}

		public Test test(int index) {
			return (Test) this.testList.get(index);
		}

		public List<Test> testList(Predicate<Test> predicate) {
			return (List) this.testList().stream().filter(predicate).collect(Collectors.toList());
		}

		public Test test(Predicate<Test> predicate) {
			return (Test) this.testList().stream().filter(predicate).findFirst().orElse(null);
		}

		public List<Web> webList() {
			return Collections.unmodifiableList(this.webList);
		}

		public Web web(int index) {
			return (Web) this.webList.get(index);
		}

		public List<Web> webList(Predicate<Web> predicate) {
			return (List) this.webList().stream().filter(predicate).collect(Collectors.toList());
		}

		public Web web(Predicate<Web> predicate) {
			return (Web) this.webList().stream().filter(predicate).findFirst().orElse(null);
		}

		protected List<Node> componentList$() {
			Set<Node> components = new LinkedHashSet(super.componentList$());
			(new ArrayList<>(this.dependencyList)).forEach((c) -> components.add(c.core$()));
			(new ArrayList<>(this.compileList)).forEach((c) -> components.add(c.core$()));
			(new ArrayList<>(this.runtimeList)).forEach((c) -> components.add(c.core$()));
			(new ArrayList<>(this.providedList)).forEach((c) -> components.add(c.core$()));
			(new ArrayList<>(this.testList)).forEach((c) -> components.add(c.core$()));
			(new ArrayList<>(this.webList)).forEach((c) -> components.add(c.core$()));
			return new ArrayList(components);
		}

		protected Map<String, List<?>> variables$() {
			Map<String, List<?>> map = new LinkedHashMap();
			return map;
		}

		protected void addNode$(Node node) {
			super.addNode$(node);
			if (node.is("Artifact$Imports$Dependency")) {
				this.dependencyList.add((Dependency) node.as(Dependency.class));
			}

			if (node.is("Artifact$Imports$Compile")) {
				this.compileList.add((Compile) node.as(Compile.class));
			}

			if (node.is("Artifact$Imports$Runtime")) {
				this.runtimeList.add((Runtime) node.as(Runtime.class));
			}

			if (node.is("Artifact$Imports$Provided")) {
				this.providedList.add((Provided) node.as(Provided.class));
			}

			if (node.is("Artifact$Imports$Test")) {
				this.testList.add((Test) node.as(Test.class));
			}

			if (node.is("Artifact$Imports$Web")) {
				this.webList.add((Web) node.as(Web.class));
			}

		}

		protected void removeNode$(Node node) {
			super.removeNode$(node);
			if (node.is("Artifact$Imports$Dependency")) {
				this.dependencyList.remove(node.as(Dependency.class));
			}

			if (node.is("Artifact$Imports$Compile")) {
				this.compileList.remove(node.as(Compile.class));
			}

			if (node.is("Artifact$Imports$Runtime")) {
				this.runtimeList.remove(node.as(Runtime.class));
			}

			if (node.is("Artifact$Imports$Provided")) {
				this.providedList.remove(node.as(Provided.class));
			}

			if (node.is("Artifact$Imports$Test")) {
				this.testList.remove(node.as(Test.class));
			}

			if (node.is("Artifact$Imports$Web")) {
				this.webList.remove(node.as(Web.class));
			}

		}

		protected void load$(String name, List<?> values) {
			super.load$(name, values);
		}

		protected void set$(String name, List<?> values) {
			super.set$(name, values);
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

			public Compile compile(String groupId, String artifactId, String version) {
				Compile newElement = (Compile) Imports.this.core$().graph().concept(Compile.class).createNode(this.name, Imports.this.core$()).as(Compile.class);
				newElement.core$().set(newElement, "groupId", Collections.singletonList(groupId));
				newElement.core$().set(newElement, "artifactId", Collections.singletonList(artifactId));
				newElement.core$().set(newElement, "version", Collections.singletonList(version));
				return newElement;
			}

			public Runtime runtime(String groupId, String artifactId, String version) {
				Runtime newElement = (Runtime) Imports.this.core$().graph().concept(Runtime.class).createNode(this.name, Imports.this.core$()).as(Runtime.class);
				newElement.core$().set(newElement, "groupId", Collections.singletonList(groupId));
				newElement.core$().set(newElement, "artifactId", Collections.singletonList(artifactId));
				newElement.core$().set(newElement, "version", Collections.singletonList(version));
				return newElement;
			}

			public Provided provided(String groupId, String artifactId, String version) {
				Provided newElement = (Provided) Imports.this.core$().graph().concept(Provided.class).createNode(this.name, Imports.this.core$()).as(Provided.class);
				newElement.core$().set(newElement, "groupId", Collections.singletonList(groupId));
				newElement.core$().set(newElement, "artifactId", Collections.singletonList(artifactId));
				newElement.core$().set(newElement, "version", Collections.singletonList(version));
				return newElement;
			}

			public Test test(String groupId, String artifactId, String version) {
				Test newElement = (Test) Imports.this.core$().graph().concept(Test.class).createNode(this.name, Imports.this.core$()).as(Test.class);
				newElement.core$().set(newElement, "groupId", Collections.singletonList(groupId));
				newElement.core$().set(newElement, "artifactId", Collections.singletonList(artifactId));
				newElement.core$().set(newElement, "version", Collections.singletonList(version));
				return newElement;
			}

			public Web web(String groupId, String artifactId, String version) {
				Web newElement = (Web) Imports.this.core$().graph().concept(Web.class).createNode(this.name, Imports.this.core$()).as(Web.class);
				newElement.core$().set(newElement, "groupId", Collections.singletonList(groupId));
				newElement.core$().set(newElement, "artifactId", Collections.singletonList(artifactId));
				newElement.core$().set(newElement, "version", Collections.singletonList(version));
				return newElement;
			}

			public Archetype archetype(String groupId, String artifactId, String version) {
				Archetype newElement = (Archetype) Imports.this.core$().graph().concept(Archetype.class).createNode(this.name, Imports.this.core$()).as(Archetype.class);
				newElement.core$().set(newElement, "groupId", Collections.singletonList(groupId));
				newElement.core$().set(newElement, "artifactId", Collections.singletonList(artifactId));
				newElement.core$().set(newElement, "version", Collections.singletonList(version));
				return newElement;
			}

			public DataHub dataHub(String groupId, String artifactId, String version) {
				DataHub newElement = (DataHub) Imports.this.core$().graph().concept(DataHub.class).createNode(this.name, Imports.this.core$()).as(DataHub.class);
				newElement.core$().set(newElement, "groupId", Collections.singletonList(groupId));
				newElement.core$().set(newElement, "artifactId", Collections.singletonList(artifactId));
				newElement.core$().set(newElement, "version", Collections.singletonList(version));
				return newElement;
			}
		}

		public class Clear {
			public void compile(Predicate<Compile> filter) {
				(new ArrayList<>(Imports.this.compileList())).stream().filter(filter).forEach(Layer::delete$);
			}

			public void runtime(Predicate<Runtime> filter) {
				(new ArrayList<>(Imports.this.runtimeList())).stream().filter(filter).forEach(Layer::delete$);
			}

			public void provided(Predicate<Provided> filter) {
				(new ArrayList<>(Imports.this.providedList())).stream().filter(filter).forEach(Layer::delete$);
			}

			public void test(Predicate<Test> filter) {
				(new ArrayList<>(Imports.this.testList())).stream().filter(filter).forEach(Layer::delete$);
			}

			public void web(Predicate<Web> filter) {
				(new ArrayList<>(Imports.this.webList())).stream().filter(filter).forEach(Layer::delete$);
			}
		}

		public abstract static class Dependency extends Library implements Terminal {
			protected String effectiveVersion;
			protected boolean transitive;
			protected boolean resolved;
			protected boolean toModule;
			protected List<Exclude> excludeList = new ArrayList();
			protected ArtifactVersionFollower _artifactVersionFollower;

			public Dependency(Node node) {
				super(node);
			}

			public String effectiveVersion() {
				return this.effectiveVersion;
			}

			public boolean transitive() {
				return this.transitive;
			}

			public boolean resolved() {
				return this.resolved;
			}

			public boolean toModule() {
				return this.toModule;
			}

			public Dependency effectiveVersion(String value) {
				this.effectiveVersion = value;
				return this;
			}

			public Dependency transitive(boolean value) {
				this.transitive = value;
				return this;
			}

			public Dependency resolved(boolean value) {
				this.resolved = value;
				return this;
			}

			public Dependency toModule(boolean value) {
				this.toModule = value;
				return this;
			}

			public List<Exclude> excludeList() {
				return Collections.unmodifiableList(this.excludeList);
			}

			public Exclude exclude(int index) {
				return (Exclude) this.excludeList.get(index);
			}

			public List<Exclude> excludeList(Predicate<Exclude> predicate) {
				return (List) this.excludeList().stream().filter(predicate).collect(Collectors.toList());
			}

			public Exclude exclude(Predicate<Exclude> predicate) {
				return (Exclude) this.excludeList().stream().filter(predicate).findFirst().orElse(null);
			}

			public ArtifactVersionFollower asArtifactVersionFollower() {
				Layer as = this.a$(ArtifactVersionFollower.class);
				return as != null ? (ArtifactVersionFollower) as : (ArtifactVersionFollower) this.core$().addAspect(ArtifactVersionFollower.class);
			}

			public boolean isArtifactVersionFollower() {
				return this.core$().is(ArtifactVersionFollower.class);
			}

			public void removeArtifactVersionFollower() {
				this.core$().removeAspect(ArtifactVersionFollower.class);
			}

			protected List<Node> componentList$() {
				Set<Node> components = new LinkedHashSet(super.componentList$());
				(new ArrayList<>(this.excludeList)).forEach((c) -> components.add(c.core$()));
				return new ArrayList(components);
			}

			protected Map<String, List<?>> variables$() {
				Map<String, List<?>> map = new LinkedHashMap(super.variables$());
				map.put("effectiveVersion", new ArrayList(Collections.singletonList(this.effectiveVersion)));
				map.put("transitive", new ArrayList(Collections.singletonList(this.transitive)));
				map.put("resolved", new ArrayList(Collections.singletonList(this.resolved)));
				map.put("toModule", new ArrayList(Collections.singletonList(this.toModule)));
				return map;
			}

			protected void addNode$(Node node) {
				super.addNode$(node);
				if (node.is("Artifact$Imports$Dependency$Exclude")) {
					this.excludeList.add((Exclude) node.as(Exclude.class));
				}

			}

			protected void removeNode$(Node node) {
				super.removeNode$(node);
				if (node.is("Artifact$Imports$Dependency$Exclude")) {
					this.excludeList.remove(node.as(Exclude.class));
				}

			}

			protected void load$(String name, List<?> values) {
				super.load$(name, values);
				if (name.equalsIgnoreCase("effectiveVersion")) {
					this.effectiveVersion = (String) StringLoader.load(values, this).get(0);
				} else if (name.equalsIgnoreCase("transitive")) {
					this.transitive = (Boolean) BooleanLoader.load(values, this).get(0);
				} else if (name.equalsIgnoreCase("resolved")) {
					this.resolved = (Boolean) BooleanLoader.load(values, this).get(0);
				} else if (name.equalsIgnoreCase("toModule")) {
					this.toModule = (Boolean) BooleanLoader.load(values, this).get(0);
				}

			}

			protected void set$(String name, List<?> values) {
				super.set$(name, values);
				if (name.equalsIgnoreCase("effectiveVersion")) {
					this.effectiveVersion = (String) values.get(0);
				} else if (name.equalsIgnoreCase("transitive")) {
					this.transitive = (Boolean) values.get(0);
				} else if (name.equalsIgnoreCase("resolved")) {
					this.resolved = (Boolean) values.get(0);
				} else if (name.equalsIgnoreCase("toModule")) {
					this.toModule = (Boolean) values.get(0);
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

			public class Create extends Library.Create {
				public Create(String name) {
					super( name);
				}

				public Exclude exclude(String groupId, String artifactId) {
					Exclude newElement = (Exclude) Dependency.this.core$().graph().concept(Exclude.class).createNode(this.name, Dependency.this.core$()).as(Exclude.class);
					newElement.core$().set(newElement, "groupId", Collections.singletonList(groupId));
					newElement.core$().set(newElement, "artifactId", Collections.singletonList(artifactId));
					return newElement;
				}
			}

			public class Clear {
				public void exclude(Predicate<Exclude> filter) {
					(new ArrayList<>(Dependency.this.excludeList())).stream().filter(filter).forEach(Layer::delete$);
				}
			}

			public static class Exclude extends Layer implements Terminal {
				protected String groupId;
				protected String artifactId;

				public Exclude(Node node) {
					super(node);
				}

				public String groupId() {
					return this.groupId;
				}

				public String artifactId() {
					return this.artifactId;
				}

				public Exclude groupId(String value) {
					this.groupId = value;
					return this;
				}

				public Exclude artifactId(String value) {
					this.artifactId = value;
					return this;
				}

				protected Map<String, List<?>> variables$() {
					Map<String, List<?>> map = new LinkedHashMap();
					map.put("groupId", new ArrayList(Collections.singletonList(this.groupId)));
					map.put("artifactId", new ArrayList(Collections.singletonList(this.artifactId)));
					return map;
				}

				protected void load$(String name, List<?> values) {
					super.load$(name, values);
					if (name.equalsIgnoreCase("groupId")) {
						this.groupId = (String) StringLoader.load(values, this).get(0);
					} else if (name.equalsIgnoreCase("artifactId")) {
						this.artifactId = (String) StringLoader.load(values, this).get(0);
					}

				}

				protected void set$(String name, List<?> values) {
					super.set$(name, values);
					if (name.equalsIgnoreCase("groupId")) {
						this.groupId = (String) values.get(0);
					} else if (name.equalsIgnoreCase("artifactId")) {
						this.artifactId = (String) values.get(0);
					}

				}

				public LegioGraph graph() {
					return (LegioGraph) this.core$().graph().as(LegioGraph.class);
				}
			}

			public static class ArtifactVersionFollower extends Layer implements Terminal {
				protected String version;
				protected Dependency _dependency;

				public ArtifactVersionFollower(Node node) {
					super(node);
				}

				public String version() {
					return this.version;
				}

				public String effectiveVersion() {
					return this._dependency.effectiveVersion();
				}

				public boolean transitive() {
					return this._dependency.transitive();
				}

				public boolean resolved() {
					return this._dependency.resolved();
				}

				public boolean toModule() {
					return this._dependency.toModule();
				}

				public ArtifactVersionFollower version(String value) {
					this.version = value;
					return this;
				}

				public ArtifactVersionFollower effectiveVersion(String value) {
					this._dependency.effectiveVersion(value);
					return this;
				}

				public ArtifactVersionFollower transitive(boolean value) {
					this._dependency.transitive(value);
					return this;
				}

				public ArtifactVersionFollower resolved(boolean value) {
					this._dependency.resolved(value);
					return this;
				}

				public ArtifactVersionFollower toModule(boolean value) {
					this._dependency.toModule(value);
					return this;
				}

				public List<Exclude> excludeList() {
					return this._dependency.excludeList();
				}

				public Exclude excludeList(int index) {
					return (Exclude) this._dependency.excludeList().get(index);
				}

				public Dependency asDependency() {
					return (Dependency) this.a$(Dependency.class);
				}

				protected Map<String, List<?>> variables$() {
					Map<String, List<?>> map = new LinkedHashMap();
					map.put("version", new ArrayList(Collections.singletonList(this.version)));
					return map;
				}

				protected void load$(String name, List<?> values) {
					super.load$(name, values);
					if (name.equalsIgnoreCase("version")) {
						this.version = (String) StringLoader.load(values, this).get(0);
					}

				}

				protected void set$(String name, List<?> values) {
					super.set$(name, values);
					if (name.equalsIgnoreCase("version")) {
						this.version = (String) values.get(0);
					}

				}

				protected void sync$(Layer layer) {
					super.sync$(layer);
					if (layer instanceof Dependency) {
						this._dependency = (Dependency) layer;
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

					public Exclude exclude(String groupId, String artifactId) {
						Exclude newElement = (Exclude) ArtifactVersionFollower.this.core$().graph().concept(Exclude.class).createNode(this.name, ArtifactVersionFollower.this.core$()).as(Exclude.class);
						newElement.core$().set(newElement, "groupId", Collections.singletonList(groupId));
						newElement.core$().set(newElement, "artifactId", Collections.singletonList(artifactId));
						return newElement;
					}
				}

				public class Clear {
					public void exclude(Predicate<Exclude> filter) {
						(new ArrayList<>(ArtifactVersionFollower.this.excludeList())).stream().filter(filter).forEach(Layer::delete$);
					}
				}
			}
		}

		public static class Compile extends Dependency implements Terminal {
			public Compile(Node node) {
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
				return (LegioGraph) this.core$().graph().as(LegioGraph.class);
			}
		}

		public static class Runtime extends Dependency implements Terminal {
			public Runtime(Node node) {
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
				return (LegioGraph) this.core$().graph().as(LegioGraph.class);
			}
		}

		public static class Provided extends Dependency implements Terminal {
			public Provided(Node node) {
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
				return (LegioGraph) this.core$().graph().as(LegioGraph.class);
			}
		}

		public static class Test extends Dependency implements Terminal {
			public Test(Node node) {
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
				return (LegioGraph) this.core$().graph().as(LegioGraph.class);
			}
		}

		public static class Web extends Library implements Terminal {
			protected boolean resolved;
			protected ArtifactVersionFollower _artifactVersionFollower;

			public Web(Node node) {
				super(node);
			}

			public boolean resolved() {
				return this.resolved;
			}

			public Web resolved(boolean value) {
				this.resolved = value;
				return this;
			}

			public ArtifactVersionFollower asArtifactVersionFollower() {
				Layer as = this.a$(ArtifactVersionFollower.class);
				return as != null ? (ArtifactVersionFollower) as : (ArtifactVersionFollower) this.core$().addAspect(ArtifactVersionFollower.class);
			}

			public boolean isArtifactVersionFollower() {
				return this.core$().is(ArtifactVersionFollower.class);
			}

			public void removeArtifactVersionFollower() {
				this.core$().removeAspect(ArtifactVersionFollower.class);
			}

			protected Map<String, List<?>> variables$() {
				Map<String, List<?>> map = new LinkedHashMap(super.variables$());
				map.put("resolved", new ArrayList(Collections.singletonList(this.resolved)));
				return map;
			}

			protected void load$(String name, List<?> values) {
				super.load$(name, values);
				if (name.equalsIgnoreCase("resolved")) {
					this.resolved = (Boolean) BooleanLoader.load(values, this).get(0);
				}

			}

			protected void set$(String name, List<?> values) {
				super.set$(name, values);
				if (name.equalsIgnoreCase("resolved")) {
					this.resolved = (Boolean) values.get(0);
				}

			}

			public Create create() {
				return new Create((String) null);
			}

			public Create create(String name) {
				return new Create(name);
			}

			public LegioGraph graph() {
				return (LegioGraph) this.core$().graph().as(LegioGraph.class);
			}

			public class Create extends Library.Create {
				public Create(String name) {
					super( name);
				}
			}

			public static class ArtifactVersionFollower extends Layer implements Terminal {
				protected String version;
				protected Web _web;

				public ArtifactVersionFollower(Node node) {
					super(node);
				}

				public String version() {
					return this.version;
				}

				public boolean resolved() {
					return this._web.resolved();
				}

				public ArtifactVersionFollower version(String value) {
					this.version = value;
					return this;
				}

				public ArtifactVersionFollower resolved(boolean value) {
					this._web.resolved(value);
					return this;
				}

				public Web asWeb() {
					return (Web) this.a$(Web.class);
				}

				protected Map<String, List<?>> variables$() {
					Map<String, List<?>> map = new LinkedHashMap();
					map.put("version", new ArrayList(Collections.singletonList(this.version)));
					return map;
				}

				protected void load$(String name, List<?> values) {
					super.load$(name, values);
					if (name.equalsIgnoreCase("version")) {
						this.version = (String) StringLoader.load(values, this).get(0);
					}

				}

				protected void set$(String name, List<?> values) {
					super.set$(name, values);
					if (name.equalsIgnoreCase("version")) {
						this.version = (String) values.get(0);
					}

				}

				protected void sync$(Layer layer) {
					super.sync$(layer);
					if (layer instanceof Web) {
						this._web = (Web) layer;
					}

				}

				public LegioGraph graph() {
					return (LegioGraph) this.core$().graph().as(LegioGraph.class);
				}
			}
		}
	}

	public static class WebImports extends Layer implements Terminal {
		protected String webDirectory;
		protected List<Resolution> resolutionList = new ArrayList();
		protected List<WebComponent> webComponentList = new ArrayList();
		protected List<WebArtifact> webArtifactList = new ArrayList();

		public WebImports(Node node) {
			super(node);
		}

		public String webDirectory() {
			return this.webDirectory;
		}

		public WebImports webDirectory(String value) {
			this.webDirectory = value;
			return this;
		}

		public List<Resolution> resolutionList() {
			return Collections.unmodifiableList(this.resolutionList);
		}

		public Resolution resolution(int index) {
			return (Resolution) this.resolutionList.get(index);
		}

		public List<Resolution> resolutionList(Predicate<Resolution> predicate) {
			return (List) this.resolutionList().stream().filter(predicate).collect(Collectors.toList());
		}

		public Resolution resolution(Predicate<Resolution> predicate) {
			return (Resolution) this.resolutionList().stream().filter(predicate).findFirst().orElse(null);
		}

		public List<WebComponent> webComponentList() {
			return Collections.unmodifiableList(this.webComponentList);
		}

		public WebComponent webComponent(int index) {
			return (WebComponent) this.webComponentList.get(index);
		}

		public List<WebComponent> webComponentList(Predicate<WebComponent> predicate) {
			return (List) this.webComponentList().stream().filter(predicate).collect(Collectors.toList());
		}

		public WebComponent webComponent(Predicate<WebComponent> predicate) {
			return (WebComponent) this.webComponentList().stream().filter(predicate).findFirst().orElse(null);
		}

		public List<WebArtifact> webArtifactList() {
			return Collections.unmodifiableList(this.webArtifactList);
		}

		public WebArtifact webArtifact(int index) {
			return (WebArtifact) this.webArtifactList.get(index);
		}

		public List<WebArtifact> webArtifactList(Predicate<WebArtifact> predicate) {
			return (List) this.webArtifactList().stream().filter(predicate).collect(Collectors.toList());
		}

		public WebArtifact webArtifact(Predicate<WebArtifact> predicate) {
			return (WebArtifact) this.webArtifactList().stream().filter(predicate).findFirst().orElse(null);
		}

		protected List<Node> componentList$() {
			Set<Node> components = new LinkedHashSet(super.componentList$());
			(new ArrayList<>(this.resolutionList)).forEach((c) -> components.add(c.core$()));
			(new ArrayList<>(this.webComponentList)).forEach((c) -> components.add(c.core$()));
			(new ArrayList<>(this.webArtifactList)).forEach((c) -> components.add(c.core$()));
			return new ArrayList(components);
		}

		protected Map<String, List<?>> variables$() {
			Map<String, List<?>> map = new LinkedHashMap();
			map.put("webDirectory", new ArrayList(Collections.singletonList(this.webDirectory)));
			return map;
		}

		protected void addNode$(Node node) {
			super.addNode$(node);
			if (node.is("Artifact$WebImports$Resolution")) {
				this.resolutionList.add((Resolution) node.as(Resolution.class));
			}

			if (node.is("Artifact$WebImports$WebComponent")) {
				this.webComponentList.add((WebComponent) node.as(WebComponent.class));
			}

			if (node.is("Artifact$WebImports$WebArtifact")) {
				this.webArtifactList.add((WebArtifact) node.as(WebArtifact.class));
			}

		}

		protected void removeNode$(Node node) {
			super.removeNode$(node);
			if (node.is("Artifact$WebImports$Resolution")) {
				this.resolutionList.remove(node.as(Resolution.class));
			}

			if (node.is("Artifact$WebImports$WebComponent")) {
				this.webComponentList.remove(node.as(WebComponent.class));
			}

			if (node.is("Artifact$WebImports$WebArtifact")) {
				this.webArtifactList.remove(node.as(WebArtifact.class));
			}

		}

		protected void load$(String name, List<?> values) {
			super.load$(name, values);
			if (name.equalsIgnoreCase("webDirectory")) {
				this.webDirectory = (String) StringLoader.load(values, this).get(0);
			}

		}

		protected void set$(String name, List<?> values) {
			super.set$(name, values);
			if (name.equalsIgnoreCase("webDirectory")) {
				this.webDirectory = (String) values.get(0);
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

			public Resolution resolution(String name, String version) {
				Resolution newElement = (Resolution) WebImports.this.core$().graph().concept(Resolution.class).createNode(this.name, WebImports.this.core$()).as(Resolution.class);
				newElement.core$().set(newElement, "name", Collections.singletonList(name));
				newElement.core$().set(newElement, "version", Collections.singletonList(version));
				return newElement;
			}

			public WebComponent webComponent(String version) {
				WebComponent newElement = (WebComponent) WebImports.this.core$().graph().concept(WebComponent.class).createNode(this.name, WebImports.this.core$()).as(WebComponent.class);
				newElement.core$().set(newElement, "version", Collections.singletonList(version));
				return newElement;
			}

			public WebArtifact webArtifact(String groupId, String artifactId, String version) {
				WebArtifact newElement = (WebArtifact) WebImports.this.core$().graph().concept(WebArtifact.class).createNode(this.name, WebImports.this.core$()).as(WebArtifact.class);
				newElement.core$().set(newElement, "groupId", Collections.singletonList(groupId));
				newElement.core$().set(newElement, "artifactId", Collections.singletonList(artifactId));
				newElement.core$().set(newElement, "version", Collections.singletonList(version));
				return newElement;
			}
		}

		public class Clear {
			public void resolution(Predicate<Resolution> filter) {
				(new ArrayList<>(WebImports.this.resolutionList())).stream().filter(filter).forEach(Layer::delete$);
			}

			public void webComponent(Predicate<WebComponent> filter) {
				(new ArrayList<>(WebImports.this.webComponentList())).stream().filter(filter).forEach(Layer::delete$);
			}

			public void webArtifact(Predicate<WebArtifact> filter) {
				(new ArrayList<>(WebImports.this.webArtifactList())).stream().filter(filter).forEach(Layer::delete$);
			}
		}

		public static class Resolution extends Layer implements Terminal {
			protected String name;
			protected String version;

			public Resolution(Node node) {
				super(node);
			}

			public String name() {
				return this.name;
			}

			public String version() {
				return this.version;
			}

			public Resolution name(String value) {
				this.name = value;
				return this;
			}

			public Resolution version(String value) {
				this.version = value;
				return this;
			}

			protected Map<String, List<?>> variables$() {
				Map<String, List<?>> map = new LinkedHashMap();
				map.put("name", new ArrayList(Collections.singletonList(this.name)));
				map.put("version", new ArrayList(Collections.singletonList(this.version)));
				return map;
			}

			protected void load$(String name, List<?> values) {
				super.load$(name, values);
				if (name.equalsIgnoreCase("name")) {
					this.name = (String) StringLoader.load(values, this).get(0);
				} else if (name.equalsIgnoreCase("version")) {
					this.version = (String) StringLoader.load(values, this).get(0);
				}

			}

			protected void set$(String name, List<?> values) {
				super.set$(name, values);
				if (name.equalsIgnoreCase("name")) {
					this.name = (String) values.get(0);
				} else if (name.equalsIgnoreCase("version")) {
					this.version = (String) values.get(0);
				}

			}

			public LegioGraph graph() {
				return (LegioGraph) this.core$().graph().as(LegioGraph.class);
			}
		}

		public static class WebComponent extends Layer implements Terminal {
			protected String url;
			protected String version;

			public WebComponent(Node node) {
				super(node);
			}

			public String url() {
				return this.url;
			}

			public String version() {
				return this.version;
			}

			public WebComponent url(String value) {
				this.url = value;
				return this;
			}

			public WebComponent version(String value) {
				this.version = value;
				return this;
			}

			protected Map<String, List<?>> variables$() {
				Map<String, List<?>> map = new LinkedHashMap();
				map.put("url", new ArrayList(Collections.singletonList(this.url)));
				map.put("version", new ArrayList(Collections.singletonList(this.version)));
				return map;
			}

			protected void load$(String name, List<?> values) {
				super.load$(name, values);
				if (name.equalsIgnoreCase("url")) {
					this.url = (String) StringLoader.load(values, this).get(0);
				} else if (name.equalsIgnoreCase("version")) {
					this.version = (String) StringLoader.load(values, this).get(0);
				}

			}

			protected void set$(String name, List<?> values) {
				super.set$(name, values);
				if (name.equalsIgnoreCase("url")) {
					this.url = (String) values.get(0);
				} else if (name.equalsIgnoreCase("version")) {
					this.version = (String) values.get(0);
				}

			}

			public LegioGraph graph() {
				return (LegioGraph) this.core$().graph().as(LegioGraph.class);
			}
		}

		public static class WebArtifact extends Library implements Terminal {
			public WebArtifact(Node node) {
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
				return (LegioGraph) this.core$().graph().as(LegioGraph.class);
			}
		}
	}

	public static class Code extends Layer implements Terminal {
		protected String targetPackage;

		public Code(Node node) {
			super(node);
		}

		public String targetPackage() {
			return this.targetPackage;
		}

		public Code targetPackage(String value) {
			this.targetPackage = value;
			return this;
		}

		protected Map<String, List<?>> variables$() {
			Map<String, List<?>> map = new LinkedHashMap();
			map.put("targetPackage", new ArrayList(Collections.singletonList(this.targetPackage)));
			return map;
		}

		protected void load$(String name, List<?> values) {
			super.load$(name, values);
			if (name.equalsIgnoreCase("targetPackage")) {
				this.targetPackage = (String) StringLoader.load(values, this).get(0);
			}

		}

		protected void set$(String name, List<?> values) {
			super.set$(name, values);
			if (name.equalsIgnoreCase("targetPackage")) {
				this.targetPackage = (String) values.get(0);
			}

		}

		public LegioGraph graph() {
			return (LegioGraph) this.core$().graph().as(LegioGraph.class);
		}
	}

	public static class IntinoPlugin extends Library implements Terminal {
		protected Phase phase;

		public IntinoPlugin(Node node) {
			super(node);
		}

		public Phase phase() {
			return this.phase;
		}

		public IntinoPlugin phase(Phase value) {
			this.phase = value;
			return this;
		}

		protected Map<String, List<?>> variables$() {
			Map<String, List<?>> map = new LinkedHashMap(super.variables$());
			map.put("phase", new ArrayList(Collections.singletonList(this.phase)));
			return map;
		}

		protected void load$(String name, List<?> values) {
			super.load$(name, values);
			if (name.equalsIgnoreCase("phase")) {
				this.phase = (Phase) WordLoader.load(values, Phase.class, this).get(0);
			}

		}

		protected void set$(String name, List<?> values) {
			super.set$(name, values);
			if (name.equalsIgnoreCase("phase")) {
				this.phase = (Phase) values.get(0);
			}

		}

		public LegioGraph graph() {
			return (LegioGraph) this.core$().graph().as(LegioGraph.class);
		}

		public static enum Phase {
			Export,
			PostCompilation,
			PrePackage,
			PostPackage,
			PostDistribution;
		}
	}

	public static class Package extends Layer implements Terminal {
		protected Mode mode;
		protected boolean createMavenPom;
		protected boolean attachSources;
		protected boolean attachDoc;
		protected boolean includeTests;
		protected boolean signArtifactWithGpg;
		protected String classpathPrefix;
		protected String finalName;
		protected String defaultJVMOptions;
		protected List<MavenPlugin> mavenPluginList = new ArrayList();
		protected Runnable _runnable;
		protected MacOSApp _macOSApp;
		protected WindowsApp _windowsApp;
		protected LinuxService _linuxService;

		public Package(Node node) {
			super(node);
		}

		public Mode mode() {
			return this.mode;
		}

		public boolean createMavenPom() {
			return this.createMavenPom;
		}

		public boolean attachSources() {
			return this.attachSources;
		}

		public boolean attachDoc() {
			return this.attachDoc;
		}

		public boolean includeTests() {
			return this.includeTests;
		}

		public boolean signArtifactWithGpg() {
			return this.signArtifactWithGpg;
		}

		public String classpathPrefix() {
			return this.classpathPrefix;
		}

		public String finalName() {
			return this.finalName;
		}

		public String defaultJVMOptions() {
			return this.defaultJVMOptions;
		}

		public Package mode(Mode value) {
			this.mode = value;
			return this;
		}

		public Package createMavenPom(boolean value) {
			this.createMavenPom = value;
			return this;
		}

		public Package attachSources(boolean value) {
			this.attachSources = value;
			return this;
		}

		public Package attachDoc(boolean value) {
			this.attachDoc = value;
			return this;
		}

		public Package includeTests(boolean value) {
			this.includeTests = value;
			return this;
		}

		public Package signArtifactWithGpg(boolean value) {
			this.signArtifactWithGpg = value;
			return this;
		}

		public Package classpathPrefix(String value) {
			this.classpathPrefix = value;
			return this;
		}

		public Package finalName(String value) {
			this.finalName = value;
			return this;
		}

		public Package defaultJVMOptions(String value) {
			this.defaultJVMOptions = value;
			return this;
		}

		public List<MavenPlugin> mavenPluginList() {
			return Collections.unmodifiableList(this.mavenPluginList);
		}

		public MavenPlugin mavenPlugin(int index) {
			return (MavenPlugin) this.mavenPluginList.get(index);
		}

		public List<MavenPlugin> mavenPluginList(Predicate<MavenPlugin> predicate) {
			return (List) this.mavenPluginList().stream().filter(predicate).collect(Collectors.toList());
		}

		public MavenPlugin mavenPlugin(Predicate<MavenPlugin> predicate) {
			return (MavenPlugin) this.mavenPluginList().stream().filter(predicate).findFirst().orElse(null);
		}

		public WindowsApp asWindowsApp() {
			return (WindowsApp) this.a$(WindowsApp.class);
		}

		public WindowsApp asWindowsApp(String windowsIcon) {
			WindowsApp newElement = (WindowsApp) this.core$().addAspect(WindowsApp.class);
			newElement.core$().set(newElement, "windowsIcon", Collections.singletonList(windowsIcon));
			return newElement;
		}

		public boolean isWindowsApp() {
			return this.core$().is(WindowsApp.class);
		}

		public void removeWindowsApp() {
			this.core$().removeAspect(WindowsApp.class);
		}

		public LinuxService asLinuxService() {
			return (LinuxService) this.a$(LinuxService.class);
		}

		public LinuxService asLinuxService(String user, RunConfiguration runConfiguration, boolean restartOnFailure, int managementPort) {
			LinuxService newElement = (LinuxService) this.core$().addAspect(LinuxService.class);
			newElement.core$().set(newElement, "user", Collections.singletonList(user));
			newElement.core$().set(newElement, "runConfiguration", Collections.singletonList(runConfiguration));
			newElement.core$().set(newElement, "restartOnFailure", Collections.singletonList(restartOnFailure));
			newElement.core$().set(newElement, "managementPort", Collections.singletonList(managementPort));
			return newElement;
		}

		public boolean isLinuxService() {
			return this.core$().is(LinuxService.class);
		}

		public void removeLinuxService() {
			this.core$().removeAspect(LinuxService.class);
		}

		public Runnable asRunnable() {
			return (Runnable) this.a$(Runnable.class);
		}

		public Runnable asRunnable(String mainClass) {
			Runnable newElement = (Runnable) this.core$().addAspect(Runnable.class);
			newElement.core$().set(newElement, "mainClass", Collections.singletonList(mainClass));
			return newElement;
		}

		public boolean isRunnable() {
			return this.core$().is(Runnable.class);
		}

		public void removeRunnable() {
			this.core$().removeAspect(Runnable.class);
		}

		public MacOSApp asMacOSApp() {
			return (MacOSApp) this.a$(MacOSApp.class);
		}

		public MacOSApp asMacOSApp(String macIcon) {
			MacOSApp newElement = (MacOSApp) this.core$().addAspect(MacOSApp.class);
			newElement.core$().set(newElement, "macIcon", Collections.singletonList(macIcon));
			return newElement;
		}

		public boolean isMacOSApp() {
			return this.core$().is(MacOSApp.class);
		}

		public void removeMacOSApp() {
			this.core$().removeAspect(MacOSApp.class);
		}

		protected List<Node> componentList$() {
			Set<Node> components = new LinkedHashSet(super.componentList$());
			(new ArrayList<>(this.mavenPluginList)).forEach((c) -> components.add(c.core$()));
			return new ArrayList(components);
		}

		protected Map<String, List<?>> variables$() {
			Map<String, List<?>> map = new LinkedHashMap();
			map.put("mode", new ArrayList(Collections.singletonList(this.mode)));
			map.put("createMavenPom", new ArrayList(Collections.singletonList(this.createMavenPom)));
			map.put("attachSources", new ArrayList(Collections.singletonList(this.attachSources)));
			map.put("attachDoc", new ArrayList(Collections.singletonList(this.attachDoc)));
			map.put("includeTests", new ArrayList(Collections.singletonList(this.includeTests)));
			map.put("signArtifactWithGpg", new ArrayList(Collections.singletonList(this.signArtifactWithGpg)));
			map.put("classpathPrefix", new ArrayList(Collections.singletonList(this.classpathPrefix)));
			map.put("finalName", new ArrayList(Collections.singletonList(this.finalName)));
			map.put("defaultJVMOptions", new ArrayList(Collections.singletonList(this.defaultJVMOptions)));
			return map;
		}

		protected void addNode$(Node node) {
			super.addNode$(node);
			if (node.is("Artifact$Package$MavenPlugin")) {
				this.mavenPluginList.add((MavenPlugin) node.as(MavenPlugin.class));
			}

		}

		protected void removeNode$(Node node) {
			super.removeNode$(node);
			if (node.is("Artifact$Package$MavenPlugin")) {
				this.mavenPluginList.remove(node.as(MavenPlugin.class));
			}

		}

		protected void load$(String name, List<?> values) {
			super.load$(name, values);
			if (name.equalsIgnoreCase("mode")) {
				this.mode = (Mode) WordLoader.load(values, Mode.class, this).get(0);
			} else if (name.equalsIgnoreCase("createMavenPom")) {
				this.createMavenPom = (Boolean) BooleanLoader.load(values, this).get(0);
			} else if (name.equalsIgnoreCase("attachSources")) {
				this.attachSources = (Boolean) BooleanLoader.load(values, this).get(0);
			} else if (name.equalsIgnoreCase("attachDoc")) {
				this.attachDoc = (Boolean) BooleanLoader.load(values, this).get(0);
			} else if (name.equalsIgnoreCase("includeTests")) {
				this.includeTests = (Boolean) BooleanLoader.load(values, this).get(0);
			} else if (name.equalsIgnoreCase("signArtifactWithGpg")) {
				this.signArtifactWithGpg = (Boolean) BooleanLoader.load(values, this).get(0);
			} else if (name.equalsIgnoreCase("classpathPrefix")) {
				this.classpathPrefix = (String) StringLoader.load(values, this).get(0);
			} else if (name.equalsIgnoreCase("finalName")) {
				this.finalName = (String) StringLoader.load(values, this).get(0);
			} else if (name.equalsIgnoreCase("defaultJVMOptions")) {
				this.defaultJVMOptions = (String) StringLoader.load(values, this).get(0);
			}

		}

		protected void set$(String name, List<?> values) {
			super.set$(name, values);
			if (name.equalsIgnoreCase("mode")) {
				this.mode = (Mode) values.get(0);
			} else if (name.equalsIgnoreCase("createMavenPom")) {
				this.createMavenPom = (Boolean) values.get(0);
			} else if (name.equalsIgnoreCase("attachSources")) {
				this.attachSources = (Boolean) values.get(0);
			} else if (name.equalsIgnoreCase("attachDoc")) {
				this.attachDoc = (Boolean) values.get(0);
			} else if (name.equalsIgnoreCase("includeTests")) {
				this.includeTests = (Boolean) values.get(0);
			} else if (name.equalsIgnoreCase("signArtifactWithGpg")) {
				this.signArtifactWithGpg = (Boolean) values.get(0);
			} else if (name.equalsIgnoreCase("classpathPrefix")) {
				this.classpathPrefix = (String) values.get(0);
			} else if (name.equalsIgnoreCase("finalName")) {
				this.finalName = (String) values.get(0);
			} else if (name.equalsIgnoreCase("defaultJVMOptions")) {
				this.defaultJVMOptions = (String) values.get(0);
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

		public static enum Mode {
			ModulesAndLibrariesExtracted,
			LibrariesLinkedByManifest,
			ModulesAndLibrariesLinkedByManifest;
		}

		public class Create {
			protected final String name;

			public Create(String name) {
				this.name = name;
			}

			public MavenPlugin mavenPlugin(String code) {
				MavenPlugin newElement = (MavenPlugin) Package.this.core$().graph().concept(MavenPlugin.class).createNode(this.name, Package.this.core$()).as(MavenPlugin.class);
				newElement.core$().set(newElement, "code", Collections.singletonList(code));
				return newElement;
			}
		}

		public class Clear {
			public void mavenPlugin(Predicate<MavenPlugin> filter) {
				(new ArrayList<>(Package.this.mavenPluginList())).stream().filter(filter).forEach(Layer::delete$);
			}
		}

		public static class MavenPlugin extends Layer implements Terminal {
			protected String code;

			public MavenPlugin(Node node) {
				super(node);
			}

			public String code() {
				return this.code;
			}

			public MavenPlugin code(String value) {
				this.code = value;
				return this;
			}

			protected Map<String, List<?>> variables$() {
				Map<String, List<?>> map = new LinkedHashMap();
				map.put("code", new ArrayList(Collections.singletonList(this.code)));
				return map;
			}

			protected void load$(String name, List<?> values) {
				super.load$(name, values);
				if (name.equalsIgnoreCase("code")) {
					this.code = (String) StringLoader.load(values, this).get(0);
				}

			}

			protected void set$(String name, List<?> values) {
				super.set$(name, values);
				if (name.equalsIgnoreCase("code")) {
					this.code = (String) values.get(0);
				}

			}

			public LegioGraph graph() {
				return (LegioGraph) this.core$().graph().as(LegioGraph.class);
			}
		}

		public static class Runnable extends Layer implements Terminal {
			protected String mainClass;
			protected Package _package;

			public Runnable(Node node) {
				super(node);
			}

			public String mainClass() {
				return this.mainClass;
			}

			public Mode mode() {
				return this._package.mode();
			}

			public boolean createMavenPom() {
				return this._package.createMavenPom();
			}

			public boolean attachSources() {
				return this._package.attachSources();
			}

			public boolean attachDoc() {
				return this._package.attachDoc();
			}

			public boolean includeTests() {
				return this._package.includeTests();
			}

			public boolean signArtifactWithGpg() {
				return this._package.signArtifactWithGpg();
			}

			public String classpathPrefix() {
				return this._package.classpathPrefix();
			}

			public String finalName() {
				return this._package.finalName();
			}

			public String defaultJVMOptions() {
				return this._package.defaultJVMOptions();
			}

			public Runnable mainClass(String value) {
				this.mainClass = value;
				return this;
			}

			public Runnable mode(Mode value) {
				this._package.mode(value);
				return this;
			}

			public Runnable createMavenPom(boolean value) {
				this._package.createMavenPom(value);
				return this;
			}

			public Runnable attachSources(boolean value) {
				this._package.attachSources(value);
				return this;
			}

			public Runnable attachDoc(boolean value) {
				this._package.attachDoc(value);
				return this;
			}

			public Runnable includeTests(boolean value) {
				this._package.includeTests(value);
				return this;
			}

			public Runnable signArtifactWithGpg(boolean value) {
				this._package.signArtifactWithGpg(value);
				return this;
			}

			public Runnable classpathPrefix(String value) {
				this._package.classpathPrefix(value);
				return this;
			}

			public Runnable finalName(String value) {
				this._package.finalName(value);
				return this;
			}

			public Runnable defaultJVMOptions(String value) {
				this._package.defaultJVMOptions(value);
				return this;
			}

			public List<MavenPlugin> mavenPluginList() {
				return this._package.mavenPluginList();
			}

			public MavenPlugin mavenPluginList(int index) {
				return (MavenPlugin) this._package.mavenPluginList().get(index);
			}

			public Package asPackage() {
				return (Package) this.a$(Package.class);
			}

			protected Map<String, List<?>> variables$() {
				Map<String, List<?>> map = new LinkedHashMap();
				map.put("mainClass", new ArrayList(Collections.singletonList(this.mainClass)));
				return map;
			}

			protected void load$(String name, List<?> values) {
				super.load$(name, values);
				if (name.equalsIgnoreCase("mainClass")) {
					this.mainClass = (String) StringLoader.load(values, this).get(0);
				}

			}

			protected void set$(String name, List<?> values) {
				super.set$(name, values);
				if (name.equalsIgnoreCase("mainClass")) {
					this.mainClass = (String) values.get(0);
				}

			}

			protected void sync$(Layer layer) {
				super.sync$(layer);
				if (layer instanceof Package) {
					this._package = (Package) layer;
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

				public MavenPlugin mavenPlugin(String code) {
					MavenPlugin newElement = (MavenPlugin) Runnable.this.core$().graph().concept(MavenPlugin.class).createNode(this.name, Runnable.this.core$()).as(MavenPlugin.class);
					newElement.core$().set(newElement, "code", Collections.singletonList(code));
					return newElement;
				}
			}

			public class Clear {
				public void mavenPlugin(Predicate<MavenPlugin> filter) {
					(new ArrayList<>(Runnable.this.mavenPluginList())).stream().filter(filter).forEach(Layer::delete$);
				}
			}
		}

		public static class MacOSApp extends Layer implements Terminal {
			protected String macIcon;
			protected String resourceDirectory;
			protected Package _package;

			public MacOSApp(Node node) {
				super(node);
			}

			public String macIcon() {
				return this.macIcon;
			}

			public String resourceDirectory() {
				return this.resourceDirectory;
			}

			public Mode mode() {
				return this._package.mode();
			}

			public boolean createMavenPom() {
				return this._package.createMavenPom();
			}

			public boolean attachSources() {
				return this._package.attachSources();
			}

			public boolean attachDoc() {
				return this._package.attachDoc();
			}

			public boolean includeTests() {
				return this._package.includeTests();
			}

			public boolean signArtifactWithGpg() {
				return this._package.signArtifactWithGpg();
			}

			public String classpathPrefix() {
				return this._package.classpathPrefix();
			}

			public String finalName() {
				return this._package.finalName();
			}

			public String defaultJVMOptions() {
				return this._package.defaultJVMOptions();
			}

			public MacOSApp macIcon(String value) {
				this.macIcon = value;
				return this;
			}

			public MacOSApp resourceDirectory(String value) {
				this.resourceDirectory = value;
				return this;
			}

			public MacOSApp mode(Mode value) {
				this._package.mode(value);
				return this;
			}

			public MacOSApp createMavenPom(boolean value) {
				this._package.createMavenPom(value);
				return this;
			}

			public MacOSApp attachSources(boolean value) {
				this._package.attachSources(value);
				return this;
			}

			public MacOSApp attachDoc(boolean value) {
				this._package.attachDoc(value);
				return this;
			}

			public MacOSApp includeTests(boolean value) {
				this._package.includeTests(value);
				return this;
			}

			public MacOSApp signArtifactWithGpg(boolean value) {
				this._package.signArtifactWithGpg(value);
				return this;
			}

			public MacOSApp classpathPrefix(String value) {
				this._package.classpathPrefix(value);
				return this;
			}

			public MacOSApp finalName(String value) {
				this._package.finalName(value);
				return this;
			}

			public MacOSApp defaultJVMOptions(String value) {
				this._package.defaultJVMOptions(value);
				return this;
			}

			public List<MavenPlugin> mavenPluginList() {
				return this._package.mavenPluginList();
			}

			public MavenPlugin mavenPluginList(int index) {
				return (MavenPlugin) this._package.mavenPluginList().get(index);
			}

			public Package asPackage() {
				return (Package) this.a$(Package.class);
			}

			protected Map<String, List<?>> variables$() {
				Map<String, List<?>> map = new LinkedHashMap();
				map.put("macIcon", new ArrayList(Collections.singletonList(this.macIcon)));
				map.put("resourceDirectory", new ArrayList(Collections.singletonList(this.resourceDirectory)));
				return map;
			}

			protected void load$(String name, List<?> values) {
				super.load$(name, values);
				if (name.equalsIgnoreCase("macIcon")) {
					this.macIcon = (String) StringLoader.load(values, this).get(0);
				} else if (name.equalsIgnoreCase("resourceDirectory")) {
					this.resourceDirectory = (String) StringLoader.load(values, this).get(0);
				}

			}

			protected void set$(String name, List<?> values) {
				super.set$(name, values);
				if (name.equalsIgnoreCase("macIcon")) {
					this.macIcon = (String) values.get(0);
				} else if (name.equalsIgnoreCase("resourceDirectory")) {
					this.resourceDirectory = (String) values.get(0);
				}

			}

			protected void sync$(Layer layer) {
				super.sync$(layer);
				if (layer instanceof Package) {
					this._package = (Package) layer;
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

				public MavenPlugin mavenPlugin(String code) {
					MavenPlugin newElement = (MavenPlugin) MacOSApp.this.core$().graph().concept(MavenPlugin.class).createNode(this.name, MacOSApp.this.core$()).as(MavenPlugin.class);
					newElement.core$().set(newElement, "code", Collections.singletonList(code));
					return newElement;
				}
			}

			public class Clear {
				public void mavenPlugin(Predicate<MavenPlugin> filter) {
					(new ArrayList<>(MacOSApp.this.mavenPluginList())).stream().filter(filter).forEach(Layer::delete$);
				}
			}
		}

		public static class WindowsApp extends Layer implements Terminal {
			protected String windowsIcon;
			protected Package _package;

			public WindowsApp(Node node) {
				super(node);
			}

			public String windowsIcon() {
				return this.windowsIcon;
			}

			public Mode mode() {
				return this._package.mode();
			}

			public boolean createMavenPom() {
				return this._package.createMavenPom();
			}

			public boolean attachSources() {
				return this._package.attachSources();
			}

			public boolean attachDoc() {
				return this._package.attachDoc();
			}

			public boolean includeTests() {
				return this._package.includeTests();
			}

			public boolean signArtifactWithGpg() {
				return this._package.signArtifactWithGpg();
			}

			public String classpathPrefix() {
				return this._package.classpathPrefix();
			}

			public String finalName() {
				return this._package.finalName();
			}

			public String defaultJVMOptions() {
				return this._package.defaultJVMOptions();
			}

			public WindowsApp windowsIcon(String value) {
				this.windowsIcon = value;
				return this;
			}

			public WindowsApp mode(Mode value) {
				this._package.mode(value);
				return this;
			}

			public WindowsApp createMavenPom(boolean value) {
				this._package.createMavenPom(value);
				return this;
			}

			public WindowsApp attachSources(boolean value) {
				this._package.attachSources(value);
				return this;
			}

			public WindowsApp attachDoc(boolean value) {
				this._package.attachDoc(value);
				return this;
			}

			public WindowsApp includeTests(boolean value) {
				this._package.includeTests(value);
				return this;
			}

			public WindowsApp signArtifactWithGpg(boolean value) {
				this._package.signArtifactWithGpg(value);
				return this;
			}

			public WindowsApp classpathPrefix(String value) {
				this._package.classpathPrefix(value);
				return this;
			}

			public WindowsApp finalName(String value) {
				this._package.finalName(value);
				return this;
			}

			public WindowsApp defaultJVMOptions(String value) {
				this._package.defaultJVMOptions(value);
				return this;
			}

			public List<MavenPlugin> mavenPluginList() {
				return this._package.mavenPluginList();
			}

			public MavenPlugin mavenPluginList(int index) {
				return (MavenPlugin) this._package.mavenPluginList().get(index);
			}

			public Package asPackage() {
				return (Package) this.a$(Package.class);
			}

			protected Map<String, List<?>> variables$() {
				Map<String, List<?>> map = new LinkedHashMap();
				map.put("windowsIcon", new ArrayList(Collections.singletonList(this.windowsIcon)));
				return map;
			}

			protected void load$(String name, List<?> values) {
				super.load$(name, values);
				if (name.equalsIgnoreCase("windowsIcon")) {
					this.windowsIcon = (String) StringLoader.load(values, this).get(0);
				}

			}

			protected void set$(String name, List<?> values) {
				super.set$(name, values);
				if (name.equalsIgnoreCase("windowsIcon")) {
					this.windowsIcon = (String) values.get(0);
				}

			}

			protected void sync$(Layer layer) {
				super.sync$(layer);
				if (layer instanceof Package) {
					this._package = (Package) layer;
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

				public MavenPlugin mavenPlugin(String code) {
					MavenPlugin newElement = (MavenPlugin) WindowsApp.this.core$().graph().concept(MavenPlugin.class).createNode(this.name, WindowsApp.this.core$()).as(MavenPlugin.class);
					newElement.core$().set(newElement, "code", Collections.singletonList(code));
					return newElement;
				}
			}

			public class Clear {
				public void mavenPlugin(Predicate<MavenPlugin> filter) {
					(new ArrayList<>(WindowsApp.this.mavenPluginList())).stream().filter(filter).forEach(Layer::delete$);
				}
			}
		}

		public static class LinuxService extends Layer implements Terminal {
			protected String user;
			protected RunConfiguration runConfiguration;
			protected boolean restartOnFailure;
			protected int managementPort;
			protected Package _package;

			public LinuxService(Node node) {
				super(node);
			}

			public String user() {
				return this.user;
			}

			public RunConfiguration runConfiguration() {
				return this.runConfiguration;
			}

			public boolean restartOnFailure() {
				return this.restartOnFailure;
			}

			public int managementPort() {
				return this.managementPort;
			}

			public Mode mode() {
				return this._package.mode();
			}

			public boolean createMavenPom() {
				return this._package.createMavenPom();
			}

			public boolean attachSources() {
				return this._package.attachSources();
			}

			public boolean attachDoc() {
				return this._package.attachDoc();
			}

			public boolean includeTests() {
				return this._package.includeTests();
			}

			public boolean signArtifactWithGpg() {
				return this._package.signArtifactWithGpg();
			}

			public String classpathPrefix() {
				return this._package.classpathPrefix();
			}

			public String finalName() {
				return this._package.finalName();
			}

			public String defaultJVMOptions() {
				return this._package.defaultJVMOptions();
			}

			public LinuxService user(String value) {
				this.user = value;
				return this;
			}

			public LinuxService runConfiguration(RunConfiguration value) {
				this.runConfiguration = value;
				return this;
			}

			public LinuxService restartOnFailure(boolean value) {
				this.restartOnFailure = value;
				return this;
			}

			public LinuxService managementPort(int value) {
				this.managementPort = value;
				return this;
			}

			public LinuxService mode(Mode value) {
				this._package.mode(value);
				return this;
			}

			public LinuxService createMavenPom(boolean value) {
				this._package.createMavenPom(value);
				return this;
			}

			public LinuxService attachSources(boolean value) {
				this._package.attachSources(value);
				return this;
			}

			public LinuxService attachDoc(boolean value) {
				this._package.attachDoc(value);
				return this;
			}

			public LinuxService includeTests(boolean value) {
				this._package.includeTests(value);
				return this;
			}

			public LinuxService signArtifactWithGpg(boolean value) {
				this._package.signArtifactWithGpg(value);
				return this;
			}

			public LinuxService classpathPrefix(String value) {
				this._package.classpathPrefix(value);
				return this;
			}

			public LinuxService finalName(String value) {
				this._package.finalName(value);
				return this;
			}

			public LinuxService defaultJVMOptions(String value) {
				this._package.defaultJVMOptions(value);
				return this;
			}

			public List<MavenPlugin> mavenPluginList() {
				return this._package.mavenPluginList();
			}

			public MavenPlugin mavenPluginList(int index) {
				return (MavenPlugin) this._package.mavenPluginList().get(index);
			}

			public Package asPackage() {
				return (Package) this.a$(Package.class);
			}

			protected Map<String, List<?>> variables$() {
				Map<String, List<?>> map = new LinkedHashMap();
				map.put("user", new ArrayList(Collections.singletonList(this.user)));
				map.put("runConfiguration", this.runConfiguration != null ? new ArrayList(Collections.singletonList(this.runConfiguration)) : Collections.emptyList());
				map.put("restartOnFailure", new ArrayList(Collections.singletonList(this.restartOnFailure)));
				map.put("managementPort", new ArrayList(Collections.singletonList(this.managementPort)));
				return map;
			}

			protected void load$(String name, List<?> values) {
				super.load$(name, values);
				if (name.equalsIgnoreCase("user")) {
					this.user = (String) StringLoader.load(values, this).get(0);
				} else if (name.equalsIgnoreCase("runConfiguration")) {
					this.runConfiguration = (RunConfiguration) NodeLoader.load(values, RunConfiguration.class, this).get(0);
				} else if (name.equalsIgnoreCase("restartOnFailure")) {
					this.restartOnFailure = (Boolean) BooleanLoader.load(values, this).get(0);
				} else if (name.equalsIgnoreCase("managementPort")) {
					this.managementPort = (Integer) IntegerLoader.load(values, this).get(0);
				}

			}

			protected void set$(String name, List<?> values) {
				super.set$(name, values);
				if (name.equalsIgnoreCase("user")) {
					this.user = (String) values.get(0);
				} else if (name.equalsIgnoreCase("runConfiguration")) {
					this.runConfiguration = values.get(0) != null ? (RunConfiguration) this.core$().graph().load(((Layer) values.get(0)).core$().id()).as(RunConfiguration.class) : null;
				} else if (name.equalsIgnoreCase("restartOnFailure")) {
					this.restartOnFailure = (Boolean) values.get(0);
				} else if (name.equalsIgnoreCase("managementPort")) {
					this.managementPort = (Integer) values.get(0);
				}

			}

			protected void sync$(Layer layer) {
				super.sync$(layer);
				if (layer instanceof Package) {
					this._package = (Package) layer;
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

				public MavenPlugin mavenPlugin(String code) {
					MavenPlugin newElement = (MavenPlugin) LinuxService.this.core$().graph().concept(MavenPlugin.class).createNode(this.name, LinuxService.this.core$()).as(MavenPlugin.class);
					newElement.core$().set(newElement, "code", Collections.singletonList(code));
					return newElement;
				}
			}

			public class Clear {
				public void mavenPlugin(Predicate<MavenPlugin> filter) {
					(new ArrayList<>(LinuxService.this.mavenPluginList())).stream().filter(filter).forEach(Layer::delete$);
				}
			}
		}
	}

	public static class Distribution extends Layer implements Terminal {
		protected boolean distributeLanguage;
		protected List<Artifactory> artifactoryList = new ArrayList();
		protected OnBitbucket onBitbucket;

		public Distribution(Node node) {
			super(node);
		}

		public boolean distributeLanguage() {
			return this.distributeLanguage;
		}

		public Distribution distributeLanguage(boolean value) {
			this.distributeLanguage = value;
			return this;
		}

		public List<Artifactory> artifactoryList() {
			return Collections.unmodifiableList(this.artifactoryList);
		}

		public Artifactory artifactory(int index) {
			return (Artifactory) this.artifactoryList.get(index);
		}

		public List<Artifactory> artifactoryList(Predicate<Artifactory> predicate) {
			return (List) this.artifactoryList().stream().filter(predicate).collect(Collectors.toList());
		}

		public Artifactory artifactory(Predicate<Artifactory> predicate) {
			return (Artifactory) this.artifactoryList().stream().filter(predicate).findFirst().orElse(null);
		}

		public OnBitbucket onBitbucket() {
			return this.onBitbucket;
		}

		protected List<Node> componentList$() {
			Set<Node> components = new LinkedHashSet(super.componentList$());
			(new ArrayList<>(this.artifactoryList)).forEach((c) -> components.add(c.core$()));
			if (this.onBitbucket != null) {
				components.add(this.onBitbucket.core$());
			}

			return new ArrayList(components);
		}

		protected Map<String, List<?>> variables$() {
			Map<String, List<?>> map = new LinkedHashMap();
			map.put("distributeLanguage", new ArrayList(Collections.singletonList(this.distributeLanguage)));
			return map;
		}

		protected void addNode$(Node node) {
			super.addNode$(node);
			if (node.is("Artifact$Distribution$Artifactory")) {
				this.artifactoryList.add((Artifactory) node.as(Artifactory.class));
			}

			if (node.is("Artifact$Distribution$OnBitbucket")) {
				this.onBitbucket = (OnBitbucket) node.as(OnBitbucket.class);
			}

		}

		protected void removeNode$(Node node) {
			super.removeNode$(node);
			if (node.is("Artifact$Distribution$Artifactory")) {
				this.artifactoryList.remove(node.as(Artifactory.class));
			}

			if (node.is("Artifact$Distribution$OnBitbucket")) {
				this.onBitbucket = null;
			}

		}

		protected void load$(String name, List<?> values) {
			super.load$(name, values);
			if (name.equalsIgnoreCase("distributeLanguage")) {
				this.distributeLanguage = (Boolean) BooleanLoader.load(values, this).get(0);
			}

		}

		protected void set$(String name, List<?> values) {
			super.set$(name, values);
			if (name.equalsIgnoreCase("distributeLanguage")) {
				this.distributeLanguage = (Boolean) values.get(0);
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

			public Artifactory artifactory(String identifier) {
				Artifactory newElement = (Artifactory) Distribution.this.core$().graph().concept(Artifactory.class).createNode(this.name, Distribution.this.core$()).as(Artifactory.class);
				newElement.core$().set(newElement, "identifier", Collections.singletonList(identifier));
				return newElement;
			}

			public OnBitbucket onBitbucket(String owner, String slugName) {
				OnBitbucket newElement = (OnBitbucket) Distribution.this.core$().graph().concept(OnBitbucket.class).createNode(this.name, Distribution.this.core$()).as(OnBitbucket.class);
				newElement.core$().set(newElement, "owner", Collections.singletonList(owner));
				newElement.core$().set(newElement, "slugName", Collections.singletonList(slugName));
				return newElement;
			}
		}

		public class Clear {
			public void artifactory(Predicate<Artifactory> filter) {
				(new ArrayList<>(Distribution.this.artifactoryList())).stream().filter(filter).forEach(Layer::delete$);
			}
		}

		public static class Artifactory extends Layer implements Terminal {
			protected String identifier;
			protected Release release;
			protected Snapshot snapshot;

			public Artifactory(Node node) {
				super(node);
			}

			public String identifier() {
				return this.identifier;
			}

			public Artifactory identifier(String value) {
				this.identifier = value;
				return this;
			}

			public Release release() {
				return this.release;
			}

			public Snapshot snapshot() {
				return this.snapshot;
			}

			protected List<Node> componentList$() {
				Set<Node> components = new LinkedHashSet(super.componentList$());
				if (this.release != null) {
					components.add(this.release.core$());
				}

				if (this.snapshot != null) {
					components.add(this.snapshot.core$());
				}

				return new ArrayList(components);
			}

			protected Map<String, List<?>> variables$() {
				Map<String, List<?>> map = new LinkedHashMap();
				map.put("identifier", new ArrayList(Collections.singletonList(this.identifier)));
				return map;
			}

			protected void addNode$(Node node) {
				super.addNode$(node);
				if (node.is("Artifact$Distribution$Artifactory$Release")) {
					this.release = (Release) node.as(Release.class);
				}

				if (node.is("Artifact$Distribution$Artifactory$Snapshot")) {
					this.snapshot = (Snapshot) node.as(Snapshot.class);
				}

			}

			protected void removeNode$(Node node) {
				super.removeNode$(node);
				if (node.is("Artifact$Distribution$Artifactory$Release")) {
					this.release = null;
				}

				if (node.is("Artifact$Distribution$Artifactory$Snapshot")) {
					this.snapshot = null;
				}

			}

			protected void load$(String name, List<?> values) {
				super.load$(name, values);
				if (name.equalsIgnoreCase("identifier")) {
					this.identifier = (String) StringLoader.load(values, this).get(0);
				}

			}

			protected void set$(String name, List<?> values) {
				super.set$(name, values);
				if (name.equalsIgnoreCase("identifier")) {
					this.identifier = (String) values.get(0);
				}

			}

			public Create create() {
				return new Create((String) null);
			}

			public Create create(String name) {
				return new Create(name);
			}

			public LegioGraph graph() {
				return (LegioGraph) this.core$().graph().as(LegioGraph.class);
			}

			public class Create {
				protected final String name;

				public Create(String name) {
					this.name = name;
				}

				public Release release(String url) {
					Release newElement = (Release) Artifactory.this.core$().graph().concept(Release.class).createNode(this.name, Artifactory.this.core$()).as(Release.class);
					newElement.core$().set(newElement, "url", Collections.singletonList(url));
					return newElement;
				}

				public Snapshot snapshot(String url) {
					Snapshot newElement = (Snapshot) Artifactory.this.core$().graph().concept(Snapshot.class).createNode(this.name, Artifactory.this.core$()).as(Snapshot.class);
					newElement.core$().set(newElement, "url", Collections.singletonList(url));
					return newElement;
				}
			}

			public static class Release extends Layer implements Terminal {
				protected String url;

				public Release(Node node) {
					super(node);
				}

				public String url() {
					return this.url;
				}

				public Release url(String value) {
					this.url = value;
					return this;
				}

				protected Map<String, List<?>> variables$() {
					Map<String, List<?>> map = new LinkedHashMap();
					map.put("url", new ArrayList(Collections.singletonList(this.url)));
					return map;
				}

				protected void load$(String name, List<?> values) {
					super.load$(name, values);
					if (name.equalsIgnoreCase("url")) {
						this.url = (String) StringLoader.load(values, this).get(0);
					}

				}

				protected void set$(String name, List<?> values) {
					super.set$(name, values);
					if (name.equalsIgnoreCase("url")) {
						this.url = (String) values.get(0);
					}

				}

				public LegioGraph graph() {
					return (LegioGraph) this.core$().graph().as(LegioGraph.class);
				}
			}

			public static class Snapshot extends Layer implements Terminal {
				protected String url;

				public Snapshot(Node node) {
					super(node);
				}

				public String url() {
					return this.url;
				}

				public Snapshot url(String value) {
					this.url = value;
					return this;
				}

				protected Map<String, List<?>> variables$() {
					Map<String, List<?>> map = new LinkedHashMap();
					map.put("url", new ArrayList(Collections.singletonList(this.url)));
					return map;
				}

				protected void load$(String name, List<?> values) {
					super.load$(name, values);
					if (name.equalsIgnoreCase("url")) {
						this.url = (String) StringLoader.load(values, this).get(0);
					}

				}

				protected void set$(String name, List<?> values) {
					super.set$(name, values);
					if (name.equalsIgnoreCase("url")) {
						this.url = (String) values.get(0);
					}

				}

				public LegioGraph graph() {
					return (LegioGraph) this.core$().graph().as(LegioGraph.class);
				}
			}
		}

		public static class OnBitbucket extends Layer implements Terminal {
			protected String owner;
			protected String slugName;

			public OnBitbucket(Node node) {
				super(node);
			}

			public String owner() {
				return this.owner;
			}

			public String slugName() {
				return this.slugName;
			}

			public OnBitbucket owner(String value) {
				this.owner = value;
				return this;
			}

			public OnBitbucket slugName(String value) {
				this.slugName = value;
				return this;
			}

			protected Map<String, List<?>> variables$() {
				Map<String, List<?>> map = new LinkedHashMap();
				map.put("owner", new ArrayList(Collections.singletonList(this.owner)));
				map.put("slugName", new ArrayList(Collections.singletonList(this.slugName)));
				return map;
			}

			protected void load$(String name, List<?> values) {
				super.load$(name, values);
				if (name.equalsIgnoreCase("owner")) {
					this.owner = (String) StringLoader.load(values, this).get(0);
				} else if (name.equalsIgnoreCase("slugName")) {
					this.slugName = (String) StringLoader.load(values, this).get(0);
				}

			}

			protected void set$(String name, List<?> values) {
				super.set$(name, values);
				if (name.equalsIgnoreCase("owner")) {
					this.owner = (String) values.get(0);
				} else if (name.equalsIgnoreCase("slugName")) {
					this.slugName = (String) values.get(0);
				}

			}

			public LegioGraph graph() {
				return (LegioGraph) this.core$().graph().as(LegioGraph.class);
			}
		}
	}

	public static class QualityAnalytics extends Layer implements Terminal {
		protected String url;
		protected Authentication authentication;

		public QualityAnalytics(Node node) {
			super(node);
		}

		public String url() {
			return this.url;
		}

		public QualityAnalytics url(String value) {
			this.url = value;
			return this;
		}

		public Authentication authentication() {
			return this.authentication;
		}

		protected List<Node> componentList$() {
			Set<Node> components = new LinkedHashSet(super.componentList$());
			if (this.authentication != null) {
				components.add(this.authentication.core$());
			}

			return new ArrayList(components);
		}

		protected Map<String, List<?>> variables$() {
			Map<String, List<?>> map = new LinkedHashMap();
			map.put("url", new ArrayList(Collections.singletonList(this.url)));
			return map;
		}

		protected void addNode$(Node node) {
			super.addNode$(node);
			if (node.is("Artifact$QualityAnalytics$Authentication")) {
				this.authentication = (Authentication) node.as(Authentication.class);
			}

		}

		protected void removeNode$(Node node) {
			super.removeNode$(node);
			if (node.is("Artifact$QualityAnalytics$Authentication")) {
				this.authentication = null;
			}

		}

		protected void load$(String name, List<?> values) {
			super.load$(name, values);
			if (name.equalsIgnoreCase("url")) {
				this.url = (String) StringLoader.load(values, this).get(0);
			}

		}

		protected void set$(String name, List<?> values) {
			super.set$(name, values);
			if (name.equalsIgnoreCase("url")) {
				this.url = (String) values.get(0);
			}

		}

		public Create create() {
			return new Create((String) null);
		}

		public Create create(String name) {
			return new Create(name);
		}

		public LegioGraph graph() {
			return (LegioGraph) this.core$().graph().as(LegioGraph.class);
		}

		public class Create {
			protected final String name;

			public Create(String name) {
				this.name = name;
			}

			public Authentication authentication(String token) {
				Authentication newElement = (Authentication) QualityAnalytics.this.core$().graph().concept(Authentication.class).createNode(this.name, QualityAnalytics.this.core$()).as(Authentication.class);
				newElement.core$().set(newElement, "token", Collections.singletonList(token));
				return newElement;
			}
		}

		public static class Authentication extends Layer implements Terminal {
			protected String token;

			public Authentication(Node node) {
				super(node);
			}

			public String token() {
				return this.token;
			}

			public Authentication token(String value) {
				this.token = value;
				return this;
			}

			protected Map<String, List<?>> variables$() {
				Map<String, List<?>> map = new LinkedHashMap();
				map.put("token", new ArrayList(Collections.singletonList(this.token)));
				return map;
			}

			protected void load$(String name, List<?> values) {
				super.load$(name, values);
				if (name.equalsIgnoreCase("token")) {
					this.token = (String) StringLoader.load(values, this).get(0);
				}

			}

			protected void set$(String name, List<?> values) {
				super.set$(name, values);
				if (name.equalsIgnoreCase("token")) {
					this.token = (String) values.get(0);
				}

			}

			public LegioGraph graph() {
				return (LegioGraph) this.core$().graph().as(LegioGraph.class);
			}
		}
	}

	public static class Deployment extends Layer implements Terminal {
		protected Server server;
		protected RunConfiguration runConfiguration;
		protected BugTracking bugTracking;
		protected Requirements requirements;

		public Deployment(Node node) {
			super(node);
		}

		public Server server() {
			return this.server;
		}

		public RunConfiguration runConfiguration() {
			return this.runConfiguration;
		}

		public Deployment server(Server value) {
			this.server = value;
			return this;
		}

		public Deployment runConfiguration(RunConfiguration value) {
			this.runConfiguration = value;
			return this;
		}

		public BugTracking bugTracking() {
			return this.bugTracking;
		}

		public Requirements requirements() {
			return this.requirements;
		}

		protected List<Node> componentList$() {
			Set<Node> components = new LinkedHashSet(super.componentList$());
			if (this.bugTracking != null) {
				components.add(this.bugTracking.core$());
			}

			if (this.requirements != null) {
				components.add(this.requirements.core$());
			}

			return new ArrayList(components);
		}

		protected Map<String, List<?>> variables$() {
			Map<String, List<?>> map = new LinkedHashMap();
			map.put("server", this.server != null ? new ArrayList(Collections.singletonList(this.server)) : Collections.emptyList());
			map.put("runConfiguration", this.runConfiguration != null ? new ArrayList(Collections.singletonList(this.runConfiguration)) : Collections.emptyList());
			return map;
		}

		protected void addNode$(Node node) {
			super.addNode$(node);
			if (node.is("Artifact$Deployment$BugTracking")) {
				this.bugTracking = (BugTracking) node.as(BugTracking.class);
			}

			if (node.is("Artifact$Deployment$Requirements")) {
				this.requirements = (Requirements) node.as(Requirements.class);
			}

		}

		protected void removeNode$(Node node) {
			super.removeNode$(node);
			if (node.is("Artifact$Deployment$BugTracking")) {
				this.bugTracking = null;
			}

			if (node.is("Artifact$Deployment$Requirements")) {
				this.requirements = null;
			}

		}

		protected void load$(String name, List<?> values) {
			super.load$(name, values);
			if (name.equalsIgnoreCase("server")) {
				this.server = (Server) NodeLoader.load(values, Server.class, this).get(0);
			} else if (name.equalsIgnoreCase("runConfiguration")) {
				this.runConfiguration = (RunConfiguration) NodeLoader.load(values, RunConfiguration.class, this).get(0);
			}

		}

		protected void set$(String name, List<?> values) {
			super.set$(name, values);
			if (name.equalsIgnoreCase("server")) {
				this.server = values.get(0) != null ? (Server) this.core$().graph().load(((Layer) values.get(0)).core$().id()).as(Server.class) : null;
			} else if (name.equalsIgnoreCase("runConfiguration")) {
				this.runConfiguration = values.get(0) != null ? (RunConfiguration) this.core$().graph().load(((Layer) values.get(0)).core$().id()).as(RunConfiguration.class) : null;
			}

		}

		public Create create() {
			return new Create((String) null);
		}

		public Create create(String name) {
			return new Create(name);
		}

		public LegioGraph graph() {
			return (LegioGraph) this.core$().graph().as(LegioGraph.class);
		}

		public class Create {
			protected final String name;

			public Create(String name) {
				this.name = name;
			}

			public BugTracking bugTracking() {
				BugTracking newElement = (BugTracking) Deployment.this.core$().graph().concept(BugTracking.class).createNode(this.name, Deployment.this.core$()).as(BugTracking.class);
				return newElement;
			}

			public Requirements requirements() {
				Requirements newElement = (Requirements) Deployment.this.core$().graph().concept(Requirements.class).createNode(this.name, Deployment.this.core$()).as(Requirements.class);
				return newElement;
			}
		}

		public static class BugTracking extends Layer implements Terminal {
			protected List<String> slackUsers = new ArrayList();

			public BugTracking(Node node) {
				super(node);
			}

			public List<String> slackUsers() {
				return this.slackUsers;
			}

			public String slackUsers(int index) {
				return (String) this.slackUsers.get(index);
			}

			public List<String> slackUsers(Predicate<String> predicate) {
				return (List) this.slackUsers().stream().filter(predicate).collect(Collectors.toList());
			}

			protected Map<String, List<?>> variables$() {
				Map<String, List<?>> map = new LinkedHashMap();
				map.put("slackUsers", this.slackUsers);
				return map;
			}

			protected void load$(String name, List<?> values) {
				super.load$(name, values);
				if (name.equalsIgnoreCase("slackUsers")) {
					this.slackUsers = StringLoader.load(values, this);
				}

			}

			protected void set$(String name, List<?> values) {
				super.set$(name, values);
				if (name.equalsIgnoreCase("slackUsers")) {
					this.slackUsers = new ArrayList(values);
				}

			}

			public LegioGraph graph() {
				return (LegioGraph) this.core$().graph().as(LegioGraph.class);
			}
		}

		public static class Requirements extends Layer implements Terminal {
			protected HDD hDD;
			protected Memory memory;
			protected CPU cPU;
			protected JVM jVM;
			protected R r;
			protected SyncDirectories syncDirectories;

			public Requirements(Node node) {
				super(node);
			}

			public HDD hDD() {
				return this.hDD;
			}

			public Memory memory() {
				return this.memory;
			}

			public CPU cPU() {
				return this.cPU;
			}

			public JVM jVM() {
				return this.jVM;
			}

			public R r() {
				return this.r;
			}

			public SyncDirectories syncDirectories() {
				return this.syncDirectories;
			}

			protected List<Node> componentList$() {
				Set<Node> components = new LinkedHashSet(super.componentList$());
				if (this.hDD != null) {
					components.add(this.hDD.core$());
				}

				if (this.memory != null) {
					components.add(this.memory.core$());
				}

				if (this.cPU != null) {
					components.add(this.cPU.core$());
				}

				if (this.jVM != null) {
					components.add(this.jVM.core$());
				}

				if (this.r != null) {
					components.add(this.r.core$());
				}

				if (this.syncDirectories != null) {
					components.add(this.syncDirectories.core$());
				}

				return new ArrayList(components);
			}

			protected Map<String, List<?>> variables$() {
				Map<String, List<?>> map = new LinkedHashMap();
				return map;
			}

			protected void addNode$(Node node) {
				super.addNode$(node);
				if (node.is("Artifact$Deployment$Requirements$HDD")) {
					this.hDD = (HDD) node.as(HDD.class);
				}

				if (node.is("Artifact$Deployment$Requirements$Memory")) {
					this.memory = (Memory) node.as(Memory.class);
				}

				if (node.is("Artifact$Deployment$Requirements$CPU")) {
					this.cPU = (CPU) node.as(CPU.class);
				}

				if (node.is("Artifact$Deployment$Requirements$JVM")) {
					this.jVM = (JVM) node.as(JVM.class);
				}

				if (node.is("Artifact$Deployment$Requirements$R")) {
					this.r = (R) node.as(R.class);
				}

				if (node.is("Artifact$Deployment$Requirements$SyncDirectories")) {
					this.syncDirectories = (SyncDirectories) node.as(SyncDirectories.class);
				}

			}

			protected void removeNode$(Node node) {
				super.removeNode$(node);
				if (node.is("Artifact$Deployment$Requirements$HDD")) {
					this.hDD = null;
				}

				if (node.is("Artifact$Deployment$Requirements$Memory")) {
					this.memory = null;
				}

				if (node.is("Artifact$Deployment$Requirements$CPU")) {
					this.cPU = null;
				}

				if (node.is("Artifact$Deployment$Requirements$JVM")) {
					this.jVM = null;
				}

				if (node.is("Artifact$Deployment$Requirements$R")) {
					this.r = null;
				}

				if (node.is("Artifact$Deployment$Requirements$SyncDirectories")) {
					this.syncDirectories = null;
				}

			}

			protected void load$(String name, List<?> values) {
				super.load$(name, values);
			}

			protected void set$(String name, List<?> values) {
				super.set$(name, values);
			}

			public Create create() {
				return new Create((String) null);
			}

			public Create create(String name) {
				return new Create(name);
			}

			public LegioGraph graph() {
				return (LegioGraph) this.core$().graph().as(LegioGraph.class);
			}

			public class Create {
				protected final String name;

				public Create(String name) {
					this.name = name;
				}

				public HDD hDD(double min) {
					HDD newElement = (HDD) Requirements.this.core$().graph().concept(HDD.class).createNode(this.name, Requirements.this.core$()).as(HDD.class);
					newElement.core$().set(newElement, "min", Collections.singletonList(min));
					return newElement;
				}

				public Memory memory(int min, int max) {
					Memory newElement = (Memory) Requirements.this.core$().graph().concept(Memory.class).createNode(this.name, Requirements.this.core$()).as(Memory.class);
					newElement.core$().set(newElement, "min", Collections.singletonList(min));
					newElement.core$().set(newElement, "max", Collections.singletonList(max));
					return newElement;
				}

				public CPU cPU(int cores) {
					CPU newElement = (CPU) Requirements.this.core$().graph().concept(CPU.class).createNode(this.name, Requirements.this.core$()).as(CPU.class);
					newElement.core$().set(newElement, "cores", Collections.singletonList(cores));
					return newElement;
				}

				public JVM jVM(String version) {
					JVM newElement = (JVM) Requirements.this.core$().graph().concept(JVM.class).createNode(this.name, Requirements.this.core$()).as(JVM.class);
					newElement.core$().set(newElement, "version", Collections.singletonList(version));
					return newElement;
				}

				public R r(String version, List<String> libraries) {
					R newElement = (R) Requirements.this.core$().graph().concept(R.class).createNode(this.name, Requirements.this.core$()).as(R.class);
					newElement.core$().set(newElement, "version", Collections.singletonList(version));
					newElement.core$().set(newElement, "libraries", libraries);
					return newElement;
				}

				public SyncDirectories syncDirectories() {
					SyncDirectories newElement = (SyncDirectories) Requirements.this.core$().graph().concept(SyncDirectories.class).createNode(this.name, Requirements.this.core$()).as(SyncDirectories.class);
					return newElement;
				}
			}

			public static class HDD extends Layer implements Terminal {
				protected double min;

				public HDD(Node node) {
					super(node);
				}

				public double min() {
					return this.min;
				}

				public HDD min(double value) {
					this.min = value;
					return this;
				}

				protected Map<String, List<?>> variables$() {
					Map<String, List<?>> map = new LinkedHashMap();
					map.put("min", new ArrayList(Collections.singletonList(this.min)));
					return map;
				}

				protected void load$(String name, List<?> values) {
					super.load$(name, values);
					if (name.equalsIgnoreCase("min")) {
						this.min = (Double) DoubleLoader.load(values, this).get(0);
					}

				}

				protected void set$(String name, List<?> values) {
					super.set$(name, values);
					if (name.equalsIgnoreCase("min")) {
						this.min = (Double) values.get(0);
					}

				}

				public LegioGraph graph() {
					return (LegioGraph) this.core$().graph().as(LegioGraph.class);
				}
			}

			public static class Memory extends Layer implements Terminal {
				protected int min;
				protected int max;

				public Memory(Node node) {
					super(node);
				}

				public int min() {
					return this.min;
				}

				public int max() {
					return this.max;
				}

				public Memory min(int value) {
					this.min = value;
					return this;
				}

				public Memory max(int value) {
					this.max = value;
					return this;
				}

				protected Map<String, List<?>> variables$() {
					Map<String, List<?>> map = new LinkedHashMap();
					map.put("min", new ArrayList(Collections.singletonList(this.min)));
					map.put("max", new ArrayList(Collections.singletonList(this.max)));
					return map;
				}

				protected void load$(String name, List<?> values) {
					super.load$(name, values);
					if (name.equalsIgnoreCase("min")) {
						this.min = (Integer) IntegerLoader.load(values, this).get(0);
					} else if (name.equalsIgnoreCase("max")) {
						this.max = (Integer) IntegerLoader.load(values, this).get(0);
					}

				}

				protected void set$(String name, List<?> values) {
					super.set$(name, values);
					if (name.equalsIgnoreCase("min")) {
						this.min = (Integer) values.get(0);
					} else if (name.equalsIgnoreCase("max")) {
						this.max = (Integer) values.get(0);
					}

				}

				public LegioGraph graph() {
					return (LegioGraph) this.core$().graph().as(LegioGraph.class);
				}
			}

			public static class CPU extends Layer implements Terminal {
				protected int cores;

				public CPU(Node node) {
					super(node);
				}

				public int cores() {
					return this.cores;
				}

				public CPU cores(int value) {
					this.cores = value;
					return this;
				}

				protected Map<String, List<?>> variables$() {
					Map<String, List<?>> map = new LinkedHashMap();
					map.put("cores", new ArrayList(Collections.singletonList(this.cores)));
					return map;
				}

				protected void load$(String name, List<?> values) {
					super.load$(name, values);
					if (name.equalsIgnoreCase("cores")) {
						this.cores = (Integer) IntegerLoader.load(values, this).get(0);
					}

				}

				protected void set$(String name, List<?> values) {
					super.set$(name, values);
					if (name.equalsIgnoreCase("cores")) {
						this.cores = (Integer) values.get(0);
					}

				}

				public LegioGraph graph() {
					return (LegioGraph) this.core$().graph().as(LegioGraph.class);
				}
			}

			public static class JVM extends Layer implements Terminal {
				protected String version;

				public JVM(Node node) {
					super(node);
				}

				public String version() {
					return this.version;
				}

				public JVM version(String value) {
					this.version = value;
					return this;
				}

				protected Map<String, List<?>> variables$() {
					Map<String, List<?>> map = new LinkedHashMap();
					map.put("version", new ArrayList(Collections.singletonList(this.version)));
					return map;
				}

				protected void load$(String name, List<?> values) {
					super.load$(name, values);
					if (name.equalsIgnoreCase("version")) {
						this.version = (String) StringLoader.load(values, this).get(0);
					}

				}

				protected void set$(String name, List<?> values) {
					super.set$(name, values);
					if (name.equalsIgnoreCase("version")) {
						this.version = (String) values.get(0);
					}

				}

				public LegioGraph graph() {
					return (LegioGraph) this.core$().graph().as(LegioGraph.class);
				}
			}

			public static class R extends Layer implements Terminal {
				protected String version;
				protected List<String> libraries = new ArrayList();

				public R(Node node) {
					super(node);
				}

				public String version() {
					return this.version;
				}

				public List<String> libraries() {
					return this.libraries;
				}

				public String libraries(int index) {
					return (String) this.libraries.get(index);
				}

				public List<String> libraries(Predicate<String> predicate) {
					return (List) this.libraries().stream().filter(predicate).collect(Collectors.toList());
				}

				public R version(String value) {
					this.version = value;
					return this;
				}

				protected Map<String, List<?>> variables$() {
					Map<String, List<?>> map = new LinkedHashMap();
					map.put("version", new ArrayList(Collections.singletonList(this.version)));
					map.put("libraries", this.libraries);
					return map;
				}

				protected void load$(String name, List<?> values) {
					super.load$(name, values);
					if (name.equalsIgnoreCase("version")) {
						this.version = (String) StringLoader.load(values, this).get(0);
					} else if (name.equalsIgnoreCase("libraries")) {
						this.libraries = StringLoader.load(values, this);
					}

				}

				protected void set$(String name, List<?> values) {
					super.set$(name, values);
					if (name.equalsIgnoreCase("version")) {
						this.version = (String) values.get(0);
					} else if (name.equalsIgnoreCase("libraries")) {
						this.libraries = new ArrayList(values);
					}

				}

				public LegioGraph graph() {
					return (LegioGraph) this.core$().graph().as(LegioGraph.class);
				}
			}

			public static class SyncDirectories extends Layer implements Terminal {
				protected List<To> toList = new ArrayList();

				public SyncDirectories(Node node) {
					super(node);
				}

				public List<To> toList() {
					return Collections.unmodifiableList(this.toList);
				}

				public To to(int index) {
					return (To) this.toList.get(index);
				}

				public List<To> toList(Predicate<To> predicate) {
					return (List) this.toList().stream().filter(predicate).collect(Collectors.toList());
				}

				public To to(Predicate<To> predicate) {
					return (To) this.toList().stream().filter(predicate).findFirst().orElse(null);
				}

				protected List<Node> componentList$() {
					Set<Node> components = new LinkedHashSet(super.componentList$());
					(new ArrayList<>(this.toList)).forEach((c) -> components.add(c.core$()));
					return new ArrayList(components);
				}

				protected Map<String, List<?>> variables$() {
					Map<String, List<?>> map = new LinkedHashMap();
					return map;
				}

				protected void addNode$(Node node) {
					super.addNode$(node);
					if (node.is("Artifact$Deployment$Requirements$SyncDirectories$To")) {
						this.toList.add((To) node.as(To.class));
					}

				}

				protected void removeNode$(Node node) {
					super.removeNode$(node);
					if (node.is("Artifact$Deployment$Requirements$SyncDirectories$To")) {
						this.toList.remove(node.as(To.class));
					}

				}

				protected void load$(String name, List<?> values) {
					super.load$(name, values);
				}

				protected void set$(String name, List<?> values) {
					super.set$(name, values);
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

					public To to(String module, Server server) {
						To newElement = (To) SyncDirectories.this.core$().graph().concept(To.class).createNode(this.name, SyncDirectories.this.core$()).as(To.class);
						newElement.core$().set(newElement, "module", Collections.singletonList(module));
						newElement.core$().set(newElement, "server", Collections.singletonList(server));
						return newElement;
					}
				}

				public class Clear {
					public void to(Predicate<To> filter) {
						(new ArrayList<>(SyncDirectories.this.toList())).stream().filter(filter).forEach(Layer::delete$);
					}
				}

				public static class To extends Layer implements Terminal {
					protected String module;
					protected Server server;

					public To(Node node) {
						super(node);
					}

					public String module() {
						return this.module;
					}

					public Server server() {
						return this.server;
					}

					public To module(String value) {
						this.module = value;
						return this;
					}

					public To server(Server value) {
						this.server = value;
						return this;
					}

					protected Map<String, List<?>> variables$() {
						Map<String, List<?>> map = new LinkedHashMap();
						map.put("module", new ArrayList(Collections.singletonList(this.module)));
						map.put("server", this.server != null ? new ArrayList(Collections.singletonList(this.server)) : Collections.emptyList());
						return map;
					}

					protected void load$(String name, List<?> values) {
						super.load$(name, values);
						if (name.equalsIgnoreCase("module")) {
							this.module = (String) StringLoader.load(values, this).get(0);
						} else if (name.equalsIgnoreCase("server")) {
							this.server = (Server) NodeLoader.load(values, Server.class, this).get(0);
						}

					}

					protected void set$(String name, List<?> values) {
						super.set$(name, values);
						if (name.equalsIgnoreCase("module")) {
							this.module = (String) values.get(0);
						} else if (name.equalsIgnoreCase("server")) {
							this.server = values.get(0) != null ? (Server) this.core$().graph().load(((Layer) values.get(0)).core$().id()).as(Server.class) : null;
						}

					}

					public LegioGraph graph() {
						return (LegioGraph) this.core$().graph().as(LegioGraph.class);
					}
				}
			}
		}
	}
}
