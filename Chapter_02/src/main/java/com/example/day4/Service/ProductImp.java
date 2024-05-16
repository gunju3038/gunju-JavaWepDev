package com.example.day4.Service;

import com.example.day4.Entity.ProductEntity;
import com.example.day4.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductImp implements ProductService{
    @Autowired
    ProductRepository productRepository;

    @Override
    public void insert(ProductEntity productEntity) {
        productRepository.save(productEntity);
    }


    @Override
    public void delete(long snumber) {
        productRepository.findById(snumber).ifPresent(result -> productRepository.delete(result));
    }

    @Override
    public ProductEntity selectOne(long snumber) {
        return productRepository.findById(snumber).orElse(null);
    }

    @Override
    public Page<ProductEntity> select(int page) {
        return productRepository.findAll(PageRequest.of(page,2));
    }
}
