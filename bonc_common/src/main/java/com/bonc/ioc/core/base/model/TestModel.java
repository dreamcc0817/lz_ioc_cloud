package com.bonc.ioc.core.base.model;/**
 * Created by wo on 2018-09-28.
 */

/**
 * TestModel模块
 *
 * @version 1.0
 * @Author chenxiaoyang
 * @Date 2018-09-28 16:33
 */
public class TestModel {

    private String id;
    private String parentId;
    private String dictCode;
    private String dictName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getDictCode() {
        return dictCode;
    }

    public void setDictCode(String dictCode) {
        this.dictCode = dictCode;
    }

    public String getDictName() {
        return dictName;
    }

    public void setDictName(String dictName) {
        this.dictName = dictName;
    }
}
