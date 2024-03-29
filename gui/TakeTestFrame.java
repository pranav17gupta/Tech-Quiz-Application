/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techquizapp.gui;

import java.awt.Color;
import java.awt.Font;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import techquizapp.dao.ExamDAO;
import techquizapp.dao.PerformanceDAO;
import techquizapp.pojo.Answer;
import techquizapp.pojo.AnswerStore;
import techquizapp.pojo.Exam;
import techquizapp.pojo.Performance;
import techquizapp.pojo.Question;
import techquizapp.pojo.QuestionStore;
import techquizapp.pojo.UserProfile;

/**
 *
 * @author Pranav Gupta
 */
public class TakeTestFrame extends javax.swing.JFrame {
    Exam exam;
    Color oldColor;
    QuestionStore qstore;
    int pos=0;
    int qno;
    AnswerStore astore;
    /**
     * Creates new form TakeTestFrame
     */
    public TakeTestFrame() {
        initComponents();
        setLocationRelativeTo(null);
        lblUserName.setText("Hello "+UserProfile.getUsername());
        oldColor=lblLogout.getForeground();
        qstore=new QuestionStore();
        astore=new AnswerStore();
        qno=1;
        lblQno.setText(lblQno.getText()+qno);
        TimerThread tr=new TimerThread();
        tr.start();
    }

