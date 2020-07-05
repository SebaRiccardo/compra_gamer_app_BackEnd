package compragamerapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import compragamerapp.entities.Product;

public interface ProductRepository  extends JpaRepository<Product, Long>{
    
}