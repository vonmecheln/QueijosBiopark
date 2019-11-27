package br.com.ifprbiopark.queijo_desktop.inicializacao;

import br.com.ifprbiopark.queijo_desktop.control.ControlePessoa;
import br.com.ifprbiopark.queijo_desktop.control.ControleReceitaQueijo;
import br.com.ifprbiopark.queijo_desktop.dao.PessoaDao;
import br.com.ifprbiopark.queijo_desktop.dao.ReceitaQueijoDao;
import br.com.ifprbiopark.queijo_desktop.exception.PessoaException;
import br.com.ifprbiopark.queijo_desktop.exception.ReceitaQueijoException;
import br.com.ifprbiopark.queijo_desktop.exception.db.DbException;
import br.com.ifprbiopark.queijo_desktop.model.Pessoa;
import br.com.ifprbiopark.queijo_desktop.model.ReceitaQueijo;
import br.com.ifprbiopark.queijo_desktop.view.TelaPrincipalView;
import java.util.logging.Level;
import java.util.logging.Logger;

public class QueijoDesktop {

    public static TelaPrincipalView telaPrincipal;

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        if (false) {
            Pessoa p = new Pessoa();
            p.setNome("");
            p.setEndereco("");
            p.setTipoFiscal("");
            p.setDocumento("");
            p.setTipoPessoa("");
            
            try {
                PessoaDao pd = new PessoaDao();
                pd.inserir(p);
                pd.alterar(p);
                pd.excluir(p);                                
            } catch (DbException ex) {
                Logger.getLogger(QueijoDesktop.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try {
                p = new Pessoa();
                p.setNome("-");
                p.setTipoFiscal("0");
                p.setDocumento("549.079.610-30");
                p.setTipoPessoa("Fornecedor");
                ControlePessoa cp = new ControlePessoa();
                cp.salvar(p);
                cp.salvar(p);
                
                
            } catch (PessoaException ex) {
                Logger.getLogger(QueijoDesktop.class.getName()).log(Level.SEVERE, null, ex);
            }
            

            ReceitaQueijo r = new ReceitaQueijo();
            r.setNomeTipo("");

            try {
                ReceitaQueijoDao rd = new ReceitaQueijoDao();
                rd.inserir(r);
                rd.alterar(r);
                rd.excluir(r);
            } catch (DbException ex) {
                Logger.getLogger(QueijoDesktop.class.getName()).log(Level.SEVERE, null, ex);
            }

            r = new ReceitaQueijo();
            r.setNomeTipo("--");
            ControleReceitaQueijo cr = new ControleReceitaQueijo();
            try {
                cr.salvar(r);
                cr.salvar(r);
            } catch (ReceitaQueijoException ex) {
                Logger.getLogger(QueijoDesktop.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {

            /* Set the Nimbus look and feel */
            //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
            /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
             */
            try {
                for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                    if ("Windows".equals(info.getName())) {
                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                }
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
                java.util.logging.Logger.getLogger(TelaPrincipalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            //</editor-fold>

            /* Create and display the form */
            java.awt.EventQueue.invokeLater(() -> {
                telaPrincipal = new TelaPrincipalView();
                //telaPrincipal.setExtendedState(JFrame.MAXIMIZED_BOTH);
                telaPrincipal.setVisible(true);
            });
        }

    }
}
