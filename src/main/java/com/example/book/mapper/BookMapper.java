package com.example.book.mapper;

import com.example.book.model.BookInfo;
import com.example.book.model.PageRequest;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BookMapper {
    @Insert("insert into book_info (book_name,author,count,price,publish,status) " +
            "values (#{bookName},#{author},#{count},#{price},#{publish},#{status})")
    Integer addBook(BookInfo bookInfo);

    @Select("SELECT * FROM book_info WHERE `status`!=0 LIMIT #{offset},#{pageSize}")
    List<BookInfo> selectBookByPage(PageRequest pageRequest);
    @Select("select count(1) from book_info where `status`!=0")
    Integer count();
}
