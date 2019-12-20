package com.seed.mybatis.service;

import com.seed.mybatis.entity.StuOperationLog;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 操作日志表 服务类
 * </p>
 *
 * @author LianSong
 * @since 2019-12-20
 */
public interface IStuOperationLogService extends IService<StuOperationLog> {

    void transUpdate(String name, long uid);
}
