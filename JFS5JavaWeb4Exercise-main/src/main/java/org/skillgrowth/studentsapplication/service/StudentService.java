package org.skillgrowth.studentsapplication.service;


import org.skillgrowth.studentsapplication.data.StudentRepository;
import org.skillgrowth.studentsapplication.data.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService
{

    private final StudentRepository studentsRepository;

    public StudentService( StudentRepository studentsRepository )
    {
        this.studentsRepository = studentsRepository;
    }


    public List<Student> getAllStudents()
    {
        return studentsRepository.findAll();
    }


    public Optional<Student> findStudentById( Integer studentId )
    {
        return studentsRepository.findById( studentId );
    }


    public void save( Student student )
    {
        studentsRepository.save( student );
    }

    public void updateStudent(Student student){
        Integer id = student.getId();
        studentsRepository.deleteById(id);
        studentsRepository.save(student);
    }

    public void deleteStudent( int studentId )
    {
        studentsRepository.deleteById( studentId );
    }

}
