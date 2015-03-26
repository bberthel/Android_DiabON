package project.android.imac.diabon;

import android.app.ListFragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import project.android.imac.diabon.alimentation.Alimentation;
import project.android.imac.diabon.alimentation.AlimentationAPI;
import project.android.imac.diabon.alimentation.AlimentationService;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Brice on 13/03/2015.
 */
public class CategoryFragment extends ListFragment {

    private Context mContext;
    private String id_cat;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.category, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // get the application context
        mContext = (CategoryActivity)getActivity();
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
        AlimentationService service = AlimentationAPI.getInstance("florent", "florent");
        service.listAliments(id_cat, new Callback<List<Alimentation>>() {
            @Override
            public void success(List<Alimentation> food, Response response) {
                if (food != null) {
                    updateView(food);
                }
            }

            @Override
            public void failure(RetrofitError error) {
                error.printStackTrace();
            }
        });
    }

    // update the event
    private void updateView (List<Alimentation> food){
        setListAdapter(new CategoryArrayAdapter(mContext, food));
    }

}
