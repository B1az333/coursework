package kpi.zabelskyi.csdb.blaze.corp.controller;

//import org.kpi.mmsa.demo.service.UserService;
import kpi.zabelskyi.csdb.blaze.corp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
    private final UserService userService;
    @Autowired
    public TestController(UserService userService){
        this.userService=userService;
    }

    @GetMapping("/user_list")
    @ResponseBody
    String getHelloMmsa(){
        return userService.userList().toString();
    }
}
