package project.android.imac.diabon;

import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by Brice on 13/03/2015.
 */
public class CategoryActivity extends NavigationDrawer {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if ( savedInstanceState == null ) {
            String id = getIntent().getStringExtra("id");
            System.out.println("id "+id);

            //create main fragment : homepage of an event
            Fragment fragment = new CategoryFragment();
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.content_frame,fragment).commit();

            /*if (id == "1") { this.setTitle("Pains, biscottes, céréales, viennoiseries"); }
            else if (id == "2") { this.setTitle("Féculents et légumes secs"); }
            else if (id == "3") { this.setTitle("Légumes"); }
            else if (id == "4") { this.setTitle("Fruits et fruits secs"); }
            else if (id == "5") { this.setTitle("Produits laitiers"); }
            else if (id == "6") { this.setTitle("Plats cuisinés"); }
            else if (id == "7") { this.setTitle("Desserts"); }
            else if (id == "8") { this.setTitle("Produits sucrés, sucreries"); }
            else if (id == "9") { this.setTitle("Apéritifs"); }
            else if (id == "10") { this.setTitle("Boissons"); }
            else if (id == "11") { this.setTitle("Restauration rapide"); }
            else if (id == "12") { this.setTitle("Sauces, assaisonnements"); }*/
        }
    }

}
