package Telas;

import Classes.Equipe;
import Classes.Questao_Desafio;
import Classes.Resposta_Questao_Desafio;
import Classes.Usuario_Token;
import Servicos.ContagemPontos;
import Servicos.Utilitarios;
import WebService.EquipeWebDAO;
import WebService.Questao_DesafioWebDAO;
import WebService.Resposta_Questao_DesafioWebDAO;
import WebService.Usuario_AlunoWebDAO;
import java.awt.Color;
import java.awt.Component;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class Tela_CorrigirRespostaDesafio extends javax.swing.JDialog {

    Usuario_Token ut = Usuario_Token.getInstance();
    Utilitarios u = new Utilitarios();
    Questao_Desafio qd = new Questao_Desafio();
    Questao_DesafioWebDAO qdwdao = new Questao_DesafioWebDAO();
    Resposta_Questao_Desafio rqd = new Resposta_Questao_Desafio();
    Resposta_Questao_DesafioWebDAO rqdwdao = new Resposta_Questao_DesafioWebDAO();
    Equipe e;
    EquipeWebDAO ewdao = new EquipeWebDAO();
    Usuario_AlunoWebDAO uawdao = new Usuario_AlunoWebDAO();
    ArrayList<Integer> listaidEquipes = new ArrayList<>();
    Color corVerde = Color.decode("#006400");
    Color corVermelha = Color.decode("#EE2C2C");
    Color corLaranja = Color.decode("#FFC125");

    public void PreencherCampos(int idEquipe) {

        ewdao.BuscarEquipe(e, idEquipe);

        //QUESTÃO 01
        qdwdao.BuscarQuestaoDesafio(e.getIdQuestao_Desafio01(), qd);
        rqdwdao.BuscarRespostaDesafio(e.getIdResposta_Desafio01(), rqd);
        ta_Questao1.setText(qd.getCorpo_Questao());
        ta_Gabarito1.setText(qd.getGabarito());
        ta_Resposta1.setText(rqd.getCorpo_Resposta());
        qd = new Questao_Desafio();
        rqd = new Resposta_Questao_Desafio();

        //QUESTÃO 02
        qdwdao.BuscarQuestaoDesafio(e.getIdQuestao_Desafio02(), qd);
        rqdwdao.BuscarRespostaDesafio(e.getIdResposta_Desafio02(), rqd);
        ta_Questao2.setText(qd.getCorpo_Questao());
        ta_Gabarito2.setText(qd.getGabarito());
        ta_Resposta2.setText(rqd.getCorpo_Resposta());
        qd = new Questao_Desafio();
        rqd = new Resposta_Questao_Desafio();

        //QUESTÃO 03
        qdwdao.BuscarQuestaoDesafio(e.getIdQuestao_Desafio03(), qd);
        rqdwdao.BuscarRespostaDesafio(e.getIdResposta_Desafio03(), rqd);
        ta_Questao3.setText(qd.getCorpo_Questao());
        ta_Gabarito3.setText(qd.getGabarito());
        ta_Resposta3.setText(rqd.getCorpo_Resposta());
        qd = new Questao_Desafio();
        rqd = new Resposta_Questao_Desafio();
    }

    public void LimparCampos() {
        u.bloqueiapainel(jp_pontuacao1);
        u.bloqueiapainel(jp_pontuacao2);
        u.bloqueiapainel(jp_pontuacao3);
        u.bloqueiapainel(jp_questoes1);
        u.bloqueiapainel(jp_questoes2);
        u.bloqueiapainel(jp_questoes3);
        u.bloqueiapainel(jp_questoes2);
        u.bloqueiapainel(jp_questoes3);
        u.bloqueiapainel(jp_correcao1);
        u.bloqueiapainel(jp_correcao2);
        u.bloqueiapainel(jp_correcao3);
        jc_correcao1.setSelectedIndex(0);
        jc_correcao2.setSelectedIndex(0);
        jc_correcao3.setSelectedIndex(0);
        jl_pt1.setText("-5 Pontos");
        jl_pt2.setText("-5 Pontos");
        jl_pt3.setText("-5 Pontos");
        ta_questoes.setEnabledAt(1, false);
        ta_questoes.setEnabledAt(0, true);
        ta_questoes.setSelectedIndex(0);
        ta_questoes.setEnabled(false);
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

    public void ListarTabela() {

        DefaultTableModel modelo1 = (DefaultTableModel) tb_equipe.getModel();
        DefaultTableModel modelo2 = (DefaultTableModel) tb_equipe1.getModel();
        DefaultTableModel modelo3 = (DefaultTableModel) tb_equipe2.getModel();
        String respostaDesafio01;
        String respostaDesafio02;
        String respostaDesafio03;
        modelo1.setNumRows(0);
        modelo2.setNumRows(0);
        modelo3.setNumRows(0);
        tb_equipe.getTableHeader().setReorderingAllowed(false); 
        tb_equipe1.getTableHeader().setReorderingAllowed(false); 
        tb_equipe2.getTableHeader().setReorderingAllowed(false); 

        try {

            int cont = 0;
            listaidEquipes = uawdao.ListaEquipesId(ut.getRodada_idRodada());
            for (int idEquipe : listaidEquipes) {
                e = new Equipe();
                ewdao.BuscarEquipe(e, listaidEquipes.get(cont));

                rqdwdao.BuscarRespostaDesafio(e.getIdResposta_Desafio01(), rqd);
                respostaDesafio01 = rqd.getNota_Questao_Desafio();
                rqd = new Resposta_Questao_Desafio();
                rqdwdao.BuscarRespostaDesafio(e.getIdResposta_Desafio02(), rqd);
                respostaDesafio02 = rqd.getNota_Questao_Desafio();
                rqd = new Resposta_Questao_Desafio();
                rqdwdao.BuscarRespostaDesafio(e.getIdResposta_Desafio03(), rqd);
                respostaDesafio03 = rqd.getNota_Questao_Desafio();
                rqd = new Resposta_Questao_Desafio();

                modelo1.addRow(new Object[]{
                    e.getNomeEquipe(),
                    VerificarEquipeCorrecao(respostaDesafio01, respostaDesafio02, respostaDesafio03, e.getIsDesafio()),
                    respostaDesafio01,
                    respostaDesafio02,
                    respostaDesafio03,
                    e.getPontuacao_Desafios()
                });
                modelo2.addRow(new Object[]{
                    e.getNomeEquipe(),
                    VerificarEquipeCorrecao(respostaDesafio01, respostaDesafio02, respostaDesafio03, e.getIsDesafio()),
                    e.getIdQuestao_Desafio01(),
                    e.getIdQuestao_Desafio02(),
                    e.getIdQuestao_Desafio03(),
                    e.getPontuacao_Desafios()
                });
                modelo3.addRow(new Object[]{
                    e.getNomeEquipe(),
                    VerificarEquipeCorrecao(respostaDesafio01, respostaDesafio02, respostaDesafio03, e.getIsDesafio()),
                    e.getIdQuestao_Desafio01(),
                    e.getIdQuestao_Desafio02(),
                    e.getIdQuestao_Desafio03(),
                    e.getPontuacao_Desafios()
                });
                cont++;
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
        tb_equipe1.setEnabled(false);
        tb_equipe2.setEnabled(false);
        MudarCorTabelas();
    }

    public void MudarCorTabelas() {

        tb_equipe.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {
                JLabel label = (JLabel) super.getTableCellRendererComponent(table, value,
                        isSelected, hasFocus, row, column);

                Object texto = table.getValueAt(row, 1);
                if (texto != null && texto.toString().equals("CORRIGIDO")) {
                    label.setForeground(corVerde);
                } else if (texto != null && texto.toString().equals("NÃO CORRIGIDO")) {
                    label.setForeground(corLaranja);
                } else if (texto != null && texto.toString().equals("SEM RESPOSTA")) {
                    label.setForeground(corVermelha);
                }

                return label;
            }
        });

        tb_equipe1.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {
                JLabel label = (JLabel) super.getTableCellRendererComponent(table, value,
                        isSelected, hasFocus, row, column);

                Object texto = table.getValueAt(row, 1);
                if (texto != null && texto.toString().equals("CORRIGIDO")) {
                    label.setForeground(corVerde);
                } else if (texto != null && texto.toString().equals("NÃO CORRIGIDO")) {
                    label.setForeground(corLaranja);
                } else if (texto != null && texto.toString().equals("SEM RESPOSTA")) {
                    label.setForeground(corVermelha);
                }

                return label;
            }
        });

        tb_equipe2.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {
                JLabel label = (JLabel) super.getTableCellRendererComponent(table, value,
                        isSelected, hasFocus, row, column);

                
                Object texto = table.getValueAt(row, 1);
                if (texto != null && texto.toString().equals("CORRIGIDO")) {
                    label.setForeground(corVerde);
                } else if (texto != null && texto.toString().equals("NÃO CORRIGIDO")) {
                    label.setForeground(corLaranja);
                } else if (texto != null && texto.toString().equals("SEM RESPOSTA")) {
                    label.setForeground(corVermelha);
                }

                return label;
            }
        });

    }

    public String VerificarEquipeCorrecao(String respostaDesafio01, String respostaDesafio02, String respostaDesafio03, int isDesafio) {

        String retorno;

        if (isDesafio == 0) {
            retorno = "SEM RESPOSTA";
        } else {
            retorno = "CORRIGIDO";
            if (respostaDesafio01.equals("SEM CONTEUDO") || respostaDesafio02.equals("SEM CONTEUDO") || respostaDesafio03.equals("SEM CONTEUDO")) {
                retorno = "NÃO CORRIGIDO";
            }
        }
        return retorno;
    }

    public Tela_CorrigirRespostaDesafio(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        LimparCampos();
        ListarTabela();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ta_questoes = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jp_equipe1 = new javax.swing.JScrollPane();
        tb_equipe = new javax.swing.JTable();
        jp_pontuacao1 = new javax.swing.JPanel();
        jp_correcao1 = new javax.swing.JPanel();
        jc_correcao1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jl_pt1 = new javax.swing.JLabel();
        bt_Cancelar1 = new javax.swing.JButton();
        bt_Avancar1 = new javax.swing.JButton();
        jp_questoes1 = new javax.swing.JPanel();
        jl_Questao1 = new javax.swing.JLabel();
        jScrollPane53 = new javax.swing.JScrollPane();
        ta_Questao1 = new javax.swing.JTextArea();
        jl_Resposta1 = new javax.swing.JLabel();
        jScrollPane35 = new javax.swing.JScrollPane();
        ta_Resposta1 = new javax.swing.JTextArea();
        jl_Gabarito1 = new javax.swing.JLabel();
        jScrollPane34 = new javax.swing.JScrollPane();
        ta_Gabarito1 = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jp_equipe2 = new javax.swing.JScrollPane();
        tb_equipe1 = new javax.swing.JTable();
        jp_pontuacao2 = new javax.swing.JPanel();
        jp_correcao2 = new javax.swing.JPanel();
        jc_correcao2 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jl_pt2 = new javax.swing.JLabel();
        bt_Voltar1 = new javax.swing.JButton();
        bt_Avancar2 = new javax.swing.JButton();
        jp_questoes2 = new javax.swing.JPanel();
        jl_Questao2 = new javax.swing.JLabel();
        jScrollPane54 = new javax.swing.JScrollPane();
        ta_Questao2 = new javax.swing.JTextArea();
        jl_Resposta2 = new javax.swing.JLabel();
        jScrollPane36 = new javax.swing.JScrollPane();
        ta_Resposta2 = new javax.swing.JTextArea();
        jl_Gabarito2 = new javax.swing.JLabel();
        jScrollPane37 = new javax.swing.JScrollPane();
        ta_Gabarito2 = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jp_equipe3 = new javax.swing.JScrollPane();
        tb_equipe2 = new javax.swing.JTable();
        jp_pontuacao3 = new javax.swing.JPanel();
        jp_correcao3 = new javax.swing.JPanel();
        jc_correcao3 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jl_pt3 = new javax.swing.JLabel();
        bt_Voltar2 = new javax.swing.JButton();
        bt_Salvar = new javax.swing.JButton();
        jp_questoes3 = new javax.swing.JPanel();
        jl_Questao3 = new javax.swing.JLabel();
        jScrollPane55 = new javax.swing.JScrollPane();
        ta_Questao3 = new javax.swing.JTextArea();
        jl_Resposta3 = new javax.swing.JLabel();
        jScrollPane38 = new javax.swing.JScrollPane();
        ta_Resposta3 = new javax.swing.JTextArea();
        jl_Gabarito3 = new javax.swing.JLabel();
        jScrollPane39 = new javax.swing.JScrollPane();
        ta_Gabarito3 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        ta_questoes.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jp_equipe1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        tb_equipe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Equipe", "Correção", "Questão 01", "Questão 02", "Questão 03", "Pontuação"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_equipe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_equipeMouseClicked(evt);
            }
        });
        jp_equipe1.setViewportView(tb_equipe);
        if (tb_equipe.getColumnModel().getColumnCount() > 0) {
            tb_equipe.getColumnModel().getColumn(0).setPreferredWidth(100);
            tb_equipe.getColumnModel().getColumn(1).setPreferredWidth(140);
            tb_equipe.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_equipe.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_equipe.getColumnModel().getColumn(4).setPreferredWidth(100);
            tb_equipe.getColumnModel().getColumn(5).setPreferredWidth(60);
        }

        jp_pontuacao1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

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
                .addComponent(jc_correcao1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jl_pt1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jp_correcao1Layout.setVerticalGroup(
            jp_correcao1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_correcao1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jp_correcao1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jc_correcao1)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jl_pt1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        bt_Cancelar1.setText("CANCELAR");
        bt_Cancelar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_Cancelar1ActionPerformed(evt);
            }
        });

        bt_Avancar1.setText("AVANÇAR");
        bt_Avancar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_Avancar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jp_pontuacao1Layout = new javax.swing.GroupLayout(jp_pontuacao1);
        jp_pontuacao1.setLayout(jp_pontuacao1Layout);
        jp_pontuacao1Layout.setHorizontalGroup(
            jp_pontuacao1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_pontuacao1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jp_pontuacao1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jp_correcao1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jp_pontuacao1Layout.createSequentialGroup()
                        .addComponent(bt_Cancelar1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_Avancar1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jp_pontuacao1Layout.setVerticalGroup(
            jp_pontuacao1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_pontuacao1Layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addComponent(jp_correcao1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jp_pontuacao1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_Cancelar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_Avancar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jp_questoes1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jl_Questao1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jl_Questao1.setText("Questão 01:");

        ta_Questao1.setBackground(new java.awt.Color(204, 204, 204));
        ta_Questao1.setColumns(20);
        ta_Questao1.setLineWrap(true);
        ta_Questao1.setRows(5);
        ta_Questao1.setWrapStyleWord(true);
        ta_Questao1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        ta_Questao1.setFocusable(false);
        jScrollPane53.setViewportView(ta_Questao1);

        jl_Resposta1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jl_Resposta1.setText("Resposta 01:");

        ta_Resposta1.setBackground(new java.awt.Color(204, 204, 204));
        ta_Resposta1.setColumns(20);
        ta_Resposta1.setLineWrap(true);
        ta_Resposta1.setRows(5);
        ta_Resposta1.setWrapStyleWord(true);
        ta_Resposta1.setFocusable(false);
        jScrollPane35.setViewportView(ta_Resposta1);

        jl_Gabarito1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jl_Gabarito1.setText("Gabarito 01:");

        ta_Gabarito1.setBackground(new java.awt.Color(204, 204, 204));
        ta_Gabarito1.setColumns(20);
        ta_Gabarito1.setLineWrap(true);
        ta_Gabarito1.setRows(5);
        ta_Gabarito1.setWrapStyleWord(true);
        ta_Gabarito1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        ta_Gabarito1.setFocusable(false);
        jScrollPane34.setViewportView(ta_Gabarito1);

        javax.swing.GroupLayout jp_questoes1Layout = new javax.swing.GroupLayout(jp_questoes1);
        jp_questoes1.setLayout(jp_questoes1Layout);
        jp_questoes1Layout.setHorizontalGroup(
            jp_questoes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_questoes1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jp_questoes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jp_questoes1Layout.createSequentialGroup()
                        .addComponent(jl_Resposta1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane35)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_questoes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jp_questoes1Layout.createSequentialGroup()
                            .addComponent(jl_Questao1)
                            .addGap(443, 443, 443)
                            .addComponent(jl_Gabarito1))
                        .addGroup(jp_questoes1Layout.createSequentialGroup()
                            .addComponent(jScrollPane53, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jScrollPane34, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jp_questoes1Layout.setVerticalGroup(
            jp_questoes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_questoes1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jp_questoes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_Questao1)
                    .addComponent(jl_Gabarito1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jp_questoes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane34)
                    .addComponent(jScrollPane53, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jl_Resposta1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane35, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jp_questoes1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jp_equipe1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jp_pontuacao1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jp_equipe1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jp_pontuacao1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jp_questoes1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        ta_questoes.addTab("Questão 01", jPanel1);

        jp_equipe2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        tb_equipe1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Equipe", "Correção", "Questão 01", "Questão 02", "Questão 03", "Pontuação"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jp_equipe2.setViewportView(tb_equipe1);
        if (tb_equipe1.getColumnModel().getColumnCount() > 0) {
            tb_equipe1.getColumnModel().getColumn(0).setPreferredWidth(100);
            tb_equipe1.getColumnModel().getColumn(1).setPreferredWidth(140);
            tb_equipe1.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_equipe1.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_equipe1.getColumnModel().getColumn(4).setPreferredWidth(100);
            tb_equipe1.getColumnModel().getColumn(5).setPreferredWidth(60);
        }

        jp_pontuacao2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

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
                .addComponent(jc_correcao2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jl_pt2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jp_correcao2Layout.setVerticalGroup(
            jp_correcao2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_correcao2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jp_correcao2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jc_correcao2)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jl_pt2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        bt_Voltar1.setText("VOLTAR");
        bt_Voltar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_Voltar1ActionPerformed(evt);
            }
        });

        bt_Avancar2.setText("AVANÇAR");
        bt_Avancar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_Avancar2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jp_pontuacao2Layout = new javax.swing.GroupLayout(jp_pontuacao2);
        jp_pontuacao2.setLayout(jp_pontuacao2Layout);
        jp_pontuacao2Layout.setHorizontalGroup(
            jp_pontuacao2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_pontuacao2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jp_pontuacao2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jp_correcao2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jp_pontuacao2Layout.createSequentialGroup()
                        .addComponent(bt_Voltar1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_Avancar2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jp_pontuacao2Layout.setVerticalGroup(
            jp_pontuacao2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_pontuacao2Layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addComponent(jp_correcao2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jp_pontuacao2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_Voltar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_Avancar2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jp_questoes2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jl_Questao2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jl_Questao2.setText("Questão 01:");

        ta_Questao2.setBackground(new java.awt.Color(204, 204, 204));
        ta_Questao2.setColumns(20);
        ta_Questao2.setLineWrap(true);
        ta_Questao2.setRows(5);
        ta_Questao2.setWrapStyleWord(true);
        ta_Questao2.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        ta_Questao2.setFocusable(false);
        jScrollPane54.setViewportView(ta_Questao2);

        jl_Resposta2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jl_Resposta2.setText("Resposta 01:");

        ta_Resposta2.setBackground(new java.awt.Color(204, 204, 204));
        ta_Resposta2.setColumns(20);
        ta_Resposta2.setLineWrap(true);
        ta_Resposta2.setRows(5);
        ta_Resposta2.setWrapStyleWord(true);
        ta_Resposta2.setFocusable(false);
        jScrollPane36.setViewportView(ta_Resposta2);

        jl_Gabarito2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jl_Gabarito2.setText("Gabarito 01:");

        ta_Gabarito2.setBackground(new java.awt.Color(204, 204, 204));
        ta_Gabarito2.setColumns(20);
        ta_Gabarito2.setLineWrap(true);
        ta_Gabarito2.setRows(5);
        ta_Gabarito2.setWrapStyleWord(true);
        ta_Gabarito2.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        ta_Gabarito2.setFocusable(false);
        jScrollPane37.setViewportView(ta_Gabarito2);

        javax.swing.GroupLayout jp_questoes2Layout = new javax.swing.GroupLayout(jp_questoes2);
        jp_questoes2.setLayout(jp_questoes2Layout);
        jp_questoes2Layout.setHorizontalGroup(
            jp_questoes2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_questoes2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jp_questoes2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jp_questoes2Layout.createSequentialGroup()
                        .addComponent(jl_Resposta2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane36)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_questoes2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jp_questoes2Layout.createSequentialGroup()
                            .addComponent(jl_Questao2)
                            .addGap(443, 443, 443)
                            .addComponent(jl_Gabarito2))
                        .addGroup(jp_questoes2Layout.createSequentialGroup()
                            .addComponent(jScrollPane54, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jScrollPane37, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jp_questoes2Layout.setVerticalGroup(
            jp_questoes2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_questoes2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jp_questoes2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_Questao2)
                    .addComponent(jl_Gabarito2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jp_questoes2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane37)
                    .addComponent(jScrollPane54, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jl_Resposta2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane36, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jp_questoes2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jp_equipe2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jp_pontuacao2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jp_equipe2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jp_pontuacao2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jp_questoes2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1054, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 541, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        ta_questoes.addTab("Questão 02", jPanel2);

        jp_equipe3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        tb_equipe2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Equipe", "Correção", "Questão 01", "Questão 02", "Questão 03", "Pontuação"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jp_equipe3.setViewportView(tb_equipe2);
        if (tb_equipe2.getColumnModel().getColumnCount() > 0) {
            tb_equipe2.getColumnModel().getColumn(0).setPreferredWidth(100);
            tb_equipe2.getColumnModel().getColumn(1).setPreferredWidth(140);
            tb_equipe2.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_equipe2.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_equipe2.getColumnModel().getColumn(4).setPreferredWidth(100);
            tb_equipe2.getColumnModel().getColumn(5).setPreferredWidth(60);
        }

        jp_pontuacao3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

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
                .addComponent(jc_correcao3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jl_pt3, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jp_correcao3Layout.setVerticalGroup(
            jp_correcao3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_correcao3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jp_correcao3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jc_correcao3)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jl_pt3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        bt_Voltar2.setText("VOLTAR");
        bt_Voltar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_Voltar2ActionPerformed(evt);
            }
        });

        bt_Salvar.setText("SALVAR");
        bt_Salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_SalvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jp_pontuacao3Layout = new javax.swing.GroupLayout(jp_pontuacao3);
        jp_pontuacao3.setLayout(jp_pontuacao3Layout);
        jp_pontuacao3Layout.setHorizontalGroup(
            jp_pontuacao3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_pontuacao3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jp_pontuacao3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jp_correcao3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jp_pontuacao3Layout.createSequentialGroup()
                        .addComponent(bt_Voltar2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_Salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jp_pontuacao3Layout.setVerticalGroup(
            jp_pontuacao3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_pontuacao3Layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addComponent(jp_correcao3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jp_pontuacao3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_Voltar2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_Salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jp_questoes3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jl_Questao3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jl_Questao3.setText("Questão 01:");

        ta_Questao3.setBackground(new java.awt.Color(204, 204, 204));
        ta_Questao3.setColumns(20);
        ta_Questao3.setLineWrap(true);
        ta_Questao3.setRows(5);
        ta_Questao3.setWrapStyleWord(true);
        ta_Questao3.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        ta_Questao3.setFocusable(false);
        jScrollPane55.setViewportView(ta_Questao3);

        jl_Resposta3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jl_Resposta3.setText("Resposta 01:");

        ta_Resposta3.setBackground(new java.awt.Color(204, 204, 204));
        ta_Resposta3.setColumns(20);
        ta_Resposta3.setLineWrap(true);
        ta_Resposta3.setRows(5);
        ta_Resposta3.setWrapStyleWord(true);
        ta_Resposta3.setFocusable(false);
        jScrollPane38.setViewportView(ta_Resposta3);

        jl_Gabarito3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jl_Gabarito3.setText("Gabarito 01:");

        ta_Gabarito3.setBackground(new java.awt.Color(204, 204, 204));
        ta_Gabarito3.setColumns(20);
        ta_Gabarito3.setLineWrap(true);
        ta_Gabarito3.setRows(5);
        ta_Gabarito3.setWrapStyleWord(true);
        ta_Gabarito3.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        ta_Gabarito3.setFocusable(false);
        jScrollPane39.setViewportView(ta_Gabarito3);

        javax.swing.GroupLayout jp_questoes3Layout = new javax.swing.GroupLayout(jp_questoes3);
        jp_questoes3.setLayout(jp_questoes3Layout);
        jp_questoes3Layout.setHorizontalGroup(
            jp_questoes3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_questoes3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jp_questoes3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jp_questoes3Layout.createSequentialGroup()
                        .addComponent(jl_Resposta3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane38)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_questoes3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jp_questoes3Layout.createSequentialGroup()
                            .addComponent(jl_Questao3)
                            .addGap(443, 443, 443)
                            .addComponent(jl_Gabarito3))
                        .addGroup(jp_questoes3Layout.createSequentialGroup()
                            .addComponent(jScrollPane55, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jScrollPane39, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jp_questoes3Layout.setVerticalGroup(
            jp_questoes3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_questoes3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jp_questoes3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_Questao3)
                    .addComponent(jl_Gabarito3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jp_questoes3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane39)
                    .addComponent(jScrollPane55, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jl_Resposta3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane38, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jp_questoes3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jp_equipe3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jp_pontuacao3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jp_equipe3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jp_pontuacao3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jp_questoes3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1054, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 541, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        ta_questoes.addTab("Questão 03", jPanel4);

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
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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

    private void bt_Cancelar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_Cancelar1ActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Deseja Cancelar?", "Cancelar", 2) == 0) {
            LimparCampos();
            dispose();
        }
    }//GEN-LAST:event_bt_Cancelar1ActionPerformed

    private void bt_Avancar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_Avancar1ActionPerformed

        ta_questoes.setEnabledAt(0, false);
        ta_questoes.setEnabledAt(1, true);
        ta_questoes.setSelectedIndex(1);

    }//GEN-LAST:event_bt_Avancar1ActionPerformed

    private void jc_correcao2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jc_correcao2ItemStateChanged

        switch (jc_correcao2.getSelectedIndex()) {
            case 0:
                jl_pt2.setText("-5 Pontos");
                break;
            case 1:
                jl_pt2.setText("0 Pontos");
                break;
            case 2:
                jl_pt2.setText("5 Pontos");
                break;
            case 3:
                jl_pt2.setText("10 Pontos");
                break;
            default:
                break;
        }

    }//GEN-LAST:event_jc_correcao2ItemStateChanged

    private void bt_Voltar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_Voltar1ActionPerformed

        ta_questoes.setEnabledAt(1, false);
        ta_questoes.setEnabledAt(0, true);
        ta_questoes.setSelectedIndex(0);

    }//GEN-LAST:event_bt_Voltar1ActionPerformed

    private void bt_Avancar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_Avancar2ActionPerformed

        ta_questoes.setEnabledAt(1, false);
        ta_questoes.setEnabledAt(2, true);
        ta_questoes.setSelectedIndex(2);

    }//GEN-LAST:event_bt_Avancar2ActionPerformed

    private void jc_correcao3ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jc_correcao3ItemStateChanged

        switch (jc_correcao3.getSelectedIndex()) {
            case 0:
                jl_pt3.setText("-5 Pontos");
                break;
            case 1:
                jl_pt3.setText("0 Pontos");
                break;
            case 2:
                jl_pt3.setText("5 Pontos");
                break;
            case 3:
                jl_pt3.setText("10 Pontos");
                break;
            default:
                break;
        }

    }//GEN-LAST:event_jc_correcao3ItemStateChanged

    private void bt_Voltar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_Voltar2ActionPerformed

        ta_questoes.setEnabledAt(2, false);
        ta_questoes.setEnabledAt(1, true);
        ta_questoes.setSelectedIndex(1);

    }//GEN-LAST:event_bt_Voltar2ActionPerformed

    private void bt_SalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_SalvarActionPerformed

        if (JOptionPane.showConfirmDialog(null, "Deseja Salvar?", "Salvar", 2) == 0) {

            //RESPOSTA DESAFIO 01
            rqd = new Resposta_Questao_Desafio();
            rqdwdao.BuscarRespostaDesafio(e.getIdResposta_Desafio01(), rqd);
            rqd.setNota_Questao_Desafio(jc_correcao1.getSelectedItem().toString());
            rqdwdao.AtualizarResposta(rqd);

            //RESPOSTA DESAFIO 02
            rqd = new Resposta_Questao_Desafio();
            rqdwdao.BuscarRespostaDesafio(e.getIdResposta_Desafio02(), rqd);
            rqd.setNota_Questao_Desafio(jc_correcao2.getSelectedItem().toString());
            rqdwdao.AtualizarResposta(rqd);

            //RESPOSTA DESAFIO 03
            rqd = new Resposta_Questao_Desafio();
            rqdwdao.BuscarRespostaDesafio(e.getIdResposta_Desafio03(), rqd);
            rqd.setNota_Questao_Desafio(jc_correcao3.getSelectedItem().toString());
            rqdwdao.AtualizarResposta(rqd);

            //VERIFICAR PONTUAÇÃO RESPOSTAS DESAFIO
            ContagemPontos cp = new ContagemPontos();
            cp.ContarPontuacaoRespostasDesafio(e);

            JOptionPane.showMessageDialog(null, "Salvo com Sucesso!");
            LimparCampos();
            ListarTabela();
        }
    }//GEN-LAST:event_bt_SalvarActionPerformed

    private void tb_equipeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_equipeMouseClicked

        if (evt.getClickCount() == 2) {
            if(tb_equipe.getValueAt(tb_equipe.getSelectedRow(), 1).toString().equals("EQUIPE NÃO RESPONDEU")){
                JOptionPane.showMessageDialog(null, "Equipe não Respondeu o Desafio!");
            } else {
            if (JOptionPane.showConfirmDialog(null, "Deseja Corrigir as Respostas da Equipe: " + tb_equipe.getValueAt(tb_equipe.getSelectedRow(), 0).toString() + "?", "Salvar", 2) == 0) {
                if (tb_equipe.getSelectedRow() != -1) {
                    PreencherCampos(listaidEquipes.get(tb_equipe.getSelectedRow()));
                    u.liberapainel(jp_questoes1);
                    u.liberapainel(jp_pontuacao1);
                    u.liberapainel(jp_correcao1);
                    u.liberapainel(jp_questoes2);
                    u.liberapainel(jp_pontuacao2);
                    u.liberapainel(jp_correcao2);
                    u.liberapainel(jp_questoes3);
                    u.liberapainel(jp_pontuacao3);
                    u.liberapainel(jp_correcao3);
                }
            }
        }
        }
    }//GEN-LAST:event_tb_equipeMouseClicked

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Tela_CorrigirRespostaDesafio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela_CorrigirRespostaDesafio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela_CorrigirRespostaDesafio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela_CorrigirRespostaDesafio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Tela_CorrigirRespostaDesafio dialog = new Tela_CorrigirRespostaDesafio(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton bt_Cancelar1;
    private javax.swing.JButton bt_Salvar;
    private javax.swing.JButton bt_Voltar1;
    private javax.swing.JButton bt_Voltar2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane34;
    private javax.swing.JScrollPane jScrollPane35;
    private javax.swing.JScrollPane jScrollPane36;
    private javax.swing.JScrollPane jScrollPane37;
    private javax.swing.JScrollPane jScrollPane38;
    private javax.swing.JScrollPane jScrollPane39;
    private javax.swing.JScrollPane jScrollPane53;
    private javax.swing.JScrollPane jScrollPane54;
    private javax.swing.JScrollPane jScrollPane55;
    private javax.swing.JComboBox<String> jc_correcao1;
    private javax.swing.JComboBox<String> jc_correcao2;
    private javax.swing.JComboBox<String> jc_correcao3;
    private javax.swing.JLabel jl_Gabarito1;
    private javax.swing.JLabel jl_Gabarito2;
    private javax.swing.JLabel jl_Gabarito3;
    private javax.swing.JLabel jl_Questao1;
    private javax.swing.JLabel jl_Questao2;
    private javax.swing.JLabel jl_Questao3;
    private javax.swing.JLabel jl_Resposta1;
    private javax.swing.JLabel jl_Resposta2;
    private javax.swing.JLabel jl_Resposta3;
    private javax.swing.JLabel jl_pt1;
    private javax.swing.JLabel jl_pt2;
    private javax.swing.JLabel jl_pt3;
    private javax.swing.JPanel jp_correcao1;
    private javax.swing.JPanel jp_correcao2;
    private javax.swing.JPanel jp_correcao3;
    private javax.swing.JScrollPane jp_equipe1;
    private javax.swing.JScrollPane jp_equipe2;
    private javax.swing.JScrollPane jp_equipe3;
    private javax.swing.JPanel jp_pontuacao1;
    private javax.swing.JPanel jp_pontuacao2;
    private javax.swing.JPanel jp_pontuacao3;
    private javax.swing.JPanel jp_questoes1;
    private javax.swing.JPanel jp_questoes2;
    private javax.swing.JPanel jp_questoes3;
    private javax.swing.JTextArea ta_Gabarito1;
    private javax.swing.JTextArea ta_Gabarito2;
    private javax.swing.JTextArea ta_Gabarito3;
    private javax.swing.JTextArea ta_Questao1;
    private javax.swing.JTextArea ta_Questao2;
    private javax.swing.JTextArea ta_Questao3;
    private javax.swing.JTextArea ta_Resposta1;
    private javax.swing.JTextArea ta_Resposta2;
    private javax.swing.JTextArea ta_Resposta3;
    private javax.swing.JTabbedPane ta_questoes;
    private javax.swing.JTable tb_equipe;
    private javax.swing.JTable tb_equipe1;
    private javax.swing.JTable tb_equipe2;
    // End of variables declaration//GEN-END:variables
}
