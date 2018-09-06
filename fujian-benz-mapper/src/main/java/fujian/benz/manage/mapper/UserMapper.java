package fujian.benz.manage.mapper;

import fujian.benz.manage.pojo.User;
import org.apache.ibatis.annotations.Param;

/**
 * Created by john on 2018/8/31.
 */
public interface UserMapper {

    //根据用户名与密码查询用户
    User queryByIdAndPwd(@Param("userId") String userId,@Param("userPwd")String userPwd);

}
