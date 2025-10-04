package com.example.nasa_pab.dto;

import java.util.List;

public class CategoryDTO {
    private Integer id;
    private String name;
    private List<PmcDTO> pmcs;

    public CategoryDTO(Integer id, String name) {
        this.id = id;
        this.name = name;
        this.pmcs = null;
    }

    public CategoryDTO(Integer id, String name, List<PmcDTO> pmcs) {
        this.id = id;
        this.name = name;
        this.pmcs = pmcs;
    }

    public Integer getId() { return id; }
    public String getName() { return name; }
    public List<PmcDTO> getPmcs() { return pmcs; }
}

