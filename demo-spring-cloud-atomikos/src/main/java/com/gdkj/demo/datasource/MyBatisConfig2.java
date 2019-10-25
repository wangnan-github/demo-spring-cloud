package com.gdkj.demo.datasource;

import com.atomikos.jdbc.AtomikosDataSourceBean;
import com.gdkj.demo.config.DBConfig1;
import com.gdkj.demo.config.DBConfig2;
import com.mysql.cj.jdbc.MysqlXADataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
//主要是利用扫包 basePackages 最好分开配置 如果放在同一个文件夹可能会报错
@MapperScan(basePackages = "com.gdkj.demo.test2", sqlSessionTemplateRef = "test2SqlSessionTemplate")
public class MyBatisConfig2 {

    //test1 sql会话工厂
    @Bean(name = "test2SqlSessionFactory")
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("test2DataSource") DataSource dataSource)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        return bean.getObject();
    }


    @Bean(name = "test2SqlSessionTemplate")
    public SqlSessionTemplate testSqlSessionTemplate(
            @Qualifier("test2SqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }


    // 配置数据源
    @Bean(name = "test2DataSource")
    public DataSource testDataSource(DBConfig2 dbconfig) throws SQLException {
        MysqlXADataSource mysqlXaDataSource = new MysqlXADataSource();
        mysqlXaDataSource.setUrl(dbconfig.getUrl());
        mysqlXaDataSource.setPinGlobalTxToPhysicalConnection(true);
        mysqlXaDataSource.setPassword(dbconfig.getPassword());
        mysqlXaDataSource.setUser(dbconfig.getUsername());
        mysqlXaDataSource.setPinGlobalTxToPhysicalConnection(true);

        // 将本地事务注册到创 Atomikos全局事务
        AtomikosDataSourceBean xaDataSource = new AtomikosDataSourceBean();
        xaDataSource.setXaDataSource(mysqlXaDataSource);
        xaDataSource.setUniqueResourceName("test2DataSource");

        xaDataSource.setMinPoolSize(dbconfig.getMinPoolSize());
        xaDataSource.setMaxPoolSize(dbconfig.getMaxPoolSize());
        xaDataSource.setMaxLifetime(dbconfig.getMaxLifetime());
        xaDataSource.setBorrowConnectionTimeout(dbconfig.getBorrowConnectionTimeout());
        xaDataSource.setLoginTimeout(dbconfig.getLoginTimeout());
        xaDataSource.setMaintenanceInterval(dbconfig.getMaintenanceInterval());
        xaDataSource.setMaxIdleTime(dbconfig.getMaxIdleTime());
        xaDataSource.setTestQuery(dbconfig.getTestQuery());
        return xaDataSource;
    }

}
