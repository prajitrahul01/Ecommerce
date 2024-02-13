package com.example.Ecommerce.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "e_category")
@AllArgsConstructor
@NoArgsConstructor
public class Category {

    @Id
    @GeneratedValue
    @Column(name = "c_id")
    private int id;

    @Column(name = "c_name")
    private String name;

    @Column(name = "d_name")
    private String description;
}
