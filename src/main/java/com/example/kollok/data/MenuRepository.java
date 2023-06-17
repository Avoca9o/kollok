package com.example.kollok.data;

import com.example.kollok.api.models.Menu;
import com.example.kollok.api.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository
        extends JpaRepository<Menu, Long> {
}
