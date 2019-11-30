/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifprbiopark.queijo_desktop.view;

import br.com.ifprbiopark.queijo_desktop.control.ControleColetaLeite;
import br.com.ifprbiopark.queijo_desktop.control.ControleFabricacaoQueijo;
import br.com.ifprbiopark.queijo_desktop.control.ControleFermento;
import br.com.ifprbiopark.queijo_desktop.control.ControlePessoa;
import br.com.ifprbiopark.queijo_desktop.control.ControleReceitaQueijo;
import br.com.ifprbiopark.queijo_desktop.exception.FabricacaoException;
import br.com.ifprbiopark.queijo_desktop.exception.db.DbException;
import br.com.ifprbiopark.queijo_desktop.inicializacao.QueijoDesktop;
import br.com.ifprbiopark.queijo_desktop.model.ColetaLeite;
import br.com.ifprbiopark.queijo_desktop.model.FabricacaoQueijo;
import br.com.ifprbiopark.queijo_desktop.model.Fermento;
import br.com.ifprbiopark.queijo_desktop.model.Pessoa;
import br.com.ifprbiopark.queijo_desktop.model.ReceitaQueijo;
import com.google.common.base.Strings;
import java.awt.Color;
import java.awt.Dimension;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author marcos.andre
 */
public class TelaFabricacaoQueijoView extends javax.swing.JInternalFrame {

    /**
     * Creates new form TelaProcessamentoView
     */
    //lista de receitas do queijo
    private ControleReceitaQueijo rqControl;
    private List<ReceitaQueijo> listaReceitaQueijo;

    //lista de coletas de leite;
    private ControleColetaLeite cleite;
    private List<ColetaLeite> listaColetaLeite;

    //lista de funcionarios
    private ControlePessoa cPessoa;
    private List<Pessoa> listaFuncionarios;
    private FabricacaoQueijo fq = new FabricacaoQueijo();
    private ControleFabricacaoQueijo cfq = new ControleFabricacaoQueijo();
    
    //lista de fermentos
    private ControleFermento cFermento;
    private List<Fermento> listaFermentos;
    
    //configuracao de datas;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    
    

