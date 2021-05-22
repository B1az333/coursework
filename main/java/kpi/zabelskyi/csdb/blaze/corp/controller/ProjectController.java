package kpi.zabelskyi.csdb.blaze.corp.controller;


import kpi.zabelskyi.csdb.blaze.corp.model.Client;
import kpi.zabelskyi.csdb.blaze.corp.model.Project;
import kpi.zabelskyi.csdb.blaze.corp.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import javax.ws.rs.core.MediaType;
import java.util.List;

@Controller
@RequestMapping("/projects")
public class ProjectController {
    private  final  ProjectService projectService;
    @Autowired
    public ProjectController(ProjectService projectService) {this.projectService=projectService;}

    @GetMapping
    @ResponseBody
    List<Project> getProjectList() { return projectService.projectList(); }


    @GetMapping("/{sid}")
    @ResponseBody
    Project getProject(@RequestBody @PathVariable long sid){
        return projectService.getProject(sid);
    }

    @PostMapping(value = "/save", produces = {MediaType.APPLICATION_JSON} )
    @ResponseBody
    Project saveProject(@RequestBody Project newProject ){
        return projectService.saveProject(newProject);
    }

    @DeleteMapping(value = "/delete", produces = {MediaType.APPLICATION_JSON} )
    @ResponseBody
    String deleteProject(@RequestBody Project delProject  ){
        projectService.deleteProject(delProject);
        return "deleted";
    }

    @DeleteMapping(value = "/delete/{sid}", produces = {MediaType.APPLICATION_JSON} )
    @ResponseBody
    String deleteProject(@RequestBody @PathVariable long sid  ){
        projectService.deleteProject(sid);
        return "deleted";
    }

    @PutMapping(value = "/update/{sid}")
    @ResponseBody
    String updateProject(@PathVariable long sid,  @RequestBody Project project) {
        return projectService.updateProject(sid, project);
    }

}
