package com.BancoSimplificado.Service;

import com.BancoSimplificado.DTO.Request.LojistaRequest;
import com.BancoSimplificado.DTO.Request.PessoaFisicaRequest;
import com.BancoSimplificado.Entity.Lojista;
import com.BancoSimplificado.Entity.PessoaFisica;
import com.BancoSimplificado.Entity.Usuario;
import com.BancoSimplificado.Exceptions.CnpjJaCadastradoException;
import com.BancoSimplificado.Exceptions.CpfJaCadastradoException;
import com.BancoSimplificado.Exceptions.EmailJaCadastradoException;
import com.BancoSimplificado.Repository.LojistaRepository;
import com.BancoSimplificado.Repository.PessoaFisicaRepository;
import com.BancoSimplificado.Repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PessoaFisicaRepository pessoaFisicaRepository;
    private final LojistaRepository lojistaRepository;
    private final CarteiraService carteiraService;


    public PessoaFisica criarPessoaFisica(PessoaFisicaRequest request) {

        Optional<Usuario> usuarioEmail =
                usuarioRepository.findByEmail(request.email());

        if (usuarioEmail.isPresent()) {
            throw new EmailJaCadastradoException("Email já cadastrado");
        }

        Optional<PessoaFisica> pessoaCpf =
                pessoaFisicaRepository.findByCpf(request.cpf());

        if (pessoaCpf.isPresent()) {
            throw new CpfJaCadastradoException("CPF já cadastrado");
        }

        PessoaFisica pessoaFisica = new PessoaFisica();

        pessoaFisica.setNome(request.nome());
        pessoaFisica.setEmail(request.email());
        pessoaFisica.setSenha(request.senha());
        pessoaFisica.setCpf(request.cpf());

        PessoaFisica pessoaSalva =
                pessoaFisicaRepository.save(pessoaFisica);

        carteiraService.criarCarteiraParaUsuario(pessoaSalva);

        return pessoaSalva;
    }


    public Lojista criarLojista(LojistaRequest request) {

        Optional<Usuario> usuarioEmail =
                usuarioRepository.findByEmail(request.email());

        if (usuarioEmail.isPresent()) {
            throw new EmailJaCadastradoException("Email já cadastrado");
        }

        Optional<Lojista> lojistaCnpj =
                lojistaRepository.findByCnpj(request.cnpj());

        if (lojistaCnpj.isPresent()) {
            throw new CnpjJaCadastradoException("CNPJ já cadastrado");
        }

        Lojista lojista = new Lojista();

        lojista.setNome(request.nome());
        lojista.setEmail(request.email());
        lojista.setSenha(request.senha());
        lojista.setCnpj(request.cnpj());
        lojista.setNomeLoja(request.nomeLoja());

        Lojista lojistaSalvo =
                lojistaRepository.save(lojista);

        carteiraService.criarCarteiraParaUsuario(lojistaSalvo);

        return lojistaSalvo;
    }
}