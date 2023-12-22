package com.example.springfirsthw.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import lombok.Data;
import org.hibernate.validator.constraints.ISBN;

@Data
public class CreateBookRequestDto {
    @NotBlank(message = "can't be blank")
    @Size(min = 1, max = 50)
    private String title;
    @NotBlank(message = "can't be blank!")
    private String author;
    @NotNull(message = "can`t be null")
    @ISBN(message = "wrong format of ISBN")
    private String isbn;
    @Positive(message = "must be more than 1")
    @NotBlank(message = "can`t be blank!")
    private BigDecimal price;
    private String description;
    private String coverImage;
}
