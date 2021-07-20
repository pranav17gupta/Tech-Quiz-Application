package techquizapp.pojo;

public class Performance {

    String userId;
    String examId;
    int right;
    int wrong;
    int unattempted;
    String language;
    double per;
    
    public Performance(String userId, String examId, int right, int wrong, int unattempted, String language, double per) {
        this.userId = userId;
        this.examId = examId;
        this.right = right;
        this.wrong = wrong;
        this.unattempted = unattempted;
        this.language = language;
        this.per = per;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public double getPer() {
        return per;
    }

    public void setPer(double per) {
        this.per = per;
    }
    
    public Performance() {
    }

    public Performance(String userId, String examId, int right, int wrong, int unattempted) {
        this.userId = userId;
        this.examId = examId;
        this.right = right;
        this.wrong = wrong;
        this.unattempted = unattempted;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getExamId() {
        return examId;
    }

    public void setExamId(String examId) {
        this.examId = examId;
    }

    public int getRight() {
        return right;
    }

    public void setRight(int right) {
        this.right = right;
    }

    public int getWrong() {
        return wrong;
    }

    public void setWrong(int wrong) {
        this.wrong = wrong;
    }

    public int getUnattempted() {
        return unattempted;
    }

    public void setUnattempted(int unattempted) {
        this.unattempted = unattempted;
    }

}
