package com.examples.dev.librarymanagementsystem.repository;

import com.examples.dev.librarymanagementsystem.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {

}
