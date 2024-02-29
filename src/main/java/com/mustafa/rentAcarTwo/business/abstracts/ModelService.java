package com.mustafa.rentAcarTwo.business.abstracts;

import com.mustafa.rentAcarTwo.business.requests.CreateModelRequest;
import com.mustafa.rentAcarTwo.business.responses.GetAllModelResponse;

import java.util.List;

public interface ModelService {
    List<GetAllModelResponse> getAll();
    void add(CreateModelRequest createModelRequest);
}
