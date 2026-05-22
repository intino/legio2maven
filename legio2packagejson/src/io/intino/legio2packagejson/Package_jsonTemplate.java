package io.intino.legio2packagejson;

import io.intino.itrules.template.Rule;
import io.intino.itrules.template.Template;

import java.util.ArrayList;
import java.util.List;

import static io.intino.itrules.template.condition.predicates.Predicates.*;
import static io.intino.itrules.template.outputs.Outputs.*;

public class Package_jsonTemplate extends Template {

	public List<Rule> ruleSet() {
		List<Rule> rules = new ArrayList<>();
		rules.add(rule().condition(allTypes("package")).output(literal("{\n    \"name\": \"")).output(placeholder("artifactId")).output(literal("\",\n    \"version\": \"")).output(placeholder("version")).output(literal("\",\n    \"description\": \"\",\n    \"main\": \"src/App.js\",\n    \"scripts\": {\n        \"build\": \"NODE_OPTIONS='--openssl-legacy-provider --no-deprecation' webpack --mode production\",\n                \"dev\": \"NODE_OPTIONS='--openssl-legacy-provider --no-deprecation' webpack --mode development --watch\"\n    },\n    \"author\": \"\",\n    \"license\": \"ISC\",\n    \"devDependencies\": {\n        ")).output(placeholder("packDependency", "dependency").multiple(",\n")).output(literal("\n    },\n    \"dependencies\": {\n        ")).output(placeholder("dependency").multiple(",\n")).output(literal("\n    },\n    \"resolutions\" : {\n    \t")).output(placeholder("resolution").multiple(",\n")).output(literal("\n    }\n}")));
		rules.add(rule().condition(trigger("dependency")).output(literal(" \"")).output(placeholder("name")).output(literal("\": \"")).output(placeholder("version")).output(literal("\"")));
		rules.add(rule().condition(trigger("resolution")).output(literal(" \"")).output(placeholder("name")).output(literal("\": \"")).output(placeholder("version")).output(literal("\"")));
		rules.add(rule().condition(trigger("fsevents")).output(literal("\"fsevents\": \"^2.1.2\",")));
		return rules;
	}

	public String render(Object object) {
		return new io.intino.itrules.Engine(this).render(object);
	}

	public String render(Object object, java.util.Map<String, io.intino.itrules.Formatter> formatters) {
		return new io.intino.itrules.Engine(this).addAll(formatters).render(object);
	}
}