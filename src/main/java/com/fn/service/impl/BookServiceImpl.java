package com.fn.service.impl;

import com.fn.controller.Code;
import com.fn.dao.BookDao;
import com.fn.domain.Book;
import com.fn.exception.BusinessException;
import com.fn.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;

    @Override
    public Boolean save(Book book) {
        return bookDao.save(book) > 0;
    }

    @Override
    public Boolean delete(Integer id) {
        return bookDao.delete(id) > 0;
    }

    @Override
    public Boolean update(Book book) {
        return bookDao.update(book) > 0;
    }

    @Override
    public Book selectById(Integer id) {
        //模拟一个业务异常
        if (id < 0) {
            throw new BusinessException(Code.PROJECT_BUSINESS_ERR, "非法输入！请重试");
        }
//        //模拟一个系统异常
//        try {
//            int i = 1 / 0;
//        } catch (Exception se) {
//            throw new SystemException(Code.SYSTEM_TIMEOUT_ERR, "服务器访问超时，请重试");
//        }
        Book book = bookDao.selectById(id);
        return book;
    }

    @Override
    public List<Book> selectAll() {
        List<Book> bookList = bookDao.selectAll();
        return bookList;
    }
}
