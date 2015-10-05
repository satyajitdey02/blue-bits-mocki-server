package org.bluebits.mocki.util;

import com.google.common.base.Strings;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import io.dropwizard.Configuration;
import org.bluebits.mocki.MockiConfiguration;
import org.bluebits.mocki.exceptions.MockiConfigurationException;

import java.net.UnknownHostException;

/**
 * Created by satyajit on 9/30/15.
 */
public class MongoUtil {

  public static DB connectDB(MockiConfiguration configuration) throws Exception {
    if (configuration == null) {
      throw new MockiConfigurationException("Mocki configurations can not be NULL.");
    }

    String host = configuration.mongohost;
    if (Strings.isNullOrEmpty(host)) {
      host = "localhost";
    }

    int port = configuration.mongoport;
    if (port <= 0 || port > 65535) {
      port = 27017;
    }

    String dbName = configuration.mongodb;
    if (Strings.isNullOrEmpty(dbName)) {
      dbName = "mocki";
    }

    MongoClient mongoClient = null;
    try {
      mongoClient = new MongoClient(host, port);
    } catch (UnknownHostException e) {
      throw e;
    }

    return mongoClient.getDB(dbName);
  }
}
