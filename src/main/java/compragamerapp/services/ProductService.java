package compragamerapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import compragamerapp.entities.Product;
import compragamerapp.repository.ProductRepository;

@Service
public class ProductService {

        @Autowired
        ProductRepository productRepository;

        public List<Product> getAll() {
            return productRepository.findAll();
        }
        public Product getProduct(Long id){
            return productRepository.findById(id).orElse(null);
        }
        public Product saveProduct (Product product){
            return productRepository.save(product);
        }
        public void deleteProduct(Long id){
            productRepository.deleteById(id);
        }
        public List<Product> saveAll(List<Product>products){
            return productRepository.saveAll(products);
        }
}