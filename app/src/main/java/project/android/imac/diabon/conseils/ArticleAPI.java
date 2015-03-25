package project.android.imac.diabon.conseils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import project.android.imac.diabon.alimentation.AlimentationService;
import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

/**
 * Created by Brice on 25/03/2015.
 */
public class ArticleAPI {

    private static ArticleService singleton;

    public static ArticleService getInstance() {
        if(singleton == null) {
            Gson gson = new GsonBuilder()
                    //.setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                    .create();

            RestAdapter restAdapter = new RestAdapter.Builder()
                    .setEndpoint("http://briceberthelot.alwaysdata.net/api")
                    .setConverter(new GsonConverter(gson))
                    .build();

            singleton = restAdapter.create(ArticleService.class);
        }
        return singleton;

    }

}