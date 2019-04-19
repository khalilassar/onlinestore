package soeq.app.soeq.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

import soeq.app.soeq.Database.DatabaseAccess;
import soeq.app.soeq.Objects.Catagory;
import soeq.app.soeq.Objects.Product;
import soeq.app.soeq.R;
import soeq.app.soeq.products_win;

public class Catogries_adapter extends BaseAdapter {

    ArrayList<Catagory> arrayList;
    Context context;

    public Catogries_adapter(Context context, ArrayList<Catagory> arrayList) {
        this.arrayList = arrayList;
        this.context = context;
    }

    public  static ArrayList<Product> prr = new ArrayList<>();

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

        convertView = View.inflate(context, R.layout.catgory_item, null);

        ConstraintLayout cat_main_v = convertView.findViewById(R.id.cat_main_v);
        TextView Cat_name = convertView.findViewById(R.id.Catogry_name);
        Cat_name.setText(arrayList.get(position).getCatagoryName());

        cat_main_v.setOnClickListener(e -> {

            // get products from database
            int id = arrayList.get(position).getCatagoryid();

            DatabaseAccess access = DatabaseAccess.getAccess(context);
            access.open();

            ArrayList<Product> products = access.getProducts(id);
            prr = products;

            Intent intent = new Intent(context, products_win.class);
            intent.putExtra("products", products);
            context.startActivity(intent);

        });


        return convertView;
    }
}
