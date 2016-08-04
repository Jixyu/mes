package com.tiza.mbp.utils.data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by XieChen on 2016/7/28.
 */
public abstract class BaseEntity implements Serializable {
    private long id;
    private Date createTime;
    //逻辑删除位：0未删除，1删除
    private int isDeleted;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int deleted) {
        isDeleted = deleted;
    }
}
