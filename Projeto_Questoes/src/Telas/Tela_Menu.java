package Telas;

import javax.swing.JOptionPane;
import Classes.Usuario_Token;

public class Tela_Menu extends javax.swing.JFrame {

    Usuario_Token ut = Usuario_Token.getInstance();

    public Tela_Menu() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mi_AdicionarRodada = new javax.swing.JMenuItem();
        mi_EditarRodada = new javax.swing.JMenuItem();
        mi_GerenciarEquipes = new javax.swing.JMenuItem();
        mi_AvaliarRecursos = new javax.swing.JMenuItem();
        mi_AjustarPontuacao = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        mi_AdicionarQuestionario = new javax.swing.JMenuItem();
        mi_ResponderQuestionario = new javax.swing.JMenuItem();
        mi_CorrigirQuestionario = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        mi_ResponderDesafio = new javax.swing.JMenuItem();
        mi_CorrigirDesafio = new javax.swing.JMenuItem();
        mi_ConsultarDesafio = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        mi_ConsultarRaking = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        mi_AdicionarRecurso = new javax.swing.JMenuItem();
        mi_ListarRecurso = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        mi_Perfil = new javax.swing.JMenuItem();
        mi_Sair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/monitor.png"))); // NOI18N
        jMenu1.setText("Administrador");

