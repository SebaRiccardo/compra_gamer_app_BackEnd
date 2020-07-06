package compragamerapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import compragamerapp.entities.Client;
import compragamerapp.repository.ClientRepository;


@Service
public class ClientService {
        
    @Autowired
    ClientRepository clientRepository;

    public List<Client> getAll(){
        return clientRepository.findAll();
    }
    public Client getClient(Long id){
        return clientRepository.findById(id).orElse(null);
    }
    public Client saveClient(Client client){
       return  clientRepository.save(client);
    }
    public void deleteClient(long id){
        clientRepository.deleteById(id);
    }
}