    public TelaFabricacaoQueijoView() {
        initComponents();
        
        setDefaultCloseOperation(JInternalFrame.DO_NOTHING_ON_CLOSE);

        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/iconeQueijos.png")));

        //carregar as receitas
        rqControl = new ControleReceitaQueijo();
//        try {
//            listaReceitaQueijo = rqControl.listaReceitaQueijo();
//            //jcTipoQueijo.removeAll();
//            jcTipoQueijo.addItem("");
//            for (ReceitaQueijo receitaQueijo : listaReceitaQueijo) {
//                jcTipoQueijo.addItem(receitaQueijo.getNomeTipo());
//            }
//
//        } catch (DbException ex) {
//            Logger.getLogger(TelaFabricacaoQueijoView.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        //carregar as coletas de leite
//        cleite = new ControleColetaLeite();
//
//        try {
//            listaColetaLeite = cleite.listaColeta();
//            //jcColeta.removeAll();
//            jcColeta.addItem("");
//            for (ColetaLeite coletaLeite : listaColetaLeite) {
//                jcColeta.addItem(coletaLeite.getLoteColeta());
//            }
//
//        } catch (DbException ex) {
//            Logger.getLogger(TelaFabricacaoQueijoView.class.getName()).log(Level.SEVERE, null, ex);
//        }

        //carregar os funcionarios
        cPessoa = new ControlePessoa();
        try {
            listaFuncionarios = cPessoa.listaFuncionarios();
            //cmbFuncionario.removeAll();
            cmbFuncionario.addItem("");
            for (Pessoa pessoas : listaFuncionarios) {
                cmbFuncionario.addItem(pessoas.getNome());
            }

        } catch (DbException ex) {
            Logger.getLogger(TelaFabricacaoQueijoView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        //carregar lista de fermentos;
        cFermento = new ControleFermento();
        try {
            listaFermentos = cFermento.listaFermento();
            
            cmbFermento.addItem("");
            for (Fermento fermentos : listaFermentos) {
                cmbFermento.addItem(fermentos.getNome() + " - " + fermentos.getMarca());
            }

        } catch (DbException ex) {
            Logger.getLogger(TelaFabricacaoQueijoView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setID(int id) {
        txtID.setText(String.valueOf(id));
        consultar();
    }
    
    public void setFabricacao(FabricacaoQueijo fq) {
        try{
            if (fq != null){
                //informações
                txtID.setText(fq.getId() != null ? fq.getId().toString() : null);
                txtReceitaQueijo.setText(fq.getReceitaQueijo() != null ? fq.getReceitaQueijo().getNomeTipo() : null);
                txtLote.setText(fq.getLoteQueijo() != null ? fq.getLoteQueijo() : null);
                txtLoteEntraga.setText(fq.getColetaLeite() != null ? fq.getColetaLeite().getLoteColeta() : null);
                txtQuantidadeLeiteUtilizada.setText(fq.getQtdLeite() != null ? fq.getQtdLeite().toString() : null);
                txtData.setText(fq.getDataFabricacao() != null ? sdf.format(fq.getDataFabricacao()) : null);

                //processamento
                if("Pasteurizado".equals(fq.getTipoLeite())){
                    jcTipoLeite.setSelectedIndex(1);
                    txtTempoFermento.setEditable(true);
                    txtTemperaturaPross.setEditable(true);
                } else {
                    jcTipoLeite.setSelectedIndex(0);
                }            
                txtTempoFermento.setText(fq.getTempoProcessamento() != null ? fq.getTempoProcessamento().toString() : null);
                txtTemperaturaPross.setText(fq.getTemperaturaProcessamento() != null ? fq.getTemperaturaProcessamento().toString() : null);


                //Prematuracao
                txtTempPreMat.setText(fq.getTemperaturaPreMaturacao() != null ? fq.getTemperaturaPreMaturacao().toString() : null);
                //Fermento
                cmbFermento.setSelectedIndex(fq.getFermento() != null ? fq.getFermento().getId(): 0);
                txtQuantFerm.setText(fq.getQtdFermento() != null ? fq.getQtdFermento().toString() : null);
                txtTempoFermento.setText(fq.getTempoFermentacao()!= null ? fq.getTempoFermentacao().toString() : null);
                txtPhPreMatura.setText(fq.getPhPreMaturacao()!= null ? fq.getPhPreMaturacao().toString() : null);

                //Coagulacao
                txtTemperaturaCoagula.setText(fq.getTemperaturaCoagulacao()!= null ? fq.getTemperaturaCoagulacao().toString() : null);
                txtCloretoCalcio.setText(fq.getQtdClCalcio() != null ? fq.getQtdClCalcio().toString() : null);
                txtQtdCoagulante.setText(fq.getQtdCoagulante()!= null ? fq.getQtdCoagulante().toString() : null);
                txtTempoCoagulacao.setText(fq.getTempoCoagulacao() != null ? fq.getTempoCoagulacao().toString() : null);
                txtPhCorte.setText(fq.getPhCorte() != null ? fq.getPhCorte().toString() : null);
                txtPhEnformagem.setText(fq.getPhEnformagem() != null ? fq.getPhEnformagem().toString() : null);
                txtPh24.setText(fq.getPh24() != null ? fq.getPh24().toString() : null);
                txtDessoragem.setText(fq.getDessoragem() != null ? fq.getDessoragem().toString() : null);
                txtTemperatura24.setText(fq.getTemperaturaDessoragem() != null ? fq.getTemperaturaDessoragem().toString() : null);           
                //Etapa de Salga
                txtTipoSalga.setText(fq.getTipoSalga() != null ? fq.getTipoSalga() : null);

                //maturação
                txtDataMaturacao.setText(fq.getDataMaturacao()!= null ? sdf.format(fq.getDataMaturacao()) : null);
                txtTemperaturaMaturacao.setText(fq.getTemperaturaMaturacao() != null ? fq.getTemperaturaMaturacao().toString() : null);          
                //tratamento casca
                tfDataTratamentoCasca.setText(fq.getDataLavagem() != null ? sdf.format(fq.getDataLavagem()) : null);
                tfTipoTratamentoCasca.setText(fq.getTipoTratamento() != null ? fq.getTipoTratamento() : null);
                txtTempoTratamento.setText(fq.getTempoTratamento().toString() != null ? fq.getTempoTratamento().toString() : null);

                //Rendimento
                tfQueijoProduzido.setText(fq.getQtdPecas() != null ? fq.getQtdPecas().toString() : null);
                tfPesoTotalLote.setText(fq.getPesoTotal() != null ? fq.getPesoTotal().toString() : null);
                tfPesoMedioLote.setText(fq.getPesoMedioPecas() != null ? fq.getPesoMedioPecas().toString() : null);

                //observações
                tfObservacao.setText(fq.getObservacoes() != null ? fq.getObservacoes() : null);

                //finalização
                tfLoteProdutoAcabado.setText(fq.getLoteAcabado() != null ? fq.getLoteAcabado() : null);
                cmbFuncionario.setSelectedItem(fq.getResponsavel() != null ? fq.getResponsavel().getNome(): null);            
                if (fq.getInativo() != null){
                    if (fq.getInativo() == 0){
                    chkAtivo.setSelected(true);
                    }
                    else{
                        chkAtivo.setSelected(false);
                    }
                }
            }
            else{
                QueijoDesktop.telaPrincipal.setMenssagem("Erro: Fabricação nula", Color.red);
            } 
        }
        catch (Exception ex){
            QueijoDesktop.telaPrincipal.setMenssagem("Erro: (Tela de fabricação) erro ao preencher a tela. " + ex.getMessage(), Color.red);
        }
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        pnlInfo = new javax.swing.JPanel();
        txtLote = new javax.swing.JTextField();
        txtQuantidadeLeiteUtilizada = new javax.swing.JTextField();
        txtID = new javax.swing.JTextField();
        txtReceitaQueijo = new javax.swing.JTextField();
        txtLoteEntraga = new javax.swing.JTextField();
        txtData = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JToggleButton();
        btnCancelar = new javax.swing.JToggleButton();
        guia = new javax.swing.JTabbedPane();
        pnlProcessamento = new javax.swing.JPanel();
        txtTemperaturaPross = new javax.swing.JTextField();
        txtTempoFermento = new javax.swing.JTextField();
        jcTipoLeite = new javax.swing.JComboBox<>();
        pnlPreMaturacao = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        txtQuantFerm = new javax.swing.JTextField();
        txtTempoFermentacao = new javax.swing.JTextField();
        cmbFermento = new javax.swing.JComboBox<>();
        txtPhPreMatura = new javax.swing.JTextField();
        txtTempPreMat = new javax.swing.JTextField();
        pnlCoagulacao = new javax.swing.JPanel();
        txtTemperaturaCoagula = new javax.swing.JTextField();
        txtQtdCoagulante = new javax.swing.JTextField();
        txtTempoCoagulacao = new javax.swing.JTextField();
        txtPhCorte = new javax.swing.JTextField();
        txtPhEnformagem = new javax.swing.JTextField();
        txtPh24 = new javax.swing.JTextField();
        txtCloretoCalcio = new javax.swing.JTextField();
        txtDessoragem = new javax.swing.JTextField();
        txtTemperatura24 = new javax.swing.JTextField();
        txtTipoSalga = new javax.swing.JTextField();
        pnlMaturacao = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        tfTipoTratamentoCasca = new javax.swing.JTextField();
        tfDataTratamentoCasca = new javax.swing.JFormattedTextField();
        txtTempoTratamento = new javax.swing.JTextField();
        txtTemperaturaMaturacao = new javax.swing.JTextField();
        txtDataMaturacao = new javax.swing.JFormattedTextField();
        pnlRendimento = new javax.swing.JPanel();
        tfPesoMedioLote = new javax.swing.JTextField();
        tfPesoTotalLote = new javax.swing.JTextField();
        tfQueijoProduzido = new javax.swing.JTextField();
        pnlObsevacao = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tfObservacao = new javax.swing.JTextPane();
        pnlFinalizacao = new javax.swing.JPanel();
        cmbFuncionario = new javax.swing.JComboBox<>();
        tfLoteProdutoAcabado = new javax.swing.JTextField();
        chkAtivo = new javax.swing.JCheckBox();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Fabricação");
        setMinimumSize(new java.awt.Dimension(976, 694));
        setRequestFocusEnabled(false);
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosing(evt);
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        pnlInfo.setBackground(new java.awt.Color(255, 255, 255));
        pnlInfo.setBorder(javax.swing.BorderFactory.createTitledBorder("Informações da fabricação"));

        txtLote.setEditable(false);
        txtLote.setBorder(javax.swing.BorderFactory.createTitledBorder("Lote:"));

        txtQuantidadeLeiteUtilizada.setEditable(false);
        txtQuantidadeLeiteUtilizada.setBorder(javax.swing.BorderFactory.createTitledBorder("Qtde Utilizada (L):"));
        txtQuantidadeLeiteUtilizada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQuantidadeLeiteUtilizadaActionPerformed(evt);
            }
        });

        txtID.setEditable(false);
        txtID.setBorder(javax.swing.BorderFactory.createTitledBorder("ID:"));

        txtReceitaQueijo.setEditable(false);
        txtReceitaQueijo.setBorder(javax.swing.BorderFactory.createTitledBorder("Receita de queijo"));

        txtLoteEntraga.setEditable(false);
        txtLoteEntraga.setBorder(javax.swing.BorderFactory.createTitledBorder("Lote da entrega de leite:"));

        txtData.setEditable(false);
        txtData.setBorder(javax.swing.BorderFactory.createTitledBorder("Data:"));

        javax.swing.GroupLayout pnlInfoLayout = new javax.swing.GroupLayout(pnlInfo);
        pnlInfo.setLayout(pnlInfoLayout);
        pnlInfoLayout.setHorizontalGroup(
            pnlInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtReceitaQueijo, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtLote, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtLoteEntraga, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtQuantidadeLeiteUtilizada, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtData)
                .addContainerGap())
        );
        pnlInfoLayout.setVerticalGroup(
            pnlInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInfoLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(pnlInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtReceitaQueijo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLote, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLoteEntraga, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtQuantidadeLeiteUtilizada, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnlInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtData)
                .addContainerGap())
        );

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        pnlProcessamento.setBackground(new java.awt.Color(255, 255, 255));
        pnlProcessamento.setForeground(new java.awt.Color(255, 255, 255));

