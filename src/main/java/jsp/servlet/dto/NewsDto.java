package jsp.servlet.dto;

import jakarta.servlet.http.Part;

public class NewsDto {
    private int id;
    private String title;
    private String img;
    private String date;
    private String content;
    private int m_id;

    public NewsDto() {
    }

    public NewsDto(String title, String img, String content, int m_id) {
        this.title = title;
        this.img = img;
        this.content = content;
        this.m_id = m_id;
    }

    public NewsDto(String title, String img, String date, String content, int m_id) {
        this.title = title;
        this.img = img;
        this.date = date;
        this.content = content;
        this.m_id = m_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getM_id() {
        return m_id;
    }

    public void setM_id(int m_id) {
        this.m_id = m_id;
    }
}
