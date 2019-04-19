package soeq.app.soeq.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import soeq.app.soeq.MainActivity;
import soeq.app.soeq.Objects.Catagory;
import soeq.app.soeq.Objects.Comment;
import soeq.app.soeq.Objects.Image;
import soeq.app.soeq.Objects.ListItem;
import soeq.app.soeq.Objects.Offer;
import soeq.app.soeq.Objects.Order;
import soeq.app.soeq.Objects.Product;
import soeq.app.soeq.Objects.User;

public class DatabaseAccess {
    private SQLiteOpenHelper sqLiteOpenHelper;
    private SQLiteDatabase sqLiteDatabase;
    private static DatabaseAccess access;
    Cursor cursor = null;

    private DatabaseAccess(Context context) {
        this.sqLiteOpenHelper = new Database(context);
    }

    public static DatabaseAccess getAccess(Context context) {
        if (access == null) {
            access = new DatabaseAccess(context);
        }
        return access;
    }


    public void open() throws SQLException {
        this.sqLiteDatabase = sqLiteOpenHelper.getWritableDatabase();
    }

    public void close() {
        if (sqLiteDatabase != null) {
            this.sqLiteOpenHelper.close();
        }
    }


/*

    public ArrayList<String> getProducts(int CatagoryId) {

        cursor = sqLiteDatabase.rawQuery("select *  from product  ", null);
        ArrayList<String> catagores_list = new ArrayList<>();

        while (cursor.moveToNext()) {
            String user = cursor.getString(0);

            catagores_list.add(user);
        }
        return catagores_list;
    }
*/


    public void clear() {
        Cursor curso1 = null;
        String sql1 = "DELETE FROM brand";
        String sql2 = "DELETE FROM catagorey";
        String sql3 = "DELETE FROM comment";
        String sql4 = "DELETE FROM complain";
        String sql5 = "DELETE FROM offers";
        String sql6 = "DELETE FROM orders";
        String sql7 = "DELETE FROM product";
        String sql8 = "DELETE FROM saved";
        String sql9 = "DELETE FROM saved_product";
        String sql10 = "DELETE FROM usr";

        sqLiteDatabase.execSQL(sql1);
        sqLiteDatabase.execSQL(sql2);
        sqLiteDatabase.execSQL(sql3);
        sqLiteDatabase.execSQL(sql4);
        sqLiteDatabase.execSQL(sql5);
        sqLiteDatabase.execSQL(sql6);
        sqLiteDatabase.execSQL(sql7);
        sqLiteDatabase.execSQL(sql8);
        sqLiteDatabase.execSQL(sql9);
        sqLiteDatabase.execSQL(sql10);

    }


    public void AddCatagoty(String Title) {

        ContentValues contentValues = new ContentValues();
        contentValues.put("title", Title);

        sqLiteDatabase.insert("catagorey", null, contentValues);

    }

    public ArrayList<Catagory> getCatagores() {
        cursor = sqLiteDatabase.rawQuery("select *   from catagorey", null);

        ArrayList<Catagory> catagores_list = new ArrayList<>();

        while (cursor.moveToNext()) {
            int c_id = cursor.getInt(0);
            String Cat_name = cursor.getString(1);

            Catagory catagory = new Catagory(c_id, Cat_name);
            catagores_list.add(catagory);
        }
        return catagores_list;
    }

    public ArrayList<Integer> getProducts_ids(int Cat_id) {
        cursor = sqLiteDatabase.rawQuery(("select product_id from catagorey where categorey_id = " + Cat_id), null);

        ArrayList<Integer> product_id_list = new ArrayList<>();

        while (cursor.moveToNext()) {
            int product_id = cursor.getInt(0);
            product_id_list.add(product_id);
        }
        return product_id_list;
    }

    public ArrayList<Product> getProducts(int Cat_id) {

        System.out.println(Cat_id);

        Cursor curso2 = null;
        ArrayList<Product> aaa = new ArrayList<>();

        curso2 = sqLiteDatabase.rawQuery("select * from product where catagorey_id="+Cat_id, null);

        while (curso2.moveToNext()) {
            int id = curso2.getInt(0);
            String title = curso2.getString(1);
            String dec = curso2.getString(2);
            int price = curso2.getInt(3);
            int quantity = curso2.getInt(4);
            String time = curso2.getString(5);
            String brandname = getBrand_name(curso2.getInt(6));



            Product product = new Product(id, dec, title, price, getImagePath(id), brandname, getProRating(id), true, quantity, time);
            aaa.add(product);
        }

        return aaa;
    }

    public void SavedItem(int p_id, int user_id) {

        ContentValues contentValues = new ContentValues();
        contentValues.put("user_id", user_id);

        sqLiteDatabase.insert("saved", null, contentValues);

        ContentValues contentValues2 = new ContentValues();
        contentValues.put("product_id", p_id);
        contentValues.put("saved_id", getSaved_id(user_id));

        sqLiteDatabase.insert("saved_product", null, contentValues2);
    }


