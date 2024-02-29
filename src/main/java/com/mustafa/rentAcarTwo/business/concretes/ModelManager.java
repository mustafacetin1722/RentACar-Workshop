package com.mustafa.rentAcarTwo.business.concretes;

import com.mustafa.rentAcarTwo.business.abstracts.ModelService;
import com.mustafa.rentAcarTwo.business.requests.CreateModelRequest;
import com.mustafa.rentAcarTwo.business.responses.GetAllModelResponse;
import com.mustafa.rentAcarTwo.core.utilities.mappers.ModelMapperService;
import com.mustafa.rentAcarTwo.dataAccess.abstracts.ModelRepository;
import com.mustafa.rentAcarTwo.entities.concretes.Model;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {

    private ModelRepository modelRepository;
    private ModelMapperService modelMapperService;

    @Override
    public List<GetAllModelResponse> getAll() {
        List<Model> models = modelRepository.findAll();
        List<GetAllModelResponse> modelRespons =
        models.stream().map(model -> this.modelMapperService.forResponse()
                .map(model,GetAllModelResponse.class)).collect(Collectors.toList());
        return modelRespons;
    }

    @Override
    public void add(CreateModelRequest createModelRequest) {
        Model model = this.modelMapperService.forRequest().map(createModelRequest,Model.class);
        this.modelRepository.save(model);
    }
}
