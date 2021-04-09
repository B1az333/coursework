package kpi.zabelskyi.csdb.blaze.corp.controller;

import kpi.zabelskyi.csdb.blaze.corp.model.User;
import kpi.zabelskyi.csdb.blaze.corp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.MediaType;
import java.util.List;


@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @ResponseBody
    List<User> getUserList(){return userService.userList();}

    @GetMapping("/{uid}")
    @ResponseBody
    User getUser(@RequestBody @PathVariable long uid){
        return userService.getUser(uid);
    }
    @PostMapping(value = "/save", produces = {MediaType.APPLICATION_JSON})
    @ResponseBody
    User saveUser(@RequestBody User newUser) {
        return userService.saveUser(newUser);
    }
    @DeleteMapping(value = "/delete/{uid}", produces = {MediaType.APPLICATION_JSON})
    @ResponseBody
    String deleteUser(@RequestBody @PathVariable long uid){
        return userService.deleteUser(uid);
    }

}