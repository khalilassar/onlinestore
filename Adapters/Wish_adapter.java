package soeq.app.soeq.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import soeq.app.soeq.Objects.Product;
import soeq.app.soeq.R;
import soeq.app.soeq.product_info;

public class Wish_adapter extends BaseAdapter {
    ArrayList<Product> arrayList;
    Context context;

    public Wish_adapter(Context context, ArrayList<Product> arrayList) {
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
        convertView = View.inflate(context, R.layout.wish_item, null);

        LinearLayout more_info = convertView.findViewById(R.id.main_v);
        ImageView imageView = convertView.findViewById(R.id.item_pic);
        TextView Item_name = convertView.findViewById(R.id.item_name);
        TextView Man_name = convertView.findViewById(R.id.man_name);
        TextView Price = convertView.findViewById(R.id.price);
        RatingBar ratingBar = convertView.findViewById(R.id.rating);

        //    Uri uri = Uri.parse(arrayList.get(position).getImagepath());
        //      Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), uri);
        imageView.setImageResource(R.drawable.book);
        Item_name.setText(arrayList.get(position).getName());
        Man_name.setText(arrayList.get(position).getMan_name());
        Price.setText(arrayList.get(position).getPrice() + "$");
        ratingBar.setRating(arrayList.get(position).getRating());

        more_info.setOnClickListener(e -> {
            Intent intent = new Intent(context, product_info.class);
            intent.putExtra("product_id", arrayList.get(position).getP_id());
            context.startActivity(intent);
        });



        return convertView;
    }
}
