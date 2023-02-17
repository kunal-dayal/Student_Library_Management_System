package com.example.Student_Library_Management_System.Service;

import com.example.Student_Library_Management_System.Dtos.AuthorEntryDto;
import com.example.Student_Library_Management_System.Models.Author;
import com.example.Student_Library_Management_System.Repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    public String createAuthor(AuthorEntryDto authorEntryDto){

        Author author = new Author();

        author.setAge(authorEntryDto.getAge());
        author.setCountry(authorEntryDto.getCountry());
        author.setName(authorEntryDto.getName());
        author.setRating(authorEntryDto.getRating());


        authorRepository.save(author);
        return "Author added sucessfully";
    }
}
