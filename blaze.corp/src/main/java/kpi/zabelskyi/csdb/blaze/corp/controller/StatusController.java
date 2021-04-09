package kpi.zabelskyi.csdb.blaze.corp.controller;


import kpi.zabelskyi.csdb.blaze.corp.model.Status;
import kpi.zabelskyi.csdb.blaze.corp.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import javax.ws.rs.core.MediaType;
import java.util.List;

@Controller
@RequestMapping("/statuses")
public class StatusController {
    private  final  StatusService statusService;
    @Autowired
    public StatusController(StatusService statusService) {this.statusService=statusService;}

    @GetMapping
    @ResponseBody
    List<Status> getStatusList() { return statusService.statusList(); }


    @GetMapping("/{sid}")
    @ResponseBody
    Status getStatus(@RequestBody @PathVariable long sid){
        return statusService.getStatus(sid);
    }

    @PostMapping(value = "/save", produces = {MediaType.APPLICATION_JSON} )
    @ResponseBody
    Status saveStatus(@RequestBody Status newStatus ){
        return statusService.saveStatus(newStatus);
    }

    @DeleteMapping(value = "/delete", produces = {MediaType.APPLICATION_JSON} )
    @ResponseBody
    String deleteStatus(@RequestBody Status delStatus  ){
        statusService.deleteStatus(delStatus);
        return "deleted";
    }

    @DeleteMapping(value = "/delete/{sid}", produces = {MediaType.APPLICATION_JSON} )
    @ResponseBody
    String deleteStatus(@RequestBody @PathVariable long sid  ){
        statusService.deleteStatus(sid);
        return "deleted";
    }
}
