package com.mustafa.rentAcarTwo.business.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateModelRequest {
    @NotNull
    @NotBlank
    @Size(min = 3,max = 20)
    private String name;
    @NotBlank
    @NotBlank
    private int brandId;
}
