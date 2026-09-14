package com.BancoSimplificado.Entity;

import com.BancoSimplificado.Enum.TipoTransacao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_transacao")
public class Transacao{

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idTransacao;
    private BigDecimal valor;
    @ManyToOne
    private Carteira origem;
    @ManyToOne
    private Carteira destino;
    private LocalDateTime data;

    //faz o Hibernate armazenar o nome no banco, em vez da posição numérica
    @Enumerated(EnumType.STRING)
    private TipoTransacao tipo;
}
