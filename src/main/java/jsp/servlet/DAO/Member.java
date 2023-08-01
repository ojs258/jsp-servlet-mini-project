package jsp.servlet.DAO;

public class Member {
    private String id;
    private String name;

    private String pw;

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
