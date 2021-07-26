package Telas;

import Classes.Equipe;
import Classes.Questao_Desafio;
import Classes.Resposta_Questao_Desafio;
import Classes.Usuario_Token;
import Servicos.ContagemPontos;
import WebService.EquipeWebDAO;
import WebService.Questao_DesafioWebDAO;
import WebService.Resposta_Questao_DesafioWebDAO;
import javax.swing.JOptionPane;

public class Tela_ConsultarDesafio extends javax.swing.JDialog {

    Equipe equipe = new Equipe();
    EquipeWebDAO ewdao = new EquipeWebDAO();
    Questao_Desafio qd;
    Questao_DesafioWebDAO qdwdao = new Questao_DesafioWebDAO();
    Resposta_Questao_Desafio rqd;
    Resposta_Questao_DesafioWebDAO rqdwdao = new Resposta_Questao_DesafioWebDAO();
    Usuario_Token ut = Usuario_Token.getInstance();
    ContagemPontos cp = new ContagemPontos();

    public Tela_ConsultarDesafio(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        ewdao.BuscarEquipe(equipe, ut.getEquipe_idEquipe());
        ListarQuestoesDesafioeRespostasDesafio();
        tf_statusquestao01.setEditable(false);
        tf_statusquestao02.setEditable(false);
        tf_statusquestao03.setEditable(false);
        tf_pontuacao1.setEditable(false);
        tf_pontuacao2.setEditable(false);
        tf_pontuacao3.setEditable(false);
    }

