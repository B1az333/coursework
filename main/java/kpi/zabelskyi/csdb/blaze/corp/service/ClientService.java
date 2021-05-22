package kpi.zabelskyi.csdb.blaze.corp.service;

import kpi.zabelskyi.csdb.blaze.corp.model.Client;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ClientService {
    List<Client> clientList();

    Client saveClient(Client newClient);
    Client getClient(@PathVariable long sid);
    String deleteClient(Client delClient);
    String deleteClient(@PathVariable long id);
    String updateClient(@PathVariable long sid,  @RequestBody Client client);
}