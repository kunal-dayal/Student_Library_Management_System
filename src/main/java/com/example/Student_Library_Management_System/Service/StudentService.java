package com.example.Student_Library_Management_System.Service;

import com.example.Student_Library_Management_System.Enums.CardStatus;
import com.example.Student_Library_Management_System.Models.Card;
import com.example.Student_Library_Management_System.Models.Student;
import com.example.Student_Library_Management_System.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;


    public String createStudent(Student student){

        Card card = new Card();
        card.setCardStatus(CardStatus.ACTIVATED);
        card.setStudentVariableName(student);

        student.setCard(card);

        studentRepository.save(student);

        return "Student and card are added";
    }


    public String findNameByEmail(String email){

        Student student = studentRepository.findByEmail(email);
        return student.getName();
    }

    public String updateMobNo(Student newStudent){
        Student orignalStudent = studentRepository.findById(newStudent.getId()).get();
        orignalStudent.setMobNo(newStudent.getMobNo());
        studentRepository.save(orignalStudent);
        return "Student has been updated sucessfully";
    }
}
