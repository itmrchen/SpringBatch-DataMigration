package com.javazx.batch.dao;

import com.javazx.batch.po.UserTo;

import java.util.List;

/**
 *
 * @author itmrchen
 * @date 2016/10/12
 * @time 13:19
 */
public interface UserToMapper {
    /**
     * spring batch 批量插入
     * @param list
     * @return
     */
    int batchInsert(List<UserTo> list);
}
