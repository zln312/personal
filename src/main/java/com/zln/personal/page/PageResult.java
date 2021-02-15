package com.zln.personal.page;

import lombok.Data;

import java.util.List;

/*
分页返回结果
 */
@Data
public class PageResult {
    // 当前页码
    private int pageNum;

    //每页数量
    private int pageSize;

    //记录总数
    private long totalSize;

    //页面总数
    private int totalPages;

    //数据模型
    private List<?> content;
}
