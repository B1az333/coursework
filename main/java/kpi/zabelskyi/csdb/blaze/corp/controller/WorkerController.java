package kpi.zabelskyi.csdb.blaze.corp.controller;


import kpi.zabelskyi.csdb.blaze.corp.model.Worker;
import kpi.zabelskyi.csdb.blaze.corp.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import javax.ws.rs.core.MediaType;
import java.util.List;

@Controller
@RequestMapping("/workers")
public class WorkerController {
    private  final  WorkerService workerService;
    @Autowired
    public WorkerController(WorkerService workerService) {this.workerService=workerService;}

    @GetMapping
    @ResponseBody
    List<Worker> getWorkerList() { return workerService.workerList(); }


    @GetMapping("/{sid}")
    @ResponseBody
    Worker getWorker(@RequestBody @PathVariable long sid){
        return workerService.getWorker(sid);
    }

    @PostMapping(value = "/save", produces = {MediaType.APPLICATION_JSON} )
    @ResponseBody
    Worker saveWorker(@RequestBody Worker newWorker ){
        return workerService.saveWorker(newWorker);
    }


    @DeleteMapping(value = "/delete/{sid}", produces = {MediaType.APPLICATION_JSON} )
    @ResponseBody
    String deleteWorker(@RequestBody @PathVariable long sid  ){
        workerService.deleteWorker(sid);
        return "deleted";
    }

    @DeleteMapping(value = "/deleteByClient/{sid}", produces = {MediaType.APPLICATION_JSON} )
    @ResponseBody
    String deleteWorkerByClient(@RequestBody @PathVariable long sid  ){
        workerService.deleteWorkerByClient(sid);
        return "deleted";
    }
}