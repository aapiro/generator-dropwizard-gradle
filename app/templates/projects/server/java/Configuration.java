package <%= package %>;

import static com.google.common.base.Preconditions.checkNotNull;

import <%= package %>.backend.DatabaseBackend;
import <%= package %>.backend.DatabaseConfiguration;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Environment;
import org.immutables.value.Value;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * Server configuration for the <%= name %> API server.
 */
@Value.Immutable
@JsonDeserialize(as = Immutable<%= className %>Configuration.class)
public abstract class <%= className %>Configuration extends Configuration {
    
    @JsonProperty("database")
    abstract DatabaseConfiguration getDatabaseConfiguration();

    public DatabaseBackend getDatabaseBackend(Environment environment) {
        return getDatabaseConfiguration().createDBI(environment, "jdbi-backend").onDemand(DatabaseBackend.class);
    }
}
