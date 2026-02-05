package io.intino.legio.model;

import io.intino.magritte.framework.Graph;

public class LegioGraph extends AbstractGraph {

	public LegioGraph(Graph graph) {
		super(graph);
	}

	public LegioGraph(Graph graph, LegioGraph wrapper) {
	    super(graph, wrapper);
	}


	public static LegioGraph load(io.intino.magritte.io.model.Stash... startingModel) {
		return new Graph().loadLanguage("Legio", _language()).loadStashes(startingModel).as(LegioGraph.class);
	}

	public static LegioGraph load(io.intino.magritte.framework.Store store, io.intino.magritte.io.model.Stash... startingModel) {
		return new Graph(store).loadLanguage("Legio", _language()).loadStashes(startingModel).as(LegioGraph.class);
	}

	public static LegioGraph load(String... startingModel) {
		return new Graph().loadLanguage("Legio", _language()).loadStashes(startingModel).as(LegioGraph.class);
	}

	public static LegioGraph load(io.intino.magritte.framework.Store store, String... startingModel) {
		return new Graph(store).loadLanguage("Legio", _language()).loadStashes(startingModel).as(LegioGraph.class);
	}
}