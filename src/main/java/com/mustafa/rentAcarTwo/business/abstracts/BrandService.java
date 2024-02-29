package com.mustafa.rentAcarTwo.business.abstracts;

import com.mustafa.rentAcarTwo.business.requests.CreateBrandRequest;
import com.mustafa.rentAcarTwo.business.requests.UpdateBrandRequest;
import com.mustafa.rentAcarTwo.business.responses.GetAllBrandResponse;
import com.mustafa.rentAcarTwo.business.responses.GetByIdBrandResponse;
import com.mustafa.rentAcarTwo.entities.concretes.Brand;

import java.util.List;

public interface BrandService {
    List<GetAllBrandResponse> getAll();
    GetByIdBrandResponse getByIdResponse(int id);
    void add(CreateBrandRequest createBrandRequest);
    void update(UpdateBrandRequest updateBrandRequest);
    void delete(int id);
}
