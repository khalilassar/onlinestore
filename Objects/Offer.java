package soeq.app.soeq.Objects;

public class Offer {
    private  int Offer_id;
    private Product product;
    private String start_date;
    private String end_date;
    private int discount;

    public Offer(int offer_id, Product product, String start_date, String end_date, int discount) {
        Offer_id = offer_id;
        this.product = product;
        this.start_date = start_date;
        this.end_date = end_date;
        this.discount = discount;
    }

    public int getOffer_id() {
        return Offer_id;
    }

    public void setOffer_id(int offer_id) {
        Offer_id = offer_id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }
}
