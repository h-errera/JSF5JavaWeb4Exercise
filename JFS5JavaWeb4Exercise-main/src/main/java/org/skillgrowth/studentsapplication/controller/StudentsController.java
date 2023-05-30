package org.skillgrowth.studentsapplication.controller;

import org.skillgrowth.studentsapplication.StudentsApplication;
import org.skillgrowth.studentsapplication.data.entity.Student;
import org.skillgrowth.studentsapplication.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class StudentsController {

    private StudentService studentService;

    public StudentsController( StudentService studentService )
    {
        StudentsApplication.studentService = studentService;
    }

    //Retrieves all students
    @GetMapping
    public List<Student> getAllStudents() {
        // Implementation of the all() method
        return studentService.getAllStudents();
    }

    //Retrieves a student by ID
    @GetMapping("/{id}")
    public Student findById(@PathVariable(name = "id") Integer id) {
        // Implementation of the findById() method
        Optional<Student> returned = studentService.findStudentById(id);
        if (returned.isPresent()){
            return returned.get();
        } else {
            return new Student();
        }
    }

    // Saves a new student
    @PostMapping
    public void saveNewStudent(@RequestBody Student student) {
        // Implementation of the save() method
        studentService.save(student);
    }

    //Updates an existing student
    @PutMapping
    public void update(@RequestBody Student student) {
        // Implementation of the update() method
        studentService.updateStudent(student);
    }

    //Deletes a student by ID
    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id") Integer id) {
        // Implementation of the delete() method
        studentService.deleteStudent(id);
    }
}


