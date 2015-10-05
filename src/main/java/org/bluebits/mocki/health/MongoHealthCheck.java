package org.bluebits.mocki.health;

import com.codahale.metrics.health.HealthCheck;
import com.mongodb.Mongo;


/**
 * Created by satyajit on 9/23/15.
 */
public class MongoHealthCheck extends HealthCheck {
    private Mongo mongo;

    public MongoHealthCheck(Mongo mongo) {
        this.mongo = mongo;
    }

    @Override
    protected Result check() throws Exception {
        mongo.getDatabaseNames();
        return HealthCheck.Result.healthy();
    }
}
