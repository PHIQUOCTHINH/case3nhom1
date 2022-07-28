package com.example.demo12.service.impl;

import com.example.demo12.DAO.CategoryRepository;
import com.example.demo12.model.Category;
import com.example.demo12.service.ICRUDService;

import java.util.ArrayList;

public class CategoryService implements ICRUDService<Category> {
    CategoryRepository categoryRepository = new CategoryRepository();
    @Override
    public Category findById(int id) {
        return categoryRepository.findById(id);
    }

    @Override
    public ArrayList<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public void create(Category category) {
        categoryRepository.create(category);
    }

    @Override
    public void update(Category category) {
        categoryRepository.update(category);
    }

    @Override
    public void deleteById(int id) {
        categoryRepository.deleteById(id);
    }
}
