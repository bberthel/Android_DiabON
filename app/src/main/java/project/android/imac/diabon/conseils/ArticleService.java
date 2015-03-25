package project.android.imac.diabon.conseils;

import project.android.imac.diabon.alimentation.AlimentationResponse;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by Brice on 25/03/2015.
 */
public interface ArticleService {

    @GET("/articles/9/")
    void listArticles (@Path("id") String id, Callback< ArticleResponse> cb);

}
