package compragamerapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import compragamerapp.entities.Purchase;
import compragamerapp.repository.PurchaseRepository;
import compragamerapp.repository.productRepository;

@Service
public class PurchaseService {
    @Autowired
    PurchaseRepository purchaseRepository;

    public List<Purchase> getAll(){
        return purchaseRepository.findAll();
    } 
    public  Purchase findById(Long id){
        return  purchaseRepository.findById(id).orElse(null);
    }
    public Purchase savePurchase(Purchase purchase){
        return purchaseRepository.save(purchase);
    }
    public void deletePurchase(Long id){
        purchaseRepository.deleteById(id);
    }

}