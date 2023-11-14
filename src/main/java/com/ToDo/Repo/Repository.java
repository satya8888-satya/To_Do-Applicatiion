package com.ToDo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ToDo.entity.To_Do;

public interface Repository extends JpaRepository<To_Do, Long>{

}
