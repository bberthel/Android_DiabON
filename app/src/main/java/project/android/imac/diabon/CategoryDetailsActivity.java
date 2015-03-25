package project.android.imac.diabon;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;


/**
 * Created by Brice on 13/03/2015.
 */
public class CategoryDetailsActivity extends NavigationDrawer {
    ListView listview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category_details);

        // get the intent from which this activity is called.
        Intent intent = getIntent();

        // fetch value from key-value pair and make it visible on TextView.
        String item = intent.getStringExtra("selected-item");
        setTitle(item);

        listview = (ListView)findViewById(R.id.listView);
        // Array holding our data
        String[] aperitifs_list = {
                "Biscuit apéritif à base de pomme de terre, type tuile salée",
                "Biscuit apéritif soufflé, à base de maïs, sans cacahuète",
                "Biscuit apéritif soufflé, à base de pomme de terre",
                "Châtaigne, cuite à l'eau",
                "Noix de coco, amande mûre, fraîche"
        };
        //adapter which will convert each data item into view item.
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.aperitifs_row_view, R.id.listText, aperitifs_list);
        //place each view-item inside listview by setting adapter for our listview
        listview.setAdapter(adapter);

    }


}
