package techquizapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import techquizapp.dbutil.DBConnection;
import techquizapp.pojo.Performance;
import techquizapp.pojo.StudentScore;

public class PerformanceDAO {
    public static ArrayList<String> getAllExamId(String studentId) throws SQLException{
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("select examid from performance where userid=?");
        ps.setString(1, studentId);
        ResultSet rs=ps.executeQuery();
        ArrayList<String> examIdList=new ArrayList<>();
        while(rs.next())
            examIdList.add(rs.getString(1));
        return examIdList;
    }
    
    public static void addPerformance(Performance performance) throws SQLException{
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("insert into performance values(?,?,?,?,?,?,?)");
        ps.setString(1, performance.getUserId());
        ps.setString(2, performance.getExamId());
        ps.setInt(3, performance.getRight());
        ps.setInt(4, performance.getWrong());
        ps.setInt(5, performance.getUnattempted());
        ps.setDouble(6, performance.getPer());
        ps.setString(7, performance.getLanguage());
        ps.executeUpdate();
    }
    
    public static ArrayList<Performance> getAllData() throws SQLException{
        Connection conn=DBConnection.getConnection();
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("select * from performance");
        ArrayList<Performance> performanceList=new ArrayList<>();
        while(rs.next())
        {
            String userId=rs.getString(1);
            String examId=rs.getString(2);
            int right=rs.getInt(3);
            int wrong=rs.getInt(4);
            int unattempted=rs.getInt(5);
            double per=rs.getDouble(6);
            String language=rs.getString(7);
            Performance p=new Performance(userId,examId,right,wrong,unattempted,language,per);
            performanceList.add(p);
        }
        return performanceList;
    }
    public static ArrayList<String> getAllStudentId() throws SQLException{
        Connection conn=DBConnection.getConnection();
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("select distinct userid from performance");
        ArrayList<String> studentIdList=new ArrayList<>();
        while(rs.next())
            studentIdList.add(rs.getString(1));
        return studentIdList;
    }
    
    public static StudentScore getStudentScore(String studentId, String examId) throws SQLException{
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("select language,per from performance where userId=? and examId=?");
        ps.setString(1, studentId);
        ps.setString(2, examId);
        ResultSet rs=ps.executeQuery();
        rs.next();
        StudentScore score=new StudentScore(rs.getString(1),rs.getString(2));
        return score;
    }
    
    public static String getLanguage(String userId, String examId) throws SQLException{
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("select language from performance where userId=? and examId=?");
        ps.setString(1, userId);
        ps.setString(2, examId);
        ResultSet rs=ps.executeQuery();
        rs.next();
        return rs.getString(1);
    }
    
    public static double getPercentage(String userId, String examId) throws SQLException{
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("select per from performance where userId=? and examId=?");
        ps.setString(1, userId);
        ps.setString(2, examId);
        ResultSet rs=ps.executeQuery();
        rs.next();
        return rs.getDouble(1);
    }
}