        mi_AdicionarRodada.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/application_form_add.png"))); // NOI18N
        mi_AdicionarRodada.setText("Adicionar Nova Rodada");
        mi_AdicionarRodada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_AdicionarRodadaActionPerformed(evt);
            }
        });
        jMenu1.add(mi_AdicionarRodada);

        mi_EditarRodada.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/application_form_edit.png"))); // NOI18N
        mi_EditarRodada.setText("Editar Rodada");
        mi_EditarRodada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_EditarRodadaActionPerformed(evt);
            }
        });
        jMenu1.add(mi_EditarRodada);

        mi_GerenciarEquipes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/group.png"))); // NOI18N
        mi_GerenciarEquipes.setText("Gerenciar Equipes");
        mi_GerenciarEquipes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_GerenciarEquipesActionPerformed(evt);
            }
        });
        jMenu1.add(mi_GerenciarEquipes);

        mi_AvaliarRecursos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/folder_go.png"))); // NOI18N
        mi_AvaliarRecursos.setText("Avaliar Recursos");
        mi_AvaliarRecursos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_AvaliarRecursosActionPerformed(evt);
            }
        });
        jMenu1.add(mi_AvaliarRecursos);

        mi_AjustarPontuacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/lightning.png"))); // NOI18N
        mi_AjustarPontuacao.setText("Ajustar Pontuação");
        mi_AjustarPontuacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_AjustarPontuacaoActionPerformed(evt);
            }
        });
        jMenu1.add(mi_AjustarPontuacao);

        jMenuBar1.add(jMenu1);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/book.png"))); // NOI18N
        jMenu2.setText("Questionario");

        mi_AdicionarQuestionario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/book_add.png"))); // NOI18N
        mi_AdicionarQuestionario.setText("Adicionar Questionario");
        mi_AdicionarQuestionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_AdicionarQuestionarioActionPerformed(evt);
            }
        });
        jMenu2.add(mi_AdicionarQuestionario);

        mi_ResponderQuestionario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/book_go.png"))); // NOI18N
        mi_ResponderQuestionario.setText("Responder Questionario");
        mi_ResponderQuestionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_ResponderQuestionarioActionPerformed(evt);
            }
        });
        jMenu2.add(mi_ResponderQuestionario);

        mi_CorrigirQuestionario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/book_open.png"))); // NOI18N
        mi_CorrigirQuestionario.setText("Corrigir Respostas");
        mi_CorrigirQuestionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_CorrigirQuestionarioActionPerformed(evt);
            }
        });
        jMenu2.add(mi_CorrigirQuestionario);

        jMenuBar1.add(jMenu2);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/medal_gold_1.png"))); // NOI18N
        jMenu3.setText("Desafio");

        mi_ResponderDesafio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/coins.png"))); // NOI18N
        mi_ResponderDesafio.setText("Responder Desafio");
        mi_ResponderDesafio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_ResponderDesafioActionPerformed(evt);
            }
        });
        jMenu3.add(mi_ResponderDesafio);

        mi_CorrigirDesafio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/coins_add.png"))); // NOI18N
        mi_CorrigirDesafio.setText("Corrigir Desafio");
        mi_CorrigirDesafio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_CorrigirDesafioActionPerformed(evt);
            }
        });
        jMenu3.add(mi_CorrigirDesafio);

        mi_ConsultarDesafio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/zoom.png"))); // NOI18N
        mi_ConsultarDesafio.setText("Consultar Desafio");
        mi_ConsultarDesafio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_ConsultarDesafioActionPerformed(evt);
            }
        });
        jMenu3.add(mi_ConsultarDesafio);

        jMenuBar1.add(jMenu3);

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/star.png"))); // NOI18N
        jMenu4.setText("Rankeamento");

        mi_ConsultarRaking.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/page_white_medal.png"))); // NOI18N
        mi_ConsultarRaking.setText("Consultar Ranking");
        mi_ConsultarRaking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_ConsultarRakingActionPerformed(evt);
            }
        });
        jMenu4.add(mi_ConsultarRaking);

        jMenuBar1.add(jMenu4);

        jMenu6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/folder.png"))); // NOI18N
        jMenu6.setText("Recurso");

        mi_AdicionarRecurso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/folder_add.png"))); // NOI18N
        mi_AdicionarRecurso.setText("Adicionar Recurso");
        mi_AdicionarRecurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_AdicionarRecursoActionPerformed(evt);
            }
        });
        jMenu6.add(mi_AdicionarRecurso);

        mi_ListarRecurso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/folder_magnify.png"))); // NOI18N
        mi_ListarRecurso.setText("Listar Recursos");
        mi_ListarRecurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_ListarRecursoActionPerformed(evt);
            }
        });
        jMenu6.add(mi_ListarRecurso);

        jMenuBar1.add(jMenu6);

        jMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/user.png"))); // NOI18N
        jMenu5.setText("Conta");

        mi_Perfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/cog.png"))); // NOI18N
        mi_Perfil.setText("Perfil");
        mi_Perfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_PerfilActionPerformed(evt);
            }
        });
        jMenu5.add(mi_Perfil);

        mi_Sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/door_out.png"))); // NOI18N
        mi_Sair.setText("Sair");
        mi_Sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_SairActionPerformed(evt);
            }
        });
        jMenu5.add(mi_Sair);

        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 610, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 402, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void mi_AdicionarRodadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_AdicionarRodadaActionPerformed
        if (ut.getTipo().equals("admin")) {
            Tela_AdicionarRodada tar = new Tela_AdicionarRodada(this, true);
            tar.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Acesso negado");
        }
    }//GEN-LAST:event_mi_AdicionarRodadaActionPerformed

    private void mi_AdicionarQuestionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_AdicionarQuestionarioActionPerformed
        if (ut.getTipo().equals("user")) {
            Tela_AdicionarQuestionario taq = new Tela_AdicionarQuestionario(this, true);
            taq.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Acesso negado");
        }
    }//GEN-LAST:event_mi_AdicionarQuestionarioActionPerformed

    private void mi_ResponderQuestionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_ResponderQuestionarioActionPerformed

        if (ut.getTipo().equals("user")) {
            Tela_ResponderQuestionario trq = new Tela_ResponderQuestionario(this, true);
            trq.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Acesso negado");
        }

    }//GEN-LAST:event_mi_ResponderQuestionarioActionPerformed

    private void mi_ResponderDesafioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_ResponderDesafioActionPerformed
        if (ut.getTipo().equals("user")) {
            Tela_ResponderDesafio td = new Tela_ResponderDesafio(this, true);
            td.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Acesso negado");
        }
    }//GEN-LAST:event_mi_ResponderDesafioActionPerformed

    private void mi_CorrigirQuestionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_CorrigirQuestionarioActionPerformed
        if (ut.getTipo().equals("user")) {
            Tela_CorrigirRespostas tc = new Tela_CorrigirRespostas(this, true);
            tc.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Acesso negado");
        }
    }//GEN-LAST:event_mi_CorrigirQuestionarioActionPerformed

    private void mi_AdicionarRecursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_AdicionarRecursoActionPerformed
        if (ut.getTipo().equals("user")) {
            Tela_AdicionarRecurso tc = new Tela_AdicionarRecurso(this, true);
            tc.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Acesso negado");
        }
    }//GEN-LAST:event_mi_AdicionarRecursoActionPerformed

    private void mi_ListarRecursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_ListarRecursoActionPerformed
        if (ut.getTipo().equals("user")) {
            Tela_ListarRecursos tc = new Tela_ListarRecursos(this, true);
            tc.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Acesso negado");
        }
    }//GEN-LAST:event_mi_ListarRecursoActionPerformed

    private void mi_SairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_SairActionPerformed
        Tela_Login tp = new Tela_Login();
        tp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_mi_SairActionPerformed

    private void mi_CorrigirDesafioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_CorrigirDesafioActionPerformed
        if (ut.getTipo().equals("admin")) {
            Tela_CorrigirRespostaDesafio trd = new Tela_CorrigirRespostaDesafio(this, true);
            trd.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Acesso negado");
        }
    }//GEN-LAST:event_mi_CorrigirDesafioActionPerformed

    private void mi_ConsultarDesafioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_ConsultarDesafioActionPerformed
        if (ut.getTipo().equals("user")) {
            Tela_ConsultarDesafio tcd = new Tela_ConsultarDesafio(this, true);
            tcd.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Acesso negado");
        }
    }//GEN-LAST:event_mi_ConsultarDesafioActionPerformed

    private void mi_GerenciarEquipesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_GerenciarEquipesActionPerformed
        if (ut.getTipo().equals("admin")) {
            Tela_GerenciarEquipes tge = new Tela_GerenciarEquipes(this, true);
            tge.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Acesso negado");
        }
    }//GEN-LAST:event_mi_GerenciarEquipesActionPerformed

    private void mi_AvaliarRecursosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_AvaliarRecursosActionPerformed
        if (ut.getTipo().equals("admin")) {
            Tela_AvaliarRercursos tar = new Tela_AvaliarRercursos(this, true);
            tar.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Acesso negado");
        }
    }//GEN-LAST:event_mi_AvaliarRecursosActionPerformed

    private void mi_AjustarPontuacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_AjustarPontuacaoActionPerformed
        if (ut.getTipo().equals("admin")) {
            Tela_AjustarPontuacao tar = new Tela_AjustarPontuacao(this, true);
            tar.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Acesso negado");
        }
    }//GEN-LAST:event_mi_AjustarPontuacaoActionPerformed

    private void mi_PerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_PerfilActionPerformed
        if (ut.getTipo().equals("user")) {
            Tela_Perfil tp = new Tela_Perfil(this, true);
            tp.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Acesso negado");
        }
    }//GEN-LAST:event_mi_PerfilActionPerformed

    private void mi_EditarRodadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_EditarRodadaActionPerformed
        if (ut.getTipo().equals("admin")) {
            Tela_AtualizarRodada tar = new Tela_AtualizarRodada(this, true);
            tar.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Acesso negado");
        }
    }//GEN-LAST:event_mi_EditarRodadaActionPerformed

    private void mi_ConsultarRakingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_ConsultarRakingActionPerformed
            Tela_Ranking tr = new Tela_Ranking(this, true);
            tr.setVisible(true);
    }//GEN-LAST:event_mi_ConsultarRakingActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Tela_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tela_Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem mi_AdicionarQuestionario;
    private javax.swing.JMenuItem mi_AdicionarRecurso;
    private javax.swing.JMenuItem mi_AdicionarRodada;
    private javax.swing.JMenuItem mi_AjustarPontuacao;
    private javax.swing.JMenuItem mi_AvaliarRecursos;
    private javax.swing.JMenuItem mi_ConsultarDesafio;
    private javax.swing.JMenuItem mi_ConsultarRaking;
    private javax.swing.JMenuItem mi_CorrigirDesafio;
    private javax.swing.JMenuItem mi_CorrigirQuestionario;
    private javax.swing.JMenuItem mi_EditarRodada;
    private javax.swing.JMenuItem mi_GerenciarEquipes;
    private javax.swing.JMenuItem mi_ListarRecurso;
    private javax.swing.JMenuItem mi_Perfil;
    private javax.swing.JMenuItem mi_ResponderDesafio;
    private javax.swing.JMenuItem mi_ResponderQuestionario;
    private javax.swing.JMenuItem mi_Sair;
    // End of variables declaration//GEN-END:variables
}
