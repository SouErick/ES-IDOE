package controller;

import dto.DoacaoDTO;
import entity.Doacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.DoacaoService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/doacoes")
public class DoacaoController {

    @Autowired
    private DoacaoService doacaoService;

    @PostMapping
    public ResponseEntity<Doacao> criarPedidoDoacao(@RequestBody DoacaoDTO doacaoDTO) {
        Doacao novaDoacao = doacaoService.registrarDoacao(doacaoDTO);
        return new ResponseEntity<>(novaDoacao, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<DoacaoDTO>> obterDoacoes() {
        List<DoacaoDTO> doacoes = doacaoService.listarDoacoes();
        return ResponseEntity.ok(doacoes);
    }

    @PostMapping("/{id}/contribuir")
    public ResponseEntity<?> contribuir(@PathVariable("id") int doacaoId) {
        String qrCodeData = doacaoService.processarContribuicao(doacaoId);
        return ResponseEntity.ok(Map.of("qrCodeData", qrCodeData));
    }
    
    
}