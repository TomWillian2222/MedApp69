package com.MedApp.historico2.Repository;

import com.MedApp.historico2.Model.M_Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface R_Usuario extends JpaRepository <M_Usuario,Long> {
    @Query(value="SELECT * FROM cadastro WHERE CPF = :CPF and " +
            "senha = :senha", nativeQuery = true)
    M_Usuario buscarPorCpfSenha (@Param("CPF") Long CPF,
                                       @Param("senha") String senha);

}
