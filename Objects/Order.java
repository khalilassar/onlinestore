package soeq.app.soeq.Objects;

public class Order {


    private String date;
    private String Statues;
    private String Type;
    private String Country;
    private String City;
    private String Street;
    private Product product;

    public Order(String date, String statues, String type, String country, String city, String street,Product product) {
        this.date = date;
        Statues = statues;
        Type = type;
        Country = country;
        City = city;
        Street = street;
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatues() {
        return Statues;
    }

    public void setStatues(String statues) {
        Statues = statues;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String street) {
        Street = street;
    }
}
