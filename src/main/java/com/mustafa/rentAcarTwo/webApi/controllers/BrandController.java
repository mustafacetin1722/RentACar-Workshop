package com.mustafa.rentAcarTwo.webApi.controllers;

import com.mustafa.rentAcarTwo.business.abstracts.BrandService;
import com.mustafa.rentAcarTwo.business.requests.CreateBrandRequest;
import com.mustafa.rentAcarTwo.business.requests.UpdateBrandRequest;
import com.mustafa.rentAcarTwo.business.responses.GetAllBrandResponse;
import com.mustafa.rentAcarTwo.business.responses.GetByIdBrandResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/brands")
public class BrandController {
    private BrandService brandService;
    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping
    public List<GetAllBrandResponse> getAll(){
        return brandService.getAll();
    }
    @GetMapping("/{id}")
    public GetByIdBrandResponse getByIdBrand(@PathVariable int id){
        return this.brandService.getByIdResponse(id);
    }
    @PutMapping
    public void updateBrand(@RequestBody UpdateBrandRequest updateBrandRequest){
        this.brandService.update(updateBrandRequest);
    }
    @PostMapping
    public void add(@RequestBody @Valid CreateBrandRequest createBrandRequest){
        brandService.add(createBrandRequest);
    }
    @DeleteMapping("/{id}")
    public void deleteBrand(@PathVariable int id){
        this.brandService.delete(id);
    }
}
