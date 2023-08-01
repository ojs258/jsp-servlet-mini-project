package jsp.servlet.Repository;

import jsp.servlet.DAO.Member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MemberRepository {
    Connection conn = null;
    PreparedStatement pstmt;

    private final String dbDriver = "org.h2.Driver";
    private final String dbUrl = "jdbc:h2:tcp://localhost/~/playdata";


    public void open(){
        try {
            Class.forName(dbDriver);
            conn = DriverManager.getConnection(dbUrl,"sa","");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void close(){
        try{
            pstmt.close();
            conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public String  save(Member member){
        open();
        String sql = "INSERT INTO member(id, name, pw) values(?,?,?)";

        try{
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, member.getId());
            pstmt.setString(2, member.getName());
            pstmt.setString(3, member.getPw());
            pstmt.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        } finally {
            close();
        }
        return member.getName()+ "님 환영합니다.";
    }

    public List<Member> findMemberList(){
        open();
        List<Member> members = new ArrayList<>();

        try{
            pstmt = conn.prepareStatement("select * from member");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()){
                members.add(new Member(rs.getString("id"), rs.getString("name"), rs.getString("pw")));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return members;
    }
}