    public void ListarQuestoesDesafioeRespostasDesafio() {

        if (equipe.getIsDesafio() == 0) {
            JOptionPane.showMessageDialog(null, "Equipe não respondeu o Desafio!");
        } else {

            //QUESTAO 01
            qd = new Questao_Desafio();
            qdwdao.BuscarQuestaoDesafio(equipe.getIdQuestao_Desafio01(), qd);
            ta_Questao1.setText(qd.getCorpo_Questao());
            
            rqd = new Resposta_Questao_Desafio();
            rqdwdao.BuscarRespostaDesafio(equipe.getIdResposta_Desafio01(), rqd);
            ta_Resposta1.setText(rqd.getCorpo_Resposta());
            tf_statusquestao01.setText(rqd.getNota_Questao_Desafio());
            tf_pontuacao1.setText(String.valueOf(cp.VerificarPontuacaoResposta(rqd.getNota_Questao_Desafio())));
            
            //QUESTAO 02
            qd = new Questao_Desafio();
            qdwdao.BuscarQuestaoDesafio(equipe.getIdQuestao_Desafio02(), qd);
            ta_Questao2.setText(qd.getCorpo_Questao());
            
            rqd = new Resposta_Questao_Desafio();
            rqdwdao.BuscarRespostaDesafio(equipe.getIdResposta_Desafio02(), rqd);
            ta_Resposta2.setText(rqd.getCorpo_Resposta());
            tf_statusquestao02.setText(rqd.getNota_Questao_Desafio());
            tf_pontuacao2.setText(String.valueOf(cp.VerificarPontuacaoResposta(rqd.getNota_Questao_Desafio())));
            
            //QUESTAO 03
            qd = new Questao_Desafio();
            qdwdao.BuscarQuestaoDesafio(equipe.getIdQuestao_Desafio03(), qd);
            ta_Questao3.setText(qd.getCorpo_Questao());
            
            rqd = new Resposta_Questao_Desafio();
            rqdwdao.BuscarRespostaDesafio(equipe.getIdResposta_Desafio03(), rqd);
            ta_Resposta3.setText(rqd.getCorpo_Resposta());
            tf_statusquestao03.setText(rqd.getNota_Questao_Desafio());
            tf_pontuacao3.setText(String.valueOf(cp.VerificarPontuacaoResposta(rqd.getNota_Questao_Desafio())));
            
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ta_questoes = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jp_questoes1 = new javax.swing.JPanel();
        jl_Questao1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ta_Questao1 = new javax.swing.JTextArea();
        jl_Resposta1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ta_Resposta1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        tf_statusquestao01 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tf_pontuacao1 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jp_questoes2 = new javax.swing.JPanel();
        jl_Questao2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        ta_Questao2 = new javax.swing.JTextArea();
        jl_Resposta2 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        ta_Resposta2 = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        tf_statusquestao02 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tf_pontuacao2 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jp_questoes3 = new javax.swing.JPanel();
        jl_Questao3 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        ta_Questao3 = new javax.swing.JTextArea();
        jl_Resposta3 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        ta_Resposta3 = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        tf_statusquestao03 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tf_pontuacao3 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        ta_questoes.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jp_questoes1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jl_Questao1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jl_Questao1.setText("Questão 01:");

        ta_Questao1.setBackground(new java.awt.Color(204, 204, 204));
        ta_Questao1.setColumns(20);
        ta_Questao1.setLineWrap(true);
        ta_Questao1.setRows(5);
        ta_Questao1.setWrapStyleWord(true);
        ta_Questao1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        ta_Questao1.setFocusable(false);
        jScrollPane1.setViewportView(ta_Questao1);

        jl_Resposta1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jl_Resposta1.setText("Resposta 01:");

        ta_Resposta1.setBackground(new java.awt.Color(204, 204, 204));
        ta_Resposta1.setColumns(20);
        ta_Resposta1.setLineWrap(true);
        ta_Resposta1.setRows(5);
        ta_Resposta1.setWrapStyleWord(true);
        ta_Resposta1.setFocusable(false);
        jScrollPane2.setViewportView(ta_Resposta1);

        jLabel1.setText("Status:");

        jLabel4.setText("Pontuação:");

        javax.swing.GroupLayout jp_questoes1Layout = new javax.swing.GroupLayout(jp_questoes1);
        jp_questoes1.setLayout(jp_questoes1Layout);
        jp_questoes1Layout.setHorizontalGroup(
            jp_questoes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_questoes1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jp_questoes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_questoes1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jl_Questao1)
                        .addGap(943, 943, 943))
                    .addComponent(jScrollPane1)
                    .addGroup(jp_questoes1Layout.createSequentialGroup()
                        .addGroup(jp_questoes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jl_Resposta1)
                            .addGroup(jp_questoes1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tf_statusquestao01, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tf_pontuacao1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jp_questoes1Layout.setVerticalGroup(
            jp_questoes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_questoes1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jl_Questao1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jl_Resposta1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(jp_questoes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tf_statusquestao01, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(tf_pontuacao1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jp_questoes1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jp_questoes1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        ta_questoes.addTab("Questão Desafio 01", jPanel1);

        jp_questoes2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jl_Questao2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jl_Questao2.setText("Questão 02:");

        ta_Questao2.setBackground(new java.awt.Color(204, 204, 204));
        ta_Questao2.setColumns(20);
        ta_Questao2.setLineWrap(true);
        ta_Questao2.setRows(5);
        ta_Questao2.setWrapStyleWord(true);
        ta_Questao2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        ta_Questao2.setFocusable(false);
        jScrollPane3.setViewportView(ta_Questao2);

        jl_Resposta2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jl_Resposta2.setText("Resposta 02:");

        ta_Resposta2.setBackground(new java.awt.Color(204, 204, 204));
        ta_Resposta2.setColumns(20);
        ta_Resposta2.setLineWrap(true);
        ta_Resposta2.setRows(5);
        ta_Resposta2.setWrapStyleWord(true);
        ta_Resposta2.setFocusable(false);
        jScrollPane4.setViewportView(ta_Resposta2);

        jLabel2.setText("Status:");

        jLabel5.setText("Pontuação:");

        javax.swing.GroupLayout jp_questoes2Layout = new javax.swing.GroupLayout(jp_questoes2);
        jp_questoes2.setLayout(jp_questoes2Layout);
        jp_questoes2Layout.setHorizontalGroup(
            jp_questoes2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_questoes2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jp_questoes2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_questoes2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jl_Questao2)
                        .addGap(943, 943, 943))
                    .addComponent(jScrollPane3)
                    .addGroup(jp_questoes2Layout.createSequentialGroup()
                        .addGroup(jp_questoes2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jl_Resposta2)
                            .addGroup(jp_questoes2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tf_statusquestao02, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tf_pontuacao2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jp_questoes2Layout.setVerticalGroup(
            jp_questoes2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_questoes2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jl_Questao2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jl_Resposta2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(jp_questoes2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tf_statusquestao02, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jp_questoes2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(tf_pontuacao2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jp_questoes2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jp_questoes2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        ta_questoes.addTab("Questão Desafio 02", jPanel2);

        jp_questoes3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jl_Questao3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jl_Questao3.setText("Questão 03:");

        ta_Questao3.setBackground(new java.awt.Color(204, 204, 204));
        ta_Questao3.setColumns(20);
        ta_Questao3.setLineWrap(true);
        ta_Questao3.setRows(5);
        ta_Questao3.setWrapStyleWord(true);
        ta_Questao3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        ta_Questao3.setFocusable(false);
        jScrollPane5.setViewportView(ta_Questao3);

        jl_Resposta3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jl_Resposta3.setText("Resposta 03:");

        ta_Resposta3.setBackground(new java.awt.Color(204, 204, 204));
        ta_Resposta3.setColumns(20);
        ta_Resposta3.setLineWrap(true);
        ta_Resposta3.setRows(5);
        ta_Resposta3.setWrapStyleWord(true);
        ta_Resposta3.setFocusable(false);
        jScrollPane6.setViewportView(ta_Resposta3);

        jLabel3.setText("Status:");

        jLabel6.setText("Pontuação:");

        javax.swing.GroupLayout jp_questoes3Layout = new javax.swing.GroupLayout(jp_questoes3);
        jp_questoes3.setLayout(jp_questoes3Layout);
        jp_questoes3Layout.setHorizontalGroup(
            jp_questoes3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_questoes3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jp_questoes3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_questoes3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jl_Questao3)
                        .addGap(943, 943, 943))
                    .addComponent(jScrollPane5)
                    .addGroup(jp_questoes3Layout.createSequentialGroup()
                        .addGroup(jp_questoes3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jl_Resposta3)
                            .addGroup(jp_questoes3Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tf_statusquestao03, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tf_pontuacao3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jp_questoes3Layout.setVerticalGroup(
            jp_questoes3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_questoes3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jl_Questao3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jl_Resposta3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(jp_questoes3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tf_statusquestao03, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jp_questoes3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(tf_pontuacao3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jp_questoes3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jp_questoes3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        ta_questoes.addTab("Questão Desafio 03", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ta_questoes)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ta_questoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            java.util.logging.Logger.getLogger(Tela_ConsultarDesafio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela_ConsultarDesafio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela_ConsultarDesafio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela_ConsultarDesafio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Tela_ConsultarDesafio dialog = new Tela_ConsultarDesafio(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel jl_Questao1;
    private javax.swing.JLabel jl_Questao2;
    private javax.swing.JLabel jl_Questao3;
    private javax.swing.JLabel jl_Resposta1;
    private javax.swing.JLabel jl_Resposta2;
    private javax.swing.JLabel jl_Resposta3;
    private javax.swing.JPanel jp_questoes1;
    private javax.swing.JPanel jp_questoes2;
    private javax.swing.JPanel jp_questoes3;
    private javax.swing.JTextArea ta_Questao1;
    private javax.swing.JTextArea ta_Questao2;
    private javax.swing.JTextArea ta_Questao3;
    private javax.swing.JTextArea ta_Resposta1;
    private javax.swing.JTextArea ta_Resposta2;
    private javax.swing.JTextArea ta_Resposta3;
    private javax.swing.JTabbedPane ta_questoes;
    private javax.swing.JTextField tf_pontuacao1;
    private javax.swing.JTextField tf_pontuacao2;
    private javax.swing.JTextField tf_pontuacao3;
    private javax.swing.JTextField tf_statusquestao01;
    private javax.swing.JTextField tf_statusquestao02;
    private javax.swing.JTextField tf_statusquestao03;
    // End of variables declaration//GEN-END:variables
}
