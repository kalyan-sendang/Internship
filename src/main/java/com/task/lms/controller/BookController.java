package com.task.lms.controller;

import com.task.lms.model.Book;
import com.task.lms.model.User;
import com.task.lms.service.BookService;
import com.task.lms.utils.CustomException;
import com.task.lms.utils.ResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {
    @Autowired
    BookService bookService;


    @GetMapping("/book/{id}")
    private ResponseEntity<ResponseWrapper> getBook(@PathVariable("id")int id){
        Book book = bookService.getABook(id);
        if (book != null) {
            try {
                ResponseWrapper response = new ResponseWrapper();
                response.setStatusCode(HttpStatus.OK.value());
                response.setMessage("Book retrieved successfully");
                response.setResponse(book);
                return ResponseEntity.ok(response);
            }catch(CustomException e){
                throw new CustomException(e.getMessage());
            }
        } else {
            ResponseWrapper response = new ResponseWrapper();
            response.setStatusCode(HttpStatus.NOT_FOUND.value());
            response.setMessage("Book not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @GetMapping("/book")
    private ResponseEntity<ResponseWrapper> getAllBook(){
        List<Book> books = bookService.getAllBook();
        if(books != null) {
                ResponseWrapper response = new ResponseWrapper();
                response.setStatusCode(HttpStatus.OK.value());
                response.setMessage("Books retrieved successfully");
                response.setResponse(books);
                return ResponseEntity.ok(response);
        }
        else{
            throw new CustomException("Database is empty");
        }

    }

}
