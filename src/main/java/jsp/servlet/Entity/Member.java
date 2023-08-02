package jsp.servlet.Entity;

public class Member {
    private String id;
    private String name;
    private String pw;

    // 엔티티 기본 생성자 잠그기
    private Member() {
    }

    public Member(String id, String name, String pw) {
        this.name = name;
        this.id = id;
        this.pw = pw;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getPw() {
        return pw;
    }
}
