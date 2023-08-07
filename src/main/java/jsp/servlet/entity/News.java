package jsp.servlet.entity;

public class News {
    private int id;
    private String title;
    private String img;
    private String date;
    private String content;
    private int m_id;

    private News() {
    }

    public News(int id, String title, String img, String date, String content) {
        this.id = id;
        this.title = title;
        this.img = img;
        this.date = date;
        this.content = content;
    }

    public News(String title, String img, String content,int m_id) {
        this.id = id;
        this.title = title;
        this.img = img;
        this.date = date;
        this.content = content;
        this.m_id = m_id;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getImg() {
        return img;
    }

    public String getContent() {
        return content;
    }

    public int getM_id() {
        return m_id;
    }

    public String getDate() {
        return date;
    }
}
