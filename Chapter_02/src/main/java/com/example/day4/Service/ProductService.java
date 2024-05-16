package com.example.day4.Service;

import com.example.day4.Entity.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    void insert(ProductEntity productEntity);

    

    void delete(long snumber);

    ProductEntity selectOne(long snumber);

    Page<ProductEntity> select(int page);
}
