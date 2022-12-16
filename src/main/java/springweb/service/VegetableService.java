package springweb.service;

import springweb.dto.VegetableDto;

import java.util.List;

public interface VegetableService {
    List<VegetableDto> findAll();
    List<VegetableDto> search(String term);
}
