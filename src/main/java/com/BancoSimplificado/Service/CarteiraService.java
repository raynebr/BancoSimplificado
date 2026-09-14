package com.BancoSimplificado.Service;

import com.BancoSimplificado.Entity.Carteira;
import com.BancoSimplificado.Entity.Usuario;
import com.BancoSimplificado.Repository.CarteiraRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CarteiraService {

    private final CarteiraRepository carteiraRepository;

    public CarteiraService(CarteiraRepository carteiraRepository) {
        this.carteiraRepository = carteiraRepository;
    }

    @Transactional
    public Carteira criarCarteiraParaUsuario(Usuario usuario) {

        Carteira carteira = new Carteira();

        carteira.setSaldo(BigDecimal.ZERO);

        carteira.setNumeroConta(gerarNumeroContaUnico());

        carteira.setUsuario(usuario);

        Carteira carteiraSalva = carteiraRepository.save(carteira);

        return carteiraSalva;
    }

    private String gerarNumeroContaUnico() {
        String numeroConta;

        do {
            numeroConta = String.valueOf(
                    (long) (Math.random() * 90000000L) + 10000000L
            );
        } while (carteiraRepository.existsByNumeroConta(numeroConta));

        return numeroConta;
    }
}