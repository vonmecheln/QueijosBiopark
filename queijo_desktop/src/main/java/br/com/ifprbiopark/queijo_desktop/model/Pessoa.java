
package br.com.ifprbiopark.queijo_desktop.model;


public class Pessoa {
    
    private Integer idPessoa;
    private String nome;
    private String endereco;    
    private String tipoFiscal;
    private String documento;
    private String tipoPessoa;
    private String telefone;

    public Pessoa() {
        idPessoa = 0;
    }

    
    public Integer getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTipoFiscal() {
        return tipoFiscal;
    }

    public void setTipoFiscal(String tipoFiscal) {
        this.tipoFiscal = tipoFiscal;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(String tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    
}
