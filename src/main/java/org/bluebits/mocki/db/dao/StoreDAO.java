package org.bluebits.mocki.db.dao;

import org.bluebits.mocki.api.Store;

import java.util.List;

/**
 * Created by satyajit on 9/30/15.
 */
public interface StoreDAO {
  public Store saveStore(Store store);

  public Store findById(String id);

  public List<Store> findAll();
}
