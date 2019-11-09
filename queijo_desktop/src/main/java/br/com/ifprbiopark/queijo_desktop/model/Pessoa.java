
package br.com.ifprbiopark.queijo_desktop.model;


public class Pessoa {
    
    private Integer idPessoa;
    private String nome;
    private String endereco;
    private int pessoaFisica;
    private String cadastro;

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
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

    public int getPessoaFisica() {
        return pessoaFisica;
    }

    public void setPessoaFisica(int pessoaFisica) {
        this.pessoaFisica = pessoaFisica;
    }

    public String getCadastro() {
        return cadastro;
    }

    public void setCadastro(String cadastro) {
        this.cadastro = cadastro;
    }
    
    
    
    
}
