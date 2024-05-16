package com.example.day4.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="exam_sang0422")
@Entity
@SequenceGenerator(
        name = "exam_sang0422",
        sequenceName = "snumber_seq",
        allocationSize = 1,
        initialValue = 1
)
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
    generator = "exam_sang0422")
    @Column
    long snumber;
    @Column
    String name;
    @Column
    int amount;
    @Column
    int price;
    @Column
    int total;
    @Column
    String picture;

}
