package service;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dto.PessoaDTO;
import entity.Pessoa;
import entity.PessoaFisica;
import entity.PessoaJuridica;
import repository.PessoaRepository;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public Pessoa cadastrarPessoa(PessoaDTO dto) {
        if ("FISICA".equalsIgnoreCase(dto.getTipo())) {
            PessoaFisica pessoa = new PessoaFisica();
            pessoa.setNome(dto.getNome());
            pessoa.setEmail(dto.getEmail());
            pessoa.setCpf(dto.getCpf());
            return pessoaRepository.save(pessoa);
        } else if ("JURIDICA".equalsIgnoreCase(dto.getTipo())) {
            PessoaJuridica pessoa = new PessoaJuridica();
            pessoa.setNome(dto.getNome());
            pessoa.setEmail(dto.getEmail());
            pessoa.setCnpj(dto.getCnpj());
            return pessoaRepository.save(pessoa);
        }
        throw new IllegalArgumentException("Tipo de pessoa inválido.");
    }

    public List<PessoaDTO> listarPessoas() {
        return pessoaRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
    
    public PessoaDTO buscarPessoaPorId(Long id) {
        Pessoa pessoa = pessoaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));
        return convertToDto(pessoa);
    }

    private PessoaDTO convertToDto(Pessoa pessoa) {
        PessoaDTO dto = new PessoaDTO();
        dto.setId(pessoa.getId());
        dto.setNome(pessoa.getNome());
        dto.setEmail(pessoa.getEmail());
        dto.setTelefone(pessoa.getTelefone());
        dto.setCep(pessoa.getCep()); 

        return dto;
    }
}