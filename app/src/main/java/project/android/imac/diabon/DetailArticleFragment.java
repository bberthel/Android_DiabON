package project.android.imac.diabon;


import android.app.Fragment;
import android.app.ListFragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import project.android.imac.diabon.alimentation.Alimentation;
import project.android.imac.diabon.conseils.Article;

/**
 * Created by Brice on 09/03/2015.
 */
public class DetailArticleFragment extends Fragment {

    private TextView title;
    private Article mArticle;
    private String id_article;
    private TextView content;
    private TextView date;
    private TextView author;
    private Context mContext;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.detail_article_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // get the application context
        mContext = (DetailArticleActivity)getActivity();

        title = (TextView) getView().findViewById(R.id.title_article);
        date = (TextView) getView().findViewById(R.id.date_article);
        content = (TextView) getView().findViewById(R.id.content_article);
        author = (TextView) getView().findViewById(R.id.author_article);

        System.out.println("CACA");

        updateView(mArticle);
    }

    // update the event
    private void updateView (Article mArticle){
        if(mArticle!=null) {
            System.out.println("mArtciel NON NULL");
            title.setText(mArticle.getTitle());
            content.setText(mArticle.getContent());
            date.setText(mArticle.getDate());
            author.setText(mArticle.getAuthor());
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }
}
