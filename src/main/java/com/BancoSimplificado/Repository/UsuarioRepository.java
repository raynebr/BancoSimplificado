package com.BancoSimplificado.Repository;

import com.BancoSimplificado.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {
    // Você não precisa escrever nada aqui dentro para ter as operações básicas (salvar, deletar, buscar).
}