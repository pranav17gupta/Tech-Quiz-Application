package techquizapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import techquizapp.dbutil.DBConnection;
import techquizapp.pojo.Question;
import techquizapp.pojo.QuestionStore;

public class QuestionDAO {
    public static void addQuestions(QuestionStore qstore) throws SQLException{
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("insert into questions values(?,?,?,?,?,?,?,?,?)");
        ArrayList<Question> questionList=qstore.getAllQuestions();
        for(Question q: questionList){
            ps.setString(1, q.getExamId());
            ps.setInt(2, q.getQno());
            ps.setString(3, q.getQuestion());
            ps.setString(4, q.getAnswer1());
            ps.setString(5, q.getAnswer2());
            ps.setString(6, q.getAnswer3());
            ps.setString(7, q.getAnswer4());
            ps.setString(8, q.getCorrectAnswer());
            ps.setString(9, q.getLanguage());
            ps.executeUpdate();
        }
    }
    
    public static void updateQuestions(QuestionStore qstore) throws SQLException{
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("update questions set question=?,answer1=?,answer2=?,answer3=?,answer4=?,correct_answer=? where qno=? and examid=?");
        ArrayList<Question> questionList=qstore.getAllQuestions();
        for(Question q: questionList){
            ps.setString(1, q.getQuestion());
            ps.setString(2, q.getAnswer1());
            ps.setString(3, q.getAnswer2());
            ps.setString(4, q.getAnswer3());
            ps.setString(5, q.getAnswer4());
            ps.setString(6, q.getCorrectAnswer());
            ps.setInt(7, q.getQno());
            ps.setString(8,q.getExamId());
            ps.executeUpdate();
        }
    }
}
