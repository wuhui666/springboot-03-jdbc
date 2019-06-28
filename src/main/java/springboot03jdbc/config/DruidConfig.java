package springboot03jdbc.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewFilter;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: wuhui
 * @time: 2019/6/24 22:26
 * @desc:
 */
@Configuration
public class DruidConfig {
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource config(){

        return new DruidDataSource();
    }

    /*监控servlet*/
    @Bean
    public ServletRegistrationBean statViewServlet (){
        ServletRegistrationBean registrationBean=
                new ServletRegistrationBean(
                        new StatViewServlet(),"/druid/*");
        HashMap<Object, Object> map = new HashMap<>();
        map.put("loginUsername", "root");
        map.put("loginPassword", "admin");
        //map.put("allow", "127.0.0.1");允许所有
        map.put("deny", "192.3.1.102");//黑名单
        registrationBean.setInitParameters(map);
        return registrationBean;
    }
    /*监控filter*/
    @Bean
    public FilterRegistrationBean filter(){
        FilterRegistrationBean filterRegistrationBean=
                new FilterRegistrationBean(new WebStatFilter());
        filterRegistrationBean.addUrlPatterns("/druid/*");
        HashMap<Object, Object> initParams = new HashMap<>();

        initParams.put("exclusions", "*.js,*css,/druid/*");

        filterRegistrationBean.setInitParameters(initParams);
        return filterRegistrationBean;
    }
}
