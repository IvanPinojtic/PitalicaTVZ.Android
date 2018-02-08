package tvz.pitalicatvz;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("fullName")
    @Expose
    private String fullName;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("examsCreated")
    @Expose
    private Object examsCreated;
    @SerializedName("examsTaken")
    @Expose
    private Object examsTaken;

    @Override
    public String toString() {
        return "{" +
                "fullName='" + fullName + '\'' +
                ", password='" + password +
                '}';
    }

    @SerializedName("id")
    @Expose
    private Integer id;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Object getExamsCreated() {
        return examsCreated;
    }

    public void setExamsCreated(Object examsCreated) {
        this.examsCreated = examsCreated;
    }

    public Object getExamsTaken() {
        return examsTaken;
    }

    public void setExamsTaken(Object examsTaken) {
        this.examsTaken = examsTaken;
    }

}