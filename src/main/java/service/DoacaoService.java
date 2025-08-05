package service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dto.DoacaoDTO;
import entity.Doacao;
import entity.PessoaJuridica;
import repository.DoacaoRepository;
import repository.PessoaRepository;

@Service
public class DoacaoService {

    @Autowired
    private DoacaoRepository doacaoRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    public Doacao registrarDoacao(DoacaoDTO dto) {
        PessoaJuridica empresa = (PessoaJuridica) pessoaRepository.findById(dto.getEmpresaId())
                .orElseThrow(() -> new RuntimeException("Empresa não encontrada"));

        Doacao doacao = new Doacao();
        doacao.setTitulo(dto.getTitulo());
        doacao.setValor(dto.getValor());
        doacao.setData(dto.getData());  
        doacao.setEspecificacao(dto.getEspecificacao());
        doacao.setEmpresa(empresa);

        return doacaoRepository.save(doacao);
    }

    public List<DoacaoDTO> listarDoacoes() {
        return doacaoRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
    
    public String processarContribuicao(int doacaoId) {
        Doacao doacao = doacaoRepository.findById(doacaoId)
            .orElseThrow(() -> new RuntimeException("Doação não encontrada"));
        return "QRCodeData[ID_DOACAO:" + doacao.getId() + ";VALOR:" + doacao.getValor() + "]";
    }

    private DoacaoDTO convertToDto(Doacao doacao) {
        DoacaoDTO dto = new DoacaoDTO();
        dto.setId(doacao.getId());
        dto.setTitulo(doacao.getTitulo());
        dto.setEspecificacao(doacao.getEspecificacao());
        dto.setValor(doacao.getValor());
        dto.setData(new java.sql.Date(doacao.getData().getTime()));

        if (doacao.getEmpresa() != null) {
            dto.setEmpresaId(doacao.getEmpresa().getId());
        }

        return dto;
    }
}