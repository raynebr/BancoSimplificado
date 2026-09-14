package com.BancoSimplificado.Service;

import com.BancoSimplificado.DTO.Request.PessoaFisicaRequest;
import com.BancoSimplificado.Entity.PessoaFisica;
import com.BancoSimplificado.Entity.Usuario;
import com.BancoSimplificado.Exceptions.CpfJaCadastradoException;
import com.BancoSimplificado.Exceptions.EmailJaCadastradoException;
import com.BancoSimplificado.Repository.CarteiraRepository;
import com.BancoSimplificado.Repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final CarteiraRepository carteiraRepository;


    public PessoaFisica criarPessoaFisica(PessoaFisicaRequest request) {
        Optional<Usuario> pessoafisica = usuarioRepository.findByEmail(request.email());

        if (pessoafisica.isPresent()) {
            throw new EmailJaCadastradoException("Email já cadastrado");
        }

        Optional<PessoaFisica> pessoafisicaCpf = usuarioRepository.findByCpf(request.cpf());

        if (pessoafisicaCpf.isPresent()){
            throw new CpfJaCadastradoException("Cpf ja Cadastrado");


        }
        return new PessoaFisica();
    }
}