package com.example.nasa_pab.service;

import com.example.nasa_pab.dto.CategoryDTO;
import com.example.nasa_pab.dto.PmcDTO;
import com.example.nasa_pab.model.Pmc;
import com.example.nasa_pab.repository.PmcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@Service
public  class PmcService {

    @Autowired
    private PmcRepository repository;

    private PmcDTO mapToDTO(Pmc pmc) {
        List<String> images = new ArrayList<>();
        try (InputStream is = getClass().getResourceAsStream("/images.txt");
             BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            String line;
            while ((line = reader.readLine()) != null) {
                images.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String coverUrl = null;
        if (!images.isEmpty()) {
            int randomIndex = new Random().nextInt(images.size());
            coverUrl = "/images/experiments/" + images.get(randomIndex).replace(" ", "%20");
        }
        return new PmcDTO(
                pmc.getId().longValue(),
                coverUrl,
                pmc.getTitle(),
                pmc.getAuthors(),
                pmc.getKeywords(),
                pmc.getAbstractText(),
                pmc.getCategory(),
                pmc.getUrl()


        );
    }



//    public Page<PmcDTO> search(String keyword, Pageable pageable) {
//        return repository
//                .findByTitleContainingIgnoreCaseOrAuthorsContainingIgnoreCaseOrKeywordsContainingIgnoreCase(
//                        keyword, keyword, keyword, pageable)
//                .map(this::mapToDTO);
//    }

    public Page<PmcDTO> search(String keyword, String title, String author, Integer year, String category, Pageable pageable) {
        if (keyword != null && keyword.isBlank()) keyword = null;
        if (title != null && title.isBlank()) title = null;
        if (author != null && author.isBlank()) author = null;
        if (category != null && category.isBlank()) category = null;

        return repository.advancedSearch(keyword, title, author, year, category, pageable)
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

    // All categories with id
    public List<CategoryDTO> getAllCategories() {
        List<String> categories = repository.findAll()
                .stream()
                .map(Pmc::getCategory)
                .distinct()
                .toList();
        List<CategoryDTO> result = new ArrayList<>();
        int idCounter = 1;
        for (String category : categories) {
            result.add(new CategoryDTO(idCounter++, category));
        }
        return result;
    }

    // Details for one category by id
    public CategoryDTO getCategoryById(int id) {
        List<String> categories = repository.findAll()
                .stream()
                .map(Pmc::getCategory)
                .distinct()
                .toList();
        if (id < 1 || id > categories.size()) {
            throw new IllegalArgumentException("Invalid category ID");
        }

        String categoryName = categories.get(id - 1);
        List<PmcDTO> pmcsInCategory = repository.findByCategoryIgnoreCase(categoryName, Pageable.unpaged())
                .stream()
                .map(this::mapToDTO)
                .toList();

        return new CategoryDTO(id, categoryName, pmcsInCategory);
    }

    public Page<PmcDTO> getAllExperiments(Pageable pageable) {
        return repository.findAll(pageable).map(this::mapToDTO);
    }

    // Get single experiment by ID
    public PmcDTO getExperimentById(Long id) {
        Pmc pmc = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Experiment not found with id " + id));
        return mapToDTO(pmc);
    }

}
