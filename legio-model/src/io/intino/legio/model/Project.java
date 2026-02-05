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

public class Project extends Layer implements Terminal {
	protected String description;
	protected Scm scm;
	protected List<Developer> developerList = new ArrayList<>();
	protected List<Server> serverList = new ArrayList<>();
	protected List<Repository> repositoryList = new ArrayList<>();

	public Project(Node node) {
		super(node);
	}

	public String description() {
		return this.description;
	}

	public Project description(String value) {
		this.description = value;
		return this;
	}

	public Scm scm() {
		return this.scm;
	}

	public List<Developer> developerList() {
		return Collections.unmodifiableList(this.developerList);
	}

	public Developer developer(int index) {
		return (Developer)this.developerList.get(index);
	}

	public List<Developer> developerList(Predicate<Developer> predicate) {
		return (List)this.developerList().stream().filter(predicate).collect(Collectors.toList());
	}

	public Developer developer(Predicate<Developer> predicate) {
		return (Developer)this.developerList().stream().filter(predicate).findFirst().orElse(null);
	}

	public List<Server> serverList() {
		return Collections.unmodifiableList(this.serverList);
	}

	public Server server(int index) {
		return (Server)this.serverList.get(index);
	}

	public List<Server> serverList(Predicate<Server> predicate) {
		return (List)this.serverList().stream().filter(predicate).collect(Collectors.toList());
	}

	public Server server(Predicate<Server> predicate) {
		return (Server)this.serverList().stream().filter(predicate).findFirst().orElse(null);
	}

	public List<Repository> repositoryList() {
		return Collections.unmodifiableList(this.repositoryList);
	}

	public Repository repository(int index) {
		return (Repository)this.repositoryList.get(index);
	}

	public List<Repository> repositoryList(Predicate<Repository> predicate) {
		return (List)this.repositoryList().stream().filter(predicate).collect(Collectors.toList());
	}

	public Repository repository(Predicate<Repository> predicate) {
		return (Repository)this.repositoryList().stream().filter(predicate).findFirst().orElse(null);
	}

	protected List<Node> componentList$() {
		Set<Node> components = new LinkedHashSet(super.componentList$());
		if (this.scm != null) {
			components.add(this.scm.core$());
		}

		(new ArrayList<>(this.developerList)).forEach((c) -> components.add(c.core$()));
		(new ArrayList<>(this.serverList)).forEach((c) -> components.add(c.core$()));
		(new ArrayList<>(this.repositoryList)).forEach((c) -> components.add(c.core$()));
		return new ArrayList<>(components);
	}

	protected Map<String, List<?>> variables$() {
		Map<String, List<?>> map = new LinkedHashMap<>();
		map.put("description", new ArrayList<>(Collections.singletonList(this.description)));
		return map;
	}

	protected void addNode$(Node node) {
		super.addNode$(node);
		if (node.is("Project$Scm")) {
			this.scm = node.as(Scm.class);
		}

		if (node.is("Project$Developer")) {
			this.developerList.add(node.as(Developer.class));
		}

		if (node.is("Server")) {
			this.serverList.add(node.as(Server.class));
		}

		if (node.is("Repository")) {
			this.repositoryList.add(node.as(Repository.class));
		}

	}

	protected void removeNode$(Node node) {
		super.removeNode$(node);
		if (node.is("Project$Scm")) {
			this.scm = null;
		}

		if (node.is("Project$Developer")) {
			this.developerList.remove(node.as(Developer.class));
		}

		if (node.is("Server")) {
			this.serverList.remove(node.as(Server.class));
		}

		if (node.is("Repository")) {
			this.repositoryList.remove(node.as(Repository.class));
		}

	}

	protected void load$(String name, List<?> values) {
		super.load$(name, values);
		if (name.equalsIgnoreCase("description")) {
			this.description = StringLoader.load(values, this).getFirst();
		}

	}

	protected void set$(String name, List<?> values) {
		super.set$(name, values);
		if (name.equalsIgnoreCase("description")) {
			this.description = (String)values.getFirst();
		}

	}

	public Create create() {
		return new Create(null);
	}

	public Create create(String name) {
		return new Create(name);
	}

	public Clear clear() {
		return new Clear();
	}

	public LegioGraph graph() {
		return (LegioGraph)this.core$().graph().as(LegioGraph.class);
	}

	public class Create {
		protected final String name;

		public Create(String name) {
			this.name = name;
		}

		public Scm scm(String url, String connection) {
			Scm newElement = (Scm)Project.this.core$().graph().concept(Scm.class).createNode(this.name, Project.this.core$()).as(Scm.class);
			newElement.core$().set(newElement, "url", Collections.singletonList(url));
			newElement.core$().set(newElement, "connection", Collections.singletonList(connection));
			return newElement;
		}

		public Developer developer(String name, String email, String organization, String organizationUrl) {
			Developer newElement = (Developer)Project.this.core$().graph().concept(Developer.class).createNode(this.name, Project.this.core$()).as(Developer.class);
			newElement.core$().set(newElement, "name", Collections.singletonList(name));
			newElement.core$().set(newElement, "email", Collections.singletonList(email));
			newElement.core$().set(newElement, "organization", Collections.singletonList(organization));
			newElement.core$().set(newElement, "organizationUrl", Collections.singletonList(organizationUrl));
			return newElement;
		}

