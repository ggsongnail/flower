package com.seed.mybatis;

import com.atomikos.jdbc.AtomikosDataSourceBean;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.seed.mybatis.config.MybatisPlusConfig;
import org.junit.jupiter.api.Test;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@EnableConfigurationProperties
@SpringBootTest(classes = MybatisPlusConfig.class)
class MysqlGeneratorTest {

    @Resource(name = "jtaDb2DataSource")
    private DataSource dataSource;

    //自3.3.0开始,默认使用雪花算法+UUID(不含中划线)
    @Test
    public void generate() {
        AtomikosDataSourceBean atomikosDataSourceBean = (AtomikosDataSourceBean) dataSource;
        String author = "LianSong";
        String projectPath = System.getProperty("user.dir");
        String packAge = "com.seed.mybatis";
        String javaCodeDir = projectPath + "/src/main/java/";
        String mapperXmlDir = projectPath + "/src/main/resources/mapper/";
        String[] tableName = new String[]{"stu_info"};
        String dbUrl = atomikosDataSourceBean.getXaProperties().getProperty("url");
        String moduleName = null;

        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(javaCodeDir);
        gc.setAuthor(author);
        gc.setOpen(false);
        gc.setFileOverride(true); //是否覆盖生成
        mpg.setGlobalConfig(gc);


        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(dbUrl);
        // dsc.setSchemaName("public");
        dsc.setDriverName(atomikosDataSourceBean.getXaDataSourceClassName());
        dsc.setUsername(atomikosDataSourceBean.getXaProperties().getProperty("user"));
        dsc.setPassword(atomikosDataSourceBean.getXaProperties().getProperty("password"));
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        if(StringUtils.isNotBlank(moduleName))
            pc.setModuleName(moduleName);
        pc.setParent(packAge);
        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
            }
        };
        List<FileOutConfig> focList = new ArrayList<>();
        focList.add(new FileOutConfig("/templates/mapper.xml.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return mapperXmlDir + Optional.ofNullable(moduleName).orElse("") + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);
        mpg.setTemplate(new TemplateConfig().setXml(null));

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        //strategy.setSuperEntityClass("com.seed.mybatis.BaseEntity");
        strategy.setEntityLombokModel(true);
        //strategy.setSuperControllerClass("com.seed.mybatis.BaseController");
        strategy.setInclude(tableName);
        //strategy.setSuperEntityColumns("id");
        strategy.setRestControllerStyle(true);
        strategy.setTablePrefix(pc.getModuleName() + "_");
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }

}