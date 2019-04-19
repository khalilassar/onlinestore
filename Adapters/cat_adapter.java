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
import android.widget.Toast;

import java.util.ArrayList;

import soeq.app.soeq.Database.DatabaseAccess;
import soeq.app.soeq.MainActivity;
import soeq.app.soeq.Make_Order;
import soeq.app.soeq.Objects.Product;
import soeq.app.soeq.R;
import soeq.app.soeq.product_info;


public class cat_adapter extends BaseAdapter {
    ArrayList<Product> arrayList;
    Context context;
    public static Product product = null;

    public cat_adapter(Context context, ArrayList<Product> arrayList) {
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
        convertView = View.inflate(context, R.layout.cat_item, null);

        LinearLayout more_info = convertView.findViewById(R.id.main_v);
        ImageView imageView = convertView.findViewById(R.id.item_pic);
        TextView Item_name = convertView.findViewById(R.id.item_name);
        TextView Man_name = convertView.findViewById(R.id.man_name);
        TextView Price = convertView.findViewById(R.id.price);
        RatingBar ratingBar = convertView.findViewById(R.id.rating);
        ImageView loved = convertView.findViewById(R.id.add_to_wish);
        Button buy = convertView.findViewById(R.id.buy_product);

        //    Uri uri = Uri.parse(arrayList.get(position).getImagepath());
        //      Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), uri);
        imageView.setImageResource(R.drawable.book);
        Item_name.setText(arrayList.get(position).getName());
        Man_name.setText(arrayList.get(position).getMan_name());
        Price.setText(arrayList.get(position).getPrice() + "$");
        ratingBar.setRating(arrayList.get(position).getRating());
        
        loved.setImageResource(R.drawable.like);

        more_info.setOnClickListener(e -> {
            Intent intent = new Intent(context, product_info.class);
            intent.putExtra("product_id", arrayList.get(position).getP_id());
            intent.putExtra("pos", position);
            //   intent.putExtra("product_id",id);
            context.startActivity(intent);
        });

        buy.setOnClickListener(e -> {

            Intent intent = new Intent(context, Make_Order.class);

            intent.putExtra("product",arrayList.get(position));
            //     intent.putExtra("product",arrayList.get(position));
            //    intent.putExtra("p_id",arrayList.get(position).getP_id());
            context.startActivity(intent);

        });

        if (Catogries_adapter.prr.get(position).getIsloved()) {
            loved.setImageResource(R.drawable.loved);
            loved.setTag(R.drawable.loved);
        } else {
            loved.setImageResource(R.drawable.like);
            loved.setTag(R.drawable.like);

        }

        loved.setOnClickListener(e -> {

            Integer resource = (Integer) loved.getTag();

            if (resource == (R.drawable.like)) {

                DatabaseAccess access = DatabaseAccess.getAccess(context);

                access.open();
                int User_id = access.getUserid(MainActivity.username);
                access.SavedItem(arrayList.get(position).getP_id(), User_id);

                loved.setImageResource(R.drawable.loved);
                loved.setTag(R.drawable.loved);
                arrayList.get(position).setIsloved(true);
                Catogries_adapter.prr.get(position).setIsloved(true);

                Toast toast = Toast.makeText(context, "Product added to WishList !", Toast.LENGTH_SHORT);
                toast.show();

            } else {
                loved.setImageResource(R.drawable.like);
                loved.setTag(R.drawable.like);
                Toast toast = Toast.makeText(context, "Product Deleted from WishList !", Toast.LENGTH_SHORT);
                toast.show();

                arrayList.get(position).setIsloved(false);
                Catogries_adapter.prr.get(position).setIsloved(false);
            }
        });


        return convertView;
    }
}
