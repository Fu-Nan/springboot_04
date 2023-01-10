package com.fn.dao;

import com.fn.domain.Book;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface BookDao {
    int save(Book book);

    int delete(Integer id);

    int update(Book book);

    Book selectById(Integer id);

    List<Book> selectAll();
}
