package project.android.imac.diabon;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import project.android.imac.diabon.conseils.ActusActivity;
import project.android.imac.diabon.conseils.AlimentationConseilsActivity;
import project.android.imac.diabon.conseils.SportActivity;
import project.android.imac.diabon.conseils.ViePratiqueActivity;

/**
 * Created by Brice on 09/03/2015.
 */
public class ConseilsFragment extends Fragment {

    private Context mContext;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.conseils, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // get the application context
        mContext = (ConseilsActivity)getActivity();

        ImageButton goto_conseils_actus = (ImageButton) getView().findViewById(R.id.goto_conseils_actus);
        goto_conseils_actus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent myIntent = new Intent(getActivity().getApplicationContext(), ActusActivity.class);
                ConseilsFragment.this.startActivity(myIntent);
            }
        });

        ImageButton goto_conseils_sport = (ImageButton) getView().findViewById(R.id.goto_conseils_sport);
        goto_conseils_sport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent myIntent = new Intent(getActivity().getApplicationContext(), SportActivity.class);
                ConseilsFragment.this.startActivity(myIntent);
            }
        });

        ImageButton goto_conseils_vie_pratique = (ImageButton) getView().findViewById(R.id.goto_conseils_vie_pratique);
        goto_conseils_vie_pratique.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent myIntent = new Intent(getActivity().getApplicationContext(), ViePratiqueActivity.class);
                ConseilsFragment.this.startActivity(myIntent);
            }
        });

        ImageButton goto_conseils_alimentation = (ImageButton) getView().findViewById(R.id.goto_conseils_alimentation);
        goto_conseils_alimentation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent myIntent = new Intent(getActivity().getApplicationContext(), AlimentationConseilsActivity.class);
                ConseilsFragment.this.startActivity(myIntent);
            }
        });
    }

}
