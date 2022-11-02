package com.hk.houqinafter.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hk.houqinafter.entity.Support;
import com.hk.houqinafter.entity.User;
import com.hk.houqinafter.mapper.SupportMapper;
import com.hk.houqinafter.service.SupportService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author echo
 * @since 2022-04-18
 */
@Service
public class SupportServiceImpl extends ServiceImpl<SupportMapper, Support> implements SupportService {
}
