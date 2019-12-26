package com.seed.mybatis.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.seed.mybatis.config.MybatisPlusConfig;
import com.seed.mybatis.entity.StuOperationLog;
import com.seed.mybatis.entity.StuPassport;
import com.seed.mybatis.mapper.db1.StuOperationLogMapper;
import com.seed.mybatis.service.IStuOperationLogService;
import com.seed.mybatis.service.IStuPassportService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Map;

@Slf4j
@SpringBootTest(classes = MybatisPlusConfig.class)
class StuInfoServiceImplTest {

    @Resource
    private IStuPassportService stuPassportService;
    @Resource
    private IStuOperationLogService stuOperationLogService;
    @Resource
    private StuOperationLogMapper stuOperationLogMapper;
    public static final ObjectMapper objectMapper = new ObjectMapper();

    //简单查询
    @Test
    public void select() throws JsonProcessingException {
        StuPassport stuPassport = stuPassportService.getById(1L);
        log.debug(objectMapper.writeValueAsString(stuPassport));
    }

    //自定义条件查询
    @Test
    public void selectByWrapper() throws JsonProcessingException {
        LambdaQueryWrapper<StuPassport> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(StuPassport::getIdcard,"440923199302282186");
        StuPassport stuPassport = stuPassportService.getOne(queryWrapper);
        log.debug(objectMapper.writeValueAsString(stuPassport));
    }

    //分页
    @Test
    public void page() throws JsonProcessingException {
        IPage<StuOperationLog> page = new Page<>();
        page.setCurrent(1);
        page.setSize(10);
        IPage<StuOperationLog> stuOperationLogIPage = stuOperationLogService.page(page);
        log.debug(objectMapper.writeValueAsString(stuOperationLogIPage));
    }

    //自定义provider
    @Test
    public void joinByProvider() throws JsonProcessingException {
        IPage<Map> page = new Page<>();
        page.setCurrent(1);
        page.setSize(1);
        StuPassport stuPassport = new StuPassport();
        stuPassport.setId(1L);
        IPage<Map> mapIPage = stuOperationLogMapper.selectOperationPageByProvider(page, stuPassport);
        log.debug(objectMapper.writeValueAsString(mapIPage));
    }

    //自定义xml
    @Test
    public void joinByXml() throws JsonProcessingException {
        IPage<Map> page = new Page<>();
        page.setCurrent(1);
        page.setSize(1);
        StuPassport stuPassport = new StuPassport();
        stuPassport.setId(1L);
        IPage<Map> mapIPage = stuOperationLogMapper.selectOperationPageByXML(page, stuPassport);
        log.debug(objectMapper.writeValueAsString(mapIPage));
    }

    //事务处理
    @Test
    public void transactionalTest(){
        stuOperationLogService.transUpdate("王三小",1L);
    }
}