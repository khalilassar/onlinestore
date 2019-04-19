package soeq.app.soeq.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

import soeq.app.soeq.Database.DatabaseAccess;
import soeq.app.soeq.Objects.Catagory;
import soeq.app.soeq.Objects.Order;
import soeq.app.soeq.Objects.Product;
import soeq.app.soeq.R;
import soeq.app.soeq.products_win;

public class Order_adapter extends BaseAdapter {

    ArrayList<Order> arrayList;
    Context context;

    public Order_adapter(Context context, ArrayList<Order> arrayList) {
        this.arrayList = arrayList;
        this.context = context;
    }


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

        convertView = View.inflate(context, R.layout.order_item, null);

        ImageView imageView = convertView.findViewById(R.id.item_pic);
        TextView Item_name = convertView.findViewById(R.id.item_name);
        TextView Man_name = convertView.findViewById(R.id.man_name);
        TextView Price = convertView.findViewById(R.id.price);
        RatingBar ratingBar = convertView.findViewById(R.id.rating);
        TextView stat = convertView.findViewById(R.id.statues);
        TextView type = convertView.findViewById(R.id.type);


      //  Button buy = convertView.findViewById(R.id.buy_product);

        //    Uri uri = Uri.parse(arrayList.get(position).getImagepath());
        //      Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), uri);
        imageView.setImageResource(R.drawable.book);
        Item_name.setText(arrayList.get(position).getProduct().getName());
        Man_name.setText(arrayList.get(position).getProduct().getMan_name());
        Price.setText(arrayList.get(position).getProduct().getPrice() + "$");
        ratingBar.setRating(arrayList.get(position).getProduct().getRating());
        stat.setText(arrayList.get(position).getStatues());
        type.setText(arrayList.get(position).getType());

        return convertView;
    }
}