package org.bluebits.mocki.resources;

import com.codahale.metrics.annotation.Timed;
import org.bluebits.mocki.api.Product;
import org.bluebits.mocki.db.dao.ProductDAO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by satyajit on 9/28/15.
 */

@Path("/product")
public class ProductResource {
  private final ProductDAO productDAO;

  public ProductResource(ProductDAO productDAO) {
    this.productDAO = productDAO;
  }

  @GET
  @Path("/list")
  @Produces(value = MediaType.APPLICATION_JSON)
  @Timed(name = "get-product-list")
  public List<Product> getProducts() {
    return productDAO.findAll();
  }

  @GET
  @Path("/{productId}")
  @Produces(value = MediaType.APPLICATION_JSON)
  @Timed(name = "get-single-product")
  public Product fetch(@PathParam("productId") String productId) {
    return productDAO.findById(productId);
  }

  @POST
  @Consumes(value = MediaType.APPLICATION_JSON)
  @Produces(value = MediaType.APPLICATION_JSON)
  @Timed(name = "save-single-product")
  public Product save(Product product) {
    return productDAO.saveProduct(product);
  }
}
