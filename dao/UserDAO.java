package techquizapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import techquizapp.dbutil.DBConnection;
import techquizapp.pojo.User;

public class UserDAO {
    public static boolean validateUser(User user) throws SQLException{
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("select * from users where userid=? and password=? and usertype=?");
        ps.setString(1,user.getUserId());
        ps.setString(2,user.getPassword());
        ps.setString(3, user.getUserType());
        ResultSet rs=ps.executeQuery();
        return rs.next();
    }
    public static String getExamId() throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("select count(*) from exam");
        rs.next();
        return "Ex-"+(rs.getInt(1)+1);
    }
    
    public static ArrayList<String> getAllStudentId() throws SQLException{
        Connection conn=DBConnection.getConnection();
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("select userid from users where usertype='Student'");
        ArrayList<String> studentList=new ArrayList<>();
        while(rs.next())
            studentList.add(rs.getString(1));
        return studentList;
    }
    
    public static void addStudent(User user) throws SQLException{
        String userType="Student";
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("insert into users values(?,?,?)");
        ps.setString(1,user.getUserId());
        ps.setString(2,user.getPassword());
        ps.setString(3,userType);
        ps.executeUpdate();
    }
    
    public static void changePassword(User user, String password) throws SQLException{
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("update users set password=? where userid=?");
        ps.setString(1, password);
        ps.setString(2, user.getUserId());
        ps.executeUpdate();
    }
}
