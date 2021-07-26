package Telas;

import Classes.Equipe;
import Classes.Questao_Desafio;
import Classes.Resposta_Questao_Desafio;
import Classes.Usuario_Token;
import Servicos.Utilitarios;
import WebService.EquipeWebDAO;
import WebService.Questao_DesafioWebDAO;
import WebService.Resposta_Questao_DesafioWebDAO;
import javax.swing.JOptionPane;

public class Tela_ResponderDesafio extends javax.swing.JDialog {

    Utilitarios u = new Utilitarios();
    Usuario_Token ut = Usuario_Token.getInstance();
    Equipe e = new Equipe();
    EquipeWebDAO ewedao = new EquipeWebDAO();
    Questao_Desafio qd = new Questao_Desafio();
    Questao_DesafioWebDAO qdwdao = new Questao_DesafioWebDAO();
    Resposta_Questao_Desafio rqd = new Resposta_Questao_Desafio();
    Resposta_Questao_DesafioWebDAO rqdwdao = new Resposta_Questao_DesafioWebDAO();

    public Tela_ResponderDesafio(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        LimparCampos();
        BuscarQuestão();
    }

    public void LimparCampos() {

        ta_questoes_desafio.setEnabled(false);
        ta_resposta_desafio1.setText("");
        ta_resposta_desafio2.setText("");
        ta_resposta_desafio3.setText("");
        ta_questoes_desafio.setEnabledAt(1, false);
        ta_questoes_desafio.setEnabledAt(0, true);
        ta_questoes_desafio.setSelectedIndex(0);

    }

