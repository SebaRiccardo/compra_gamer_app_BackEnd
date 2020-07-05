package compragamerapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import compragamerapp.entities.Product;
import compragamerapp.entities.ResponseError;
import compragamerapp.services.ProductService;

@RestController
public class ProductController {
    
    @Autowired 
    ProductService productService;


    @GetMapping(value = "/ping")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public String ping() {
        return "pong";
    }
    
    @GetMapping(value = "/products")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<Product> getAll() {
        return productService.getAll();
    }

    @GetMapping(value = "/products/{id}")
    @ResponseBody
    public Object getProduct(@PathVariable("id") long productId) {
        Product product = productService.getProduct(productId);
        if (product == null) {
            return new ResponseEntity( new ResponseError( 404, String.format("El producto con id: %d no existe", productId)),HttpStatus.NOT_FOUND);
        }
        return product;
    }
    @PostMapping(value= "/products")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Object saveProduct(@RequestBody Product product){
    
        if(product !=null){    
            return productService.saveProduct(product);
        }else{
            return new ResponseEntity(new ResponseError(400, String.format("Informacion faltante")), HttpStatus.BAD_REQUEST);
        } 
    }
}