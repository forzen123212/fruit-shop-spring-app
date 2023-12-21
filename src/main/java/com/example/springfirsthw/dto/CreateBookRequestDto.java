package com.example.springfirsthw.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import lombok.Data;

@Data
public class CreateBookRequestDto {
    @Size(min = 1, max = 50)
    private String title;
    @NotNull(message = "can't be null")
    private String author;
    @NotNull(message = "can`t be null")
    @Size(min = 10, max = 13)
    private String isbn;
    @Positive(message = "must be more than 1")
    private BigDecimal price;
    private String description;
    private String coverImage;
}
