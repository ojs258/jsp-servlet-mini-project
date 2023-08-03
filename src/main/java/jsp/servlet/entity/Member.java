package jsp.servlet.entity;

public class Member {
    private int id;
    private String email;

    private String pw;

    private String name;

    // 엔티티 기본 생성자 잠그기
    private Member() {
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
