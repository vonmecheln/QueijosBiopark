/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifprbiopark.queijo_desktop.view;

import br.com.ifprbiopark.queijo_desktop.control.ControleColetaLeite;
import br.com.ifprbiopark.queijo_desktop.dao.PessoaDao;
import br.com.ifprbiopark.queijo_desktop.exception.db.DbException;
import br.com.ifprbiopark.queijo_desktop.model.ColetaLeite;
import br.com.ifprbiopark.queijo_desktop.model.Pessoa;
import br.com.ifprbiopark.queijo_desktop.view.tablemodel.TableRecebimentoLeite;
import java.awt.Component;

import java.awt.Dimension;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author marcos.andre
 */
public class TelaColetaLeiteView extends javax.swing.JInternalFrame {
    private List<Pessoa> fornecedores;
    private List<Pessoa> funcionarios;

    TableRecebimentoLeite listaColetas = new TableRecebimentoLeite();

    public TelaColetaLeiteView() throws ParseException, DbException {
        initComponents();
        load();
        
        MaskFormatter coletaLeite = new MaskFormatter("##/##/####");  
        coletaLeite.install(jfData);
        
        //inicio - > Botao fornecedor
        PessoaDao p = new PessoaDao();
        fornecedores = p.consultarFornecedores();

        jcFornecedor.removeAll();
        
        for (int i = 0; i < fornecedores.size(); i++) {
            jcFornecedor.addItem(fornecedores.get(i).getNome());
        }
        //fim;
        
        //inicio - > Botao funcioario
        PessoaDao f = new PessoaDao();
        funcionarios = f.consultarFuncionarios();

        jcFuncionario.removeAll();
        
        for (int i = 0; i < funcionarios.size(); i++) {
            jcFuncionario.addItem(funcionarios.get(i).getNome());
        }
        
        
    }
    
