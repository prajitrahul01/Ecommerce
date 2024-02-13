package com.example.Ecommerce.Repository;

import com.example.Ecommerce.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    // Custom query to retrieve a Category by its name
    @Query(value = "SELECT c FROM Category c WHERE c.name = :categoryName")
    Category getCategoryByName(String categoryName);

    // Custom query to retrieve a Category by its description
    @Query(value = "SELECT c FROM Category c WHERE c.description = :Description")
    Category getCategoryByDescription(String Description);
}
