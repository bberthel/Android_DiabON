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
public class AlimentationFragment extends Fragment implements View.OnClickListener{

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
        lv = (ListView) getView().findViewById(android.R.id.list);
        title = (TextView) getView().findViewById(R.id.title);

        id_food = getActivity().getIntent().getStringExtra("category_id");
        System.out.println(id_food);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onClick(View v){
        String id = String.valueOf(v.getId()).substring(2, v.getId());
        Intent intent = new Intent(mContext,CategoryActivity.class);
        intent.putExtra("id",id);
        startActivity(intent);
    }



}
