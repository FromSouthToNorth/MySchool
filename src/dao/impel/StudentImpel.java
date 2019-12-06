package dao.impel;

import dao.BaseDao;
import dao.StudentDAO;
import entity.Result;
import entity.Student;

import java.sql.ResultSet;
import java.util.ArrayList;

public class StudentImpel extends BaseDao implements StudentDAO {
    @Override
    public boolean addStudent(Student student) {
        String sql = "INSERT INTO Student " +
                "( StudentNo, LoginPwd, StudentName, Sex, GradeId, Phone, Address, BornDate, Email, IndentityCard) " +
                "VALUE ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ? );";
        Object[] objectArray = new Object[10];
        objectArray[0] = student.getStudentNo();
        objectArray[1] = student.getLoginPwd();
        objectArray[2] = student.getStudentName();
        objectArray[3] = student.getSex();
        objectArray[4] = student.getGradeId();
        objectArray[5] = student.getPhone();
        objectArray[6] = student.getAddress();
        objectArray[7] = student.getBornDate();
        objectArray[8] = student.getEmail();
        objectArray[9] = student.getIndentityCard();
        try {
            int result = executeUpdate(sql, objectArray);
            if (result > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean addResult(Result result) {
        String sql = "INSERT INTO result " +
                "( StudentNo, SubjectId, StudentResult, ExamDate) VALUE(?, ?, ?, ?)";
        Object[] objectArray = new Object[4];
        objectArray[0] = result.getStudentNo();
        objectArray[1] = result.getSubjectId();
        objectArray[2] = result.getStudentResult();
        objectArray[3] = result.getExamDate();
        try {
            int results = executeUpdate(sql, objectArray);
            if (results > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public ArrayList<Student> queryStudent(String grade) {
        String sql = "SELECT StudentName " +
                "FROM student " +
                "WHERE GradeId = (SELECT GradeId FROM grade WHERE GradeName = ?)";
        Object[] objectArray = new Object[1];
        ArrayList<Student> studentArrayList = new ArrayList<Student>();
        objectArray[0] = grade;
        try {
            ResultSet resultSet = executeQuery(sql, objectArray);
            while (resultSet.next()) {
                Student student = new Student();
                student.setStudentName(resultSet.getString("StudentName"));
                studentArrayList.add(student);
            }
            resultSet.close();
            return studentArrayList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Result> queryResult(String studentNo) {
        String sql = "SELECT StudentResult FROM result WHERE StudentNo = ?";
        Object[] objectsArray = new Object[1];
        ArrayList<Result> resultArrayList = new ArrayList<Result>();
        objectsArray[0] = studentNo;
        try {
            ResultSet resultSet = executeQuery(sql, objectsArray);
            while (resultSet.next()) {
                Result result = new Result();
                result.setStudentResult(resultSet.getInt("StudentResult"));
                resultArrayList.add(result);
            }
            resultSet.close();
            return resultArrayList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Integer> queryMaxMin(String course) {
        String sql = "SELECT MAX(StudentResult),MIN(StudentResult) " +
                "FROM result WHERE SubjectId = (SELECT SubjectId FROM `subject` WHERE SubjectName = ?)";
        Object[] objectArray = new Object[1];
        ArrayList<Integer> integerArrayList = new ArrayList<Integer>();
        objectArray[0] = course;
        try {
            ResultSet resultSet = executeQuery(sql, objectArray);
            resultSet.next();
            integerArrayList.add(resultSet.getInt("MAX(StudentResult)"));
            integerArrayList.add(resultSet.getInt("MIN(StudentResult)"));
            return integerArrayList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public double queryAvg(String course) {
        double avg = 0;
        String sql = "SELECT AVG(StudentResult) " +
                "FROM result WHERE SubjectId = (SELECT SubjectId FROM `subject` WHERE SubjectName = ?)";
        Object[] objectArray = new Object[1];
        objectArray[0] = course;
        try {
            ResultSet resultSet = executeQuery(sql, objectArray);
            resultSet.next();
            avg = resultSet.getDouble("AVG(StudentResult)");
            return avg;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public boolean deleteStudent(String studentNo) {
        String sql = "DELETE FROM result WHERE StudentNo = ?";
        Object[] objectsArray = new Object[1];
        objectsArray[0] = studentNo;
        try {
            int result = executeUpdate(sql, objectsArray);
            if (result > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
