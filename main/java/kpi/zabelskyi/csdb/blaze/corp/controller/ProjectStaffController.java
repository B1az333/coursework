package kpi.zabelskyi.csdb.blaze.corp.controller;


import kpi.zabelskyi.csdb.blaze.corp.model.ProjectStaff;
import kpi.zabelskyi.csdb.blaze.corp.service.ProjectStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import javax.ws.rs.core.MediaType;
import java.util.List;

@Controller
@RequestMapping("/projectStaffs")
public class ProjectStaffController {
    private  final  ProjectStaffService projectStaffService;
    @Autowired
    public ProjectStaffController(ProjectStaffService projectStaffService) {this.projectStaffService=projectStaffService;}

    @GetMapping
    @ResponseBody
    List<ProjectStaff> getProjectStaffList() { return projectStaffService.projectStaffList(); }


    @GetMapping("/{sid}")
    @ResponseBody
    ProjectStaff getProjectStaff(@RequestBody @PathVariable long sid){
        return projectStaffService.getProjectStaff(sid);
    }

    @PostMapping(value = "/save", produces = {MediaType.APPLICATION_JSON} )
    @ResponseBody
    ProjectStaff saveProjectStaff(@RequestBody ProjectStaff newProjectStaff ){
        return projectStaffService.saveProjectStaff(newProjectStaff);
    }

    @DeleteMapping(value = "/delete", produces = {MediaType.APPLICATION_JSON} )
    @ResponseBody
    String deleteProjectStaff(@RequestBody ProjectStaff delProjectStaff  ){
        projectStaffService.deleteProjectStaff(delProjectStaff);
        return "deleted";
    }

    @DeleteMapping(value = "/delete/{sid}", produces = {MediaType.APPLICATION_JSON} )
    @ResponseBody
    String deleteProjectStaff(@RequestBody @PathVariable long sid  ){
        projectStaffService.deleteProjectStaff(sid);
        return "deleted";
    }


}
