package project.android.imac.diabon;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Brice on 09/03/2015.
 */
public class ArticleDetailFragment extends Fragment {

    private TextView title;
    private TextView content;
    /*private TextView date;*/
    private TextView author;
    private Context mContext;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.article_detail_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // get arguments sent by the activity
        Bundle extras = getActivity().getIntent().getExtras();

        String title_data = extras.getString("title");
        String author_data = extras.getString("author");
        /*String date_data = extras.getString("date");*/
        String content_data = extras.getString("content");

        // get the application context
        mContext = (ArticleDetailActivity)getActivity();

        // get the loaded view
        View parent = getView();

        title = (TextView) parent.findViewById(R.id.title_article);
        /*date = (TextView) parent.findViewById(R.id.date_article);*/
        content = (TextView) parent.findViewById(R.id.content_article);
        author = (TextView) parent.findViewById(R.id.author_article);

        // push data
        title.setText(title_data);
        content.setText(content_data);
        /*date.setText("le "+date_data);*/
        author.setText("de "+author_data);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

}