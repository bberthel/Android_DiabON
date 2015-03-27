package project.android.imac.diabon;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.List;

import project.android.imac.diabon.alimentation.Alimentation;

/**
 * Created by Brice on 12/03/2015.
 */
public class AlimentationCategoryArrayAdapter extends BaseAdapter {

    private static List<Alimentation> alimentationList;

    private LayoutInflater mInflater;

    public AlimentationCategoryArrayAdapter(Context context, List<Alimentation> results) {
        alimentationList = results;
        mInflater = LayoutInflater.from(context);
    }

    public int getCount() {
        return alimentationList.size();
    }

    public Object getItem(int position) {
        return alimentationList.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.alimentation_category_row_view, null);
            holder = new ViewHolder();
            holder.txtName = (TextView) convertView.findViewById(R.id.name);
            holder.glucide = (TextView) convertView.findViewById(R.id.glucide);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        // set data
        holder.txtName.setText(alimentationList.get(position).getName());
        holder.glucide.setText(alimentationList.get(position).getGlucide()+" glucides");

        return convertView;
    }

    static class ViewHolder {
        TextView txtName;
        TextView glucide;
    }

}
