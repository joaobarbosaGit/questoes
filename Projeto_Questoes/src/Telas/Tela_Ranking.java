package Telas;

import Classes.Equipe;
import Classes.Usuario_Token;
import WebService.EquipeWebDAO;
import WebService.Usuario_AlunoWebDAO;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Tela_Ranking extends javax.swing.JDialog {

    EquipeWebDAO ewdao = new EquipeWebDAO();
    Usuario_AlunoWebDAO uawdao = new Usuario_AlunoWebDAO();
    Usuario_Token ut = Usuario_Token.getInstance();
    ArrayList<Equipe> listaEquipes = new ArrayList<>();
    ArrayList<Equipe> listaEquipesOrdem = new ArrayList<>();
    
    /**
     * 
     * Gamificação e Pontuação: a patente de cada equipe será resultante do seu total de pontos por rodada, 
     * sendo: 1ª Patente para equipes com pontuação acima de 250 pontos; 2ª Patente para equipes com pontuação 
     * acima de 225 pontos; 3ª Patente para equipes com pontuação acima de 200 pontos; 4ª Patente para equipes 
     * com      * pontuação acima de 175 pontos; 5ª Patente para equipes com pontuação acima de 150 pontos; 
     * 6ª Patente para equipes com pontuação acima de 125 pontos; e 7ª Patente para equipes com pontuação acima 
     * de 100 pontos.

     * 
     * 
     * 
     */

    public void GerarRanking() {

        DefaultTableModel modelo1 = (DefaultTableModel) ta_ranking.getModel();
        ta_ranking.getTableHeader().setReorderingAllowed(false); 
        modelo1.setNumRows(0);
        int cont = 0, maiorNota = 0, notaEquipe = 0, aux = 0;

        try {

            for (int idEquipe : uawdao.ListaEquipesId(2)) {
                Equipe e = new Equipe();
                ewdao.BuscarEquipe(e, idEquipe);
                listaEquipes.add(e);
            }

            while (!listaEquipes.isEmpty()) {

                maiorNota = VerificarMaiorNota();
                Equipe equipe = listaEquipes.get(aux);
                notaEquipe = CalcularPontuação(equipe);

                if (notaEquipe == maiorNota) {
                    listaEquipesOrdem.add(equipe);
                    listaEquipes.remove(aux);
                    aux = 0;
                } else if (aux == listaEquipes.size() - 1) {
                    aux = 0;
                    maiorNota = VerificarMaiorNota();
                    notaEquipe = 0;
                } else {
                    aux++;
                }
            }

            for (int i = 0; i <= listaEquipesOrdem.size() - 1; i++) {
                Equipe e = listaEquipesOrdem.get(i);
                notaEquipe = CalcularPontuação(e);
                int equipeMesmaPontuacao = 0;
                if (i != 0) {
                    int teste = Integer.parseInt(modelo1.getValueAt(i - 1, 2).toString());
                    if (Integer.parseInt(modelo1.getValueAt(i - 1, 2).toString()) == notaEquipe) {
                        modelo1.addRow(new Object[]{
                            Integer.parseInt(modelo1.getValueAt(i - 1, 0).toString()),
                            e.getNomeEquipe(),
                            notaEquipe
                        });
                    } else {
                        modelo1.addRow(new Object[]{
                            (i + 1),
                            e.getNomeEquipe(),
                            notaEquipe
                        });
                    }
                } else {
                    modelo1.addRow(new Object[]{
                        i + 1,
                        e.getNomeEquipe(),
                        notaEquipe
                    });
                }
            }

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro!: " + ex);
        }

    }

    public int CalcularPontuação(Equipe e) {
        int retorno;
        return retorno = +(e.getPontuacao_Desafios() + e.getPontuacao_Respostas() + e.getPontuacao_Questoes());
    }

    public int VerificarMaiorNota() {
        int retorno = 0;

        for (int i = 0; i <= listaEquipes.size() - 1; i++) {
            Equipe e = listaEquipes.get(i);
            if (CalcularPontuação(e) > retorno) {
                retorno = CalcularPontuação(e);
            }
        }

        return retorno;
    }

    public Tela_Ranking(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        GerarRanking();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ta_ranking = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        ta_ranking.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ranking", "Time", "Pontuação", "Patente"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(ta_ranking);
        if (ta_ranking.getColumnModel().getColumnCount() > 0) {
            ta_ranking.getColumnModel().getColumn(0).setPreferredWidth(70);
            ta_ranking.getColumnModel().getColumn(0).setMaxWidth(70);
            ta_ranking.getColumnModel().getColumn(1).setResizable(false);
            ta_ranking.getColumnModel().getColumn(2).setPreferredWidth(80);
            ta_ranking.getColumnModel().getColumn(2).setMaxWidth(80);
            ta_ranking.getColumnModel().getColumn(3).setPreferredWidth(100);
            ta_ranking.getColumnModel().getColumn(3).setMaxWidth(100);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE)
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

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Tela_Ranking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela_Ranking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela_Ranking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela_Ranking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Tela_Ranking dialog = new Tela_Ranking(new javax.swing.JFrame(), true);
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable ta_ranking;
    // End of variables declaration//GEN-END:variables
}
