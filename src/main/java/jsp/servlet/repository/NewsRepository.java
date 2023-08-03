package jsp.servlet.repository;

import jsp.servlet.entity.News;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class NewsRepository {
    Connection conn = null;
    PreparedStatement pstmt;
    final String dbDriver = "org.h2.Driver";
    final String dbUrl = "jdbc:h2:tcp://localhost/~/playdata";

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

    public void save(News news){
        open();
        String sql = "INSERT INTO news(title, img, date, content) values(?,?,CURRENT_TIMESTAMP(),?)";
        System.out.println("news.getTitle() = " + news.getTitle());
        try{
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, news.getTitle());
            pstmt.setString(2, news.getImg());
            pstmt.setString(3, news.getContent()); // 3번 스킵하고 알아서 4번에 넣어주는듯?
            pstmt.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("save에러");
        } finally {
            close();
        }
    }

    public List<News> findAll(){
        open();
        List<News> newsList = new ArrayList<>();

        try{
            pstmt = conn.prepareStatement("select aid, title, img, FORMATDATETIME(date,'yyyy-MM-dd hh:mm:ss')as cdate, content" +
                    " from news");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()){
                newsList.add(new News(rs.getInt("aid")
                                        ,rs.getString("title")
                                        , rs.getString("img")
                                        , rs.getString("cdate")
                                        ,rs.getString("content")));
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("findAll에러");
        }finally {
            close();
        }
        return newsList;
    }

    public News findOne(int aid){
        News news = null;
        open();

        try{
            pstmt = conn.prepareStatement("select aid, title, img, FORMATDATETIME(date,'yyyy-MM-dd hh:mm:ss')as cdate, content" +
                    " from news " +
                    " where aid=?");

            pstmt.setInt(1,aid);
            ResultSet rs = pstmt.executeQuery();

            rs.next();

            news = new News(rs.getInt("aid"),
                    rs.getString("title"),
                    rs.getString("img"),
                    rs.getString("cdate"),
                    rs.getString("content"));

        }catch (Exception e){
            e.printStackTrace();
            System.out.println("fineOne에러");
        } finally {
            close();
        }
        return news;
    }

    public void delete(int aid){
        System.out.println("aid = " + aid);
        open();
        try{
            pstmt = conn.prepareStatement("delete from news where aid=?");
            pstmt.setInt(1,aid);
            pstmt.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("delete에러");
        }finally {
            close();
        }
    }
}
