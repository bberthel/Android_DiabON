package project.android.imac.diabon;

import android.app.ListFragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import project.android.imac.diabon.conseils.Article;



/**
 * Created by Florent on 09/03/2015.
 */
public class ConseilsFragment extends ListFragment {

    private TextView title;
    private Article mArticle;
    private ListView lv;
    private String id_article;
    private Context mContext;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.conseils_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // get the application context
        mContext = (ConseilsActivity)getActivity();

        LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        title = (TextView) getView().findViewById(R.id.title);
        List<String> list = new ArrayList<String>();
        list.add("Actualité");
        list.add("Activités sportives");
        list.add("Suivi et vie pratique");
        list.add("Alimentation");
        setListAdapter(new ConseilsArrayAdapter(mContext, list));
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id){
        Intent intent = new Intent(mContext,CategoryArticleActivity.class);
        intent.putExtra("id",String.valueOf(position+1));
        startActivity(intent);
    }


}
