package com.seed.mybatis.config;

import com.atomikos.jdbc.AtomikosDataSourceBean;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @Author LianSong
 * @Date 2019/12/20 11:19
 */
@Configuration
@MapperScan(basePackages = "com.seed.mybatis.mapper.db2", sqlSessionTemplateRef = "jtaDb2SqlSessionTemplate")
public class Db2DataSourceJTAConfig {
    @Bean
    @ConfigurationProperties(prefix = "spring.jta.atomikos.datasource.db2")
    public DataSource jtaDb2DataSource() {
        return new AtomikosDataSourceBean();
    }

    @Bean
    public SqlSessionFactory jtaDb2SessionFactory(@Qualifier("jtaDb2DataSource") DataSource dataSource) throws Exception {
        MybatisSqlSessionFactoryBean bean = new MybatisSqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));
        bean.setTypeAliasesPackage("com.seed.mybatis.mapper.db2");
        return bean.getObject();
    }

    @Bean
    public SqlSessionTemplate jtaDb2SqlSessionTemplate(@Qualifier("jtaDb2SessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    /*@Bean(name="db2TransactionManager")
    public DataSourceTransactionManager transactionManager(@Qualifier("jtaDb2DataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }*/
}
