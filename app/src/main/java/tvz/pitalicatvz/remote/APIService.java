package tvz.pitalicatvz.remote;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import tvz.pitalicatvz.models.User;

/**
 * Created by Ivan on 2/3/2018.
 */

public interface APIService {

//region UserAPI
    @POST("/api/Users/TryGetUser")
    Call<User> tryGetUser(@Body User user);

    @GET("/api/Users")
    Call<List<User>> getUsers();

    @GET("/api/Users/{id}")
    Call<User> getUser(@Path("id") int id);

    @PUT("/api/Users/{id}")
    Call<User> putUser(@Path("id") int id, @Body User user);

    @POST("/api/Users")
    Call<User> postUser(@Body User user);

    @DELETE("/api/Users/{id}")
    Call<User> deleteUser(@Path("id") int id);
//endregion
}