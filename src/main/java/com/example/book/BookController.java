package com.example.book;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RequestMapping("/book")
@RestController
public class BookController {
    @RequestMapping("/getList")
    public List<BookInfo> getList(){
        List<BookInfo> bookInfos=mockData();
        for (BookInfo bookInfo : bookInfos) {
            if (bookInfo.getStatus()==1){
                bookInfo.setStatusCN("可借阅");
            }else {
                bookInfo.setStatusCN("不可借阅");
            }
        }
        return bookInfos;
    }

    /**
     * mock从数据库查询数据
     * @return
     */
    public List<BookInfo> mockData(){
        List<BookInfo> bookInfos=new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            BookInfo bookInfo = new BookInfo();
            bookInfo.setBookId(i);
            bookInfo.setBookName("图书"+i);
            bookInfo.setAuthor("作者"+i);
            bookInfo.setPublish("出版社"+i);
            bookInfo.setNum(new Random().nextInt(100));
            bookInfo.setPrice(new BigDecimal(new Random().nextInt(100)));
            bookInfo.setStatus(i%5==0?2:1);
            bookInfos.add(bookInfo);
        }
        return bookInfos;
    }

}
