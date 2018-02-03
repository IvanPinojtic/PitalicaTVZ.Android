package tvz.pitalicatvz.remote;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import tvz.pitalicatvz.User;

/**
 * Created by Ivan on 2/3/2018.
 */

public interface APIService {

    @POST("/api/Users/TryGetUser")
    @FormUrlEncoded
    Call<User> sendUser(@Field("fullName") String fullName,
                        @Field("password") String password);

    @POST("/posts")
    @FormUrlEncoded
    Call<Post> savePost(@Field("title") String title,
                        @Field("body") String body,
                        @Field("userId") long userId);
}