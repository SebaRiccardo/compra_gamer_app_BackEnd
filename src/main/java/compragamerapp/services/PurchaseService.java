package compragamerapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import compragamerapp.entities.Purchase;
import compragamerapp.repository.PurchaseRepository;


@Service
public class PurchaseService {
    @Autowired
    PurchaseRepository purchaseRepository;
    

    public List<Purchase> getAll(){
        return purchaseRepository.findAll();
    } 
    public  Purchase getPurchase(Long id){
        
        return  purchaseRepository.findById(id).orElse(null);
    
    }
    public Purchase savePurchase(Purchase p){  
       return purchaseRepository.save(p);
    }
    public void deletePurchase(Long id){
        purchaseRepository.deleteById(id);
    }


}