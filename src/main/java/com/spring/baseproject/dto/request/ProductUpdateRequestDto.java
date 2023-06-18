package com.spring.baseproject.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProductUpdateRequestDto {

    @Size(min = 1, max = 50, message = "El nombre debe tener entre 1 y 50 caracteres.")
    private String name;

    private String description;

    @Min(value = 1, message = "El precio minimo debe ser 0.")
    @Max(value = 10000000, message = "El precio máxmimo admitido es de 10000000.")
    private int price;

    @Min(value = 1, message = "Debe agregar mínimo 1 producto al stock.")
    private int stock;
}
