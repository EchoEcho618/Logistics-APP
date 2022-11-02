package com.hk.houqinafter.mapper;

import com.hk.houqinafter.entity.Support;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author echo
 * @since 2022-04-18
 */
@Repository
public interface SupportMapper extends BaseMapper<Support> {
    @Select("SELECT S_ID , S_NAME FROM SUPPORT")
    List<Support> getAllSname();
}
