package fujian.benz.manage.service.impl;

import fujian.benz.manage.mapper.UserMapper;
import fujian.benz.manage.pojo.User;
import fujian.benz.manage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by john on 2018/8/31.
 */
@Service
public class UserServiceImpl implements UserService {

   @Autowired
   private UserMapper userMapper;

    //根据用户名与密码查询用户
    @Override
    public User queryByIdAndPwd(String userId,String userPwd) {

        return userMapper.queryByIdAndPwd(userId,userPwd);
    }
}
