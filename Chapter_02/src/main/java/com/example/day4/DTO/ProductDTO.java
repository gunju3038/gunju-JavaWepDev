package com.example.day4.DTO;


import com.example.day4.Entity.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductDTO {
    long snumber;
    String name;
    int amount;
    int price;
    int total;
    String picture;

    public ProductEntity entity() {
        return new ProductEntity(snumber,name,amount,price,total,picture);
    }
}
