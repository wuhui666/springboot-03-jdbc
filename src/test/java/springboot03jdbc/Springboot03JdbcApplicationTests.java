package springboot03jdbc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import springboot03jdbc.mappers.UserMapper;

import javax.sql.DataSource;
import java.sql.SQLException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot03JdbcApplicationTests {
    @Autowired
    DataSource dataSource;
    @Autowired
    UserMapper userMapper;
    @Test
    public void contextLoads() throws SQLException {
        System.out.println(dataSource);
        System.out.println(dataSource.getConnection());
    }
    @Test
    public void test1(){
        System.out.println(userMapper.selectByPrimaryKey(31));
    }

}
