package project.android.imac.diabon.conseils;

import java.util.List;

import project.android.imac.diabon.alimentation.Alimentation;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by Brice on 25/03/2015.
 */
public interface ArticleService {

    @GET("/articles/{id}")
    public void listArticles (@Path("id") String id, Callback <List<Article>> callback);

}
