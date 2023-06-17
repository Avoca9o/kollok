package com.example.kollok;

import com.example.kollok.api.models.Dish;
import com.example.kollok.api.models.Menu;
import com.example.kollok.api.models.Restaurant;
import com.example.kollok.data.DishRepository;
import com.example.kollok.data.MenuRepository;
import com.example.kollok.data.OrderRepository;
import com.example.kollok.data.RestaurantRepository;
import jdk.jfr.RecordingState;
import org.aspectj.weaver.ast.Or;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class ConfigurationClass {
    @Bean
    CommandLineRunner commandLineRunner(
            RestaurantRepository restaurantRepository,
            MenuRepository menuRepository,
            OrderRepository orderRepository,
            DishRepository dishRepository
    ) {
        return args -> {
            Restaurant a = new Restaurant("kfc", "USA", 5.0);
            Restaurant b = new Restaurant("rostics", "Russia", 4.8);

            restaurantRepository.saveAll(List.of(a, b));

            Menu kfcMenu = new Menu();
            Menu rosticsMenu = new Menu();

            menuRepository.saveAll(List.of(kfcMenu, rosticsMenu));

            Dish latte = new Dish("latte", "coffee with a lot of milk", 4.99, kfcMenu.getId());
            Dish burger = new Dish("cheeseburger", "a big burger", 5.99, kfcMenu.getId());
            Dish cola = new Dish("cola", "unhealthy drink", 3.55, rosticsMenu.getId());
            Dish shwarm = new Dish("shwarm", "meal of Gods", 5.00, rosticsMenu.getId());

            dishRepository.saveAll(List.of(latte, burger, cola, shwarm));

        };
    }
}
