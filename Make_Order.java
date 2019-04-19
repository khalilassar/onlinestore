package soeq.app.soeq;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import soeq.app.soeq.Adapters.cat_adapter;
import soeq.app.soeq.Database.DatabaseAccess;
import soeq.app.soeq.Objects.Order;
import soeq.app.soeq.Objects.Product;

public class Make_Order extends AppCompatActivity {

    @BindView(R.id.make_order)
    Button button;

    @BindView(R.id.Country_name)
    EditText countryname;

    @BindView(R.id.StreetName)
    EditText StreetName;

    @BindView(R.id.CityName)
    EditText CityName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make__order);

        ButterKnife.bind(this);

        setTitle("Make Order");

        button.setOnClickListener(e -> {
            if (!countryname.getText().toString().isEmpty() && !StreetName.getText().toString().isEmpty()
                    && !CityName.getText().toString().isEmpty()) {

                DatabaseAccess access = DatabaseAccess.getAccess(getApplicationContext());
                access.open();
                Product product = (Product) getIntent().getSerializableExtra("product");
                 //= cat_adapter.product;
                Date currentTime = Calendar.getInstance().getTime();

                Order order = new Order(currentTime.toString(), "In Transint", "By Visa", countryname.getText().toString()
                        , CityName.getText().toString(), StreetName.getText().toString()
                        , product);


                access.addOrder(order);


                Intent intent = new Intent(this, Orders.class);
                startActivity(intent);
            }
        });
    }
}
