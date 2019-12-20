package com.seed.mybatis.provider;

import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.seed.mybatis.entity.StuPassport;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

/**
 * @Author LianSong
 * @Date 2019/12/20 10:19
 */
public class StuOperationLogProvider {

    public String selectOperationPageByProvider(Map<String,Object> param){
        SQL sql = new SQL()
                .SELECT("s.`name`,s.idcard, sg.method, sg.operation")
                .FROM("stu_operation_log sg")
                .LEFT_OUTER_JOIN("stu_passport s ON s.id = sg.uid");
        if(ObjectUtils.isNotEmpty(param.get("dto"))){
            StuPassport stuPassport = (StuPassport) param.get("dto");
            if(ObjectUtils.isNotEmpty(stuPassport.getId())){
                sql.WHERE("s.id = #{dto.id}");
            }
        }
        return sql.toString();
    }
}