    public TakeTestFrame(Exam exam){
        this();
        this.exam=exam;
        lblSubject.setText(exam.getLanguage().toUpperCase()+" PAPER");
        loadQuestions();
        showQuestion();
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        lblSubject = new javax.swing.JLabel();
        lblQno = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtQuestion = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jrbOption1 = new javax.swing.JRadioButton();
        jrbOption2 = new javax.swing.JRadioButton();
        jrbOption3 = new javax.swing.JRadioButton();
        jrbOption4 = new javax.swing.JRadioButton();
        btnNext = new javax.swing.JButton();
        btnPrevious = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnDone = new javax.swing.JButton();
        lblUserName = new javax.swing.JLabel();
        lblLogout = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblTimer = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        lblSubject.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblSubject.setForeground(new java.awt.Color(204, 102, 0));
        lblSubject.setText("Take test");

        lblQno.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblQno.setForeground(new java.awt.Color(204, 102, 0));
        lblQno.setText("Question No: ");

        txtQuestion.setColumns(20);
        txtQuestion.setRows(5);
        jScrollPane1.setViewportView(txtQuestion);

        jLabel3.setIcon(new javax.swing.ImageIcon("D:\\Images\\goodLuck.JPG")); // NOI18N

        buttonGroup1.add(jrbOption1);
        jrbOption1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jrbOption1.setForeground(new java.awt.Color(204, 102, 0));
        jrbOption1.setText("jRadioButton1");
        jrbOption1.setOpaque(false);

        buttonGroup1.add(jrbOption2);
        jrbOption2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jrbOption2.setForeground(new java.awt.Color(204, 102, 0));
        jrbOption2.setText("jRadioButton2");
        jrbOption2.setOpaque(false);

        buttonGroup1.add(jrbOption3);
        jrbOption3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jrbOption3.setForeground(new java.awt.Color(204, 102, 0));
        jrbOption3.setText("jRadioButton3");
        jrbOption3.setOpaque(false);

        buttonGroup1.add(jrbOption4);
        jrbOption4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jrbOption4.setForeground(new java.awt.Color(204, 102, 0));
        jrbOption4.setText("jRadioButton4");
        jrbOption4.setOpaque(false);

        btnNext.setBackground(new java.awt.Color(0, 0, 0));
        btnNext.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnNext.setForeground(new java.awt.Color(204, 102, 0));
        btnNext.setText("Next");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnPrevious.setBackground(new java.awt.Color(0, 0, 0));
        btnPrevious.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnPrevious.setForeground(new java.awt.Color(204, 102, 0));
        btnPrevious.setText("Previous");
        btnPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreviousActionPerformed(evt);
            }
        });

        btnCancel.setBackground(new java.awt.Color(0, 0, 0));
        btnCancel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCancel.setForeground(new java.awt.Color(204, 102, 0));
        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnDone.setBackground(new java.awt.Color(0, 0, 0));
        btnDone.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnDone.setForeground(new java.awt.Color(204, 102, 0));
        btnDone.setText("Done");
        btnDone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoneActionPerformed(evt);
            }
        });

        lblUserName.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblUserName.setForeground(new java.awt.Color(204, 102, 0));

        lblLogout.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblLogout.setForeground(new java.awt.Color(204, 102, 0));
        lblLogout.setText("Logout");
        lblLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLogoutMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblLogoutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblLogoutMouseExited(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Time Left:");

        lblTimer.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblTimer.setForeground(new java.awt.Color(255, 255, 255));
        lblTimer.setText("jLabel2");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(27, 27, 27)
                            .addComponent(lblQno, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jrbOption1)
                                        .addComponent(jrbOption3))
                                    .addGap(63, 63, 63)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jrbOption4)
                                        .addComponent(jrbOption2)))))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(189, 189, 189)
                            .addComponent(jLabel3))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(45, 45, 45)
                            .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(26, 26, 26)
                            .addComponent(btnPrevious, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(32, 32, 32)
                            .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(29, 29, 29)
                            .addComponent(btnDone, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(222, 222, 222)
                        .addComponent(lblSubject)
                        .addGap(130, 130, 130)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblTimer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLogout))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSubject)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTimer)
                .addGap(1, 1, 1)
                .addComponent(jLabel3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jrbOption1)
                            .addComponent(jrbOption2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jrbOption3)
                            .addComponent(jrbOption4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                        .addComponent(lblQno)
                        .addGap(173, 173, 173)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNext)
                    .addComponent(btnPrevious)
                    .addComponent(btnCancel)
                    .addComponent(btnDone))
                .addGap(31, 31, 31))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogoutMouseClicked
        LoginFrame loginFrame=new LoginFrame();
        loginFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblLogoutMouseClicked

    private void lblLogoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogoutMouseEntered
        lblLogout.setForeground(java.awt.Color.white);
        Font f=new Font("Tahome",Font.ITALIC,12);
        lblLogout.setFont(f);
    }//GEN-LAST:event_lblLogoutMouseEntered

    private void lblLogoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogoutMouseExited
        // TODO add your handling code here:
        lblLogout.setForeground(oldColor);
        Font f=new Font("Tahome",Font.BOLD,12);
        lblLogout.setFont(f);
    }//GEN-LAST:event_lblLogoutMouseExited

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        String chosenAnswer=getUserAnswer();
        if(chosenAnswer!=null){
            Question question=qstore.getQuestionByQno(qno);
            String correctAnswer=question.getCorrectAnswer();
            Answer newAnswer=new Answer(exam.getExamId(),exam.getLanguage(),qno,chosenAnswer,correctAnswer);
            Answer answer=astore.getAnswerByQno(qno);
            if(answer==null)
                astore.addAnswer(newAnswer);
            else{
                if(newAnswer.getChosenAnswer().equals(answer.getChosenAnswer())==false){
                    int apos=astore.removeAnswer(answer);
                    astore.setAnswerAt(pos,newAnswer);
                }
            }
        }
        pos++;
        if(pos>=qstore.getCount())
            pos=0;
        qno++;
        if(qno>qstore.getCount())
            qno=1;
        lblQno.setText("Question No: "+qno);
        showQuestion();
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreviousActionPerformed
        String chosenAnswer=getUserAnswer();
        if(chosenAnswer!=null){
            Question question=qstore.getQuestionByQno(qno);
            String correctAnswer=question.getCorrectAnswer();
            Answer newAnswer=new Answer(exam.getExamId(),exam.getLanguage(),qno,chosenAnswer,correctAnswer);
            Answer answer=astore.getAnswerByQno(qno);
            if(answer==null)
                astore.addAnswer(newAnswer);
            else{
                if(newAnswer.getChosenAnswer().equals(answer.getChosenAnswer())==false){
                    int apos=astore.removeAnswer(answer);
                    astore.setAnswerAt(pos,newAnswer);
                }
            }
        }
        pos--;
        if(pos<0)
            pos=qstore.getCount()-1;
        qno--;
        if(qno<=0)
            qno=qstore.getCount();
        lblQno.setText("Question No: "+qno);
        showQuestion();
    }//GEN-LAST:event_btnPreviousActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        PaperSelectionFrame paperSelection=new PaperSelectionFrame();
        paperSelection.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnDoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoneActionPerformed
        String chosenAnswer=getUserAnswer();
        if(chosenAnswer!=null){
            Question question=qstore.getQuestionByQno(qno);
            String correctAnswer=question.getCorrectAnswer();
            Answer newAnswer=new Answer(exam.getExamId(),exam.getLanguage(),qno,chosenAnswer,correctAnswer);
            Answer answer=astore.getAnswerByQno(qno);
            if(answer==null)
                astore.addAnswer(newAnswer);
            else{
                if(newAnswer.getChosenAnswer().equals(answer.getChosenAnswer())==false){
                    int apos=astore.removeAnswer(answer);
                    astore.setAnswerAt(pos,newAnswer);
                }
            }
        }
        int right=0,wrong=0;
        for(Question question: qstore.getAllQuestions()){
            int qno=question.getQno();
            Answer answer=astore.getAnswerByQno(qno);
            if(answer==null)
                continue;
            else{
                String chosenAnswer1=answer.getChosenAnswer();
                String correctAnswer=answer.getCorrectAnswer();
                if(chosenAnswer1.equals(correctAnswer))
                    right++;
                else
                    wrong++;
            }
        }
        String reportCard="Total Questions: "+qstore.getCount()+"\nRight Answers: "+right+"\nWrong Answer: "+wrong+"\nUnattempted: "+(qstore.getCount()-right-wrong);
        JOptionPane.showMessageDialog(null, reportCard, "Your Result!", JOptionPane.INFORMATION_MESSAGE);
        try{
            Performance performance=new Performance(UserProfile.getUsername(),exam.getExamId(),right,wrong,(qstore.getCount()-right-wrong),exam.getLanguage(),(double)right/qstore.getCount()*100);
            PerformanceDAO.addPerformance(performance);
            JOptionPane.showMessageDialog(null, "Your Performance is successfully added to database", "Performance Added!", JOptionPane.INFORMATION_MESSAGE);
            PaperSelectionFrame paperSelection=new PaperSelectionFrame();
            paperSelection.setVisible(true);
            this.dispose();
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Database Error","Error",JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
        
    }//GEN-LAST:event_btnDoneActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TakeTestFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TakeTestFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TakeTestFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TakeTestFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TakeTestFrame().setVisible(true);
            }
        });
    }
    
    private void loadQuestions(){
        try{
            ArrayList<Question> questionList=ExamDAO.getQuestionByExamId(exam.getExamId());
            for(Question q : questionList)
                qstore.addQuestion(q);
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Database Error", "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }
    
    private void showQuestion(){
        Question question=qstore.getQuestion(pos);
        buttonGroup1.clearSelection();
        txtQuestion.setText(question.getQuestion());
        jrbOption1.setText(question.getAnswer1());
        jrbOption2.setText(question.getAnswer2());
        jrbOption3.setText(question.getAnswer3());
        jrbOption4.setText(question.getAnswer4());
        Answer answer=astore.getAnswerByQno(qno);
        if(answer==null)
            return;
        String chosenAnswer=answer.getChosenAnswer();
        switch(chosenAnswer){
            case "Answer1":
                jrbOption1.setSelected(true);
                break;
            case "Answer2":
                jrbOption2.setSelected(true);
                break;
            case "Answer3":
                jrbOption3.setSelected(true);
                break;
            case "Answer4":
                jrbOption4.setSelected(true);
                break;
        }
    }

    public String getUserAnswer(){
        if(jrbOption1.isSelected())
            return "Answer1";
        else if(jrbOption2.isSelected())
            return "Answer2";
        else if(jrbOption3.isSelected())
            return "Answer3";
        else if(jrbOption4.isSelected())
            return "Answer4";
        else 
            return null;
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDone;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrevious;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton jrbOption1;
    private javax.swing.JRadioButton jrbOption2;
    private javax.swing.JRadioButton jrbOption3;
    private javax.swing.JRadioButton jrbOption4;
    private javax.swing.JLabel lblLogout;
    private javax.swing.JLabel lblQno;
    private javax.swing.JLabel lblSubject;
    private javax.swing.JLabel lblTimer;
    private javax.swing.JLabel lblUserName;
    private javax.swing.JTextArea txtQuestion;
    // End of variables declaration//GEN-END:variables

    class TimerThread extends Thread{

        public void run() {
            int time=exam.getTotalQuestions()*30;
            while(time>=0)
            {
                try{
                    int hours = (int) time / 3600;
                    int remainder = (int) time - hours * 3600;
                    int mins = remainder / 60;
                    remainder = remainder - mins * 60;
                    int secs = remainder;
                    lblTimer.setText(mins+":"+secs+" sec");
                    Thread.sleep(1000);
                    time--;
                }
                catch(InterruptedException ex){
                    System.out.println("Thread interrupted");
                }
            }
            JOptionPane.showMessageDialog(null, "Time given for exam is completed\nPress Done to submit", "No Time Left!", JOptionPane.INFORMATION_MESSAGE);
            btnNext.setEnabled(false);
            btnPrevious.setEnabled(false);
            btnCancel.setEnabled(false);
            jrbOption1.setEnabled(false);
            jrbOption2.setEnabled(false);
            jrbOption3.setEnabled(false);
            jrbOption4.setEnabled(false);
        }
    }
}
