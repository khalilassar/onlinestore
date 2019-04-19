package soeq.app.soeq.Objects;


import java.io.Serializable;

public class Product implements Serializable {

    private String Imagepath;
    private String Description;
    private String name;
    private double Price;
    private String Man_name;
    private float Rating;
    private Boolean isloved;
    private int qantity;
    private String time;
    private int p_id;
    private String user_id;


    public Product(int p_id, String description, String name, int price, String Imagepath, String man_name, float rating, Boolean isloved, int qantity, String time) {
        this.p_id = p_id;
        this.Imagepath = Imagepath;
        Description = description;
        this.name = name;
        Price = price;
        Man_name = man_name;
        Rating = rating;
        this.isloved = isloved;
        this.time = time;
        this.qantity = qantity;
        user_id ="";

    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public int getP_id() {
        return p_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    public int getQantity() {
        return qantity;
    }

    public void setQantity(int qantity) {
        this.qantity = qantity;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public String getMan_name() {
        return Man_name;
    }

    public void setMan_name(String man_name) {
        Man_name = man_name;
    }

    public float getRating() {
        return Rating;
    }

    public void setRating(float rating) {
        Rating = rating;
    }

    public Boolean getIsloved() {
        return isloved;
    }

    public void setIsloved(Boolean isloved) {
        this.isloved = isloved;
    }


    public String getImagepath() {
        return Imagepath;
    }

    public void setImagepath(String imagepath) {
        Imagepath = imagepath;
    }

}
