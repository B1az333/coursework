package kpi.zabelskyi.csdb.blaze.corp.service;

import kpi.zabelskyi.csdb.blaze.corp.model.Client;
import kpi.zabelskyi.csdb.blaze.corp.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@Service
public class ClientServiceImpl implements ClientService{
    private final ClientRepository clientRepository;
    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository){
        this.clientRepository=clientRepository;
    }

    @Override
    public List<Client> clientList() { return clientRepository.findAll(); }

    @Override
    public Client saveClient(Client newClient) {
        return clientRepository.save(newClient);
    }

    @Override
    public Client getClient(long sid) {
        return clientRepository.findById(sid)
                .orElseThrow();
    }


    @Override
    public  String deleteClient(Client delClient){
        clientRepository.delete(delClient);
        return "deleted";
    }

    @Override
    public String deleteClient(@PathVariable long sid){
        Client s = clientRepository.getOne(sid);
        clientRepository.delete(s);
        return "deleted";
    }

    @Override
    public String updateClient(long sid, Client client) {
        clientRepository.getOne(sid).setClientName(client.getClientName());//setName(client.getName());
        clientRepository.getOne(sid).setClientEmail(client.getClientEmail());
        clientRepository.getOne(sid).setClientPassword(client.getClientPassword());
        clientRepository.getOne(sid).setIdUserType(client.getIdUserType());
        clientRepository.save(clientRepository.getOne(sid));
        return "Client updated";

    }
//clientName clientEmail clientPassword idUserType
}