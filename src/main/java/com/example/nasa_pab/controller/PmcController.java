package com.example.nasa_pab.controller;

import com.example.nasa_pab.dto.PmcDTO;
import com.example.nasa_pab.service.PmcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pmc")
@CrossOrigin(origins = "*")
public class PmcController {

    @Autowired
    private PmcService service;

    // Search
    @GetMapping("/search")
    public Page<PmcDTO> search(@RequestParam String keyword, Pageable pageable) {
        return service.search(keyword, pageable);
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
}
