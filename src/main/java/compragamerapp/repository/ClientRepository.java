package compragamerapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import compragamerapp.entities.Client;

public interface ClientRepository extends JpaRepository<Client,Long> {
    
}