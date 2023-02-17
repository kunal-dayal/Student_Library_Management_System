package com.example.Student_Library_Management_System.Service;

import com.example.Student_Library_Management_System.Dtos.IssueBookRequestDto;
import com.example.Student_Library_Management_System.Repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    public String issueBook(IssueBookRequestDto issueBookRequestDto){
        return "";
    }
}
