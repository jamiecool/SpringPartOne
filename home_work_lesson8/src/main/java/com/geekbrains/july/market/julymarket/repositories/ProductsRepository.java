package com.geekbrains.july.market.julymarket.repositories;

import com.geekbrains.july.market.julymarket.entities.Product;
import com.geekbrains.july.market.julymarket.entities.dtos.ProductDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductsRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {
    List<ProductDto> findAllBy();

}