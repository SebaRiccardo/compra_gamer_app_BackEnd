package compragamerapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import compragamerapp.entities.Client;
import compragamerapp.entities.ResponseError;
import compragamerapp.services.ClientService;

@RestController
public class ClientController {
    @Autowired
    ClientService clientService;

    
    @GetMapping(value = "/clients")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<Client> getAll() {
        return clientService.getAll();
    }

    @GetMapping(value = "/client/{id}")
    @ResponseBody
    public Object getClient(@PathVariable("id") long clientId) {
        Client client = clientService.getClient(clientId);
        if (client == null) {
            return new ResponseEntity( new ResponseError( 404, String.format("El cliente con id: %d no existe", clientId)),HttpStatus.NOT_FOUND);
        }
        return client;
    }
    
    @PostMapping(value= "/clients")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Object saveClient(@RequestBody Client client){
    
        if(client !=null){    
            return clientService.saveClient(client);
        }else{
            return new ResponseEntity(new ResponseError(400, String.format("Informacion faltante")), HttpStatus.BAD_REQUEST);
        } 
    }

}