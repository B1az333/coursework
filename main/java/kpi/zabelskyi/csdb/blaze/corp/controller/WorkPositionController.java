package kpi.zabelskyi.csdb.blaze.corp.controller;


import kpi.zabelskyi.csdb.blaze.corp.model.WorkPosition;
import kpi.zabelskyi.csdb.blaze.corp.service.WorkPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import javax.ws.rs.core.MediaType;
import java.util.List;

@Controller
@RequestMapping("/workPositions")
public class WorkPositionController {
    private  final  WorkPositionService workPositionService;
    @Autowired
    public WorkPositionController(WorkPositionService workPositionService) {this.workPositionService=workPositionService;}

    @GetMapping
    @ResponseBody
    List<WorkPosition> getWorkPositionList() { return workPositionService.workPositionList(); }


    @GetMapping("/{sid}")
    @ResponseBody
    WorkPosition getWorkPosition(@RequestBody @PathVariable long sid){
        return workPositionService.getWorkPosition(sid);
    }

    @PostMapping(value = "/save", produces = {MediaType.APPLICATION_JSON} )
    @ResponseBody
    WorkPosition saveWorkPosition(@RequestBody WorkPosition newWorkPosition ){
        return workPositionService.saveWorkPosition(newWorkPosition);
    }

    @DeleteMapping(value = "/delete", produces = {MediaType.APPLICATION_JSON} )
    @ResponseBody
    String deleteWorkPosition(@RequestBody WorkPosition delWorkPosition  ){
        workPositionService.deleteWorkPosition(delWorkPosition);
        return "deleted";
    }

    @DeleteMapping(value = "/delete/{sid}", produces = {MediaType.APPLICATION_JSON} )
    @ResponseBody
    String deleteWorkPosition(@RequestBody @PathVariable long sid  ){
        workPositionService.deleteWorkPosition(sid);
        return "deleted";
    }


}