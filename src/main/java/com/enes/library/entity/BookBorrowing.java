package com.enes.library.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "book_borrowings")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookBorrowing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String borrowerName;

    private LocalDate borrowingDate;

    private LocalDate returnDate;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;
}
