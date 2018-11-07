package com.bonc.ioc.core.base.model;


import com.bonc.ioc.core.util.IdGenerator;

/**
 * @version 1.0
 * @Description : <p>实体父类</p>
 * @Author: chenxy
 * @Date: Created in 2017/10/27 0027.
 * @remarks
 * @updateBy
 * @updateDate
 */
public abstract class BaseEntity {

    private String id;//主键Id
    private String extend1;//扩展字段1
    private String extend2;//扩展字段2
    private String isValid;

    public void preInsert(){
        this.setId(IdGenerator.getId());
        this.setIsValid("1");
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getExtend1() {
        return extend1;
    }

    public void setExtend1(String extend1) {
        this.extend1 = extend1;
    }

    public String getExtend2() {
        return extend2;
    }

    public void setExtend2(String extend2) {
        this.extend2 = extend2;
    }

    public String getIsValid() {
        return isValid;
    }

    public void setIsValid(String isValid) {
        this.isValid = isValid;
    }

}
