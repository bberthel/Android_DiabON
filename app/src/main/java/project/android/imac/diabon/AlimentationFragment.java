package project.android.imac.diabon;

import android.app.Activity;
import android.app.ListFragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import project.android.imac.diabon.alimentation.Alimentation;
import project.android.imac.diabon.alimentation.AlimentationAPI;
import project.android.imac.diabon.alimentation.AlimentationResponse;
import project.android.imac.diabon.alimentation.AlimentationService;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Brice on 09/03/2015.
 */
public class AlimentationFragment extends ListFragment {
    private TextView title;
    private Alimentation mAlimentation;
    private ListView lv;
    private String id_food;
    private Context mContext;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.alimentation, container, false);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // get the application context
        mContext = (AlimentationActivity)getActivity();

        LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View header = inflater.inflate(R.layout.alimentation_header, null, false);
        lv = (ListView) getView().findViewById(android.R.id.list);
        lv.addHeaderView(header);
        title = (TextView) getView().findViewById(R.id.title);

        id_food = getActivity().getIntent().getStringExtra("category_id");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onStart (){
        super.onStart();
        AlimentationService service = AlimentationAPI.getInstance();
        service.listAliments(id_food, new Callback<AlimentationResponse>() {
            @Override
            public void success(AlimentationResponse food, Response response) {
                if (food.getAlimentation() != null) {
                    mAlimentation = food.getAlimentation();
                    updateView(food);
                }
            }

            @Override
            public void failure(RetrofitError error) {
                error.printStackTrace();
            }
        });
    }
    /*
    @Override
    // call the EventActivity and pass the id
    public void onListItemClick(ListView l, View v, int position, long id) {
        Alimentation selectedFood = (Alimentation)lv.getItemAtPosition(position);
        Intent intent;
        switch (selectedFood.getId()){
            // module invitation/inscription
            case 1:
                intent= new Intent(mContext,GuestActivity.class);
                intent.putExtra("module_id",String.valueOf(selectedModule.getId()));
                startActivity(intent);
                break;
            // module budget
            case 2:
                intent= new Intent(mContext,BudgetActivity.class);
                intent.putExtra("module_id",String.valueOf(selectedModule.getId()));
                startActivity(intent);
                break;
            // module Lieu
            case 3:
                intent= new Intent(mContext,PlaceActivity.class);
                intent.putExtra("module_id",String.valueOf(selectedModule.getId()));
                startActivity(intent);
                break;
            // module Transport
            case 4:
                Toast.makeText(mContext, "Module Transport à venir", Toast.LENGTH_SHORT).show();
                break;
            // module liste de tâches
            case 5:
                intent= new Intent(mContext,TodoActivity.class);
                intent.putExtra("module_id",String.valueOf(selectedModule.getId()));
                startActivity(intent);
                break;
            // ajouter un module
            case 6:
                intent= new Intent(mContext,AddModule.class);
                intent.putExtra("event",mEvent);
                startActivity(intent);
                break;

        }
    }
    */

    // update the event
    private void updateView (AlimentationResponse food){
        title.setText(food.getAlimentation().getName());

        //lv.setAdapter(new AlimentationArrayAdapter(mContext, food.getAlimentation().getName()));
    }


}
