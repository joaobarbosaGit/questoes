
package Telas;

import Classes.Equipe;
import Classes.Usuario_Aluno;
import Classes.Usuario_Token;
import WebService.EquipeWebDAO;
import WebService.Usuario_AlunoWebDAO;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;


public class Tela_GerenciarEquipes extends javax.swing.JDialog {

    EquipeWebDAO ewdao = new EquipeWebDAO();
    Usuario_AlunoWebDAO uawdao = new Usuario_AlunoWebDAO();
    Usuario_Aluno ua = new Usuario_Aluno();
    Usuario_Token ut = Usuario_Token.getInstance();
    ArrayList<Integer> listaIdEquipes = new ArrayList<>();
    
    public void PopularCBEquipes(){
        
    listaIdEquipes.clear();
    
    try {
        DefaultComboBoxModel theModel = (DefaultComboBoxModel)cb_equipe.getModel();
        theModel.removeAllElements();
        cb_equipe.setSelectedIndex(-1);
        cb_equipe.setSelectedItem(null);
        
        Equipe e;
        for(int idEquipe :uawdao.ListaEquipesId(ut.getRodada_idRodada())){
            e = new Equipe();
            ewdao.BuscarEquipe(e, idEquipe);
            listaIdEquipes.add(e.getIdEquipe());
            cb_equipe.addItem(e); 
        }
    } catch (IOException ex) {
        System.out.println(ex);
    }
    }
    
    public Tela_GerenciarEquipes(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        PopularCBEquipes();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cb_equipe = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        tf_nome = new javax.swing.JTextField();
        bt_atualizar = new javax.swing.JButton();
        bt_cancelar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jpf_senha = new javax.swing.JPasswordField();
        cb_mostrarsenha = new javax.swing.JCheckBox();
        tf_email = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setText("Equipe:");

        cb_equipe.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_equipeItemStateChanged(evt);
            }
        });

        jLabel2.setText("Nome da Equipe:");

        bt_atualizar.setText("ATUALIZAR");
        bt_atualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_atualizarActionPerformed(evt);
            }
        });

        bt_cancelar.setText("CANCELAR");
        bt_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cancelarActionPerformed(evt);
            }
        });

        jLabel3.setText("E-mail");

        jLabel4.setText("Senha");

        cb_mostrarsenha.setText("Mostrar Senha");
        cb_mostrarsenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_mostrarsenhaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_nome)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cb_equipe, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jpf_senha, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cb_mostrarsenha))
                                    .addComponent(tf_email))
                                .addGap(0, 129, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_cancelar)
                        .addGap(18, 18, 18)
                        .addComponent(bt_atualizar)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_equipe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tf_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tf_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jpf_senha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_mostrarsenha))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_atualizar)
                    .addComponent(bt_cancelar))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cb_equipeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_equipeItemStateChanged
        if(cb_equipe.getItemCount() > 0 && listaIdEquipes.size() > 0){
        tf_nome.setText(cb_equipe.getSelectedItem().toString());
        uawdao.BuscarUsuarioAlunoIdEquipe(ua, listaIdEquipes.get(cb_equipe.getSelectedIndex()));
        tf_email.setText(ua.getEmail());
        jpf_senha.setText(ua.getSenha());
        }
    }//GEN-LAST:event_cb_equipeItemStateChanged

    private void bt_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cancelarActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Deseja Cancelar?", "Cancelar", 2) == 0) {
            dispose();
        }
    }//GEN-LAST:event_bt_cancelarActionPerformed

    private void bt_atualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_atualizarActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Deseja Atualizar?", "Atualizar", 2) == 0) {
            
            Equipe e = new Equipe();
            e.setIdEquipe(listaIdEquipes.get(cb_equipe.getSelectedIndex()));
            e.setNomeEquipe(tf_nome.getText());
            ewdao.AtualizarNomeEquipe(e);
            
            ua.setUsuario(tf_nome.getText());
            ua.setEmail(tf_email.getText());
            ua.setSenha(String.valueOf(jpf_senha.getPassword()));
            uawdao.AtualizarUsuarioAluno(ua);
            
            PopularCBEquipes();
        }
    }//GEN-LAST:event_bt_atualizarActionPerformed

    private void cb_mostrarsenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_mostrarsenhaActionPerformed
       if(cb_mostrarsenha.isSelected()){
           jpf_senha.setEchoChar((char)0);
       } else {
           jpf_senha.setEchoChar('*');
       }
    }//GEN-LAST:event_cb_mostrarsenhaActionPerformed

   
    public static void main(String args[]) {
       
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Tela_GerenciarEquipes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela_GerenciarEquipes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela_GerenciarEquipes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela_GerenciarEquipes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Tela_GerenciarEquipes dialog = new Tela_GerenciarEquipes(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton bt_atualizar;
    private javax.swing.JButton bt_cancelar;
    private javax.swing.JComboBox<Object> cb_equipe;
    private javax.swing.JCheckBox cb_mostrarsenha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jpf_senha;
    private javax.swing.JTextField tf_email;
    private javax.swing.JTextField tf_nome;
    // End of variables declaration//GEN-END:variables
}
