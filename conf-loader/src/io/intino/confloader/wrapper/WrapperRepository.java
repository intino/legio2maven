package io.intino.confloader.wrapper;


import io.intino.Configuration;
import io.intino.legio.model.Repository;

public class WrapperRepository implements Configuration.Repository {
	private final Repository r;

	public WrapperRepository(Repository r) {
		this.r = r;
	}

	@Override
	public String identifier() {
		return r.identifier();
	}

	@Override
	public String url() {
		return r.release().url();
	}

	@Override
	public String user() {
		return null;
	}

	@Override
	public String password() {
		return null;
	}

	@Override
	public Configuration root() {
		return null;
	}

	@Override
	public Configuration.ConfigurationNode owner() {
		return null;
	}
}
