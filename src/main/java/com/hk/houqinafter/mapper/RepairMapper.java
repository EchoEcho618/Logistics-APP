package com.hk.houqinafter.mapper;

import com.hk.houqinafter.entity.Repair;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author echo
 * @since 2022-04-18
 */
@Repository
public interface RepairMapper extends BaseMapper<Repair> {
    @Select("SELECT AVG(STAR) FROM REPAIR WHERE S_ID = #{sId}")
    Double getAvgStar(@Param("sId")Integer sId);
}
