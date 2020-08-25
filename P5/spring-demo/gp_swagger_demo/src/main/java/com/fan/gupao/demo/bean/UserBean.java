package com.fan.gupao.demo.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author 樊高风
 * @date 2020/8/25
 */
@ApiModel(value = "用户Bean")
public class UserBean {


    @ApiModelProperty("编号")
    private Integer id;

    @ApiModelProperty("帐号")
    private String userName;

    @ApiModelProperty("密码")
    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
