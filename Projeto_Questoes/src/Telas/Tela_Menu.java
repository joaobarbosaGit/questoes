package Telas;


import javax.swing.JOptionPane;

import Classes.Usuario_Token;



public class Tela_Menu extends javax.swing.JFrame {

    Usuario_Token ut = Usuario_Token.getInstance();
   
    
    public Tela_Menu() {
        initComponents();
        JOptionPane.showMessageDialog(null, "Bem vindo: "+ut.getNome());
        
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuAdicionarRodada = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        menuAdicionarQuestionario = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem11 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/monitor.png"))); // NOI18N
        jMenu1.setText("Administrador");

        menuAdicionarRodada.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/application_form_add.png"))); // NOI18N
        menuAdicionarRodada.setText("Adicionar Nova Rodada");
        menuAdicionarRodada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAdicionarRodadaActionPerformed(evt);
            }
        });
        jMenu1.add(menuAdicionarRodada);

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/application_form_edit.png"))); // NOI18N
        jMenuItem2.setText("Editar Rodada");
        jMenu1.add(jMenuItem2);

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/application_form_magnify.png"))); // NOI18N
        jMenuItem3.setText("Consultar Rodada");
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/page.png"))); // NOI18N
        jMenu2.setText("Questionario");

        menuAdicionarQuestionario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/book_add.png"))); // NOI18N
        menuAdicionarQuestionario.setText("Adicionar Questionario");
        menuAdicionarQuestionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAdicionarQuestionarioActionPerformed(evt);
            }
        });
        jMenu2.add(menuAdicionarQuestionario);

        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/book_edit.png"))); // NOI18N
        jMenuItem5.setText("Editar Questionario");
        jMenu2.add(jMenuItem5);

        jMenuItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/book_go.png"))); // NOI18N
        jMenuItem7.setText("Responder Questionario");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem7);

        jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/book_open.png"))); // NOI18N
        jMenuItem6.setText("Corrigir Questionario");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem6);

        jMenuBar1.add(jMenu2);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/medal_gold_1.png"))); // NOI18N
        jMenu3.setText("Desafio");

        jMenuItem8.setText("Responder Desafio");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem8);

        jMenuItem9.setText("Consultar Desafio");
        jMenu3.add(jMenuItem9);

        jMenuBar1.add(jMenu3);

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/star.png"))); // NOI18N
        jMenu4.setText("Rankeamento");

        jMenuItem10.setText("Consultar Rank");
        jMenu4.add(jMenuItem10);

        jMenuBar1.add(jMenu4);

        jMenu6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/book_add.png"))); // NOI18N
        jMenu6.setText("Recurso");

        jMenuItem1.setText("Abrir Recurso");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem1);

        jMenuItem4.setText("Listar Recursos");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem4);

        jMenuBar1.add(jMenu6);

        jMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/user.png"))); // NOI18N
        jMenu5.setText("Conta");

        jMenuItem11.setText("Sair");
        jMenu5.add(jMenuItem11);

        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1108, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 638, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menuAdicionarRodadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAdicionarRodadaActionPerformed
        if(ut.getTipo().equals("admin")){
           Tela_AdicionarRodada tar = new Tela_AdicionarRodada(this,true);
            tar.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(null,"Acesso negado");
        }
    }//GEN-LAST:event_menuAdicionarRodadaActionPerformed

    private void menuAdicionarQuestionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAdicionarQuestionarioActionPerformed
        if(ut.getTipo().equals("admin") || ut.getTipo().equals("user")){
           Tela_AdicionarQuestionario taq = new Tela_AdicionarQuestionario(this,true);
            taq.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(null,"Acesso negado");
        }
    }//GEN-LAST:event_menuAdicionarQuestionarioActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
         
        if(ut.getTipo().equals("admin") || ut.getTipo().equals("user")){
           Tela_ResponderQuestionario trq = new Tela_ResponderQuestionario(this, true);
           trq.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(null,"Acesso negado");
        }
        
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
       Tela_ResponderDesafio td = new Tela_ResponderDesafio(this,true);
       td.setVisible(true);
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
       Tela_CorrigirRespostas tc = new Tela_CorrigirRespostas(this,true);
       tc.setVisible(true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
       Tela_AdicionarRecurso tc = new Tela_AdicionarRecurso(this,true);
       tc.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
       Tela_ListarRercursos tc = new Tela_ListarRercursos(this,true);
       tc.setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

   
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
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JMenuItem menuAdicionarQuestionario;
    private javax.swing.JMenuItem menuAdicionarRodada;
    // End of variables declaration//GEN-END:variables
}
