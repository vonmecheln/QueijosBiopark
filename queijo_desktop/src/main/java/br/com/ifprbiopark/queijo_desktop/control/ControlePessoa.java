package br.com.ifprbiopark.queijo_desktop.control;

import br.com.ifprbiopark.queijo_desktop.dao.PessoaDao;
import br.com.ifprbiopark.queijo_desktop.exception.PessoaException;
import br.com.ifprbiopark.queijo_desktop.exception.RequiredFieldException;
import br.com.ifprbiopark.queijo_desktop.model.Pessoa;

public class ControlePessoa {

        private static final int[] pesoCPF = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};
        private static final int[] pesoCNPJ = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
        
    public void salvar(Pessoa p) throws PessoaException, Exception {       
        if (p.getTipoFiscal() == "0"){            
            if(!isValidCPF(p.getCadastro().replace(".", "").replace("-", ""))){
                throw new Exception("CPF não válido.");
            }
        }
        else if (p.getTipoFiscal() == "1"){
            if(!isValidCNPJ(p.getCadastro().replace(".", "").replace("-", "").replace("/", ""))){
                throw new Exception("CNPJ não válido.");
            }
        }        

        if (p.getNome().trim().isEmpty()) {
            throw new PessoaException(new RequiredFieldException("nome"));
        }

        PessoaDao dao = new PessoaDao();

        try {

            if (p.getIdPessoa() == 0) {
                // TODO: #466                
                dao.inserir(p);
            } else {
                dao.alterar(p);
            }

        } catch (Exception ex) {
            throw new PessoaException(ex);
        }
        
    }
    
    public Pessoa consultar(int id) throws Exception{
        try {
            PessoaDao p = new PessoaDao();
            return p.consultar(id);            
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }
    
    private static int calcularDigito(String str, int[] peso) {
      int soma = 0;
      for (int indice=str.length()-1, digito; indice >= 0; indice-- ) {
         digito = Integer.parseInt(str.substring(indice,indice+1));
         soma += digito*peso[peso.length-str.length()+indice];
      }
      soma = 11 - soma % 11;
      return soma > 9 ? 0 : soma;
   }

   public static boolean isValidCPF(String cpf) {
      if ((cpf==null) || (cpf.length()!=11)) return false;

      Integer digito1 = calcularDigito(cpf.substring(0,9), pesoCPF);
      Integer digito2 = calcularDigito(cpf.substring(0,9) + digito1, pesoCPF);
      return cpf.equals(cpf.substring(0,9) + digito1.toString() + digito2.toString());
   }

   public static boolean isValidCNPJ(String cnpj) {
      if ((cnpj==null)||(cnpj.length()!=14)) return false;

      Integer digito1 = calcularDigito(cnpj.substring(0,12), pesoCNPJ);
      Integer digito2 = calcularDigito(cnpj.substring(0,12) + digito1, pesoCNPJ);
      return cnpj.equals(cnpj.substring(0,12) + digito1.toString() + digito2.toString());
   }
}
