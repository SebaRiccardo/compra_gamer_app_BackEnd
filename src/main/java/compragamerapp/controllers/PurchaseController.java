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

import compragamerapp.entities.Purchase;
import compragamerapp.entities.ResponseError;
import compragamerapp.services.PurchaseService;

@RestController
public class PurchaseController {
    
    @Autowired 
    PurchaseService purchaseService;

    @GetMapping(value = "/purchases")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<Purchase> getAll() {
        return purchaseService.getAll();
    }
    @GetMapping(value = "/purchase/{id}")
    @ResponseBody
    public Object getProduct(@PathVariable("id") long purchaseId) {
        Purchase purchase = purchaseService.getPurchase(purchaseId);
        if (purchase == null) {
            return new ResponseEntity( new ResponseError( 404, String.format("La venta con id: %d no existe", purchaseId)),HttpStatus.NOT_FOUND);
        }
        return purchase;
    }
    @PostMapping(value="/purchases")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Object savePurchase(@RequestBody Purchase purchase){
        
        if(purchase!=null){
            return purchaseService.savePurchase(purchase);
        }else{
            return new ResponseEntity(new ResponseError(400, String.format("Informacion de compra faltante")), HttpStatus.BAD_REQUEST);
        }

    }
}