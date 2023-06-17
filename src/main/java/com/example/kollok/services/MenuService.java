package com.example.kollok.services;

import com.example.kollok.api.models.Dish;
import com.example.kollok.api.models.Menu;
import com.example.kollok.data.DishRepository;
import com.example.kollok.data.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenuService {
    private final DishRepository dishRepository;

    @Autowired
    public MenuService(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    public List<Dish> getMenu(Long idx) {
        List<Dish> output = dishRepository.findAll().stream().filter(dish -> idx.equals(dish.getMenuId())).toList();
        if (output.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return output;
    }
}
