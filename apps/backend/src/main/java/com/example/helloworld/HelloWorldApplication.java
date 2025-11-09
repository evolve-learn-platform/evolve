package com.example.helloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@SpringBootApplication
public class HelloWorldApplication {
    public static void main(String[] args) {
        SpringApplication.run(HelloWorldApplication.class, args);
    }
}

// Класс модели для объекта
class Item {
    private final int id;
    private final String name;
    private final String description;

    public Item(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}

@RestController
@CrossOrigin(origins = "*")
class HelloWorldController {

    @GetMapping("/")
    public String hello() {
        return "Hello World";
    }

    // Список вещей
    @GetMapping("/things")
    public List<Item> getThings() {
        return List.of(
                new Item(1, "Стул", "Деревянный стул для кухни"),
                new Item(2, "Стол", "Обеденный стол на 4 персоны"),
                new Item(3, "Лампа", "Настольная лампа с регулировкой яркости"),
                new Item(4, "Книга", "Интересная книга по программированию"),
                new Item(5, "Ручка", "Черная гелевая ручка")
        );
    }

    // Список животных
    @GetMapping("/animals")
    public List<Item> getAnimals() {
        return List.of(
                new Item(1, "Собака", "Дружелюбная порода"),
                new Item(2, "Кошка", "Ласковая домашняя кошка"),
                new Item(3, "Лошадь", "Галопирующая лошадь"),
                new Item(4, "Корова", "Молочная корова"),
                new Item(5, "Кролик", "Белый кролик с длинными ушами")
        );
    }
}
