package jsp.servlet.entity;

import java.util.List;

public class Member {
    private int id;
    private String email;

    private String pw;

    private String name;

    private List<Integer> news_ids;

    // 엔티티 기본 생성자 잠그기
    private Member() {
    }

    public Member(String email) {
        this.email = email;
    }

    public Member(int id, String email, String pw, String name) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.pw = pw;
    }

    public Member(String email, String pw, String name) {
        this.email = email;
        this.name = name;
        this.pw = pw;
    }

    public void addNews(int n_id){
        news_ids.add(n_id);
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getPw() {
        return pw;
    }
}
