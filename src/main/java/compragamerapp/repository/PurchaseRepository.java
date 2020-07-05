package compragamerapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import compragamerapp.entities.Purchase;

public interface PurchaseRepository extends JpaRepository<Purchase, Long>{
    
}