package com.example.bookshop.dto.book;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import lombok.Data;
import org.hibernate.validator.constraints.ISBN;

@Data
public class CreateBookRequestDto {
    @NotBlank
    @Size(min = 1, max = 100)
    private String title;
    @NotNull(message = "author value can't be null")
    private String author;
    @ISBN
    private String isbn;
    @NotNull(message = "price can`t be null")
    @Positive(message = "must be more or equals 0")
    private BigDecimal price;
    private String description;
    private String coverImage;

}
