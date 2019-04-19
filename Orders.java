package soeq.app.soeq;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import soeq.app.soeq.Adapters.Order_adapter;
import soeq.app.soeq.Database.DatabaseAccess;
import soeq.app.soeq.Objects.Order;

public class Orders extends AppCompatActivity {

    @BindView(R.id.Orders_list)
    ListView Orders_list;


    @BindView(R.id.ord_drawer_lay)
    DrawerLayout drawerLayout;

    @BindView(R.id.ord_nav_view)
    NavigationView navigationView;

    private ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders);
        ButterKnife.bind(this);

        setTitle("Orders");

        DatabaseAccess access = DatabaseAccess.getAccess(getApplicationContext());
        access.open();

        ArrayList<Order> list = access.getOrders();
        System.out.println(list.size());
          Order_adapter adapter = new Order_adapter(getApplicationContext(),list);
          Orders_list.setAdapter(adapter);



        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();
                switch (id) {

                    case R.id.categories:
                        Intent Cat_intent = new Intent(getApplicationContext(), Catgories.class);
                        startActivity(Cat_intent);
                        break;


                    case R.id.wish:
                        Intent wish = new Intent(getApplicationContext(), wish.class);
                        wish.putExtra("user_id", getIntent().getIntExtra("user_id", 0));
                        startActivity(wish);
                        break;


                    case R.id.offers:
                        Intent offers = new Intent(getApplicationContext(), Offers.class);
                        offers.putExtra("user_id", getIntent().getIntExtra("user_id", 0));
                        startActivity(offers);
                        break;

                    case R.id.Orders:
                        Intent Orders = new Intent(getApplicationContext(), Orders.class);
                        startActivity(Orders);
                        break;
                }


                return false;
            }
        });


    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
