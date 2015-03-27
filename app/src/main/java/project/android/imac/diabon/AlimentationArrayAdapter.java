package project.android.imac.diabon;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Brice on 26/03/2015.
 */
public class AlimentationArrayAdapter extends BaseAdapter {

    private static List<String> categories;

    private LayoutInflater mInflater;

    public AlimentationArrayAdapter(Context context, List<String> listcategories) {
        categories = listcategories;
        mInflater = LayoutInflater.from(context);
    }

    public int getCount() {
        return categories.size();
    }

    public Object getItem(int position) {
        return categories.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.alimentation_row_view, null);
            holder = new ViewHolder();
            holder.txtName = (TextView) convertView.findViewById(R.id.name);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        // set data
        holder.txtName.setText(categories.get(position));

        return convertView;
    }

    static class ViewHolder {
        TextView txtName;
    }

}

