package com.invenco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.invenco.entity.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}
