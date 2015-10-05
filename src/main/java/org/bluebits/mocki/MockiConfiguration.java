package org.bluebits.mocki;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * Created by satyajit on 9/22/15.
 */
public class MockiConfiguration extends Configuration {
    @JsonProperty
    @NotEmpty
    public String mongohost = "127.0.0.1";

    @JsonProperty
    @Min(1)
    @Max(65535)
    public int mongoport = 27017;

    @JsonProperty
    @NotEmpty
    public String mongodb = "mocki";
}
