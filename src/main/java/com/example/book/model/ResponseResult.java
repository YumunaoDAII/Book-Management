package com.example.book.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseResult<T> {
    private Integer total;
    private List<T> records;
    private PageRequest pageRequest;


}
