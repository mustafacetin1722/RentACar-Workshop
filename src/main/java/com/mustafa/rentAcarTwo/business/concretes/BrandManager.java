package com.mustafa.rentAcarTwo.business.concretes;

import com.mustafa.rentAcarTwo.business.abstracts.BrandService;
import com.mustafa.rentAcarTwo.business.requests.CreateBrandRequest;
import com.mustafa.rentAcarTwo.business.requests.UpdateBrandRequest;
import com.mustafa.rentAcarTwo.business.responses.GetAllBrandResponse;
import com.mustafa.rentAcarTwo.business.responses.GetByIdBrandResponse;
import com.mustafa.rentAcarTwo.business.rules.BrandBusinessRules;
import com.mustafa.rentAcarTwo.core.utilities.mappers.ModelMapperService;
import com.mustafa.rentAcarTwo.dataAccess.abstracts.BrandRepository;
import com.mustafa.rentAcarTwo.entities.concretes.Brand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BrandManager implements BrandService {
    private BrandRepository brandRepository;
    private ModelMapperService modelMapperService;
    private BrandBusinessRules brandBusinessRules;

    @Override
    public List<GetAllBrandResponse> getAll() {
        List<Brand> brands = brandRepository.findAll();
        List<GetAllBrandResponse> brandsResponse =
                brands.stream().map(brand -> this.modelMapperService.forResponse()
                        .map(brand,GetAllBrandResponse.class)).collect(Collectors.toList());
        return brandsResponse;
    }

    @Override
    public GetByIdBrandResponse getByIdResponse(int id) {
        Brand brand = this.brandRepository.findById(id).orElseThrow();
        GetByIdBrandResponse getByIdBrandResponse =
                this.modelMapperService.forResponse().map(brand,GetByIdBrandResponse.class);
        return getByIdBrandResponse;
    }

    @Override
    public void add(CreateBrandRequest createBrandRequest) {
        this.brandBusinessRules.checkIfBrandNameExists(createBrandRequest.getName());

        Brand brand = this.modelMapperService.forRequest().map(createBrandRequest,Brand.class);
        this.brandRepository.save(brand);
    }

    @Override
    public void update(UpdateBrandRequest updateBrandRequest) {
        Brand brand = this.modelMapperService.forRequest().map(updateBrandRequest,Brand.class);
        this.brandRepository.save(brand);
    }

    @Override
    public void delete(int id) {
        this.brandRepository.deleteById(id);
    }
}
