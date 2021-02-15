package com.zln.personal.page;

import lombok.Data;

/**
 * 分页请求
 */
@Data
public class PageRequest {
    //当前页码
    private  int pageNum;

    //每页的数量
    private int pageSize;
}
