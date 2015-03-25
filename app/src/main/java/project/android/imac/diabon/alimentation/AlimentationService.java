package project.android.imac.diabon.alimentation;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by Brice on 12/03/2015.
 */
public interface AlimentationService {

        @GET("/foods/9/")
        void listAliments (@Path("id") String id, Callback < AlimentationResponse> cb);
}
