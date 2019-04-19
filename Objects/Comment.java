package soeq.app.soeq.Objects;


public class Comment {

    private  String Username;
    private float Rating;
    private String Date;
    private String title;
    private String Description;


    public Comment(String username, float rating, String date, String title, String description) {
        Username = username;
        Rating = rating;
        Date = date;
        this.title = title;
        Description = description;
    }


    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public float getRating() {
        return Rating;
    }

    public void setRating(float rating) {
        Rating = rating;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
