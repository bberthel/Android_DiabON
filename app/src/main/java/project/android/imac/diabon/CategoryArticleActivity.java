package project.android.imac.diabon;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

/**
 * Created by Florent on 26/03/2015.
 */

public class CategoryArticleActivity extends NavigationDrawer {
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            if ( savedInstanceState == null ) {
                String id = getIntent().getStringExtra("id");
                System.out.println("id "+id);

                //create main_fragment fragment : homepage of an event
                Fragment fragment = new CategoryArticleFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.content_frame,fragment).commit();

            }
        }



}
