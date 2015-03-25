package project.android.imac.diabon.login;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;
import retrofit.mime.TypedInput;

/**
 * Created by Brice on 25/03/2015.
 */
public interface UserService {
    @GET("/users/{username}")
    void login(@Path("username") String username, Callback<Object> cb);
}
