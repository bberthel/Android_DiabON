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
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import project.android.imac.diabon.alimentation.Alimentation;
import project.android.imac.diabon.alimentation.AlimentationAPI;
import project.android.imac.diabon.alimentation.AlimentationService;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Brice on 09/03/2015.
 */
public class AlimentationFragment extends ListFragment{

    private TextView title;
    private Alimentation mAlimentation;
    private ListView lv;
    private String id_food;
    private Context mContext;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.alimentation_fragment, container, false);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // get the application context
        mContext = (AlimentationActivity)getActivity();

        LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        title = (TextView) getView().findViewById(R.id.title);
        List<String> list = new ArrayList<String>();
        list.add("Pains, biscottes, céréales, viennoiseries");
        list.add("Féculents et légumes secs");
        list.add("Légumes");
        list.add("Fruits et fruits secs");
        list.add("Produits laitiers");
        list.add("Plats cuisinés");
        list.add("Desserts");
        list.add("Produits sucrés, sucreries");
        list.add("Apéritifs");
        list.add("Boissons");
        list.add("Restauration rapide");
        list.add("Sauces, assaisonnements");
        setListAdapter(new AlimentationArrayAdapter(mContext, list));

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id){
        Intent intent = new Intent(mContext,CategoryActivity.class);
        intent.putExtra("id",String.valueOf(position+1));
        startActivity(intent);
    }



}
