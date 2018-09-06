package fujian.benz.manage.service;

import fujian.benz.manage.pojo.User;

/**
 * Created by john on 2018/8/31.
 */
public interface UserService {

    //根据用户名与密码查询用户
    User queryByIdAndPwd(String userId,String userPwd);

}
