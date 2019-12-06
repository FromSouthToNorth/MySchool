package entity;

import java.util.Date;

public class Student {

    private String StudentNo;
    private String LoginPwd;
    private String StudentName;
    private String Sex;
    private int GradeId;
    private String Phone;
    private String Address;
    private Date BornDate;
    private String Email;
    private String IndentityCard;

    public Student() {
    }

    public Student(String studentNo, String loginPwd, String studentName,
                   String sex, int gradeId, String phone, String address,
                   Date bornDate, String email, String indentityCard) {
        StudentNo = studentNo;
        LoginPwd = loginPwd;
        StudentName = studentName;
        Sex = sex;
        GradeId = gradeId;
        Phone = phone;
        Address = address;
        BornDate = bornDate;
        Email = email;
        IndentityCard = indentityCard;
    }

    public String getStudentNo() {
        return StudentNo;
    }

    public String getLoginPwd() {
        return LoginPwd;
    }

    public String getStudentName() {
        return StudentName;
    }

    public String getSex() {
        return Sex;
    }

    public int getGradeId() {
        return GradeId;
    }

    public String getPhone() {
        return Phone;
    }

    public String getAddress() {
        return Address;
    }

    public Date getBornDate() {
        return BornDate;
    }

    public String getEmail() {
        return Email;
    }

    public String getIndentityCard() {
        return IndentityCard;
    }

    public void setStudentNo(String studentNo) {
        StudentNo = studentNo;
    }

    public void setLoginPwd(String loginPwd) {
        LoginPwd = loginPwd;
    }

    public void setStudentName(String studentName) {
        StudentName = studentName;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public void setGradeId(int gradeId) {
        GradeId = gradeId;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public void setBornDate(Date bornDate) {
        BornDate = bornDate;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setIndentityCard(String indentityCard) {
        IndentityCard = indentityCard;
    }
}
