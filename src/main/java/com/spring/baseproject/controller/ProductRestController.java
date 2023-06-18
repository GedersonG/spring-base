package com.spring.baseproject.controller;

import com.spring.baseproject.dto.request.ProductRequestDto;
import com.spring.baseproject.dto.request.ProductUpdateRequestDto;
import com.spring.baseproject.dto.response.ProductResponseDto;
import com.spring.baseproject.service.IProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductRestController {

    private final IProductService productService;

    @Operation(summary = "Agregar un nuevo producto")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Product creado", content = @Content),
            @ApiResponse(responseCode = "400", description = "Datos incorrectos", content = @Content),
            @ApiResponse(responseCode = "409", description = "Producto ya existe", content = @Content)
    })
    @PostMapping()
    public ResponseEntity<Void> saveProduct(@Valid @RequestBody ProductRequestDto productRequestDto) {
        productService.saveProduct(productRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Operation(summary = "Obtener todos los productos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Todos los productos retornados",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = ProductResponseDto.class)))),
            @ApiResponse(responseCode = "404", description = "No se encontraron datos", content = @Content)
    })
    @GetMapping()
    public ResponseEntity<List<ProductResponseDto>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @Operation(summary = "Obtener producto por id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Producto retornado",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProductResponseDto.class))),
            @ApiResponse(responseCode = "404", description = "No se encontraron datos", content = @Content)
    })
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDto> getProductById(@PathVariable("id") long id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @Operation(summary = "Borra un producto")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Product eliminado", content = @Content),
            @ApiResponse(responseCode = "404", description = "Product no existe", content = @Content)
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductById(@PathVariable("id") long id) {
        productService.deleteProductById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Operation(summary = "Actualiza a un producto")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Product actualizado", content = @Content),
            @ApiResponse(responseCode = "404", description = "Product no existe", content = @Content)
    })
    @PatchMapping("/update/{id}")
    public ResponseEntity<Void> updateProductById(
            @PathVariable("id") long id,
            @Valid @RequestBody ProductUpdateRequestDto productUpdateRequestDto
    ) {
        productService.updateProductById(id, productUpdateRequestDto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
