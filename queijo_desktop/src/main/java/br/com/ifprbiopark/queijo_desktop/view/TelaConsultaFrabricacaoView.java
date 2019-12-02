package br.com.ifprbiopark.queijo_desktop.view;

import br.com.ifprbiopark.queijo_desktop.control.ControleFabricacaoQueijo;
import br.com.ifprbiopark.queijo_desktop.control.ControleReceitaQueijo;
import br.com.ifprbiopark.queijo_desktop.inicializacao.QueijoDesktop;
import br.com.ifprbiopark.queijo_desktop.model.FabricacaoQueijo;
import br.com.ifprbiopark.queijo_desktop.model.ReceitaQueijo;
import br.com.ifprbiopark.queijo_desktop.view.tablemodel.TableConsultaFabricacao;
import java.awt.Color;
import java.awt.Dimension;
import java.util.List;

public class TelaConsultaFrabricacaoView extends javax.swing.JInternalFrame {

    private ControleReceitaQueijo rqControl = new ControleReceitaQueijo();
    private List<ReceitaQueijo> listaReceitaQueijo;
    private TableConsultaFabricacao tableModel = new TableConsultaFabricacao();
    private ControleFabricacaoQueijo cp;

    /**
     * Creates new form TelaConsultaFrabricacaoView
     */
    public TelaConsultaFrabricacaoView() {
        initComponents();

        tblFabricacoes.setModel(tableModel);

        try {
            listaReceitaQueijo = rqControl.listaReceitaQueijo();
            //jcTipoQueijo.removeAll();
            //cmbTipoQueijo.addItem("");
            cmbTipoQueijo.addItem("Todos");
            for (ReceitaQueijo receitaQueijo : listaReceitaQueijo) {
                cmbTipoQueijo.addItem(receitaQueijo.getNomeTipo());
            }

        } catch (Exception ex) {
            QueijoDesktop.telaPrincipal.setMenssagem("Erro: " + ex.getMessage(), Color.RED);
        }

        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/iconeQueijos.png")));
    }

    public void setPosicao() {
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnNovo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFabricacoes = new javax.swing.JTable();
        btnFiltrar = new javax.swing.JButton();
        cmbTipoQueijo = new javax.swing.JComboBox<>();
        btnAbrir = new javax.swing.JButton();
        chkInativo = new javax.swing.JCheckBox();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setResizable(true);
        setTitle("Consultar fabricações");

        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        tblFabricacoes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblFabricacoes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblFabricacoesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblFabricacoes);

        btnFiltrar.setText("Filtrar");
        btnFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltrarActionPerformed(evt);
            }
        });

        cmbTipoQueijo.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipo de queijo"));

        btnAbrir.setText("Abrir");
        btnAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirActionPerformed(evt);
            }
        });

        chkInativo.setBackground(new java.awt.Color(255, 255, 255));
        chkInativo.setText("Arquivados");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cmbTipoQueijo, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(chkInativo)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 588, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAbrir, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbTipoQueijo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFiltrar)
                    .addComponent(btnNovo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkInativo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAbrir)
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltrarActionPerformed
        consultar();
    }//GEN-LAST:event_btnFiltrarActionPerformed

    private void btnAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirActionPerformed
        abrirFabricacao();
    }//GEN-LAST:event_btnAbrirActionPerformed

    private void tblFabricacoesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblFabricacoesMouseClicked
        if (evt.getClickCount() == 2 && !evt.isConsumed()) {
            evt.consume();
            abrirFabricacao();
        }
    }//GEN-LAST:event_tblFabricacoesMouseClicked

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        novaFabricacao();
    }//GEN-LAST:event_btnNovoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrir;
    private javax.swing.JButton btnFiltrar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JCheckBox chkInativo;
    private javax.swing.JComboBox<String> cmbTipoQueijo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblFabricacoes;
    // End of variables declaration//GEN-END:variables

    private void consultar() {
        try {
            int id = listaReceitaQueijo.get(cmbTipoQueijo.getSelectedIndex()).getId() - 1;
            boolean inativo = Boolean.valueOf(chkInativo.getText());

            tableModel.consultar(id, inativo);
        } catch (Exception ex) {
            QueijoDesktop.telaPrincipal.setMenssagem("Erro: " + ex.getMessage(), Color.RED);
        }
    }

    private void abrirFabricacao() {
        if (tblFabricacoes.getSelectedRow() != -1) {
            FabricacaoQueijo fq = tableModel.getDados().get(tblFabricacoes.getSelectedRow());

            TelaFabricacaoQueijoView form = new TelaFabricacaoQueijoView();
            form.setFabricacao(fq);
            QueijoDesktop.telaPrincipal.getPainelDesktop().add(form);
            form.setPosicao();
            form.setVisible(true);
            this.dispose();
        }
    }

    private void novaFabricacao() {
        TelaNovaFabricacaoView form = new TelaNovaFabricacaoView();
        QueijoDesktop.telaPrincipal.getPainelDesktop().add(form);
        form.setPosicao();
        form.setVisible(true);
        this.dispose();
    }
}
