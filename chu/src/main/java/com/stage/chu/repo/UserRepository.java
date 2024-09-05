package com.stage.chu.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stage.chu.entities.Utilisateur;

@Repository
public interface UserRepository extends JpaRepository<Utilisateur , Long> {
  
}