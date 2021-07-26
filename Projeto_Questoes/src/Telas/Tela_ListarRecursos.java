package Telas;

import Classes.Equipe;
import Classes.Recurso;
import Classes.Usuario_Token;
import Servicos.Utilitarios;
import WebService.EquipeWebDAO;
import WebService.RecursoWebDAO;
import java.awt.Color;
import java.awt.Component;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class Tela_ListarRecursos extends javax.swing.JDialog {

    ArrayList<Recurso> listaRecursos = new ArrayList<>();
    Recurso r = new Recurso();
    RecursoWebDAO rwdao = new RecursoWebDAO();
    Usuario_Token ut = Usuario_Token.getInstance();
    Utilitarios u = new Utilitarios();
    EquipeWebDAO ewdao = new EquipeWebDAO();
    Color corVerde = Color.decode("#006400");
    Color corVermelha = Color.decode("#EE2C2C");
    Color corLaranja = Color.decode("#FFC125");
    boolean eventoClickeTabela = true;

    public Tela_ListarRecursos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        LimparCampos();
        if (ListarTabelaRecurso()) {
            JOptionPane.showMessageDialog(null, "Equipe Sem Recursos Adicionados!");
            bt_cancelar.setEnabled(true);
        }
    }

    public boolean ListarTabelaRecurso() {

        boolean retorno = false;

        DefaultTableModel modelo = (DefaultTableModel) tb_recursos.getModel();
        tb_recursos.getTableHeader().setReorderingAllowed(false);
        modelo.setNumRows(0);
        try {

            listaRecursos = rwdao.ListaRecursoIdEquipe(ut.getEquipe_idEquipe());
            for (Recurso r : listaRecursos) {
                Equipe e = new Equipe();
                ewdao.BuscarEquipe(e, r.getEquipe_idEquipe());
                modelo.addRow(new Object[]{
                    r.getIdRecurso(),
                    e.getNomeEquipe(),
                    r.getObjeto(),
                    u.VerificarSituacaoRecurso(r.getSituacao())
                });
            }
        } catch (IOException ex) {
        }

        if (modelo.getRowCount() == 0) {
            retorno = true;
        }
        MudarCorTabelas();
        return retorno;
    }

    public void LimparCampos() {

        ta_causa.setText("");
        ta_causa.setEditable(false);
        ta_deferimento.setText("");
        ta_deferimento.setEditable(false);
        ListarTabelaRecurso();
        u.bloqueiapainel(p_causa);
        u.bloqueiapainel(p_deferimento);
        eventoClickeTabela = true;
        cb_objeto.setSelectedIndex(0);
        cb_numero.setSelectedIndex(0);

    }

    public void MudarCorTabelas() {

        tb_recursos.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {
                JLabel label = (JLabel) super.getTableCellRendererComponent(table, value,
                        isSelected, hasFocus, row, column);

                Object texto = table.getValueAt(row, 3);
                if (texto != null && texto.toString().equals("Deferido")) {
                    label.setForeground(corVerde);
                } else if (texto != null && texto.toString().equals("Em Análise")) {
                    label.setForeground(corLaranja);
                } else if (texto != null && texto.toString().equals("Indeferido")) {
                    label.setForeground(corVermelha);
                }

                return label;
            }
        });

    }

    public void MudarValoresComboBox() {

        if (cb_objeto.getSelectedItem().toString().equals("Questão Desafio") || cb_objeto.getSelectedItem().toString().equals("Resposta Desafio")) {
            String[] items = new String[]{"1", "2", "3"};
            cb_numero.setModel(new DefaultComboBoxModel(items));
        } else {
            String[] items = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
            cb_numero.setModel(new DefaultComboBoxModel(items));
        }

    }

    public void VerificarComboBox(String objeto) {

        String[] objetos = objeto.split("-");

        switch (objetos[0]) {
            case "Questão":
                cb_objeto.setSelectedIndex(0);
                break;
            case "Resposta":
                cb_objeto.setSelectedIndex(1);
                break;
            case "Questão Desafio":
                cb_objeto.setSelectedIndex(2);
                break;
            case "Resposta Desafio":
                cb_objeto.setSelectedIndex(3);
                break;
            default:
                break;
        }

        cb_numero.setSelectedIndex(Integer.parseInt(objetos[1]) - 1);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tb_recursos = new javax.swing.JTable();
        p_deferimento = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        ta_deferimento = new javax.swing.JTextArea();
        bt_salvar = new javax.swing.JButton();
        bt_cancelar = new javax.swing.JButton();
        bt_voltar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        cb_objeto = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cb_numero = new javax.swing.JComboBox<>();
        p_causa = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ta_causa = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        tb_recursos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Equipe", "Objeto", "Situação"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_recursos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_recursosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_recursos);
        if (tb_recursos.getColumnModel().getColumnCount() > 0) {
            tb_recursos.getColumnModel().getColumn(0).setPreferredWidth(50);
            tb_recursos.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        p_deferimento.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel2.setText("Deferimento:");

        ta_deferimento.setBackground(new java.awt.Color(204, 204, 204));
        ta_deferimento.setColumns(20);
        ta_deferimento.setLineWrap(true);
        ta_deferimento.setRows(5);
        ta_deferimento.setWrapStyleWord(true);
        jScrollPane3.setViewportView(ta_deferimento);

        bt_salvar.setText("SALVAR");
        bt_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_salvarActionPerformed(evt);
            }
        });

        bt_cancelar.setText("CANCELAR");
        bt_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cancelarActionPerformed(evt);
            }
        });

        bt_voltar.setText("VOLTAR");
        bt_voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_voltarActionPerformed(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel3.setText("Objeto:");

        cb_objeto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Questão", "Resposta", "Questão Desafio", "Resposta Desafio" }));
        cb_objeto.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_objetoItemStateChanged(evt);
            }
        });

        jLabel4.setText("Numero:");

        cb_numero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));

        javax.swing.GroupLayout p_deferimentoLayout = new javax.swing.GroupLayout(p_deferimento);
        p_deferimento.setLayout(p_deferimentoLayout);
        p_deferimentoLayout.setHorizontalGroup(
            p_deferimentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_deferimentoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(p_deferimentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(p_deferimentoLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(p_deferimentoLayout.createSequentialGroup()
                        .addComponent(jScrollPane3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(p_deferimentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(p_deferimentoLayout.createSequentialGroup()
                                .addGroup(p_deferimentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(p_deferimentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cb_objeto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cb_numero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, p_deferimentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(bt_salvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(bt_voltar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(bt_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        p_deferimentoLayout.setVerticalGroup(
            p_deferimentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_deferimentoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(p_deferimentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(p_deferimentoLayout.createSequentialGroup()
                        .addGroup(p_deferimentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cb_objeto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(p_deferimentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cb_numero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(48, 48, 48)
                        .addComponent(bt_cancelar)
                        .addGap(18, 18, 18)
                        .addComponent(bt_voltar)
                        .addGap(18, 18, 18)
                        .addComponent(bt_salvar))
                    .addGroup(p_deferimentoLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(p_deferimentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSeparator1)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE))))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        p_causa.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setText("Causa / Justificativa:");

        ta_causa.setColumns(20);
        ta_causa.setLineWrap(true);
        ta_causa.setRows(5);
        ta_causa.setWrapStyleWord(true);
        jScrollPane2.setViewportView(ta_causa);

        javax.swing.GroupLayout p_causaLayout = new javax.swing.GroupLayout(p_causa);
        p_causa.setLayout(p_causaLayout);
        p_causaLayout.setHorizontalGroup(
            p_causaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_causaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(p_causaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(p_causaLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 258, Short.MAX_VALUE)))
                .addContainerGap())
        );
        p_causaLayout.setVerticalGroup(
            p_causaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_causaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(p_deferimento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(p_causa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(p_causa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(p_deferimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tb_recursosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_recursosMouseClicked
        if (eventoClickeTabela) {
            if (evt.getClickCount() == 2) {
                if (JOptionPane.showConfirmDialog(null, "Deseja Selecionar o Recurso : " + tb_recursos.getValueAt(tb_recursos.getSelectedRow(), 0).toString() + "?", "Salvar", 2) == 0) {

                    u.liberapainel(p_causa);
                    u.liberapainel(p_deferimento);
                    ta_causa.setEditable(true);
                    rwdao.BuscarQuestao(Integer.parseInt(tb_recursos.getValueAt(tb_recursos.getSelectedRow(), 0).toString()), r);
                    ta_causa.setText(r.getCausa());
                    ta_deferimento.setText(r.getDeferimento());
                    tb_recursos.setEnabled(false);
                    eventoClickeTabela = false;
                    VerificarComboBox(r.getObjeto());
                }
            }
        }
    }//GEN-LAST:event_tb_recursosMouseClicked

    private void bt_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_salvarActionPerformed

        if (JOptionPane.showConfirmDialog(null, "Deseja Salvar suas Alterações?", "Salvar", 2) == 0) {
            if (ta_deferimento.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Informe o Deferimento do Recurso para Continuar!");
            } else {
                if (r.getSituacao() == 0) {
                    r.setCausa(ta_causa.getText());
                    r.setObjeto(cb_objeto.getSelectedItem().toString() + "-" + cb_numero.getSelectedItem());
                    rwdao.AtualizarRecurso(r);
                    LimparCampos();
                    tb_recursos.setEnabled(true);
                    eventoClickeTabela = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Recurso não pode ser alterado!");
                }
            }
        }
    }//GEN-LAST:event_bt_salvarActionPerformed

    private void bt_voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_voltarActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Deseja Voltar para Seleção do Recurso?", "Voltar", 2) == 0) {
            LimparCampos();
            tb_recursos.setEnabled(true);
            eventoClickeTabela = true;
        }
    }//GEN-LAST:event_bt_voltarActionPerformed

    private void bt_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cancelarActionPerformed
        LimparCampos();
        dispose();
    }//GEN-LAST:event_bt_cancelarActionPerformed

    private void cb_objetoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_objetoItemStateChanged
        MudarValoresComboBox();
    }//GEN-LAST:event_cb_objetoItemStateChanged

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Tela_ListarRecursos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela_ListarRecursos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela_ListarRecursos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela_ListarRecursos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Tela_ListarRecursos dialog = new Tela_ListarRecursos(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton bt_cancelar;
    private javax.swing.JButton bt_salvar;
    private javax.swing.JButton bt_voltar;
    private javax.swing.JComboBox<String> cb_numero;
    private javax.swing.JComboBox<String> cb_objeto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel p_causa;
    private javax.swing.JPanel p_deferimento;
    private javax.swing.JTextArea ta_causa;
    private javax.swing.JTextArea ta_deferimento;
    private javax.swing.JTable tb_recursos;
    // End of variables declaration//GEN-END:variables
}
