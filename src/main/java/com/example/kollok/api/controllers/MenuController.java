package com.example.kollok.api.controllers;

import com.example.kollok.api.models.Dish;
import com.example.kollok.api.models.Menu;
import com.example.kollok.services.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/menu")
public class MenuController {

    private final MenuService menuService;

    @Autowired
    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }


    @GetMapping ("/")
    public ResponseEntity<?> getMenu(@RequestBody Long idx) {
        try {
            List<Dish> menu = menuService.getMenu(idx);
            return new ResponseEntity<>(menu, HttpStatus.OK);
        } catch (IllegalArgumentException ie) {
            return new ResponseEntity<>("Can't find menu with this id", HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
