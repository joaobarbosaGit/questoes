package Telas;

import Classes.Usuario_Aluno;
import Classes.Usuario_Professor;
import Classes.Usuario_Token;
import WebService.Usuario_ProfessorWebDAO;
import Servicos.Utilitarios;
import WebService.Usuario_AlunoWebDAO;
import javax.swing.JOptionPane;

public class Tela_Login extends javax.swing.JFrame {

    Usuario_Token ut = Usuario_Token.getInstance();
    Utilitarios uti = new Utilitarios();

    public Tela_Login() {
        initComponents();
        getRootPane().setDefaultButton(bt_entrar);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tf_usuario = new javax.swing.JTextField();
        tf_senha = new javax.swing.JPasswordField();
        bt_limpar = new javax.swing.JButton();
        bt_entrar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        cxEntrarAdmin = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("LOGIN");

        jLabel2.setText("Email:");

        jLabel3.setText("Senha:");

        bt_limpar.setText("Limpar");
        bt_limpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_limparActionPerformed(evt);
            }
        });

        bt_entrar.setText("Entrar");
        bt_entrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_entrarActionPerformed(evt);
            }
        });

        jLabel4.setText("Entrar como Administrador:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(tf_usuario)
                                .addComponent(tf_senha, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(bt_limpar)
                            .addGap(29, 29, 29)
                            .addComponent(bt_entrar))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cxEntrarAdmin))))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tf_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tf_senha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cxEntrarAdmin)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_limpar)
                    .addComponent(bt_entrar))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bt_limparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_limparActionPerformed
        tf_senha.setText("");
        tf_usuario.setText("");
        cxEntrarAdmin.setSelected(false);
    }//GEN-LAST:event_bt_limparActionPerformed

    private void bt_entrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_entrarActionPerformed
        String senha = new String(tf_senha.getPassword());
        if (tf_usuario.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Digite o seu Login");
        } else if (senha.equals("")) {
            JOptionPane.showMessageDialog(null, "Digite o sua Senha");
        } else {
            //if (uti.VerificaConexão()) {
                if (cxEntrarAdmin.isSelected()) {
                    Usuario_Professor up = new Usuario_Professor();
                    Usuario_ProfessorWebDAO udao = new Usuario_ProfessorWebDAO();
                    if (udao.VerificaUsuario(tf_usuario.getText())) {
                        udao.LoginUsuarioProfessor(up, tf_usuario.getText());
                        if (senha.equals(up.getSenha())) {
                            ut.setId(up.getIdUsuario_Professor());
                            ut.setNome(up.getNome_Professor());
                            ut.setEmail(up.getEmail());
                            ut.setSenha(up.getSenha());
                            ut.setEquipe_idEquipe(0);
                            ut.setRodada_idRodada(0);
                            ut.setTipo("admin");
                            Tela_Menu tm = new Tela_Menu();
                            tm.setVisible(true);
                            this.dispose();
                        } else {
                            JOptionPane.showMessageDialog(null, "Senha Incorreta!");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Email não cadastrado!");
                    }
                } else {
                    Usuario_Aluno ua = new Usuario_Aluno();
                    Usuario_AlunoWebDAO udao = new Usuario_AlunoWebDAO();
                    if (udao.VerificaUsuario(tf_usuario.getText())) {
                        udao.LoginUsuarioAluno(ua, tf_usuario.getText());
                        if (senha.equals(ua.getSenha())) {
                            ut.setId(ua.getIdUsuario_Aluno());
                            ut.setNome(ua.getUsuario());
                            ut.setEmail(ua.getEmail());
                            ut.setSenha(ua.getSenha());
                            ut.setEquipe_idEquipe(ua.getEquipe_idEquipe());
                            ut.setRodada_idRodada(ua.getRodada_idRodada());
                            ut.setTipo("user");
                            Tela_Menu tm = new Tela_Menu();
                            tm.setVisible(true);
                            this.dispose();
                        } else {
                            JOptionPane.showMessageDialog(null, "Senha Incorreta!");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Email não cadastrado!");
                    }
                }
           // } else {
               // JOptionPane.showMessageDialog(null, "Sem Conexão!");
            //}
        }
    }//GEN-LAST:event_bt_entrarActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Tela_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tela_Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_entrar;
    private javax.swing.JButton bt_limpar;
    private javax.swing.JCheckBox cxEntrarAdmin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField tf_senha;
    private javax.swing.JTextField tf_usuario;
    // End of variables declaration//GEN-END:variables
}