    public int getUserid(String Username) {
        int userid = 0;

        Cursor curso2 = null;
        curso2 = sqLiteDatabase.rawQuery(("select user_id from usr where user_name = " + "'" + Username + "'"), null);

        while (curso2.moveToNext()) {
            userid = curso2.getInt(0);
        }

        return userid;
    }


    public int getSaved_id(int user_id) {
        int s_id = 0;
        Cursor curso2 = null;
        curso2 = sqLiteDatabase.rawQuery("select saved_id from saved where user_id= " + user_id, null);
        while (curso2.moveToNext()) {
            s_id = curso2.getInt(0);
        }
        return s_id;
    }


    public ArrayList<Order> getOrders() {
        ArrayList<Order> arrayList = new ArrayList<>();

        int User_id = getUserid(MainActivity.username);
        Cursor curso2 = null;
        curso2 = sqLiteDatabase.rawQuery("select * from orders where user_id = " + User_id, null);
        while (curso2.moveToNext()) {

            int order_id = curso2.getInt(0);
            String date = curso2.getString(1);
            String statues = curso2.getString(3);
            String type = curso2.getString(4);
            String country = curso2.getString(5);
            String city = curso2.getString(6);
            String street = curso2.getString(7);
            int product_id = curso2.getInt(8);
            Product product = getProduct(product_id);
            Order order = new Order(date, statues, type, country, city, street, product);
            arrayList.add(order);


        }
        return arrayList;

    }

    public void addOrder(Order order) {

        int userid = getUserid(MainActivity.username);
        ContentValues contentValues = new ContentValues();
        contentValues.put("date", order.getDate());
        contentValues.put("status", order.getStatues());
        contentValues.put("type", order.getType());
        contentValues.put("country", order.getCountry());
        contentValues.put("city", order.getCity());
        contentValues.put("street", order.getStreet());
        contentValues.put("user_id", userid);
        contentValues.put("product_id", order.getProduct().getP_id());
        System.out.println(order.getProduct().getP_id());

        sqLiteDatabase.insert("orders", null, contentValues);

    }

    public ArrayList<Offer> getOffers() {

        ArrayList<Offer> Offers = new ArrayList<>();
        Cursor curso2 = null;
        curso2 = sqLiteDatabase.rawQuery("select * from offers ", null);
        while (curso2.moveToNext()) {
            int offer_id = curso2.getInt(0);
            int discount = curso2.getInt(1);
            String Start_date = curso2.getString(2);
            String end_date = curso2.getString(3);

            Product product = getProduct(curso2.getInt(4));
            product.setPrice((product.getPrice() *  (curso2.getInt(1) / 100.0)));
            Offer offer = new Offer(offer_id, product, Start_date, end_date, discount);
            Offers.add(offer);

        }
        return Offers;
    }

    public void addOffer(int Product_id, int discount, String start_date, String end_date) {

        ContentValues contentValues = new ContentValues();

        contentValues.put("discount", discount);
        contentValues.put("start_date", start_date);
        contentValues.put("end_date", end_date);
        contentValues.put("product_id", Product_id);

        sqLiteDatabase.insert("offers", null, contentValues);
    }

    public ArrayList<Product> getLikedProducts(int user_id) {
        ArrayList<Product> products = new ArrayList<>();
        Cursor curso2 = null;

        curso2 = sqLiteDatabase.rawQuery("select saved_id from saved where user_id= " + user_id, null);
        while (curso2.moveToNext()) {
            int saved_id = curso2.getInt(0);
            System.out.println(saved_id + "/*/*/*");

            Cursor curso3 = null;
            curso3 = sqLiteDatabase.rawQuery("select product_id from saved_product where saved_id= " + saved_id, null);

            while (curso3.moveToNext()) {

                int product_id = curso3.getInt(0);
                System.out.println(product_id + "///");

                Cursor ceee4 = null;
                ceee4 = sqLiteDatabase.rawQuery("select * from product where product_id = " + product_id, null);

                while (ceee4.moveToNext()) {

                    int id = ceee4.getInt(0);
                    System.out.println(id + "*****");
                    String title = ceee4.getString(1);
                    String dec = ceee4.getString(2);
                    int price = ceee4.getInt(3);
                    int quantity = ceee4.getInt(4);
                    String time = ceee4.getString(5);
                    String brandname = getBrand_name(ceee4.getInt(6));
                    Product product = new Product(id, dec, title, price, getImagePath(id), brandname, getProRating(id), true, quantity, time);

                    products.add(product);
                }


            }


        }
        return products;
    }


    public ArrayList<Comment> getCommentes(int p_id) {
        ArrayList<Comment> arrayList = new ArrayList<>();
        Cursor curso2 = sqLiteDatabase.rawQuery("select * from comment where product_id =" + p_id, null);
        Comment comment = null;

        while (curso2.moveToNext()) {
            int idd = curso2.getInt(0);
            String c_text = curso2.getString(1);
            int stars = curso2.getInt(2);
            String date = curso2.getString(3);
            int user_id = curso2.getInt(5);
            String comment_dec = curso2.getString(7);

            comment = new Comment(getUser(user_id).getUser_name(), stars, date, c_text, comment_dec);
            arrayList.add(comment);

        }
        return arrayList;
    }


