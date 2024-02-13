package com.example.Ecommerce.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Entity
@Table(name = "e_product")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue
    @Column(name = "p_id")
    private int id;

    @Column(name = "p_name")
    private String name;

    @Column(name = "p_price")
    private int price;

    @Column(name = "p_description")
    private String description;


    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="c_id")
    private Category category;
}
