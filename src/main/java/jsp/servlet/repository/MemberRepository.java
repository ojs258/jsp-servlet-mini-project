package jsp.servlet.repository;

import jakarta.ws.rs.OPTIONS;
import jsp.servlet.entity.Member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MemberRepository {
    Connection conn = null;
    PreparedStatement pstmt = null;

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

    public void save(Member member){
        open();
        try{

            pstmt = conn.prepareStatement("INSERT INTO member(m_email, m_password, m_name) values(?,?,?)");

            pstmt.setString(1, member.getEmail());
            pstmt.setString(2, member.getPw());
            pstmt.setString(3, member.getName());

            pstmt.executeUpdate();

        } catch(Exception e) {
            e.printStackTrace();
            System.out.println("save error");
        } finally {
            close();
        }
    }

    public List<Member> findAll(){
        open();
        List<Member> members = new ArrayList<>();

        try{

            pstmt = conn.prepareStatement("select * from member");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()){
                members.add(new Member(rs.getInt("m_id"), rs.getString("m_email"), rs.getString("m_password"), rs.getString("m_name")));
            }

        } catch (Exception e){
            e.printStackTrace();
            System.out.println("findAll에러");
        } finally {
            close();
        }
        return members;
    }
    public int duplicatedEmail(String m_email){
        open();
        int cond = 0;
        try {
            pstmt = conn.prepareStatement("select count(*) as cnt from member where m_email=?");
            pstmt.setString(1, String.valueOf(m_email));
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            cond = rs.getInt("cnt");

        }catch (Exception e){

            e.printStackTrace();
            System.out.println("email count 에러");

        }finally {
            close();
        }
        return cond;
    }
    public Member findByEmail(String m_email){
        open();
        Member member = null;
        try{

            pstmt = conn.prepareStatement("select * from member where m_email=?");
            pstmt.setString(1, String.valueOf(m_email));
            ResultSet rs = pstmt.executeQuery();

            rs.next();
            // 2시간 걸려서 잡은 에러 JDBC의 결과인 ResultSet는 iterator의 성질을 띄기 때문에
            // 0번인덱스에는 주소 값의 도착지점이있고 아무런 값도 없는 공간이다.
            // next()메서드를 통해서 값이 있는칸을 가르키도록 해야지 getOO메서드로 값을 가져올 수 있다.

            member = new Member(rs.getInt("m_id"),
                                rs.getString("m_email"),
                                rs.getString("m_password"),
                                rs.getString("m_name"));

        } catch (Exception e){
            e.printStackTrace();
            System.out.println("findByEmail에러");
        } finally {
            close();
        }

        return member;
    }

    public Member findOne(int m_id){
        open();
        Member member = null;
        try{

            pstmt = conn.prepareStatement("select * from member where m_id=?");
            pstmt.setInt(1, m_id);
            ResultSet rs = pstmt.executeQuery();

            member = new Member(rs.getInt("m_id"),
                                rs.getString("m_email"),
                                rs.getString("m_password"),
                                rs.getString("m_name"));
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("findOne에러");
        } finally {
            close();
        }
        return member;
    }

    public void delete(int m_id){
        open();
        try{

            pstmt = conn.prepareStatement("delete from member where m_id = ?");
            pstmt.setInt(1, m_id);

            pstmt.executeUpdate();

        } catch (Exception e){
            e.printStackTrace();
            System.out.println("delete에러");
        }finally {
            close();
        }
    }
}