		public Server server(Server.Type type) {
			Server newElement = (Server)Project.this.core$().graph().concept(Server.class).createNode(this.name, Project.this.core$()).as(Server.class);
			newElement.core$().set(newElement, "type", Collections.singletonList(type));
			return newElement;
		}

		public Repository repository(String identifier) {
			Repository newElement = (Repository)Project.this.core$().graph().concept(Repository.class).createNode(this.name, Project.this.core$()).as(Repository.class);
			newElement.core$().set(newElement, "identifier", Collections.singletonList(identifier));
			return newElement;
		}
	}

	public class Clear {
		public void developer(Predicate<Developer> filter) {
			(new ArrayList<>(Project.this.developerList())).stream().filter(filter).forEach(Layer::delete$);
		}

		public void server(Predicate<Server> filter) {
			(new ArrayList<>(Project.this.serverList())).stream().filter(filter).forEach(Layer::delete$);
		}

		public void repository(Predicate<Repository> filter) {
			(new ArrayList<>(Project.this.repositoryList())).stream().filter(filter).forEach(Layer::delete$);
		}
	}

	public static class Scm extends Layer implements Terminal {
		protected String url;
		protected String connection;

		public Scm(Node node) {
			super(node);
		}

		public String url() {
			return this.url;
		}

		public String connection() {
			return this.connection;
		}

		public Scm url(String value) {
			this.url = value;
			return this;
		}

		public Scm connection(String value) {
			this.connection = value;
			return this;
		}

		protected Map<String, List<?>> variables$() {
			Map<String, List<?>> map = new LinkedHashMap<>();
			map.put("url", new ArrayList<>(Collections.singletonList(this.url)));
			map.put("connection", new ArrayList<>(Collections.singletonList(this.connection)));
			return map;
		}

		protected void load$(String name, List<?> values) {
			super.load$(name, values);
			if (name.equalsIgnoreCase("url")) {
				this.url = (String)StringLoader.load(values, this).getFirst();
			} else if (name.equalsIgnoreCase("connection")) {
				this.connection = (String)StringLoader.load(values, this).getFirst();
			}

		}

		protected void set$(String name, List<?> values) {
			super.set$(name, values);
			if (name.equalsIgnoreCase("url")) {
				this.url = (String)values.getFirst();
			} else if (name.equalsIgnoreCase("connection")) {
				this.connection = (String)values.getFirst();
			}

		}

		public LegioGraph graph() {
			return this.core$().graph().as(LegioGraph.class);
		}
	}

	public static class Developer extends Layer implements Terminal {
		protected String name;
		protected String email;
		protected String organization;
		protected String organizationUrl;

		public Developer(Node node) {
			super(node);
		}

		public String name() {
			return this.name;
		}

		public String email() {
			return this.email;
		}

		public String organization() {
			return this.organization;
		}

		public String organizationUrl() {
			return this.organizationUrl;
		}

		public Developer name(String value) {
			this.name = value;
			return this;
		}

		public Developer email(String value) {
			this.email = value;
			return this;
		}

		public Developer organization(String value) {
			this.organization = value;
			return this;
		}

		public Developer organizationUrl(String value) {
			this.organizationUrl = value;
			return this;
		}

		protected Map<String, List<?>> variables$() {
			Map<String, List<?>> map = new LinkedHashMap<>();
			map.put("name", new ArrayList<>(Collections.singletonList(this.name)));
			map.put("email", new ArrayList<>(Collections.singletonList(this.email)));
			map.put("organization", new ArrayList<>(Collections.singletonList(this.organization)));
			map.put("organizationUrl", new ArrayList<>(Collections.singletonList(this.organizationUrl)));
			return map;
		}

		protected void load$(String name, List<?> values) {
			super.load$(name, values);
			if (name.equalsIgnoreCase("name")) {
				this.name = (String)StringLoader.load(values, this).get(0);
			} else if (name.equalsIgnoreCase("email")) {
				this.email = (String)StringLoader.load(values, this).get(0);
			} else if (name.equalsIgnoreCase("organization")) {
				this.organization = (String)StringLoader.load(values, this).get(0);
			} else if (name.equalsIgnoreCase("organizationUrl")) {
				this.organizationUrl = (String)StringLoader.load(values, this).get(0);
			}

		}

		protected void set$(String name, List<?> values) {
			super.set$(name, values);
			if (name.equalsIgnoreCase("name")) {
				this.name = (String)values.getFirst();
			} else if (name.equalsIgnoreCase("email")) {
				this.email = (String)values.getFirst();
			} else if (name.equalsIgnoreCase("organization")) {
				this.organization = (String)values.getFirst();
			} else if (name.equalsIgnoreCase("organizationUrl")) {
				this.organizationUrl = (String)values.getFirst();
			}

		}

		public LegioGraph graph() {
			return this.core$().graph().as(LegioGraph.class);
		}
	}
}
