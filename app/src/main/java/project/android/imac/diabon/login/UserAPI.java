package project.android.imac.diabon.login;

import android.util.Base64;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.okhttp.OkHttpClient;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.client.OkClient;
import retrofit.converter.GsonConverter;


/**
 * Created by Brice on 25/03/2015.
 */
public class UserAPI {
    private static UserService singleton;

    public static UserService getInstance(String username, String password) {
        if(singleton == null) {
            Gson gson = new GsonBuilder()
                    //.setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                    .create();

            RestAdapter.Builder builder = new RestAdapter.Builder()
                    .setEndpoint("http://briceberthelot.alwaysdata.net/api")
                    .setConverter(new GsonConverter(gson))
                    .setClient(new OkClient(new OkHttpClient()));

            if (username != null && password != null) {
                // concatenate username and password with colon for authentication
                final String credentials = username + ":" + password;

                builder.setRequestInterceptor(new RequestInterceptor() {
                    @Override
                    public void intercept(RequestFacade request) {
                        // create Base64 encodet string
                        String string = "Basic " + Base64.encodeToString(credentials.getBytes(), Base64.NO_WRAP);
                        request.addHeader("Accept", "application/json");
                        request.addHeader("Authorization", string);
                    }
                });
            }

            RestAdapter adapter = builder.build();


            singleton = adapter.create(UserService.class);
        }
        return singleton;

    }
}
