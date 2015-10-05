package org.bluebits.mocki.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.bson.types.ObjectId;
import org.mongojack.Id;

/**
 * Created by satyajit on 9/23/15.
 */

public class Store {
  @Id
  ObjectId id;
  String storeId;
  String storeName;

  public Store() {
  }

  public Store(String storeId, String storeName) {
    this.storeId = storeId;
    this.storeName = storeName;
  }

  @JsonProperty
  public String getStoreId() {
    return storeId;
  }

  @JsonProperty
  public void setStoreId(String storeId) {
    this.storeId = storeId;
  }

  @JsonProperty
  public String getStoreName() {
    return storeName;
  }

  @JsonProperty
  public void setStoreName(String storeName) {
    this.storeName = storeName;
  }

  @Override
  public String toString() {
    return "{\"storeId\" : " + (storeId == null ? "null" : "\"" + storeId + "\"") + ", " +
        "\"storeName\" : " + (storeName == null ? "null" : "\"" + storeName + "\"") +
        "}";
  }
}
