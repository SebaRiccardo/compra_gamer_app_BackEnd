package compragamerapp.controllers;

import java.util.ArrayList;
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

import compragamerapp.entities.ItemToPurchase;
import compragamerapp.entities.Product;
import compragamerapp.entities.Purchase;
import compragamerapp.entities.ResponseError;
import compragamerapp.services.ClientService;
import compragamerapp.services.ItemTopurchaseService;
import compragamerapp.services.ProductService;
import compragamerapp.services.PurchaseService;

@RestController
public class PurchaseController {
    
    @Autowired 
    PurchaseService purchaseService;
    @Autowired
    ClientService clientService;
    @Autowired
    ItemTopurchaseService ITPService;
    @Autowired
    ProductService productService;

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
       /// logica para buscar todos los productos asociados a dicha compra, primero
       
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
           List<Product> products;
           Purchase savedPurchase;
           List<ItemToPurchase> items = new ArrayList<>();
           
           products= purchase.getPurchasedItems();
                      
           savedPurchase= purchaseService.savePurchase(purchase);
           
           for(Product p: products){
            ItemToPurchase item = new ItemToPurchase();
            item.setPricePerItem(p.getPrice());
            item.setProduct_id(p.getId());
            item.setPurchase_id(savedPurchase.getNro());
            item.setQuantity(1);
            items.add(item);
           }   
           ITPService.saveAll(items);
           return savedPurchase;
        }else{
           
            return new ResponseEntity(new ResponseError(400, "Request mal formado"), HttpStatus.BAD_REQUEST);
        
        }

    }
}