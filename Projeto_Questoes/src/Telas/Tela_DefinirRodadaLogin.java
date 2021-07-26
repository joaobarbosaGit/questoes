

package Telas;

import Classes.Equipe;
import Classes.Resposta_Questao_Desafio;
import Classes.Rodada;
import Classes.Usuario_Token;
import WebService.RodadaWebDAO;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Tela_DefinirRodadaLogin extends javax.swing.JFrame {
    
    RodadaWebDAO rwdao = new RodadaWebDAO();
    Usuario_Token ut = Usuario_Token.getInstance();

    public void ListarTabela() {

        DefaultTableModel modelo = (DefaultTableModel) ta_rodada.getModel();
        modelo.setNumRows(0);

        try {

            for (Rodada r : rwdao.ListaRodadaUsuario_Professor(ut.getId())) {
               
                modelo.addRow(new Object[]{
                    r.getIdRodada(),
                    r.getDescricao(),
                    r.getMaterial(),
                    r.getQuantidade_Times()
                });
               
            }
        } catch (IOException ex) {
        }

    }
   
    public Tela_DefinirRodadaLogin() {
        initComponents();
        ListarTabela();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        ta_rodada = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder("Definir Rodada para Acesso"));

        ta_rodada.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Descrição", "Material", "Quantidade de Times"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ta_rodada.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ta_rodadaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(ta_rodada);
        if (ta_rodada.getColumnModel().getColumnCount() > 0) {
            ta_rodada.getColumnModel().getColumn(0).setPreferredWidth(40);
            ta_rodada.getColumnModel().getColumn(0).setMaxWidth(40);
            ta_rodada.getColumnModel().getColumn(3).setPreferredWidth(130);
            ta_rodada.getColumnModel().getColumn(3).setMaxWidth(130);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 863, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ta_rodadaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ta_rodadaMouseClicked
       if (evt.getClickCount() == 2) {
           if (JOptionPane.showConfirmDialog(null, "Deseja selecionar a rodada: " + ta_rodada.getValueAt(ta_rodada.getSelectedRow(),0).toString() + "?", "Selecionar Rodada", 2) == 0) {
               ut.setRodada_idRodada(Integer.parseInt(ta_rodada.getValueAt(ta_rodada.getSelectedRow(),0).toString()));
               JOptionPane.showMessageDialog(null, "Bem vindo "+ut.getNome());
               Tela_Menu tm = new Tela_Menu();
               tm.setVisible(true);
               this.dispose();
           }
       }
    }//GEN-LAST:event_ta_rodadaMouseClicked

   
    public static void main(String args[]) {
        

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Tela_DefinirRodadaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela_DefinirRodadaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela_DefinirRodadaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela_DefinirRodadaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tela_DefinirRodadaLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable ta_rodada;
    // End of variables declaration//GEN-END:variables

}
