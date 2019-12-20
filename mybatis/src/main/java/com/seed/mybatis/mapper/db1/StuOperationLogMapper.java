package com.seed.mybatis.mapper.db1;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.seed.mybatis.entity.StuOperationLog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.seed.mybatis.entity.StuPassport;
import com.seed.mybatis.provider.StuOperationLogProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.Map;

/**
 * <p>
 * 操作日志表 Mapper 接口
 * </p>
 *
 * @author LianSong
 * @since 2019-12-20
 */
public interface StuOperationLogMapper extends BaseMapper<StuOperationLog> {

    @SelectProvider(value = StuOperationLogProvider.class, method = "selectOperationPageByProvider")
    IPage<Map> selectOperationPageByProvider(IPage<Map> page, @Param("dto") StuPassport stuPassport);

    IPage<Map> selectOperationPageByXML(IPage<Map> page, @Param("dto") StuPassport stuPassport);
}
