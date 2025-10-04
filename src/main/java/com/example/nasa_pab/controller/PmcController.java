package com.example.nasa_pab.controller;

import com.example.nasa_pab.dto.CategoryDTO;
import com.example.nasa_pab.dto.PmcDTO;
import com.example.nasa_pab.model.Pmc;
import com.example.nasa_pab.service.PmcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pmc")
@CrossOrigin(origins = "*")
public class PmcController {

    @Autowired
    private PmcService service;


    // Search
    @GetMapping("/search")
    public Page<PmcDTO> search(
            @RequestParam(required = false) String keyword,
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String author,
            @RequestParam(required = false) Integer year,
            @RequestParam(required = false) String category,
            Pageable pageable) {
        return service.search(keyword, title, author, year, category, pageable);
    }
    // Filter by year
    @GetMapping("/year/{year}")
    public Page<PmcDTO> filterByYear(@PathVariable int year, Pageable pageable) {
        return service.filterByYear(year, pageable);
    }

    // Filter by category (card click)
    @GetMapping("/category/{category}")
    public Page<PmcDTO> filterByCategory(@PathVariable String category, Pageable pageable) {
        return service.filterByCategory(category, pageable);
    }

    // Filter by author
    @GetMapping("/author")
    public Page<PmcDTO> filterByAuthor(@RequestParam String name, Pageable pageable) {
        return service.filterByAuthor(name, pageable);
    }

    //get all categories
    @GetMapping("/categories")
    public List<CategoryDTO> getAllCategories() {
        return service.getAllCategories();
    }

    // Get category by ID
    @GetMapping("/categories/{id}")
    public CategoryDTO getCategoryById(@PathVariable int id) {
        return service.getCategoryById(id);
    }

    @GetMapping("/experiments")
    public Page<PmcDTO> getAllExperiments(Pageable pageable) {
        return service.getAllExperiments(pageable);
    }

    @GetMapping("/experiments/{id}")
    public PmcDTO getExperimentById(@PathVariable Long id) {
        return service.getExperimentById(id);
    }
    }
