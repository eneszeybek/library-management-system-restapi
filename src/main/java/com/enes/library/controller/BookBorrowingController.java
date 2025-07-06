package com.enes.library.controller;

import com.enes.library.dto.BookBorrowingRequestDTO;
import com.enes.library.entity.BookBorrowing;
import com.enes.library.service.BookBorrowingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/borrowings")
@RequiredArgsConstructor
public class BookBorrowingController {

    private final BookBorrowingService borrowingService;

    @GetMapping
    public ResponseEntity<List<BookBorrowing>> getAll() {
        return ResponseEntity.ok(borrowingService.getAllBorrowings());
    }

    @PostMapping
    public ResponseEntity<String> borrowBook(@RequestBody @Valid BookBorrowingRequestDTO dto) {
        String result = borrowingService.borrowBookFromDTO(dto);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/{id}/return")
    public ResponseEntity<String> returnBook(@PathVariable Long id) {
        String result = borrowingService.returnBook(id);
        return ResponseEntity.ok(result);
    }
}
