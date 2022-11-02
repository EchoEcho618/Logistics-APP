package com.hk.houqinafter.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
public class Repair extends Model<Repair> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "r_id", type = IdType.AUTO)
    private Integer rId;

    @NotNull(message = "报修人不能为空！")
    private Integer uId;

    @NotBlank(message = "报修地点不能为空！")
    private String rPlace;

    @NotBlank(message = "报修内容不能为空！")
    private String rContent;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime start;

    private Integer sId;

    private LocalDateTime end;

    private Integer star;

    private String evaluation;


    @Override
    protected Serializable pkVal() {
        return this.rId;
    }

}
