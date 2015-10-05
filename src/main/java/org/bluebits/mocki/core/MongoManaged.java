package org.bluebits.mocki.core;

import com.mongodb.Mongo;
import io.dropwizard.lifecycle.Managed;

/**
 * Created by satyajit on 9/23/15.
 */
public class MongoManaged implements Managed {
    private Mongo mongo;

    public MongoManaged(Mongo mongo) {
        this.mongo = mongo;
    }

    @Override
    public void start() throws Exception {

    }

    @Override
    public void stop() throws Exception {
        mongo.close();
    }
}
