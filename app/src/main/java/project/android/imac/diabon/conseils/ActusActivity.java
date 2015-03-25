package project.android.imac.diabon.conseils;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.MenuItem;

import project.android.imac.diabon.NavigationDrawer;
import project.android.imac.diabon.R;

/**
 * Created by Brice on 25/03/2015.
 */
public class ActusActivity extends NavigationDrawer {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if ( savedInstanceState == null ) {
            //create main fragment : homepage of an event
            Fragment fragment = new ActusFragment();
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.content_frame,fragment).commit();
        }
    }

}
