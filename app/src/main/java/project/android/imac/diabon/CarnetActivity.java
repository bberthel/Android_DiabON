package project.android.imac.diabon;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.ListView;

/**
 * Created by Brice on 08/03/2015.
 */
public class CarnetActivity extends NavigationDrawer {

    ListView listView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if ( savedInstanceState == null ) {
            //create main fragment : homepage of an event
            Fragment fragment = new CarnetFragment();
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.content_frame,fragment).commit();
        }

    }

}
