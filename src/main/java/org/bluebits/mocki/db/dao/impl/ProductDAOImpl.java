package org.bluebits.mocki.db.dao.impl;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import org.bluebits.mocki.api.Product;
import org.bluebits.mocki.api.Store;
import org.bluebits.mocki.db.dao.ProductDAO;
import org.mongojack.DBQuery;
import org.mongojack.JacksonDBCollection;
import org.mongojack.WriteResult;

import java.util.List;

/**
 * Created by satyajit on 9/30/15.
 */
public class ProductDAOImpl implements ProductDAO {
  private static final String PRODUCT_COLLECTION_NAME = "product";
  private final JacksonDBCollection<Product, String> collection;

  public ProductDAOImpl(DB db) {
    this.collection = JacksonDBCollection.wrap(db.getCollection(PRODUCT_COLLECTION_NAME), Product.class, String.class);
  }

  @Override
  public Product saveProduct(Product product) {
    WriteResult<Product, String> result = this.collection.insert(product);
    return result.getSavedObject();
  }

  @Override
  public Product findById(String id) {
    return this.collection.findOne(DBQuery.is("productId", id));
  }

  @Override
  public List<Product> findAll() {
    return this.collection.find().toArray();
  }
}
