package com.seed.mybatis.service.impl;

import com.seed.mybatis.entity.StuInfo;
import com.seed.mybatis.mapper.db2.StuInfoMapper;
import com.seed.mybatis.service.IStuInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 学生信息表 服务实现类
 * </p>
 *
 * @author LianSong
 * @since 2019-12-20
 */
@Service
public class StuInfoServiceImpl extends ServiceImpl<StuInfoMapper, StuInfo> implements IStuInfoService {

}
