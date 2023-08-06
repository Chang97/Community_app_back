package com.board.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.board.back.model.File;

public interface FileRepository extends JpaRepository<File, Long>{

}
