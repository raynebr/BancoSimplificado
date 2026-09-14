package com.BancoSimplificado.Controller;

import com.BancoSimplificado.DTO.Request.LojistaRequest;
import com.BancoSimplificado.DTO.Request.PessoaFisicaRequest;
import com.BancoSimplificado.Entity.Lojista;
import com.BancoSimplificado.Entity.PessoaFisica;
import com.BancoSimplificado.Service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping("/pessoa-fisica")
    public ResponseEntity<PessoaFisica> criarPessoaFisica(
            @RequestBody PessoaFisicaRequest request) {

        PessoaFisica pessoaFisica =
                usuarioService.criarPessoaFisica(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(pessoaFisica);
    }

    @PostMapping("/lojista")
    public ResponseEntity<Lojista> criarLojista(
            @RequestBody LojistaRequest request) {

        Lojista lojista =
                usuarioService.criarLojista(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(lojista);
    }
}