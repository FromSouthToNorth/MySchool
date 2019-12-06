package dao;

import entity.*;

import java.util.ArrayList;

public interface StudentDAO {

    public boolean addStudent(Student student);

    public boolean addResult(Result result);

    public ArrayList<Student> queryStudent(String grade);

    public ArrayList<Result> queryResult(String studentNo);

    public ArrayList<Integer> queryMaxMin(String course);

    public double queryAvg(String course);

    public boolean deleteStudent(String studentNo);
}
