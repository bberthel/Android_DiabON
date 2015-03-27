package project.android.imac.diabon;

        import android.app.ListFragment;
        import android.content.Context;
        import android.os.Bundle;
        import android.support.annotation.Nullable;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;

        import java.util.List;

        import project.android.imac.diabon.conseils.Article;
        import project.android.imac.diabon.conseils.ArticleAPI;
        import project.android.imac.diabon.conseils.ArticleService;
        import retrofit.Callback;
        import retrofit.RetrofitError;
        import retrofit.client.Response;

/**
 * Created by Florent on 26/03/2015.
 */
public class CategoryArticleFragment extends ListFragment {

    private Context mContext;
    private String id_cat;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.article_category, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // get the application context
        mContext = (CategoryArticleActivity)getActivity();
        id_cat= getActivity().getIntent().getStringExtra("id");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onStart (){
        super.onStart();
        ArticleService service = ArticleAPI.getInstance("florent", "florent");
        service.listArticles(id_cat, new Callback<List<Article>>() {
            @Override
            public void success(List<Article> article, Response response) {
                if (article != null) {
                    updateView(article);
                }
            }

            @Override
            public void failure(RetrofitError error) {
                error.printStackTrace();
            }
        });
    }

    // update the event
    private void updateView (List<Article> article){
        setListAdapter(new CategoryArticleArrayAdapter(mContext, article));
    }



}
