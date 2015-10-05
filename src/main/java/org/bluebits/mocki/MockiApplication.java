package org.bluebits.mocki;

import com.mongodb.DB;
import com.mongodb.Mongo;
import io.dropwizard.Application;
import io.dropwizard.server.DefaultServerFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.bluebits.mocki.api.Store;
import org.bluebits.mocki.core.MongoManaged;
import org.bluebits.mocki.db.dao.ProductDAO;
import org.bluebits.mocki.db.dao.StoreDAO;
import org.bluebits.mocki.db.dao.impl.ProductDAOImpl;
import org.bluebits.mocki.db.dao.impl.StoreDAOImpl;
import org.bluebits.mocki.health.MongoHealthCheck;
import org.bluebits.mocki.resources.ProductResource;
import org.bluebits.mocki.resources.StoreResource;
import org.bluebits.mocki.util.MongoUtil;

/**
 * Created by satyajit on 9/29/15.
 */
public class MockiApplication extends Application<MockiConfiguration> {
  public static void main(String[] args) throws Exception {
    new MockiApplication().run(args);
  }

  @Override
  public String getName() {
    return "Mocki Server";
  }

  @Override
  public void initialize(Bootstrap<MockiConfiguration> bootstrap) {
    super.initialize(bootstrap);
  }

  @Override
  public void run(MockiConfiguration configuration, Environment environment) throws Exception {
    ((DefaultServerFactory) configuration.getServerFactory()).setJerseyRootPath("/mocki/api/*");

    Mongo mongo = new Mongo(configuration.mongohost, configuration.mongoport);
    MongoManaged mongoManaged = new MongoManaged(mongo);
    environment.lifecycle().manage(mongoManaged);
    environment.healthChecks().register("Mongo Health", new MongoHealthCheck(mongo));

    DB db = mongo.getDB(configuration.mongodb);
    StoreDAO storeDAO = new StoreDAOImpl(db);
    ProductDAO productDAO = new ProductDAOImpl(db);

    environment.jersey().register(new StoreResource(storeDAO));
    environment.jersey().register(new ProductResource(productDAO));
  }
}
