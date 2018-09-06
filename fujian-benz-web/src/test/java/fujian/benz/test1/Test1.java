package fujian.benz.test1;


import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.pagehelper.PageInfo;

import fujian.benz.manage.Application;
import fujian.benz.manage.pojo.Role;
import fujian.benz.manage.service.RoleService;

/**
 * Created by john on 2018/8/23.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes=Application.class)
public class Test1 {

    @Autowired
    private RoleService roleService;

    @Test
    public void test333(){
        Role role =new Role();
        role.setName("管理员1");
        role.setCreateTime(new Date());
        role.setCode("admin1");


        roleService.save(role);
        System.out.println(role.getId());

    }

    @Test
    public void update(){

        Role role =new Role();
        role.setId("B3E1C72926B349A3AA29D24623C4C829");
        role.setCode("admin5");
        role.setName("管理员6");


        roleService.update(role);
    }

    @Test
    public void select(){

        List<Role> roles=roleService.queryAll();

        for (Role role : roles) {
            System.out.println(role);
        }
    }

    @Test
    public void fenye(){


        Role role=new Role();

        PageInfo<Role>ttt=roleService.queryPageByWhere(role,1,10);

        System.out.println("总页数为"+ttt.getPages());

    }


    @Test
    public void delete(){

        roleService.deleteById("B3E1C72926B349A3AA29D24623C4C829");
    }
}
