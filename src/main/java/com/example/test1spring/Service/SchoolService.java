package com.example.test1spring.Service;

import com.example.test1spring.Model.Student;
import com.example.test1spring.Model.Teacher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class SchoolService {
    ArrayList<Student> students = new ArrayList<Student>();
    ArrayList<Teacher> teachers = new ArrayList<Teacher>();

    public ArrayList<Student> getStudent(){
        return students;
    }
    public ArrayList<Teacher> getTeacher(){
        return teachers;
    }

    public boolean addStudent(Student student){
        students.add(student);
        return true;
    }
    public boolean addTeacher(Teacher teacher){
        teachers.add(teacher);
        return true;
    }

    public boolean updateStudent(Student student){
        int index = students.indexOf(student);
        students.set(index, student);
        return true;
    }
    public boolean updateTeacher(Teacher teacher){
        int index = teachers.indexOf(teacher);
        teachers.set(index, teacher);
        return true;
    }

    public boolean removeStudent(Student student){
        students.remove(student);
        return true;
    }
    public boolean removeTeacher(Teacher teacher){
        teachers.remove(teacher);
        return true;
    }

    public boolean getStudentsByName(String name){
        ArrayList<Student> studentName = new ArrayList<>();
        for(Student student : students){
            if(student.getName().equals(name)){
                studentName.add(student);
                return true;
            }
        }
        return false;
    }

    public boolean getStudentByMajor(String major){
        ArrayList<Student> studentMajor = new ArrayList<>();
        for(Student student : students){
            if(student.getMajor().equals(major)){
                studentMajor.add(student);
                return true;
            }
        }
        return false;
    }

    public boolean getTeacherbyId(int id){
        ArrayList<Teacher> teachersById = new ArrayList<>();
        for(Teacher teacher : teachers){
            if(teacher.getId() == id){
                teachersById.add(teacher);
                return true;
            }
        }
        return false;
    }

    public boolean getTeacherBySalary(double salary){
        ArrayList<Teacher> teachersBySalary = new ArrayList<>();
        for(Teacher teacher : teachers){
            if(teacher.getSalary() == salary){
                teachersBySalary.add(teacher);
                return true;
            }
        }
        return false;
    }


}
