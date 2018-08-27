package fujian.benz.manage.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import fujian.benz.manage.pojo.Role;
import fujian.benz.manage.service.RoleService;

@RequestMapping("/hello")
@Controller
public class HelloController {
	
	@Autowired
	private RoleService roleService;
	
	@RequestMapping("/test1")
	public ModelAndView test1(){
    
		ModelAndView mv=new ModelAndView("a");
        
		mv.addObject("hello","哈哈哈");
		return mv;
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public String update(){
		
		   Role role =new Role();
		  role.setId("B3E1C72926B349A3AA29D24623C4C829");
	      role.setCode("admin5");
	      role.setName("管理员6"); 
	try{
	   roleService.update(role);
	   
	   System.out.println(role);	
	   
	} catch(Exception e){
		e.printStackTrace();
	}     
	      return "哈哈哈悟饭";
	} 
	
	
	@RequestMapping("/select")
	@ResponseBody
	public String select(){
		 
	try{
	   Role role= roleService.queryById("B3E1C72926B349A3AA29D24623C4C829");
	   
	   System.out.println(role);	
	   
	} catch(Exception e){
		e.printStackTrace();
	}     
		  
		  
	      return "哈哈哈悟饭";
	} 
}
