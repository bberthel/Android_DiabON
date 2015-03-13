package project.android.imac.diabon.alimentation;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

/**
 * Created by Brice on 12/03/2015.
 */
public class AlimentationAPI {

    private static AlimentationService singleton;

    public static AlimentationService getInstance() {
        if(singleton == null) {
            Gson gson = new GsonBuilder()
                    //.setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                    .create();

            RestAdapter restAdapter = new RestAdapter.Builder()
                    .setEndpoint("http://briceberthelot.alwaysdata.net/api")
                    .setConverter(new GsonConverter(gson))
                    .build();

            singleton = restAdapter.create(AlimentationService.class);
        }
        return singleton;

    }

}
