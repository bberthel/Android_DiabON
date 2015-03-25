package project.android.imac.diabon;

import android.app.ListFragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import project.android.imac.diabon.alimentation.Alimentation;
import project.android.imac.diabon.alimentation.AlimentationAPI;
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
        System.out.println(id_food);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onStart (){
        super.onStart();
        AlimentationService service = AlimentationAPI.getInstance("florent","florent");
        service.listAliments("4", new Callback <List<Alimentation>>() {
            @Override
            public void success(List<Alimentation> food, Response response) {
                if (food != null) {
                    updateView(food);
                }
            }

            @Override
            public void failure(RetrofitError error) {
                error.printStackTrace();
            }
        });
    }

    // update the event
    private void updateView (List<Alimentation> food){
        setListAdapter(new AlimentationArrayAdapter(mContext, food));
    }


}
