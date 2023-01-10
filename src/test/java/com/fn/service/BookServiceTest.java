package com.fn.service;

import com.fn.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class BookServiceTest {
    @Autowired
    private BookService bookService;

    @Test
    public void selectByIdTest() {
        Book book = bookService.selectById(2);
        System.out.println(book);
    }

    @Test
    public void selectAllTest() {
        List<Book> bookList = bookService.selectAll();
        for (Book book : bookList) {
            System.out.println(book);
        }
    }
}
