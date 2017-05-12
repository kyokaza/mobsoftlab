package hu.bm.mobsoft.lab.costlog.network.costlogapi;

import hu.bm.mobsoft.lab.costlog.model.Item;


import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface ItemApi {
  
  /**
   * Find all item
   * Get all item
   * @return Call<List<Item>>
   */
  
  @GET("item")
  Call<List<Item>> itemGet();
    

  
  /**
   * Update item
   * update item
   * @param body Item needed
   * @return Call<Void>
   */
  
  @PUT("item")
  Call<Void> itemPut(
          @Body Item body
  );

  
  /**
   * add item to the cost manager
   * 
   * @param body add item
   * @return Call<Void>
   */
  
  @POST("item")
  Call<Void> itemPost(
          @Body Item body
  );

  
  /**
   * Delete item
   * Delete item
   * @param itemId Item id to delete
   * @return Call<Void>
   */
  
  @DELETE("item/{itemId}")
  Call<Void> itemItemIdDelete(
          @Path("itemId") String itemId
  );

  
}
