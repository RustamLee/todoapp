package com.utn.todoapp.controllers;

import com.utn.todoapp.model.ToDoItem;
import com.utn.todoapp.repositories.ToDoItemRepository;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

@Controller
public class ToDoController implements CommandLineRunner {
    private final ToDoItemRepository toDoItemRepository;

    public ToDoController(ToDoItemRepository toDoItemRepository) {
        this.toDoItemRepository = toDoItemRepository;
    }

    @GetMapping
    public String index(Model model) {
        List<ToDoItem> allItems = toDoItemRepository.findAll();
        model.addAttribute("allItems", allItems);
        model.addAttribute("newItem", new ToDoItem());
        return "index";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute ToDoItem toDoItem) {
        if (toDoItem.getTitle() == null || toDoItem.getTitle().trim().isEmpty()) {
            return "redirect:/?error=true";
        }
        toDoItemRepository.save(toDoItem);
        return "redirect:/";
    }


    @PostMapping("/delete/{id}")
    public String deleteItem(@PathVariable("id") Long id) {
        toDoItemRepository.deleteById(id);
        return "redirect:/";
    }

    @PostMapping("/deleteAll")
    public String deleteAll() {
        toDoItemRepository.deleteAll();
        return "redirect:/";
    }

    @PostMapping("/search")
    public String searchItems(@RequestParam("searchTerm") String searchTerm, Model model) {
        if (searchTerm == null || searchTerm.trim().isEmpty()) {
            model.addAttribute("error", "Search term cannot be empty!");
            model.addAttribute("allItems", toDoItemRepository.findAll()); // Вернуть все элементы при ошибке
            model.addAttribute("newItem", new ToDoItem());
            return "index";
        }

        List<ToDoItem> allItems = toDoItemRepository.findAll();
        List<ToDoItem> searchResult = new ArrayList<>();
        for (ToDoItem item : allItems) {
            if (item.getTitle().toLowerCase().contains(searchTerm.toLowerCase())) {
                searchResult.add(item);
            }
        }

        model.addAttribute("allItems", searchResult);
        model.addAttribute("newItem", new ToDoItem());
        model.addAttribute("searchTerm", searchTerm);
        return "index";
    }


    @Override
    public void run(String... args) throws Exception {
    }
}
