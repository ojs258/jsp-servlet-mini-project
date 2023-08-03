package jsp.servlet.repository;

import jsp.servlet.entity.Member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
        } finally {
            close();
        }
        return members;
    }

    public Member findByEmail(String m_email){
        Member member = null;
        try{

            pstmt = conn.prepareStatement("select * from member where m_email = ?");
            pstmt.setString(1, m_email);
            ResultSet rs = pstmt.executeQuery();

            member = new Member(rs.getInt("m_id"), rs.getString("m_email"), rs.getString("m_password"), rs.getString("m_name"));

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            close();
        }
        return member;
    }

    public Member findOne(int m_id){
        Member member = null;
        try{

            pstmt = conn.prepareStatement("select * from member where m_id = ?");
            pstmt.setInt(1, m_id);
            ResultSet rs = pstmt.executeQuery();

            member = new Member(rs.getInt("m_id"), rs.getString("m_email"), rs.getString("m_password"), rs.getString("m_name"));

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            close();
        }
        return member;
    }

    public void delete(int m_id){
        try{

            pstmt = conn.prepareStatement("delete from member where m_id = ?");
            pstmt.setInt(1, m_id);

            pstmt.executeUpdate();

        } catch (Exception e){
            e.printStackTrace();
        }finally {
            close();
        }
    }
}
