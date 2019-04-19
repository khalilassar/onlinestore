package soeq.app.soeq;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import soeq.app.soeq.Adapters.Catogries_adapter;
import soeq.app.soeq.Database.DatabaseAccess;
import soeq.app.soeq.Objects.Catagory;

public class Catgories extends AppCompatActivity {

    @BindView(R.id.Cat_list)
    ListView gridView;

    @BindView(R.id.catg_drawer_lay)
    DrawerLayout drawerLayout;

    @BindView(R.id.catg_nav_view)
    NavigationView navigationView;

    private ActionBarDrawerToggle actionBarDrawerToggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catgories);
        ButterKnife.bind(this);
        setTitle("Catgories");

        DatabaseAccess access = DatabaseAccess.getAccess(getApplicationContext());
        access.open();


      /*  access.addBrand("Brand 1 ");
        access.addBrand("Brand 2 ");

        access.addProduct("First Product","This Product is very nice  1",100,10,
                "10/10/2018",1);

        access.addProduct(" Product 2","This Product is very nice 2 ",200,7,
                "10/10/2018",1);

        access.addProduct(" Product 3","This Product is very nice  3 ",300,3,
                "10/10/2018",1);

        access.addProduct(" Product 4","This Product is very nice  4",800,2,
                "10/10/2018",1);

        access.addImage("content://com.android.providers.media.documents/document/image%3A1623","Good Pic");
*/


     //   access.AddCatagoty("Cat2");
   //   access.addBrand("Brand 2 ");
    // Image image = new Image("content://com.android.providers.media.documents/document/image%3A1969", "Image 1");

       // access.addProduct(" Product 4", "This Product is very nice 4 ", 200, 8,
            //    "12/10/2018", 1, 2, image);
    //    access.addProduct(" Product 6", "This Product is very nice 6 ", 100, 9,
       //         "10/10/2018", 1, 1, image);
        // add image

/*        access.addProduct(" Product 3","This Product is very nice  3 ",300,3,
                "10/10/2018",1,5);

        access.addProduct(" Product 4","This Product is very nice  4",800,2,
                "10/10/2018",1,5);

        access.addImage("content://com.android.providers.media.documents/document/image%3A1623","Good Pic");*/

        ArrayList<Catagory> Catogries = access.getCatagores();
        Catogries_adapter catogries_adapter = new Catogries_adapter(getApplicationContext(), Catogries);
        gridView.setAdapter(catogries_adapter);


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
