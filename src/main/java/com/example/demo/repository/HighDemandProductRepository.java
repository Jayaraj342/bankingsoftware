package com.example.demo.repository;

import com.example.demo.model.HighDemandProduct;
import com.example.demo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HighDemandProductRepository extends JpaRepository<HighDemandProduct, Integer> {
    Optional<HighDemandProduct> findByProduct(Product product);
}
