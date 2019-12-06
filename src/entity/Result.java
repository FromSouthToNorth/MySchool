package entity;

import java.util.Date;

public class Result {

    private String StudentNo;
    private int SubjectId;
    private double StudentResult;
    private Date ExamDate;

    public Result() {
    }

    public Result(String studentNo, int subjectId, double studentResult, Date examDate) {
        StudentNo = studentNo;
        SubjectId = subjectId;
        StudentResult = studentResult;
        ExamDate = examDate;
    }

    public String getStudentNo() {
        return StudentNo;
    }

    public int getSubjectId() {
        return SubjectId;
    }

    public double getStudentResult() {
        return StudentResult;
    }

    public Date getExamDate() {
        return ExamDate;
    }

    public void setStudentNo(String studentNo) {
        StudentNo = studentNo;
    }

    public void setSubjectId(int subjectId) {
        SubjectId = subjectId;
    }

    public void setStudentResult(double studentResult) {
        StudentResult = studentResult;
    }

    public void setExamDate(Date examDate) {
        ExamDate = examDate;
    }
}
