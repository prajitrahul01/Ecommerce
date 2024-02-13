package com.example.Ecommerce.Controller;

import com.example.Ecommerce.Model.Category;
import com.example.Ecommerce.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    // Endpoint to save a new category
    @PostMapping("/save")
    public Category save(@RequestBody Category category){
        return categoryService.saveCategory(category);
    }

    // Endpoint to update an existing category by ID
    @PostMapping("/{id}")
    public Category update(@RequestBody Category category, @PathVariable("id") int id){
        return categoryService.updateCategory(category, id);
    }

    // Endpoint to delete a category by ID
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id){
        categoryService.deleteCategory(id);
    }

    // Endpoint to get all categories
    @GetMapping("/")
    public List<Category> getAll(){
        return categoryService.getAllCategory();
    }

    // Endpoint to get a category by ID
    @PostMapping("/")
    public Optional<Category> get(@RequestBody int id){
        return categoryService.getCategory(id);
    }


    @GetMapping("/findbyname/{name}")
    public Category findbyname(@PathVariable String name) {
        return categoryService.getCategorybyname(name);
    }
    @GetMapping("/findbydes/{des}")
    public Category findbydes(@PathVariable String des) {
        return categoryService.getCategorybydes(des);
    }

}
