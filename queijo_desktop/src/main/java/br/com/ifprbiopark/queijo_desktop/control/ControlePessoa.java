package br.com.ifprbiopark.queijo_desktop.control;

import br.com.ifprbiopark.queijo_desktop.dao.PessoaDao;
import br.com.ifprbiopark.queijo_desktop.exception.PessoaException;
import br.com.ifprbiopark.queijo_desktop.exception.RequiredFieldException;
import br.com.ifprbiopark.queijo_desktop.exception.UniqueRegisterException;
import br.com.ifprbiopark.queijo_desktop.exception.db.DbException;
import br.com.ifprbiopark.queijo_desktop.model.Pessoa;
import com.google.common.base.Strings;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControlePessoa {
    
    PessoaDao dao;

    private static final int[] PESO_CPF = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};
    private static final int[] PESO_CNPJ = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};

    public ControlePessoa() {
        try {
            this.dao = new PessoaDao();
        } catch (DbException ex) {
            Logger.getLogger(ControlePessoa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private enum TipoPessoa {
        FUNC("Funcionário"), 
        FORN("Fornecedor");
        private String nomenclatura;
        private TipoPessoa(String nome) {
            this.nomenclatura = nome;
        }
       
        @Override
        public String toString(){
            return nomenclatura;
        }
        
        public static String toWord(){
            
            String t = "";
            TipoPessoa[] tipos = TipoPessoa.values(); 
            for (TipoPessoa i : tipos) {
                t += i.nomenclatura;
                t += "/";
            }
            return t.substring(0, t.length()-1);
        }
    } 

    public void salvar(Pessoa p) throws PessoaException {
        

        if (Strings.isNullOrEmpty(p.getNome())) {
            throw new PessoaException(new RequiredFieldException("Nome"));
        }
        
        if (Strings.isNullOrEmpty(p.getTipoFiscal())) {
            throw new PessoaException(new RequiredFieldException("Tipo Fiscal(CPF/CNPJ)"));
        }
        
        if (Strings.isNullOrEmpty(p.getDocumento())) {
            throw new PessoaException(new RequiredFieldException("Documento"));
        }
        
        if (Strings.isNullOrEmpty(p.getTipoPessoa())) {
            throw new PessoaException(new RequiredFieldException("Tipo de Pessoa("+TipoPessoa.toWord()+")"));
        }
        
        if (Strings.isNullOrEmpty(p.getEndereco())) {
            p.setEndereco("");
            //throw new PessoaException(new RequiredFieldException("Endereço"));
        }

        if ("0".equals(p.getTipoFiscal())) {
            if (!isValidCPF(p.getDocumento().replace(".", "").replace("-", ""))) {
                throw new PessoaException("CPF não válido.");
            }
        } else if ("1".equals(p.getTipoFiscal())) {
            if (!isValidCNPJ(p.getDocumento().replace(".", "").replace("-", "").replace("/", ""))) {
                throw new PessoaException("CNPJ não válido.");
            }
        }
        
        try {

            if (p.getIdPessoa() == 0) {
                Pessoa consulta = dao.consultarPorDocumento(p.getDocumento());
                if(consulta != null){
                    throw new PessoaException(new UniqueRegisterException(p.getDocumento()));
                }
                dao.inserir(p);
            } else {
                dao.alterar(p);
            }

        } catch (PessoaException | DbException ex) {
            throw new PessoaException(ex);
        }

    }

    public Pessoa consultar(int id) throws Exception {
        try {
            PessoaDao p = new PessoaDao();
            return p.consultar(id);
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    private static int calcularDigito(String str, int[] peso) {
        int soma = 0;
        for (int indice = str.length() - 1, digito; indice >= 0; indice--) {
            digito = Integer.parseInt(str.substring(indice, indice + 1));
            soma += digito * peso[peso.length - str.length() + indice];
        }
        soma = 11 - soma % 11;
        return soma > 9 ? 0 : soma;
    }

    public static boolean isValidCPF(String cpf) {
        if ((cpf == null) || (cpf.length() != 11)) {
            return false;
        }

        Integer digito1 = calcularDigito(cpf.substring(0, 9), PESO_CPF);
        Integer digito2 = calcularDigito(cpf.substring(0, 9) + digito1, PESO_CPF);
        return cpf.equals(cpf.substring(0, 9) + digito1.toString() + digito2.toString());
    }

    public static boolean isValidCNPJ(String cnpj) {
        if ((cnpj == null) || (cnpj.length() != 14)) {
            return false;
        }

        Integer digito1 = calcularDigito(cnpj.substring(0, 12), PESO_CNPJ);
        Integer digito2 = calcularDigito(cnpj.substring(0, 12) + digito1, PESO_CNPJ);
        return cnpj.equals(cnpj.substring(0, 12) + digito1.toString() + digito2.toString());
    }

    public List<Pessoa> consultar(int id, String nome, String tipo) throws Exception {
        try {
            PessoaDao p = new PessoaDao();
            List<Pessoa> lista = new ArrayList<Pessoa>();
            if (id != 0) {
                lista.add(p.consultar(id));
            } else if (!Strings.isNullOrEmpty(nome) || !Strings.isNullOrEmpty(tipo)) {
                lista = p.consultar(nome, tipo);
            } else {
                lista = p.consultar();
            }
            return lista;
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    public List<Pessoa> listaFuncionarios() throws DbException {
        PessoaDao p = new PessoaDao();
        return p.consultarFuncionarios();
    }

}
