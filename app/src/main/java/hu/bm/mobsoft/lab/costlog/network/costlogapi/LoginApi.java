package hu.bm.mobsoft.lab.costlog.network.costlogapi;


import hu.bm.mobsoft.lab.costlog.model.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface LoginApi {
  
  /**
   * Login
   * 
   * @param body User in
   * @return Call<Void>
   */
  
  @POST("login")
  Call<Void> loginPost(
          @Body User body
  );

  
}
