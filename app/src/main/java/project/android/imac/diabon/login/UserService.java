package project.android.imac.diabon.login;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.POST;
import retrofit.mime.TypedInput;

/**
 * Created by Brice on 25/03/2015.
 */
public interface UserService {
    @POST("/users")
    void login(@Body TypedInput in, Callback<Object> cb);
}
