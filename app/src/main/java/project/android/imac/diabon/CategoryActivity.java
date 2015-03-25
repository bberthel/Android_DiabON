package project.android.imac.diabon;

import android.app.ActionBar;
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

    ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category);

        listview = (ListView)findViewById(R.id.listView);
        // Array holding our data
        String[] category_list = {
                "Pains, crackers, céréales, pâtisseries",
                "Féculents et légumes secs",
                "Légumes",
                "Fruits et fruits secs",
                "Produits laitiers",
                "Plats cuisinés",
                "Desserts",
                "Produits sucrés, confiseries",
                "Appéritifs",
                "Boissons",
                "Restauration rapide",
                "Sauces, assaisonnements"
        };
        //adapter which will convert each data item into view item.
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.category_row_view, R.id.listText, category_list);
        //place each view-item inside listview by setting adapter for our listview
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new ListClickHandler());
    }

    public class ListClickHandler implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> adapter, View view, int position, long arg3) {
            // TODO Auto-generated method stub
            TextView listText = (TextView) view.findViewById(R.id.listText);
            String text = listText.getText().toString();

            // create intent to start another activity
            Intent intent = new Intent(CategoryActivity.this, CategoryDetailsActivity.class);
            // add the selected text item to our intent.
            intent.putExtra("selected-item", text);
            startActivity(intent);

        }

    }

}
