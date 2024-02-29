package com.mustafa.rentAcarTwo.business.rules;

import com.mustafa.rentAcarTwo.core.utilities.exceptions.BusinessException;
import com.mustafa.rentAcarTwo.dataAccess.abstracts.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BrandBusinessRules {
    private BrandRepository brandRepository;
    public void checkIfBrandNameExists(String name){
        if (this.brandRepository.existsByName(name)){
            throw new BusinessException("Brand name already exists.");
        }
    }
}