    private void load() throws ParseException, DbException{
        tblEntradaLeite.setModel(listaColetas);
        
        
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

        jProgressBar1 = new javax.swing.JProgressBar();
        jPanel1 = new javax.swing.JPanel();
        jcFornecedor = new javax.swing.JComboBox<>();
        tfLote = new javax.swing.JTextField();
        tfQuantidade = new javax.swing.JTextField();
        jbSalvar = new javax.swing.JButton();
        jbExcluir = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jcFuncionario = new javax.swing.JComboBox<>();
        jfData = new javax.swing.JFormattedTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblEntradaLeite = new javax.swing.JTable();
        jcbSituacao = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Entrada de Leite");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Fornecedor"));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jcFornecedor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jcFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tfLote.setBorder(javax.swing.BorderFactory.createTitledBorder("Lote:"));
        tfLote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfLoteActionPerformed(evt);
            }
        });

        tfQuantidade.setBorder(javax.swing.BorderFactory.createTitledBorder("Quantidade(L):"));
        tfQuantidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfQuantidadeActionPerformed(evt);
            }
        });

        jbSalvar.setText("Salvar");
        jbSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalvarActionPerformed(evt);
            }
        });

        jbExcluir.setText("Excluir");
        jbExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExcluirActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Funcionário"));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jcFuncionario, 0, 350, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jcFuncionario)
                .addContainerGap())
        );

        jfData.setBorder(javax.swing.BorderFactory.createTitledBorder("Data"));

        tblEntradaLeite.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tblEntradaLeite);

        jcbSituacao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pago", "Pendente" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jfData, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfLote, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jcbSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jbSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfLote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jfData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jcbSituacao)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        tfQuantidade.getAccessibleContext().setAccessibleName("Quantidade(L):");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfLoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfLoteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfLoteActionPerformed

    private void tfQuantidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfQuantidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfQuantidadeActionPerformed

    private void jbSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalvarActionPerformed
        
        ColetaLeite coleta = new ColetaLeite();
        ControleColetaLeite cColeta  = new ControleColetaLeite();
        
        //ajusta o botao
        if (jbSalvar.getText().equals("Atualizar")) {
            jbSalvar.setText("Salvar");
        }

        //Obriga preenchimento do cpf ou cnpj;
        if (jfData.getText().isEmpty()) {
            Component frame = null;
            JOptionPane.showMessageDialog(frame, "Insira os dados para Cadastrar!");

        } else {

            //Aqui atualiza os dados do objeto com informaçoes da table model;
            if (tblEntradaLeite.getSelectedRow() != -1) {

                try {

                    int row = tblEntradaLeite.getSelectedRow();
                    
                    //"Id", "Produtor", "Quantidade", "Data Coleta", "Funcionario", "Lote";
                    Object id = tblEntradaLeite.getValueAt(row, 0);
                    Object produtor = tblEntradaLeite.getValueAt(row, 1);
                    Object quantidade = tblEntradaLeite.getValueAt(row, 2);
                    Object data = tblEntradaLeite.getValueAt(row, 3);
                    Object funcionario = tblEntradaLeite.getValueAt(row, 4);
                    Object lote = tblEntradaLeite.getValueAt(row, 5);
                    Object situacao = tblEntradaLeite.getValueAt(row, 6);
                    
                    coleta.setIdColetaLeite((Integer) id);
                    //coleta.setProdutor_idProdutor((Pessoa) produtor);
                    coleta.setQtdLeite((double) quantidade);
                    coleta.setDtColeta((Date) data);
                    coleta.setSituacao((String)situacao);
                    
                    //funcionario
                    Pessoa p = new Pessoa();
                    p.setIdPessoa(coleta.getPessoa_idPessoa().getIdPessoa());
                    
                    coleta.setLoteColeta((String) lote);
                    
                    
                    try {
                        cColeta.salvar(coleta);
                    } catch (DbException ex) {
                        Logger.getLogger(TelaColetaLeiteView.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    load();
                    listaColetas.updateRow();
                    
                    
                    
                } catch (ParseException ex) {
                    Logger.getLogger(TelaColetaLeiteView.class.getName()).log(Level.SEVERE, null, ex);
                } catch (DbException ex) {
                    Logger.getLogger(TelaColetaLeiteView.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else {

                try {
                    //coleta dados do formulario da tela "ColetaLeite";
                    
                    //fornecedor na tela;
                    coleta.setProdutor_idProdutor(fornecedores.get(jcFornecedor.getSelectedIndex()));
                    //Funcionario na tela;
                    coleta.setPessoa_idPessoa(funcionarios.get(jcFuncionario.getSelectedIndex()));
                    //data da coleta;
                    Date leiteColeta = new SimpleDateFormat("dd/MM/yyyy").parse(jfData.getText());
                    coleta.setDtColeta(leiteColeta);
                } catch (ParseException ex) {
                    Logger.getLogger(TelaColetaLeiteView.class.getName()).log(Level.SEVERE, null, ex);
                }
                    coleta.setSituacao((String) jcbSituacao.getSelectedItem());
                
                               
                coleta.setQtdLeite(Double.parseDouble(tfQuantidade.getText()));
                coleta.setLoteColeta(tfLote.getText());
                
                
                
                listaColetas.addRow(coleta);
                
                //limpar campos;
                    jfData.setText("");
                    tfQuantidade.setText("");
                    tfLote.setText("");
                try {
                    cColeta.salvar(coleta);
                } catch (DbException ex) {
                    Logger.getLogger(TelaColetaLeiteView.class.getName()).log(Level.SEVERE, null, ex);
                }
                        
            }

        }
        
        
    }//GEN-LAST:event_jbSalvarActionPerformed

    private void jbExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExcluirActionPerformed
        
        ControleColetaLeite cColeta = new ControleColetaLeite();
        ColetaLeite c = new ColetaLeite();
        
        if (tblEntradaLeite.getSelectedRow() != -1) {

            if (JOptionPane.showConfirmDialog(null, "Deseja excluir este cadastro?", "Atenção!",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

                int row = tblEntradaLeite.getSelectedRow();
                if (row > -1) {

                    //para selecionar o ID a coluna deve ser setada com valor 0;
                    Object id = tblEntradaLeite.getValueAt(row, 0);
                    
                    c.setIdColetaLeite((Integer) id);
                    
                    try {
                        cColeta.excluir(c);
                    } catch (DbException ex) {
                        Logger.getLogger(TelaColetaLeiteView.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    listaColetas.removeRow(tblEntradaLeite.getSelectedRow());

                }
            }
        }
    }//GEN-LAST:event_jbExcluirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbExcluir;
    private javax.swing.JButton jbSalvar;
    private javax.swing.JComboBox<String> jcFornecedor;
    private javax.swing.JComboBox<String> jcFuncionario;
    private javax.swing.JComboBox<String> jcbSituacao;
    private javax.swing.JFormattedTextField jfData;
    private javax.swing.JTable tblEntradaLeite;
    private javax.swing.JTextField tfLote;
    private javax.swing.JTextField tfQuantidade;
    // End of variables declaration//GEN-END:variables
}
