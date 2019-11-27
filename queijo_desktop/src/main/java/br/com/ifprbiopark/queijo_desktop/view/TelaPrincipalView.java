package br.com.ifprbiopark.queijo_desktop.view;

import br.com.ifprbiopark.queijo_desktop.exception.db.DbException;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDesktopPane;
import javax.swing.Timer;

public class TelaPrincipalView extends javax.swing.JFrame {

    /**
     * Creates new form TelaPrincipal
     */
    public TelaPrincipalView() {
        initComponents();

    }

    public JDesktopPane getPainelDesktop() {
        return painelDesktop;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlInicio = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        pnlMenssagem = new javax.swing.JPanel();
        lblMenssagem = new javax.swing.JLabel();
        painelDesktop = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        pnlMenuSelecionado = new javax.swing.JPanel();
        lbPessoas = new javax.swing.JLabel();
        lbReceitas = new javax.swing.JLabel();
        lbFermentos = new javax.swing.JLabel();
        lbEntrada = new javax.swing.JLabel();
        lbClassificacao = new javax.swing.JLabel();
        lbFabricacao = new javax.swing.JLabel();
        lbRelatorios = new javax.swing.JLabel();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        pnlBgGeral = new javax.swing.JPanel();
        imgDesktop = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Queijos Biopark");
        setPreferredSize(new java.awt.Dimension(1366, 749));
        setResizable(false);

        pnlInicio.setLayout(new java.awt.CardLayout());

        jPanel1.setPreferredSize(new java.awt.Dimension(1366, 720));
        jPanel1.setRequestFocusEnabled(false);

        pnlMenssagem.setBackground(new java.awt.Color(255, 255, 255));
        pnlMenssagem.setLayout(new java.awt.CardLayout());
        pnlMenssagem.add(lblMenssagem, "card2");

        painelDesktop.setBackground(new java.awt.Color(255, 255, 255));
        painelDesktop.setPreferredSize(new java.awt.Dimension(500, 500));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bgWindowDesktop.jpg"))); // NOI18N
        jLabel1.setPreferredSize(new java.awt.Dimension(1000, 720));
        jLabel1.setRequestFocusEnabled(false);

        painelDesktop.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout painelDesktopLayout = new javax.swing.GroupLayout(painelDesktop);
        painelDesktop.setLayout(painelDesktopLayout);
        painelDesktopLayout.setHorizontalGroup(
            painelDesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1184, Short.MAX_VALUE)
            .addGroup(painelDesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(painelDesktopLayout.createSequentialGroup()
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1178, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        painelDesktopLayout.setVerticalGroup(
            painelDesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 720, Short.MAX_VALUE)
            .addGroup(painelDesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(painelDesktopLayout.createSequentialGroup()
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pnlMenuSelecionado.setOpaque(false);
        pnlMenuSelecionado.setPreferredSize(new java.awt.Dimension(1280, 730));

        lbPessoas.setFont(new java.awt.Font("Nexa Bold", 0, 12)); // NOI18N
        lbPessoas.setForeground(new java.awt.Color(255, 255, 255));
        lbPessoas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPessoas.setText("PESSOAS");
        lbPessoas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lbPessoas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbPessoasMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbPessoasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbPessoasMouseExited(evt);
            }
        });

        lbReceitas.setFont(new java.awt.Font("Nexa Bold", 0, 12)); // NOI18N
        lbReceitas.setForeground(new java.awt.Color(255, 255, 255));
        lbReceitas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbReceitas.setText("RECEITAS");
        lbReceitas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lbReceitas.setMaximumSize(new java.awt.Dimension(56, 15));
        lbReceitas.setMinimumSize(new java.awt.Dimension(56, 15));
        lbReceitas.setPreferredSize(new java.awt.Dimension(56, 15));
        lbReceitas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbReceitasMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbReceitasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbReceitasMouseExited(evt);
            }
        });

        lbFermentos.setFont(new java.awt.Font("Nexa Bold", 0, 12)); // NOI18N
        lbFermentos.setForeground(new java.awt.Color(255, 255, 255));
        lbFermentos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbFermentos.setText("FERMENTOS");
        lbFermentos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lbFermentos.setMaximumSize(new java.awt.Dimension(56, 15));
        lbFermentos.setMinimumSize(new java.awt.Dimension(56, 15));
        lbFermentos.setPreferredSize(new java.awt.Dimension(56, 15));
        lbFermentos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbFermentosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbFermentosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbFermentosMouseExited(evt);
            }
        });

        lbEntrada.setFont(new java.awt.Font("Nexa Bold", 0, 12)); // NOI18N
        lbEntrada.setForeground(new java.awt.Color(255, 255, 255));
        lbEntrada.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbEntrada.setText("ENTRADA");
        lbEntrada.setToolTipText("");
        lbEntrada.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lbEntrada.setMaximumSize(new java.awt.Dimension(56, 15));
        lbEntrada.setMinimumSize(new java.awt.Dimension(56, 15));
        lbEntrada.setPreferredSize(new java.awt.Dimension(56, 15));
        lbEntrada.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbEntradaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbEntradaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbEntradaMouseExited(evt);
            }
        });

        lbClassificacao.setFont(new java.awt.Font("Nexa Bold", 0, 12)); // NOI18N
        lbClassificacao.setForeground(new java.awt.Color(255, 255, 255));
        lbClassificacao.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbClassificacao.setText("CLASSIFICAÇÃO");
        lbClassificacao.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lbClassificacao.setMaximumSize(new java.awt.Dimension(56, 15));
        lbClassificacao.setMinimumSize(new java.awt.Dimension(56, 15));
        lbClassificacao.setPreferredSize(new java.awt.Dimension(56, 15));
        lbClassificacao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbClassificacaoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbClassificacaoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbClassificacaoMouseExited(evt);
            }
        });

        lbFabricacao.setFont(new java.awt.Font("Nexa Bold", 0, 12)); // NOI18N
        lbFabricacao.setForeground(new java.awt.Color(255, 255, 255));
        lbFabricacao.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbFabricacao.setText("FABRICAÇÃO");
        lbFabricacao.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lbFabricacao.setMaximumSize(new java.awt.Dimension(56, 15));
        lbFabricacao.setMinimumSize(new java.awt.Dimension(56, 15));
        lbFabricacao.setPreferredSize(new java.awt.Dimension(56, 15));
        lbFabricacao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbFabricacaoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbFabricacaoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbFabricacaoMouseExited(evt);
            }
        });

        lbRelatorios.setFont(new java.awt.Font("Nexa Bold", 0, 12)); // NOI18N
        lbRelatorios.setForeground(new java.awt.Color(255, 255, 255));
        lbRelatorios.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbRelatorios.setText("RELATÓRIOS");
        lbRelatorios.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lbRelatorios.setMaximumSize(new java.awt.Dimension(56, 15));
        lbRelatorios.setMinimumSize(new java.awt.Dimension(56, 15));
        lbRelatorios.setPreferredSize(new java.awt.Dimension(56, 15));
        lbRelatorios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbRelatoriosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbRelatoriosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbRelatoriosMouseExited(evt);
            }
        });

        javax.swing.GroupLayout pnlMenuSelecionadoLayout = new javax.swing.GroupLayout(pnlMenuSelecionado);
        pnlMenuSelecionado.setLayout(pnlMenuSelecionadoLayout);
        pnlMenuSelecionadoLayout.setHorizontalGroup(
            pnlMenuSelecionadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuSelecionadoLayout.createSequentialGroup()
                .addGroup(pnlMenuSelecionadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbRelatorios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbFabricacao, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                    .addComponent(lbClassificacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbEntrada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbFermentos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbReceitas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbPessoas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlMenuSelecionadoLayout.setVerticalGroup(
            pnlMenuSelecionadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMenuSelecionadoLayout.createSequentialGroup()
                .addContainerGap(278, Short.MAX_VALUE)
                .addComponent(lbPessoas, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(lbReceitas, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(lbFermentos, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(lbEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbClassificacao, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(lbFabricacao, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbRelatorios, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75))
        );

        jLayeredPane2.setPreferredSize(new java.awt.Dimension(1366, 720));

        imgDesktop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/desktopQueijos.jpg"))); // NOI18N

        javax.swing.GroupLayout pnlBgGeralLayout = new javax.swing.GroupLayout(pnlBgGeral);
        pnlBgGeral.setLayout(pnlBgGeralLayout);
        pnlBgGeralLayout.setHorizontalGroup(
            pnlBgGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imgDesktop, javax.swing.GroupLayout.DEFAULT_SIZE, 1372, Short.MAX_VALUE)
        );
        pnlBgGeralLayout.setVerticalGroup(
            pnlBgGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imgDesktop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLayeredPane2.setLayer(pnlBgGeral, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane2Layout = new javax.swing.GroupLayout(jLayeredPane2);
        jLayeredPane2.setLayout(jLayeredPane2Layout);
        jLayeredPane2Layout.setHorizontalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1372, Short.MAX_VALUE)
            .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane2Layout.createSequentialGroup()
                    .addComponent(pnlBgGeral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jLayeredPane2Layout.setVerticalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 749, Short.MAX_VALUE)
            .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane2Layout.createSequentialGroup()
                    .addComponent(pnlBgGeral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1378, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(188, Short.MAX_VALUE)
                    .addComponent(painelDesktop, javax.swing.GroupLayout.PREFERRED_SIZE, 1184, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addComponent(pnlMenuSelecionado, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 1193, Short.MAX_VALUE)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(191, Short.MAX_VALUE)
                    .addComponent(pnlMenssagem, javax.swing.GroupLayout.PREFERRED_SIZE, 1181, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addComponent(jLayeredPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1372, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 749, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addComponent(painelDesktop, javax.swing.GroupLayout.PREFERRED_SIZE, 692, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 57, Short.MAX_VALUE)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnlMenuSelecionado, javax.swing.GroupLayout.DEFAULT_SIZE, 749, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addGap(0, 725, Short.MAX_VALUE)
                    .addComponent(pnlMenssagem, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLayeredPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 749, Short.MAX_VALUE))
        );

        pnlInicio.add(jPanel1, "card2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1366, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(pnlInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 749, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnlInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleDescription("");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lbFermentosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbFermentosMouseExited

        lbFermentos.setForeground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_lbFermentosMouseExited

    private void lbFermentosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbFermentosMouseEntered
        lbFermentos.setForeground(new java.awt.Color(218, 1, 68));

    }//GEN-LAST:event_lbFermentosMouseEntered

    private void lbReceitasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbReceitasMouseExited

        lbReceitas.setForeground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_lbReceitasMouseExited

    private void lbReceitasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbReceitasMouseEntered
        lbReceitas.setForeground(new java.awt.Color(218, 1, 68));

    }//GEN-LAST:event_lbReceitasMouseEntered

    private void lbPessoasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbPessoasMouseExited
        lbPessoas.setForeground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_lbPessoasMouseExited

    private void lbPessoasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbPessoasMouseEntered
        lbPessoas.setForeground(new java.awt.Color(218, 1, 68));
    }//GEN-LAST:event_lbPessoasMouseEntered

    private void lbFabricacaoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbFabricacaoMouseExited

        lbFabricacao.setForeground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_lbFabricacaoMouseExited

    private void lbFabricacaoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbFabricacaoMouseEntered
        lbFabricacao.setForeground(new java.awt.Color(218, 1, 68));

    }//GEN-LAST:event_lbFabricacaoMouseEntered

    private void lbClassificacaoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbClassificacaoMouseExited

        lbClassificacao.setForeground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_lbClassificacaoMouseExited

    private void lbClassificacaoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbClassificacaoMouseEntered
        lbClassificacao.setForeground(new java.awt.Color(218, 1, 68));

    }//GEN-LAST:event_lbClassificacaoMouseEntered

    private void lbEntradaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbEntradaMouseExited

        lbEntrada.setForeground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_lbEntradaMouseExited

    private void lbEntradaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbEntradaMouseEntered
        lbEntrada.setForeground(new java.awt.Color(218, 1, 68));

    }//GEN-LAST:event_lbEntradaMouseEntered

    private void lbEntradaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbEntradaMouseClicked

        TelaColetaLeiteView formEntrada;
        try {
            formEntrada = new TelaColetaLeiteView();
            painelDesktop.add(formEntrada);
            formEntrada.setPosicao();
            formEntrada.setVisible(true);
        } catch (ParseException ex) {
            Logger.getLogger(TelaPrincipalView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DbException ex) {
            Logger.getLogger(TelaPrincipalView.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_lbEntradaMouseClicked

    private void lbClassificacaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbClassificacaoMouseClicked
        TelaClassificacaoLeiteView formClassificacao = new TelaClassificacaoLeiteView();
        painelDesktop.add(formClassificacao);
        formClassificacao.setPosicao();
        formClassificacao.setVisible(true);

    }//GEN-LAST:event_lbClassificacaoMouseClicked

    private void lbFabricacaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbFabricacaoMouseClicked
        TelaFabricacaoQueijoView formProcessamento = new TelaFabricacaoQueijoView();
        painelDesktop.add(formProcessamento);
        formProcessamento.setPosicao();
        formProcessamento.setVisible(true);

    }//GEN-LAST:event_lbFabricacaoMouseClicked

    private void lbPessoasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbPessoasMouseClicked
        TelaPessoaView formPessoa;
        try {
            formPessoa = new TelaPessoaView();
            painelDesktop.add(formPessoa);
            formPessoa.setPosicao();
            formPessoa.setVisible(true);
        } catch (ParseException ex) {
            Logger.getLogger(TelaPrincipalView.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_lbPessoasMouseClicked

    private void lbReceitasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbReceitasMouseClicked
        TelaReceitaQueijoView formItem = new TelaReceitaQueijoView();
        painelDesktop.add(formItem);
        formItem.setPosicao();
        formItem.setVisible(true);
    }//GEN-LAST:event_lbReceitasMouseClicked

    private void lbFermentosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbFermentosMouseClicked
        TelaFermentoView formFermento = new TelaFermentoView();
        painelDesktop.add(formFermento);
        //formRelatorio.setPosicao();
        formFermento.setVisible(true);
    }//GEN-LAST:event_lbFermentosMouseClicked

    private void lbRelatoriosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbRelatoriosMouseClicked
        TelaRelatorio formRelatorio = new TelaRelatorio();
        painelDesktop.add(formRelatorio);
        //formRelatorio.setPosicao();
        formRelatorio.setVisible(true);  // TODO add your handling code here:
    }//GEN-LAST:event_lbRelatoriosMouseClicked

    private void lbRelatoriosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbRelatoriosMouseEntered
        lbRelatorios.setForeground(new java.awt.Color(218, 1, 68));

    }//GEN-LAST:event_lbRelatoriosMouseEntered

    private void lbRelatoriosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbRelatoriosMouseExited

        lbRelatorios.setForeground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_lbRelatoriosMouseExited

    public void setMenssagem(String menssagem, Color corFundo) {
        lblMenssagem.setText(menssagem);
        //lblMenssagem.setForeground(Color.WHITE);
        pnlMenssagem.setBackground(corFundo);

        ActionListener taskPerformer = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                lblMenssagem.setText(" ");
                //lblMenssagem.setForeground(Color.BLACK);
                pnlMenssagem.setBackground(Color.white);
            }
        };
        Timer timer = new Timer(5000, taskPerformer);
        timer.setRepeats(false);
        timer.start();

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel imgDesktop;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbClassificacao;
    private javax.swing.JLabel lbEntrada;
    private javax.swing.JLabel lbFabricacao;
    private javax.swing.JLabel lbFermentos;
    private javax.swing.JLabel lbPessoas;
    private javax.swing.JLabel lbReceitas;
    private javax.swing.JLabel lbRelatorios;
    private javax.swing.JLabel lblMenssagem;
    private javax.swing.JDesktopPane painelDesktop;
    private javax.swing.JPanel pnlBgGeral;
    private javax.swing.JPanel pnlInicio;
    private javax.swing.JPanel pnlMenssagem;
    private javax.swing.JPanel pnlMenuSelecionado;
    // End of variables declaration//GEN-END:variables
}
