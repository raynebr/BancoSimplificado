package com.BancoSimplificado.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_Lojista")
public class Lojista extends Usuario {
    @Column(unique = true)
    private String cnpj;
    private String nomeLoja;
}
