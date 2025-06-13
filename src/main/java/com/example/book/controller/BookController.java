package com.example.book.controller;

import com.example.book.constant.Constants;
import com.example.book.enums.BookStatusEnum;
import com.example.book.model.*;
import com.example.book.service.BookService;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequestMapping("/book")
@RestController
public class BookController {

    @Autowired
    private BookService bookService;
    @RequestMapping("/getList")
    public List<BookInfo> getList(){
        return bookService.getList();
    }

    @RequestMapping(value = "/addBook",produces = "application/json")
    public String addBook(BookInfo bookInfo){
        //1参数校验
        //2存储数据
        //3返回结果
        if (!StringUtils.hasLength(bookInfo.getBookName())
                ||!StringUtils.hasLength(bookInfo.getAuthor())
                ||bookInfo.getCount()==null
                ||bookInfo.getPrice()==null
                ||!StringUtils.hasLength(bookInfo.getPublish())
                ||bookInfo.getStatus()==null){
            // 记录参数不合法的情况
            log.warn("参数不合法 - 书名: {}, 作者: {}, 数量: {}, 价格: {}, 出版社: {}, 状态: {}",
                    bookInfo.getBookName(),
                    bookInfo.getAuthor(),
                    bookInfo.getCount(),
                    bookInfo.getPrice(),
                    bookInfo.getPublish(),
                    bookInfo.getStatus());
            return "参数不合法";
        }
        try {
            bookService.addBook(bookInfo);
            return "";
        }catch (Exception e){
            log.error("添加图书发生异常,   e: "+e);
            return "添加图书发生异常";
        }

    }
    @RequestMapping("/getListByPage")
    public Result getListByPage(PageRequest pageRequest, HttpSession session){
        //参数校验
        //返回数据
        ResponseResult<BookInfo> listPage=bookService.getListByPage(pageRequest);
        return Result.success(listPage);

    }
    @RequestMapping("/queryBookId")
    public BookInfo queryBookById(Integer bookId){

        log.info("查询图书信息， bookId: "+bookId);
        return bookService.queryBookById(bookId);
    }
    @RequestMapping(value = "/updateBook")
    public Result updateBook(BookInfo bookInfo){
        log.info("修改图书信息， bookInfo: "+bookInfo);
        try {
            bookService.updateBook(bookInfo);
            return Result.success("");
        }catch (Exception e){
            log.error("修改图书发生异常, e"+e);
            return Result.fail("修改图书发生异常");
        }
    }
    @RequestMapping(value = "/deleteBook")
    public Result deleteBook(Integer bookId){
        log.info("删除图书信息， bookInfo: "+bookId);
        try {
            BookInfo bookInfo=new BookInfo();
            bookInfo.setId(bookId);
            bookInfo.setStatus(BookStatusEnum.DELETED.getCode());
            bookService.updateBook(bookInfo);
            return Result.success("");
        }catch (Exception e){
            log.error("删除图书发生异常, e"+e);
            return Result.fail("删除图书发生异常");
        }
    }
    @RequestMapping("/batchDelete")
    public  Boolean batchDelete(@RequestParam List<Integer> ids){
        log.info("批量删除图书    ，ids:  ",ids);
        try {
            bookService.batchDelete(ids);
            return true;
        }catch (Exception e){
            log.error("批量删除图书失败， e",e);
            return false;
        }
    }

}
