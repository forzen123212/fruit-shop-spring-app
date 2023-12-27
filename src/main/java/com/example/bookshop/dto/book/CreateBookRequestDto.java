package com.example.bookshop.dto.book;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import lombok.Data;

@Data
public class CreateBookRequestDto {
    @NotNull(message = "can't be null")
    @Size(min = 1, max = 100)
    private String title;
    @NotNull(message = "author value can't be null")
    private String author;
    @Size(min = 10, max = 13)
    private String isbn;
    @NotNull(message = "price can`t be null")
    @Positive(message = "must be more or equals 0")
    private BigDecimal price;
    private String description;
    private String coverImage;

}
