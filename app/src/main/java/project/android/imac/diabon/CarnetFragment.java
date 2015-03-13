package project.android.imac.diabon;

import android.app.Fragment;
import android.app.ListFragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

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
public class CarnetFragment extends Fragment {

    private Context mContext;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.carnet, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // get the application context
        mContext = (CarnetActivity)getActivity();
    }

}
