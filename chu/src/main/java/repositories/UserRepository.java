package repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stage.chu.entities.Utilisateur;

public interface UserRepository extends JpaRepository<Utilisateur , Long> {
  
}
