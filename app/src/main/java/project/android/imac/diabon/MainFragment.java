package project.android.imac.diabon;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Brice on 09/03/2015.
 */
public class MainFragment extends Fragment {

    private Context mContext;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // get the application context
        mContext = (MainActivity)getActivity();

        Button goto_alimentation = (Button) getView().findViewById(R.id.goto_alimentation);
        goto_alimentation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent myIntent = new Intent(getActivity().getApplicationContext(), AlimentationActivity.class);
                MainFragment.this.startActivity(myIntent);
            }
        });

        Button goto_conseils = (Button) getView().findViewById(R.id.goto_conseils);
        goto_conseils.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent myIntent = new Intent(getActivity().getApplicationContext(), ConseilsActivity.class);
                MainFragment.this.startActivity(myIntent);
            }
        });

    }
}
