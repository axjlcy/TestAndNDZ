package com.wcy.hongkong.config;

import javax.sql.DataSource;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;

/**
 * druid 连接池配置类
 * Created by Fant.J.
 * 但是后来我找不到这个原作者的那篇文章，如果有人知道麻烦告诉我一声
 * by slience
 */
@Configuration
public class DruidConfiguration
{
    @Bean
    public ServletRegistrationBean statViewServlet()
    {
        //创建servlet注册实体
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        //设置ip白名单
        servletRegistrationBean.addInitParameter("allow", "127.0.0.1");
        //设置ip黑名单
        servletRegistrationBean.addInitParameter("deny", "192.168.0.2");
        //设置控制台管理用户__登录用户名和密码
        servletRegistrationBean.addInitParameter("loginUsername", "wcy");
        servletRegistrationBean.addInitParameter("loginPassword", "123");
        //是否可以重置数据
        servletRegistrationBean.addInitParameter("resetEnable", "false");
        return servletRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean statFilter()
    {
        //创建过滤器
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
        //设置过滤器过滤路径
        filterRegistrationBean.addUrlPatterns("/*");
        //忽略过滤的形式
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.png,*.css,*.ico,/druid/*");
        return filterRegistrationBean;
    }
}