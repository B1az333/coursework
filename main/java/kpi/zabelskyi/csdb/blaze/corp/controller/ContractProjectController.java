package kpi.zabelskyi.csdb.blaze.corp.controller;


import kpi.zabelskyi.csdb.blaze.corp.model.Client;
import kpi.zabelskyi.csdb.blaze.corp.model.ContractProject;
import kpi.zabelskyi.csdb.blaze.corp.service.ContractProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import javax.ws.rs.core.MediaType;
import java.util.List;

@Controller
@RequestMapping("/contractProjects")
public class ContractProjectController {
    private  final  ContractProjectService contractProjectService;
    @Autowired
    public ContractProjectController(ContractProjectService contractProjectService) {this.contractProjectService=contractProjectService;}

    @GetMapping
    @ResponseBody
    List<ContractProject> getContractProjectList() { return contractProjectService.contractProjectList(); }


    @GetMapping("/{sid}")
    @ResponseBody
    ContractProject getContractProject(@RequestBody @PathVariable long sid){
        return contractProjectService.getContractProject(sid);
    }

    @PostMapping(value = "/save", produces = {MediaType.APPLICATION_JSON} )
    @ResponseBody
    ContractProject saveContractProject(@RequestBody ContractProject newContractProject ){
        return contractProjectService.saveContractProject(newContractProject);
    }

    @DeleteMapping(value = "/delete", produces = {MediaType.APPLICATION_JSON} )
    @ResponseBody
    String deleteContractProject(@RequestBody ContractProject delContractProject  ){
        contractProjectService.deleteContractProject(delContractProject);
        return "deleted";
    }

    @DeleteMapping(value = "/delete/{sid}", produces = {MediaType.APPLICATION_JSON} )
    @ResponseBody
    String deleteContractProject(@RequestBody @PathVariable long sid  ){
        contractProjectService.deleteContractProject(sid);
        return "deleted";
    }

    @PutMapping(value = "/update/{sid}")
    @ResponseBody
    String updateContractProject(@PathVariable long sid,  @RequestBody ContractProject contractProject) {
        return contractProjectService.updateContractProject(sid, contractProject);
    }
}
