package br.com.ifprbiopark.queijo_desktop.inicializacao;

import br.com.ifprbiopark.queijo_desktop.control.ControleColetaLeite;
import br.com.ifprbiopark.queijo_desktop.control.ControleEntregaAtributo;
import br.com.ifprbiopark.queijo_desktop.control.ControleFabricacaoQueijo;
import br.com.ifprbiopark.queijo_desktop.control.ControleFermento;
import br.com.ifprbiopark.queijo_desktop.control.ControlePessoa;
import br.com.ifprbiopark.queijo_desktop.control.ControleReceitaQueijo;
import br.com.ifprbiopark.queijo_desktop.dao.ColetaLeiteDao;
import br.com.ifprbiopark.queijo_desktop.dao.EntradaAtributoDao;
import br.com.ifprbiopark.queijo_desktop.dao.FabricacaoQueijoDao;
import br.com.ifprbiopark.queijo_desktop.dao.FermentoDao;
import br.com.ifprbiopark.queijo_desktop.dao.PessoaDao;
import br.com.ifprbiopark.queijo_desktop.dao.ReceitaQueijoDao;
import br.com.ifprbiopark.queijo_desktop.exception.ColetaLeiteException;
import br.com.ifprbiopark.queijo_desktop.exception.EntregaAtributoException;
import br.com.ifprbiopark.queijo_desktop.exception.FabricacaoException;
import br.com.ifprbiopark.queijo_desktop.exception.FermentoException;
import br.com.ifprbiopark.queijo_desktop.exception.PessoaException;
import br.com.ifprbiopark.queijo_desktop.exception.ReceitaQueijoException;
import br.com.ifprbiopark.queijo_desktop.exception.db.DbException;
import br.com.ifprbiopark.queijo_desktop.model.Atributos;
import br.com.ifprbiopark.queijo_desktop.model.ColetaLeite;
import br.com.ifprbiopark.queijo_desktop.model.EntradaAtributo;
import br.com.ifprbiopark.queijo_desktop.model.FabricacaoQueijo;
import br.com.ifprbiopark.queijo_desktop.model.Fermento;
import br.com.ifprbiopark.queijo_desktop.model.Pessoa;
import br.com.ifprbiopark.queijo_desktop.model.ReceitaQueijo;
import br.com.ifprbiopark.queijo_desktop.view.TelaPrincipalView;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class QueijoDesktop {

    public static GUIProperties guiProps = new GUIProperties();

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
                cr.excluir(r);

            } catch (ReceitaQueijoException ex) {
                Logger.getLogger(QueijoDesktop.class.getName()).log(Level.SEVERE, null, ex);
            }

            Fermento f;
            try {
                f = new Fermento();
                f.setNome("");
                f.setMarca("");
                FermentoDao fd = new FermentoDao();

                fd.inserir(f);
                fd.alterar(f);
                fd.excluir(f);

                ControleFermento cf = new ControleFermento();
                f = new Fermento();
                f.setNome("-");
                f.setMarca("--");
                cf.salvar(f);
                cf.salvar(f);
                cf.excluir(f);

            } catch (FermentoException | DbException ex) {
                Logger.getLogger(QueijoDesktop.class.getName()).log(Level.SEVERE, null, ex);
            }

            ColetaLeite cl;
            try {

                cl = new ColetaLeite();
                cl.setLoteColeta("");
                cl.setDtColeta(new Date("01/01/2020"));
                ColetaLeiteDao cd = new ColetaLeiteDao();
                cd.inserir(cl);
                cd.alterar(cl);
                cd.excluir(cl);

                cl = new ColetaLeite();
                cl.setLoteColeta("-");
                cl.setDtColeta(new Date("31/12/2020"));
                cl.setQtdLeite(1.5);
                cl.setFuncionario(new Pessoa());
                cl.setProdutor(new Pessoa());
                ControleColetaLeite cc = new ControleColetaLeite();
                cc.salvar(cl);
                cc.excluir(cl);

            } catch (DbException | ColetaLeiteException ex) {
                Logger.getLogger(QueijoDesktop.class.getName()).log(Level.SEVERE, null, ex);
            }
            EntradaAtributo ea;

            try {
                ea = new EntradaAtributo();
                ea.setValor("0");

                EntradaAtributoDao ead = new EntradaAtributoDao();
                ead.inserir(ea);
                ead.alterar(ea);
                ead.excluir(ea);

                ea = new EntradaAtributo();

                ea.setValor("0");
                ea.setAtributo(new Atributos());
                ea.setColetaLeite_idColetaLeite(new ColetaLeite());

                ControleEntregaAtributo cea = new ControleEntregaAtributo();
                cea.salvar(ea);
                cea.excluir(ea);

            } catch (DbException | EntregaAtributoException ex) {
                Logger.getLogger(QueijoDesktop.class.getName()).log(Level.SEVERE, null, ex);
            }

            FabricacaoQueijo fb;
            try {

                fb = new FabricacaoQueijo();
                fb.setReceitaQueijo(new ReceitaQueijo());
                fb.setColetaLeite(new ColetaLeite());
                fb.setTipoLeite("");
                fb.setDataFabricacao(new Date());
                FabricacaoQueijoDao fbd = new FabricacaoQueijoDao();
                fbd.inserir(fb);
                fbd.alterar(fb);
                fbd.excluir(fb);

                fb = new FabricacaoQueijo();
                fb.setReceitaQueijo(new ReceitaQueijo());
                fb.setColetaLeite(new ColetaLeite());
                fb.setDataFabricacao(new Date("31/12/2020"));
                fb.setQtdLeite(40.5);
                fb.setLoteQueijo("AAABBB");
                fb.setTipoLeite("");
                fb.setTempoProcessamento(1);
                fb.setTemperaturaProcessamento(2);
                fb.setTemperaturaPreMaturacao(3);
                fbd.inserir(fb);
                fbd.alterar(fb);
                fbd.excluir(fb);

                fb = new FabricacaoQueijo();
                fb.setLoteQueijo("AAABBB");
                fb.setDataFabricacao(new Date("31/12/2020"));
                fb.setQtdLeite(40.5);
                fb.setTempoProcessamento(1);
                fb.setTemperaturaProcessamento(2);
                fb.setTemperaturaPreMaturacao(3);
                fb.setReceitaQueijo(new ReceitaQueijo());
                fb.setColetaLeite(new ColetaLeite());
                fb.setTipoLeite("");

                ControleFabricacaoQueijo fbc = new ControleFabricacaoQueijo();
                fbc.salvar(fb);
                fbc.salvar(fb);
                fbc.excluir(fb);

            } catch (DbException | FabricacaoException ex) {
                Logger.getLogger(QueijoDesktop.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {

            try {
                //            /* Set the Nimbus look and feel */
//            //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//            /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//             */
//            try {
//                for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                    if ("Windows".equals(info.getName())) {
//                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                        break;
//                    }
//                }
//            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
//                java.util.logging.Logger.getLogger(TelaPrincipalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//            }
//            //</editor-fold>
//
//            /* Create and display the form */

                UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(QueijoDesktop.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                Logger.getLogger(QueijoDesktop.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(QueijoDesktop.class.getName()).log(Level.SEVERE, null, ex);
            } catch (UnsupportedLookAndFeelException ex) {
                Logger.getLogger(QueijoDesktop.class.getName()).log(Level.SEVERE, null, ex);
            }

            java.awt.EventQueue.invokeLater(() -> {
                telaPrincipal = new TelaPrincipalView();
                //telaPrincipal.setExtendedState(JFrame.MAXIMIZED_BOTH);
                telaPrincipal.setVisible(true);
            });
        }

    }

}
