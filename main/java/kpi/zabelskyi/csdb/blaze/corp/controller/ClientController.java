package kpi.zabelskyi.csdb.blaze.corp.controller;


import kpi.zabelskyi.csdb.blaze.corp.model.Client;
import kpi.zabelskyi.csdb.blaze.corp.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import javax.ws.rs.core.MediaType;
import java.util.List;

@Controller
@RequestMapping("/clients")
public class ClientController {
    private  final  ClientService clientService;
    @Autowired
    public ClientController(ClientService clientService) {this.clientService=clientService;}

    @GetMapping
    @ResponseBody
    List<Client> getClientList() { return clientService.clientList(); }


    @GetMapping("/{sid}")
    @ResponseBody
    Client getClient(@RequestBody @PathVariable long sid){
        return clientService.getClient(sid);
    }

    @PostMapping(value = "/save", produces = {MediaType.APPLICATION_JSON} )
    @ResponseBody
    Client saveClient(@RequestBody Client newClient ){
        return clientService.saveClient(newClient);
    }

    @DeleteMapping(value = "/delete", produces = {MediaType.APPLICATION_JSON} )
    @ResponseBody
    String deleteClient(@RequestBody Client delClient  ){
        clientService.deleteClient(delClient);
        return "deleted";
    }

    @DeleteMapping(value = "/delete/{sid}", produces = {MediaType.APPLICATION_JSON} )
    @ResponseBody
    String deleteClient(@RequestBody @PathVariable long sid){
        clientService.deleteClient(sid);
        return "deleted";
    }

    @PutMapping(value = "/update/{sid}")
    @ResponseBody
    String updateClient(@PathVariable long sid,  @RequestBody Client client) {
        return clientService.updateClient(sid, client);
    }


}