package com.clear2pay.entity.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class User implements Serializable {
    private static final long serialVersionUID = 20210713224900001L;

    private Integer id;  //ID

    @NotEmpty(message = "密码必填!")
    @Length(min = 6, max = 20, message = "密码长度为6~20位")
    @JsonIgnore
    private String password;  //ID

    @NotNull(message = "姓名必填!")
    @Length(max = 20, message = "姓名过长!")
    private String name; //名字

    @Max(value = 130, message = "年龄不得超过130岁")
    @Min(value = 1, message = "年龄不得小于1岁")
    private Integer age; //年龄

    private BigDecimal weight; //体重

    @Past(message = "无效的出生日期!")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date birthday;  //生日

    @NotNull(message = "工牌必填!")
    @Pattern(regexp = "\\d{10}",message = "请输入10位数字工牌!")//长度10，0-9
    private String badgeCode;

    public User() {
    }

    public User(Integer id, String name, Integer age, BigDecimal weight, Date birthday) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.birthday = birthday;
    }

    public String getBadgeCode() {
        return badgeCode;
    }

    public void setBadgeCode(String badgeCode) {
        this.badgeCode = badgeCode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
