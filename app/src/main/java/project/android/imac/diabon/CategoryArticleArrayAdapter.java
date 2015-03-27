package project.android.imac.diabon;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import project.android.imac.diabon.conseils.Article;

/**
 * Created by Florent on 26/03/2015.
 */
public class CategoryArticleArrayAdapter extends BaseAdapter{

    private static List<Article> articleList;

    private LayoutInflater mInflater;

    public CategoryArticleArrayAdapter(Context context, List<Article> results) {
        articleList = results;
        mInflater = LayoutInflater.from(context);
    }

    public int getCount() {
        return articleList.size();
    }

    public Object getItem(int position) {
        return articleList.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.article_category_row_view, null);
            holder = new ViewHolder();
            holder.txtTitle = (TextView) convertView.findViewById(R.id.title);
            holder.date = (TextView) convertView.findViewById(R.id.date);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        // set data
        holder.txtTitle.setText(articleList.get(position).getTitle());
        holder.date.setText(articleList.get(position).getDate());

        return convertView;
    }

    static class ViewHolder {
        TextView txtTitle;
        TextView date;
    }

}



