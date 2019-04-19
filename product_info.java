package soeq.app.soeq;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import soeq.app.soeq.Adapters.Catogries_adapter;
import soeq.app.soeq.Adapters.CommentAdapter;
import soeq.app.soeq.Database.DatabaseAccess;
import soeq.app.soeq.Objects.Comment;
import soeq.app.soeq.Objects.Product;

public class product_info extends AppCompatActivity {




    @BindView(R.id.Comments_List)
    ListView commentsList;

    @BindView(R.id.item_name)
    TextView item_name;

    @BindView(R.id.man_name)
    TextView man_name;

    @BindView(R.id.rating)
    RatingBar rating;

    @BindView(R.id.price)
    TextView price;

    @BindView(R.id.Description)
    TextView Description;

    @BindView(R.id.add_to_wish)
    ImageView addImageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_info);

        ButterKnife.bind(this);

        setTitle("Product Info");

        DatabaseAccess databaseAccess = DatabaseAccess.getAccess(getApplicationContext());
        databaseAccess.open();

        Product product = databaseAccess.getProduct(getIntent().getIntExtra("product_id", 0));

        item_name.setText(product.getName());
        man_name.setText(product.getMan_name());
        rating.setRating(product.getRating());
        price.setText(product.getPrice()+"");
        Description.setText(product.getDescription());


        ArrayList<Comment> commentArrayList = databaseAccess.getCommentes(getIntent().getIntExtra("product_id", 0));


        CommentAdapter commentAdapter = new CommentAdapter(getApplicationContext(), commentArrayList);
        commentsList.setAdapter(commentAdapter);

        if (Catogries_adapter.prr.get(getIntent().getIntExtra("pos", 0)).getIsloved()) {
            addImageView.setImageResource(R.drawable.loved);
            addImageView.setTag(R.drawable.loved);
        } else {
            addImageView.setImageResource(R.drawable.like);
            addImageView.setTag(R.drawable.like);
        }


        addImageView.setOnClickListener(e->{
            Integer aaa = (Integer) addImageView.getTag();

            if (aaa == (R.drawable.like)) {

                addImageView.setImageResource(R.drawable.loved);
                addImageView.setTag(R.drawable.loved);
                Catogries_adapter.prr.get(getIntent().getIntExtra("pos", 0)).setIsloved(true);

                Toast toast = Toast.makeText(getApplicationContext(), "Product added to WishList !", Toast.LENGTH_SHORT);
                toast.show();


            } else {
                addImageView.setImageResource(R.drawable.like);
                addImageView.setTag(R.drawable.like);
                Catogries_adapter.prr.get(getIntent().getIntExtra("pos", 0)).setIsloved(false);
                Toast toast = Toast.makeText(getApplicationContext(), "Product Deleted from WishList !", Toast.LENGTH_SHORT);
                toast.show();
            }
        });


    }
}
