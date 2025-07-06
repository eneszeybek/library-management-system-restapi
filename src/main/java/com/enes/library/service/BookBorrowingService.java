package com.enes.library.service;

import com.enes.library.dto.BookBorrowingRequestDTO;
import com.enes.library.entity.BookBorrowing;

import java.util.List;

public interface BookBorrowingService {
    List<BookBorrowing> getAllBorrowings();
    String borrowBookFromDTO(BookBorrowingRequestDTO dto);
    String returnBook(Long id);
}
