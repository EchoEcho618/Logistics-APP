package com.hk.houqinafter.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author echo
 * @since 2022-04-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO,value = "u_id")
    private Integer uId;

    @NotBlank(message = "姓名不能为空！")
    @Pattern(regexp = ".{0,20}",message = "姓名最长20位字符！")
    private String uName;

    @NotBlank(message = "密码不能为空！")
    @Pattern(regexp = ".{0,20}",message = "密码最长20位字符！")
    private String uPassword;

    /**
     * 用户性别0:male,1:female
     */
    @NotNull(message = "性别不能为空！")
    private Integer uSex;

    @NotBlank(message = "电话不能为空！")
    @Pattern(regexp = "\\d{0,11}" , message = "电话格式应为11位纯数字！")
    private String uTel;

    /**
     * 用户类型0:teacher,1:student
     */
    @NotNull(message = "身份不能为空！")
    private Integer uType;

    /**
     * 是否毕业/离职0：否，1：是
     */
    @TableLogic
    private Integer isDelete;


    @Override
    protected Serializable pkVal() {
        return this.uId;
    }

}
