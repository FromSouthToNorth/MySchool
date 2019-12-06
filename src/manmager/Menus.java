package manmager;

import dao.impel.StudentImpel;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import entity.Result;
import entity.Student;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Menus {

    Scanner scanner = new Scanner(System.in);

    StudentImpel studentImpel = new StudentImpel();

    public void showMenus() {
        int num = 0;
        do {
            System.out.println("\t\t\t\t欢迎来到学生管理系统");
            System.out.print("1.新增一个学生信息\t\t\t\t2.新增学生的考试成绩\n");
            System.out.print("3.查询指定年级的所有学生\t\t4.查询某个学生的所有考试成绩\n");
            System.out.print("5.查询指定课程的最高分和最低分\t6.查询指定课程的平均分\n");
            System.out.print("7.删除指定学生的所有考试成绩\n8.退出\n");
            System.out.print("请选择：");
            num = scanner.nextInt();
            switch (num) {
                case 1:
                    try {
                        addStudent();
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    continue;
                case 2:
                    try {
                        addResult();
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    continue;
                case 3:
                    queryStudent();
                    continue;
                case 4:
                    queryResults();
                    continue;
                case 5:
                    queryMaximumMinimum();
                    continue;
                case 6:
                    average();
                    continue;
                case 7:
                    deleteGrades();
                    continue;
                case 8:
                default:
                    break;
            }
            break;
        } while (true);
    }

    private void addStudent() throws ParseException {
        Student student = new Student();
        System.out.print("请输入学生学号：");
        student.setStudentNo(scanner.next());
        System.out.print("请输入学生登录密码：");
        student.setLoginPwd(scanner.next());
        System.out.print("请输入学生姓名：");
        student.setStudentName(scanner.next());
        System.out.print("请输入学生性别：");
        student.setSex(scanner.next());
        System.out.print("请输入学生年级编号：");
        student.setGradeId(scanner.nextInt());
        System.out.print("请输入学生联系电话：");
        student.setPhone(scanner.next());
        System.out.print("请输入学生地址：");
        student.setAddress(scanner.next());

        System.out.print("请输入学生出生日期：");
        String sDate = scanner.next();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = dateFormat.parse(sDate);
        student.setBornDate(date);

        System.out.print("请输入学生电子邮件：");
        student.setEmail(scanner.next());
        System.out.print("请输入学生身份证号码：");
        student.setIndentityCard(scanner.next());
        if (studentImpel.addStudent(student)){
            System.out.println("添加成功！");
        } else {
            System.out.println("添加失败！");
        }

    }

    private void addResult() throws ParseException {
        Result result = new Result();
        System.out.print("请输入学生编号：");
        result.setStudentNo(scanner.next());
        System.out.print("请输入科目编号：");
        result.setSubjectId(scanner.nextInt());
        System.out.print("请输入考试成绩：");
        result.setStudentResult(scanner.nextDouble());

        System.out.print("请输入考试日期：");
        String sDate = scanner.next();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = dateFormat.parse(sDate);
        result.setExamDate(date);

        if (studentImpel.addResult(result)){
            System.out.println("添加成功！");
        } else {
            System.out.println("添加失败！");
        }
    }

    private void queryStudent() {
        System.out.print("请输入查询的年级名称（S1/S2/Y2）:");
        String gradeName = scanner.next();
        ArrayList<Student> studentArrayList = studentImpel.queryStudent(gradeName);
        System.out.println(" 姓名");
        for (Student student : studentArrayList) {
            System.out.println(student.getStudentName());
        }
    }

    private void queryResults() {
        System.out.print("请输入学生学号：");
        String studentNo = scanner.next();
        ArrayList<Result> resultArrayList = studentImpel.queryResult(studentNo);
        System.out.println(" 分数");
        for (Result result : resultArrayList) {
            System.out.println(result.getStudentResult());
        }
    }

    private void queryMaximumMinimum() {
        System.out.print("请输入课程名称：");
        String subjectName = scanner.next();
        ArrayList<Integer> integerArrayList = studentImpel.queryMaxMin(subjectName);
        for (int grade : integerArrayList) {
            System.out.println(grade);
        }
    }

    private void average() {
        System.out.print("请输入课程名称：");
        String subjectName = scanner.next();
        double avg = studentImpel.queryAvg(subjectName);
        System.out.println("平均分：" + avg);
    }

    private void deleteGrades() {
        System.out.print("请输入需要删除成绩的学生学号：");
        String studentNo = scanner.next();
        if (studentImpel.deleteStudent(studentNo)) {
            System.out.println("删除成功！");
        } else {
            System.out.println("删除失败！");
        }
    }
}
