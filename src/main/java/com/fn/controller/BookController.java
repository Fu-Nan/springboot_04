package com.fn.controller;

import com.fn.domain.Book;
import com.fn.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping
    public Result save(@RequestBody Book book) {
        Boolean save = bookService.save(book);
        return new Result(save ? Code.SAVE_OK : Code.SAVE_ERR, save);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        Boolean delete = bookService.delete(id);
        return new Result(delete ? Code.DELETE_OK : Code.DELETE_ERR, delete);
    }

    @PutMapping
    public Result update(@RequestBody Book book) {
        Boolean update = bookService.update(book);
        return new Result(update ? Code.UPDATE_OK : Code.UPDATE_ERR, update);
    }

    @GetMapping("/{id}")
    public Result selectById(@PathVariable Integer id) {
        Book book = bookService.selectById(id);
        Integer code = book != null ? Code.SELECT_OK : Code.SELECT_ERR;
        String msg = book != null ? "" : "查询失败，未找到";
        System.out.println("selectById...");
        return new Result(code, book, msg);
    }

    @GetMapping
    public Result selectAll() {
        List<Book> bookList = bookService.selectAll();
        Integer code = bookList != null ? Code.SELECT_OK : Code.SELECT_ERR;
        String msg = bookList != null ? "" : "查询失败，未找到";
        System.out.println("selectAll...");
        return new Result(code, bookList, msg);
    }
}
