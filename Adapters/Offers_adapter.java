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
import soeq.app.soeq.Make_Order;
import soeq.app.soeq.Objects.Catagory;
import soeq.app.soeq.Objects.Offer;
import soeq.app.soeq.Objects.Product;
import soeq.app.soeq.R;
import soeq.app.soeq.product_info;
import soeq.app.soeq.products_win;

public class Offers_adapter extends BaseAdapter {

    ArrayList<Offer> arrayList;
    Context context;
    public Product product2 = null;

    public Offers_adapter(Context context, ArrayList<Offer> arrayList) {
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

        convertView = View.inflate(context, R.layout.offer_item, null);


        LinearLayout more_info = convertView.findViewById(R.id.main_v);
        ImageView imageView = convertView.findViewById(R.id.item_pic);
        TextView Item_name = convertView.findViewById(R.id.item_name);
        TextView Man_name = convertView.findViewById(R.id.man_name);
        TextView Price = convertView.findViewById(R.id.price);
        RatingBar ratingBar = convertView.findViewById(R.id.rating);
        TextView discount = convertView.findViewById(R.id.discount);
        TextView start_datee = convertView.findViewById(R.id.start_datee);
        TextView end_datee = convertView.findViewById(R.id.end_datee);
        Button Buy_bt = convertView.findViewById(R.id.buy_product);

        //    Uri uri = Uri.parse(arrayList.get(position).getImagepath());
        //      Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), uri);
        imageView.setImageResource(R.drawable.book);
        Item_name.setText(arrayList.get(position).getProduct().getName());
        Man_name.setText(arrayList.get(position).getProduct().getMan_name());
        Price.setText(arrayList.get(position).getProduct().getPrice() + "$");
        ratingBar.setRating(arrayList.get(position).getProduct().getRating());
        discount.setText(arrayList.get(position).getDiscount() + "%");
        start_datee.setText(arrayList.get(position).getStart_date());
        end_datee.setText(arrayList.get(position).getEnd_date());

        more_info.setOnClickListener(e -> {
            Intent intent = new Intent(context, product_info.class);
            intent.putExtra("product_id", arrayList.get(position).getProduct().getP_id());
            context.startActivity(intent);
        });

        Buy_bt.setOnClickListener(e -> {
            Intent intent = new Intent(context, Make_Order.class);
         //   product2 = arrayList.get(position).getProduct();
            intent.putExtra("product",arrayList.get(position).getProduct());
            //    intent.putExtra("p_id",arrayList.get(position).getP_id());
            context.startActivity(intent);

        });

        return convertView;
    }
}