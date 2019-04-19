package soeq.app.soeq.Adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

import soeq.app.soeq.Objects.Comment;
import soeq.app.soeq.R;

public class CommentAdapter extends BaseAdapter {

    private ArrayList<Comment> arrayList;
    private Context context;

    public CommentAdapter(Context context, ArrayList<Comment> arrayList) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = View.inflate(context, R.layout.comment_elm, null);
        TextView Username = convertView.findViewById(R.id.u_name);
        TextView Title = convertView.findViewById(R.id.c_title);
        TextView date = convertView.findViewById(R.id.time);
        TextView Dec = convertView.findViewById(R.id.c_Description);
        RatingBar ratingBar = convertView.findViewById(R.id.c_rating);


        Username.setText(arrayList.get(position).getUsername());
        Title.setText(arrayList.get(position).getTitle());
        date.setText(arrayList.get(position).getDate());
        Dec.setText(arrayList.get(position).getDescription());
        ratingBar.setRating(arrayList.get(position).getRating());


        return convertView;
    }
}
