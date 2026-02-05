package io.intino.legio.model.natives.artifact.model;

/**#/Users/oroncal/workspace/infrastructure/intino-plugin/legio/src/io/intino/legio/model/Main.tara#31#2**/
public class OutLanguage_0 implements io.intino.magritte.framework.Expression<String> {
	private io.intino.legio.model.Artifact.Model self;

	@Override
	public String value() {
		return self.graph().artifact().name$();
	}

	@Override
	public void self(io.intino.magritte.framework.Layer context) {
		self = (io.intino.legio.model.Artifact.Model) context;
	}

	@Override
	public Class<? extends io.intino.magritte.framework.Layer> selfClass() {
		return io.intino.legio.model.Artifact.Model.class;
	}
}