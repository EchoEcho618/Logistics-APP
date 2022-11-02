package com.hk.houqinafter.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

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
public class Admin extends Model<Admin> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "a_id", type = IdType.AUTO)
    private Integer aId;

    @NotBlank(message = "姓名不能为空！")
    @Pattern(regexp = ".{0,20}",message = "姓名最长20位字符！")
    private String aName;

    @NotBlank(message = "密码不能为空！")
    @Pattern(regexp = ".{0,20}",message = "密码最长20位字符！")
    private String aPassword;


    @Override
    protected Serializable pkVal() {
        return this.aId;
    }

}
