package br.com.alunoonline.api.repository;

import br.com.alunoonline.api.model.Employee;
import br.com.alunoonline.api.model.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("SELECT u FROM Employee u WHERE u.email = :email" )
    Employee findByUsername(@Param("email") String email);
}
