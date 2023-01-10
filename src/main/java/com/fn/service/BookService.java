package com.fn.service;

import com.fn.domain.Book;

import java.util.List;

public interface BookService {
    /**
     * 保存
     *
     * @param book
     * @return
     */
    Boolean save(Book book);

    /**
     * 根据id删除
     *
     * @param id
     * @return
     */
    Boolean delete(Integer id);

    /**
     * 更新
     *
     * @param book
     * @return
     */
    Boolean update(Book book);

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    Book selectById(Integer id);

    /**
     * 查询全部
     *
     * @return
     */
    List<Book> selectAll();
}
