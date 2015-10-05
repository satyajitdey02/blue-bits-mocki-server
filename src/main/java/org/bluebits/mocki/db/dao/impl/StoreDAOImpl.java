package org.bluebits.mocki.db.dao.impl;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import org.bluebits.mocki.api.Store;
import org.bluebits.mocki.db.dao.StoreDAO;
import org.mongojack.DBCursor;
import org.mongojack.DBQuery;
import org.mongojack.JacksonDBCollection;
import org.mongojack.WriteResult;

import java.util.List;

/**
 * Created by satyajit on 9/30/15.
 */
public class StoreDAOImpl implements StoreDAO {
  private static final String STORE_COLLECTION_NAME = "store";
  private final JacksonDBCollection<Store, String> collection;

  public StoreDAOImpl(DB db) {
    this.collection = JacksonDBCollection.wrap(db.getCollection(STORE_COLLECTION_NAME), Store.class, String.class);
  }

  @Override
  public Store saveStore(Store store) {
    WriteResult<Store, String> result = this.collection.insert(store);
    return result.getSavedObject();
  }

  @Override
  public Store findById(String id) {
    return this.collection.findOne(DBQuery.is("storeId", id));
  }

  @Override
  public List<Store> findAll() {
    return this.collection.find().toArray();
  }
}
