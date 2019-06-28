package springboot03jdbc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springboot03jdbc.mappers.UserMapper;
import springboot03jdbc.pojo.User;

import java.util.List;

/**
 * @author: wuhui
 * @time: 2019/6/25 11:11
 * @desc:
 */
@RestController
public class JdbcController {
    @Autowired
    UserMapper mapper;

    @GetMapping("/user")
    public List<User> getAll(){
        return mapper.selectByExample(null);
    }
}
