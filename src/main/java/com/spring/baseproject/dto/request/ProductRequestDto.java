package com.spring.baseproject.dto.request;

import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProductRequestDto {

    @NotEmpty(message = "El nombre es obligatorio.")
    @Size(min = 1, max = 50, message = "El nombre debe tener entre 1 y 50 caracteres.")
    private String name;

    private String description;

    @NotNull(message = "El precio es obligatorio.")
    @Min(value = 1, message = "El precio minimo debe ser 1.")
    @Max(value = 10000000, message = "El precio máxmimo admitido es de 10000000.")
    private int price;

    @NotNull(message = "El stock es obligatorio.")
    @Min(value = 1, message = "Debe agregar mínimo 1 producto al stock.")
    private int stock;
}
