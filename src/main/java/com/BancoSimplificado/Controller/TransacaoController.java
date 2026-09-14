package com.BancoSimplificado.Controller;

import com.BancoSimplificado.DTO.Request.DepositoRequest;
import com.BancoSimplificado.DTO.Request.SaqueRequest;
import com.BancoSimplificado.DTO.Request.TransferenciaRequest;
import com.BancoSimplificado.DTO.Response.DepositoResponse;
import com.BancoSimplificado.DTO.Response.SaqueResponse;
import com.BancoSimplificado.DTO.Response.TransferenciaResponse;
import com.BancoSimplificado.Service.TransacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transacoes")
@RequiredArgsConstructor
public class TransacaoController {

    private final TransacaoService transacaoService;

    @PostMapping("/deposito")
    public ResponseEntity<DepositoResponse> deposito(
            @RequestBody DepositoRequest request) {

        return ResponseEntity.ok(
                transacaoService.deposito(request)
        );
    }

    @PostMapping("/saque")
    public ResponseEntity<SaqueResponse> saque(
            @RequestBody SaqueRequest request) {

        return ResponseEntity.ok(
                transacaoService.saque(request)
        );
    }

    @PostMapping("/transferencia")
    public ResponseEntity<TransferenciaResponse> transferencia(
            @RequestBody TransferenciaRequest request) {

        return ResponseEntity.ok(
                transacaoService.transferencia(request)
        );
    }
}