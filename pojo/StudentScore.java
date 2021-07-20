package techquizapp.pojo;

public class StudentScore {
    
    String language;
    String per;
    
    public StudentScore() {
    }

    public StudentScore(String language, String per) {
        this.language = language;
        this.per = per;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getPer() {
        return per;
    }

    public void setPer(String per) {
        this.per = per;
    }

}
