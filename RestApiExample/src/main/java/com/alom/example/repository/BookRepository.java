package com.alom.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alom.example.model.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
