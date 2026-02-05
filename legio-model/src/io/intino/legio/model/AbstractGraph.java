//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package io.intino.legio.model;

import io.intino.magritte.framework.Concept;
import io.intino.magritte.framework.Graph;
import io.intino.magritte.framework.GraphWrapper;
import io.intino.magritte.framework.Layer;
import io.intino.magritte.framework.Node;
import io.intino.magritte.framework.utils.I18n;
import io.intino.magritte.io.StashDeserializer;
import io.intino.magritte.io.model.Stash;
import java.net.URL;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class AbstractGraph extends GraphWrapper {
	protected Graph graph;
	private Artifact artifact;
	private List<RunConfiguration> runConfigurationList = new ArrayList();
	private List<Server> serverList = new ArrayList();
	private List<Repository> repositoryList = new ArrayList();
	private List<Library> libraryList = new ArrayList();
	private Project project;
	private Map<String, Indexer> _index = this._fillIndex();

	public AbstractGraph(Graph graph) {
		this.graph = graph;
		this.graph.i18n().register("Legio");
	}

	public AbstractGraph(Graph graph, AbstractGraph wrapper) {
		this.graph = graph;
		this.graph.i18n().register("Legio");
		this.artifact = wrapper.artifact;
		this.runConfigurationList = new ArrayList(wrapper.runConfigurationList);
		this.serverList = new ArrayList(wrapper.serverList);
		this.repositoryList = new ArrayList(wrapper.repositoryList);
		this.libraryList = new ArrayList(wrapper.libraryList);
		this.project = wrapper.project;
	}

	public <T extends GraphWrapper> T a$(Class<T> t) {
		return (T)this.core$().as(t);
	}

	public void update() {
		this._index.values().forEach((v) -> v.clear());
		this.graph.rootList().forEach((r) -> this.addNode$(r));
	}

	protected void addNode$(Node node) {
		for(Concept c : node.conceptList()) {
			if (this._index.containsKey(c.id())) {
				((Indexer)this._index.get(c.id())).add(node);
			}
		}

		if (this._index.containsKey(node.id())) {
			((Indexer)this._index.get(node.id())).add(node);
		}

	}

	protected void removeNode$(Node node) {
		for(Concept c : node.conceptList()) {
			if (this._index.containsKey(c.id())) {
				((Indexer)this._index.get(c.id())).remove(node);
			}
		}

		if (this._index.containsKey(node.id())) {
			((Indexer)this._index.get(node.id())).remove(node);
		}

	}

	public URL resourceAsMessage$(String language, String key) {
		return this.graph.loadResource(this.graph.i18n().message(language, key, new Object[0]));
	}

	public Artifact artifact() {
		return this.artifact;
	}

	public List<RunConfiguration> runConfigurationList() {
		return this.runConfigurationList;
	}

	public List<Server> serverList() {
		return this.serverList;
	}

	public List<Repository> repositoryList() {
		return this.repositoryList;
	}

	public List<Library> libraryList() {
		return this.libraryList;
	}

	public Project project() {
		return this.project;
	}

	public Stream<RunConfiguration> runConfigurationList(Predicate<RunConfiguration> filter) {
		return this.runConfigurationList.stream().filter(filter);
	}

	public RunConfiguration runConfiguration(int index) {
		return (RunConfiguration)this.runConfigurationList.get(index);
	}

	public Stream<Server> serverList(Predicate<Server> filter) {
		return this.serverList.stream().filter(filter);
	}

	public Server server(int index) {
		return (Server)this.serverList.get(index);
	}

	public Stream<Repository> repositoryList(Predicate<Repository> filter) {
		return this.repositoryList.stream().filter(filter);
	}

	public Repository repository(int index) {
		return (Repository)this.repositoryList.get(index);
	}

	public Stream<Library> libraryList(Predicate<Library> filter) {
		return this.libraryList.stream().filter(filter);
	}

	public Library library(int index) {
		return (Library)this.libraryList.get(index);
	}

	public Graph core$() {
		return this.graph;
	}

	public I18n i18n$() {
		return this.graph.i18n();
	}

	public Create create() {
		return new Create("Misc", (String)null);
	}

	public Create create(String stash) {
		return new Create(stash, (String)null);
	}

	public Create create(String stash, String name) {
		return new Create(stash, name);
	}

	public Clear clear() {
		return new Clear();
	}

	private HashMap<String, Indexer> _fillIndex() {
		HashMap<String, Indexer> map = new HashMap();
		map.put("Artifact", new Indexer((node) -> this.artifact = (Artifact)node.as(Artifact.class), (node) -> this.artifact = null, () -> this.artifact = null));
		map.put("RunConfiguration", new Indexer((node) -> this.runConfigurationList.add((RunConfiguration)node.as(RunConfiguration.class)), (node) -> this.runConfigurationList.remove(node.as(RunConfiguration.class)), () -> this.runConfigurationList.clear()));
		map.put("Server", new Indexer((node) -> this.serverList.add((Server)node.as(Server.class)), (node) -> this.serverList.remove(node.as(Server.class)), () -> this.serverList.clear()));
		map.put("Repository", new Indexer((node) -> this.repositoryList.add((Repository)node.as(Repository.class)), (node) -> this.repositoryList.remove(node.as(Repository.class)), () -> this.repositoryList.clear()));
		map.put("Library", new Indexer((node) -> this.libraryList.add((Library)node.as(Library.class)), (node) -> this.libraryList.remove(node.as(Library.class)), () -> this.libraryList.clear()));
		map.put("Project", new Indexer((node) -> this.project = (Project)node.as(Project.class), (node) -> this.project = null, () -> this.project = null));
		return map;
	}

	public static Stash[] _language() {
		return new Stash[]{stash()};
	}

	private static Stash stash() {
		String var10000 = stash0();
		String content = var10000 + stash1() + stash2() + stash3();
		return StashDeserializer.stashFrom(Base64.getDecoder().decode(content));
	}

	private static String stash0() {
		return "gAEAamF2YS51dGlsLkFycmF5TGlz9MIBAQFpby5pbnRpbm8ubWFncml0dGUuaW8ubW9kZWwuQ29uY2Vw9ABpby5pbnRpbm8ubGVnaW8ubW9kZWwuQXJ0aWZhY/QBAJABAmlvLmludGluby5tYWdyaXR0ZS5pby5tb2RlbC5Db25jZXB0JENvbnRlbvQAAgBBcnRpZmFjdCRMaWNlbnPl/v///w8AQXJ0aWZhY3QkRHPsAgBBcnRpZmFjdCRNb2Rl7AIAQXJ0aWZhY3QkQm/4AgBBcnRpZmFjdCREYXRhSHXiAgBBcnRpZmFjdCRBcmNoZXR5cOUCAEFydGlmYWN0JEltcG9ydPMCAEFydGlmYWN0JFdlYkltcG9ydPMCAEFydGlmYWN0JENvZOX+////DwBBcnRpZmFjdCRJbnRpbm9QbHVnae4CAEFydGlmYWN0JFBhY2thZ+X+////DwBQYXJhbWV0ZfICAEFydGlmYWN0JERpc3RyaWJ1dGlv7gIAQXJ0aWZhY3QkUXVhbGl0eUFuYWx5dGlj8/7///8PAEFydGlmYWN0JERlcGxveW1lbvQAAAEAQXJ0aWZhY/QBAAEBAAGAAQACQ29uY2Vw9AEAAadpby5pbnRpbm8ubGVnaW8ubW9kZWwuQXJ0aWZhY3QkTGljZW5zZQEAAQAAAABBcnRpZmFjdCRMaWNlbnPlAQABAQABgAEAAkNvbmNlcPQBAAGjaW8uaW50aW5vLmxlZ2lvLm1vZGVsLkFydGlmYWN0JERzbAEAgwECAAIAQXJ0aWZhY3QkRHNsJEJ1aWxkZfICAEFydGlmYWN0JERzbCRPdXRwdXREc+wAAAAAQXJ0aWZhY3QkRHPsAQABAQABgAEAAkNvbmNlcPQBAAGraW8uaW50aW5vLmxlZ2lvLm1vZGVsLkFydGlmYWN0JERzbCRCdWlsZGVyAQABAAAAAEFydGlmYWN0JERzbCRCdWlsZGXyAQABAQABgAEAAkNvbmNlcPQBAAGtaW8uaW50aW5vLmxlZ2lvLm1vZGVsLkFydGlmYWN0JERzbCRPdXRwdXREc2wBAIMBAgACAEFydGlmYWN0JERzbCRPdXRwdXREc2wkUnVudGlt5QIAQXJ0aWZhY3QkRHNsJE91dHB1dERzbCRCdWlsZGXyAAAAAEFydGlmYWN0JERzbCRPdXRwdXREc+wBAAEBAAGAAQACQ29uY2Vw9AEAAbVpby5pbnRpbm8ubGVnaW8ubW9kZWwuQXJ0aWZhY3QkRHNsJE91dHB1dERzbCRSdW50aW1lAQABAAAAAEFydGlmYWN0JERzbCRPdXRwdXREc2wkUnVudGlt5QEAAQEAAUxpYnJhcvkBAAJDb25jZXD0AQABzQFpby5pbnRpbm8ubGVnaW8ubW9kZWwuQXJ0aWZhY3QkRHNsJE91dHB1dERzbCRSdW50aW1lJEFydGlmYWN0VmVyc2lvbkZvbGxvd2VyAQABAAEAALdBcnRpZmFjdCREc2wkT3V0cHV0RHNsJFJ1bnRpbWUkQXJ0aWZhY3RWZXJzaW9uRm9sbG93ZXIBAAEBAAGAAQACRmFjZfQBAAG1aW8uaW50aW5vLmxlZ2lvLm1vZGVsLkFydGlmYWN0JERzbCRPdXRwdXREc2wkQnVpbGRlcgEAAQAAAABBcnRpZmFjdCREc2wkT3V0cHV0RHNsJEJ1aWxkZfIBAAEBAAFMaWJyYXL5AQACQ29uY2Vw9AEAAc0BaW8uaW50aW5vLmxlZ2lvLm1vZGVsLkFydGlmYWN0JERzbCRPdXRwdXREc2wkQnVpbGRlciRBcnRpZmFjdFZlcnNpb25Gb2xsb3dlcgEAAQABAAC3QXJ0aWZhY3QkRHNsJE91dHB1dERzbCRCdWlsZGVyJEFydGlmYWN0VmVyc2lvbkZvbGxvd2VyAQABAQABgAEAAkZhY2X0AQABpWlvLmludGluby5sZWdpby5tb2RlbC5BcnRpZmFjdCRNb2RlbAEAAQAAAABBcnRpZmFjdCRNb2Rl7AEAAQEAAYABAAJDb25jZXD0AQCEAQNpby5pbnRpbm8ubWFncml0dGUuaW8ubW9kZWwuVmFyaWFibOUAc2TrAQCCAwBpby5pbnRpbm8ubWFncml0dGU6YnVpbGRl8mVmZmVjdGl2ZVZlcnNpb+4BAIIDAIFvdXRMYW5ndWFn5QEAggMAvSRAaW8uaW50aW5vLmxlZ2lvLm1vZGVsLm5hdGl2ZXMuYXJ0aWZhY3QubW9kZWwuT3V0TGFuZ3VhZ2VfMKNpby5pbnRpbm8ubGVnaW8ubW9kZWwuQXJ0aWZhY3QkQm94AQABAAAAAEFydGlmYWN0JEJv+AEAAQEAAYABAAJDb25jZXD0AQCDAQMAZWZmZWN0aXZlVmVyc2lv7gEAggMAgXRhcmdldFBhY2thZ+UBAIIDAGJv+Kdpby5pbnRpbm8ubGVnaW8ubW9kZWwuQXJ0aWZhY3QkRGF0YUh1YgEAggECAP7///8PAKRBcnRpZmFjdCRJbXBvcnRzJERlcGVuZGVuY3kkRXhjbHVkZQAAAABBcnRpZmFjdCREYXRhSHXiAQABAQABQXJ0aWZhY3QkSW1wb3J0cyREZXBlbmRlbmP5AQACQ29uY2Vw9AEAAalpby5pbnRpbm8ubGVnaW8ubW9kZWwuQXJ0aWZhY3QkQXJjaGV0eXBlAQCCAQIA/v///w8ApEFydGlmYWN0JEltcG9ydHMkRGVwZW5kZW5jeSRFeGNsdWRlAAAAAEFydGlmYWN0JEFyY2hldHlw5QEAAQEAAUFydGlmYWN0JEltcG9ydHMkRGVwZW5kZW5j+QEAAkNvbmNlcPQBAAGnaW8uaW50aW5vLmxlZ2lvLm1vZGVsLkFydGlmYWN0JEltcG9ydHMBAIcBAgD+////DwBBcnRpZmFjdCRJbXBvcnRzJERlcGVuZGVuY/n+////DwBBcnRpZmFjdCRJbXBvcnRzJENvbXBpbOX+////DwBBcnRpZmFjdCRJbXBvcnRzJFJ1bnRpbeX+////DwBBcnRpZmFjdCRJbXBvcnRzJFByb3ZpZGXk/v///w8AQXJ0aWZhY3QkSW1wb3J0cyRUZXP0/v///w8AQXJ0aWZhY3QkSW1wb3J0cyRXZeIAAAAAQXJ0aWZhY3QkSW1wb3J08wEAAQEAAYABAAJDb25jZXD0AQABsmlvLmludGluby5sZWdpby5tb2RlbC5BcnRpZmFjdCRJbXBvcnRzJERlcGVuZGVuY3kBAIIBAgD+////DwCkQXJ0aWZhY3QkSW1wb3J0cyREZXBlbmRlbmN5JEV4Y2x1ZGUBAAAAQXJ0aWZhY3QkSW1wb3J0cyREZXBlbmRlbmP5AQABAQABTGlicmFy+QEAAkNvbmNlcPQBAIUBAwBlZmZlY3RpdmVWZXJzaW/uAQCCAwCBdHJhbnNpdGl25QEAggUAAXJlc29sdmXkAQCCBQAAdG9Nb2R1bOUBAIIFAAC6aW8uaW50aW5vLmxlZ2lvLm1vZGVsLkFydGlmYWN0JEltcG9ydHMkRGVwZW5kZW5jeSRFeGNsdWRlAQABAAAAAKRBcnRpZmFjdCRJbXBvcnRzJERlcGVuZGVuY3kkRXhjbHVkZQEAAQEAAYABAAJDb25jZXD0AQABygFpby5pbnRpbm8ubGVnaW8ubW9kZWwuQXJ0aWZhY3QkSW1wb3J0cyREZXBlbmRlbmN5JEFydGlmYWN0VmVyc2lvbkZvbGxvd2VyAQABAAEAALRBcnRpZmFjdCRJbXBvcnRzJERlcGVuZGVuY3kkQXJ0aWZhY3RWZXJzaW9uRm9sbG93ZXIBAAEBAAGAAQACRmFjZfQBAAGvaW8uaW50aW5vLmxlZ2lvLm1vZGVsLkFydGlmYWN0JEltcG9ydHMkQ29tcGlsZQEAggECAP7///8PAKRBcnRpZmFjdCRJbXBvcnRzJERlcGVuZGVuY3kkRXhj";
	}

	private static String stash1() {
		return "bHVkZQAAAABBcnRpZmFjdCRJbXBvcnRzJENvbXBpbOUBAAEBAAFBcnRpZmFjdCRJbXBvcnRzJERlcGVuZGVuY/kBAAJDb25jZXD0AQABr2lvLmludGluby5sZWdpby5tb2RlbC5BcnRpZmFjdCRJbXBvcnRzJFJ1bnRpbWUBAIIBAgD+////DwCkQXJ0aWZhY3QkSW1wb3J0cyREZXBlbmRlbmN5JEV4Y2x1ZGUAAAAAQXJ0aWZhY3QkSW1wb3J0cyRSdW50aW3lAQABAQABQXJ0aWZhY3QkSW1wb3J0cyREZXBlbmRlbmP5AQACQ29uY2Vw9AEAAbBpby5pbnRpbm8ubGVnaW8ubW9kZWwuQXJ0aWZhY3QkSW1wb3J0cyRQcm92aWRlZAEAggECAP7///8PAKRBcnRpZmFjdCRJbXBvcnRzJERlcGVuZGVuY3kkRXhjbHVkZQAAAABBcnRpZmFjdCRJbXBvcnRzJFByb3ZpZGXkAQABAQABQXJ0aWZhY3QkSW1wb3J0cyREZXBlbmRlbmP5AQACQ29uY2Vw9AEAAaxpby5pbnRpbm8ubGVnaW8ubW9kZWwuQXJ0aWZhY3QkSW1wb3J0cyRUZXN0AQCCAQIA/v///w8ApEFydGlmYWN0JEltcG9ydHMkRGVwZW5kZW5jeSRFeGNsdWRlAAAAAEFydGlmYWN0JEltcG9ydHMkVGVz9AEAAQEAAUFydGlmYWN0JEltcG9ydHMkRGVwZW5kZW5j+QEAAkNvbmNlcPQBAAGraW8uaW50aW5vLmxlZ2lvLm1vZGVsLkFydGlmYWN0JEltcG9ydHMkV2ViAQABAAAAAEFydGlmYWN0JEltcG9ydHMkV2XiAQABAQABTGlicmFy+QEAAkNvbmNlcPQBAIIBAwByZXNvbHZl5AEAggUAAMMBaW8uaW50aW5vLmxlZ2lvLm1vZGVsLkFydGlmYWN0JEltcG9ydHMkV2ViJEFydGlmYWN0VmVyc2lvbkZvbGxvd2VyAQABAAEAAK1BcnRpZmFjdCRJbXBvcnRzJFdlYiRBcnRpZmFjdFZlcnNpb25Gb2xsb3dlcgEAAQEAAYABAAJGYWNl9AEAAappby5pbnRpbm8ubGVnaW8ubW9kZWwuQXJ0aWZhY3QkV2ViSW1wb3J0cwEAhAECAP7///8PAEFydGlmYWN0JFdlYkltcG9ydHMkUmVzb2x1dGlv7v7///8PAEFydGlmYWN0JFdlYkltcG9ydHMkV2ViQ29tcG9uZW70/v///w8AQXJ0aWZhY3QkV2ViSW1wb3J0cyRXZWJBcnRpZmFj9AAAAABBcnRpZmFjdCRXZWJJbXBvcnTzAQABAQABgAEAAkNvbmNlcPQBAIIBAwB3ZWJEaXJlY3RvcvkBAIIDAGxp4rVpby5pbnRpbm8ubGVnaW8ubW9kZWwuQXJ0aWZhY3QkV2ViSW1wb3J0cyRSZXNvbHV0aW9uAQABAAAAAEFydGlmYWN0JFdlYkltcG9ydHMkUmVzb2x1dGlv7gEAAQEAAYABAAJDb25jZXD0AQABt2lvLmludGluby5sZWdpby5tb2RlbC5BcnRpZmFjdCRXZWJJbXBvcnRzJFdlYkNvbXBvbmVudAEAAQAAAABBcnRpZmFjdCRXZWJJbXBvcnRzJFdlYkNvbXBvbmVu9AEAAQEAAYABAAJDb25jZXD0AQCCAQMAdXLsAQCCAwCBtmlvLmludGluby5sZWdpby5tb2RlbC5BcnRpZmFjdCRXZWJJbXBvcnRzJFdlYkFydGlmYWN0AQABAAAAAEFydGlmYWN0JFdlYkltcG9ydHMkV2ViQXJ0aWZhY/QBAAEBAAFMaWJyYXL5AQACQ29uY2Vw9AEAAaRpby5pbnRpbm8ubGVnaW8ubW9kZWwuQXJ0aWZhY3QkQ29kZQEAAQAAAABBcnRpZmFjdCRDb2TlAQABAQABgAEAAkNvbmNlcPQBAAGsaW8uaW50aW5vLmxlZ2lvLm1vZGVsLkFydGlmYWN0JEludGlub1BsdWdpbgEAAQAAAABBcnRpZmFjdCRJbnRpbm9QbHVnae4BAAEBAAFMaWJyYXL5AQACQ29uY2Vw9AEAggEDAHBoYXPlAQCCAwBQcmVQYWNrYWflp2lvLmludGluby5sZWdpby5tb2RlbC5BcnRpZmFjdCRQYWNrYWdlAQCCAQIA/v///w8AQXJ0aWZhY3QkUGFja2FnZSRNYXZlblBsdWdp7gAAAABBcnRpZmFjdCRQYWNrYWflAQABAQABgAEAAkNvbmNlcPQBAIcBAwBjcmVhdGVNYXZlblBv7QEAggUAAGF0dGFjaFNvdXJjZfMBAIIFAABhdHRhY2hEb+MBAIIFAABpbmNsdWRlVGVzdPMBAIIFAABzaWduQXJ0aWZhY3RXaXRoR3DnAQCCBQAAZGVmYXVsdEpWTU9wdGlvbvMBAIIDAIGzaW8uaW50aW5vLmxlZ2lvLm1vZGVsLkFydGlmYWN0JFBhY2thZ2UkTWF2ZW5QbHVnaW4BAAEAAAAAQXJ0aWZhY3QkUGFja2FnZSRNYXZlblBsdWdp7gEAAQEAAYABAAJDb25jZXD0AQABsGlvLmludGluby5sZWdpby5tb2RlbC5BcnRpZmFjdCRQYWNrYWdlJFJ1bm5hYmxlAQABAAEAAEFydGlmYWN0JFBhY2thZ2UkUnVubmFibOUBAAEBAAGAAQACRmFjZfQBAAGwaW8uaW50aW5vLmxlZ2lvLm1vZGVsLkFydGlmYWN0JFBhY2thZ2UkTWFjT1NBcHABAAEAAQAAQXJ0aWZhY3QkUGFja2FnZSRNYWNPU0Fw8AEAAQEAAYABAAJGYWNl9AEAAbJpby5pbnRpbm8ubGVnaW8ubW9kZWwuQXJ0aWZhY3QkUGFja2FnZSRXaW5kb3dzQXBwAQABAAEAAEFydGlmYWN0JFBhY2thZ2UkV2luZG93c0Fw8AEAAQEAAYABAAJGYWNl9AEAAbRpby5pbnRpbm8ubGVnaW8ubW9kZWwuQXJ0aWZhY3QkUGFja2FnZSRMaW51eFNlcnZpY2UBAAEAAQAAQXJ0aWZhY3QkUGFja2FnZSRMaW51eFNlcnZpY+UBAAEBAAGAAQACRmFjZfQBAAGsaW8uaW50aW5vLmxlZ2lvLm1vZGVsLkFydGlmYWN0JERpc3RyaWJ1dGlvbgEAgwECAP7///8PAKJBcnRpZmFjdCREaXN0cmlidXRpb24kQXJ0aWZhY3RvcnkCAKJBcnRpZmFjdCREaXN0cmlidXRpb24kT25CaXRidWNrZXQAAAAAQXJ0aWZhY3QkRGlzdHJpYnV0aW/uAQABAQABgAEAAkNvbmNlcPQBAIIBAwBkaXN0cmlidXRlTGFuZ3VhZ+UBAIIFAAG4aW8uaW50aW5vLmxlZ2lvLm1vZGVsLkFydGlmYWN0JERpc3RyaWJ1dGlvbiRBcnRpZmFjdG9yeQEAgwECAAIAqkFydGlmYWN0JERpc3RyaWJ1dGlvbiRBcnRpZmFjdG9yeSRSZWxlYXNlAgCrQXJ0aWZhY3QkRGlzdHJpYnV0aW9uJEFydGlmYWN0b3J5JFNuYXBzaG90AAAAAKJBcnRpZmFjdCREaXN0cmlidXRpb24kQXJ0aWZhY3RvcnkBAAEBAAGAAQACQ29uY2Vw9AEAAcABaW8uaW50aW5vLmxlZ2lvLm1vZGVsLkFydGlmYWN0JERpc3RyaWJ1dGlvbiRBcnRpZmFjdG9yeSRSZWxlYXNlAQABAAAAAKpBcnRpZmFjdCREaXN0cmlidXRpb24kQXJ0aWZhY3RvcnkkUmVsZWFzZQEAAQEAAYABAAJDb25jZXD0AQABwQFpby5pbnRpbm8ubGVnaW8ubW9kZWwuQXJ0aWZhY3QkRGlzdHJpYnV0aW9uJEFydGlmYWN0b3J5JFNuYXBzaG90AQABAAAAAKtBcnRpZmFjdCREaXN0cmlidXRpb24kQXJ0";
	}

	private static String stash2() {
		return "aWZhY3RvcnkkU25hcHNob3QBAAEBAAGAAQACQ29uY2Vw9AEAAbhpby5pbnRpbm8ubGVnaW8ubW9kZWwuQXJ0aWZhY3QkRGlzdHJpYnV0aW9uJE9uQml0YnVja2V0AQABAAAAAKJBcnRpZmFjdCREaXN0cmlidXRpb24kT25CaXRidWNrZXQBAAEBAAGAAQACQ29uY2Vw9AEAAbBpby5pbnRpbm8ubGVnaW8ubW9kZWwuQXJ0aWZhY3QkUXVhbGl0eUFuYWx5dGljcwEAggECAAIAqUFydGlmYWN0JFF1YWxpdHlBbmFseXRpY3MkQXV0aGVudGljYXRpb24AAAAAQXJ0aWZhY3QkUXVhbGl0eUFuYWx5dGlj8wEAAQEAAYABAAJDb25jZXD0AQABv2lvLmludGluby5sZWdpby5tb2RlbC5BcnRpZmFjdCRRdWFsaXR5QW5hbHl0aWNzJEF1dGhlbnRpY2F0aW9uAQABAAAAAKlBcnRpZmFjdCRRdWFsaXR5QW5hbHl0aWNzJEF1dGhlbnRpY2F0aW9uAQABAQABgAEAAkNvbmNlcPQBAAGqaW8uaW50aW5vLmxlZ2lvLm1vZGVsLkFydGlmYWN0JERlcGxveW1lbnQBAIMBAgACAEFydGlmYWN0JERlcGxveW1lbnQkQnVnVHJhY2tpbucCAEFydGlmYWN0JERlcGxveW1lbnQkUmVxdWlyZW1lbnTzAAAAAEFydGlmYWN0JERlcGxveW1lbvQBAAEBAAGAAQACQ29uY2Vw9AEAAbZpby5pbnRpbm8ubGVnaW8ubW9kZWwuQXJ0aWZhY3QkRGVwbG95bWVudCRCdWdUcmFja2luZwEAAQAAAABBcnRpZmFjdCREZXBsb3ltZW50JEJ1Z1RyYWNraW7nAQABAQABgAEAAkNvbmNlcPQBAAG3aW8uaW50aW5vLmxlZ2lvLm1vZGVsLkFydGlmYWN0JERlcGxveW1lbnQkUmVxdWlyZW1lbnRzAQCHAQIAAgClQXJ0aWZhY3QkRGVwbG95bWVudCRSZXF1aXJlbWVudHMkSEREAgCoQXJ0aWZhY3QkRGVwbG95bWVudCRSZXF1aXJlbWVudHMkTWVtb3J5AgClQXJ0aWZhY3QkRGVwbG95bWVudCRSZXF1aXJlbWVudHMkQ1BVAgClQXJ0aWZhY3QkRGVwbG95bWVudCRSZXF1aXJlbWVudHMkSlZNAgCjQXJ0aWZhY3QkRGVwbG95bWVudCRSZXF1aXJlbWVudHMkUgIAsUFydGlmYWN0JERlcGxveW1lbnQkUmVxdWlyZW1lbnRzJFN5bmNEaXJlY3RvcmllcwAAAABBcnRpZmFjdCREZXBsb3ltZW50JFJlcXVpcmVtZW508wEAAQEAAYABAAJDb25jZXD0AQABu2lvLmludGluby5sZWdpby5tb2RlbC5BcnRpZmFjdCREZXBsb3ltZW50JFJlcXVpcmVtZW50cyRIREQBAAEAAAAApUFydGlmYWN0JERlcGxveW1lbnQkUmVxdWlyZW1lbnRzJEhERAEAAQEAAYABAAJDb25jZXD0AQABvmlvLmludGluby5sZWdpby5tb2RlbC5BcnRpZmFjdCREZXBsb3ltZW50JFJlcXVpcmVtZW50cyRNZW1vcnkBAAEAAAAAqEFydGlmYWN0JERlcGxveW1lbnQkUmVxdWlyZW1lbnRzJE1lbW9yeQEAAQEAAYABAAJDb25jZXD0AQABu2lvLmludGluby5sZWdpby5tb2RlbC5BcnRpZmFjdCREZXBsb3ltZW50JFJlcXVpcmVtZW50cyRDUFUBAAEAAAAApUFydGlmYWN0JERlcGxveW1lbnQkUmVxdWlyZW1lbnRzJENQVQEAAQEAAYABAAJDb25jZXD0AQABu2lvLmludGluby5sZWdpby5tb2RlbC5BcnRpZmFjdCREZXBsb3ltZW50JFJlcXVpcmVtZW50cyRKVk0BAAEAAAAApUFydGlmYWN0JERlcGxveW1lbnQkUmVxdWlyZW1lbnRzJEpWTQEAAQEAAYABAAJDb25jZXD0AQABuWlvLmludGluby5sZWdpby5tb2RlbC5BcnRpZmFjdCREZXBsb3ltZW50JFJlcXVpcmVtZW50cyRSAQABAAAAAKNBcnRpZmFjdCREZXBsb3ltZW50JFJlcXVpcmVtZW50cyRSAQABAQABgAEAAkNvbmNlcPQBAAHHAWlvLmludGluby5sZWdpby5tb2RlbC5BcnRpZmFjdCREZXBsb3ltZW50JFJlcXVpcmVtZW50cyRTeW5jRGlyZWN0b3JpZXMBAIIBAgD+////DwK0QXJ0aWZhY3QkRGVwbG95bWVudCRSZXF1aXJlbWVudHMkU3luY0RpcmVjdG9yaWVzJFRvAAAAALFBcnRpZmFjdCREZXBsb3ltZW50JFJlcXVpcmVtZW50cyRTeW5jRGlyZWN0b3JpZXMBAAEBAAGAAQACQ29uY2Vw9AEAAcoBaW8uaW50aW5vLmxlZ2lvLm1vZGVsLkFydGlmYWN0JERlcGxveW1lbnQkUmVxdWlyZW1lbnRzJFN5bmNEaXJlY3RvcmllcyRUbwEAAQAAAAC0QXJ0aWZhY3QkRGVwbG95bWVudCRSZXF1aXJlbWVudHMkU3luY0RpcmVjdG9yaWVzJFRvAQABAQABgAEAAkNvbmNlcPQBAAGnaW8uaW50aW5vLmxlZ2lvLm1vZGVsLlJ1bkNvbmZpZ3VyYXRpb24BAIIBAgD+////DwBBcmd1bWVu9AAAAQBSdW5Db25maWd1cmF0aW/uAQABAQABgAEAAkNvbmNlcPQBAIMBAwBtYWluQ2xhc/MBAIIDAIF2bU9wdGlvbvMBAIIDAIFpby5pbnRpbm8ubGVnaW8ubW9kZWwuU2VydmXyAQABAAABAFNlcnZl8gEAAQEAAYABAAJDb25jZXD0AQABaW8uaW50aW5vLmxlZ2lvLm1vZGVsLlJlcG9zaXRvcvkBAIQBAgD+////DwBSZXBvc2l0b3J5JFR5cOUCAFJlcG9zaXRvcnkkUmVsZWFz5QIAUmVwb3NpdG9yeSRTbmFwc2hv9AAAAQBSZXBvc2l0b3L5AQABAQABgAEAAkNvbmNlcPQBAAGmaW8uaW50aW5vLmxlZ2lvLm1vZGVsLlJlcG9zaXRvcnkkVHlwZQEAAQEAAABSZXBvc2l0b3J5JFR5cOUBAAEBAAGAAQACQ29uY2Vw9AEAggEDAHVwZGF0ZVBvbGlj+QEAggMARGFpbPmpaW8uaW50aW5vLmxlZ2lvLm1vZGVsLlJlcG9zaXRvcnkkUmVsZWFzZQEAAQAAAABSZXBvc2l0b3J5JFJlbGVhc+UBAAEBAAFSZXBvc2l0b3J5JFR5cOUBAAJDb25jZXD0AQCCAQMAdXBkYXRlUG9saWP5AQCCAwBEYWls+appby5pbnRpbm8ubGVnaW8ubW9kZWwuUmVwb3NpdG9yeSRTbmFwc2hvdAEAAQAAAABSZXBvc2l0b3J5JFNuYXBzaG/0AQABAQABUmVwb3NpdG9yeSRUeXDlAQACQ29uY2Vw9AEAggEDAHVwZGF0ZVBvbGlj+QEAggMAQWx3YXnzaW8uaW50aW5vLmxlZ2lvLm1vZGVsLlBhcmFtZXRl8gEAAQAAAABQYXJhbWV0ZfIBAAEBAAGAAQACQ29uY2Vw9AEAggEDAGRlc2NyaXB0aW/uAQCCAwCBrmlvLmludGluby5sZWdpby5tb2RlbC5QYXJhbWV0ZXIkQXJjaGV0eXBlUm9vdAEAAQABAABQYXJhbWV0ZXIkQXJjaGV0eXBlUm9v9AEAAQEAAYABAAJGYWNl9AEAAWlvLmludGluby5sZWdpby5tb2RlbC5Bcmd1bWVu9AEAAQAAAABBcmd1bWVu9AEAAQEAAYABAAJDb25jZXD0AQABaW8uaW50aW5vLmxlZ2lvLm1vZGVsLkxp";
	}

	private static String stash3() {
		return "YnJhcvkBAAEBAAEATGlicmFy+QEAAQEAAYABAAJDb25jZXD0AQABaW8uaW50aW5vLmxlZ2lvLm1vZGVsLlByb2plY/QBAIUBAgACAFByb2plY3QkU2Pt/v///w8AUHJvamVjdCREZXZlbG9wZfL+////DwBTZXJ2ZfL+////DwBSZXBvc2l0b3L5AAABAFByb2plY/QBAAEBAAGAAQACQ29uY2Vw9AEAAaJpby5pbnRpbm8ubGVnaW8ubW9kZWwuUHJvamVjdCRTY20BAAEAAAAAUHJvamVjdCRTY+0BAAEBAAGAAQACQ29uY2Vw9AEAAahpby5pbnRpbm8ubGVnaW8ubW9kZWwuUHJvamVjdCREZXZlbG9wZXIBAAEAAAAAUHJvamVjdCREZXZlbG9wZfIBAAEBAAGAAQACQ29uY2Vw9AEAAQEAhwECAAICQXJ0aWZhY/T+////DwBSdW5Db25maWd1cmF0aW/u/v///w8AU2VydmXy/v///w8AUmVwb3NpdG9y+f7///8PAExpYnJhcvkCAFByb2plY/RQcm90Ze8BAAFNYWluLnN0YXPoAQABgA==";
	}

	public class Create {
		private final String stash;
		private final String name;

		public Create(String stash, String name) {
			this.stash = stash;
			this.name = name;
		}

		public Artifact artifact(String groupId, String version) {
			Artifact newElement = (Artifact)((Artifact)AbstractGraph.this.graph.createRoot(Artifact.class, this.stash, this.name)).a$(Artifact.class);
			newElement.core$().set(newElement, "groupId", Collections.singletonList(groupId));
			newElement.core$().set(newElement, "version", Collections.singletonList(version));
			return newElement;
		}

		public RunConfiguration runConfiguration() {
			RunConfiguration newElement = (RunConfiguration)((RunConfiguration)AbstractGraph.this.graph.createRoot(RunConfiguration.class, this.stash, this.name)).a$(RunConfiguration.class);
			return newElement;
		}

		public Server server(Server.Type type) {
			Server newElement = (Server)((Server)AbstractGraph.this.graph.createRoot(Server.class, this.stash, this.name)).a$(Server.class);
			newElement.core$().set(newElement, "type", Collections.singletonList(type));
			return newElement;
		}

		public Repository repository(String identifier) {
			Repository newElement = (Repository)((Repository)AbstractGraph.this.graph.createRoot(Repository.class, this.stash, this.name)).a$(Repository.class);
			newElement.core$().set(newElement, "identifier", Collections.singletonList(identifier));
			return newElement;
		}

		public Project project() {
			Project newElement = (Project)((Project)AbstractGraph.this.graph.createRoot(Project.class, this.stash, this.name)).a$(Project.class);
			return newElement;
		}
	}

	public class Clear {
		public void runConfiguration(Predicate<RunConfiguration> filter) {
			(new ArrayList<>(AbstractGraph.this.runConfigurationList())).stream().filter(filter).forEach(Layer::delete$);
		}

		public void server(Predicate<Server> filter) {
			(new ArrayList<>(AbstractGraph.this.serverList())).stream().filter(filter).forEach(Layer::delete$);
		}

		public void repository(Predicate<Repository> filter) {
			(new ArrayList<>(AbstractGraph.this.repositoryList())).stream().filter(filter).forEach(Layer::delete$);
		}
	}

	public static class Indexer {
		Add add;
		Remove remove;
		IndexClear clear;

		public Indexer(Add add, Remove remove, IndexClear clear) {
			this.add = add;
			this.remove = remove;
			this.clear = clear;
		}

		void add(Node node) {
			this.add.add(node);
		}

		void remove(Node node) {
			this.remove.remove(node);
		}

		void clear() {
			this.clear.clear();
		}
	}

	interface Add {
		void add(Node var1);
	}

	interface IndexClear {
		void clear();
	}

	interface Remove {
		void remove(Node var1);
	}
}
