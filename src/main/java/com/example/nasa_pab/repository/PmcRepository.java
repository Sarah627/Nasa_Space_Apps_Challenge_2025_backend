package com.example.nasa_pab.repository;

import com.example.nasa_pab.model.Pmc;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PmcRepository extends JpaRepository<Pmc, Long> {

    // Search across title, authors, keywords
    Page<Pmc> findByTitleContainingIgnoreCaseOrAuthorsContainingIgnoreCaseOrKeywordsContainingIgnoreCase(
            String title, String authors, String keywords, Pageable pageable
    );

    // Filter by year
    Page<Pmc> findByYear(int year, Pageable pageable);

    // Filter by category
    Page<Pmc> findByCategoryIgnoreCase(String category, Pageable pageable);

    // Filter by author
    Page<Pmc> findByAuthorsContainingIgnoreCase(String author, Pageable pageable);
}
