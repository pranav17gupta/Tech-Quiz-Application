package techquizapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import techquizapp.dbutil.DBConnection;
import techquizapp.pojo.Exam;
import techquizapp.pojo.Question;

public class ExamDAO {
    public static boolean addExam(Exam exam) throws SQLException{
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("insert into exam values(?,?,?)");
        ps.setString(1, exam.getExamId());
        ps.setString(2, exam.getLanguage());
        ps.setInt(3, exam.getTotalQuestions());
        int res=ps.executeUpdate();
        return res==1;
    }
    
    public static ArrayList<String> getExamIdBySubject(String subject) throws SQLException {
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("select examid from exam where language=?");
        ps.setString(1, subject);
        ResultSet rs=ps.executeQuery();
        ArrayList<String> examList=new ArrayList<>();
        while(rs.next())
            examList.add(rs.getString(1));
        return examList;
    }
    
    public static int getQuestionCountByExam(String examId) throws SQLException{
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("select total_question from exam where examid=?");
        ps.setString(1, examId);
        ResultSet rs=ps.executeQuery();
        rs.next();
        return rs.getInt(1);
    }
    
    public static ArrayList<Question> getQuestionByExamId(String examId) throws SQLException {
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("select * from questions where examid=? order by qno");
        ps.setString(1,examId);
        ResultSet rs=ps.executeQuery();
        ArrayList<Question> questionList=new ArrayList<>();
        while(rs.next())
        {
            int qno=rs.getInt(2);
            String question=rs.getString(3);
            String option1=rs.getString(4);
            String option2=rs.getString(5);
            String option3=rs.getString(6);
            String option4=rs.getString(7);
            String correctAnswer=rs.getString(8);
            String language=rs.getString(9);
            Question ques=new Question(examId,qno,language,option1,option2,option3,option4,correctAnswer,question);
            questionList.add(ques);
        }
        return questionList;
    }
    
    public static boolean isPaperSet(String subject) throws SQLException{
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("select examid from exam where language=?");
        ps.setString(1, subject);
        ResultSet rs=ps.executeQuery();
        return rs.next();
    }
    
    public static ArrayList<String> getExamIdBySubject(String userId, String subject) throws SQLException{
        String qry="select examid from exam where language=? minus select examid from performance where userid=?";
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement(qry);
        ps.setString(1, subject);
        ps.setString(2, userId);
        ResultSet rs=ps.executeQuery();
        ArrayList<String> examIdList=new ArrayList<>();
        while(rs.next())
            examIdList.add(rs.getString(1));
        return examIdList;
    } 
}