    public void BuscarQuestão() {

        ewedao.BuscarEquipe(e, ut.getEquipe_idEquipe());

        //QUESTÃO 01
        qdwdao.BuscarQuestaoDesafio(e.getIdQuestao_Desafio01(), qd);
        ta_questao_desafio1.setText(qd.getCorpo_Questao());
        qd = new Questao_Desafio();

        //QUESTÃO 02
        qdwdao.BuscarQuestaoDesafio(e.getIdQuestao_Desafio02(), qd);
        ta_questao_desafio2.setText(qd.getCorpo_Questao());
        qd = new Questao_Desafio();

        //QUESTÃO 03
        qdwdao.BuscarQuestaoDesafio(e.getIdQuestao_Desafio03(), qd);
        ta_questao_desafio3.setText(qd.getCorpo_Questao());
        qd = new Questao_Desafio();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ta_questoes_desafio = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ta_questao_desafio1 = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ta_resposta_desafio1 = new javax.swing.JTextArea();
        bt_avancar1 = new javax.swing.JButton();
        bt_cancelar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        ta_questao_desafio2 = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        ta_resposta_desafio2 = new javax.swing.JTextArea();
        bt_avancar2 = new javax.swing.JButton();
        bt_voltar1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        ta_questao_desafio3 = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        ta_resposta_desafio3 = new javax.swing.JTextArea();
        bt_salvar = new javax.swing.JButton();
        bt_voltar2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setText("Questão 01:");

        ta_questao_desafio1.setBackground(new java.awt.Color(204, 204, 204));
        ta_questao_desafio1.setColumns(20);
        ta_questao_desafio1.setLineWrap(true);
        ta_questao_desafio1.setRows(5);
        ta_questao_desafio1.setWrapStyleWord(true);
        ta_questao_desafio1.setEnabled(false);
        ta_questao_desafio1.setFocusable(false);
        jScrollPane1.setViewportView(ta_questao_desafio1);

        jLabel2.setText("Resposta 01:");

        ta_resposta_desafio1.setColumns(20);
        ta_resposta_desafio1.setLineWrap(true);
        ta_resposta_desafio1.setRows(5);
        ta_resposta_desafio1.setWrapStyleWord(true);
        jScrollPane2.setViewportView(ta_resposta_desafio1);

        bt_avancar1.setText("AVANÇAR");
        bt_avancar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_avancar1ActionPerformed(evt);
            }
        });

        bt_cancelar.setText("CANCELAR");
        bt_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(214, 568, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bt_cancelar)
                .addGap(18, 18, 18)
                .addComponent(bt_avancar1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_avancar1)
                    .addComponent(bt_cancelar))
                .addContainerGap())
        );

        ta_questoes_desafio.addTab("Questão 01", jPanel1);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel3.setText("Questão 02:");

        ta_questao_desafio2.setBackground(new java.awt.Color(204, 204, 204));
        ta_questao_desafio2.setColumns(20);
        ta_questao_desafio2.setLineWrap(true);
        ta_questao_desafio2.setRows(5);
        ta_questao_desafio2.setWrapStyleWord(true);
        ta_questao_desafio2.setEnabled(false);
        ta_questao_desafio2.setFocusable(false);
        jScrollPane3.setViewportView(ta_questao_desafio2);

        jLabel4.setText("Resposta 02:");

        ta_resposta_desafio2.setColumns(20);
        ta_resposta_desafio2.setLineWrap(true);
        ta_resposta_desafio2.setRows(5);
        ta_resposta_desafio2.setWrapStyleWord(true);
        jScrollPane4.setViewportView(ta_resposta_desafio2);

        bt_avancar2.setText("AVANÇAR");
        bt_avancar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_avancar2ActionPerformed(evt);
            }
        });

        bt_voltar1.setText("VOLTAR");
        bt_voltar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_voltar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane4)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(214, 568, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bt_voltar1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bt_avancar2)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_avancar2)
                    .addComponent(bt_voltar1))
                .addContainerGap())
        );

        ta_questoes_desafio.addTab("Questão 02", jPanel2);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel5.setText("Questão 03:");

        ta_questao_desafio3.setBackground(new java.awt.Color(204, 204, 204));
        ta_questao_desafio3.setColumns(20);
        ta_questao_desafio3.setLineWrap(true);
        ta_questao_desafio3.setRows(5);
        ta_questao_desafio3.setWrapStyleWord(true);
        ta_questao_desafio3.setEnabled(false);
        ta_questao_desafio3.setFocusable(false);
        jScrollPane5.setViewportView(ta_questao_desafio3);

        jLabel6.setText("Resposta 03:");

        ta_resposta_desafio3.setColumns(20);
        ta_resposta_desafio3.setLineWrap(true);
        ta_resposta_desafio3.setRows(5);
        ta_resposta_desafio3.setWrapStyleWord(true);
        jScrollPane6.setViewportView(ta_resposta_desafio3);

        bt_salvar.setText("SALVAR");
        bt_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_salvarActionPerformed(evt);
            }
        });

        bt_voltar2.setText("VOLTAR");
        bt_voltar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_voltar2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane6)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(214, 568, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bt_voltar2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bt_salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_salvar)
                    .addComponent(bt_voltar2))
                .addContainerGap())
        );

        ta_questoes_desafio.addTab("Questão 03", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ta_questoes_desafio)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ta_questoes_desafio, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bt_avancar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_avancar1ActionPerformed

        ta_questoes_desafio.setEnabledAt(0, false);
        ta_questoes_desafio.setEnabledAt(1, true);
        ta_questoes_desafio.setSelectedIndex(1);

    }//GEN-LAST:event_bt_avancar1ActionPerformed

    private void bt_avancar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_avancar2ActionPerformed

        ta_questoes_desafio.setEnabledAt(1, false);
        ta_questoes_desafio.setEnabledAt(2, true);
        ta_questoes_desafio.setSelectedIndex(2);

    }//GEN-LAST:event_bt_avancar2ActionPerformed

    private void bt_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cancelarActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Deseja cancelar o processo?", "Cancelar", 2) == 0) {
            LimparCampos();
            dispose();

        }
    }//GEN-LAST:event_bt_cancelarActionPerformed

    private void bt_voltar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_voltar1ActionPerformed
        ta_questoes_desafio.setEnabledAt(1, false);
        ta_questoes_desafio.setEnabledAt(0, true);
        ta_questoes_desafio.setSelectedIndex(0);
    }//GEN-LAST:event_bt_voltar1ActionPerformed

    private void bt_voltar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_voltar2ActionPerformed
        ta_questoes_desafio.setEnabledAt(2, false);
        ta_questoes_desafio.setEnabledAt(1, true);
        ta_questoes_desafio.setSelectedIndex(1);
    }//GEN-LAST:event_bt_voltar2ActionPerformed

    private void bt_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_salvarActionPerformed
        if (ta_resposta_desafio1.getText().equals("") || ta_resposta_desafio2.getText().equals("") || ta_resposta_desafio3.getText().equals("")) {

            JOptionPane.showMessageDialog(null, "Informe todas as Respostas");

        } else {

            if (JOptionPane.showConfirmDialog(null, "Deseja Salvar?", "Salvar", 2) == 0) {

                ewedao.BuscarEquipe(e, ut.getEquipe_idEquipe());
                
                //RESPOSTA 01
                rqdwdao.BuscarRespostaDesafio(e.getIdResposta_Desafio01(), rqd);
                rqd.setCorpo_Resposta(ta_resposta_desafio1.getText());
                rqdwdao.AtualizarResposta(rqd);
                rqd = new Resposta_Questao_Desafio();

                //RESPOSTA 02
                rqdwdao.BuscarRespostaDesafio(e.getIdResposta_Desafio02(), rqd);
                rqd.setCorpo_Resposta(ta_resposta_desafio2.getText());
                rqdwdao.AtualizarResposta(rqd);
                rqd = new Resposta_Questao_Desafio();

                //RESPOSTA 03
                rqdwdao.BuscarRespostaDesafio(e.getIdResposta_Desafio03(), rqd);
                rqd.setCorpo_Resposta(ta_resposta_desafio3.getText());
                rqdwdao.AtualizarResposta(rqd);
                rqd = new Resposta_Questao_Desafio();
                
                //ATUALIZAR STATUS EQUIPE
                e.setIsDesafio(1);
                ewedao.AtualizarStatusEquipe(e);
                
                JOptionPane.showMessageDialog(null, "Salvo com Sucesso!");
                LimparCampos();

            }

        }
    }//GEN-LAST:event_bt_salvarActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Tela_ResponderDesafio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela_ResponderDesafio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela_ResponderDesafio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela_ResponderDesafio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Tela_ResponderDesafio dialog = new Tela_ResponderDesafio(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_avancar1;
    private javax.swing.JButton bt_avancar2;
    private javax.swing.JButton bt_cancelar;
    private javax.swing.JButton bt_salvar;
    private javax.swing.JButton bt_voltar1;
    private javax.swing.JButton bt_voltar2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTextArea ta_questao_desafio1;
    private javax.swing.JTextArea ta_questao_desafio2;
    private javax.swing.JTextArea ta_questao_desafio3;
    private javax.swing.JTabbedPane ta_questoes_desafio;
    private javax.swing.JTextArea ta_resposta_desafio1;
    private javax.swing.JTextArea ta_resposta_desafio2;
    private javax.swing.JTextArea ta_resposta_desafio3;
    // End of variables declaration//GEN-END:variables
}
