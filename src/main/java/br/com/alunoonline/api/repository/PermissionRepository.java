package br.com.alunoonline.api.repository;

import br.com.alunoonline.api.model.Aluno;
import br.com.alunoonline.api.model.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long> {
    Permission findByDescription(@Param("description") String description);

}
