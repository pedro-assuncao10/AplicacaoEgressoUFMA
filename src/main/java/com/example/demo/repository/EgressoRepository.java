package com.example.demo.repository;

import com.example.demo.model.Egresso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

@Repository
public interface EgressoRepository extends JpaRepository<Egresso, Integer> {
    // Consulta para buscar egressos pelo nome (contém uma string)
    @Query("SELECT e FROM Egresso e WHERE e.nome LIKE %:nome%")
    List<Egresso> findByNomeContaining(@Param("nome") String nome);

    // Consulta para buscar egresso pelo email
    @Query("SELECT e FROM Egresso e WHERE e.email = :email")
    Egresso findByEmail(@Param("email") String email);

    // Consulta para buscar egressos com um LinkedIn associado
    @Query("SELECT e FROM Egresso e WHERE e.linkedin IS NOT NULL")
    List<Egresso> findWithLinkedin();

    // Consulta para buscar egressos com currículo disponível
    @Query("SELECT e FROM Egresso e WHERE e.curriculo IS NOT NULL")
    List<Egresso> findWithCurriculo();

    //------------------------------------------------------------------


}
