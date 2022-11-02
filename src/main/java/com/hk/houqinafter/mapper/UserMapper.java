package com.hk.houqinafter.mapper;

import com.hk.houqinafter.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
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
public interface UserMapper extends BaseMapper<User> {
    @Select("SELECT U_NAME FROM USER WHERE U_ID = #{uId}")
    String getUname(@Param("uId")Integer uId);

    @Select("SELECT U_ID , U_NAME FROM USER")
    List<User> getAllUname();
}
