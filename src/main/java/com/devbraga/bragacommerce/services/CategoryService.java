package com.devbraga.bragacommerce.services;

import com.devbraga.bragacommerce.dto.CategoryDTO;
import com.devbraga.bragacommerce.entities.Category;
import com.devbraga.bragacommerce.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional(readOnly = true)
    public List<CategoryDTO> findAll(){
        List<Category> result = categoryRepository.findAll();
        return result.stream().map(x -> new CategoryDTO(x)).toList();
    }

}
