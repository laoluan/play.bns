/**
 *   Copyright (C) 2011-2012 Typesafe Inc. <http://typesafe.com>
 */
package hexlab.config.impl;

import hexlab.config.ConfigIncludeContext;
import hexlab.config.ConfigParseOptions;
import hexlab.config.ConfigParseable;

class SimpleIncludeContext implements ConfigIncludeContext {

    private final Parseable parseable;

    SimpleIncludeContext(Parseable parseable) {
        this.parseable = parseable;
    }

    SimpleIncludeContext withParseable(Parseable parseable) {
        if (parseable == this.parseable)
            return this;
        else
            return new SimpleIncludeContext(parseable);
    }

    @Override
    public ConfigParseable relativeTo(String filename) {
        if (parseable != null)
            return parseable.relativeTo(filename);
        else
            return null;
    }

    @Override
    public ConfigParseOptions parseOptions() {
        return SimpleIncluder.clearForInclude(parseable.options());
    }
}
