package com.enes.library.service.impl;

import com.enes.library.repository.BookRepository;
import com.enes.library.repository.CategoryRepository;
import com.enes.library.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final BookRepository bookRepository;

    @Override
    public String deleteCategoryById(Long id) {
        boolean hasBooks = bookRepository.existsByCategories_Id(id);
        if (hasBooks) {
            return "Bu kategoriye ait kitap var. Bu kategori silinemedi.";
        }

        categoryRepository.deleteById(id);
        return "Kategori başarıyla silindi.";
    }
}
