package com.example.nasa_pab.service;

import com.example.nasa_pab.dto.PmcDTO;
import com.example.nasa_pab.model.Pmc;
import com.example.nasa_pab.repository.PmcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PmcService {

    @Autowired
    private PmcRepository repository;

    private PmcDTO mapToDTO(Pmc pmc) {
        return new PmcDTO(
                pmc.getCoverPhoto(),
                pmc.getTitle(),
                pmc.getAuthors(),
                pmc.getKeywords(),
                pmc.getAbstractText(),
                pmc.getCategory()
        );
    }

    public Page<PmcDTO> search(String keyword, Pageable pageable) {
        return repository
                .findByTitleContainingIgnoreCaseOrAuthorsContainingIgnoreCaseOrKeywordsContainingIgnoreCase(
                        keyword, keyword, keyword, pageable)
                .map(this::mapToDTO);
    }

    public Page<PmcDTO> filterByYear(int year, Pageable pageable) {
        return repository.findByYear(year, pageable).map(this::mapToDTO);
    }

    public Page<PmcDTO> filterByCategory(String category, Pageable pageable) {
        return repository.findByCategoryIgnoreCase(category, pageable).map(this::mapToDTO);
    }

    public Page<PmcDTO> filterByAuthor(String author, Pageable pageable) {
        return repository.findByAuthorsContainingIgnoreCase(author, pageable).map(this::mapToDTO);
    }
}
