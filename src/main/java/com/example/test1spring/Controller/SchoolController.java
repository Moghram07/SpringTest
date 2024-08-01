package com.example.test1spring.Controller;

import com.example.test1spring.Model.Student;
import com.example.test1spring.Model.Teacher;
import com.example.test1spring.Service.SchoolService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.internal.constraintvalidators.bv.time.futureorpresent.FutureOrPresentValidatorForOffsetDateTime;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/school")
@RequiredArgsConstructor
public class SchoolController {
    private final SchoolService schoolService;
    private final FutureOrPresentValidatorForOffsetDateTime futureOrPresentValidatorForOffsetDateTime;

    SchoolService getSchoolService() {
        return schoolService;
    }
    @GetMapping("/get/students")
    public ResponseEntity getStudents(){
        ArrayList<Student> student = schoolService.getStudent();
        return ResponseEntity.status(200).body(student);
    }

    @GetMapping("/get/teachers")
    public ResponseEntity getTeacher(){
        ArrayList<Teacher> teacher = schoolService.getTeacher();
        return ResponseEntity.status(200).body(teacher);
    }

    @PostMapping("/add/student")
    public ResponseEntity addStudent(@Valid @RequestBody Student student, Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        getSchoolService().addStudent(student);
        return ResponseEntity.status(201).body("Student added");
    }

    @PostMapping("/add/teacher")
    public ResponseEntity addTeacher(@Valid @RequestBody Teacher teacher, Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        getSchoolService().addTeacher(teacher);
        return ResponseEntity.status(201).body("Teacher added");
    }

    @PutMapping("/update/student/{index}")
    public ResponseEntity updateStudent(@Valid @RequestBody Student student, @PathVariable int index, Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        getSchoolService().getStudent().set(index,student);
        return ResponseEntity.status(201).body("Student updated");
    }

    @PutMapping("/update/teacher/{index}")
    public ResponseEntity updateStudent(@Valid @RequestBody Teacher teacher, @PathVariable int index, Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        getSchoolService().getTeacher().set(index,teacher);
        return ResponseEntity.status(201).body("teachder updated");
    }

    @DeleteMapping("/delete/student/{index}")
    public ResponseEntity deleteStudent(@PathVariable int index){
        getSchoolService().getStudent().remove(index);
        return ResponseEntity.status(204).body("Student deleted");
    }

    @DeleteMapping("/delete/teacher/{index}")
    public ResponseEntity deleteTeacher(@PathVariable int index){
        getSchoolService().getTeacher().remove(index);
        return ResponseEntity.status(204).body("Teacher deleted");
    }

    @GetMapping("/get/student/{name}")
    public ResponseEntity getStudentByName(@PathVariable String name){
        ArrayList<Student> student = getSchoolService().getStudent();
        for(Student s : student){
            if(s.getName().equals(name)){
                student.add(s);
                return ResponseEntity.status(201).body(s);
            }
        }
        return ResponseEntity.status(404).body("Student not found");
    }

    @GetMapping("/get/student/major")
    public ResponseEntity getStudentMajor(@PathVariable String major){
        ArrayList<Student> studentByMajor = getSchoolService().getStudent();
        for(Student s : studentByMajor){
            if(s.getMajor().equals(major)){
                studentByMajor.add(s);
                return ResponseEntity.status(201).body(s);
            }
        }
        return ResponseEntity.status(404).body("Student not found");
    }

    @GetMapping("/get/teacher/{id}")
    public ResponseEntity getTeacherById(@PathVariable int id){
        ArrayList<Teacher> teacherById = getSchoolService().getTeacher();
        for(Teacher t : teacherById){
            if(t.getId() == id){
                teacherById.add(t);
                return ResponseEntity.status(201).body(t);
            }
        }
        return ResponseEntity.status(404).body("Teacher not found");
    }

    @GetMapping("/get/teacher/{salary}")
    public ResponseEntity getTeacherBySalary(@PathVariable int salary){
        ArrayList<Teacher> teacherBySalary = getSchoolService().getTeacher();
        for(Teacher t : teacherBySalary){
            if(t.getSalary() == salary){
                teacherBySalary.add(t);
                return ResponseEntity.status(201).body(t);
            }
        }
        return ResponseEntity.status(404).body("Teacher not found");
    }

}
