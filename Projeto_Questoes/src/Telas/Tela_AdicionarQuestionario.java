package Telas;

import Classes.Equipe;
import Classes.Questao;
import Classes.Usuario_Token;
import Servicos.Utilitarios;
import WebService.EquipeWebDAO;
import WebService.QuestaoWebDAO;
import javax.swing.JOptionPane;

public class Tela_AdicionarQuestionario extends javax.swing.JDialog {

    Utilitarios u = new Utilitarios();
    Usuario_Token ut = Usuario_Token.getInstance();
    EquipeWebDAO ewdao = new EquipeWebDAO();
    QuestaoWebDAO qwdao = new QuestaoWebDAO();
    Equipe e = new Equipe();
    Questao q = new Questao();

    public Tela_AdicionarQuestionario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        BloquearPaineis();
        BuscarQuestoes();
    }

    private void BloquearPaineis() {

        u.bloqueiapainel(painel_qst02);
        u.bloqueiapainel(painel_qst03);
        u.bloqueiapainel(painel_qst04);
        u.bloqueiapainel(painel_qst05);
        u.bloqueiapainel(painel_qst06);
        u.bloqueiapainel(painel_qst07);
        u.bloqueiapainel(painel_qst08);
        u.bloqueiapainel(painel_qst09);
        u.bloqueiapainel(painel_qst10);
        tp_rodada.setEnabledAt(1, false);
        tp_rodada.setEnabledAt(2, false);
        tp_rodada.setEnabledAt(3, false);
        tp_rodada.setEnabledAt(4, false);
        tp_rodada.setEnabledAt(5, false);
        tp_rodada.setEnabledAt(6, false);
        tp_rodada.setEnabledAt(7, false);
        tp_rodada.setEnabledAt(8, false);
        tp_rodada.setEnabledAt(9, false);
        tp_rodada.setEnabledAt(0, true);
        tp_rodada.setSelectedIndex(0);

    }

    private void LimparCampos() {

        ta_questao01.setText("");
        ta_questao02.setText("");
        ta_questao03.setText("");
        ta_questao04.setText("");
        ta_questao05.setText("");
        ta_questao06.setText("");
        ta_questao07.setText("");
        ta_questao08.setText("");
        ta_questao09.setText("");
        ta_questao10.setText("");
        ta_gabarito01.setText("");
        ta_gabarito02.setText("");
        ta_gabarito03.setText("");
        ta_gabarito04.setText("");
        ta_gabarito05.setText("");
        ta_gabarito06.setText("");
        ta_gabarito07.setText("");
        ta_gabarito08.setText("");
        ta_gabarito09.setText("");
        ta_gabarito10.setText("");

    }
    
    private void BuscarQuestoes() {

        //BUSCAR EQUIPE
        ewdao.BuscarEquipe(e, ut.getEquipe_idEquipe());
        
        //QUESTAO 01
        qwdao.BuscarQuestao(e.getIdQuestao_Equipe01(), q);
        if(!q.getCorpo_Questao().equals("SEM CONTEUDO")){
        ta_questao01.setText(q.getCorpo_Questao());
        ta_gabarito01.setText(q.getGabarito());
        q = new Questao();
                
        //QUESTAO 02
        qwdao.BuscarQuestao(e.getIdQuestao_Equipe02(), q);
        ta_questao02.setText(q.getCorpo_Questao());
        ta_gabarito02.setText(q.getGabarito());
        q = new Questao();
        
        //QUESTAO 03
        qwdao.BuscarQuestao(e.getIdQuestao_Equipe03(), q);
        ta_questao03.setText(q.getCorpo_Questao());
        ta_gabarito03.setText(q.getGabarito());
        q = new Questao();

        //QUESTAO 04
        qwdao.BuscarQuestao(e.getIdQuestao_Equipe04(), q);
        ta_questao04.setText(q.getCorpo_Questao());
        ta_gabarito04.setText(q.getGabarito());
        q = new Questao();

        //QUESTAO 05
        qwdao.BuscarQuestao(e.getIdQuestao_Equipe05(), q);
        ta_questao05.setText(q.getCorpo_Questao());
        ta_gabarito05.setText(q.getGabarito());
        q = new Questao();

        //QUESTAO 06
        qwdao.BuscarQuestao(e.getIdQuestao_Equipe06(), q);
        ta_questao06.setText(q.getCorpo_Questao());
        ta_gabarito06.setText(q.getGabarito());
        q = new Questao();

        //QUESTAO 07
        qwdao.BuscarQuestao(e.getIdQuestao_Equipe07(), q);
        ta_questao07.setText(q.getCorpo_Questao());
        ta_gabarito07.setText(q.getGabarito());
        q = new Questao();

        //QUESTAO 08
        qwdao.BuscarQuestao(e.getIdQuestao_Equipe08(), q);
        ta_questao08.setText(q.getCorpo_Questao());
        ta_gabarito08.setText(q.getGabarito());
        q = new Questao();

        //QUESTAO 09
        qwdao.BuscarQuestao(e.getIdQuestao_Equipe09(), q);
        ta_questao09.setText(q.getCorpo_Questao());
        ta_gabarito09.setText(q.getGabarito());
        q = new Questao();

        //QUESTAO 10
        qwdao.BuscarQuestao(e.getIdQuestao_Equipe10(), q);
        ta_questao10.setText(q.getCorpo_Questao());
        ta_gabarito10.setText(q.getGabarito());
        q = new Questao();
        
        bt_salvar.setText("ATUALIZAR");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tp_rodada = new javax.swing.JTabbedPane();
        painel_qst01 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        bt_avancar01 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ta_questao01 = new javax.swing.JTextArea();
        bt_cancelar = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        ta_gabarito01 = new javax.swing.JTextArea();
        painel_qst02 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane12 = new javax.swing.JScrollPane();
        ta_questao02 = new javax.swing.JTextArea();
        jScrollPane13 = new javax.swing.JScrollPane();
        ta_gabarito02 = new javax.swing.JTextArea();
        jLabel13 = new javax.swing.JLabel();
        bt_voltar02 = new javax.swing.JButton();
        bt_avancar02 = new javax.swing.JButton();
        painel_qst03 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        bt_voltar03 = new javax.swing.JButton();
        bt_avancar03 = new javax.swing.JButton();
        jScrollPane14 = new javax.swing.JScrollPane();
        ta_questao03 = new javax.swing.JTextArea();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane15 = new javax.swing.JScrollPane();
        ta_gabarito03 = new javax.swing.JTextArea();
        painel_qst04 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        bt_voltar04 = new javax.swing.JButton();
        bt_avancar04 = new javax.swing.JButton();
        jScrollPane16 = new javax.swing.JScrollPane();
        ta_questao04 = new javax.swing.JTextArea();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane17 = new javax.swing.JScrollPane();
        ta_gabarito04 = new javax.swing.JTextArea();
        painel_qst05 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        bt_voltar05 = new javax.swing.JButton();
        bt_avancar05 = new javax.swing.JButton();
        jScrollPane18 = new javax.swing.JScrollPane();
        ta_questao05 = new javax.swing.JTextArea();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane19 = new javax.swing.JScrollPane();
        ta_gabarito05 = new javax.swing.JTextArea();
        painel_qst06 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        bt_voltar06 = new javax.swing.JButton();
        bt_avancar06 = new javax.swing.JButton();
        jScrollPane20 = new javax.swing.JScrollPane();
        ta_questao06 = new javax.swing.JTextArea();
        jLabel21 = new javax.swing.JLabel();
        jScrollPane21 = new javax.swing.JScrollPane();
        ta_gabarito06 = new javax.swing.JTextArea();
        painel_qst07 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        bt_voltar07 = new javax.swing.JButton();
        bt_avancar07 = new javax.swing.JButton();
        jScrollPane22 = new javax.swing.JScrollPane();
        ta_questao07 = new javax.swing.JTextArea();
        jLabel23 = new javax.swing.JLabel();
        jScrollPane23 = new javax.swing.JScrollPane();
        ta_gabarito07 = new javax.swing.JTextArea();
        painel_qst08 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        bt_voltar08 = new javax.swing.JButton();
        bt_avancar08 = new javax.swing.JButton();
        jScrollPane24 = new javax.swing.JScrollPane();
        ta_questao08 = new javax.swing.JTextArea();
        jLabel25 = new javax.swing.JLabel();
        jScrollPane25 = new javax.swing.JScrollPane();
        ta_gabarito08 = new javax.swing.JTextArea();
        painel_qst09 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        bt_voltar09 = new javax.swing.JButton();
        bt_avancar09 = new javax.swing.JButton();
        jScrollPane26 = new javax.swing.JScrollPane();
        ta_questao09 = new javax.swing.JTextArea();
        jLabel27 = new javax.swing.JLabel();
        jScrollPane27 = new javax.swing.JScrollPane();
        ta_gabarito09 = new javax.swing.JTextArea();
        painel_qst10 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        bt_voltar10 = new javax.swing.JButton();
        bt_salvar = new javax.swing.JButton();
        jScrollPane28 = new javax.swing.JScrollPane();
        ta_questao10 = new javax.swing.JTextArea();
        jLabel29 = new javax.swing.JLabel();
        jScrollPane29 = new javax.swing.JScrollPane();
        ta_gabarito10 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        tp_rodada.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        tp_rodada.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);

        jLabel1.setText("Questão 01:");

        bt_avancar01.setText("AVANÇAR");
        bt_avancar01.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_avancar01ActionPerformed(evt);
            }
        });

        ta_questao01.setColumns(20);
        ta_questao01.setRows(5);
        jScrollPane1.setViewportView(ta_questao01);

        bt_cancelar.setText("CANCELAR");
        bt_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cancelarActionPerformed(evt);
            }
        });

        jLabel11.setText("Gabarito 01:");

        ta_gabarito01.setColumns(20);
        ta_gabarito01.setRows(5);
        jScrollPane11.setViewportView(ta_gabarito01);

        javax.swing.GroupLayout painel_qst01Layout = new javax.swing.GroupLayout(painel_qst01);
        painel_qst01.setLayout(painel_qst01Layout);
        painel_qst01Layout.setHorizontalGroup(
            painel_qst01Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_qst01Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_qst01Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(painel_qst01Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 344, Short.MAX_VALUE)
                        .addComponent(bt_cancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_avancar01))
                    .addGroup(painel_qst01Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        painel_qst01Layout.setVerticalGroup(
            painel_qst01Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_qst01Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(painel_qst01Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel_qst01Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bt_avancar01)
                        .addComponent(bt_cancelar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tp_rodada.addTab("QST 01", painel_qst01);

        jLabel12.setText("Questão 02:");

        ta_questao02.setColumns(20);
        ta_questao02.setRows(5);
        jScrollPane12.setViewportView(ta_questao02);

        ta_gabarito02.setColumns(20);
        ta_gabarito02.setRows(5);
        jScrollPane13.setViewportView(ta_gabarito02);

        jLabel13.setText("Gabarito 02:");

        bt_voltar02.setText("VOLTAR");
        bt_voltar02.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_voltar02ActionPerformed(evt);
            }
        });

        bt_avancar02.setText("AVANÇAR");
        bt_avancar02.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_avancar02ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painel_qst02Layout = new javax.swing.GroupLayout(painel_qst02);
        painel_qst02.setLayout(painel_qst02Layout);
        painel_qst02Layout.setHorizontalGroup(
            painel_qst02Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_qst02Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_qst02Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
                    .addComponent(jScrollPane12)
                    .addGroup(painel_qst02Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_voltar02, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_avancar02))
                    .addGroup(painel_qst02Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        painel_qst02Layout.setVerticalGroup(
            painel_qst02Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_qst02Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(painel_qst02Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel_qst02Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bt_avancar02)
                        .addComponent(bt_voltar02)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tp_rodada.addTab("QST 02", painel_qst02);

        jLabel14.setText("Questão 03:");

        bt_voltar03.setText("VOLTAR");
        bt_voltar03.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_voltar03ActionPerformed(evt);
            }
        });

        bt_avancar03.setText("AVANÇAR");
        bt_avancar03.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_avancar03ActionPerformed(evt);
            }
        });

        ta_questao03.setColumns(20);
        ta_questao03.setRows(5);
        jScrollPane14.setViewportView(ta_questao03);

        jLabel15.setText("Gabarito 03:");

        ta_gabarito03.setColumns(20);
        ta_gabarito03.setRows(5);
        jScrollPane15.setViewportView(ta_gabarito03);

        javax.swing.GroupLayout painel_qst03Layout = new javax.swing.GroupLayout(painel_qst03);
        painel_qst03.setLayout(painel_qst03Layout);
        painel_qst03Layout.setHorizontalGroup(
            painel_qst03Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_qst03Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_qst03Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
                    .addComponent(jScrollPane14)
                    .addGroup(painel_qst03Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_voltar03, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_avancar03))
                    .addGroup(painel_qst03Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        painel_qst03Layout.setVerticalGroup(
            painel_qst03Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_qst03Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(painel_qst03Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel_qst03Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bt_avancar03)
                        .addComponent(bt_voltar03)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tp_rodada.addTab("QST 03", painel_qst03);

        jLabel16.setText("Questão 04:");

        bt_voltar04.setText("VOLTAR");
        bt_voltar04.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_voltar04ActionPerformed(evt);
            }
        });

        bt_avancar04.setText("AVANÇAR");
        bt_avancar04.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_avancar04ActionPerformed(evt);
            }
        });

        ta_questao04.setColumns(20);
        ta_questao04.setRows(5);
        jScrollPane16.setViewportView(ta_questao04);

        jLabel17.setText("Gabarito 04:");

        ta_gabarito04.setColumns(20);
        ta_gabarito04.setRows(5);
        jScrollPane17.setViewportView(ta_gabarito04);

        javax.swing.GroupLayout painel_qst04Layout = new javax.swing.GroupLayout(painel_qst04);
        painel_qst04.setLayout(painel_qst04Layout);
        painel_qst04Layout.setHorizontalGroup(
            painel_qst04Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_qst04Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_qst04Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
                    .addComponent(jScrollPane16)
                    .addGroup(painel_qst04Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_voltar04, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_avancar04))
                    .addGroup(painel_qst04Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        painel_qst04Layout.setVerticalGroup(
            painel_qst04Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_qst04Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(painel_qst04Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel_qst04Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bt_avancar04)
                        .addComponent(bt_voltar04)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tp_rodada.addTab("QST 04", painel_qst04);

        jLabel18.setText("Questão 05:");

        bt_voltar05.setText("VOLTAR");
        bt_voltar05.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_voltar05ActionPerformed(evt);
            }
        });

        bt_avancar05.setText("AVANÇAR");
        bt_avancar05.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_avancar05ActionPerformed(evt);
            }
        });

        ta_questao05.setColumns(20);
        ta_questao05.setRows(5);
        jScrollPane18.setViewportView(ta_questao05);

        jLabel19.setText("Gabarito 05:");

        ta_gabarito05.setColumns(20);
        ta_gabarito05.setRows(5);
        jScrollPane19.setViewportView(ta_gabarito05);

        javax.swing.GroupLayout painel_qst05Layout = new javax.swing.GroupLayout(painel_qst05);
        painel_qst05.setLayout(painel_qst05Layout);
        painel_qst05Layout.setHorizontalGroup(
            painel_qst05Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_qst05Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_qst05Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
                    .addComponent(jScrollPane18)
                    .addGroup(painel_qst05Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_voltar05, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_avancar05))
                    .addGroup(painel_qst05Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        painel_qst05Layout.setVerticalGroup(
            painel_qst05Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_qst05Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(painel_qst05Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel_qst05Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bt_avancar05)
                        .addComponent(bt_voltar05)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane19, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tp_rodada.addTab("QST 05", painel_qst05);

        jLabel20.setText("Questão 06:");

        bt_voltar06.setText("VOLTAR");
        bt_voltar06.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_voltar06ActionPerformed(evt);
            }
        });

        bt_avancar06.setText("AVANÇAR");
        bt_avancar06.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_avancar06ActionPerformed(evt);
            }
        });

        ta_questao06.setColumns(20);
        ta_questao06.setRows(5);
        jScrollPane20.setViewportView(ta_questao06);

        jLabel21.setText("Gabarito 06:");

        ta_gabarito06.setColumns(20);
        ta_gabarito06.setRows(5);
        jScrollPane21.setViewportView(ta_gabarito06);

        javax.swing.GroupLayout painel_qst06Layout = new javax.swing.GroupLayout(painel_qst06);
        painel_qst06.setLayout(painel_qst06Layout);
        painel_qst06Layout.setHorizontalGroup(
            painel_qst06Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_qst06Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_qst06Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane21, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
                    .addComponent(jScrollPane20)
                    .addGroup(painel_qst06Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_voltar06, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_avancar06))
                    .addGroup(painel_qst06Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        painel_qst06Layout.setVerticalGroup(
            painel_qst06Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_qst06Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(painel_qst06Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel_qst06Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bt_avancar06)
                        .addComponent(bt_voltar06)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane20, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane21, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tp_rodada.addTab("QST 06", painel_qst06);

        jLabel22.setText("Questão 07:");

        bt_voltar07.setText("VOLTAR");
        bt_voltar07.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_voltar07ActionPerformed(evt);
            }
        });

        bt_avancar07.setText("AVANÇAR");
        bt_avancar07.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_avancar07ActionPerformed(evt);
            }
        });

        ta_questao07.setColumns(20);
        ta_questao07.setRows(5);
        jScrollPane22.setViewportView(ta_questao07);

        jLabel23.setText("Gabarito 07:");

        ta_gabarito07.setColumns(20);
        ta_gabarito07.setRows(5);
        jScrollPane23.setViewportView(ta_gabarito07);

        javax.swing.GroupLayout painel_qst07Layout = new javax.swing.GroupLayout(painel_qst07);
        painel_qst07.setLayout(painel_qst07Layout);
        painel_qst07Layout.setHorizontalGroup(
            painel_qst07Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_qst07Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_qst07Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane23, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
                    .addComponent(jScrollPane22)
                    .addGroup(painel_qst07Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_voltar07, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_avancar07))
                    .addGroup(painel_qst07Layout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        painel_qst07Layout.setVerticalGroup(
            painel_qst07Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_qst07Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(painel_qst07Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel_qst07Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bt_avancar07)
                        .addComponent(bt_voltar07)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane22, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane23, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tp_rodada.addTab("QST 07", painel_qst07);

        jLabel24.setText("Questão 08:");

        bt_voltar08.setText("VOLTAR");
        bt_voltar08.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_voltar08ActionPerformed(evt);
            }
        });

        bt_avancar08.setText("AVANÇAR");
        bt_avancar08.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_avancar08ActionPerformed(evt);
            }
        });

        ta_questao08.setColumns(20);
        ta_questao08.setRows(5);
        jScrollPane24.setViewportView(ta_questao08);

        jLabel25.setText("Gabarito 08:");

        ta_gabarito08.setColumns(20);
        ta_gabarito08.setRows(5);
        jScrollPane25.setViewportView(ta_gabarito08);

        javax.swing.GroupLayout painel_qst08Layout = new javax.swing.GroupLayout(painel_qst08);
        painel_qst08.setLayout(painel_qst08Layout);
        painel_qst08Layout.setHorizontalGroup(
            painel_qst08Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_qst08Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_qst08Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane25, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
                    .addComponent(jScrollPane24)
                    .addGroup(painel_qst08Layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_voltar08, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_avancar08))
                    .addGroup(painel_qst08Layout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        painel_qst08Layout.setVerticalGroup(
            painel_qst08Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_qst08Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(painel_qst08Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel_qst08Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bt_avancar08)
                        .addComponent(bt_voltar08)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane24, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane25, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tp_rodada.addTab("QST 08", painel_qst08);

        jLabel26.setText("Questão 09:");

        bt_voltar09.setText("VOLTAR");
        bt_voltar09.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_voltar09ActionPerformed(evt);
            }
        });

        bt_avancar09.setText("AVANÇAR");
        bt_avancar09.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_avancar09ActionPerformed(evt);
            }
        });

        ta_questao09.setColumns(20);
        ta_questao09.setRows(5);
        jScrollPane26.setViewportView(ta_questao09);

        jLabel27.setText("Gabarito 09:");

        ta_gabarito09.setColumns(20);
        ta_gabarito09.setRows(5);
        jScrollPane27.setViewportView(ta_gabarito09);

        javax.swing.GroupLayout painel_qst09Layout = new javax.swing.GroupLayout(painel_qst09);
        painel_qst09.setLayout(painel_qst09Layout);
        painel_qst09Layout.setHorizontalGroup(
            painel_qst09Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_qst09Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_qst09Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane27, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
                    .addComponent(jScrollPane26)
                    .addGroup(painel_qst09Layout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_voltar09, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_avancar09))
                    .addGroup(painel_qst09Layout.createSequentialGroup()
                        .addComponent(jLabel27)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        painel_qst09Layout.setVerticalGroup(
            painel_qst09Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_qst09Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(painel_qst09Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel_qst09Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bt_avancar09)
                        .addComponent(bt_voltar09)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane26, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane27, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tp_rodada.addTab("QST 09", painel_qst09);

        jLabel28.setText("Questão 10:");

        bt_voltar10.setText("VOLTAR");
        bt_voltar10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_voltar10ActionPerformed(evt);
            }
        });

        bt_salvar.setText("SALVAR");
        bt_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_salvarActionPerformed(evt);
            }
        });

        ta_questao10.setColumns(20);
        ta_questao10.setRows(5);
        jScrollPane28.setViewportView(ta_questao10);

        jLabel29.setText("Gabarito 10:");

        ta_gabarito10.setColumns(20);
        ta_gabarito10.setRows(5);
        jScrollPane29.setViewportView(ta_gabarito10);

        javax.swing.GroupLayout painel_qst10Layout = new javax.swing.GroupLayout(painel_qst10);
        painel_qst10.setLayout(painel_qst10Layout);
        painel_qst10Layout.setHorizontalGroup(
            painel_qst10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_qst10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_qst10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane29, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
                    .addComponent(jScrollPane28)
                    .addGroup(painel_qst10Layout.createSequentialGroup()
                        .addComponent(jLabel28)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_voltar10, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painel_qst10Layout.createSequentialGroup()
                        .addComponent(jLabel29)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        painel_qst10Layout.setVerticalGroup(
            painel_qst10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_qst10Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addGroup(painel_qst10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel_qst10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bt_salvar)
                        .addComponent(bt_voltar10)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane28, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel29)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane29, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tp_rodada.addTab("QST 10", painel_qst10);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tp_rodada)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tp_rodada, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bt_avancar01ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_avancar01ActionPerformed
        if (!ta_questao01.getText().equals("") && !ta_gabarito01.getText().equals("")) {
            tp_rodada.setEnabledAt(0, false);
            tp_rodada.setEnabledAt(1, true);
            tp_rodada.setSelectedIndex(1);
            u.liberapainel(painel_qst02);
        } else {
            JOptionPane.showMessageDialog(null, "Questão 01 ou Gabarito 01, não podem estar vazio!");
        }
    }//GEN-LAST:event_bt_avancar01ActionPerformed

    private void bt_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cancelarActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Deseja cancelar o processo?", "Cancelar", 2) == 0) {
            BloquearPaineis();
            LimparCampos();
            dispose();
        }
    }//GEN-LAST:event_bt_cancelarActionPerformed

    private void bt_voltar02ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_voltar02ActionPerformed
        tp_rodada.setEnabledAt(1, false);
        tp_rodada.setEnabledAt(0, true);
        tp_rodada.setSelectedIndex(0);
    }//GEN-LAST:event_bt_voltar02ActionPerformed

    private void bt_avancar02ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_avancar02ActionPerformed
        if (!ta_questao02.getText().equals("") && !ta_gabarito02.getText().equals("")) {
            tp_rodada.setEnabledAt(1, false);
            tp_rodada.setEnabledAt(2, true);
            tp_rodada.setSelectedIndex(2);
            u.liberapainel(painel_qst03);
        } else {
            JOptionPane.showMessageDialog(null, "Questão 02 ou Gabarito 02, não podem estar vazio!");
        }
    }//GEN-LAST:event_bt_avancar02ActionPerformed

    private void bt_voltar03ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_voltar03ActionPerformed
        tp_rodada.setEnabledAt(2, false);
        tp_rodada.setEnabledAt(1, true);
        tp_rodada.setSelectedIndex(1);
    }//GEN-LAST:event_bt_voltar03ActionPerformed

    private void bt_avancar03ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_avancar03ActionPerformed
        if (!ta_questao03.getText().equals("") && !ta_gabarito03.getText().equals("")) {
            tp_rodada.setEnabledAt(2, false);
            tp_rodada.setEnabledAt(3, true);
            tp_rodada.setSelectedIndex(3);
            u.liberapainel(painel_qst04);
        } else {
            JOptionPane.showMessageDialog(null, "Questão 03 ou Gabarito 03, não podem estar vazio!");
        }
    }//GEN-LAST:event_bt_avancar03ActionPerformed

    private void bt_voltar04ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_voltar04ActionPerformed
        tp_rodada.setEnabledAt(3, false);
        tp_rodada.setEnabledAt(2, true);
        tp_rodada.setSelectedIndex(2);
    }//GEN-LAST:event_bt_voltar04ActionPerformed

    private void bt_avancar04ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_avancar04ActionPerformed
        if (!ta_questao04.getText().equals("") && !ta_gabarito04.getText().equals("")) {
            tp_rodada.setEnabledAt(3, false);
            tp_rodada.setEnabledAt(4, true);
            tp_rodada.setSelectedIndex(4);
            u.liberapainel(painel_qst05);
        } else {
            JOptionPane.showMessageDialog(null, "Questão 04 ou Gabarito 04, não podem estar vazio!");
        }
    }//GEN-LAST:event_bt_avancar04ActionPerformed

    private void bt_voltar05ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_voltar05ActionPerformed
        tp_rodada.setEnabledAt(4, false);
        tp_rodada.setEnabledAt(3, true);
        tp_rodada.setSelectedIndex(3);
    }//GEN-LAST:event_bt_voltar05ActionPerformed

    private void bt_avancar05ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_avancar05ActionPerformed
        if (!ta_questao05.getText().equals("") && !ta_gabarito05.getText().equals("")) {
            tp_rodada.setEnabledAt(4, false);
            tp_rodada.setEnabledAt(5, true);
            tp_rodada.setSelectedIndex(5);
            u.liberapainel(painel_qst06);
        } else {
            JOptionPane.showMessageDialog(null, "Questão 05 ou Gabarito 05, não podem estar vazio!");
        }
    }//GEN-LAST:event_bt_avancar05ActionPerformed

    private void bt_voltar06ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_voltar06ActionPerformed
        tp_rodada.setEnabledAt(5, false);
        tp_rodada.setEnabledAt(4, true);
        tp_rodada.setSelectedIndex(4);
    }//GEN-LAST:event_bt_voltar06ActionPerformed

    private void bt_avancar06ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_avancar06ActionPerformed
        if (!ta_questao06.getText().equals("") && !ta_gabarito06.getText().equals("")) {
            tp_rodada.setEnabledAt(5, false);
            tp_rodada.setEnabledAt(6, true);
            tp_rodada.setSelectedIndex(6);
            u.liberapainel(painel_qst07);
        } else {
            JOptionPane.showMessageDialog(null, "Questão 06 ou Gabarito 06, não podem estar vazio!");
        }
    }//GEN-LAST:event_bt_avancar06ActionPerformed

    private void bt_voltar07ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_voltar07ActionPerformed
        tp_rodada.setEnabledAt(6, false);
        tp_rodada.setEnabledAt(5, true);
        tp_rodada.setSelectedIndex(5);
    }//GEN-LAST:event_bt_voltar07ActionPerformed

    private void bt_avancar07ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_avancar07ActionPerformed
        if (!ta_questao07.getText().equals("") && !ta_gabarito07.getText().equals("")) {
            tp_rodada.setEnabledAt(6, false);
            tp_rodada.setEnabledAt(7, true);
            tp_rodada.setSelectedIndex(7);
            u.liberapainel(painel_qst08);
        } else {
            JOptionPane.showMessageDialog(null, "Questão 07 ou Gabarito 07, não podem estar vazio!");
        }
    }//GEN-LAST:event_bt_avancar07ActionPerformed

    private void bt_voltar08ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_voltar08ActionPerformed
        tp_rodada.setEnabledAt(7, false);
        tp_rodada.setEnabledAt(6, true);
        tp_rodada.setSelectedIndex(6);
    }//GEN-LAST:event_bt_voltar08ActionPerformed

    private void bt_avancar08ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_avancar08ActionPerformed
        if (!ta_questao08.getText().equals("") && !ta_gabarito08.getText().equals("")) {
            tp_rodada.setEnabledAt(7, false);
            tp_rodada.setEnabledAt(8, true);
            tp_rodada.setSelectedIndex(8);
            u.liberapainel(painel_qst09);
        } else {
            JOptionPane.showMessageDialog(null, "Questão 08 ou Gabarito 08, não podem estar vazio!");
        }
    }//GEN-LAST:event_bt_avancar08ActionPerformed

    private void bt_voltar09ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_voltar09ActionPerformed
        tp_rodada.setEnabledAt(8, false);
        tp_rodada.setEnabledAt(7, true);
        tp_rodada.setSelectedIndex(7);
    }//GEN-LAST:event_bt_voltar09ActionPerformed

    private void bt_avancar09ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_avancar09ActionPerformed
        if (!ta_questao09.getText().equals("") && !ta_gabarito09.getText().equals("")) {
            tp_rodada.setEnabledAt(8, false);
            tp_rodada.setEnabledAt(9, true);
            tp_rodada.setSelectedIndex(9);
            u.liberapainel(painel_qst10);
        } else {
            JOptionPane.showMessageDialog(null, "Questão 09 ou Gabarito 09, não podem estar vazio!");
        }
    }//GEN-LAST:event_bt_avancar09ActionPerformed

    private void bt_voltar10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_voltar10ActionPerformed
        tp_rodada.setEnabledAt(9, false);
        tp_rodada.setEnabledAt(8, true);
        tp_rodada.setSelectedIndex(8);
    }//GEN-LAST:event_bt_voltar10ActionPerformed

    private void bt_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_salvarActionPerformed

        if (!ta_questao10.getText().equals("") && !ta_gabarito10.getText().equals("")) {
            
            if (JOptionPane.showConfirmDialog(null, "Deseja salvar o Questionario?", "Salvar", 2) == 0) {
                
                Equipe e = new Equipe();
                EquipeWebDAO ewdao = new EquipeWebDAO();
                Questao q = new Questao();
                QuestaoWebDAO qwdao = new QuestaoWebDAO();
                
                //BUSCAR EQUIPE
                ewdao.BuscarEquipe(e,ut.getEquipe_idEquipe());
                
                //ATUALIZAR QUESTÃO 01
                q.setIdQuestao(e.getIdQuestao_Equipe01());
                q.setCorpo_Questao(ta_questao01.getText());
                q.setGabarito(ta_gabarito01.getText());
                q.setQualificacao_Questao("NÃO APLICADO");
                qwdao.AtualizarQuestao(q);
                
                //ATUALIZAR QUESTÃO 02
                q.setIdQuestao(e.getIdQuestao_Equipe02());
                q.setCorpo_Questao(ta_questao02.getText());
                q.setGabarito(ta_gabarito02.getText());
                q.setQualificacao_Questao("NÃO APLICADO");
                qwdao.AtualizarQuestao(q);
                
                //ATUALIZAR QUESTÃO 03
                q.setIdQuestao(e.getIdQuestao_Equipe03());
                q.setCorpo_Questao(ta_questao03.getText());
                q.setGabarito(ta_gabarito03.getText());
                q.setQualificacao_Questao("NÃO APLICADO");
                qwdao.AtualizarQuestao(q);
                
                //ATUALIZAR QUESTÃO 04
                q.setIdQuestao(e.getIdQuestao_Equipe04());
                q.setCorpo_Questao(ta_questao04.getText());
                q.setGabarito(ta_gabarito04.getText());
                q.setQualificacao_Questao("NÃO APLICADO");
                qwdao.AtualizarQuestao(q);
                
                //ATUALIZAR QUESTÃO 05
                q.setIdQuestao(e.getIdQuestao_Equipe05());
                q.setCorpo_Questao(ta_questao05.getText());
                q.setGabarito(ta_gabarito05.getText());
                q.setQualificacao_Questao("NÃO APLICADO");
                qwdao.AtualizarQuestao(q);
                
                //ATUALIZAR QUESTÃO 06
                q.setIdQuestao(e.getIdQuestao_Equipe06());
                q.setCorpo_Questao(ta_questao06.getText());
                q.setGabarito(ta_gabarito06.getText());
                q.setQualificacao_Questao("NÃO APLICADO");
                qwdao.AtualizarQuestao(q);
                
                //ATUALIZAR QUESTÃO 07
                q.setIdQuestao(e.getIdQuestao_Equipe07());
                q.setCorpo_Questao(ta_questao07.getText());
                q.setGabarito(ta_gabarito07.getText());
                q.setQualificacao_Questao("NÃO APLICADO");
                qwdao.AtualizarQuestao(q);
                
                //ATUALIZAR QUESTÃO 08
                q.setIdQuestao(e.getIdQuestao_Equipe08());
                q.setCorpo_Questao(ta_questao08.getText());
                q.setGabarito(ta_gabarito08.getText());
                q.setQualificacao_Questao("NÃO APLICADO");
                qwdao.AtualizarQuestao(q);
                
                //ATUALIZAR QUESTÃO 09
                q.setIdQuestao(e.getIdQuestao_Equipe09());
                q.setCorpo_Questao(ta_questao09.getText());
                q.setGabarito(ta_gabarito09.getText());
                q.setQualificacao_Questao("NÃO APLICADO");
                qwdao.AtualizarQuestao(q);
                
                //ATUALIZAR QUESTÃO 10
                q.setIdQuestao(e.getIdQuestao_Equipe10());
                q.setCorpo_Questao(ta_questao10.getText());
                q.setGabarito(ta_gabarito10.getText());
                q.setQualificacao_Questao("NÃO APLICADO");
                qwdao.AtualizarQuestao(q);
                
                //LIMPAR CAMPOS
                JOptionPane.showMessageDialog(null, "Salvo com Sucesso!");
                LimparCampos();
                BloquearPaineis();
                BuscarQuestoes();
            }
       
        } else {
            JOptionPane.showMessageDialog(null, "Questão 10 ou Gabarito 10, não podem estar vazio!");
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
            java.util.logging.Logger.getLogger(Tela_AdicionarQuestionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela_AdicionarQuestionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela_AdicionarQuestionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela_AdicionarQuestionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Tela_AdicionarQuestionario dialog = new Tela_AdicionarQuestionario(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton bt_avancar01;
    private javax.swing.JButton bt_avancar02;
    private javax.swing.JButton bt_avancar03;
    private javax.swing.JButton bt_avancar04;
    private javax.swing.JButton bt_avancar05;
    private javax.swing.JButton bt_avancar06;
    private javax.swing.JButton bt_avancar07;
    private javax.swing.JButton bt_avancar08;
    private javax.swing.JButton bt_avancar09;
    private javax.swing.JButton bt_cancelar;
    private javax.swing.JButton bt_salvar;
    private javax.swing.JButton bt_voltar02;
    private javax.swing.JButton bt_voltar03;
    private javax.swing.JButton bt_voltar04;
    private javax.swing.JButton bt_voltar05;
    private javax.swing.JButton bt_voltar06;
    private javax.swing.JButton bt_voltar07;
    private javax.swing.JButton bt_voltar08;
    private javax.swing.JButton bt_voltar09;
    private javax.swing.JButton bt_voltar10;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JScrollPane jScrollPane20;
    private javax.swing.JScrollPane jScrollPane21;
    private javax.swing.JScrollPane jScrollPane22;
    private javax.swing.JScrollPane jScrollPane23;
    private javax.swing.JScrollPane jScrollPane24;
    private javax.swing.JScrollPane jScrollPane25;
    private javax.swing.JScrollPane jScrollPane26;
    private javax.swing.JScrollPane jScrollPane27;
    private javax.swing.JScrollPane jScrollPane28;
    private javax.swing.JScrollPane jScrollPane29;
    private javax.swing.JPanel painel_qst01;
    private javax.swing.JPanel painel_qst02;
    private javax.swing.JPanel painel_qst03;
    private javax.swing.JPanel painel_qst04;
    private javax.swing.JPanel painel_qst05;
    private javax.swing.JPanel painel_qst06;
    private javax.swing.JPanel painel_qst07;
    private javax.swing.JPanel painel_qst08;
    private javax.swing.JPanel painel_qst09;
    private javax.swing.JPanel painel_qst10;
    private javax.swing.JTextArea ta_gabarito01;
    private javax.swing.JTextArea ta_gabarito02;
    private javax.swing.JTextArea ta_gabarito03;
    private javax.swing.JTextArea ta_gabarito04;
    private javax.swing.JTextArea ta_gabarito05;
    private javax.swing.JTextArea ta_gabarito06;
    private javax.swing.JTextArea ta_gabarito07;
    private javax.swing.JTextArea ta_gabarito08;
    private javax.swing.JTextArea ta_gabarito09;
    private javax.swing.JTextArea ta_gabarito10;
    private javax.swing.JTextArea ta_questao01;
    private javax.swing.JTextArea ta_questao02;
    private javax.swing.JTextArea ta_questao03;
    private javax.swing.JTextArea ta_questao04;
    private javax.swing.JTextArea ta_questao05;
    private javax.swing.JTextArea ta_questao06;
    private javax.swing.JTextArea ta_questao07;
    private javax.swing.JTextArea ta_questao08;
    private javax.swing.JTextArea ta_questao09;
    private javax.swing.JTextArea ta_questao10;
    private javax.swing.JTabbedPane tp_rodada;
    // End of variables declaration//GEN-END:variables
}
