package soeq.app.soeq.Objects;

public class Catagory {

    private String CatagoryName;
    private  int Catagoryid;

    public Catagory(int Catagoryid ,String catagoryName) {
        CatagoryName = catagoryName;
        this.Catagoryid = Catagoryid;
    }

    public String getCatagoryName() {
        return CatagoryName;
    }

    public void setCatagoryName(String catagoryName) {
        CatagoryName = catagoryName;
    }

    public int getCatagoryid() {
        return Catagoryid;
    }

    public void setCatagoryid(int catagoryid) {
        Catagoryid = catagoryid;
    }
}
