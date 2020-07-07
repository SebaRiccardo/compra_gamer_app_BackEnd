package compragamerapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import compragamerapp.entities.ItemToPurchase;

public interface ItemToPurchaseRepository extends JpaRepository<ItemToPurchase, Long> {
    
}