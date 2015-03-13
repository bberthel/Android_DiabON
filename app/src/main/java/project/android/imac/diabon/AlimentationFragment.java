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
 * Created by Brice on 09/03/2015.
 */
public class AlimentationFragment extends ListFragment {

    private Context mContext;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.alimentation, container, false);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // get the application context
        mContext = (AlimentationActivity)getActivity();

        // display the event list
        updateView();
    }

    public void updateView(){
        // use API to get the event
        AlimentationService service = AlimentationAPI.getInstance();
        service.listAliments(((DiabONApplication) mContext.getApplicationContext()).USER_ID, new Callback<List<Alimentation>>() {
            @Override
            public void success(List<Alimentation> aliments, Response response) {
                if (aliments != null)
                    setListAdapter(new AlimentationArrayAdapter(mContext, aliments));
            }

            @Override
            public void failure(RetrofitError error) {
                error.printStackTrace();
            }
        });
    }

}
