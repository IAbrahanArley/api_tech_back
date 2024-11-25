package br.com.alunoonline.api.repository;

import br.com.alunoonline.api.model.Auth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AuthRepository extends JpaRepository<Auth, Long> {
   // @Query("SELECT u FROM Auth u WHERE u.email = :email" )
    Auth findByEmail( String email);
}
