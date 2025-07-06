package com.enes.library.repository;

import com.enes.library.entity.BookBorrowing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookBorrowingRepository extends JpaRepository<BookBorrowing, Long> {
}
