package entity;

public class QrCode implements FormaPagamento {
    private String codigo; 
    private String dadosQrGerado; 

    public QrCode(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public String gerarIdentificadorPagamento(Doacao doacao) {

        String informacaoParaQr = "ID_DOACAO:" + doacao.getId() + ";VALOR:" + doacao.getValor() + "EMPRESA_ID:" + (doacao.getEmpresa() != null ? doacao.getEmpresa().getId() : "N/A");
        this.dadosQrGerado = "QRCodeData[" + informacaoParaQr + "]"; 
        System.out.println("QR Code gerado para Doacao ID " + doacao.getId() + ": " + this.dadosQrGerado);
        return this.dadosQrGerado; 
    }

    @Override
    public boolean validarPagamento() {
        System.out.println("Método validarPagamento() para QrCode chamado.");
        return true;
    }

    @Override
    public String getCodigo() {
        return codigo;
    }

    public String getDadosQrGerado() {
        return dadosQrGerado;
    }


}