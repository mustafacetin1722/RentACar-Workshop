package com.mustafa.rentAcarTwo.webApi.controllers;

import com.mustafa.rentAcarTwo.business.abstracts.ModelService;
import com.mustafa.rentAcarTwo.business.requests.CreateModelRequest;
import com.mustafa.rentAcarTwo.business.responses.GetAllModelResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/models")
public class ModelController {
    private ModelService modelService;

    public ModelController(ModelService modelService) {
        this.modelService = modelService;
    }
    @GetMapping
    public List<GetAllModelResponse> getAll(){
        return this.modelService.getAll();
    }
    @PostMapping
    public void add(@RequestBody @Valid CreateModelRequest  createModelRequest){
        this.modelService.add(createModelRequest);
    }
}
