package Telas;

import Classes.Equipe;
import Classes.Questao;
import Classes.Questao_Desafio;
import Classes.Resposta;
import Classes.Resposta_Questao_Desafio;
import Classes.Rodada;
import Classes.Usuario_Token;
import Servicos.ContagemPontos;
import Servicos.Utilitarios;
import WebService.EquipeWebDAO;
import WebService.QuestaoWebDAO;
import WebService.Questao_DesafioWebDAO;
import WebService.RespostaWebDAO;
import WebService.Resposta_Questao_DesafioWebDAO;
import WebService.RodadaWebDAO;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Tela_CorrigirRespostas extends javax.swing.JDialog {

    Usuario_Token ut = Usuario_Token.getInstance();
    Utilitarios u = new Utilitarios();
    Equipe e = new Equipe();
    Equipe er = new Equipe();
    EquipeWebDAO ewdao = new EquipeWebDAO();
    Questao_Desafio qd = new Questao_Desafio();
    Questao_DesafioWebDAO qdwdao = new Questao_DesafioWebDAO();
    Resposta_Questao_Desafio rqd = new Resposta_Questao_Desafio();
    Resposta_Questao_DesafioWebDAO rqdwdao = new Resposta_Questao_DesafioWebDAO();
    Rodada ro = new Rodada();
    RodadaWebDAO rowdao = new RodadaWebDAO();
    Questao q = new Questao();
    QuestaoWebDAO qwdao = new QuestaoWebDAO();
    Resposta r = new Resposta();
    RespostaWebDAO rwdao = new RespostaWebDAO();
    ArrayList<Questao> listaQuestoes = new ArrayList<>();
    ArrayList<Resposta> listaRespostas = new ArrayList<>();

    public Tela_CorrigirRespostas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        BuscarQuestoes();
        tb_Questoes.setEnabled(false);
        BloquearAreasTexto();
    }

    public void BuscarQuestoes() {

        tb_Questoes.setEnabledAt(1, false);
        tb_Questoes.setEnabledAt(0, true);
        tb_Questoes.setSelectedIndex(0);

        //BUSCAR EQUIPE
        ewdao.BuscarEquipe(e, ut.getEquipe_idEquipe());
        ewdao.BuscarEquipe(er, e.getEquipe_Que_Resposta());
        
        //VERIFICAR STATUS DA EQUIPE
        if(e.getIsQuestionario() == 0){
            JOptionPane.showMessageDialog(null, "Equipe não fez questionario!");
            bt_Avancar1.setEnabled(false);
            u.bloqueiapainel(jp_correcao1);
        } else if(er.getIsResposta() ==  0 ){
            JOptionPane.showMessageDialog(null, "Equipe não respondeu o questionario!");
            bt_Avancar1.setEnabled(false);
            u.bloqueiapainel(jp_correcao1);
        } else {

        //QUESTAO 01
        qwdao.BuscarQuestao(e.getIdQuestao_Equipe01(), q);
        
        ta_Questao1.setText(q.getCorpo_Questao());
        ta_Gabarito1.setText(q.getGabarito());
        listaQuestoes.add(q);
        q = new Questao();
        rwdao.BuscarResposta(er.getIdResposta_Equipe01(), r);
        ta_Resposta1.setText(r.getCorpo_Resposta());
        jc_correcao1.setSelectedIndex(IndexCorecaoResposta(r.getNota_Resposta()));
        listaRespostas.add(r);
        r = new Resposta();

        //QUESTAO 02
        qwdao.BuscarQuestao(e.getIdQuestao_Equipe02(), q);
        ta_Questao2.setText(q.getCorpo_Questao());
        ta_Gabarito2.setText(q.getGabarito());
        listaQuestoes.add(q);
        q = new Questao();
        rwdao.BuscarResposta(er.getIdResposta_Equipe02(), r);
        ta_Resposta2.setText(r.getCorpo_Resposta());
        jc_correcao2.setSelectedIndex(IndexCorecaoResposta(r.getNota_Resposta()));
        listaRespostas.add(r);
        r = new Resposta();

        //QUESTAO 03
        qwdao.BuscarQuestao(e.getIdQuestao_Equipe03(), q);
        ta_Questao3.setText(q.getCorpo_Questao());
        ta_Gabarito3.setText(q.getGabarito());
        listaQuestoes.add(q);
        q = new Questao();
        rwdao.BuscarResposta(er.getIdResposta_Equipe03(), r);
        ta_Resposta3.setText(r.getCorpo_Resposta());
        jc_correcao3.setSelectedIndex(IndexCorecaoResposta(r.getNota_Resposta()));
        listaRespostas.add(r);
        r = new Resposta();

        //QUESTAO 04
        qwdao.BuscarQuestao(e.getIdQuestao_Equipe04(), q);
        ta_Questao4.setText(q.getCorpo_Questao());
        ta_Gabarito4.setText(q.getGabarito());
        listaQuestoes.add(q);
        q = new Questao();
        rwdao.BuscarResposta(er.getIdResposta_Equipe04(), r);
        ta_Resposta4.setText(r.getCorpo_Resposta());
        jc_correcao4.setSelectedIndex(IndexCorecaoResposta(r.getNota_Resposta()));
        listaRespostas.add(r);
        r = new Resposta();

        //QUESTAO 05
        qwdao.BuscarQuestao(e.getIdQuestao_Equipe05(), q);
        ta_Questao5.setText(q.getCorpo_Questao());
        ta_Gabarito5.setText(q.getGabarito());
        listaQuestoes.add(q);
        q = new Questao();
        rwdao.BuscarResposta(er.getIdResposta_Equipe05(), r);
        ta_Resposta5.setText(r.getCorpo_Resposta());
        jc_correcao5.setSelectedIndex(IndexCorecaoResposta(r.getNota_Resposta()));
        listaRespostas.add(r);
        r = new Resposta();

        //QUESTAO 06
        qwdao.BuscarQuestao(e.getIdQuestao_Equipe06(), q);
        ta_Questao6.setText(q.getCorpo_Questao());
        ta_Gabarito6.setText(q.getGabarito());
        listaQuestoes.add(q);
        q = new Questao();
        rwdao.BuscarResposta(er.getIdResposta_Equipe06(), r);
        ta_Resposta6.setText(r.getCorpo_Resposta());
        jc_correcao6.setSelectedIndex(IndexCorecaoResposta(r.getNota_Resposta()));
        listaRespostas.add(r);
        r = new Resposta();

        //QUESTAO 07
        qwdao.BuscarQuestao(e.getIdQuestao_Equipe07(), q);
        ta_Questao7.setText(q.getCorpo_Questao());
        ta_Gabarito7.setText(q.getGabarito());
        listaQuestoes.add(q);
        q = new Questao();
        rwdao.BuscarResposta(er.getIdResposta_Equipe07(), r);
        ta_Resposta7.setText(r.getCorpo_Resposta());
        jc_correcao7.setSelectedIndex(IndexCorecaoResposta(r.getNota_Resposta()));
        listaRespostas.add(r);
        r = new Resposta();

        //QUESTAO 08
        qwdao.BuscarQuestao(e.getIdQuestao_Equipe08(), q);
        ta_Questao8.setText(q.getCorpo_Questao());
        ta_Gabarito8.setText(q.getGabarito());
        listaQuestoes.add(q);
        q = new Questao();
        rwdao.BuscarResposta(er.getIdResposta_Equipe08(), r);
        ta_Resposta8.setText(r.getCorpo_Resposta());
        jc_correcao8.setSelectedIndex(IndexCorecaoResposta(r.getNota_Resposta()));
        listaRespostas.add(r);
        r = new Resposta();

        //QUESTAO 09
        qwdao.BuscarQuestao(e.getIdQuestao_Equipe09(), q);
        ta_Questao9.setText(q.getCorpo_Questao());
        ta_Gabarito9.setText(q.getGabarito());
        listaQuestoes.add(q);
        q = new Questao();
        rwdao.BuscarResposta(er.getIdResposta_Equipe09(), r);
        ta_Resposta9.setText(r.getCorpo_Resposta());
        jc_correcao9.setSelectedIndex(IndexCorecaoResposta(r.getNota_Resposta()));
        listaRespostas.add(r);
        r = new Resposta();

        //QUESTAO 10
        qwdao.BuscarQuestao(e.getIdQuestao_Equipe10(), q);
        ta_Questao10.setText(q.getCorpo_Questao());
        ta_Gabarito10.setText(q.getGabarito());
        listaQuestoes.add(q);
        q = new Questao();
        rwdao.BuscarResposta(er.getIdResposta_Equipe10(), r);
        ta_Resposta10.setText(r.getCorpo_Resposta());
        jc_correcao10.setSelectedIndex(IndexCorecaoResposta(r.getNota_Resposta()));
        listaRespostas.add(r);
        r = new Resposta();
        }
    }

    public void BloquearAreasTexto() {

        ta_Gabarito1.setEditable(false);
        ta_Questao2.setEditable(false);
        ta_Questao3.setEditable(false);
        ta_Questao4.setEditable(false);
        ta_Questao5.setEditable(false);
        ta_Questao6.setEditable(false);
        ta_Questao7.setEditable(false);
        ta_Questao8.setEditable(false);
        ta_Questao9.setEditable(false);
        ta_Questao10.setEditable(false);
        ta_Resposta1.setEditable(false);
        ta_Resposta2.setEditable(false);
        ta_Resposta3.setEditable(false);
        ta_Resposta4.setEditable(false);
        ta_Resposta5.setEditable(false);
        ta_Resposta6.setEditable(false);
        ta_Resposta7.setEditable(false);
        ta_Resposta8.setEditable(false);
        ta_Resposta9.setEditable(false);
        ta_Resposta10.setEditable(false);

    }

    public int IndexCorecaoResposta(String corecao) {
        int retorno = 0;

        switch (corecao) {
            case "Sem Resposta":
                retorno = 0;
                break;
            case "Resposta Errada":
                retorno = 1;
                break;
            case "Resposta Incompleta":
                retorno = 2;
                break;
            case "Resposta Correta":
                retorno = 3;
                break;
            default:
                retorno = 0;
                break;
        }

        return retorno;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tb_Questoes = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        painel_qst01 = new javax.swing.JPanel();
        bt_Voltar1 = new javax.swing.JButton();
        jl_Questao1 = new javax.swing.JLabel();
        jScrollPane32 = new javax.swing.JScrollPane();
        ta_Gabarito1 = new javax.swing.JTextArea();
        jl_Resposta1 = new javax.swing.JLabel();
        jScrollPane33 = new javax.swing.JScrollPane();
        ta_Resposta1 = new javax.swing.JTextArea();
        bt_Avancar1 = new javax.swing.JButton();
        jp_correcao1 = new javax.swing.JPanel();
        jc_correcao1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jl_pt1 = new javax.swing.JLabel();
        jl_Questao11 = new javax.swing.JLabel();
        jScrollPane52 = new javax.swing.JScrollPane();
        ta_Questao1 = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        painel_qst2 = new javax.swing.JPanel();
        bt_Voltar2 = new javax.swing.JButton();
        jl_Questao2 = new javax.swing.JLabel();
        jScrollPane34 = new javax.swing.JScrollPane();
        ta_Gabarito2 = new javax.swing.JTextArea();
        jl_Resposta2 = new javax.swing.JLabel();
        jScrollPane35 = new javax.swing.JScrollPane();
        ta_Resposta2 = new javax.swing.JTextArea();
        bt_Avancar2 = new javax.swing.JButton();
        jp_correcao2 = new javax.swing.JPanel();
        jc_correcao2 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jl_pt2 = new javax.swing.JLabel();
        jl_Questao12 = new javax.swing.JLabel();
        jScrollPane53 = new javax.swing.JScrollPane();
        ta_Questao2 = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        painel_qst3 = new javax.swing.JPanel();
        bt_Voltar3 = new javax.swing.JButton();
        jl_Questao3 = new javax.swing.JLabel();
        jScrollPane36 = new javax.swing.JScrollPane();
        ta_Gabarito3 = new javax.swing.JTextArea();
        jl_Resposta3 = new javax.swing.JLabel();
        jScrollPane37 = new javax.swing.JScrollPane();
        ta_Resposta3 = new javax.swing.JTextArea();
        bt_Avancar3 = new javax.swing.JButton();
        jp_correcao3 = new javax.swing.JPanel();
        jc_correcao3 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jl_pt3 = new javax.swing.JLabel();
        jl_Questao13 = new javax.swing.JLabel();
        jScrollPane54 = new javax.swing.JScrollPane();
        ta_Questao3 = new javax.swing.JTextArea();
        jPanel5 = new javax.swing.JPanel();
        painel_qst4 = new javax.swing.JPanel();
        bt_Voltar4 = new javax.swing.JButton();
        jl_Questao4 = new javax.swing.JLabel();
        jScrollPane38 = new javax.swing.JScrollPane();
        ta_Gabarito4 = new javax.swing.JTextArea();
        jl_Resposta4 = new javax.swing.JLabel();
        jScrollPane39 = new javax.swing.JScrollPane();
        ta_Resposta4 = new javax.swing.JTextArea();
        bt_Avancar4 = new javax.swing.JButton();
        jp_correcao4 = new javax.swing.JPanel();
        jc_correcao4 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jl_pt4 = new javax.swing.JLabel();
        jl_Questao14 = new javax.swing.JLabel();
        jScrollPane55 = new javax.swing.JScrollPane();
        ta_Questao4 = new javax.swing.JTextArea();
        jPanel6 = new javax.swing.JPanel();
        painel_qst5 = new javax.swing.JPanel();
        bt_Voltar5 = new javax.swing.JButton();
        jl_Questao5 = new javax.swing.JLabel();
        jScrollPane40 = new javax.swing.JScrollPane();
        ta_Gabarito5 = new javax.swing.JTextArea();
        jl_Resposta5 = new javax.swing.JLabel();
        jScrollPane41 = new javax.swing.JScrollPane();
        ta_Resposta5 = new javax.swing.JTextArea();
        bt_Avancar5 = new javax.swing.JButton();
        jp_correcao5 = new javax.swing.JPanel();
        jc_correcao5 = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jl_pt5 = new javax.swing.JLabel();
        jl_Questao15 = new javax.swing.JLabel();
        jScrollPane56 = new javax.swing.JScrollPane();
        ta_Questao5 = new javax.swing.JTextArea();
        jPanel7 = new javax.swing.JPanel();
        painel_qst6 = new javax.swing.JPanel();
        bt_Voltar6 = new javax.swing.JButton();
        jl_Questao6 = new javax.swing.JLabel();
        jScrollPane42 = new javax.swing.JScrollPane();
        ta_Gabarito6 = new javax.swing.JTextArea();
        jl_Resposta6 = new javax.swing.JLabel();
        jScrollPane43 = new javax.swing.JScrollPane();
        ta_Resposta6 = new javax.swing.JTextArea();
        bt_Avancar6 = new javax.swing.JButton();
        jp_correcao6 = new javax.swing.JPanel();
        jc_correcao6 = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jl_pt6 = new javax.swing.JLabel();
        jl_Questao16 = new javax.swing.JLabel();
        jScrollPane57 = new javax.swing.JScrollPane();
        ta_Questao6 = new javax.swing.JTextArea();
        jPanel8 = new javax.swing.JPanel();
        painel_qst7 = new javax.swing.JPanel();
        bt_Voltar7 = new javax.swing.JButton();
        jl_Questao7 = new javax.swing.JLabel();
        jScrollPane44 = new javax.swing.JScrollPane();
        ta_Gabarito7 = new javax.swing.JTextArea();
        jl_Resposta7 = new javax.swing.JLabel();
        jScrollPane45 = new javax.swing.JScrollPane();
        ta_Resposta7 = new javax.swing.JTextArea();
        bt_Avancar7 = new javax.swing.JButton();
        jp_correcao7 = new javax.swing.JPanel();
        jc_correcao7 = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jl_pt7 = new javax.swing.JLabel();
        jl_Questao17 = new javax.swing.JLabel();
        jScrollPane58 = new javax.swing.JScrollPane();
        ta_Questao7 = new javax.swing.JTextArea();
        jPanel9 = new javax.swing.JPanel();
        painel_qst8 = new javax.swing.JPanel();
        bt_Voltar8 = new javax.swing.JButton();
        jl_Questao8 = new javax.swing.JLabel();
        jScrollPane46 = new javax.swing.JScrollPane();
        ta_Gabarito8 = new javax.swing.JTextArea();
        jl_Resposta8 = new javax.swing.JLabel();
        jScrollPane47 = new javax.swing.JScrollPane();
        ta_Resposta8 = new javax.swing.JTextArea();
        bt_Avancar8 = new javax.swing.JButton();
        jp_correcao8 = new javax.swing.JPanel();
        jc_correcao8 = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jl_pt8 = new javax.swing.JLabel();
        jl_Questao18 = new javax.swing.JLabel();
        jScrollPane59 = new javax.swing.JScrollPane();
        ta_Questao8 = new javax.swing.JTextArea();
        jPanel10 = new javax.swing.JPanel();
        painel_qst9 = new javax.swing.JPanel();
        bt_Voltar9 = new javax.swing.JButton();
        jl_Questao9 = new javax.swing.JLabel();
        jScrollPane48 = new javax.swing.JScrollPane();
        ta_Gabarito9 = new javax.swing.JTextArea();
        jl_Resposta9 = new javax.swing.JLabel();
        jScrollPane49 = new javax.swing.JScrollPane();
        ta_Resposta9 = new javax.swing.JTextArea();
        bt_Avancar9 = new javax.swing.JButton();
        jp_correcao9 = new javax.swing.JPanel();
        jc_correcao9 = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jl_pt9 = new javax.swing.JLabel();
        jl_Questao19 = new javax.swing.JLabel();
        jScrollPane60 = new javax.swing.JScrollPane();
        ta_Questao9 = new javax.swing.JTextArea();
        jPanel11 = new javax.swing.JPanel();
        painel_qst10 = new javax.swing.JPanel();
        bt_Voltar10 = new javax.swing.JButton();
        jl_Questao10 = new javax.swing.JLabel();
        jScrollPane50 = new javax.swing.JScrollPane();
        ta_Gabarito10 = new javax.swing.JTextArea();
        jl_Resposta10 = new javax.swing.JLabel();
        jScrollPane51 = new javax.swing.JScrollPane();
        ta_Resposta10 = new javax.swing.JTextArea();
        bt_Avancar10 = new javax.swing.JButton();
        jp_correcao10 = new javax.swing.JPanel();
        jc_correcao10 = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jl_pt10 = new javax.swing.JLabel();
        jl_Questao20 = new javax.swing.JLabel();
        jScrollPane61 = new javax.swing.JScrollPane();
        ta_Questao10 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        tb_Questoes.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        tb_Questoes.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);

        bt_Voltar1.setText("CANCELAR");
        bt_Voltar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_Voltar1ActionPerformed(evt);
            }
        });

        jl_Questao1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jl_Questao1.setText("Gabarito 01:");

        ta_Gabarito1.setBackground(new java.awt.Color(204, 204, 204));
        ta_Gabarito1.setColumns(20);
        ta_Gabarito1.setLineWrap(true);
        ta_Gabarito1.setRows(5);
        ta_Gabarito1.setWrapStyleWord(true);
        ta_Gabarito1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        ta_Gabarito1.setFocusable(false);
        jScrollPane32.setViewportView(ta_Gabarito1);

        jl_Resposta1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jl_Resposta1.setText("Resposta 01:");

        ta_Resposta1.setBackground(new java.awt.Color(204, 204, 204));
        ta_Resposta1.setColumns(20);
        ta_Resposta1.setLineWrap(true);
        ta_Resposta1.setRows(5);
        ta_Resposta1.setWrapStyleWord(true);
        ta_Resposta1.setFocusable(false);
        jScrollPane33.setViewportView(ta_Resposta1);

        bt_Avancar1.setText("AVANÇAR");
        bt_Avancar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_Avancar1ActionPerformed(evt);
            }
        });

        jp_correcao1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jc_correcao1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sem Resposta", "Resposta Errada", "Resposta Incompleta", "Resposta Correta" }));
        jc_correcao1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jc_correcao1ItemStateChanged(evt);
            }
        });

        jLabel1.setText("Pontuação:");

        jl_pt1.setText("-5 Pontos");

        javax.swing.GroupLayout jp_correcao1Layout = new javax.swing.GroupLayout(jp_correcao1);
        jp_correcao1.setLayout(jp_correcao1Layout);
        jp_correcao1Layout.setHorizontalGroup(
            jp_correcao1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_correcao1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jc_correcao1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jl_pt1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jp_correcao1Layout.setVerticalGroup(
            jp_correcao1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_correcao1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jp_correcao1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jc_correcao1)
                    .addComponent(jl_pt1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jl_Questao11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jl_Questao11.setText("Questão 01:");

        ta_Questao1.setBackground(new java.awt.Color(204, 204, 204));
        ta_Questao1.setColumns(20);
        ta_Questao1.setLineWrap(true);
        ta_Questao1.setRows(5);
        ta_Questao1.setWrapStyleWord(true);
        ta_Questao1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        ta_Questao1.setFocusable(false);
        jScrollPane52.setViewportView(ta_Questao1);

        javax.swing.GroupLayout painel_qst01Layout = new javax.swing.GroupLayout(painel_qst01);
        painel_qst01.setLayout(painel_qst01Layout);
        painel_qst01Layout.setHorizontalGroup(
            painel_qst01Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_qst01Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_qst01Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane52, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane32)
                    .addComponent(jScrollPane33)
                    .addGroup(painel_qst01Layout.createSequentialGroup()
                        .addGroup(painel_qst01Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jl_Questao11)
                            .addComponent(jl_Resposta1)
                            .addComponent(jl_Questao1))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(painel_qst01Layout.createSequentialGroup()
                        .addComponent(jp_correcao1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bt_Voltar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bt_Avancar1)))
                .addContainerGap())
        );
        painel_qst01Layout.setVerticalGroup(
            painel_qst01Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel_qst01Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jl_Questao11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane52, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jl_Questao1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane32, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jl_Resposta1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane33, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painel_qst01Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jp_correcao1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel_qst01Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(painel_qst01Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bt_Voltar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bt_Avancar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 616, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addContainerGap(17, Short.MAX_VALUE)
                    .addComponent(painel_qst01, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(17, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 635, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(painel_qst01, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        tb_Questoes.addTab("QST 01", jPanel2);

        bt_Voltar2.setText("CANCELAR");
        bt_Voltar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_Voltar2ActionPerformed(evt);
            }
        });

        jl_Questao2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jl_Questao2.setText("Gabarito 02:");

        ta_Gabarito2.setBackground(new java.awt.Color(204, 204, 204));
        ta_Gabarito2.setColumns(20);
        ta_Gabarito2.setLineWrap(true);
        ta_Gabarito2.setRows(5);
        ta_Gabarito2.setWrapStyleWord(true);
        ta_Gabarito2.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        ta_Gabarito2.setFocusable(false);
        jScrollPane34.setViewportView(ta_Gabarito2);

        jl_Resposta2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jl_Resposta2.setText("Resposta 02:");

        ta_Resposta2.setBackground(new java.awt.Color(204, 204, 204));
        ta_Resposta2.setColumns(20);
        ta_Resposta2.setLineWrap(true);
        ta_Resposta2.setRows(5);
        ta_Resposta2.setWrapStyleWord(true);
        ta_Resposta2.setFocusable(false);
        jScrollPane35.setViewportView(ta_Resposta2);

        bt_Avancar2.setText("AVANÇAR");
        bt_Avancar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_Avancar2ActionPerformed(evt);
            }
        });

        jp_correcao2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jc_correcao2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sem Resposta", "Resposta Errada", "Resposta Incompleta", "Resposta Correta" }));
        jc_correcao2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jc_correcao2ItemStateChanged(evt);
            }
        });

        jLabel2.setText("Pontuação:");

        jl_pt2.setText("-5 Pontos");

        javax.swing.GroupLayout jp_correcao2Layout = new javax.swing.GroupLayout(jp_correcao2);
        jp_correcao2.setLayout(jp_correcao2Layout);
        jp_correcao2Layout.setHorizontalGroup(
            jp_correcao2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_correcao2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jc_correcao2, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jl_pt2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jp_correcao2Layout.setVerticalGroup(
            jp_correcao2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_correcao2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jp_correcao2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jc_correcao2)
                    .addComponent(jl_pt2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jl_Questao12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jl_Questao12.setText("Questão 02:");

        ta_Questao2.setBackground(new java.awt.Color(204, 204, 204));
        ta_Questao2.setColumns(20);
        ta_Questao2.setLineWrap(true);
        ta_Questao2.setRows(5);
        ta_Questao2.setWrapStyleWord(true);
        ta_Questao2.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        ta_Questao2.setFocusable(false);
        jScrollPane53.setViewportView(ta_Questao2);

        javax.swing.GroupLayout painel_qst2Layout = new javax.swing.GroupLayout(painel_qst2);
        painel_qst2.setLayout(painel_qst2Layout);
        painel_qst2Layout.setHorizontalGroup(
            painel_qst2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_qst2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_qst2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane53, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane34)
                    .addComponent(jScrollPane35)
                    .addGroup(painel_qst2Layout.createSequentialGroup()
                        .addGroup(painel_qst2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jl_Questao12)
                            .addComponent(jl_Resposta2)
                            .addComponent(jl_Questao2))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(painel_qst2Layout.createSequentialGroup()
                        .addComponent(jp_correcao2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bt_Voltar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bt_Avancar2)))
                .addContainerGap())
        );
        painel_qst2Layout.setVerticalGroup(
            painel_qst2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel_qst2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jl_Questao12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane53, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jl_Questao2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane34, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jl_Resposta2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane35, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painel_qst2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jp_correcao2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel_qst2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(painel_qst2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bt_Voltar2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bt_Avancar2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 616, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                    .addContainerGap(17, Short.MAX_VALUE)
                    .addComponent(painel_qst2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(17, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 635, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(painel_qst2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        tb_Questoes.addTab("QST 02", jPanel3);

        bt_Voltar3.setText("CANCELAR");
        bt_Voltar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_Voltar3ActionPerformed(evt);
            }
        });

        jl_Questao3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jl_Questao3.setText("Gabarito 03:");

        ta_Gabarito3.setBackground(new java.awt.Color(204, 204, 204));
        ta_Gabarito3.setColumns(20);
        ta_Gabarito3.setLineWrap(true);
        ta_Gabarito3.setRows(5);
        ta_Gabarito3.setWrapStyleWord(true);
        ta_Gabarito3.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        ta_Gabarito3.setFocusable(false);
        jScrollPane36.setViewportView(ta_Gabarito3);

        jl_Resposta3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jl_Resposta3.setText("Resposta 03:");

        ta_Resposta3.setBackground(new java.awt.Color(204, 204, 204));
        ta_Resposta3.setColumns(20);
        ta_Resposta3.setLineWrap(true);
        ta_Resposta3.setRows(5);
        ta_Resposta3.setWrapStyleWord(true);
        ta_Resposta3.setFocusable(false);
        jScrollPane37.setViewportView(ta_Resposta3);

        bt_Avancar3.setText("AVANÇAR");
        bt_Avancar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_Avancar3ActionPerformed(evt);
            }
        });

        jp_correcao3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jc_correcao3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sem Resposta", "Resposta Errada", "Resposta Incompleta", "Resposta Correta" }));
        jc_correcao3.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jc_correcao3ItemStateChanged(evt);
            }
        });

        jLabel3.setText("Pontuação:");

        jl_pt3.setText("-5 Pontos");

        javax.swing.GroupLayout jp_correcao3Layout = new javax.swing.GroupLayout(jp_correcao3);
        jp_correcao3.setLayout(jp_correcao3Layout);
        jp_correcao3Layout.setHorizontalGroup(
            jp_correcao3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_correcao3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jc_correcao3, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jl_pt3, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jp_correcao3Layout.setVerticalGroup(
            jp_correcao3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_correcao3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jp_correcao3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jc_correcao3)
                    .addComponent(jl_pt3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jl_Questao13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jl_Questao13.setText("Questão 03:");

        ta_Questao3.setBackground(new java.awt.Color(204, 204, 204));
        ta_Questao3.setColumns(20);
        ta_Questao3.setLineWrap(true);
        ta_Questao3.setRows(5);
        ta_Questao3.setWrapStyleWord(true);
        ta_Questao3.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        ta_Questao3.setFocusable(false);
        jScrollPane54.setViewportView(ta_Questao3);

        javax.swing.GroupLayout painel_qst3Layout = new javax.swing.GroupLayout(painel_qst3);
        painel_qst3.setLayout(painel_qst3Layout);
        painel_qst3Layout.setHorizontalGroup(
            painel_qst3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_qst3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_qst3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane54, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane36)
                    .addComponent(jScrollPane37)
                    .addGroup(painel_qst3Layout.createSequentialGroup()
                        .addGroup(painel_qst3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jl_Questao13)
                            .addComponent(jl_Resposta3)
                            .addComponent(jl_Questao3))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(painel_qst3Layout.createSequentialGroup()
                        .addComponent(jp_correcao3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bt_Voltar3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bt_Avancar3)))
                .addContainerGap())
        );
        painel_qst3Layout.setVerticalGroup(
            painel_qst3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel_qst3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jl_Questao13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane54, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jl_Questao3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane36, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jl_Resposta3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane37, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painel_qst3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jp_correcao3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel_qst3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(painel_qst3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bt_Voltar3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bt_Avancar3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 616, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                    .addContainerGap(17, Short.MAX_VALUE)
                    .addComponent(painel_qst3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(17, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 635, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(painel_qst3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        tb_Questoes.addTab("QST 03", jPanel4);

        bt_Voltar4.setText("CANCELAR");
        bt_Voltar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_Voltar4ActionPerformed(evt);
            }
        });

        jl_Questao4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jl_Questao4.setText("Gabarito 04:");

        ta_Gabarito4.setBackground(new java.awt.Color(204, 204, 204));
        ta_Gabarito4.setColumns(20);
        ta_Gabarito4.setLineWrap(true);
        ta_Gabarito4.setRows(5);
        ta_Gabarito4.setWrapStyleWord(true);
        ta_Gabarito4.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        ta_Gabarito4.setFocusable(false);
        jScrollPane38.setViewportView(ta_Gabarito4);

        jl_Resposta4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jl_Resposta4.setText("Resposta 04:");

        ta_Resposta4.setBackground(new java.awt.Color(204, 204, 204));
        ta_Resposta4.setColumns(20);
        ta_Resposta4.setLineWrap(true);
        ta_Resposta4.setRows(5);
        ta_Resposta4.setWrapStyleWord(true);
        ta_Resposta4.setFocusable(false);
        jScrollPane39.setViewportView(ta_Resposta4);

        bt_Avancar4.setText("AVANÇAR");
        bt_Avancar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_Avancar4ActionPerformed(evt);
            }
        });

        jp_correcao4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jc_correcao4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sem Resposta", "Resposta Errada", "Resposta Incompleta", "Resposta Correta" }));
        jc_correcao4.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jc_correcao4ItemStateChanged(evt);
            }
        });

        jLabel4.setText("Pontuação:");

        jl_pt4.setText("-5 Pontos");

        javax.swing.GroupLayout jp_correcao4Layout = new javax.swing.GroupLayout(jp_correcao4);
        jp_correcao4.setLayout(jp_correcao4Layout);
        jp_correcao4Layout.setHorizontalGroup(
            jp_correcao4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_correcao4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jc_correcao4, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jl_pt4, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jp_correcao4Layout.setVerticalGroup(
            jp_correcao4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_correcao4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jp_correcao4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jc_correcao4)
                    .addComponent(jl_pt4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jl_Questao14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jl_Questao14.setText("Questão 04:");

        ta_Questao4.setBackground(new java.awt.Color(204, 204, 204));
        ta_Questao4.setColumns(20);
        ta_Questao4.setLineWrap(true);
        ta_Questao4.setRows(5);
        ta_Questao4.setWrapStyleWord(true);
        ta_Questao4.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        ta_Questao4.setFocusable(false);
        jScrollPane55.setViewportView(ta_Questao4);

        javax.swing.GroupLayout painel_qst4Layout = new javax.swing.GroupLayout(painel_qst4);
        painel_qst4.setLayout(painel_qst4Layout);
        painel_qst4Layout.setHorizontalGroup(
            painel_qst4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_qst4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_qst4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane55, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane38)
                    .addComponent(jScrollPane39)
                    .addGroup(painel_qst4Layout.createSequentialGroup()
                        .addGroup(painel_qst4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jl_Questao14)
                            .addComponent(jl_Resposta4)
                            .addComponent(jl_Questao4))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(painel_qst4Layout.createSequentialGroup()
                        .addComponent(jp_correcao4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bt_Voltar4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bt_Avancar4)))
                .addContainerGap())
        );
        painel_qst4Layout.setVerticalGroup(
            painel_qst4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel_qst4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jl_Questao14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane55, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jl_Questao4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane38, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jl_Resposta4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane39, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painel_qst4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jp_correcao4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel_qst4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(painel_qst4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bt_Voltar4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bt_Avancar4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 616, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                    .addContainerGap(17, Short.MAX_VALUE)
                    .addComponent(painel_qst4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(17, Short.MAX_VALUE)))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 635, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(painel_qst4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        tb_Questoes.addTab("QST 04", jPanel5);

        bt_Voltar5.setText("CANCELAR");
        bt_Voltar5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_Voltar5ActionPerformed(evt);
            }
        });

        jl_Questao5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jl_Questao5.setText("Gabarito 05:");

        ta_Gabarito5.setBackground(new java.awt.Color(204, 204, 204));
        ta_Gabarito5.setColumns(20);
        ta_Gabarito5.setLineWrap(true);
        ta_Gabarito5.setRows(5);
        ta_Gabarito5.setWrapStyleWord(true);
        ta_Gabarito5.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        ta_Gabarito5.setFocusable(false);
        jScrollPane40.setViewportView(ta_Gabarito5);

        jl_Resposta5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jl_Resposta5.setText("Resposta 05:");

        ta_Resposta5.setBackground(new java.awt.Color(204, 204, 204));
        ta_Resposta5.setColumns(20);
        ta_Resposta5.setLineWrap(true);
        ta_Resposta5.setRows(5);
        ta_Resposta5.setWrapStyleWord(true);
        ta_Resposta5.setFocusable(false);
        jScrollPane41.setViewportView(ta_Resposta5);

        bt_Avancar5.setText("AVANÇAR");
        bt_Avancar5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_Avancar5ActionPerformed(evt);
            }
        });

        jp_correcao5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jc_correcao5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sem Resposta", "Resposta Errada", "Resposta Incompleta", "Resposta Correta" }));
        jc_correcao5.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jc_correcao5ItemStateChanged(evt);
            }
        });

        jLabel5.setText("Pontuação:");

        jl_pt5.setText("-5 Pontos");

        javax.swing.GroupLayout jp_correcao5Layout = new javax.swing.GroupLayout(jp_correcao5);
        jp_correcao5.setLayout(jp_correcao5Layout);
        jp_correcao5Layout.setHorizontalGroup(
            jp_correcao5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_correcao5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jc_correcao5, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jl_pt5, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jp_correcao5Layout.setVerticalGroup(
            jp_correcao5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_correcao5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jp_correcao5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jc_correcao5)
                    .addComponent(jl_pt5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jl_Questao15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jl_Questao15.setText("Questão 05:");

        ta_Questao5.setBackground(new java.awt.Color(204, 204, 204));
        ta_Questao5.setColumns(20);
        ta_Questao5.setLineWrap(true);
        ta_Questao5.setRows(5);
        ta_Questao5.setWrapStyleWord(true);
        ta_Questao5.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        ta_Questao5.setFocusable(false);
        jScrollPane56.setViewportView(ta_Questao5);

        javax.swing.GroupLayout painel_qst5Layout = new javax.swing.GroupLayout(painel_qst5);
        painel_qst5.setLayout(painel_qst5Layout);
        painel_qst5Layout.setHorizontalGroup(
            painel_qst5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_qst5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_qst5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane56, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane40)
                    .addComponent(jScrollPane41)
                    .addGroup(painel_qst5Layout.createSequentialGroup()
                        .addGroup(painel_qst5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jl_Questao15)
                            .addComponent(jl_Resposta5)
                            .addComponent(jl_Questao5))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(painel_qst5Layout.createSequentialGroup()
                        .addComponent(jp_correcao5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bt_Voltar5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bt_Avancar5)))
                .addContainerGap())
        );
        painel_qst5Layout.setVerticalGroup(
            painel_qst5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel_qst5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jl_Questao15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane56, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jl_Questao5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane40, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jl_Resposta5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane41, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painel_qst5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jp_correcao5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel_qst5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(painel_qst5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bt_Voltar5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bt_Avancar5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 616, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                    .addContainerGap(17, Short.MAX_VALUE)
                    .addComponent(painel_qst5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(17, Short.MAX_VALUE)))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 635, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(painel_qst5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        tb_Questoes.addTab("QST 05", jPanel6);

        bt_Voltar6.setText("CANCELAR");
        bt_Voltar6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_Voltar6ActionPerformed(evt);
            }
        });

        jl_Questao6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jl_Questao6.setText("Gabarito 06:");

        ta_Gabarito6.setBackground(new java.awt.Color(204, 204, 204));
        ta_Gabarito6.setColumns(20);
        ta_Gabarito6.setLineWrap(true);
        ta_Gabarito6.setRows(5);
        ta_Gabarito6.setWrapStyleWord(true);
        ta_Gabarito6.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        ta_Gabarito6.setFocusable(false);
        jScrollPane42.setViewportView(ta_Gabarito6);

        jl_Resposta6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jl_Resposta6.setText("Resposta 06:");

        ta_Resposta6.setBackground(new java.awt.Color(204, 204, 204));
        ta_Resposta6.setColumns(20);
        ta_Resposta6.setLineWrap(true);
        ta_Resposta6.setRows(5);
        ta_Resposta6.setWrapStyleWord(true);
        ta_Resposta6.setFocusable(false);
        jScrollPane43.setViewportView(ta_Resposta6);

        bt_Avancar6.setText("AVANÇAR");
        bt_Avancar6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_Avancar6ActionPerformed(evt);
            }
        });

        jp_correcao6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jc_correcao6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sem Resposta", "Resposta Errada", "Resposta Incompleta", "Resposta Correta" }));
        jc_correcao6.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jc_correcao6ItemStateChanged(evt);
            }
        });

        jLabel6.setText("Pontuação:");

        jl_pt6.setText("-5 Pontos");

        javax.swing.GroupLayout jp_correcao6Layout = new javax.swing.GroupLayout(jp_correcao6);
        jp_correcao6.setLayout(jp_correcao6Layout);
        jp_correcao6Layout.setHorizontalGroup(
            jp_correcao6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_correcao6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jc_correcao6, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jl_pt6, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jp_correcao6Layout.setVerticalGroup(
            jp_correcao6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_correcao6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jp_correcao6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jc_correcao6)
                    .addComponent(jl_pt6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jl_Questao16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jl_Questao16.setText("Questão 06:");

        ta_Questao6.setBackground(new java.awt.Color(204, 204, 204));
        ta_Questao6.setColumns(20);
        ta_Questao6.setLineWrap(true);
        ta_Questao6.setRows(5);
        ta_Questao6.setWrapStyleWord(true);
        ta_Questao6.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        ta_Questao6.setFocusable(false);
        jScrollPane57.setViewportView(ta_Questao6);

        javax.swing.GroupLayout painel_qst6Layout = new javax.swing.GroupLayout(painel_qst6);
        painel_qst6.setLayout(painel_qst6Layout);
        painel_qst6Layout.setHorizontalGroup(
            painel_qst6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_qst6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_qst6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane57, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane42)
                    .addComponent(jScrollPane43)
                    .addGroup(painel_qst6Layout.createSequentialGroup()
                        .addGroup(painel_qst6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jl_Questao16)
                            .addComponent(jl_Resposta6)
                            .addComponent(jl_Questao6))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(painel_qst6Layout.createSequentialGroup()
                        .addComponent(jp_correcao6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bt_Voltar6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bt_Avancar6)))
                .addContainerGap())
        );
        painel_qst6Layout.setVerticalGroup(
            painel_qst6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel_qst6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jl_Questao16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane57, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jl_Questao6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane42, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jl_Resposta6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane43, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painel_qst6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jp_correcao6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel_qst6Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(painel_qst6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bt_Voltar6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bt_Avancar6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 616, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                    .addContainerGap(17, Short.MAX_VALUE)
                    .addComponent(painel_qst6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(17, Short.MAX_VALUE)))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 635, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(painel_qst6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        tb_Questoes.addTab("QST 06", jPanel7);

        bt_Voltar7.setText("CANCELAR");
        bt_Voltar7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_Voltar7ActionPerformed(evt);
            }
        });

        jl_Questao7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jl_Questao7.setText("Gabarito 07:");

        ta_Gabarito7.setBackground(new java.awt.Color(204, 204, 204));
        ta_Gabarito7.setColumns(20);
        ta_Gabarito7.setLineWrap(true);
        ta_Gabarito7.setRows(5);
        ta_Gabarito7.setWrapStyleWord(true);
        ta_Gabarito7.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        ta_Gabarito7.setFocusable(false);
        jScrollPane44.setViewportView(ta_Gabarito7);

        jl_Resposta7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jl_Resposta7.setText("Resposta 07:");

        ta_Resposta7.setBackground(new java.awt.Color(204, 204, 204));
        ta_Resposta7.setColumns(20);
        ta_Resposta7.setLineWrap(true);
        ta_Resposta7.setRows(5);
        ta_Resposta7.setWrapStyleWord(true);
        ta_Resposta7.setFocusable(false);
        jScrollPane45.setViewportView(ta_Resposta7);

        bt_Avancar7.setText("AVANÇAR");
        bt_Avancar7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_Avancar7ActionPerformed(evt);
            }
        });

        jp_correcao7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jc_correcao7.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sem Resposta", "Resposta Errada", "Resposta Incompleta", "Resposta Correta" }));
        jc_correcao7.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jc_correcao7ItemStateChanged(evt);
            }
        });

        jLabel7.setText("Pontuação:");

        jl_pt7.setText("-5 Pontos");

        javax.swing.GroupLayout jp_correcao7Layout = new javax.swing.GroupLayout(jp_correcao7);
        jp_correcao7.setLayout(jp_correcao7Layout);
        jp_correcao7Layout.setHorizontalGroup(
            jp_correcao7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_correcao7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jc_correcao7, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jl_pt7, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jp_correcao7Layout.setVerticalGroup(
            jp_correcao7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_correcao7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jp_correcao7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jc_correcao7)
                    .addComponent(jl_pt7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jl_Questao17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jl_Questao17.setText("Questão 07:");

        ta_Questao7.setBackground(new java.awt.Color(204, 204, 204));
        ta_Questao7.setColumns(20);
        ta_Questao7.setLineWrap(true);
        ta_Questao7.setRows(5);
        ta_Questao7.setWrapStyleWord(true);
        ta_Questao7.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        ta_Questao7.setFocusable(false);
        jScrollPane58.setViewportView(ta_Questao7);

        javax.swing.GroupLayout painel_qst7Layout = new javax.swing.GroupLayout(painel_qst7);
        painel_qst7.setLayout(painel_qst7Layout);
        painel_qst7Layout.setHorizontalGroup(
            painel_qst7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_qst7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_qst7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane58, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane44)
                    .addComponent(jScrollPane45)
                    .addGroup(painel_qst7Layout.createSequentialGroup()
                        .addGroup(painel_qst7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jl_Questao17)
                            .addComponent(jl_Resposta7)
                            .addComponent(jl_Questao7))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(painel_qst7Layout.createSequentialGroup()
                        .addComponent(jp_correcao7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bt_Voltar7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bt_Avancar7)))
                .addContainerGap())
        );
        painel_qst7Layout.setVerticalGroup(
            painel_qst7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel_qst7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jl_Questao17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane58, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jl_Questao7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane44, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jl_Resposta7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane45, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painel_qst7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jp_correcao7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel_qst7Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(painel_qst7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bt_Voltar7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bt_Avancar7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 616, Short.MAX_VALUE)
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                    .addContainerGap(17, Short.MAX_VALUE)
                    .addComponent(painel_qst7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(17, Short.MAX_VALUE)))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 635, Short.MAX_VALUE)
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel8Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(painel_qst7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        tb_Questoes.addTab("QST 07", jPanel8);

        bt_Voltar8.setText("CANCELAR");
        bt_Voltar8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_Voltar8ActionPerformed(evt);
            }
        });

        jl_Questao8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jl_Questao8.setText("Gabarito 08:");

        ta_Gabarito8.setBackground(new java.awt.Color(204, 204, 204));
        ta_Gabarito8.setColumns(20);
        ta_Gabarito8.setLineWrap(true);
        ta_Gabarito8.setRows(5);
        ta_Gabarito8.setWrapStyleWord(true);
        ta_Gabarito8.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        ta_Gabarito8.setFocusable(false);
        jScrollPane46.setViewportView(ta_Gabarito8);

        jl_Resposta8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jl_Resposta8.setText("Resposta 08:");

        ta_Resposta8.setBackground(new java.awt.Color(204, 204, 204));
        ta_Resposta8.setColumns(20);
        ta_Resposta8.setLineWrap(true);
        ta_Resposta8.setRows(5);
        ta_Resposta8.setWrapStyleWord(true);
        ta_Resposta8.setFocusable(false);
        jScrollPane47.setViewportView(ta_Resposta8);

        bt_Avancar8.setText("AVANÇAR");
        bt_Avancar8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_Avancar8ActionPerformed(evt);
            }
        });

        jp_correcao8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jc_correcao8.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sem Resposta", "Resposta Errada", "Resposta Incompleta", "Resposta Correta" }));
        jc_correcao8.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jc_correcao8ItemStateChanged(evt);
            }
        });

        jLabel8.setText("Pontuação:");

        jl_pt8.setText("-5 Pontos");

        javax.swing.GroupLayout jp_correcao8Layout = new javax.swing.GroupLayout(jp_correcao8);
        jp_correcao8.setLayout(jp_correcao8Layout);
        jp_correcao8Layout.setHorizontalGroup(
            jp_correcao8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_correcao8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jc_correcao8, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jl_pt8, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jp_correcao8Layout.setVerticalGroup(
            jp_correcao8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_correcao8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jp_correcao8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jc_correcao8)
                    .addComponent(jl_pt8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jl_Questao18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jl_Questao18.setText("Questão 08:");

        ta_Questao8.setBackground(new java.awt.Color(204, 204, 204));
        ta_Questao8.setColumns(20);
        ta_Questao8.setLineWrap(true);
        ta_Questao8.setRows(5);
        ta_Questao8.setWrapStyleWord(true);
        ta_Questao8.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        ta_Questao8.setFocusable(false);
        jScrollPane59.setViewportView(ta_Questao8);

        javax.swing.GroupLayout painel_qst8Layout = new javax.swing.GroupLayout(painel_qst8);
        painel_qst8.setLayout(painel_qst8Layout);
        painel_qst8Layout.setHorizontalGroup(
            painel_qst8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_qst8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_qst8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane59, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane46)
                    .addComponent(jScrollPane47)
                    .addGroup(painel_qst8Layout.createSequentialGroup()
                        .addGroup(painel_qst8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jl_Questao18)
                            .addComponent(jl_Resposta8)
                            .addComponent(jl_Questao8))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(painel_qst8Layout.createSequentialGroup()
                        .addComponent(jp_correcao8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bt_Voltar8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bt_Avancar8)))
                .addContainerGap())
        );
        painel_qst8Layout.setVerticalGroup(
            painel_qst8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel_qst8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jl_Questao18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane59, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jl_Questao8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane46, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jl_Resposta8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane47, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painel_qst8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jp_correcao8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel_qst8Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(painel_qst8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bt_Voltar8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bt_Avancar8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 616, Short.MAX_VALUE)
            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                    .addContainerGap(17, Short.MAX_VALUE)
                    .addComponent(painel_qst8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(17, Short.MAX_VALUE)))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 635, Short.MAX_VALUE)
            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel9Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(painel_qst8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        tb_Questoes.addTab("QST 08", jPanel9);

        bt_Voltar9.setText("CANCELAR");
        bt_Voltar9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_Voltar9ActionPerformed(evt);
            }
        });

        jl_Questao9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jl_Questao9.setText("Gabarito 09:");

        ta_Gabarito9.setBackground(new java.awt.Color(204, 204, 204));
        ta_Gabarito9.setColumns(20);
        ta_Gabarito9.setLineWrap(true);
        ta_Gabarito9.setRows(5);
        ta_Gabarito9.setWrapStyleWord(true);
        ta_Gabarito9.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        ta_Gabarito9.setFocusable(false);
        jScrollPane48.setViewportView(ta_Gabarito9);

        jl_Resposta9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jl_Resposta9.setText("Resposta 09:");

        ta_Resposta9.setBackground(new java.awt.Color(204, 204, 204));
        ta_Resposta9.setColumns(20);
        ta_Resposta9.setLineWrap(true);
        ta_Resposta9.setRows(5);
        ta_Resposta9.setWrapStyleWord(true);
        ta_Resposta9.setFocusable(false);
        jScrollPane49.setViewportView(ta_Resposta9);

        bt_Avancar9.setText("AVANÇAR");
        bt_Avancar9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_Avancar9ActionPerformed(evt);
            }
        });

        jp_correcao9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jc_correcao9.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sem Resposta", "Resposta Errada", "Resposta Incompleta", "Resposta Correta" }));
        jc_correcao9.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jc_correcao9ItemStateChanged(evt);
            }
        });

        jLabel9.setText("Pontuação:");

        jl_pt9.setText("-5 Pontos");

        javax.swing.GroupLayout jp_correcao9Layout = new javax.swing.GroupLayout(jp_correcao9);
        jp_correcao9.setLayout(jp_correcao9Layout);
        jp_correcao9Layout.setHorizontalGroup(
            jp_correcao9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_correcao9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jc_correcao9, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jl_pt9, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jp_correcao9Layout.setVerticalGroup(
            jp_correcao9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_correcao9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jp_correcao9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jc_correcao9)
                    .addComponent(jl_pt9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jl_Questao19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jl_Questao19.setText("Questão 09:");

        ta_Questao9.setBackground(new java.awt.Color(204, 204, 204));
        ta_Questao9.setColumns(20);
        ta_Questao9.setLineWrap(true);
        ta_Questao9.setRows(5);
        ta_Questao9.setWrapStyleWord(true);
        ta_Questao9.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        ta_Questao9.setFocusable(false);
        jScrollPane60.setViewportView(ta_Questao9);

        javax.swing.GroupLayout painel_qst9Layout = new javax.swing.GroupLayout(painel_qst9);
        painel_qst9.setLayout(painel_qst9Layout);
        painel_qst9Layout.setHorizontalGroup(
            painel_qst9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_qst9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_qst9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane60, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane48)
                    .addComponent(jScrollPane49)
                    .addGroup(painel_qst9Layout.createSequentialGroup()
                        .addGroup(painel_qst9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jl_Questao19)
                            .addComponent(jl_Resposta9)
                            .addComponent(jl_Questao9))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(painel_qst9Layout.createSequentialGroup()
                        .addComponent(jp_correcao9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bt_Voltar9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bt_Avancar9)))
                .addContainerGap())
        );
        painel_qst9Layout.setVerticalGroup(
            painel_qst9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel_qst9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jl_Questao19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane60, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jl_Questao9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane48, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jl_Resposta9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane49, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painel_qst9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jp_correcao9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel_qst9Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(painel_qst9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bt_Voltar9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bt_Avancar9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 616, Short.MAX_VALUE)
            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                    .addContainerGap(17, Short.MAX_VALUE)
                    .addComponent(painel_qst9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(17, Short.MAX_VALUE)))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 635, Short.MAX_VALUE)
            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel10Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(painel_qst9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        tb_Questoes.addTab("QST 09", jPanel10);

        bt_Voltar10.setText("CANCELAR");
        bt_Voltar10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_Voltar10ActionPerformed(evt);
            }
        });

        jl_Questao10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jl_Questao10.setText("Gabarito 10:");

        ta_Gabarito10.setBackground(new java.awt.Color(204, 204, 204));
        ta_Gabarito10.setColumns(20);
        ta_Gabarito10.setLineWrap(true);
        ta_Gabarito10.setRows(5);
        ta_Gabarito10.setWrapStyleWord(true);
        ta_Gabarito10.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        ta_Gabarito10.setFocusable(false);
        jScrollPane50.setViewportView(ta_Gabarito10);

        jl_Resposta10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jl_Resposta10.setText("Resposta 10:");

        ta_Resposta10.setBackground(new java.awt.Color(204, 204, 204));
        ta_Resposta10.setColumns(20);
        ta_Resposta10.setLineWrap(true);
        ta_Resposta10.setRows(5);
        ta_Resposta10.setWrapStyleWord(true);
        ta_Resposta10.setFocusable(false);
        jScrollPane51.setViewportView(ta_Resposta10);

        bt_Avancar10.setText("AVANÇAR");
        bt_Avancar10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_Avancar10ActionPerformed(evt);
            }
        });

        jp_correcao10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jc_correcao10.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sem Resposta", "Resposta Errada", "Resposta Incompleta", "Resposta Correta" }));
        jc_correcao10.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jc_correcao10ItemStateChanged(evt);
            }
        });

        jLabel10.setText("Pontuação:");

        jl_pt10.setText("-5 Pontos");

        javax.swing.GroupLayout jp_correcao10Layout = new javax.swing.GroupLayout(jp_correcao10);
        jp_correcao10.setLayout(jp_correcao10Layout);
        jp_correcao10Layout.setHorizontalGroup(
            jp_correcao10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_correcao10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jc_correcao10, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jl_pt10, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jp_correcao10Layout.setVerticalGroup(
            jp_correcao10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_correcao10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jp_correcao10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jc_correcao10)
                    .addComponent(jl_pt10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jl_Questao20.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jl_Questao20.setText("Questão 10:");

        ta_Questao10.setBackground(new java.awt.Color(204, 204, 204));
        ta_Questao10.setColumns(20);
        ta_Questao10.setLineWrap(true);
        ta_Questao10.setRows(5);
        ta_Questao10.setWrapStyleWord(true);
        ta_Questao10.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        ta_Questao10.setFocusable(false);
        jScrollPane61.setViewportView(ta_Questao10);

        javax.swing.GroupLayout painel_qst10Layout = new javax.swing.GroupLayout(painel_qst10);
        painel_qst10.setLayout(painel_qst10Layout);
        painel_qst10Layout.setHorizontalGroup(
            painel_qst10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_qst10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_qst10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane61, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane50)
                    .addComponent(jScrollPane51)
                    .addGroup(painel_qst10Layout.createSequentialGroup()
                        .addGroup(painel_qst10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jl_Questao20)
                            .addComponent(jl_Resposta10)
                            .addComponent(jl_Questao10))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(painel_qst10Layout.createSequentialGroup()
                        .addComponent(jp_correcao10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bt_Voltar10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bt_Avancar10)))
                .addContainerGap())
        );
        painel_qst10Layout.setVerticalGroup(
            painel_qst10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel_qst10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jl_Questao20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane61, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jl_Questao10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane50, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jl_Resposta10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane51, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painel_qst10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jp_correcao10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel_qst10Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(painel_qst10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bt_Voltar10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bt_Avancar10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 616, Short.MAX_VALUE)
            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                    .addContainerGap(17, Short.MAX_VALUE)
                    .addComponent(painel_qst10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(17, Short.MAX_VALUE)))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 635, Short.MAX_VALUE)
            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel11Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(painel_qst10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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
                .addComponent(tb_Questoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bt_Voltar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_Voltar1ActionPerformed

        if (JOptionPane.showConfirmDialog(null, "Deseja Cancelar?", "Cancelar", 2) == 0) {
            dispose();
        }
    }//GEN-LAST:event_bt_Voltar1ActionPerformed

    private void bt_Avancar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_Avancar1ActionPerformed

        tb_Questoes.setEnabledAt(0, false);
        tb_Questoes.setEnabledAt(1, true);
        tb_Questoes.setSelectedIndex(1);

    }//GEN-LAST:event_bt_Avancar1ActionPerformed

    private void jc_correcao1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jc_correcao1ItemStateChanged

        switch (jc_correcao1.getSelectedIndex()) {
            case 0:
                jl_pt1.setText("-5 Pontos");
                break;
            case 1:
                jl_pt1.setText("0 Pontos");
                break;
            case 2:
                jl_pt1.setText("5 Pontos");
                break;
            case 3:
                jl_pt1.setText("10 Pontos");
                break;
            default:
                break;
        }

    }//GEN-LAST:event_jc_correcao1ItemStateChanged

    private void bt_Voltar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_Voltar2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_Voltar2ActionPerformed

    private void bt_Avancar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_Avancar2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_Avancar2ActionPerformed

    private void jc_correcao2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jc_correcao2ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jc_correcao2ItemStateChanged

    private void bt_Voltar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_Voltar3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_Voltar3ActionPerformed

    private void bt_Avancar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_Avancar3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_Avancar3ActionPerformed

    private void jc_correcao3ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jc_correcao3ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jc_correcao3ItemStateChanged

    private void bt_Voltar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_Voltar4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_Voltar4ActionPerformed

    private void bt_Avancar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_Avancar4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_Avancar4ActionPerformed

    private void jc_correcao4ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jc_correcao4ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jc_correcao4ItemStateChanged

    private void bt_Voltar5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_Voltar5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_Voltar5ActionPerformed

    private void bt_Avancar5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_Avancar5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_Avancar5ActionPerformed

    private void jc_correcao5ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jc_correcao5ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jc_correcao5ItemStateChanged

    private void bt_Voltar6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_Voltar6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_Voltar6ActionPerformed

    private void bt_Avancar6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_Avancar6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_Avancar6ActionPerformed

    private void jc_correcao6ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jc_correcao6ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jc_correcao6ItemStateChanged

    private void bt_Voltar7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_Voltar7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_Voltar7ActionPerformed

    private void bt_Avancar7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_Avancar7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_Avancar7ActionPerformed

    private void jc_correcao7ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jc_correcao7ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jc_correcao7ItemStateChanged

    private void bt_Voltar8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_Voltar8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_Voltar8ActionPerformed

    private void bt_Avancar8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_Avancar8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_Avancar8ActionPerformed

    private void jc_correcao8ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jc_correcao8ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jc_correcao8ItemStateChanged

    private void bt_Voltar9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_Voltar9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_Voltar9ActionPerformed

    private void bt_Avancar9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_Avancar9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_Avancar9ActionPerformed

    private void jc_correcao9ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jc_correcao9ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jc_correcao9ItemStateChanged

    private void bt_Voltar10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_Voltar10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_Voltar10ActionPerformed

    private void bt_Avancar10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_Avancar10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_Avancar10ActionPerformed

    private void jc_correcao10ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jc_correcao10ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jc_correcao10ItemStateChanged

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Tela_CorrigirRespostas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela_CorrigirRespostas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela_CorrigirRespostas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela_CorrigirRespostas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Tela_CorrigirRespostas dialog = new Tela_CorrigirRespostas(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton bt_Avancar10;
    private javax.swing.JButton bt_Avancar2;
    private javax.swing.JButton bt_Avancar3;
    private javax.swing.JButton bt_Avancar4;
    private javax.swing.JButton bt_Avancar5;
    private javax.swing.JButton bt_Avancar6;
    private javax.swing.JButton bt_Avancar7;
    private javax.swing.JButton bt_Avancar8;
    private javax.swing.JButton bt_Avancar9;
    private javax.swing.JButton bt_Voltar1;
    private javax.swing.JButton bt_Voltar10;
    private javax.swing.JButton bt_Voltar2;
    private javax.swing.JButton bt_Voltar3;
    private javax.swing.JButton bt_Voltar4;
    private javax.swing.JButton bt_Voltar5;
    private javax.swing.JButton bt_Voltar6;
    private javax.swing.JButton bt_Voltar7;
    private javax.swing.JButton bt_Voltar8;
    private javax.swing.JButton bt_Voltar9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
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
    private javax.swing.JScrollPane jScrollPane52;
    private javax.swing.JScrollPane jScrollPane53;
    private javax.swing.JScrollPane jScrollPane54;
    private javax.swing.JScrollPane jScrollPane55;
    private javax.swing.JScrollPane jScrollPane56;
    private javax.swing.JScrollPane jScrollPane57;
    private javax.swing.JScrollPane jScrollPane58;
    private javax.swing.JScrollPane jScrollPane59;
    private javax.swing.JScrollPane jScrollPane60;
    private javax.swing.JScrollPane jScrollPane61;
    private javax.swing.JComboBox<String> jc_correcao1;
    private javax.swing.JComboBox<String> jc_correcao10;
    private javax.swing.JComboBox<String> jc_correcao2;
    private javax.swing.JComboBox<String> jc_correcao3;
    private javax.swing.JComboBox<String> jc_correcao4;
    private javax.swing.JComboBox<String> jc_correcao5;
    private javax.swing.JComboBox<String> jc_correcao6;
    private javax.swing.JComboBox<String> jc_correcao7;
    private javax.swing.JComboBox<String> jc_correcao8;
    private javax.swing.JComboBox<String> jc_correcao9;
    private javax.swing.JLabel jl_Questao1;
    private javax.swing.JLabel jl_Questao10;
    private javax.swing.JLabel jl_Questao11;
    private javax.swing.JLabel jl_Questao12;
    private javax.swing.JLabel jl_Questao13;
    private javax.swing.JLabel jl_Questao14;
    private javax.swing.JLabel jl_Questao15;
    private javax.swing.JLabel jl_Questao16;
    private javax.swing.JLabel jl_Questao17;
    private javax.swing.JLabel jl_Questao18;
    private javax.swing.JLabel jl_Questao19;
    private javax.swing.JLabel jl_Questao2;
    private javax.swing.JLabel jl_Questao20;
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
    private javax.swing.JLabel jl_pt1;
    private javax.swing.JLabel jl_pt10;
    private javax.swing.JLabel jl_pt2;
    private javax.swing.JLabel jl_pt3;
    private javax.swing.JLabel jl_pt4;
    private javax.swing.JLabel jl_pt5;
    private javax.swing.JLabel jl_pt6;
    private javax.swing.JLabel jl_pt7;
    private javax.swing.JLabel jl_pt8;
    private javax.swing.JLabel jl_pt9;
    private javax.swing.JPanel jp_correcao1;
    private javax.swing.JPanel jp_correcao10;
    private javax.swing.JPanel jp_correcao2;
    private javax.swing.JPanel jp_correcao3;
    private javax.swing.JPanel jp_correcao4;
    private javax.swing.JPanel jp_correcao5;
    private javax.swing.JPanel jp_correcao6;
    private javax.swing.JPanel jp_correcao7;
    private javax.swing.JPanel jp_correcao8;
    private javax.swing.JPanel jp_correcao9;
    private javax.swing.JPanel painel_qst01;
    private javax.swing.JPanel painel_qst10;
    private javax.swing.JPanel painel_qst2;
    private javax.swing.JPanel painel_qst3;
    private javax.swing.JPanel painel_qst4;
    private javax.swing.JPanel painel_qst5;
    private javax.swing.JPanel painel_qst6;
    private javax.swing.JPanel painel_qst7;
    private javax.swing.JPanel painel_qst8;
    private javax.swing.JPanel painel_qst9;
    private javax.swing.JTextArea ta_Gabarito1;
    private javax.swing.JTextArea ta_Gabarito10;
    private javax.swing.JTextArea ta_Gabarito2;
    private javax.swing.JTextArea ta_Gabarito3;
    private javax.swing.JTextArea ta_Gabarito4;
    private javax.swing.JTextArea ta_Gabarito5;
    private javax.swing.JTextArea ta_Gabarito6;
    private javax.swing.JTextArea ta_Gabarito7;
    private javax.swing.JTextArea ta_Gabarito8;
    private javax.swing.JTextArea ta_Gabarito9;
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
