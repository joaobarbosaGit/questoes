package Telas;

import Classes.Equipe;
import Classes.Questao;
import Classes.Resposta;
import Classes.Usuario_Token;
import Servicos.Utilitarios;
import WebService.EquipeWebDAO;
import WebService.QuestaoWebDAO;
import WebService.RespostaWebDAO;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Tela_ResponderQuestionario extends javax.swing.JDialog {

    Utilitarios u = new Utilitarios();
    Usuario_Token ut = Usuario_Token.getInstance();
    ArrayList<Questao> listaQuestoes = new ArrayList<>();
    ArrayList<Resposta> listaRespostas = new ArrayList<>();
    Equipe e = new Equipe();
    Equipe er = new Equipe();
    EquipeWebDAO ewdao = new EquipeWebDAO();
    Questao q = new Questao();
    QuestaoWebDAO qwdao = new QuestaoWebDAO();
    Resposta r = new Resposta();
    RespostaWebDAO rwdao = new RespostaWebDAO();

    public Tela_ResponderQuestionario(java.awt.Frame parent, boolean modal) {

        super(parent, modal);
        initComponents();
        GerarIcones();
        tb_Questoes.setEnabled(false);
        BloquearAreasTexto();
        BuscarQuestoes();
        
    }

    private void GerarIcones() {

        //QUESTAO 01
        rb01_qst1.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
        rb02_qst1.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
        rb03_qst1.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
        rb04_qst1.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
        rb05_qst1.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
        jl_qualificacao1.setText("INRRELEVANTE");
        jl_qualificacao1.setForeground(Color.red);

        //QUESTAO 02
        rb01_qst2.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
        rb02_qst2.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
        rb03_qst2.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
        rb04_qst2.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
        rb05_qst2.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
        jl_qualificacao2.setText("INRRELEVANTE");
        jl_qualificacao2.setForeground(Color.red);

        //QUESTAO 03
        rb01_qst3.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
        rb02_qst3.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
        rb03_qst3.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
        rb04_qst3.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
        rb05_qst3.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
        jl_qualificacao3.setText("INRRELEVANTE");
        jl_qualificacao3.setForeground(Color.red);

        //QUESTAO 04
        rb01_qst4.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
        rb02_qst4.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
        rb03_qst4.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
        rb04_qst4.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
        rb05_qst4.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
        jl_qualificacao4.setText("INRRELEVANTE");
        jl_qualificacao4.setForeground(Color.red);

        //QUESTAO 05
        rb01_qst5.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
        rb02_qst5.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
        rb03_qst5.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
        rb04_qst5.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
        rb05_qst5.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
        jl_qualificacao5.setText("INRRELEVANTE");
        jl_qualificacao5.setForeground(Color.red);

        //QUESTAO 06
        rb01_qst6.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
        rb02_qst6.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
        rb03_qst6.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
        rb04_qst6.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
        rb05_qst6.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
        jl_qualificacao6.setText("INRRELEVANTE");
        jl_qualificacao6.setForeground(Color.red);

        //QUESTAO 07
        rb01_qst7.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
        rb02_qst7.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
        rb03_qst7.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
        rb04_qst7.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
        rb05_qst7.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
        jl_qualificacao7.setText("INRRELEVANTE");
        jl_qualificacao7.setForeground(Color.red);

        //QUESTAO 08
        rb01_qst8.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
        rb02_qst8.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
        rb03_qst8.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
        rb04_qst8.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
        rb05_qst8.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
        jl_qualificacao8.setText("INRRELEVANTE");
        jl_qualificacao8.setForeground(Color.red);

        //QUESTAO 09
        rb01_qst9.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
        rb02_qst9.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
        rb03_qst9.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
        rb04_qst9.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
        rb05_qst9.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
        jl_qualificacao9.setText("INRRELEVANTE");
        jl_qualificacao9.setForeground(Color.red);

        //QUESTAO 10
        rb01_qst10.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
        rb02_qst10.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
        rb03_qst10.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
        rb04_qst10.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
        rb05_qst10.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
        jl_qualificacao10.setText("INRRELEVANTE");
        jl_qualificacao10.setForeground(Color.red);

    }

    private void BloquearAreasTexto() {

        ta_Questao1.setEditable(false);
        ta_Questao2.setEditable(false);
        ta_Questao3.setEditable(false);
        ta_Questao4.setEditable(false);
        ta_Questao5.setEditable(false);
        ta_Questao6.setEditable(false);
        ta_Questao7.setEditable(false);
        ta_Questao8.setEditable(false);
        ta_Questao9.setEditable(false);
        ta_Questao10.setEditable(false);

    }

    private void LimparCampos() {

        ta_Resposta1.setText("");
        ta_Resposta2.setText("");
        ta_Resposta3.setText("");
        ta_Resposta4.setText("");
        ta_Resposta5.setText("");
        ta_Resposta6.setText("");
        ta_Resposta7.setText("");
        ta_Resposta8.setText("");
        ta_Resposta9.setText("");
        ta_Resposta10.setText("");
        ta_Questao1.setText("");
        ta_Questao2.setText("");
        ta_Questao3.setText("");
        ta_Questao4.setText("");
        ta_Questao5.setText("");
        ta_Questao6.setText("");
        ta_Questao7.setText("");
        ta_Questao8.setText("");
        ta_Questao9.setText("");
        ta_Questao10.setText("");
        tb_Questoes.setEnabledAt(1, false);
        tb_Questoes.setEnabledAt(0, true);
        tb_Questoes.setSelectedIndex(0);
        listaQuestoes.clear();
        listaRespostas.clear();
        GerarIcones();
    }

    private void BuscarQuestoes() {

        //BUSCAR EQUIPE
        ewdao.BuscarEquipe(e, ut.getEquipe_idEquipe());
        ewdao.BuscarEquipe(er, e.getEquipe_Para_Resposta());

        //QUESTAO 01
        qwdao.BuscarQuestao(er.getIdQuestao_Equipe01(), q);
        ta_Questao1.setText(q.getCorpo_Questao());
        listaQuestoes.add(q);
        q = new Questao();
        rwdao.BuscarResposta(e.getIdResposta_Equipe01(), r);
        listaRespostas.add(r);
        r = new Resposta();

        //QUESTAO 02
        qwdao.BuscarQuestao(er.getIdQuestao_Equipe02(), q);
        ta_Questao2.setText(q.getCorpo_Questao());
        listaQuestoes.add(q);
        q = new Questao();
        rwdao.BuscarResposta(e.getIdResposta_Equipe02(), r);
        listaRespostas.add(r);
        r = new Resposta();

        //QUESTAO 03
        qwdao.BuscarQuestao(er.getIdQuestao_Equipe03(), q);
        ta_Questao3.setText(q.getCorpo_Questao());
        listaQuestoes.add(q);
        q = new Questao();
        rwdao.BuscarResposta(e.getIdResposta_Equipe03(), r);
        listaRespostas.add(r);
        r = new Resposta();

        //QUESTAO 04
        qwdao.BuscarQuestao(er.getIdQuestao_Equipe04(), q);
        ta_Questao4.setText(q.getCorpo_Questao());
        listaQuestoes.add(q);
        q = new Questao();
        rwdao.BuscarResposta(e.getIdResposta_Equipe04(), r);
        listaRespostas.add(r);
        r = new Resposta();

        //QUESTAO 05
        qwdao.BuscarQuestao(er.getIdQuestao_Equipe05(), q);
        ta_Questao5.setText(q.getCorpo_Questao());
        listaQuestoes.add(q);
        q = new Questao();
        rwdao.BuscarResposta(e.getIdResposta_Equipe05(), r);
        listaRespostas.add(r);
        r = new Resposta();

        //QUESTAO 06
        qwdao.BuscarQuestao(er.getIdQuestao_Equipe06(), q);
        ta_Questao6.setText(q.getCorpo_Questao());
        listaQuestoes.add(q);
        q = new Questao();
        rwdao.BuscarResposta(e.getIdResposta_Equipe06(), r);
        listaRespostas.add(r);
        r = new Resposta();

        //QUESTAO 07
        qwdao.BuscarQuestao(er.getIdQuestao_Equipe07(), q);
        ta_Questao7.setText(q.getCorpo_Questao());
        listaQuestoes.add(q);
        q = new Questao();
        rwdao.BuscarResposta(e.getIdResposta_Equipe07(), r);
        listaRespostas.add(r);
        r = new Resposta();

        //QUESTAO 08
        qwdao.BuscarQuestao(er.getIdQuestao_Equipe08(), q);
        ta_Questao8.setText(q.getCorpo_Questao());
        listaQuestoes.add(q);
        q = new Questao();
        rwdao.BuscarResposta(e.getIdResposta_Equipe08(), r);
        listaRespostas.add(r);
        r = new Resposta();

        //QUESTAO 09
        qwdao.BuscarQuestao(er.getIdQuestao_Equipe09(), q);
        ta_Questao9.setText(q.getCorpo_Questao());
        listaQuestoes.add(q);
        q = new Questao();
        rwdao.BuscarResposta(e.getIdResposta_Equipe09(), r);
        listaRespostas.add(r);
        r = new Resposta();

        //QUESTAO 10
        qwdao.BuscarQuestao(er.getIdQuestao_Equipe10(), q);
        ta_Questao10.setText(q.getCorpo_Questao());
        listaQuestoes.add(q);
        q = new Questao();
        rwdao.BuscarResposta(e.getIdResposta_Equipe10(), r);
        listaRespostas.add(r);
        r = new Resposta();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        tb_Questoes = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        painel_qst01 = new javax.swing.JPanel();
        bt_Cancelar = new javax.swing.JButton();
        jl_Questao1 = new javax.swing.JLabel();
        jScrollPane32 = new javax.swing.JScrollPane();
        ta_Questao1 = new javax.swing.JTextArea();
        jl_Resposta1 = new javax.swing.JLabel();
        jScrollPane33 = new javax.swing.JScrollPane();
        ta_Resposta1 = new javax.swing.JTextArea();
        bt_Avancar1 = new javax.swing.JButton();
        painel_ql01 = new javax.swing.JPanel();
        rb01_qst1 = new javax.swing.JRadioButton();
        rb02_qst1 = new javax.swing.JRadioButton();
        rb03_qst1 = new javax.swing.JRadioButton();
        rb04_qst1 = new javax.swing.JRadioButton();
        rb05_qst1 = new javax.swing.JRadioButton();
        jl_qualificacao1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        painel_qst02 = new javax.swing.JPanel();
        bt_Voltar2 = new javax.swing.JButton();
        jl_Questao2 = new javax.swing.JLabel();
        jScrollPane34 = new javax.swing.JScrollPane();
        ta_Questao2 = new javax.swing.JTextArea();
        jl_Resposta2 = new javax.swing.JLabel();
        jScrollPane35 = new javax.swing.JScrollPane();
        ta_Resposta2 = new javax.swing.JTextArea();
        bt_Avancar2 = new javax.swing.JButton();
        painel_ql02 = new javax.swing.JPanel();
        rb01_qst2 = new javax.swing.JRadioButton();
        rb02_qst2 = new javax.swing.JRadioButton();
        rb03_qst2 = new javax.swing.JRadioButton();
        rb04_qst2 = new javax.swing.JRadioButton();
        rb05_qst2 = new javax.swing.JRadioButton();
        jl_qualificacao2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        painel_qst03 = new javax.swing.JPanel();
        bt_Voltar3 = new javax.swing.JButton();
        jl_Questao3 = new javax.swing.JLabel();
        jScrollPane36 = new javax.swing.JScrollPane();
        ta_Questao3 = new javax.swing.JTextArea();
        jl_Resposta3 = new javax.swing.JLabel();
        jScrollPane37 = new javax.swing.JScrollPane();
        ta_Resposta3 = new javax.swing.JTextArea();
        bt_Avancar3 = new javax.swing.JButton();
        painel_ql03 = new javax.swing.JPanel();
        rb01_qst3 = new javax.swing.JRadioButton();
        rb02_qst3 = new javax.swing.JRadioButton();
        rb03_qst3 = new javax.swing.JRadioButton();
        rb04_qst3 = new javax.swing.JRadioButton();
        rb05_qst3 = new javax.swing.JRadioButton();
        jl_qualificacao3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        painel_qst04 = new javax.swing.JPanel();
        bt_Voltar4 = new javax.swing.JButton();
        jl_Questao4 = new javax.swing.JLabel();
        jScrollPane38 = new javax.swing.JScrollPane();
        ta_Questao4 = new javax.swing.JTextArea();
        jl_Resposta4 = new javax.swing.JLabel();
        jScrollPane39 = new javax.swing.JScrollPane();
        ta_Resposta4 = new javax.swing.JTextArea();
        bt_Avancar4 = new javax.swing.JButton();
        painel_ql04 = new javax.swing.JPanel();
        rb01_qst4 = new javax.swing.JRadioButton();
        rb02_qst4 = new javax.swing.JRadioButton();
        rb03_qst4 = new javax.swing.JRadioButton();
        rb04_qst4 = new javax.swing.JRadioButton();
        rb05_qst4 = new javax.swing.JRadioButton();
        jl_qualificacao4 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        painel_qst05 = new javax.swing.JPanel();
        bt_Voltar5 = new javax.swing.JButton();
        jl_Questao5 = new javax.swing.JLabel();
        jScrollPane40 = new javax.swing.JScrollPane();
        ta_Questao5 = new javax.swing.JTextArea();
        jl_Resposta5 = new javax.swing.JLabel();
        jScrollPane41 = new javax.swing.JScrollPane();
        ta_Resposta5 = new javax.swing.JTextArea();
        bt_Avancar5 = new javax.swing.JButton();
        painel_ql05 = new javax.swing.JPanel();
        rb01_qst5 = new javax.swing.JRadioButton();
        rb02_qst5 = new javax.swing.JRadioButton();
        rb03_qst5 = new javax.swing.JRadioButton();
        rb04_qst5 = new javax.swing.JRadioButton();
        rb05_qst5 = new javax.swing.JRadioButton();
        jl_qualificacao5 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        painel_qst06 = new javax.swing.JPanel();
        bt_Voltar6 = new javax.swing.JButton();
        jl_Questao6 = new javax.swing.JLabel();
        jScrollPane42 = new javax.swing.JScrollPane();
        ta_Questao6 = new javax.swing.JTextArea();
        jl_Resposta6 = new javax.swing.JLabel();
        jScrollPane43 = new javax.swing.JScrollPane();
        ta_Resposta6 = new javax.swing.JTextArea();
        bt_Avancar6 = new javax.swing.JButton();
        painel_ql06 = new javax.swing.JPanel();
        rb01_qst6 = new javax.swing.JRadioButton();
        rb02_qst6 = new javax.swing.JRadioButton();
        rb03_qst6 = new javax.swing.JRadioButton();
        rb04_qst6 = new javax.swing.JRadioButton();
        rb05_qst6 = new javax.swing.JRadioButton();
        jl_qualificacao6 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        painel_qst07 = new javax.swing.JPanel();
        bt_Voltar7 = new javax.swing.JButton();
        jl_Questao7 = new javax.swing.JLabel();
        jScrollPane44 = new javax.swing.JScrollPane();
        ta_Questao7 = new javax.swing.JTextArea();
        jl_Resposta7 = new javax.swing.JLabel();
        jScrollPane45 = new javax.swing.JScrollPane();
        ta_Resposta7 = new javax.swing.JTextArea();
        bt_Avancar7 = new javax.swing.JButton();
        painel_ql07 = new javax.swing.JPanel();
        rb01_qst7 = new javax.swing.JRadioButton();
        rb02_qst7 = new javax.swing.JRadioButton();
        rb03_qst7 = new javax.swing.JRadioButton();
        rb04_qst7 = new javax.swing.JRadioButton();
        rb05_qst7 = new javax.swing.JRadioButton();
        jl_qualificacao7 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        painel_qst08 = new javax.swing.JPanel();
        bt_Voltar8 = new javax.swing.JButton();
        jl_Questao8 = new javax.swing.JLabel();
        jScrollPane46 = new javax.swing.JScrollPane();
        ta_Questao8 = new javax.swing.JTextArea();
        jl_Resposta8 = new javax.swing.JLabel();
        jScrollPane47 = new javax.swing.JScrollPane();
        ta_Resposta8 = new javax.swing.JTextArea();
        bt_Avancar8 = new javax.swing.JButton();
        painel_ql08 = new javax.swing.JPanel();
        rb01_qst8 = new javax.swing.JRadioButton();
        rb02_qst8 = new javax.swing.JRadioButton();
        rb03_qst8 = new javax.swing.JRadioButton();
        rb04_qst8 = new javax.swing.JRadioButton();
        rb05_qst8 = new javax.swing.JRadioButton();
        jl_qualificacao8 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        painel_qst09 = new javax.swing.JPanel();
        bt_Voltar9 = new javax.swing.JButton();
        jl_Questao9 = new javax.swing.JLabel();
        jScrollPane48 = new javax.swing.JScrollPane();
        ta_Questao9 = new javax.swing.JTextArea();
        jl_Resposta9 = new javax.swing.JLabel();
        jScrollPane49 = new javax.swing.JScrollPane();
        ta_Resposta9 = new javax.swing.JTextArea();
        bt_Avancar9 = new javax.swing.JButton();
        painel_ql09 = new javax.swing.JPanel();
        rb01_qst9 = new javax.swing.JRadioButton();
        rb02_qst9 = new javax.swing.JRadioButton();
        rb03_qst9 = new javax.swing.JRadioButton();
        rb04_qst9 = new javax.swing.JRadioButton();
        rb05_qst9 = new javax.swing.JRadioButton();
        jl_qualificacao9 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        painel_qst10 = new javax.swing.JPanel();
        bt_Voltar10 = new javax.swing.JButton();
        jl_Questao10 = new javax.swing.JLabel();
        jScrollPane50 = new javax.swing.JScrollPane();
        ta_Questao10 = new javax.swing.JTextArea();
        jl_Resposta10 = new javax.swing.JLabel();
        jScrollPane51 = new javax.swing.JScrollPane();
        ta_Resposta10 = new javax.swing.JTextArea();
        bt_Salvar = new javax.swing.JButton();
        painel_ql10 = new javax.swing.JPanel();
        rb01_qst10 = new javax.swing.JRadioButton();
        rb02_qst10 = new javax.swing.JRadioButton();
        rb03_qst10 = new javax.swing.JRadioButton();
        rb04_qst10 = new javax.swing.JRadioButton();
        rb05_qst10 = new javax.swing.JRadioButton();
        jl_qualificacao10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        tb_Questoes.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        tb_Questoes.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);

        bt_Cancelar.setText("CANCELAR");
        bt_Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_CancelarActionPerformed(evt);
            }
        });

        jl_Questao1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jl_Questao1.setText("Questão 01:");

        ta_Questao1.setEditable(false);
        ta_Questao1.setBackground(new java.awt.Color(204, 204, 204));
        ta_Questao1.setColumns(20);
        ta_Questao1.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        ta_Questao1.setRows(5);
        ta_Questao1.setFocusable(false);
        jScrollPane32.setViewportView(ta_Questao1);

        jl_Resposta1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jl_Resposta1.setText("Resposta 01:");

        ta_Resposta1.setColumns(20);
        ta_Resposta1.setRows(5);
        jScrollPane33.setViewportView(ta_Resposta1);

        bt_Avancar1.setText("AVANÇAR");
        bt_Avancar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_Avancar1ActionPerformed(evt);
            }
        });

        painel_ql01.setBorder(javax.swing.BorderFactory.createTitledBorder("Qualificação"));

        rb01_qst1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/bomb.png"))); // NOI18N
        rb01_qst1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb01_qst1ActionPerformed(evt);
            }
        });

        rb02_qst1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/bomb.png"))); // NOI18N
        rb02_qst1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb02_qst1ActionPerformed(evt);
            }
        });

        rb03_qst1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/bomb.png"))); // NOI18N
        rb03_qst1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb03_qst1ActionPerformed(evt);
            }
        });

        rb04_qst1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/bomb.png"))); // NOI18N
        rb04_qst1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb04_qst1ActionPerformed(evt);
            }
        });

        rb05_qst1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/bomb.png"))); // NOI18N
        rb05_qst1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb05_qst1ActionPerformed(evt);
            }
        });

        jl_qualificacao1.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jl_qualificacao1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout painel_ql01Layout = new javax.swing.GroupLayout(painel_ql01);
        painel_ql01.setLayout(painel_ql01Layout);
        painel_ql01Layout.setHorizontalGroup(
            painel_ql01Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_ql01Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_ql01Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jl_qualificacao1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(painel_ql01Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(rb01_qst1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rb02_qst1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rb03_qst1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rb04_qst1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rb05_qst1)
                        .addGap(0, 24, Short.MAX_VALUE)))
                .addContainerGap())
        );
        painel_ql01Layout.setVerticalGroup(
            painel_ql01Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_ql01Layout.createSequentialGroup()
                .addComponent(jl_qualificacao1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painel_ql01Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(rb01_qst1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rb02_qst1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rb03_qst1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rb04_qst1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rb05_qst1, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout painel_qst01Layout = new javax.swing.GroupLayout(painel_qst01);
        painel_qst01.setLayout(painel_qst01Layout);
        painel_qst01Layout.setHorizontalGroup(
            painel_qst01Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_qst01Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_qst01Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane32)
                    .addComponent(jScrollPane33, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
                    .addGroup(painel_qst01Layout.createSequentialGroup()
                        .addGroup(painel_qst01Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jl_Resposta1)
                            .addComponent(jl_Questao1))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(painel_qst01Layout.createSequentialGroup()
                        .addComponent(painel_ql01, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_Cancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_Avancar1)))
                .addContainerGap())
        );
        painel_qst01Layout.setVerticalGroup(
            painel_qst01Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel_qst01Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jl_Questao1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane32, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jl_Resposta1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane33, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(painel_qst01Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painel_qst01Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(painel_ql01, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel_qst01Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(painel_qst01Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bt_Cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bt_Avancar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19))))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 596, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(painel_qst01, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(painel_qst01, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        tb_Questoes.addTab("QST 01", jPanel2);

        bt_Voltar2.setText("VOLTAR");
        bt_Voltar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_Voltar2ActionPerformed(evt);
            }
        });

        jl_Questao2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jl_Questao2.setText("Questão 02:");

        ta_Questao2.setEditable(false);
        ta_Questao2.setBackground(new java.awt.Color(204, 204, 204));
        ta_Questao2.setColumns(20);
        ta_Questao2.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        ta_Questao2.setRows(5);
        ta_Questao2.setFocusable(false);
        jScrollPane34.setViewportView(ta_Questao2);

        jl_Resposta2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jl_Resposta2.setText("Resposta 02:");

        ta_Resposta2.setColumns(20);
        ta_Resposta2.setRows(5);
        jScrollPane35.setViewportView(ta_Resposta2);

        bt_Avancar2.setText("AVANÇAR");
        bt_Avancar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_Avancar2ActionPerformed(evt);
            }
        });

        painel_ql02.setBorder(javax.swing.BorderFactory.createTitledBorder("Qualificação"));

        rb01_qst2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/bomb.png"))); // NOI18N
        rb01_qst2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb01_qst2ActionPerformed(evt);
            }
        });

        rb02_qst2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/bomb.png"))); // NOI18N
        rb02_qst2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb02_qst2ActionPerformed(evt);
            }
        });

        rb03_qst2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/bomb.png"))); // NOI18N
        rb03_qst2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb03_qst2ActionPerformed(evt);
            }
        });

        rb04_qst2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/bomb.png"))); // NOI18N
        rb04_qst2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb04_qst2ActionPerformed(evt);
            }
        });

        rb05_qst2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/bomb.png"))); // NOI18N
        rb05_qst2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb05_qst2ActionPerformed(evt);
            }
        });

        jl_qualificacao2.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jl_qualificacao2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout painel_ql02Layout = new javax.swing.GroupLayout(painel_ql02);
        painel_ql02.setLayout(painel_ql02Layout);
        painel_ql02Layout.setHorizontalGroup(
            painel_ql02Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_ql02Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_ql02Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jl_qualificacao2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(painel_ql02Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(rb01_qst2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rb02_qst2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rb03_qst2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rb04_qst2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rb05_qst2)
                        .addGap(0, 24, Short.MAX_VALUE)))
                .addContainerGap())
        );
        painel_ql02Layout.setVerticalGroup(
            painel_ql02Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_ql02Layout.createSequentialGroup()
                .addComponent(jl_qualificacao2, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painel_ql02Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(rb01_qst2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rb02_qst2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rb03_qst2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rb04_qst2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rb05_qst2, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout painel_qst02Layout = new javax.swing.GroupLayout(painel_qst02);
        painel_qst02.setLayout(painel_qst02Layout);
        painel_qst02Layout.setHorizontalGroup(
            painel_qst02Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_qst02Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_qst02Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane34)
                    .addComponent(jScrollPane35, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
                    .addGroup(painel_qst02Layout.createSequentialGroup()
                        .addGroup(painel_qst02Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jl_Resposta2)
                            .addComponent(jl_Questao2))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(painel_qst02Layout.createSequentialGroup()
                        .addComponent(painel_ql02, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_Voltar2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_Avancar2)))
                .addContainerGap())
        );
        painel_qst02Layout.setVerticalGroup(
            painel_qst02Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel_qst02Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jl_Questao2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane34, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jl_Resposta2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane35, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(painel_qst02Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painel_qst02Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(painel_ql02, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel_qst02Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(painel_qst02Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bt_Avancar2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bt_Voltar2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19))))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 596, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(painel_qst02, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(painel_qst02, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        tb_Questoes.addTab("QST 02", jPanel3);

        bt_Voltar3.setText("VOLTAR");
        bt_Voltar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_Voltar3ActionPerformed(evt);
            }
        });

        jl_Questao3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jl_Questao3.setText("Questão 03:");

        ta_Questao3.setEditable(false);
        ta_Questao3.setBackground(new java.awt.Color(204, 204, 204));
        ta_Questao3.setColumns(20);
        ta_Questao3.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        ta_Questao3.setRows(5);
        ta_Questao3.setFocusable(false);
        jScrollPane36.setViewportView(ta_Questao3);

        jl_Resposta3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jl_Resposta3.setText("Resposta 03:");

        ta_Resposta3.setColumns(20);
        ta_Resposta3.setRows(5);
        jScrollPane37.setViewportView(ta_Resposta3);

        bt_Avancar3.setText("AVANÇAR");
        bt_Avancar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_Avancar3ActionPerformed(evt);
            }
        });

        painel_ql03.setBorder(javax.swing.BorderFactory.createTitledBorder("Qualificação"));

        rb01_qst3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/bomb.png"))); // NOI18N
        rb01_qst3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb01_qst3ActionPerformed(evt);
            }
        });

        rb02_qst3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/bomb.png"))); // NOI18N
        rb02_qst3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb02_qst3ActionPerformed(evt);
            }
        });

        rb03_qst3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/bomb.png"))); // NOI18N
        rb03_qst3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb03_qst3ActionPerformed(evt);
            }
        });

        rb04_qst3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/bomb.png"))); // NOI18N
        rb04_qst3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb04_qst3ActionPerformed(evt);
            }
        });

        rb05_qst3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/bomb.png"))); // NOI18N
        rb05_qst3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb05_qst3ActionPerformed(evt);
            }
        });

        jl_qualificacao3.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jl_qualificacao3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout painel_ql03Layout = new javax.swing.GroupLayout(painel_ql03);
        painel_ql03.setLayout(painel_ql03Layout);
        painel_ql03Layout.setHorizontalGroup(
            painel_ql03Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_ql03Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_ql03Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jl_qualificacao3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(painel_ql03Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(rb01_qst3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rb02_qst3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rb03_qst3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rb04_qst3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rb05_qst3)
                        .addGap(0, 24, Short.MAX_VALUE)))
                .addContainerGap())
        );
        painel_ql03Layout.setVerticalGroup(
            painel_ql03Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_ql03Layout.createSequentialGroup()
                .addComponent(jl_qualificacao3, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painel_ql03Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(rb01_qst3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rb02_qst3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rb03_qst3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rb04_qst3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rb05_qst3, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout painel_qst03Layout = new javax.swing.GroupLayout(painel_qst03);
        painel_qst03.setLayout(painel_qst03Layout);
        painel_qst03Layout.setHorizontalGroup(
            painel_qst03Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_qst03Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_qst03Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane36)
                    .addComponent(jScrollPane37, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
                    .addGroup(painel_qst03Layout.createSequentialGroup()
                        .addGroup(painel_qst03Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jl_Resposta3)
                            .addComponent(jl_Questao3))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(painel_qst03Layout.createSequentialGroup()
                        .addComponent(painel_ql03, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_Voltar3, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_Avancar3)))
                .addContainerGap())
        );
        painel_qst03Layout.setVerticalGroup(
            painel_qst03Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel_qst03Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jl_Questao3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane36, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jl_Resposta3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane37, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(painel_qst03Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painel_qst03Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(painel_ql03, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel_qst03Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(painel_qst03Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bt_Voltar3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bt_Avancar3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19))))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 596, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(painel_qst03, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(painel_qst03, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        tb_Questoes.addTab("QST 03", jPanel4);

        bt_Voltar4.setText("VOLTAR");
        bt_Voltar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_Voltar4ActionPerformed(evt);
            }
        });

        jl_Questao4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jl_Questao4.setText("Questão 04:");

        ta_Questao4.setEditable(false);
        ta_Questao4.setBackground(new java.awt.Color(204, 204, 204));
        ta_Questao4.setColumns(20);
        ta_Questao4.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        ta_Questao4.setRows(5);
        ta_Questao4.setFocusable(false);
        jScrollPane38.setViewportView(ta_Questao4);

        jl_Resposta4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jl_Resposta4.setText("Resposta 04:");

        ta_Resposta4.setColumns(20);
        ta_Resposta4.setRows(5);
        jScrollPane39.setViewportView(ta_Resposta4);

        bt_Avancar4.setText("AVANÇAR");
        bt_Avancar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_Avancar4ActionPerformed(evt);
            }
        });

        painel_ql04.setBorder(javax.swing.BorderFactory.createTitledBorder("Qualificação"));

        rb01_qst4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/bomb.png"))); // NOI18N
        rb01_qst4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb01_qst4ActionPerformed(evt);
            }
        });

        rb02_qst4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/bomb.png"))); // NOI18N
        rb02_qst4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb02_qst4ActionPerformed(evt);
            }
        });

        rb03_qst4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/bomb.png"))); // NOI18N
        rb03_qst4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb03_qst4ActionPerformed(evt);
            }
        });

        rb04_qst4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/bomb.png"))); // NOI18N
        rb04_qst4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb04_qst4ActionPerformed(evt);
            }
        });

        rb05_qst4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/bomb.png"))); // NOI18N
        rb05_qst4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb05_qst4ActionPerformed(evt);
            }
        });

        jl_qualificacao4.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jl_qualificacao4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout painel_ql04Layout = new javax.swing.GroupLayout(painel_ql04);
        painel_ql04.setLayout(painel_ql04Layout);
        painel_ql04Layout.setHorizontalGroup(
            painel_ql04Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_ql04Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_ql04Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jl_qualificacao4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(painel_ql04Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(rb01_qst4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rb02_qst4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rb03_qst4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rb04_qst4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rb05_qst4)
                        .addGap(0, 24, Short.MAX_VALUE)))
                .addContainerGap())
        );
        painel_ql04Layout.setVerticalGroup(
            painel_ql04Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_ql04Layout.createSequentialGroup()
                .addComponent(jl_qualificacao4, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painel_ql04Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(rb01_qst4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rb02_qst4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rb03_qst4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rb04_qst4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rb05_qst4, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout painel_qst04Layout = new javax.swing.GroupLayout(painel_qst04);
        painel_qst04.setLayout(painel_qst04Layout);
        painel_qst04Layout.setHorizontalGroup(
            painel_qst04Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_qst04Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_qst04Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane38)
                    .addComponent(jScrollPane39, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
                    .addGroup(painel_qst04Layout.createSequentialGroup()
                        .addGroup(painel_qst04Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jl_Resposta4)
                            .addComponent(jl_Questao4))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(painel_qst04Layout.createSequentialGroup()
                        .addComponent(painel_ql04, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_Voltar4, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_Avancar4)))
                .addContainerGap())
        );
        painel_qst04Layout.setVerticalGroup(
            painel_qst04Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel_qst04Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jl_Questao4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane38, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jl_Resposta4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane39, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(painel_qst04Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painel_qst04Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(painel_ql04, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel_qst04Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(painel_qst04Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bt_Voltar4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bt_Avancar4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19))))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 596, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(painel_qst04, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(painel_qst04, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        tb_Questoes.addTab("QST 04", jPanel5);

        bt_Voltar5.setText("VOLTAR");
        bt_Voltar5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_Voltar5ActionPerformed(evt);
            }
        });

        jl_Questao5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jl_Questao5.setText("Questão 05:");

        ta_Questao5.setEditable(false);
        ta_Questao5.setBackground(new java.awt.Color(204, 204, 204));
        ta_Questao5.setColumns(20);
        ta_Questao5.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        ta_Questao5.setRows(5);
        ta_Questao5.setFocusable(false);
        jScrollPane40.setViewportView(ta_Questao5);

        jl_Resposta5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jl_Resposta5.setText("Resposta 05:");

        ta_Resposta5.setColumns(20);
        ta_Resposta5.setRows(5);
        jScrollPane41.setViewportView(ta_Resposta5);

        bt_Avancar5.setText("AVANÇAR");
        bt_Avancar5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_Avancar5ActionPerformed(evt);
            }
        });

        painel_ql05.setBorder(javax.swing.BorderFactory.createTitledBorder("Qualificação"));

        rb01_qst5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/bomb.png"))); // NOI18N
        rb01_qst5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb01_qst5ActionPerformed(evt);
            }
        });

        rb02_qst5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/bomb.png"))); // NOI18N
        rb02_qst5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb02_qst5ActionPerformed(evt);
            }
        });

        rb03_qst5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/bomb.png"))); // NOI18N
        rb03_qst5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb03_qst5ActionPerformed(evt);
            }
        });

        rb04_qst5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/bomb.png"))); // NOI18N
        rb04_qst5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb04_qst5ActionPerformed(evt);
            }
        });

        rb05_qst5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/bomb.png"))); // NOI18N
        rb05_qst5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb05_qst5ActionPerformed(evt);
            }
        });

        jl_qualificacao5.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jl_qualificacao5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout painel_ql05Layout = new javax.swing.GroupLayout(painel_ql05);
        painel_ql05.setLayout(painel_ql05Layout);
        painel_ql05Layout.setHorizontalGroup(
            painel_ql05Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_ql05Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_ql05Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jl_qualificacao5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(painel_ql05Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(rb01_qst5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rb02_qst5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rb03_qst5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rb04_qst5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rb05_qst5)
                        .addGap(0, 24, Short.MAX_VALUE)))
                .addContainerGap())
        );
        painel_ql05Layout.setVerticalGroup(
            painel_ql05Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_ql05Layout.createSequentialGroup()
                .addComponent(jl_qualificacao5, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painel_ql05Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(rb01_qst5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rb02_qst5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rb03_qst5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rb04_qst5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rb05_qst5, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout painel_qst05Layout = new javax.swing.GroupLayout(painel_qst05);
        painel_qst05.setLayout(painel_qst05Layout);
        painel_qst05Layout.setHorizontalGroup(
            painel_qst05Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_qst05Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_qst05Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane40)
                    .addComponent(jScrollPane41, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
                    .addGroup(painel_qst05Layout.createSequentialGroup()
                        .addGroup(painel_qst05Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jl_Resposta5)
                            .addComponent(jl_Questao5))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(painel_qst05Layout.createSequentialGroup()
                        .addComponent(painel_ql05, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_Voltar5, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_Avancar5)))
                .addContainerGap())
        );
        painel_qst05Layout.setVerticalGroup(
            painel_qst05Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel_qst05Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jl_Questao5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane40, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jl_Resposta5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane41, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(painel_qst05Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painel_qst05Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(painel_ql05, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel_qst05Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(painel_qst05Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bt_Voltar5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bt_Avancar5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19))))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 596, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(painel_qst05, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(painel_qst05, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        tb_Questoes.addTab("QST 05", jPanel6);

        bt_Voltar6.setText("VOLTAR");
        bt_Voltar6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_Voltar6ActionPerformed(evt);
            }
        });

        jl_Questao6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jl_Questao6.setText("Questão 06:");

        ta_Questao6.setEditable(false);
        ta_Questao6.setBackground(new java.awt.Color(204, 204, 204));
        ta_Questao6.setColumns(20);
        ta_Questao6.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        ta_Questao6.setRows(5);
        ta_Questao6.setFocusable(false);
        jScrollPane42.setViewportView(ta_Questao6);

        jl_Resposta6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jl_Resposta6.setText("Resposta 06:");

        ta_Resposta6.setColumns(20);
        ta_Resposta6.setRows(5);
        jScrollPane43.setViewportView(ta_Resposta6);

        bt_Avancar6.setText("AVANÇAR");
        bt_Avancar6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_Avancar6ActionPerformed(evt);
            }
        });

        painel_ql06.setBorder(javax.swing.BorderFactory.createTitledBorder("Qualificação"));

        rb01_qst6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/bomb.png"))); // NOI18N
        rb01_qst6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb01_qst6ActionPerformed(evt);
            }
        });

        rb02_qst6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/bomb.png"))); // NOI18N
        rb02_qst6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb02_qst6ActionPerformed(evt);
            }
        });

        rb03_qst6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/bomb.png"))); // NOI18N
        rb03_qst6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb03_qst6ActionPerformed(evt);
            }
        });

        rb04_qst6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/bomb.png"))); // NOI18N
        rb04_qst6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb04_qst6ActionPerformed(evt);
            }
        });

        rb05_qst6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/bomb.png"))); // NOI18N
        rb05_qst6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb05_qst6ActionPerformed(evt);
            }
        });

        jl_qualificacao6.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jl_qualificacao6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout painel_ql06Layout = new javax.swing.GroupLayout(painel_ql06);
        painel_ql06.setLayout(painel_ql06Layout);
        painel_ql06Layout.setHorizontalGroup(
            painel_ql06Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_ql06Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_ql06Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jl_qualificacao6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(painel_ql06Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(rb01_qst6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rb02_qst6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rb03_qst6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rb04_qst6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rb05_qst6)
                        .addGap(0, 24, Short.MAX_VALUE)))
                .addContainerGap())
        );
        painel_ql06Layout.setVerticalGroup(
            painel_ql06Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_ql06Layout.createSequentialGroup()
                .addComponent(jl_qualificacao6, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painel_ql06Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(rb01_qst6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rb02_qst6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rb03_qst6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rb04_qst6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rb05_qst6, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout painel_qst06Layout = new javax.swing.GroupLayout(painel_qst06);
        painel_qst06.setLayout(painel_qst06Layout);
        painel_qst06Layout.setHorizontalGroup(
            painel_qst06Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_qst06Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_qst06Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane42)
                    .addComponent(jScrollPane43, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
                    .addGroup(painel_qst06Layout.createSequentialGroup()
                        .addGroup(painel_qst06Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jl_Resposta6)
                            .addComponent(jl_Questao6))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(painel_qst06Layout.createSequentialGroup()
                        .addComponent(painel_ql06, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_Voltar6, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_Avancar6)))
                .addContainerGap())
        );
        painel_qst06Layout.setVerticalGroup(
            painel_qst06Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel_qst06Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jl_Questao6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane42, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jl_Resposta6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane43, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(painel_qst06Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painel_qst06Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(painel_ql06, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel_qst06Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(painel_qst06Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bt_Voltar6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bt_Avancar6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19))))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 596, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(painel_qst06, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(painel_qst06, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        tb_Questoes.addTab("QST 06", jPanel7);

        bt_Voltar7.setText("VOLTAR");
        bt_Voltar7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_Voltar7ActionPerformed(evt);
            }
        });

        jl_Questao7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jl_Questao7.setText("Questão 07:");

        ta_Questao7.setEditable(false);
        ta_Questao7.setBackground(new java.awt.Color(204, 204, 204));
        ta_Questao7.setColumns(20);
        ta_Questao7.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        ta_Questao7.setRows(5);
        ta_Questao7.setFocusable(false);
        jScrollPane44.setViewportView(ta_Questao7);

        jl_Resposta7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jl_Resposta7.setText("Resposta 07:");

        ta_Resposta7.setColumns(20);
        ta_Resposta7.setRows(5);
        jScrollPane45.setViewportView(ta_Resposta7);

        bt_Avancar7.setText("AVANÇAR");
        bt_Avancar7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_Avancar7ActionPerformed(evt);
            }
        });

        painel_ql07.setBorder(javax.swing.BorderFactory.createTitledBorder("Qualificação"));

        rb01_qst7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/bomb.png"))); // NOI18N
        rb01_qst7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb01_qst7ActionPerformed(evt);
            }
        });

        rb02_qst7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/bomb.png"))); // NOI18N
        rb02_qst7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb02_qst7ActionPerformed(evt);
            }
        });

        rb03_qst7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/bomb.png"))); // NOI18N
        rb03_qst7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb03_qst7ActionPerformed(evt);
            }
        });

        rb04_qst7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/bomb.png"))); // NOI18N
        rb04_qst7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb04_qst7ActionPerformed(evt);
            }
        });

        rb05_qst7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/bomb.png"))); // NOI18N
        rb05_qst7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb05_qst7ActionPerformed(evt);
            }
        });

        jl_qualificacao7.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jl_qualificacao7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout painel_ql07Layout = new javax.swing.GroupLayout(painel_ql07);
        painel_ql07.setLayout(painel_ql07Layout);
        painel_ql07Layout.setHorizontalGroup(
            painel_ql07Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_ql07Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_ql07Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jl_qualificacao7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(painel_ql07Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(rb01_qst7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rb02_qst7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rb03_qst7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rb04_qst7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rb05_qst7)
                        .addGap(0, 24, Short.MAX_VALUE)))
                .addContainerGap())
        );
        painel_ql07Layout.setVerticalGroup(
            painel_ql07Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_ql07Layout.createSequentialGroup()
                .addComponent(jl_qualificacao7, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painel_ql07Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(rb01_qst7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rb02_qst7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rb03_qst7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rb04_qst7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rb05_qst7, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout painel_qst07Layout = new javax.swing.GroupLayout(painel_qst07);
        painel_qst07.setLayout(painel_qst07Layout);
        painel_qst07Layout.setHorizontalGroup(
            painel_qst07Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_qst07Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_qst07Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane44)
                    .addComponent(jScrollPane45, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
                    .addGroup(painel_qst07Layout.createSequentialGroup()
                        .addGroup(painel_qst07Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jl_Resposta7)
                            .addComponent(jl_Questao7))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(painel_qst07Layout.createSequentialGroup()
                        .addComponent(painel_ql07, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_Voltar7, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_Avancar7)))
                .addContainerGap())
        );
        painel_qst07Layout.setVerticalGroup(
            painel_qst07Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel_qst07Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jl_Questao7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane44, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jl_Resposta7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane45, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(painel_qst07Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painel_qst07Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(painel_ql07, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel_qst07Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(painel_qst07Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bt_Voltar7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bt_Avancar7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19))))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 596, Short.MAX_VALUE)
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel8Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(painel_qst07, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel8Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(painel_qst07, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        tb_Questoes.addTab("QST 07", jPanel8);

        bt_Voltar8.setText("VOLTAR");
        bt_Voltar8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_Voltar8ActionPerformed(evt);
            }
        });

        jl_Questao8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jl_Questao8.setText("Questão 08:");

        ta_Questao8.setEditable(false);
        ta_Questao8.setBackground(new java.awt.Color(204, 204, 204));
        ta_Questao8.setColumns(20);
        ta_Questao8.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        ta_Questao8.setRows(5);
        ta_Questao8.setFocusable(false);
        jScrollPane46.setViewportView(ta_Questao8);

        jl_Resposta8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jl_Resposta8.setText("Resposta 08:");

        ta_Resposta8.setColumns(20);
        ta_Resposta8.setRows(5);
        jScrollPane47.setViewportView(ta_Resposta8);

        bt_Avancar8.setText("AVANÇAR");
        bt_Avancar8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_Avancar8ActionPerformed(evt);
            }
        });

        painel_ql08.setBorder(javax.swing.BorderFactory.createTitledBorder("Qualificação"));

        rb01_qst8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/bomb.png"))); // NOI18N
        rb01_qst8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb01_qst8ActionPerformed(evt);
            }
        });

        rb02_qst8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/bomb.png"))); // NOI18N
        rb02_qst8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb02_qst8ActionPerformed(evt);
            }
        });

        rb03_qst8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/bomb.png"))); // NOI18N
        rb03_qst8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb03_qst8ActionPerformed(evt);
            }
        });

        rb04_qst8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/bomb.png"))); // NOI18N
        rb04_qst8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb04_qst8ActionPerformed(evt);
            }
        });

        rb05_qst8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/bomb.png"))); // NOI18N
        rb05_qst8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb05_qst8ActionPerformed(evt);
            }
        });

        jl_qualificacao8.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jl_qualificacao8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout painel_ql08Layout = new javax.swing.GroupLayout(painel_ql08);
        painel_ql08.setLayout(painel_ql08Layout);
        painel_ql08Layout.setHorizontalGroup(
            painel_ql08Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_ql08Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_ql08Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jl_qualificacao8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(painel_ql08Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(rb01_qst8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rb02_qst8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rb03_qst8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rb04_qst8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rb05_qst8)
                        .addGap(0, 24, Short.MAX_VALUE)))
                .addContainerGap())
        );
        painel_ql08Layout.setVerticalGroup(
            painel_ql08Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_ql08Layout.createSequentialGroup()
                .addComponent(jl_qualificacao8, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painel_ql08Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(rb01_qst8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rb02_qst8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rb03_qst8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rb04_qst8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rb05_qst8, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout painel_qst08Layout = new javax.swing.GroupLayout(painel_qst08);
        painel_qst08.setLayout(painel_qst08Layout);
        painel_qst08Layout.setHorizontalGroup(
            painel_qst08Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_qst08Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_qst08Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane46)
                    .addComponent(jScrollPane47, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
                    .addGroup(painel_qst08Layout.createSequentialGroup()
                        .addGroup(painel_qst08Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jl_Resposta8)
                            .addComponent(jl_Questao8))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(painel_qst08Layout.createSequentialGroup()
                        .addComponent(painel_ql08, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_Voltar8, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_Avancar8)))
                .addContainerGap())
        );
        painel_qst08Layout.setVerticalGroup(
            painel_qst08Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel_qst08Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jl_Questao8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane46, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jl_Resposta8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane47, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(painel_qst08Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painel_qst08Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(painel_ql08, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel_qst08Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(painel_qst08Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bt_Voltar8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bt_Avancar8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19))))
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 596, Short.MAX_VALUE)
            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel9Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(painel_qst08, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel9Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(painel_qst08, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        tb_Questoes.addTab("QST 08", jPanel9);

        bt_Voltar9.setText("VOLTAR");
        bt_Voltar9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_Voltar9ActionPerformed(evt);
            }
        });

        jl_Questao9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jl_Questao9.setText("Questão 09:");

        ta_Questao9.setEditable(false);
        ta_Questao9.setBackground(new java.awt.Color(204, 204, 204));
        ta_Questao9.setColumns(20);
        ta_Questao9.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        ta_Questao9.setRows(5);
        ta_Questao9.setFocusable(false);
        jScrollPane48.setViewportView(ta_Questao9);

        jl_Resposta9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jl_Resposta9.setText("Resposta 09:");

        ta_Resposta9.setColumns(20);
        ta_Resposta9.setRows(5);
        jScrollPane49.setViewportView(ta_Resposta9);

        bt_Avancar9.setText("AVANÇAR");
        bt_Avancar9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_Avancar9ActionPerformed(evt);
            }
        });

        painel_ql09.setBorder(javax.swing.BorderFactory.createTitledBorder("Qualificação"));

        rb01_qst9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/bomb.png"))); // NOI18N
        rb01_qst9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb01_qst9ActionPerformed(evt);
            }
        });

        rb02_qst9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/bomb.png"))); // NOI18N
        rb02_qst9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb02_qst9ActionPerformed(evt);
            }
        });

        rb03_qst9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/bomb.png"))); // NOI18N
        rb03_qst9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb03_qst9ActionPerformed(evt);
            }
        });

        rb04_qst9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/bomb.png"))); // NOI18N
        rb04_qst9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb04_qst9ActionPerformed(evt);
            }
        });

        rb05_qst9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/bomb.png"))); // NOI18N
        rb05_qst9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb05_qst9ActionPerformed(evt);
            }
        });

        jl_qualificacao9.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jl_qualificacao9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout painel_ql09Layout = new javax.swing.GroupLayout(painel_ql09);
        painel_ql09.setLayout(painel_ql09Layout);
        painel_ql09Layout.setHorizontalGroup(
            painel_ql09Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_ql09Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_ql09Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jl_qualificacao9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(painel_ql09Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(rb01_qst9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rb02_qst9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rb03_qst9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rb04_qst9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rb05_qst9)
                        .addGap(0, 24, Short.MAX_VALUE)))
                .addContainerGap())
        );
        painel_ql09Layout.setVerticalGroup(
            painel_ql09Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_ql09Layout.createSequentialGroup()
                .addComponent(jl_qualificacao9, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painel_ql09Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(rb01_qst9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rb02_qst9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rb03_qst9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rb04_qst9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rb05_qst9, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout painel_qst09Layout = new javax.swing.GroupLayout(painel_qst09);
        painel_qst09.setLayout(painel_qst09Layout);
        painel_qst09Layout.setHorizontalGroup(
            painel_qst09Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_qst09Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_qst09Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane48)
                    .addComponent(jScrollPane49, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
                    .addGroup(painel_qst09Layout.createSequentialGroup()
                        .addGroup(painel_qst09Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jl_Resposta9)
                            .addComponent(jl_Questao9))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(painel_qst09Layout.createSequentialGroup()
                        .addComponent(painel_ql09, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_Voltar9, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_Avancar9)))
                .addContainerGap())
        );
        painel_qst09Layout.setVerticalGroup(
            painel_qst09Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel_qst09Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jl_Questao9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane48, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jl_Resposta9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane49, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(painel_qst09Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painel_qst09Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(painel_ql09, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel_qst09Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(painel_qst09Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bt_Voltar9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bt_Avancar9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19))))
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 596, Short.MAX_VALUE)
            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel10Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(painel_qst09, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel10Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(painel_qst09, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        tb_Questoes.addTab("QST 09", jPanel10);

        bt_Voltar10.setText("VOLTAR");
        bt_Voltar10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_Voltar10ActionPerformed(evt);
            }
        });

        jl_Questao10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jl_Questao10.setText("Questão 10:");

        ta_Questao10.setEditable(false);
        ta_Questao10.setBackground(new java.awt.Color(204, 204, 204));
        ta_Questao10.setColumns(20);
        ta_Questao10.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        ta_Questao10.setRows(5);
        ta_Questao10.setFocusable(false);
        jScrollPane50.setViewportView(ta_Questao10);

        jl_Resposta10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jl_Resposta10.setText("Resposta 10:");

        ta_Resposta10.setColumns(20);
        ta_Resposta10.setRows(5);
        jScrollPane51.setViewportView(ta_Resposta10);

        bt_Salvar.setText("SALVAR");
        bt_Salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_SalvarActionPerformed(evt);
            }
        });

        painel_ql10.setBorder(javax.swing.BorderFactory.createTitledBorder("Qualificação"));

        rb01_qst10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/bomb.png"))); // NOI18N
        rb01_qst10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb01_qst10ActionPerformed(evt);
            }
        });

        rb02_qst10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/bomb.png"))); // NOI18N
        rb02_qst10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb02_qst10ActionPerformed(evt);
            }
        });

        rb03_qst10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/bomb.png"))); // NOI18N
        rb03_qst10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb03_qst10ActionPerformed(evt);
            }
        });

        rb04_qst10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/bomb.png"))); // NOI18N
        rb04_qst10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb04_qst10ActionPerformed(evt);
            }
        });

        rb05_qst10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/bomb.png"))); // NOI18N
        rb05_qst10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb05_qst10ActionPerformed(evt);
            }
        });

        jl_qualificacao10.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jl_qualificacao10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout painel_ql10Layout = new javax.swing.GroupLayout(painel_ql10);
        painel_ql10.setLayout(painel_ql10Layout);
        painel_ql10Layout.setHorizontalGroup(
            painel_ql10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_ql10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_ql10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jl_qualificacao10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(painel_ql10Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(rb01_qst10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rb02_qst10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rb03_qst10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rb04_qst10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rb05_qst10)
                        .addGap(0, 24, Short.MAX_VALUE)))
                .addContainerGap())
        );
        painel_ql10Layout.setVerticalGroup(
            painel_ql10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_ql10Layout.createSequentialGroup()
                .addComponent(jl_qualificacao10, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painel_ql10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(rb01_qst10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rb02_qst10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rb03_qst10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rb04_qst10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rb05_qst10, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout painel_qst10Layout = new javax.swing.GroupLayout(painel_qst10);
        painel_qst10.setLayout(painel_qst10Layout);
        painel_qst10Layout.setHorizontalGroup(
            painel_qst10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_qst10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_qst10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane50)
                    .addComponent(jScrollPane51, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
                    .addGroup(painel_qst10Layout.createSequentialGroup()
                        .addGroup(painel_qst10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jl_Resposta10)
                            .addComponent(jl_Questao10))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(painel_qst10Layout.createSequentialGroup()
                        .addComponent(painel_ql10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_Voltar10, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_Salvar)))
                .addContainerGap())
        );
        painel_qst10Layout.setVerticalGroup(
            painel_qst10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel_qst10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jl_Questao10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane50, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jl_Resposta10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane51, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(painel_qst10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painel_qst10Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(painel_ql10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel_qst10Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(painel_qst10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bt_Voltar10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bt_Salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19))))
        );

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 596, Short.MAX_VALUE)
            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel11Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(painel_qst10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel11Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(painel_qst10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        tb_Questoes.addTab("QST 10", jPanel11);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tb_Questoes)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tb_Questoes)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void rb01_qst1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb01_qst1ActionPerformed

        if (rb01_qst1.isSelected()) {
            rb01_qst1.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb02_qst1.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            rb03_qst1.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            rb04_qst1.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            rb05_qst1.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            jl_qualificacao1.setText("INRRELEVANTE");
            jl_qualificacao1.setForeground(Color.RED);
        } else {
            rb01_qst1.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb02_qst1.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            rb03_qst1.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            rb04_qst1.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            rb05_qst1.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            jl_qualificacao1.setText("INRRELEVANTE");
            jl_qualificacao1.setForeground(Color.RED);
        }

    }//GEN-LAST:event_rb01_qst1ActionPerformed

    private void rb02_qst1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb02_qst1ActionPerformed

        if (rb02_qst1.isSelected()) {
            rb01_qst1.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb02_qst1.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb03_qst1.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            rb04_qst1.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            rb05_qst1.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            jl_qualificacao1.setText("POUCO RELEVANTE");
            jl_qualificacao1.setForeground(Color.ORANGE);
        } else {
            rb01_qst1.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb02_qst1.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb03_qst1.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            rb04_qst1.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            rb05_qst1.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            jl_qualificacao1.setText("POUCO RELEVANTE");
            jl_qualificacao1.setForeground(Color.ORANGE);
        }

    }//GEN-LAST:event_rb02_qst1ActionPerformed

    private void rb03_qst1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb03_qst1ActionPerformed

        if (rb03_qst1.isSelected()) {
            rb01_qst1.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb02_qst1.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb03_qst1.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb04_qst1.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            rb05_qst1.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            jl_qualificacao1.setText("RELEVANTE");
            jl_qualificacao1.setForeground(Color.MAGENTA);
        } else {
            rb01_qst1.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb02_qst1.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb03_qst1.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb04_qst1.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            rb05_qst1.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            jl_qualificacao1.setText("RELEVANTE");
            jl_qualificacao1.setForeground(Color.MAGENTA);
        }

    }//GEN-LAST:event_rb03_qst1ActionPerformed

    private void rb04_qst1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb04_qst1ActionPerformed

        if (rb04_qst1.isSelected()) {
            rb01_qst1.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb02_qst1.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb03_qst1.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb04_qst1.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb05_qst1.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            jl_qualificacao1.setText("MUITO RELEVANTE");
            jl_qualificacao1.setForeground(Color.BLUE);
        } else {
            rb01_qst1.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb02_qst1.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb03_qst1.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb04_qst1.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb05_qst1.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            jl_qualificacao1.setText("MUITO RELEVANTE");
            jl_qualificacao1.setForeground(Color.BLUE);
        }

    }//GEN-LAST:event_rb04_qst1ActionPerformed

    private void rb05_qst1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb05_qst1ActionPerformed

        if (rb05_qst1.isSelected()) {
            rb01_qst1.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb02_qst1.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb03_qst1.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb04_qst1.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb05_qst1.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            jl_qualificacao1.setText("EXTREMAMENTE RELEVANTE");
            jl_qualificacao1.setForeground(Color.GREEN);
        } else {
            rb01_qst1.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb02_qst1.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb03_qst1.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb04_qst1.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb05_qst1.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            jl_qualificacao1.setText("EXTREMAMENTE RELEVANTE");
            jl_qualificacao1.setForeground(Color.GREEN);
        }

    }//GEN-LAST:event_rb05_qst1ActionPerformed

    private void rb01_qst2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb01_qst2ActionPerformed

        if (rb01_qst2.isSelected()) {
            rb01_qst2.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb02_qst2.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            rb03_qst2.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            rb04_qst2.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            rb05_qst2.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            jl_qualificacao2.setText("INRRELEVANTE");
            jl_qualificacao2.setForeground(Color.RED);
        } else {
            rb01_qst2.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb02_qst2.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            rb03_qst2.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            rb04_qst2.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            rb05_qst2.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            jl_qualificacao2.setText("INRRELEVANTE");
            jl_qualificacao2.setForeground(Color.RED);
        }

    }//GEN-LAST:event_rb01_qst2ActionPerformed

    private void rb02_qst2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb02_qst2ActionPerformed

        if (rb02_qst2.isSelected()) {
            rb01_qst2.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb02_qst2.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb03_qst2.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            rb04_qst2.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            rb05_qst2.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            jl_qualificacao2.setText("POUCO RELEVANTE");
            jl_qualificacao2.setForeground(Color.ORANGE);
        } else {
            rb01_qst2.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb02_qst2.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb03_qst2.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            rb04_qst2.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            rb05_qst2.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            jl_qualificacao2.setText("POUCO RELEVANTE");
            jl_qualificacao2.setForeground(Color.ORANGE);
        }

    }//GEN-LAST:event_rb02_qst2ActionPerformed

    private void rb03_qst2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb03_qst2ActionPerformed

        if (rb03_qst2.isSelected()) {
            rb01_qst2.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb02_qst2.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb03_qst2.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb04_qst2.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            rb05_qst2.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            jl_qualificacao2.setText("RELEVANTE");
            jl_qualificacao2.setForeground(Color.MAGENTA);
        } else {
            rb01_qst2.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb02_qst2.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb03_qst2.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb04_qst2.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            rb05_qst2.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            jl_qualificacao2.setText("RELEVANTE");
            jl_qualificacao2.setForeground(Color.MAGENTA);
        }

    }//GEN-LAST:event_rb03_qst2ActionPerformed

    private void rb04_qst2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb04_qst2ActionPerformed

        if (rb04_qst2.isSelected()) {
            rb01_qst2.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb02_qst2.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb03_qst2.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb04_qst2.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb05_qst2.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            jl_qualificacao2.setText("MUITO RELEVANTE");
            jl_qualificacao2.setForeground(Color.BLUE);
        } else {
            rb01_qst2.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb02_qst2.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb03_qst2.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb04_qst2.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb05_qst2.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            jl_qualificacao2.setText("MUITO RELEVANTE");
            jl_qualificacao2.setForeground(Color.BLUE);
        }

    }//GEN-LAST:event_rb04_qst2ActionPerformed

    private void rb05_qst2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb05_qst2ActionPerformed

        if (rb05_qst2.isSelected()) {
            rb01_qst2.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb02_qst2.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb03_qst2.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb04_qst2.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb05_qst2.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            jl_qualificacao2.setText("EXTREMAMENTE RELEVANTE");
            jl_qualificacao2.setForeground(Color.GREEN);
        } else {
            rb01_qst2.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb02_qst2.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb03_qst2.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb04_qst2.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb05_qst2.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            jl_qualificacao2.setText("EXTREMAMENTE RELEVANTE");
            jl_qualificacao2.setForeground(Color.GREEN);
        }

    }//GEN-LAST:event_rb05_qst2ActionPerformed

    private void rb01_qst3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb01_qst3ActionPerformed

        if (rb01_qst3.isSelected()) {
            rb01_qst3.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb02_qst3.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            rb03_qst3.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            rb04_qst3.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            rb05_qst3.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            jl_qualificacao3.setText("INRRELEVANTE");
            jl_qualificacao3.setForeground(Color.RED);
        } else {
            rb01_qst3.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb02_qst3.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            rb03_qst3.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            rb04_qst3.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            rb05_qst3.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            jl_qualificacao3.setText("INRRELEVANTE");
            jl_qualificacao3.setForeground(Color.RED);
        }

    }//GEN-LAST:event_rb01_qst3ActionPerformed

    private void rb02_qst3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb02_qst3ActionPerformed

        if (rb02_qst3.isSelected()) {
            rb01_qst3.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb02_qst3.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb03_qst3.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            rb04_qst3.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            rb05_qst3.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            jl_qualificacao3.setText("POUCO RELEVANTE");
            jl_qualificacao3.setForeground(Color.ORANGE);
        } else {
            rb01_qst3.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb02_qst3.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb03_qst3.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            rb04_qst3.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            rb05_qst3.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            jl_qualificacao3.setText("POUCO RELEVANTE");
            jl_qualificacao3.setForeground(Color.ORANGE);
        }

    }//GEN-LAST:event_rb02_qst3ActionPerformed

    private void rb03_qst3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb03_qst3ActionPerformed

        if (rb03_qst3.isSelected()) {
            rb01_qst3.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb02_qst3.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb03_qst3.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb04_qst3.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            rb05_qst3.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            jl_qualificacao3.setText("RELEVANTE");
            jl_qualificacao3.setForeground(Color.MAGENTA);
        } else {
            rb01_qst3.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb02_qst3.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb03_qst3.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb04_qst3.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            rb05_qst3.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            jl_qualificacao3.setText("RELEVANTE");
            jl_qualificacao3.setForeground(Color.MAGENTA);
        }

    }//GEN-LAST:event_rb03_qst3ActionPerformed

    private void rb04_qst3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb04_qst3ActionPerformed

        if (rb04_qst3.isSelected()) {
            rb01_qst3.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb02_qst3.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb03_qst3.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb04_qst3.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb05_qst3.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            jl_qualificacao3.setText("MUITO RELEVANTE");
            jl_qualificacao3.setForeground(Color.BLUE);
        } else {
            rb01_qst3.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb02_qst3.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb03_qst3.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb04_qst3.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb05_qst3.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            jl_qualificacao3.setText("MUITO RELEVANTE");
            jl_qualificacao3.setForeground(Color.BLUE);
        }

    }//GEN-LAST:event_rb04_qst3ActionPerformed

    private void rb05_qst3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb05_qst3ActionPerformed

        if (rb05_qst3.isSelected()) {
            rb01_qst3.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb02_qst3.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb03_qst3.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb04_qst3.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb05_qst3.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            jl_qualificacao3.setText("EXTREMAMENTE RELEVANTE");
            jl_qualificacao3.setForeground(Color.GREEN);
        } else {
            rb01_qst3.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb02_qst3.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb03_qst3.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb04_qst3.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb05_qst3.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            jl_qualificacao3.setText("EXTREMAMENTE RELEVANTE");
            jl_qualificacao3.setForeground(Color.GREEN);
        }

    }//GEN-LAST:event_rb05_qst3ActionPerformed

    private void rb01_qst4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb01_qst4ActionPerformed

        if (rb01_qst4.isSelected()) {
            rb01_qst4.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb02_qst4.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            rb03_qst4.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            rb04_qst4.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            rb05_qst4.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            jl_qualificacao4.setText("INRRELEVANTE");
            jl_qualificacao4.setForeground(Color.RED);
        } else {
            rb01_qst4.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb02_qst4.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            rb03_qst4.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            rb04_qst4.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            rb05_qst4.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            jl_qualificacao4.setText("INRRELEVANTE");
            jl_qualificacao4.setForeground(Color.RED);
        }

    }//GEN-LAST:event_rb01_qst4ActionPerformed

    private void rb02_qst4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb02_qst4ActionPerformed

        if (rb02_qst4.isSelected()) {
            rb01_qst4.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb02_qst4.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb03_qst4.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            rb04_qst4.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            rb05_qst4.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            jl_qualificacao4.setText("POUCO RELEVANTE");
            jl_qualificacao4.setForeground(Color.ORANGE);
        } else {
            rb01_qst4.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb02_qst4.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb03_qst4.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            rb04_qst4.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            rb05_qst4.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            jl_qualificacao4.setText("POUCO RELEVANTE");
            jl_qualificacao4.setForeground(Color.ORANGE);
        }

    }//GEN-LAST:event_rb02_qst4ActionPerformed

    private void rb03_qst4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb03_qst4ActionPerformed

        if (rb03_qst4.isSelected()) {
            rb01_qst4.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb02_qst4.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb03_qst4.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb04_qst4.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            rb05_qst4.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            jl_qualificacao4.setText("RELEVANTE");
            jl_qualificacao4.setForeground(Color.MAGENTA);
        } else {
            rb01_qst4.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb02_qst4.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb03_qst4.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb04_qst4.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            rb05_qst4.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            jl_qualificacao4.setText("RELEVANTE");
            jl_qualificacao4.setForeground(Color.MAGENTA);
        }

    }//GEN-LAST:event_rb03_qst4ActionPerformed

    private void rb04_qst4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb04_qst4ActionPerformed

        if (rb04_qst4.isSelected()) {
            rb01_qst4.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb02_qst4.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb03_qst4.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb04_qst4.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb05_qst4.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            jl_qualificacao4.setText("MUITO RELEVANTE");
            jl_qualificacao4.setForeground(Color.BLUE);
        } else {
            rb01_qst4.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb02_qst4.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb03_qst4.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb04_qst4.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb05_qst4.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            jl_qualificacao4.setText("MUITO RELEVANTE");
            jl_qualificacao4.setForeground(Color.BLUE);
        }

    }//GEN-LAST:event_rb04_qst4ActionPerformed

    private void rb05_qst4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb05_qst4ActionPerformed

        if (rb05_qst4.isSelected()) {
            rb01_qst4.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb02_qst4.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb03_qst4.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb04_qst4.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb05_qst4.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            jl_qualificacao4.setText("EXTREMAMENTE RELEVANTE");
            jl_qualificacao4.setForeground(Color.GREEN);
        } else {
            rb01_qst4.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb02_qst4.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb03_qst4.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb04_qst4.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb05_qst4.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            jl_qualificacao4.setText("EXTREMAMENTE RELEVANTE");
            jl_qualificacao4.setForeground(Color.GREEN);
        }

    }//GEN-LAST:event_rb05_qst4ActionPerformed

    private void rb01_qst5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb01_qst5ActionPerformed

        if (rb01_qst5.isSelected()) {
            rb01_qst5.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb02_qst5.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            rb03_qst5.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            rb04_qst5.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            rb05_qst5.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            jl_qualificacao5.setText("INRRELEVANTE");
            jl_qualificacao5.setForeground(Color.RED);
        } else {
            rb01_qst5.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb02_qst5.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            rb03_qst5.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            rb04_qst5.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            rb05_qst5.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            jl_qualificacao5.setText("INRRELEVANTE");
            jl_qualificacao5.setForeground(Color.RED);
        }

    }//GEN-LAST:event_rb01_qst5ActionPerformed

    private void rb02_qst5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb02_qst5ActionPerformed

        if (rb02_qst5.isSelected()) {
            rb01_qst5.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb02_qst5.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb03_qst5.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            rb04_qst5.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            rb05_qst5.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            jl_qualificacao5.setText("POUCO RELEVANTE");
            jl_qualificacao5.setForeground(Color.ORANGE);
        } else {
            rb01_qst5.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb02_qst5.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb03_qst5.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            rb04_qst5.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            rb05_qst5.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            jl_qualificacao5.setText("POUCO RELEVANTE");
            jl_qualificacao5.setForeground(Color.ORANGE);
        }

    }//GEN-LAST:event_rb02_qst5ActionPerformed

    private void rb03_qst5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb03_qst5ActionPerformed

        if (rb03_qst5.isSelected()) {
            rb01_qst5.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb02_qst5.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb03_qst5.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb04_qst5.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            rb05_qst5.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            jl_qualificacao5.setText("RELEVANTE");
            jl_qualificacao5.setForeground(Color.MAGENTA);
        } else {
            rb01_qst5.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb02_qst5.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb03_qst5.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb04_qst5.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            rb05_qst5.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            jl_qualificacao5.setText("RELEVANTE");
            jl_qualificacao5.setForeground(Color.MAGENTA);
        }

    }//GEN-LAST:event_rb03_qst5ActionPerformed

    private void rb04_qst5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb04_qst5ActionPerformed

        if (rb04_qst5.isSelected()) {
            rb01_qst5.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb02_qst5.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb03_qst5.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb04_qst5.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb05_qst5.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            jl_qualificacao5.setText("MUITO RELEVANTE");
            jl_qualificacao5.setForeground(Color.BLUE);
        } else {
            rb01_qst5.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb02_qst5.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb03_qst5.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb04_qst5.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb05_qst5.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            jl_qualificacao5.setText("MUITO RELEVANTE");
            jl_qualificacao5.setForeground(Color.BLUE);
        }

    }//GEN-LAST:event_rb04_qst5ActionPerformed

    private void rb05_qst5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb05_qst5ActionPerformed

        if (rb05_qst5.isSelected()) {
            rb01_qst5.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb02_qst5.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb03_qst5.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb04_qst5.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb05_qst5.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            jl_qualificacao5.setText("EXTREMAMENTE RELEVANTE");
            jl_qualificacao5.setForeground(Color.GREEN);
        } else {
            rb01_qst5.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb02_qst5.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb03_qst5.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb04_qst5.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb05_qst5.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            jl_qualificacao5.setText("EXTREMAMENTE RELEVANTE");
            jl_qualificacao5.setForeground(Color.GREEN);
        }

    }//GEN-LAST:event_rb05_qst5ActionPerformed

    private void rb01_qst6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb01_qst6ActionPerformed

        if (rb01_qst6.isSelected()) {
            rb01_qst6.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb02_qst6.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            rb03_qst6.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            rb04_qst6.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            rb05_qst6.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            jl_qualificacao6.setText("INRRELEVANTE");
            jl_qualificacao6.setForeground(Color.RED);
        } else {
            rb01_qst6.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb02_qst6.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            rb03_qst6.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            rb04_qst6.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            rb05_qst6.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            jl_qualificacao6.setText("INRRELEVANTE");
            jl_qualificacao6.setForeground(Color.RED);
        }

    }//GEN-LAST:event_rb01_qst6ActionPerformed

    private void rb02_qst6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb02_qst6ActionPerformed

        if (rb02_qst6.isSelected()) {
            rb01_qst6.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb02_qst6.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb03_qst6.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            rb04_qst6.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            rb05_qst6.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            jl_qualificacao6.setText("POUCO RELEVANTE");
            jl_qualificacao6.setForeground(Color.ORANGE);
        } else {
            rb01_qst6.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb02_qst6.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb03_qst6.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            rb04_qst6.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            rb05_qst6.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            jl_qualificacao6.setText("POUCO RELEVANTE");
            jl_qualificacao6.setForeground(Color.ORANGE);
        }

    }//GEN-LAST:event_rb02_qst6ActionPerformed

    private void rb03_qst6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb03_qst6ActionPerformed

        if (rb03_qst6.isSelected()) {
            rb01_qst6.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb02_qst6.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb03_qst6.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb04_qst6.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            rb05_qst6.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            jl_qualificacao6.setText("RELEVANTE");
            jl_qualificacao6.setForeground(Color.MAGENTA);
        } else {
            rb01_qst6.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb02_qst6.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb03_qst6.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb04_qst6.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            rb05_qst6.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            jl_qualificacao6.setText("RELEVANTE");
            jl_qualificacao6.setForeground(Color.MAGENTA);
        }

    }//GEN-LAST:event_rb03_qst6ActionPerformed

    private void rb04_qst6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb04_qst6ActionPerformed

        if (rb04_qst6.isSelected()) {
            rb01_qst6.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb02_qst6.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb03_qst6.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb04_qst6.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb05_qst6.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            jl_qualificacao6.setText("MUITO RELEVANTE");
            jl_qualificacao6.setForeground(Color.BLUE);
        } else {
            rb01_qst6.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb02_qst6.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb03_qst6.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb04_qst6.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb05_qst6.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            jl_qualificacao6.setText("MUITO RELEVANTE");
            jl_qualificacao6.setForeground(Color.BLUE);
        }

    }//GEN-LAST:event_rb04_qst6ActionPerformed

    private void rb05_qst6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb05_qst6ActionPerformed

        if (rb05_qst6.isSelected()) {
            rb01_qst6.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb02_qst6.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb03_qst6.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb04_qst6.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb05_qst6.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            jl_qualificacao6.setText("EXTREMAMENTE RELEVANTE");
            jl_qualificacao6.setForeground(Color.GREEN);
        } else {
            rb01_qst6.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb02_qst6.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb03_qst6.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb04_qst6.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb05_qst6.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            jl_qualificacao6.setText("EXTREMAMENTE RELEVANTE");
            jl_qualificacao6.setForeground(Color.GREEN);
        }

    }//GEN-LAST:event_rb05_qst6ActionPerformed

    private void rb01_qst7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb01_qst7ActionPerformed

        if (rb01_qst7.isSelected()) {
            rb01_qst7.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb02_qst7.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            rb03_qst7.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            rb04_qst7.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            rb05_qst7.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            jl_qualificacao7.setText("INRRELEVANTE");
            jl_qualificacao7.setForeground(Color.RED);
        } else {
            rb01_qst7.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb02_qst7.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            rb03_qst7.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            rb04_qst7.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            rb05_qst7.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            jl_qualificacao7.setText("INRRELEVANTE");
            jl_qualificacao7.setForeground(Color.RED);
        }

    }//GEN-LAST:event_rb01_qst7ActionPerformed

    private void rb02_qst7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb02_qst7ActionPerformed

        if (rb02_qst7.isSelected()) {
            rb01_qst7.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb02_qst7.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb03_qst7.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            rb04_qst7.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            rb05_qst7.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            jl_qualificacao7.setText("POUCO RELEVANTE");
            jl_qualificacao7.setForeground(Color.ORANGE);
        } else {
            rb01_qst7.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb02_qst7.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb03_qst7.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            rb04_qst7.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            rb05_qst7.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            jl_qualificacao7.setText("POUCO RELEVANTE");
            jl_qualificacao7.setForeground(Color.ORANGE);
        }

    }//GEN-LAST:event_rb02_qst7ActionPerformed

    private void rb03_qst7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb03_qst7ActionPerformed

        if (rb03_qst7.isSelected()) {
            rb01_qst7.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb02_qst7.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb03_qst7.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb04_qst7.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            rb05_qst7.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            jl_qualificacao7.setText("RELEVANTE");
            jl_qualificacao7.setForeground(Color.MAGENTA);
        } else {
            rb01_qst7.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb02_qst7.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb03_qst7.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb04_qst7.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            rb05_qst7.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            jl_qualificacao7.setText("RELEVANTE");
            jl_qualificacao7.setForeground(Color.MAGENTA);
        }

    }//GEN-LAST:event_rb03_qst7ActionPerformed

    private void rb04_qst7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb04_qst7ActionPerformed

        if (rb04_qst7.isSelected()) {
            rb01_qst7.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb02_qst7.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb03_qst7.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb04_qst7.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb05_qst7.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            jl_qualificacao7.setText("MUITO RELEVANTE");
            jl_qualificacao7.setForeground(Color.BLUE);
        } else {
            rb01_qst7.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb02_qst7.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb03_qst7.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb04_qst7.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb05_qst7.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            jl_qualificacao7.setText("MUITO RELEVANTE");
            jl_qualificacao7.setForeground(Color.BLUE);
        }

    }//GEN-LAST:event_rb04_qst7ActionPerformed

    private void rb05_qst7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb05_qst7ActionPerformed

        if (rb05_qst7.isSelected()) {
            rb01_qst7.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb02_qst7.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb03_qst7.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb04_qst7.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb05_qst7.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            jl_qualificacao7.setText("EXTREMAMENTE RELEVANTE");
            jl_qualificacao7.setForeground(Color.GREEN);
        } else {
            rb01_qst7.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb02_qst7.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb03_qst7.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb04_qst7.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb05_qst7.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            jl_qualificacao7.setText("EXTREMAMENTE RELEVANTE");
            jl_qualificacao7.setForeground(Color.GREEN);
        }

    }//GEN-LAST:event_rb05_qst7ActionPerformed

    private void rb01_qst8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb01_qst8ActionPerformed

        if (rb01_qst8.isSelected()) {
            rb01_qst8.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb02_qst8.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            rb03_qst8.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            rb04_qst8.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            rb05_qst8.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            jl_qualificacao8.setText("INRRELEVANTE");
            jl_qualificacao8.setForeground(Color.RED);
        } else {
            rb01_qst8.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb02_qst8.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            rb03_qst8.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            rb04_qst8.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            rb05_qst8.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            jl_qualificacao8.setText("INRRELEVANTE");
            jl_qualificacao8.setForeground(Color.RED);
        }

    }//GEN-LAST:event_rb01_qst8ActionPerformed

    private void rb02_qst8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb02_qst8ActionPerformed

        if (rb02_qst8.isSelected()) {
            rb01_qst8.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb02_qst8.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb03_qst8.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            rb04_qst8.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            rb05_qst8.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            jl_qualificacao8.setText("POUCO RELEVANTE");
            jl_qualificacao8.setForeground(Color.ORANGE);
        } else {
            rb01_qst8.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb02_qst8.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb03_qst8.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            rb04_qst8.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            rb05_qst8.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            jl_qualificacao8.setText("POUCO RELEVANTE");
            jl_qualificacao8.setForeground(Color.ORANGE);
        }

    }//GEN-LAST:event_rb02_qst8ActionPerformed

    private void rb03_qst8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb03_qst8ActionPerformed

        if (rb03_qst8.isSelected()) {
            rb01_qst8.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb02_qst8.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb03_qst8.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb04_qst8.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            rb05_qst8.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            jl_qualificacao8.setText("RELEVANTE");
            jl_qualificacao8.setForeground(Color.MAGENTA);
        } else {
            rb01_qst8.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb02_qst8.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb03_qst8.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb04_qst8.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            rb05_qst8.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            jl_qualificacao8.setText("RELEVANTE");
            jl_qualificacao8.setForeground(Color.MAGENTA);
        }

    }//GEN-LAST:event_rb03_qst8ActionPerformed

    private void rb04_qst8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb04_qst8ActionPerformed

        if (rb04_qst8.isSelected()) {
            rb01_qst8.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb02_qst8.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb03_qst8.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb04_qst8.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb05_qst8.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            jl_qualificacao8.setText("MUITO RELEVANTE");
            jl_qualificacao8.setForeground(Color.BLUE);
        } else {
            rb01_qst8.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb02_qst8.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb03_qst8.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb04_qst8.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb05_qst8.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            jl_qualificacao8.setText("MUITO RELEVANTE");
            jl_qualificacao8.setForeground(Color.BLUE);
        }

    }//GEN-LAST:event_rb04_qst8ActionPerformed

    private void rb05_qst8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb05_qst8ActionPerformed

        if (rb05_qst8.isSelected()) {
            rb01_qst8.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb02_qst8.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb03_qst8.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb04_qst8.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb05_qst8.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            jl_qualificacao8.setText("EXTREMAMENTE RELEVANTE");
            jl_qualificacao8.setForeground(Color.GREEN);
        } else {
            rb01_qst8.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb02_qst8.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb03_qst8.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb04_qst8.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb05_qst8.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            jl_qualificacao8.setText("EXTREMAMENTE RELEVANTE");
            jl_qualificacao8.setForeground(Color.GREEN);
        }

    }//GEN-LAST:event_rb05_qst8ActionPerformed

    private void rb01_qst9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb01_qst9ActionPerformed

        if (rb01_qst9.isSelected()) {
            rb01_qst9.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb02_qst9.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            rb03_qst9.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            rb04_qst9.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            rb05_qst9.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            jl_qualificacao9.setText("INRRELEVANTE");
            jl_qualificacao9.setForeground(Color.RED);
        } else {
            rb01_qst9.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb02_qst9.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            rb03_qst9.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            rb04_qst9.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            rb05_qst9.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            jl_qualificacao9.setText("INRRELEVANTE");
            jl_qualificacao9.setForeground(Color.RED);
        }

    }//GEN-LAST:event_rb01_qst9ActionPerformed

    private void rb02_qst9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb02_qst9ActionPerformed

        if (rb02_qst9.isSelected()) {
            rb01_qst9.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb02_qst9.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb03_qst9.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            rb04_qst9.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            rb05_qst9.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            jl_qualificacao9.setText("POUCO RELEVANTE");
            jl_qualificacao9.setForeground(Color.ORANGE);
        } else {
            rb01_qst9.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb02_qst9.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb03_qst9.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            rb04_qst9.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            rb05_qst9.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            jl_qualificacao9.setText("POUCO RELEVANTE");
            jl_qualificacao9.setForeground(Color.ORANGE);
        }

    }//GEN-LAST:event_rb02_qst9ActionPerformed

    private void rb03_qst9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb03_qst9ActionPerformed

        if (rb03_qst9.isSelected()) {
            rb01_qst9.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb02_qst9.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb03_qst9.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb04_qst9.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            rb05_qst9.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            jl_qualificacao9.setText("RELEVANTE");
            jl_qualificacao9.setForeground(Color.MAGENTA);
        } else {
            rb01_qst9.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb02_qst9.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb03_qst9.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb04_qst9.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            rb05_qst9.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            jl_qualificacao9.setText("RELEVANTE");
            jl_qualificacao9.setForeground(Color.MAGENTA);
        }

    }//GEN-LAST:event_rb03_qst9ActionPerformed

    private void rb04_qst9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb04_qst9ActionPerformed

        if (rb04_qst9.isSelected()) {
            rb01_qst9.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb02_qst9.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb03_qst9.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb04_qst9.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb05_qst9.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            jl_qualificacao9.setText("MUITO RELEVANTE");
            jl_qualificacao9.setForeground(Color.BLUE);
        } else {
            rb01_qst9.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb02_qst9.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb03_qst9.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb04_qst9.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb05_qst9.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            jl_qualificacao9.setText("MUITO RELEVANTE");
            jl_qualificacao9.setForeground(Color.BLUE);
        }

    }//GEN-LAST:event_rb04_qst9ActionPerformed

    private void rb05_qst9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb05_qst9ActionPerformed

        if (rb05_qst9.isSelected()) {
            rb01_qst9.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb02_qst9.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb03_qst9.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb04_qst9.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb05_qst9.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            jl_qualificacao9.setText("EXTREMAMENTE RELEVANTE");
            jl_qualificacao9.setForeground(Color.GREEN);
        } else {
            rb01_qst9.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb02_qst9.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb03_qst9.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb04_qst9.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb05_qst9.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            jl_qualificacao9.setText("EXTREMAMENTE RELEVANTE");
            jl_qualificacao9.setForeground(Color.GREEN);
        }

    }//GEN-LAST:event_rb05_qst9ActionPerformed

    private void rb01_qst10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb01_qst10ActionPerformed

        if (rb01_qst10.isSelected()) {
            rb01_qst10.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb02_qst10.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            rb03_qst10.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            rb04_qst10.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            rb05_qst10.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            jl_qualificacao10.setText("INRRELEVANTE");
            jl_qualificacao10.setForeground(Color.RED);
        } else {
            rb01_qst10.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb02_qst10.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            rb03_qst10.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            rb04_qst10.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            rb05_qst10.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            jl_qualificacao10.setText("INRRELEVANTE");
            jl_qualificacao10.setForeground(Color.RED);
        }

    }//GEN-LAST:event_rb01_qst10ActionPerformed

    private void rb02_qst10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb02_qst10ActionPerformed

        if (rb02_qst10.isSelected()) {
            rb01_qst10.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb02_qst10.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb03_qst10.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            rb04_qst10.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            rb05_qst10.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            jl_qualificacao10.setText("POUCO RELEVANTE");
            jl_qualificacao10.setForeground(Color.ORANGE);
        } else {
            rb01_qst10.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb02_qst10.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb03_qst10.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            rb04_qst10.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            rb05_qst10.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            jl_qualificacao10.setText("POUCO RELEVANTE");
            jl_qualificacao10.setForeground(Color.ORANGE);
        }

    }//GEN-LAST:event_rb02_qst10ActionPerformed

    private void rb03_qst10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb03_qst10ActionPerformed

        if (rb03_qst10.isSelected()) {
            rb01_qst10.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb02_qst10.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb03_qst10.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb04_qst10.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            rb05_qst10.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            jl_qualificacao10.setText("RELEVANTE");
            jl_qualificacao10.setForeground(Color.MAGENTA);
        } else {
            rb01_qst10.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb02_qst10.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb03_qst10.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb04_qst10.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            rb05_qst10.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            jl_qualificacao10.setText("RELEVANTE");
            jl_qualificacao10.setForeground(Color.MAGENTA);
        }

    }//GEN-LAST:event_rb03_qst10ActionPerformed

    private void rb04_qst10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb04_qst10ActionPerformed

        if (rb04_qst10.isSelected()) {
            rb01_qst10.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb02_qst10.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb03_qst10.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb04_qst10.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb05_qst10.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            jl_qualificacao10.setText("MUITO RELEVANTE");
            jl_qualificacao10.setForeground(Color.BLUE);
        } else {
            rb01_qst10.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb02_qst10.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb03_qst10.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb04_qst10.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb05_qst10.setIcon(new ImageIcon(getClass().getResource("/Imagens/bomb.png")));
            jl_qualificacao10.setText("MUITO RELEVANTE");
            jl_qualificacao10.setForeground(Color.BLUE);
        }

    }//GEN-LAST:event_rb04_qst10ActionPerformed

    private void rb05_qst10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb05_qst10ActionPerformed

        if (rb05_qst10.isSelected()) {
            rb01_qst10.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb02_qst10.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb03_qst10.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb04_qst10.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb05_qst10.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            jl_qualificacao10.setText("EXTREMAMENTE RELEVANTE");
            jl_qualificacao10.setForeground(Color.GREEN);
        } else {
            rb01_qst10.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb02_qst10.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb03_qst10.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb04_qst10.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            rb05_qst10.setIcon(new ImageIcon(getClass().getResource("/Imagens/star.png")));
            jl_qualificacao10.setText("EXTREMAMENTE RELEVANTE");
            jl_qualificacao10.setForeground(Color.GREEN);
        }

    }//GEN-LAST:event_rb05_qst10ActionPerformed

    private void bt_CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_CancelarActionPerformed

        if (JOptionPane.showConfirmDialog(null, "Deseja Cancelar?", "Cancelar", 2) == 0) {
            LimparCampos();
            dispose();
        }

    }//GEN-LAST:event_bt_CancelarActionPerformed

    private void bt_Avancar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_Avancar1ActionPerformed

        if (!ta_Resposta1.getText().equals("")) {
            tb_Questoes.setEnabledAt(0, false);
            tb_Questoes.setEnabledAt(1, true);
            tb_Questoes.setSelectedIndex(1);
        } else {
            JOptionPane.showMessageDialog(null, "Resposta 01 não pode estar vazio!");
        }

    }//GEN-LAST:event_bt_Avancar1ActionPerformed

    private void bt_Voltar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_Voltar2ActionPerformed

        tb_Questoes.setEnabledAt(1, false);
        tb_Questoes.setEnabledAt(0, true);
        tb_Questoes.setSelectedIndex(0);

    }//GEN-LAST:event_bt_Voltar2ActionPerformed

    private void bt_Avancar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_Avancar2ActionPerformed

        if (!ta_Resposta2.getText().equals("")) {
            tb_Questoes.setEnabledAt(1, false);
            tb_Questoes.setEnabledAt(2, true);
            tb_Questoes.setSelectedIndex(2);
        } else {
            JOptionPane.showMessageDialog(null, "Resposta 02 não pode estar vazio!");
        }

    }//GEN-LAST:event_bt_Avancar2ActionPerformed

    private void bt_Voltar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_Voltar3ActionPerformed

        tb_Questoes.setEnabledAt(2, false);
        tb_Questoes.setEnabledAt(1, true);
        tb_Questoes.setSelectedIndex(1);

    }//GEN-LAST:event_bt_Voltar3ActionPerformed

    private void bt_Avancar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_Avancar3ActionPerformed

        if (!ta_Resposta3.getText().equals("")) {
            tb_Questoes.setEnabledAt(2, false);
            tb_Questoes.setEnabledAt(3, true);
            tb_Questoes.setSelectedIndex(3);
        } else {
            JOptionPane.showMessageDialog(null, "Resposta 03 não pode estar vazio!");
        }

    }//GEN-LAST:event_bt_Avancar3ActionPerformed

    private void bt_Voltar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_Voltar4ActionPerformed

        tb_Questoes.setEnabledAt(3, false);
        tb_Questoes.setEnabledAt(2, true);
        tb_Questoes.setSelectedIndex(2);

    }//GEN-LAST:event_bt_Voltar4ActionPerformed

    private void bt_Avancar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_Avancar4ActionPerformed

        if (!ta_Resposta4.getText().equals("")) {
            tb_Questoes.setEnabledAt(3, false);
            tb_Questoes.setEnabledAt(4, true);
            tb_Questoes.setSelectedIndex(4);
        } else {
            JOptionPane.showMessageDialog(null, "Resposta 04 não pode estar vazio!");
        }

    }//GEN-LAST:event_bt_Avancar4ActionPerformed

    private void bt_Voltar5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_Voltar5ActionPerformed

        tb_Questoes.setEnabledAt(4, false);
        tb_Questoes.setEnabledAt(3, true);
        tb_Questoes.setSelectedIndex(3);

    }//GEN-LAST:event_bt_Voltar5ActionPerformed

    private void bt_Avancar5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_Avancar5ActionPerformed

        if (!ta_Resposta5.getText().equals("")) {
            tb_Questoes.setEnabledAt(4, false);
            tb_Questoes.setEnabledAt(5, true);
            tb_Questoes.setSelectedIndex(5);
        } else {
            JOptionPane.showMessageDialog(null, "Resposta 05 não pode estar vazio!");
        }

    }//GEN-LAST:event_bt_Avancar5ActionPerformed

    private void bt_Voltar6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_Voltar6ActionPerformed

        tb_Questoes.setEnabledAt(5, false);
        tb_Questoes.setEnabledAt(4, true);
        tb_Questoes.setSelectedIndex(4);

    }//GEN-LAST:event_bt_Voltar6ActionPerformed

    private void bt_Avancar6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_Avancar6ActionPerformed

        if (!ta_Resposta6.getText().equals("")) {
            tb_Questoes.setEnabledAt(5, false);
            tb_Questoes.setEnabledAt(6, true);
            tb_Questoes.setSelectedIndex(6);
        } else {
            JOptionPane.showMessageDialog(null, "Resposta 06 não pode estar vazio!");
        }

    }//GEN-LAST:event_bt_Avancar6ActionPerformed

    private void bt_Voltar7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_Voltar7ActionPerformed

        tb_Questoes.setEnabledAt(6, false);
        tb_Questoes.setEnabledAt(5, true);
        tb_Questoes.setSelectedIndex(5);

    }//GEN-LAST:event_bt_Voltar7ActionPerformed

    private void bt_Avancar7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_Avancar7ActionPerformed

        if (!ta_Resposta7.getText().equals("")) {
            tb_Questoes.setEnabledAt(6, false);
            tb_Questoes.setEnabledAt(7, true);
            tb_Questoes.setSelectedIndex(7);
        } else {
            JOptionPane.showMessageDialog(null, "Resposta 07 não pode estar vazio!");
        }

    }//GEN-LAST:event_bt_Avancar7ActionPerformed

    private void bt_Voltar8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_Voltar8ActionPerformed

        tb_Questoes.setEnabledAt(7, false);
        tb_Questoes.setEnabledAt(6, true);
        tb_Questoes.setSelectedIndex(6);

    }//GEN-LAST:event_bt_Voltar8ActionPerformed

    private void bt_Avancar8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_Avancar8ActionPerformed

        if (!ta_Resposta8.getText().equals("")) {
            tb_Questoes.setEnabledAt(7, false);
            tb_Questoes.setEnabledAt(8, true);
            tb_Questoes.setSelectedIndex(8);
        } else {
            JOptionPane.showMessageDialog(null, "Resposta 08 não pode estar vazio!");
        }

    }//GEN-LAST:event_bt_Avancar8ActionPerformed

    private void bt_Voltar9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_Voltar9ActionPerformed

        tb_Questoes.setEnabledAt(8, false);
        tb_Questoes.setEnabledAt(7, true);
        tb_Questoes.setSelectedIndex(7);

    }//GEN-LAST:event_bt_Voltar9ActionPerformed

    private void bt_Avancar9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_Avancar9ActionPerformed

        if (!ta_Resposta9.getText().equals("")) {
            tb_Questoes.setEnabledAt(8, false);
            tb_Questoes.setEnabledAt(9, true);
            tb_Questoes.setSelectedIndex(9);
        } else {
            JOptionPane.showMessageDialog(null, "Resposta 09 não pode estar vazio!");
        }

    }//GEN-LAST:event_bt_Avancar9ActionPerformed

    private void bt_Voltar10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_Voltar10ActionPerformed

        tb_Questoes.setEnabledAt(9, false);
        tb_Questoes.setEnabledAt(8, true);
        tb_Questoes.setSelectedIndex(8);

    }//GEN-LAST:event_bt_Voltar10ActionPerformed

    private void bt_SalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_SalvarActionPerformed

        if (!ta_Resposta10.getText().equals("")) {
            if (JOptionPane.showConfirmDialog(null, "Deseja Salvar suas Respostas?", "Salvar", 2) == 0) {

                //RESPOSTA 01
                r = listaRespostas.get(0);
                r.setCorpo_Resposta(ta_Resposta1.getText());
                r.setNota_Resposta("AGUARDANDO CORREÇÃO");
                rwdao.AtualizarResposta(r);

                //QUALIFICAÇÃO QUESTÃO 01
                q = listaQuestoes.get(0);
                q.setQualificacao_Questao(jl_qualificacao1.getText());
                qwdao.AtualizarQuestao(q);

                //RESPOSTA 02
                r = listaRespostas.get(1);
                r.setCorpo_Resposta(ta_Resposta2.getText());
                r.setNota_Resposta("AGUARDANDO CORREÇÃO");
                rwdao.AtualizarResposta(r);

                //QUALIFICAÇÃO QUESTÃO 02
                q = listaQuestoes.get(1);
                q.setQualificacao_Questao(jl_qualificacao2.getText());
                qwdao.AtualizarQuestao(q);

                //RESPOSTA 03
                r = listaRespostas.get(2);
                r.setCorpo_Resposta(ta_Resposta3.getText());
                r.setNota_Resposta("AGUARDANDO CORREÇÃO");
                rwdao.AtualizarResposta(r);

                //QUALIFICAÇÃO QUESTÃO 03
                q = listaQuestoes.get(2);
                q.setQualificacao_Questao(jl_qualificacao3.getText());
                qwdao.AtualizarQuestao(q);

                //RESPOSTA 04
                r = listaRespostas.get(3);
                r.setCorpo_Resposta(ta_Resposta4.getText());
                r.setNota_Resposta("AGUARDANDO CORREÇÃO");
                rwdao.AtualizarResposta(r);

                //QUALIFICAÇÃO QUESTÃO 04
                q = listaQuestoes.get(3);
                q.setQualificacao_Questao(jl_qualificacao4.getText());
                qwdao.AtualizarQuestao(q);

                //RESPOSTA 05
                r = listaRespostas.get(4);
                r.setCorpo_Resposta(ta_Resposta5.getText());
                r.setNota_Resposta("AGUARDANDO CORREÇÃO");
                rwdao.AtualizarResposta(r);

                //QUALIFICAÇÃO QUESTÃO 05
                q = listaQuestoes.get(4);
                q.setQualificacao_Questao(jl_qualificacao5.getText());
                qwdao.AtualizarQuestao(q);

                //RESPOSTA 06
                r = listaRespostas.get(5);
                r.setCorpo_Resposta(ta_Resposta6.getText());
                r.setNota_Resposta("AGUARDANDO CORREÇÃO");
                rwdao.AtualizarResposta(r);

                //QUALIFICAÇÃO QUESTÃO 06
                q = listaQuestoes.get(5);
                q.setQualificacao_Questao(jl_qualificacao6.getText());
                qwdao.AtualizarQuestao(q);

                //RESPOSTA 07
                r = listaRespostas.get(6);
                r.setCorpo_Resposta(ta_Resposta7.getText());
                r.setNota_Resposta("AGUARDANDO CORREÇÃO");
                rwdao.AtualizarResposta(r);

                //QUALIFICAÇÃO QUESTÃO 07
                q = listaQuestoes.get(6);
                q.setQualificacao_Questao(jl_qualificacao7.getText());
                qwdao.AtualizarQuestao(q);

                //RESPOSTA 08
                r = listaRespostas.get(7);
                r.setCorpo_Resposta(ta_Resposta8.getText());
                r.setNota_Resposta("AGUARDANDO CORREÇÃO");
                rwdao.AtualizarResposta(r);

                //QUALIFICAÇÃO QUESTÃO 08
                q = listaQuestoes.get(7);
                q.setQualificacao_Questao(jl_qualificacao8.getText());
                qwdao.AtualizarQuestao(q);

                //RESPOSTA 09
                r = listaRespostas.get(8);
                r.setCorpo_Resposta(ta_Resposta9.getText());
                r.setNota_Resposta("AGUARDANDO CORREÇÃO");
                rwdao.AtualizarResposta(r);

                //QUALIFICAÇÃO QUESTÃO 09
                q = listaQuestoes.get(8);
                q.setQualificacao_Questao(jl_qualificacao9.getText());
                qwdao.AtualizarQuestao(q);

                //RESPOSTA 10
                r = listaRespostas.get(9);
                r.setCorpo_Resposta(ta_Resposta10.getText());
                r.setNota_Resposta("AGUARDANDO CORREÇÃO");
                rwdao.AtualizarResposta(r);

                //QUALIFICAÇÃO QUESTÃO 10
                q = listaQuestoes.get(9);
                q.setQualificacao_Questao(jl_qualificacao10.getText());
                qwdao.AtualizarQuestao(q);

                JOptionPane.showMessageDialog(null, "Salvo com Sucesso!");
                LimparCampos();
                BuscarQuestoes();

            } else {
                JOptionPane.showMessageDialog(null, "Resposta 10 não pode estar vazio!");
            }

    }//GEN-LAST:event_bt_SalvarActionPerformed
    }

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Tela_ResponderQuestionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela_ResponderQuestionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela_ResponderQuestionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela_ResponderQuestionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Tela_ResponderQuestionario dialog = new Tela_ResponderQuestionario(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton bt_Avancar1;
    private javax.swing.JButton bt_Avancar2;
    private javax.swing.JButton bt_Avancar3;
    private javax.swing.JButton bt_Avancar4;
    private javax.swing.JButton bt_Avancar5;
    private javax.swing.JButton bt_Avancar6;
    private javax.swing.JButton bt_Avancar7;
    private javax.swing.JButton bt_Avancar8;
    private javax.swing.JButton bt_Avancar9;
    private javax.swing.JButton bt_Cancelar;
    private javax.swing.JButton bt_Salvar;
    private javax.swing.JButton bt_Voltar10;
    private javax.swing.JButton bt_Voltar2;
    private javax.swing.JButton bt_Voltar3;
    private javax.swing.JButton bt_Voltar4;
    private javax.swing.JButton bt_Voltar5;
    private javax.swing.JButton bt_Voltar6;
    private javax.swing.JButton bt_Voltar7;
    private javax.swing.JButton bt_Voltar8;
    private javax.swing.JButton bt_Voltar9;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane32;
    private javax.swing.JScrollPane jScrollPane33;
    private javax.swing.JScrollPane jScrollPane34;
    private javax.swing.JScrollPane jScrollPane35;
    private javax.swing.JScrollPane jScrollPane36;
    private javax.swing.JScrollPane jScrollPane37;
    private javax.swing.JScrollPane jScrollPane38;
    private javax.swing.JScrollPane jScrollPane39;
    private javax.swing.JScrollPane jScrollPane40;
    private javax.swing.JScrollPane jScrollPane41;
    private javax.swing.JScrollPane jScrollPane42;
    private javax.swing.JScrollPane jScrollPane43;
    private javax.swing.JScrollPane jScrollPane44;
    private javax.swing.JScrollPane jScrollPane45;
    private javax.swing.JScrollPane jScrollPane46;
    private javax.swing.JScrollPane jScrollPane47;
    private javax.swing.JScrollPane jScrollPane48;
    private javax.swing.JScrollPane jScrollPane49;
    private javax.swing.JScrollPane jScrollPane50;
    private javax.swing.JScrollPane jScrollPane51;
    private javax.swing.JLabel jl_Questao1;
    private javax.swing.JLabel jl_Questao10;
    private javax.swing.JLabel jl_Questao2;
    private javax.swing.JLabel jl_Questao3;
    private javax.swing.JLabel jl_Questao4;
    private javax.swing.JLabel jl_Questao5;
    private javax.swing.JLabel jl_Questao6;
    private javax.swing.JLabel jl_Questao7;
    private javax.swing.JLabel jl_Questao8;
    private javax.swing.JLabel jl_Questao9;
    private javax.swing.JLabel jl_Resposta1;
    private javax.swing.JLabel jl_Resposta10;
    private javax.swing.JLabel jl_Resposta2;
    private javax.swing.JLabel jl_Resposta3;
    private javax.swing.JLabel jl_Resposta4;
    private javax.swing.JLabel jl_Resposta5;
    private javax.swing.JLabel jl_Resposta6;
    private javax.swing.JLabel jl_Resposta7;
    private javax.swing.JLabel jl_Resposta8;
    private javax.swing.JLabel jl_Resposta9;
    private javax.swing.JLabel jl_qualificacao1;
    private javax.swing.JLabel jl_qualificacao10;
    private javax.swing.JLabel jl_qualificacao2;
    private javax.swing.JLabel jl_qualificacao3;
    private javax.swing.JLabel jl_qualificacao4;
    private javax.swing.JLabel jl_qualificacao5;
    private javax.swing.JLabel jl_qualificacao6;
    private javax.swing.JLabel jl_qualificacao7;
    private javax.swing.JLabel jl_qualificacao8;
    private javax.swing.JLabel jl_qualificacao9;
    private javax.swing.JPanel painel_ql01;
    private javax.swing.JPanel painel_ql02;
    private javax.swing.JPanel painel_ql03;
    private javax.swing.JPanel painel_ql04;
    private javax.swing.JPanel painel_ql05;
    private javax.swing.JPanel painel_ql06;
    private javax.swing.JPanel painel_ql07;
    private javax.swing.JPanel painel_ql08;
    private javax.swing.JPanel painel_ql09;
    private javax.swing.JPanel painel_ql10;
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
    private javax.swing.JRadioButton rb01_qst1;
    private javax.swing.JRadioButton rb01_qst10;
    private javax.swing.JRadioButton rb01_qst2;
    private javax.swing.JRadioButton rb01_qst3;
    private javax.swing.JRadioButton rb01_qst4;
    private javax.swing.JRadioButton rb01_qst5;
    private javax.swing.JRadioButton rb01_qst6;
    private javax.swing.JRadioButton rb01_qst7;
    private javax.swing.JRadioButton rb01_qst8;
    private javax.swing.JRadioButton rb01_qst9;
    private javax.swing.JRadioButton rb02_qst1;
    private javax.swing.JRadioButton rb02_qst10;
    private javax.swing.JRadioButton rb02_qst2;
    private javax.swing.JRadioButton rb02_qst3;
    private javax.swing.JRadioButton rb02_qst4;
    private javax.swing.JRadioButton rb02_qst5;
    private javax.swing.JRadioButton rb02_qst6;
    private javax.swing.JRadioButton rb02_qst7;
    private javax.swing.JRadioButton rb02_qst8;
    private javax.swing.JRadioButton rb02_qst9;
    private javax.swing.JRadioButton rb03_qst1;
    private javax.swing.JRadioButton rb03_qst10;
    private javax.swing.JRadioButton rb03_qst2;
    private javax.swing.JRadioButton rb03_qst3;
    private javax.swing.JRadioButton rb03_qst4;
    private javax.swing.JRadioButton rb03_qst5;
    private javax.swing.JRadioButton rb03_qst6;
    private javax.swing.JRadioButton rb03_qst7;
    private javax.swing.JRadioButton rb03_qst8;
    private javax.swing.JRadioButton rb03_qst9;
    private javax.swing.JRadioButton rb04_qst1;
    private javax.swing.JRadioButton rb04_qst10;
    private javax.swing.JRadioButton rb04_qst2;
    private javax.swing.JRadioButton rb04_qst3;
    private javax.swing.JRadioButton rb04_qst4;
    private javax.swing.JRadioButton rb04_qst5;
    private javax.swing.JRadioButton rb04_qst6;
    private javax.swing.JRadioButton rb04_qst7;
    private javax.swing.JRadioButton rb04_qst8;
    private javax.swing.JRadioButton rb04_qst9;
    private javax.swing.JRadioButton rb05_qst1;
    private javax.swing.JRadioButton rb05_qst10;
    private javax.swing.JRadioButton rb05_qst2;
    private javax.swing.JRadioButton rb05_qst3;
    private javax.swing.JRadioButton rb05_qst4;
    private javax.swing.JRadioButton rb05_qst5;
    private javax.swing.JRadioButton rb05_qst6;
    private javax.swing.JRadioButton rb05_qst7;
    private javax.swing.JRadioButton rb05_qst8;
    private javax.swing.JRadioButton rb05_qst9;
    private javax.swing.JTextArea ta_Questao1;
    private javax.swing.JTextArea ta_Questao10;
    private javax.swing.JTextArea ta_Questao2;
    private javax.swing.JTextArea ta_Questao3;
    private javax.swing.JTextArea ta_Questao4;
    private javax.swing.JTextArea ta_Questao5;
    private javax.swing.JTextArea ta_Questao6;
    private javax.swing.JTextArea ta_Questao7;
    private javax.swing.JTextArea ta_Questao8;
    private javax.swing.JTextArea ta_Questao9;
    private javax.swing.JTextArea ta_Resposta1;
    private javax.swing.JTextArea ta_Resposta10;
    private javax.swing.JTextArea ta_Resposta2;
    private javax.swing.JTextArea ta_Resposta3;
    private javax.swing.JTextArea ta_Resposta4;
    private javax.swing.JTextArea ta_Resposta5;
    private javax.swing.JTextArea ta_Resposta6;
    private javax.swing.JTextArea ta_Resposta7;
    private javax.swing.JTextArea ta_Resposta8;
    private javax.swing.JTextArea ta_Resposta9;
    private javax.swing.JTabbedPane tb_Questoes;
    // End of variables declaration//GEN-END:variables
}
