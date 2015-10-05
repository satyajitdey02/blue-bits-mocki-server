package org.bluebits.mocki.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.bson.types.ObjectId;
import org.mongojack.Id;

/**
 * Created by satyajit on 9/28/15.
 */
public class Product {
  @Id
  ObjectId id;
  String productId;
  String productName;
  double unitPrice;

  public Product() {

  }

  public Product(String productId, String productName, double unitPrice) {
    this.productId = productId;
    this.productName = productName;
    this.unitPrice = unitPrice;
  }

  @JsonProperty
  public String getProductId() {
    return productId;
  }

  @JsonProperty
  public void setProductId(String productId) {
    this.productId = productId;
  }

  @JsonProperty
  public String getProductName() {
    return productName;
  }

  @JsonProperty
  public void setProductName(String productName) {
    this.productName = productName;
  }

  @JsonProperty
  public double getUnitPrice() {
    return unitPrice;
  }

  @JsonProperty
  public void setUnitPrice(double unitPrice) {
    this.unitPrice = unitPrice;
  }

  @Override
  public String toString() {
    return "{\"productId\" : " + (productId == null ? "null" : "\"" + productId + "\"") + ", " +
        "\"productName\" : " + (productName == null ? "null" : "\"" + productName + "\"") + ", " +
        "\"unitPrice\" : \"" + unitPrice + "\"" +
        "}";
  }
}
