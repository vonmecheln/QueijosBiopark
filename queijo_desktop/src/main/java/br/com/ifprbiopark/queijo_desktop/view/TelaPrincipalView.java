package br.com.ifprbiopark.queijo_desktop.view;

import java.awt.Color;
import java.beans.PropertyVetoException;
import java.text.ParseException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TelaPrincipalView extends javax.swing.JFrame {

    /**
     * Creates new form TelaPrincipal
     */
    public TelaPrincipalView() {
        initComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuCadastro = new javax.swing.JMenu();
        menuPessoa = new javax.swing.JMenuItem();
        menuEntradaLeite = new javax.swing.JMenuItem();
        menuClassificacaoLeite = new javax.swing.JMenuItem();
        menuItem = new javax.swing.JMenuItem();
        menuProcessamento = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        pnlInicio = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        pnlMenssagem = new javax.swing.JPanel();
        lblMenssagem = new javax.swing.JLabel();
        painelDesktop = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        pnlMenuSelecionado = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        pnlBgGeral = new javax.swing.JPanel();
        imgDesktop = new javax.swing.JLabel();

        jMenuItem1.setText("jMenuItem1");

        menuCadastro.setText("Cadastro");

        menuPessoa.setText("Pessoa");
        menuPessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPessoaActionPerformed(evt);
            }
        });
        menuCadastro.add(menuPessoa);

        menuEntradaLeite.setText("Entrada de Leite");
        menuEntradaLeite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEntradaLeiteActionPerformed(evt);
            }
        });
        menuCadastro.add(menuEntradaLeite);

        menuClassificacaoLeite.setText("Classificação de Leite");
        menuClassificacaoLeite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuClassificacaoLeiteActionPerformed(evt);
            }
        });
        menuCadastro.add(menuClassificacaoLeite);

        menuItem.setText("Item");
        menuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemActionPerformed(evt);
            }
        });
        menuCadastro.add(menuItem);

        menuProcessamento.setText("Processamento");
        menuProcessamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuProcessamentoActionPerformed(evt);
            }
        });
        menuCadastro.add(menuProcessamento);

        jMenuBar1.add(menuCadastro);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1366, 720));
        setResizable(false);

        pnlInicio.setLayout(new java.awt.CardLayout());

        jPanel1.setPreferredSize(new java.awt.Dimension(1366, 720));
        jPanel1.setRequestFocusEnabled(false);

        pnlMenssagem.setBackground(new java.awt.Color(240, 240, 240));
        pnlMenssagem.setLayout(new java.awt.CardLayout());

        lblMenssagem.setText(" ");
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

        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel2MouseExited(evt);
            }
        });

        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel3MouseExited(evt);
            }
        });

        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel4MouseExited(evt);
            }
        });

        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel5MouseExited(evt);
            }
        });

        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel6MouseExited(evt);
            }
        });

        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel7MouseExited(evt);
            }
        });

        javax.swing.GroupLayout pnlMenuSelecionadoLayout = new javax.swing.GroupLayout(pnlMenuSelecionado);
        pnlMenuSelecionado.setLayout(pnlMenuSelecionadoLayout);
        pnlMenuSelecionadoLayout.setHorizontalGroup(
            pnlMenuSelecionadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        pnlMenuSelecionadoLayout.setVerticalGroup(
            pnlMenuSelecionadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuSelecionadoLayout.createSequentialGroup()
                .addGap(284, 284, 284)
                .addGroup(pnlMenuSelecionadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMenuSelecionadoLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 3, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(169, Short.MAX_VALUE))
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
            .addGap(0, 720, Short.MAX_VALUE)
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
            .addGap(0, 720, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addComponent(painelDesktop, javax.swing.GroupLayout.PREFERRED_SIZE, 697, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 23, Short.MAX_VALUE)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnlMenuSelecionado, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addGap(0, 705, Short.MAX_VALUE)
                    .addComponent(pnlMenssagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLayeredPane2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            .addGap(0, 720, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnlInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleDescription("");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menuProcessamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuProcessamentoActionPerformed
        try {
            TelaProcessamentoView formProcessamentoe = new TelaProcessamentoView();
            painelDesktop.add(formProcessamentoe);
            formProcessamentoe.setMaximum(false);
            formProcessamentoe.setVisible(true);
            formProcessamentoe.setPosicao();
        } catch (PropertyVetoException ex) {
            Logger.getLogger(TelaPrincipalView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_menuProcessamentoActionPerformed

    private void menuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemActionPerformed
        try {
            TelaItemView formItem = new TelaItemView();
            painelDesktop.add(formItem);
            formItem.setMaximum(false);
            formItem.setVisible(true);
            formItem.setPosicao();
        } catch (PropertyVetoException ex) {
            Logger.getLogger(TelaPrincipalView.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_menuItemActionPerformed

    private void menuClassificacaoLeiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuClassificacaoLeiteActionPerformed
        try {
            TelaClassificacaoLeiteView formClassificacaoLeite = new TelaClassificacaoLeiteView();
            painelDesktop.add(formClassificacaoLeite);
            formClassificacaoLeite.setMaximum(false);
            formClassificacaoLeite.setVisible(true);
            formClassificacaoLeite.setPosicao();
        } catch (PropertyVetoException ex) {
            Logger.getLogger(TelaPrincipalView.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_menuClassificacaoLeiteActionPerformed

    private void menuEntradaLeiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEntradaLeiteActionPerformed
        try {
            TelaColetaLeiteView formEntradaLeite = new TelaColetaLeiteView();
            painelDesktop.add(formEntradaLeite);
            formEntradaLeite.setMaximum(false);
            formEntradaLeite.setVisible(true);
            formEntradaLeite.setPosicao();
        } catch (PropertyVetoException ex) {
            Logger.getLogger(TelaPrincipalView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(TelaPrincipalView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_menuEntradaLeiteActionPerformed

    private void menuPessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPessoaActionPerformed
        try {
            TelaPessoaView formPessoa = new TelaPessoaView();
            painelDesktop.add(formPessoa);
            formPessoa.setMaximum(false);
            formPessoa.setVisible(true);
            formPessoa.setPosicao();
        } catch (PropertyVetoException ex) {
            Logger.getLogger(TelaPrincipalView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_menuPessoaActionPerformed

    private void jLabel7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseExited
        jLabel7.setIcon(null); // NOI18N
        jLabel7.setPreferredSize(new java.awt.Dimension(211, 243));// TODO add your handling code here:
    }//GEN-LAST:event_jLabel7MouseExited

    private void jLabel7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseEntered
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btRelatorios.jpg")));
        jLabel7.setPreferredSize(new java.awt.Dimension(211, 243));   // TODO add your handling code here:
    }//GEN-LAST:event_jLabel7MouseEntered

    private void jLabel6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseExited
        jLabel6.setIcon(null); // NOI18N
        jLabel6.setPreferredSize(new java.awt.Dimension(211, 243));// TODO add your handling code here:
    }//GEN-LAST:event_jLabel6MouseExited

    private void jLabel6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseEntered
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btReceitas.jpg")));
        jLabel6.setPreferredSize(new java.awt.Dimension(211, 243));    // TODO add your handling code here:
    }//GEN-LAST:event_jLabel6MouseEntered

    private void jLabel5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseExited
        jLabel5.setIcon(null); // NOI18N
        jLabel5.setPreferredSize(new java.awt.Dimension(211, 243));// TODO add your handling code here:
    }//GEN-LAST:event_jLabel5MouseExited

    private void jLabel5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseEntered
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btProcessamento.jpg")));
        jLabel5.setPreferredSize(new java.awt.Dimension(211, 243));    // TODO add your handling code here:
    }//GEN-LAST:event_jLabel5MouseEntered

    private void jLabel4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseExited
        jLabel4.setIcon(null); // NOI18N
        jLabel4.setPreferredSize(new java.awt.Dimension(211, 243));// TODO add your handling code here:
    }//GEN-LAST:event_jLabel4MouseExited

    private void jLabel4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseEntered
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btClassificacao.jpg")));
        jLabel4.setPreferredSize(new java.awt.Dimension(211, 243));   // TODO add your handling code here:
    }//GEN-LAST:event_jLabel4MouseEntered

    private void jLabel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseExited
        jLabel3.setIcon(null); // NOI18N
        jLabel3.setPreferredSize(new java.awt.Dimension(211, 243));// TODO add your handling code here:
    }//GEN-LAST:event_jLabel3MouseExited

    private void jLabel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseEntered
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btEntrada.jpg")));
        jLabel3.setPreferredSize(new java.awt.Dimension(211, 243));    // TODO add your handling code here:
    }//GEN-LAST:event_jLabel3MouseEntered

    private void jLabel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseExited
        jLabel2.setIcon(null); // NOI18N
        jLabel2.setPreferredSize(new java.awt.Dimension(211, 243));     // TODO add your handling code here:
    }//GEN-LAST:event_jLabel2MouseExited

    private void jLabel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseEntered
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btPessoas.jpg")));
        jLabel2.setPreferredSize(new java.awt.Dimension(211, 243));
    }//GEN-LAST:event_jLabel2MouseEntered

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        TelaPessoaView formPessoa = new TelaPessoaView();
        painelDesktop.add(formPessoa);
        formPessoa.setVisible(true);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        TelaEntradaLeiteView formEntrada = new TelaEntradaLeiteView();
        painelDesktop.add(formEntrada);
        formEntrada.setVisible(true);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        TelaClassificacaoLeiteView formClassificacao = new TelaClassificacaoLeiteView();
        painelDesktop.add(formClassificacao);
        formClassificacao.setVisible(true);       
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        TelaProcessamentoView formProcessamento = new TelaProcessamentoView();
        painelDesktop.add(formProcessamento);
        formProcessamento.setVisible(true); 
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        TelaItemView formItem = new TelaItemView();
        painelDesktop.add(formItem);
        formItem.setVisible(true);
    }//GEN-LAST:event_jLabel6MouseClicked

    public void setMenssagem(String menssagem, Color corFundo) {
        lblMenssagem.setText(menssagem);
        lblMenssagem.setForeground(Color.WHITE);
        lblMenssagem.setBackground(corFundo);

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask(){
            public void run(){
                lblMenssagem.setText(" ");
                lblMenssagem.setForeground(Color.BLACK);
                lblMenssagem.setBackground(Color.LIGHT_GRAY);
            }
        }, 5000, 1000);
        
        timer.cancel();
        

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel imgDesktop;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblMenssagem;
    private javax.swing.JMenu menuCadastro;
    private javax.swing.JMenuItem menuClassificacaoLeite;
    private javax.swing.JMenuItem menuEntradaLeite;
    private javax.swing.JMenuItem menuItem;
    private javax.swing.JMenuItem menuPessoa;
    private javax.swing.JMenuItem menuProcessamento;
    private javax.swing.JDesktopPane painelDesktop;
    private javax.swing.JPanel pnlBgGeral;
    private javax.swing.JPanel pnlInicio;
    private javax.swing.JPanel pnlMenssagem;
    private javax.swing.JPanel pnlMenuSelecionado;
    // End of variables declaration//GEN-END:variables
}
