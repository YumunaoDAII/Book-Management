package com.example.book.service;

import com.example.book.dao.BookDao;
import com.example.book.enums.BookStatusEnum;
import com.example.book.mapper.BookMapper;
import com.example.book.model.BookInfo;
import com.example.book.model.PageRequest;
import com.example.book.model.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookService {
    @Autowired
    private BookDao bookDao;
    @Autowired
    private BookMapper bookMapper;
    public List<BookInfo> getList(){

        List<BookInfo> bookInfos=bookDao.mockData();
        for (BookInfo bookInfo : bookInfos) {
            if (bookInfo.getStatus()==1){
                bookInfo.setStatusCN("可借阅");
            }else {
                bookInfo.setStatusCN("不可借阅");
            }
        }
        return bookInfos;
    }

    public void addBook(BookInfo bookInfo) {
        bookMapper.addBook(bookInfo);
    }

    public ResponseResult<BookInfo> getListByPage(PageRequest pageRequest){
        //获得总图书数
        //获得当前页的数据
        Integer count=bookMapper.count();
        List<BookInfo> bookInfos = bookMapper.selectBookByPage(pageRequest);
        for (BookInfo bookInfo : bookInfos) {
            bookInfo.setStatusCN(BookStatusEnum.getStatusByCode(bookInfo.getStatus()).getDesc());
        }

        return new ResponseResult<>(count,bookInfos,pageRequest);
    }

    public BookInfo queryBookById(Integer bookId) {
        return bookMapper.queryBookById(bookId);
    }

    public void updateBook(BookInfo bookInfo) {
        bookMapper.updateBook(bookInfo);
    }

    public Integer batchDelete(List<Integer> ids){
        return bookMapper.batchDelete(ids);
    }
}
