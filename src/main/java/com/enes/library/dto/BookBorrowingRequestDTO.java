package com.enes.library.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class BookBorrowingRequestDTO {

    @NotBlank(message = "borrowerName boş olamaz.")
    private String borrowerName;

    @NotNull(message = "bookId boş olamaz.")
    @Min(value = 1, message = "bookId en az 1 olmalıdır.")
    private Long bookId;
}
