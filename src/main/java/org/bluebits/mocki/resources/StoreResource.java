package org.bluebits.mocki.resources;

import com.codahale.metrics.annotation.Timed;
import org.bluebits.mocki.api.Store;
import org.bluebits.mocki.db.dao.StoreDAO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by satyajit on 9/23/15.
 */

@Path("/store")
public class StoreResource {
  private final StoreDAO storeDAO;

  public StoreResource(StoreDAO storeDAO) {
    this.storeDAO = storeDAO;
  }

  @GET
  @Path("/list")
  @Produces(value = MediaType.APPLICATION_JSON)
  @Timed(name = "get-store-list")
  public List<Store> getStores() {
    return storeDAO.findAll();
  }

  @GET
  @Path("/{storeId}")
  @Produces(value = MediaType.APPLICATION_JSON)
  @Timed(name = "get-single-store")
  public Store fetch(@PathParam("storeId") String storeId) {
    return storeDAO.findById(storeId);
  }

  @POST
  @Consumes(value = MediaType.APPLICATION_JSON)
  @Produces(value = MediaType.APPLICATION_JSON)
  @Timed(name = "save-single-store")
  public Store save(Store store) {
    return storeDAO.saveStore(store);
  }
}
