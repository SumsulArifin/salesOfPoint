package com.example.sysDevLtd.restController;

import com.example.sysDevLtd.entity.model.pos.Book;
import com.example.sysDevLtd.entity.model.pos.Customer;
import com.example.sysDevLtd.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
@CrossOrigin(originPatterns = {"*"})
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @PostMapping("/save")
    public void save(@RequestBody Book book) {
        System.out.println(book);
       bookRepository.save(book);
    }
}
