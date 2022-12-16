package springweb.impl;

import springweb.dto.VegetableDto;
import springweb.entity.Vegetable;
import springweb.repository.VegetableRepository;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import springweb.service.VegetableService;


public class VegetableServiceImpl implements VegetableService {
    private VegetableRepository vegetableRepository;
    public VegetableServiceImpl(VegetableRepository vegetableRepository) {
        this.vegetableRepository = vegetableRepository;
    }

    @Override
    public List<VegetableDto> findAll() {
        List<Vegetable> vegetableList = vegetableRepository.findAll();
        return toListVegetableDto(vegetableList);
    }

    private List<VegetableDto> toListVegetableDto(List<Vegetable> vegetableList) {
        return vegetableList.stream().map(this::toVegetableDto).collect(Collectors.toList());
    }

    private VegetableDto toVegetableDto(Vegetable vegetable) {
        VegetableDto vegetableDto = VegetableDto.builder().build();
        BeanUtils.copyProperties(vegetable, vegetableDto);
        return vegetableDto;
    }

    @Override
    public List<VegetableDto> search(String term) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    
}
