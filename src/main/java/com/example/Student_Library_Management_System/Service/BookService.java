package com.example.Student_Library_Management_System.Service;


import com.example.Student_Library_Management_System.Dtos.BookRequestDto;
import com.example.Student_Library_Management_System.Models.Author;
import com.example.Student_Library_Management_System.Models.Book;
import com.example.Student_Library_Management_System.Repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    AuthorRepository authorRepository;

    public String addBook(BookRequestDto bookRequestDto){

        int authorId = bookRequestDto.getAuthorId();

        Author author = authorRepository.findById(authorId).get();


        Book book = new Book();
        book.setGenre(bookRequestDto.getGenre());
        book.setName(bookRequestDto.getName());
        book.setPages(bookRequestDto.getPages());
        book.setIssued(false);

        book.setAuthor(author);


        List<Book> currentBooksWritten = author.getBooksWritten();
        currentBooksWritten.add(book);

        authorRepository.save(author);

        return "Book Added Sucessfully";

    }

}
