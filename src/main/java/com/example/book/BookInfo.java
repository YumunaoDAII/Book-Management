package com.example.book;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class BookInfo {
    private Integer bookId;
    private String bookName;
    private String author;
    private Integer num;
    private BigDecimal price;
    private String publish;
    private Integer status;
    private String statusCN;
}
