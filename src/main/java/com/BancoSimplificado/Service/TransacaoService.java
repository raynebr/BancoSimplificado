package com.BancoSimplificado.Service;

import com.BancoSimplificado.DTO.Request.DepositoRequest;
import com.BancoSimplificado.DTO.Request.SaqueRequest;
import com.BancoSimplificado.DTO.Request.TransferenciaRequest;
import com.BancoSimplificado.DTO.Response.DepositoResponse;
import com.BancoSimplificado.DTO.Response.SaqueResponse;
import com.BancoSimplificado.DTO.Response.TransferenciaResponse;
import com.BancoSimplificado.Entity.Carteira;
import com.BancoSimplificado.Entity.Transacao;
import com.BancoSimplificado.Enum.TipoTransacao;
import com.BancoSimplificado.Exceptions.ContaNaoEncontradaException;
import com.BancoSimplificado.Exceptions.ContasIguaisException;
import com.BancoSimplificado.Exceptions.SaldoInsuficienteException;
import com.BancoSimplificado.Exceptions.ValorInvalidoException;
import com.BancoSimplificado.Repository.CarteiraRepository;
import com.BancoSimplificado.Repository.TransacaoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TransacaoService {

    private final CarteiraRepository carteiraRepository;
    private final TransacaoRepository transacaoRepository;


    @Transactional
    public DepositoResponse deposito(DepositoRequest request) {

        Carteira carteira = carteiraRepository
                .findByNumeroConta(request.numeroConta())
                .orElseThrow(() ->
                        new ContaNaoEncontradaException("Conta não encontrada"));

        if (request.valor() == null ||
                request.valor().compareTo(BigDecimal.ZERO) <= 0) {

            throw new ValorInvalidoException("Valor inválido");
        }

        carteira.setSaldo(
                carteira.getSaldo().add(request.valor())
        );

        carteiraRepository.save(carteira);

        LocalDateTime data = LocalDateTime.now();

        Transacao transacao = new Transacao();

        transacao.setValor(request.valor());
        transacao.setOrigem(null);
        transacao.setDestino(carteira);
        transacao.setData(data);
        transacao.setTipo(TipoTransacao.DEPOSITO);

        transacaoRepository.save(transacao);

        return new DepositoResponse(
                request.valor(),
                carteira.getNumeroConta(),
                carteira.getUsuario().getNome(),
                carteira.getSaldo(),
                data
        );
    }


    @Transactional
    public SaqueResponse saque(SaqueRequest request) {

        Carteira carteira = carteiraRepository
                .findByNumeroConta(request.numeroConta())
                .orElseThrow(() ->
                        new ContaNaoEncontradaException("Conta não encontrada"));

        if (request.valor() == null ||
                request.valor().compareTo(BigDecimal.ZERO) <= 0) {

            throw new ValorInvalidoException("Valor inválido");
        }

        if (carteira.getSaldo().compareTo(request.valor()) < 0) {

            throw new SaldoInsuficienteException("Saldo insuficiente");
        }

        carteira.setSaldo(
                carteira.getSaldo().subtract(request.valor())
        );

        carteiraRepository.save(carteira);

        LocalDateTime data = LocalDateTime.now();

        Transacao transacao = new Transacao();

        transacao.setValor(request.valor());
        transacao.setOrigem(carteira);
        transacao.setDestino(null);
        transacao.setData(data);
        transacao.setTipo(TipoTransacao.SAQUE);

        transacaoRepository.save(transacao);

        return new SaqueResponse(
                request.valor(),
                carteira.getNumeroConta(),
                carteira.getSaldo(),
                data
        );
    }


    @Transactional
    public TransferenciaResponse transferencia(
            TransferenciaRequest request) {

        Carteira origem = carteiraRepository
                .findByNumeroConta(request.numeroContaOrigem())
                .orElseThrow(() ->
                        new ContaNaoEncontradaException(
                                "Conta de origem não encontrada"));

        Carteira destino = carteiraRepository
                .findByNumeroConta(request.numeroContaDestino())
                .orElseThrow(() ->
                        new ContaNaoEncontradaException(
                                "Conta de destino não encontrada"));

        if (request.valor() == null ||
                request.valor().compareTo(BigDecimal.ZERO) <= 0) {

            throw new ValorInvalidoException("Valor inválido");
        }

        if (origem.getId().equals(destino.getId())) {

            throw new ContasIguaisException(
                    "A conta de origem e destino devem ser diferentes");
        }

        if (origem.getSaldo().compareTo(request.valor()) < 0) {

            throw new SaldoInsuficienteException("Saldo insuficiente");
        }

        origem.setSaldo(
                origem.getSaldo().subtract(request.valor())
        );

        destino.setSaldo(
                destino.getSaldo().add(request.valor())
        );

        carteiraRepository.save(origem);
        carteiraRepository.save(destino);

        LocalDateTime data = LocalDateTime.now();

        Transacao transacao = new Transacao();

        transacao.setValor(request.valor());
        transacao.setOrigem(origem);
        transacao.setDestino(destino);
        transacao.setData(data);
        transacao.setTipo(TipoTransacao.TRANSFERENCIA);

        transacaoRepository.save(transacao);

        return new TransferenciaResponse(
                request.valor(),
                origem.getNumeroConta(),
                destino.getNumeroConta(),
                destino.getUsuario().getNome(),
                origem.getSaldo(),
                data
        );
    }
}