package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {

}
