package soeq.app.soeq.Objects;

public class Image {
    private String ImagePath;
    private String ImageTitle;

    public Image(String imagePath, String imageTitle) {
        ImagePath = imagePath;
        ImageTitle = imageTitle;
    }


    public String getImagePath() {
        return ImagePath;
    }

    public String getImageTitle() {
        return ImageTitle;
    }

}
