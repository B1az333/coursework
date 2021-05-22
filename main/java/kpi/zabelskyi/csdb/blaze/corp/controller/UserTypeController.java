package kpi.zabelskyi.csdb.blaze.corp.controller;


import kpi.zabelskyi.csdb.blaze.corp.model.Client;
import kpi.zabelskyi.csdb.blaze.corp.model.UserType;
import kpi.zabelskyi.csdb.blaze.corp.service.UserTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import javax.ws.rs.core.MediaType;
import java.util.List;

@Controller
@RequestMapping("/userType")
public class UserTypeController {
    private  final  UserTypeService userTypeService;
    @Autowired
    public UserTypeController(UserTypeService userTypeService) {this.userTypeService=userTypeService;}

    @GetMapping
    @ResponseBody
    List<UserType> getUserTypeList() { return userTypeService.userTypeList(); }


    @GetMapping("/{sid}")
    @ResponseBody
    UserType getUserType(@RequestBody @PathVariable long sid){
        return userTypeService.getUserType(sid);
    }

    @PostMapping(value = "/save", produces = {MediaType.APPLICATION_JSON} )
    @ResponseBody
    UserType saveUserType(@RequestBody UserType newUserType ){
        return userTypeService.saveUserType(newUserType);
    }

    @DeleteMapping(value = "/delete", produces = {MediaType.APPLICATION_JSON} )
    @ResponseBody
    String deleteUserType(@RequestBody UserType delUserType  ){
        userTypeService.deleteUserType(delUserType);
        return "deleted";
    }

    @DeleteMapping(value = "/delete/{sid}", produces = {MediaType.APPLICATION_JSON} )
    @ResponseBody
    String deleteUserType(@RequestBody @PathVariable long sid  ){
        userTypeService.deleteUserType(sid);
        return "deleted";
    }
}