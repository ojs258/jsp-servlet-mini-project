package jsp.servlet.Entity;

public class Member {
    private int id;
    private String email;
    private String name;
    private String pw;

    // 엔티티 기본 생성자 잠그기
    private Member() {
    }

    public Member(int id, String email, String name, String pw) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.pw = pw;
    }

    public Member(String email, String name, String pw) {
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
