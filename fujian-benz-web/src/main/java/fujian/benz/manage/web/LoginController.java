package fujian.benz.manage.web;

import fujian.benz.manage.pojo.User;
import fujian.benz.manage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by john on 2018/8/31.
 */
@RestController
@RequestMapping("login")
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "login.sp", method = RequestMethod.POST)
    public User login(@RequestParam("userId") String userId,
                      @RequestParam("userPwd") String userPwd) {

        try {

           User user=userService.queryByIdAndPwd(userId,userPwd);

            return user;

        } catch (Exception e) {
            e.printStackTrace();
        }
            return null;
    }

}