        txtTemperaturaPross.setEditable(false);
        txtTemperaturaPross.setBorder(javax.swing.BorderFactory.createTitledBorder("Temperatura (°C):"));
        txtTemperaturaPross.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTemperaturaProssActionPerformed(evt);
            }
        });

        txtTempoFermento.setEditable(false);
        txtTempoFermento.setBorder(javax.swing.BorderFactory.createTitledBorder("Tempo (min):"));
        txtTempoFermento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTempoFermentoActionPerformed(evt);
            }
        });

        jcTipoLeite.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cru", "Pasteurizado" }));
        jcTipoLeite.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipo de Leite"));
        jcTipoLeite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcTipoLeiteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlProcessamentoLayout = new javax.swing.GroupLayout(pnlProcessamento);
        pnlProcessamento.setLayout(pnlProcessamentoLayout);
        pnlProcessamentoLayout.setHorizontalGroup(
            pnlProcessamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProcessamentoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jcTipoLeite, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTempoFermento, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTemperaturaPross, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(542, Short.MAX_VALUE))
        );
        pnlProcessamentoLayout.setVerticalGroup(
            pnlProcessamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProcessamentoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlProcessamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcTipoLeite, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTempoFermento, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTemperaturaPross, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(195, 195, 195))
        );

        guia.addTab("Processamento", pnlProcessamento);

        pnlPreMaturacao.setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Fermento"));

        txtQuantFerm.setBorder(javax.swing.BorderFactory.createTitledBorder("Quantidade (g):"));
        txtQuantFerm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQuantFermActionPerformed(evt);
            }
        });

        txtTempoFermentacao.setBorder(javax.swing.BorderFactory.createTitledBorder("Tempo(min):"));
        txtTempoFermentacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTempoFermentacaoActionPerformed(evt);
            }
        });

        cmbFermento.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipo do fermento e marca:"));

        txtPhPreMatura.setBorder(javax.swing.BorderFactory.createTitledBorder("pH após pré-maturação:"));
        txtPhPreMatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPhPreMaturaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(cmbFermento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtQuantFerm, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTempoFermentacao, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPhPreMatura, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtQuantFerm, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTempoFermentacao, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPhPreMatura, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbFermento, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        txtTempPreMat.setBorder(javax.swing.BorderFactory.createTitledBorder("Temperatura utilizada(°C):"));
        txtTempPreMat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTempPreMatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlPreMaturacaoLayout = new javax.swing.GroupLayout(pnlPreMaturacao);
        pnlPreMaturacao.setLayout(pnlPreMaturacaoLayout);
        pnlPreMaturacaoLayout.setHorizontalGroup(
            pnlPreMaturacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPreMaturacaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPreMaturacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPreMaturacaoLayout.createSequentialGroup()
                        .addComponent(txtTempPreMat, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 788, Short.MAX_VALUE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlPreMaturacaoLayout.setVerticalGroup(
            pnlPreMaturacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPreMaturacaoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtTempPreMat, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(105, Short.MAX_VALUE))
        );

        guia.addTab("Pré-maturação", pnlPreMaturacao);

        pnlCoagulacao.setBackground(new java.awt.Color(255, 255, 255));

        txtTemperaturaCoagula.setBorder(javax.swing.BorderFactory.createTitledBorder("Temperatura (°C):"));
        txtTemperaturaCoagula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTemperaturaCoagulaActionPerformed(evt);
            }
        });

        txtQtdCoagulante.setBorder(javax.swing.BorderFactory.createTitledBorder("Coagulante (mL):"));
        txtQtdCoagulante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQtdCoagulanteActionPerformed(evt);
            }
        });

        txtTempoCoagulacao.setBorder(javax.swing.BorderFactory.createTitledBorder("Tempo de coagulação (min):"));
        txtTempoCoagulacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTempoCoagulacaoActionPerformed(evt);
            }
        });

        txtPhCorte.setBorder(javax.swing.BorderFactory.createTitledBorder("pH do corte:"));
        txtPhCorte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPhCorteActionPerformed(evt);
            }
        });

        txtPhEnformagem.setBorder(javax.swing.BorderFactory.createTitledBorder("pH da enformagem:"));
        txtPhEnformagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPhEnformagemActionPerformed(evt);
            }
        });

        txtPh24.setBorder(javax.swing.BorderFactory.createTitledBorder("pH após 24Hs:"));
        txtPh24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPh24ActionPerformed(evt);
            }
        });

        txtCloretoCalcio.setBorder(javax.swing.BorderFactory.createTitledBorder("Cloreto de Cálcio (ml):"));
        txtCloretoCalcio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCloretoCalcioActionPerformed(evt);
            }
        });

        txtDessoragem.setBorder(javax.swing.BorderFactory.createTitledBorder("Dessoragem:"));
        txtDessoragem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDessoragemActionPerformed(evt);
            }
        });

        txtTemperatura24.setBorder(javax.swing.BorderFactory.createTitledBorder("Temperatura dessoragem (°C):"));
        txtTemperatura24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTemperatura24ActionPerformed(evt);
            }
        });

        txtTipoSalga.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipo de salga:"));

        javax.swing.GroupLayout pnlCoagulacaoLayout = new javax.swing.GroupLayout(pnlCoagulacao);
        pnlCoagulacao.setLayout(pnlCoagulacaoLayout);
        pnlCoagulacaoLayout.setHorizontalGroup(
            pnlCoagulacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCoagulacaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCoagulacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtQtdCoagulante, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                    .addComponent(txtTemperaturaCoagula)
                    .addComponent(txtPhCorte)
                    .addComponent(txtDessoragem))
                .addGroup(pnlCoagulacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCoagulacaoLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(pnlCoagulacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCoagulacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtTemperatura24, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                                .addComponent(txtPhEnformagem))
                            .addComponent(txtTempoCoagulacao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCoagulacaoLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(txtCloretoCalcio, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlCoagulacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPh24, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTipoSalga, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(415, Short.MAX_VALUE))
        );
        pnlCoagulacaoLayout.setVerticalGroup(
            pnlCoagulacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCoagulacaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCoagulacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTemperaturaCoagula, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCloretoCalcio, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlCoagulacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtQtdCoagulante, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTempoCoagulacao, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlCoagulacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPhCorte, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPhEnformagem, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPh24, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlCoagulacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTemperatura24, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDessoragem, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTipoSalga, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );

        guia.addTab("Coagulação", pnlCoagulacao);

        pnlMaturacao.setBackground(new java.awt.Color(255, 255, 255));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Tratamento da Casca"));

        tfTipoTratamentoCasca.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipo de tratamento:"));
        tfTipoTratamentoCasca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfTipoTratamentoCascaActionPerformed(evt);
            }
        });

        tfDataTratamentoCasca.setBorder(javax.swing.BorderFactory.createTitledBorder("Data de lavagem:"));
        tfDataTratamentoCasca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfDataTratamentoCascaActionPerformed(evt);
            }
        });

        txtTempoTratamento.setBorder(javax.swing.BorderFactory.createTitledBorder("Tempo de tratamento (min):"));
        txtTempoTratamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTempoTratamentoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(tfDataTratamentoCasca, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfTipoTratamentoCasca, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTempoTratamento, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 316, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfDataTratamentoCasca, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfTipoTratamentoCasca, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTempoTratamento, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4))
        );

        txtTemperaturaMaturacao.setBorder(javax.swing.BorderFactory.createTitledBorder("Temperatura (°C):"));
        txtTemperaturaMaturacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTemperaturaMaturacaoActionPerformed(evt);
            }
        });

        txtDataMaturacao.setBorder(javax.swing.BorderFactory.createTitledBorder("Data:"));
        txtDataMaturacao.setToolTipText("");

        javax.swing.GroupLayout pnlMaturacaoLayout = new javax.swing.GroupLayout(pnlMaturacao);
        pnlMaturacao.setLayout(pnlMaturacaoLayout);
        pnlMaturacaoLayout.setHorizontalGroup(
            pnlMaturacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMaturacaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlMaturacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMaturacaoLayout.createSequentialGroup()
                        .addComponent(txtDataMaturacao, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTemperaturaMaturacao, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlMaturacaoLayout.setVerticalGroup(
            pnlMaturacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMaturacaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlMaturacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDataMaturacao, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTemperaturaMaturacao, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(109, Short.MAX_VALUE))
        );

        guia.addTab("Maturação", pnlMaturacao);

        pnlRendimento.setBackground(new java.awt.Color(255, 255, 255));

        tfPesoMedioLote.setBorder(javax.swing.BorderFactory.createTitledBorder("Peso médio (Kg):"));
        tfPesoMedioLote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPesoMedioLoteActionPerformed(evt);
            }
        });

        tfPesoTotalLote.setBorder(javax.swing.BorderFactory.createTitledBorder("Peso total (Kg):"));
        tfPesoTotalLote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPesoTotalLoteActionPerformed(evt);
            }
        });

        tfQueijoProduzido.setBorder(javax.swing.BorderFactory.createTitledBorder("Qtd de peças produzidas:"));
        tfQueijoProduzido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfQueijoProduzidoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlRendimentoLayout = new javax.swing.GroupLayout(pnlRendimento);
        pnlRendimento.setLayout(pnlRendimentoLayout);
        pnlRendimentoLayout.setHorizontalGroup(
            pnlRendimentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRendimentoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlRendimentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfPesoTotalLote, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                    .addComponent(tfQueijoProduzido)
                    .addComponent(tfPesoMedioLote))
                .addContainerGap(806, Short.MAX_VALUE))
        );
        pnlRendimentoLayout.setVerticalGroup(
            pnlRendimentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRendimentoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tfQueijoProduzido, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfPesoMedioLote, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfPesoTotalLote, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(77, Short.MAX_VALUE))
        );

        guia.addTab("Rendimento", pnlRendimento);

        pnlObsevacao.setBackground(new java.awt.Color(255, 255, 255));

        tfObservacao.setBorder(javax.swing.BorderFactory.createTitledBorder("Observações:"));
        jScrollPane1.setViewportView(tfObservacao);

        javax.swing.GroupLayout pnlObsevacaoLayout = new javax.swing.GroupLayout(pnlObsevacao);
        pnlObsevacao.setLayout(pnlObsevacaoLayout);
        pnlObsevacaoLayout.setHorizontalGroup(
            pnlObsevacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1002, Short.MAX_VALUE)
        );
        pnlObsevacaoLayout.setVerticalGroup(
            pnlObsevacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
        );

        guia.addTab("Observações", pnlObsevacao);

        pnlFinalizacao.setBackground(new java.awt.Color(255, 255, 255));

        cmbFuncionario.setBorder(javax.swing.BorderFactory.createTitledBorder("Funcionario"));

        tfLoteProdutoAcabado.setBorder(javax.swing.BorderFactory.createTitledBorder("Lote (Produto Acabado):"));
        tfLoteProdutoAcabado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfLoteProdutoAcabadoActionPerformed(evt);
            }
        });

        chkAtivo.setBackground(new java.awt.Color(255, 255, 255));
        chkAtivo.setSelected(true);
        chkAtivo.setText("Fabricação ativa");

        javax.swing.GroupLayout pnlFinalizacaoLayout = new javax.swing.GroupLayout(pnlFinalizacao);
        pnlFinalizacao.setLayout(pnlFinalizacaoLayout);
        pnlFinalizacaoLayout.setHorizontalGroup(
            pnlFinalizacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFinalizacaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFinalizacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFinalizacaoLayout.createSequentialGroup()
                        .addComponent(tfLoteProdutoAcabado, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(chkAtivo))
                .addContainerGap(586, Short.MAX_VALUE))
        );
        pnlFinalizacaoLayout.setVerticalGroup(
            pnlFinalizacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFinalizacaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFinalizacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfLoteProdutoAcabado, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkAtivo)
                .addContainerGap(162, Short.MAX_VALUE))
        );

        guia.addTab("Finalização", pnlFinalizacao);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(guia))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(guia, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnCancelar))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        guia.getAccessibleContext().setAccessibleName("Processamento");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTemperaturaProssActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTemperaturaProssActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTemperaturaProssActionPerformed

    private void txtQuantFermActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQuantFermActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQuantFermActionPerformed

    private void txtTempPreMatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTempPreMatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTempPreMatActionPerformed

    private void txtTempoFermentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTempoFermentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTempoFermentoActionPerformed

    private void txtTempoFermentacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTempoFermentacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTempoFermentacaoActionPerformed

    private void txtPhPreMaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPhPreMaturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPhPreMaturaActionPerformed

    private void txtCloretoCalcioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCloretoCalcioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCloretoCalcioActionPerformed

    private void txtTemperaturaMaturacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTemperaturaMaturacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTemperaturaMaturacaoActionPerformed

    private void txtPhEnformagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPhEnformagemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPhEnformagemActionPerformed

    private void txtTempoCoagulacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTempoCoagulacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTempoCoagulacaoActionPerformed

    private void txtQtdCoagulanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQtdCoagulanteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQtdCoagulanteActionPerformed

    private void txtPhCorteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPhCorteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPhCorteActionPerformed

    private void txtPh24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPh24ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPh24ActionPerformed

    private void txtDessoragemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDessoragemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDessoragemActionPerformed

    private void txtTemperatura24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTemperatura24ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTemperatura24ActionPerformed

    private void txtTemperaturaCoagulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTemperaturaCoagulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTemperaturaCoagulaActionPerformed

    private void txtTempoTratamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTempoTratamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTempoTratamentoActionPerformed

    private void tfLoteProdutoAcabadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfLoteProdutoAcabadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfLoteProdutoAcabadoActionPerformed

    private void tfQueijoProduzidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfQueijoProduzidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfQueijoProduzidoActionPerformed

    private void tfPesoMedioLoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPesoMedioLoteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfPesoMedioLoteActionPerformed

    private void tfPesoTotalLoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPesoTotalLoteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfPesoTotalLoteActionPerformed

    private void tfTipoTratamentoCascaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfTipoTratamentoCascaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfTipoTratamentoCascaActionPerformed

    private void txtQuantidadeLeiteUtilizadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQuantidadeLeiteUtilizadaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQuantidadeLeiteUtilizadaActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        fechar();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void tfDataTratamentoCascaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfDataTratamentoCascaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfDataTratamentoCascaActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed

        try {
            FabricacaoQueijo queijo = new FabricacaoQueijo();
            ControleFabricacaoQueijo cQueijo = new ControleFabricacaoQueijo();

            //informacoes iniciais de processamento
            queijo.setReceitaQueijo(listaReceitaQueijo.get(fq.getReceitaQueijo().getIdTipoQueijo()));
            queijo.setLoteQueijo(txtLote.getText());
            queijo.setColetaLeite((listaColetaLeite.get(fq.getColetaLeite().getIdColetaLeite())));
            queijo.setQtdLeite(parseDoubles(txtQuantidadeLeiteUtilizada.getText()));

            //Processamento
            queijo.setTipoLeite((String) jcTipoLeite.getSelectedItem());
            queijo.setTempoProcessamento(parseInteiro(txtTempoFermento.getText()));
            queijo.setTemperaturaProcessamento(parseInteiro(txtTemperaturaPross.getText()));

            //Prematuracao
            queijo.setTemperaturaPreMaturacao(parseInteiro(txtTempPreMat.getText()));

            //Insercao de Fermento
            //fermento_id
            queijo.setQtdFermento(parseDoubles(txtQuantFerm.getText()));
            queijo.setTempoFermentacao(parseInteiro(txtTempoFermento.getText()));
            //queijo.setFermento(txtTipoFermento.getText());
            //queijo.setMarcaFermento(txtMarcaFerm.getText());
            queijo.setPhPreMaturacao(parseDoubles(txtPhPreMatura.getText()));

            //Coagulacao
            queijo.setTemperaturaCoagulacao(parseInteiro(txtTemperaturaCoagula.getText()));
            queijo.setQtdClCalcio(parseDoubles(txtCloretoCalcio.getText()));
            queijo.setQtdCoagulante(parseDoubles(txtQtdCoagulante.getText()));
            queijo.setTempoCoagulacao(parseInteiro(txtTempoCoagulacao.getText()));
            queijo.setPhCorte(parseDoubles(txtPhCorte.getText()));
            queijo.setPhEnformagem(parseDoubles(txtPhEnformagem.getText()));
            //queijo.setPhMaturacao(parseDoubles(txtPhPreMatura.getText()));
            queijo.setDessoragem(parseInteiro(txtDessoragem.getText()));
            queijo.setTemperaturaDessoragem(parseInteiro(txtTemperatura24.getText()));

            //Etapa de Salga
            queijo.setTipoSalga(txtTipoSalga.getText());
               
            //tratamento casca
            queijo.setDataLavagem(sdf.parse(tfDataTratamentoCasca.getText()));
            queijo.setTipoTratamento(tfTipoTratamentoCasca.getText());
            queijo.setTempoTratamento(Integer.parseInt(txtTempoTratamento.getText()));
            
            //Rendimento
            queijo.setQtdPecas(parseInteiro(tfQueijoProduzido.getText()));
            queijo.setPesoTotal(parseDoubles(tfPesoTotalLote.getText()));
            queijo.setPesoMedioPecas(parseDoubles(tfPesoMedioLote.getText()));
            queijo.setLoteAcabado(tfLoteProdutoAcabado.getText());
            queijo.setResponsavel(listaFuncionarios.get(cmbFuncionario.getSelectedIndex()));
            queijo.setObservacoes(tfObservacao.getText());

            cQueijo.salvar(queijo);
        } catch (FabricacaoException ex) {
            Logger.getLogger(TelaFabricacaoQueijoView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(TelaFabricacaoQueijoView.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnSalvarActionPerformed

    private void jcTipoLeiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcTipoLeiteActionPerformed
        
        if(jcTipoLeite.getSelectedIndex() == 0){
            txtTempoFermento.setEditable(false);
            txtTemperaturaPross.setEditable(false);
        }
        else if (jcTipoLeite.getSelectedIndex() == 1){
            txtTempoFermento.setEditable(true);
            txtTemperaturaPross.setEditable(true);
        }
    }//GEN-LAST:event_jcTipoLeiteActionPerformed

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        fechar();
    }//GEN-LAST:event_formInternalFrameClosing

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnCancelar;
    private javax.swing.JToggleButton btnSalvar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox chkAtivo;
    private javax.swing.JComboBox<String> cmbFermento;
    private javax.swing.JComboBox<String> cmbFuncionario;
    private javax.swing.JTabbedPane guia;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jcTipoLeite;
    private javax.swing.JPanel pnlCoagulacao;
    private javax.swing.JPanel pnlFinalizacao;
    private javax.swing.JPanel pnlInfo;
    private javax.swing.JPanel pnlMaturacao;
    private javax.swing.JPanel pnlObsevacao;
    private javax.swing.JPanel pnlPreMaturacao;
    private javax.swing.JPanel pnlProcessamento;
    private javax.swing.JPanel pnlRendimento;
    private javax.swing.JFormattedTextField tfDataTratamentoCasca;
    private javax.swing.JTextField tfLoteProdutoAcabado;
    private javax.swing.JTextPane tfObservacao;
    private javax.swing.JTextField tfPesoMedioLote;
    private javax.swing.JTextField tfPesoTotalLote;
    private javax.swing.JTextField tfQueijoProduzido;
    private javax.swing.JTextField tfTipoTratamentoCasca;
    private javax.swing.JTextField txtCloretoCalcio;
    private javax.swing.JTextField txtData;
    private javax.swing.JFormattedTextField txtDataMaturacao;
    private javax.swing.JTextField txtDessoragem;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtLote;
    private javax.swing.JTextField txtLoteEntraga;
    private javax.swing.JTextField txtPh24;
    private javax.swing.JTextField txtPhCorte;
    private javax.swing.JTextField txtPhEnformagem;
    private javax.swing.JTextField txtPhPreMatura;
    private javax.swing.JTextField txtQtdCoagulante;
    private javax.swing.JTextField txtQuantFerm;
    private javax.swing.JTextField txtQuantidadeLeiteUtilizada;
    private javax.swing.JTextField txtReceitaQueijo;
    private javax.swing.JTextField txtTempPreMat;
    private javax.swing.JTextField txtTemperatura24;
    private javax.swing.JTextField txtTemperaturaCoagula;
    private javax.swing.JTextField txtTemperaturaMaturacao;
    private javax.swing.JTextField txtTemperaturaPross;
    private javax.swing.JTextField txtTempoCoagulacao;
    private javax.swing.JTextField txtTempoFermentacao;
    private javax.swing.JTextField txtTempoFermento;
    private javax.swing.JTextField txtTempoTratamento;
    private javax.swing.JTextField txtTipoSalga;
    // End of variables declaration//GEN-END:variables

    private Integer parseInteiro(String value) {

        if (Strings.isNullOrEmpty(value)) {
            return null;
        }
        return Integer.parseInt(value);
    }

    private Double parseDoubles(String value) {

        if (Strings.isNullOrEmpty(value)) {
            return null;
        }
        return Double.parseDouble(value);
    }

    private void consultar() {
        fq = cfq.consultar(Integer.parseInt(txtID.getText()));
        setFabricacao(fq);
    }
    
    private void fechar(){
        if (JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair?", "Aviso", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            this.dispose();
        }
    }
}
