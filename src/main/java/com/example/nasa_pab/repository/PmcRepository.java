package com.example.nasa_pab.repository;

import com.example.nasa_pab.model.Pmc;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PmcRepository extends JpaRepository<Pmc, Long> {

    // Search across title, authors, keywords
    Page<Pmc> findByTitleContainingIgnoreCaseOrAuthorsContainingIgnoreCaseOrKeywordsContainingIgnoreCase(
            String title, String authors, String keywords, Pageable pageable
    );

    @Query("SELECT p FROM Pmc p " +
            "WHERE (:keyword IS NULL OR LOWER(p.title) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "   OR LOWER(p.authors) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "   OR LOWER(p.keywords) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "   OR LOWER(p.category) LIKE LOWER(CONCAT('%', :keyword, '%'))) " +
            "AND (:title IS NULL OR LOWER(p.title) LIKE LOWER(CONCAT('%', :title, '%'))) " +
            "AND (:author IS NULL OR LOWER(p.authors) LIKE LOWER(CONCAT('%', :author, '%'))) " +
            "AND (:year IS NULL OR p.year = :year) " +
            "AND (:category IS NULL OR LOWER(p.category) LIKE LOWER(CONCAT('%', :category, '%')))")
    Page<Pmc> advancedSearch(
            @Param("keyword") String keyword,
            @Param("title") String title,
            @Param("author") String author,
            @Param("year") Integer year,
            @Param("category") String category,
            Pageable pageable
    );


    // Filter by year
    Page<Pmc> findByYear(int year, Pageable pageable);

    // Filter by category
    Page<Pmc> findByCategoryIgnoreCase(String category, Pageable pageable);

    // Filter by author
    Page<Pmc> findByAuthorsContainingIgnoreCase(String author, Pageable pageable);
}
