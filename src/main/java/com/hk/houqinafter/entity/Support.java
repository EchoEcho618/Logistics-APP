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
public class Support extends Model<Support> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "s_id", type = IdType.AUTO)
    private Integer sId;

    @NotBlank(message = "姓名不能为空！")
    @Pattern(regexp = ".{0,20}",message = "姓名最长20位字符！")
    private String sName;

    @NotBlank(message = "密码不能为空！")
    @Pattern(regexp = ".{0,20}",message = "密码最长20位字符！")
    private String sPassword;

    /**
     * 后勤人员性别0:male,1:female
     */
    @NotNull(message = "性别不能为空！")
    private Integer sSex;

    @NotBlank(message = "电话不能为空！")
    @Pattern(regexp = "\\d{0,11}" , message = "电话格式不对！")
    private String sTel;


    @Override
    protected Serializable pkVal() {
        return this.sId;
    }

}
