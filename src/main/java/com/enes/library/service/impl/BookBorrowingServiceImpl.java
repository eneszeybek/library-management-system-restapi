package com.enes.library.service.impl;

import com.enes.library.dto.BookBorrowingRequestDTO;
import com.enes.library.entity.Book;
import com.enes.library.entity.BookBorrowing;
import com.enes.library.repository.BookBorrowingRepository;
import com.enes.library.repository.BookRepository;
import com.enes.library.service.BookBorrowingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookBorrowingServiceImpl implements BookBorrowingService {

    private final BookBorrowingRepository borrowingRepository;
    private final BookRepository bookRepository;

    @Override
    public List<BookBorrowing> getAllBorrowings() {
        return borrowingRepository.findAll();
    }

    @Override
    public String borrowBookFromDTO(BookBorrowingRequestDTO dto) {
        Book book = bookRepository.findById(dto.getBookId())
                .orElseThrow(() -> new RuntimeException("Kitap bulunamadı."));

        if (book.getStock() <= 0) {
            return "Stokta kitap kalmadığı için ödünç verilemez.";
        }

        book.setStock(book.getStock() - 1);
        bookRepository.save(book);

        BookBorrowing borrowing = new BookBorrowing();
        borrowing.setBook(book);
        borrowing.setBorrowerName(dto.getBorrowerName());
        borrowing.setBorrowingDate(LocalDate.now());

        borrowingRepository.save(borrowing);

        return "Kitap başarıyla ödünç verildi.";
    }

    @Override
    public String returnBook(Long id) {
        BookBorrowing borrowing = borrowingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Kayıt bulunamadı."));

        if (borrowing.getReturnDate() != null) {
            return "Bu kitap zaten iade edilmiş.";
        }

        borrowing.setReturnDate(LocalDate.now());
        borrowingRepository.save(borrowing);

        Book book = borrowing.getBook();
        book.setStock(book.getStock() + 1);
        bookRepository.save(book);

        return "Kitap başarıyla iade edildi.";
    }
}
