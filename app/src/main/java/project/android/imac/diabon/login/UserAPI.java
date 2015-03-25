package project.android.imac.diabon.login;

import retrofit.RestAdapter;

/**
 * Created by Brice on 25/03/2015.
 */
public class UserAPI {
    private static UserService singleton;

    public static UserService getInstance() {
        if(singleton == null) {

            RestAdapter restAdapter = new RestAdapter.Builder()
                    .setEndpoint("http://briceberthelot.alwaysdata.net/api")
                    .build();

            singleton = restAdapter.create(UserService.class);
        }
        return singleton;

    }
}
