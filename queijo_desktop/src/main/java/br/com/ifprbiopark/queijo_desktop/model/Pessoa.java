
package br.com.ifprbiopark.queijo_desktop.model;


public class Pessoa {
    
    private Integer idPessoa;
    private String nome;
    private String endereco;    
    private String tipoFiscal;
    private String cadastro;
    private String tipoPessoa;

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

    public String getCadastro() {
        return cadastro;
    }

    public void setCadastro(String cadastro) {
        this.cadastro = cadastro;
    }

    public String getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(String tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }
    
    
}
