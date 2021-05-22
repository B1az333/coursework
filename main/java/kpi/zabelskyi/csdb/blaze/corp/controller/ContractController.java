package kpi.zabelskyi.csdb.blaze.corp.controller;


import kpi.zabelskyi.csdb.blaze.corp.model.Contract;
import kpi.zabelskyi.csdb.blaze.corp.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import javax.ws.rs.core.MediaType;
import java.util.List;

@Controller
@RequestMapping("/contracts")
public class ContractController {
    private  final  ContractService contractService;
    @Autowired
    public ContractController(ContractService contractService) {this.contractService=contractService;}

    @GetMapping
    @ResponseBody
    List<Contract> getContractList() { return contractService.contractList(); }


    @GetMapping("/{sid}")
    @ResponseBody
    Contract getContract(@RequestBody @PathVariable long sid){
        return contractService.getContract(sid);
    }

    @PostMapping(value = "/save", produces = {MediaType.APPLICATION_JSON} )
    @ResponseBody
    Contract saveContract(@RequestBody Contract newContract ){
        return contractService.saveContract(newContract);
    }

    @DeleteMapping(value = "/delete", produces = {MediaType.APPLICATION_JSON} )
    @ResponseBody
    String deleteContract(@RequestBody Contract delContract  ){
        contractService.deleteContract(delContract);
        return "deleted";
    }

    @DeleteMapping(value = "/delete/{sid}", produces = {MediaType.APPLICATION_JSON} )
    @ResponseBody
    String deleteContract(@RequestBody @PathVariable long sid  ){
        contractService.deleteContract(sid);
        return "deleted";
    }


}