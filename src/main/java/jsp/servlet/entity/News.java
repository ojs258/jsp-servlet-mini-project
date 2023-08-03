package jsp.servlet.entity;

public class News {
    private int id;
    private String title;
    private String img;
    private String date;
    private String content;

    public News() {
    }

    public News(int id, String title, String img, String date, String content) {
        this.id = id;
        this.title = title;
        this.img = img;
        this.date = date;
        this.content = content;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getAid() {
        return id;
    }
    public String getTitle() {
        return title;
    }

    public String getImg() {
        return img;
    }

    public String getDate() {
        return date;
    }

    public String getContent() {
        return content;
    }

    public void addImg(String img) {
        this.img = img;
    }
}
