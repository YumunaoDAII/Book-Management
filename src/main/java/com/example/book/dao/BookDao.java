package com.example.book.dao;

import com.example.book.model.BookInfo;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
@Component
public class BookDao {

    /**
     * mock从数据库查询数据
     * @return
     */
    public List<BookInfo> mockData(){
        List<BookInfo> bookInfos=new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            BookInfo bookInfo = new BookInfo();
            bookInfo.setId(i);
            bookInfo.setBookName("图书"+i);
            bookInfo.setAuthor("作者"+i);
            bookInfo.setPublish("出版社"+i);
            bookInfo.setCount(new Random().nextInt(100));
            bookInfo.setPrice(new BigDecimal(new Random().nextInt(100)));
            bookInfo.setStatus(i%5==0?2:1);
            bookInfos.add(bookInfo);
        }
        return bookInfos;
    }

}
