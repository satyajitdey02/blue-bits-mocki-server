package org.bluebits.mocki.db.dao;


import org.bluebits.mocki.api.Product;

import java.util.List;

/**
 * Created by satyajit on 9/30/15.
 */
public interface ProductDAO {
  public Product saveProduct(Product product);

  public Product findById(String id);

  public List<Product> findAll();
}
