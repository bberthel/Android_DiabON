package project.android.imac.diabon;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

/**
 * Created by Brice on 13/03/2015.
 */
public class AlimentationCategoryActivity extends NavigationDrawer {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if ( savedInstanceState == null ) {
            String id = getIntent().getStringExtra("id");

            //create main_fragment fragment : page des catégories d'aliments
            Fragment fragment = new AlimentationCategoryFragment();
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.content_frame,fragment).commit();
        }
    }

}