    public User getUser(int id) {
        Cursor curso2 = sqLiteDatabase.rawQuery("select * from usr where user_id =" + id, null);
        User user = null;

        while (curso2.moveToNext()) {
            int idd = curso2.getInt(0);
            String username = curso2.getString(1);
            String password = curso2.getString(2);
            String first_name = curso2.getString(3);
            String last_name = curso2.getString(4);
            String email = curso2.getString(5);
            String phone = curso2.getString(6);

            user = new User(idd, username, password, first_name, last_name, email, phone);


        }
        return user;
    }

    public Product getProduct(int id) {
        Cursor cursoo4 = null;
        cursoo4 = sqLiteDatabase.rawQuery("select * from product where product_id =" + id, null);
        Product product2 = null;

        while (cursoo4.moveToNext()) {
            int idd = cursoo4.getInt(0);
            String title = cursoo4.getString(1);
            String dec = cursoo4.getString(2);
            int price = cursoo4.getInt(3);
            int quantity = cursoo4.getInt(4);
            String time = cursoo4.getString(5);
            String brandname = getBrand_name(cursoo4.getInt(6));

            Product product = new Product(idd, dec, title, price, getImagePath(id), brandname, getProRating(id), true, quantity, time);
            System.out.println(product.getName());
            product2 = product;
        }
        System.out.println(product2.getName());
        return product2;

    }

    public String getImagePath(int Product_id) {
        String path = "";
        cursor = sqLiteDatabase.rawQuery(("select path from image where product_id = " + Product_id), null);

        while (cursor.moveToNext()) {
            String p_path = cursor.getString(0);
            path = p_path;
        }
        return path;
    }

    public float getProRating(int Product_id) {
        float rating = 0;
        int num = 0;
        cursor = sqLiteDatabase.rawQuery(("select stars from comment where product_id = " + Product_id), null);

        while (cursor.moveToNext()) {
            int r_rating = cursor.getInt(0);
            rating += r_rating;
            num++;
        }
        return rating / num;

    }

    public String getBrand_name(int brand_id) {
        String BrandN = "";
        cursor = sqLiteDatabase.rawQuery(("select title from brand where brand_id = " + brand_id), null);
        while (cursor.moveToNext()) {
            String BrandName = cursor.getString(0);
            BrandN = BrandName;
        }
        return BrandN;
    }


    public ArrayList<String> getUsers() {

        cursor = sqLiteDatabase.rawQuery("select user_name  from usr", null);
        ArrayList<String> users_list = new ArrayList<>();

        while (cursor.moveToNext()) {
            String user = cursor.getString(0);
            System.out.println(user);
            users_list.add(user);
        }
        return users_list;
    }


    public String getPassword(String Username) {

        cursor = sqLiteDatabase.rawQuery(("select u_password  from usr where user_name = " + "'" + Username + "'"), null);
        if (cursor.moveToNext()) {
            return cursor.getString(0);
        } else {
            return "null";
        }
    }


    public void addUser(String first_name, String last_name, String email, String phone_number,
                        String username, String password) {

        ContentValues contentValues = new ContentValues();
        contentValues.put("user_name", username);
        contentValues.put("u_password", password);
        contentValues.put("first_name", first_name);
        contentValues.put("last_name", last_name);
        contentValues.put("email", email);
        contentValues.put("phon_number", phone_number);

        sqLiteDatabase.insert("usr", null, contentValues);
    }


    public void addImage(String Path, String Title) {

        ContentValues contentValues = new ContentValues();
        contentValues.put("title", Title);
        contentValues.put("path", Path);
        contentValues.put("product_id", 1);

        sqLiteDatabase.insert("image", null, contentValues);
    }

    public void addProduct(String title, String decription, int price, int qantity,
                           String insertion_time, int brand_id, int Catagory_id, Image image) {


        ContentValues contentValues = new ContentValues();

        contentValues.put("title", title);
        contentValues.put("description", decription);
        contentValues.put("price", price);
        contentValues.put("quantity", qantity);
        contentValues.put("insertion_time", insertion_time);
        contentValues.put("brand_id", brand_id);
        contentValues.put("catagorey_id", Catagory_id);
        sqLiteDatabase.insert("product", null, contentValues);
        addImage(image.getImagePath(), image.getImageTitle());

    }

    public void addBrand(String title) {

        ContentValues contentValues = new ContentValues();
        contentValues.put("title", title);

        sqLiteDatabase.insert("brand", null, contentValues);
    }


  /*  public ArrayList<ListItem> getWishListItems(){
        ArrayList<ListItem> arrayList;

        cursor = sqLiteDatabase.rawQuery("select *  from usr ", null);
        if (cursor.moveToNext()) {
             cursor.getString(0);

          ListItem listItem = new ListItem(,,,,,,);
         arrayList.add()
        } else {
            return arrayList;
        }
    }*/
}
