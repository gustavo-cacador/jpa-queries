package br.com.gustavo.jpa_queries.repositories;

import br.com.gustavo.jpa_queries.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "SELECT obj FROM Product obj JOIN FETCH obj.categories")
    List<Product> searchAll();
}
