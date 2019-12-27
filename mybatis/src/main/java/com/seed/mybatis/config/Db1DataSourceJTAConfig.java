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
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * @Author LianSong
 * @Date 2019/12/20 11:19
 */
@Configuration
@MapperScan(basePackages = "com.seed.mybatis.mapper.db1", sqlSessionTemplateRef = "jtaDb1SqlSessionTemplate")
public class Db1DataSourceJTAConfig {

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.jta.atomikos.datasource.db1")
    public DataSource jtaDb1DataSource() {
        return new AtomikosDataSourceBean();
    }

    @Bean
    @Primary
    public SqlSessionFactory jtaDb1SessionFactory(@Qualifier("jtaDb1DataSource") DataSource dataSource) throws Exception {
        MybatisSqlSessionFactoryBean bean = new MybatisSqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));
        bean.setTypeAliasesPackage("com.seed.mybatis.mapper.db1");
        return bean.getObject();
    }

    @Bean
    @Primary
    public SqlSessionTemplate jtaDb1SqlSessionTemplate(@Qualifier("jtaDb1SessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    /*@Bean(name="db1TransactionManager")
    @Primary
    public DataSourceTransactionManager transactionManager(@Qualifier("jtaDb1DataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }*/

}
