package com.example.Ecommerce.Service;

import com.example.Ecommerce.Model.Category;
import com.example.Ecommerce.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    // Method to save a new category
    public Category saveCategory(Category category){
        return categoryRepository.save(category);
    }

    // Method to update an existing category by ID
    public Category updateCategory(Category category, int id){
        category.setId(id);
        return categoryRepository.saveAndFlush(category);
    }

    // Method to delete a category by ID
    public void deleteCategory(int id){
        categoryRepository.deleteById(id);
    }

    // Method to retrieve all categories
    public List<Category> getAllCategory(){
        return categoryRepository.findAll();
    }

    // Method to retrieve a category by ID
    public Optional<Category> getCategory(int id){
        return categoryRepository.findById(id);
    }

    public Category getCategorybyname(String name){
        return categoryRepository.getCategoryByName(name);
    }
    public Category getCategorybydes(String des){
        return categoryRepository.getCategoryByDescription(des);
    }

}
