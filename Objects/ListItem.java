package soeq.app.soeq.Objects;


public class ListItem {


    private Image Image;
    private String Description;
    private String name;
    private int Price;
    private String Man_name;
    private float Rating;
    private Boolean isloved;



    public ListItem(String description, String name, int price, Image Image, String Man_name, float Rating,Boolean isloved) {
        Description = description;
        this.name = name;
        Price = price;
        this.Image = Image;
        this.Man_name = Man_name;
        this.Rating = Rating;
        this.isloved  = isloved;
    }
    public Boolean getIsloved() {
        return isloved;
    }

    public void setIsloved(Boolean isloved) {
        this.isloved = isloved;
    }

    public float getRating() {
        return Rating;
    }

    public void setRating(float rating) {
        Rating = rating;
    }

    public String getMan_name() {
        return Man_name;
    }

    public void setMan_name(String man_name) {
        Man_name = man_name;
    }

    public Image getImage() {
        return Image;
    }

    public void setImage(Image image) {
        Image = image;
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

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }
}
