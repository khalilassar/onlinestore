package soeq.app.soeq.Adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import soeq.app.soeq.Objects.ListItem;
import soeq.app.soeq.R;

public class MyAdapter  extends BaseAdapter {
    ArrayList<ListItem> arrayList;
    Context context;

    public MyAdapter(Context context, ArrayList<ListItem> arrayList) {
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
        convertView = View.inflate(context, R.layout.list_item,null);

        ImageView imageView  = convertView.findViewById(R.id.item_pic);
        TextView Item_name  = convertView.findViewById(R.id.item_name);
        TextView Man_name  = convertView.findViewById(R.id.man_name);
        TextView Price  = convertView.findViewById(R.id.price);

       // imageView.setImageResource(arrayList.get(position).get());
        Item_name.setText(arrayList.get(position).getName());
        Man_name.setText(arrayList.get(position).getMan_name());
        Price.setText(arrayList.get(position).getPrice()+"$");


        return convertView;
    }
}
