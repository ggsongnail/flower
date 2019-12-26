package com.seed.mybatis.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.seed.mybatis.entity.StuInfo;
import com.seed.mybatis.entity.StuOperationLog;
import com.seed.mybatis.entity.StuPassport;
import com.seed.mybatis.mapper.db1.StuOperationLogMapper;
import com.seed.mybatis.service.IStuInfoService;
import com.seed.mybatis.service.IStuOperationLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.seed.mybatis.service.IStuPassportService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 操作日志表 服务实现类
 * </p>
 *
 * @author LianSong
 * @since 2019-12-20
 */
@Service
public class StuOperationLogServiceImpl extends ServiceImpl<StuOperationLogMapper, StuOperationLog> implements IStuOperationLogService {

    @Resource
    private IStuInfoService stuInfoService;
    @Resource
    private IStuPassportService stuPassportService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    //@Transactional(transactionManager = "transactionManager", rollbackFor = Exception.class)
    public void transUpdate(String name, long uid) {

        StuPassport stuPassport = stuPassportService.getById(1L);
        stuPassport.setName(name);
        stuPassportService.saveOrUpdate(stuPassport);
        List<StuOperationLog> stuOperationLogs = list(new LambdaQueryWrapper<StuOperationLog>()
                .eq(StuOperationLog::getUid, 1L));
        stuOperationLogs.forEach(v -> v.setUserName(name));
        saveOrUpdateBatch(stuOperationLogs, 100);

        StuInfo stuInfo = stuInfoService.getById(1200303224419049474L);
        stuInfo.setName(name);
        stuInfoService.saveOrUpdate(stuInfo);

        int i = 1/0;
    }
}
