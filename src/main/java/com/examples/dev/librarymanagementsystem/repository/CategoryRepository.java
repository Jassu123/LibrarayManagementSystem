package com.examples.dev.librarymanagementsystem.repository;

import com.examples.dev.librarymanagementsystem.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
