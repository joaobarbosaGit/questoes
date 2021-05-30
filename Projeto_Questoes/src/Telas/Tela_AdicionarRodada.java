package Telas;

import Classes.Equipe;
import Classes.Questao;
import Classes.Questao_Desafio;
import Classes.Resposta;
import Classes.Resposta_Questao_Desafio;
import Classes.Rodada;
import Classes.Usuario_Aluno;
import Classes.Usuario_Token;
import Servicos.FormatarDatas;
import Servicos.Utilitarios;
import WebService.EquipeWebDAO;
import WebService.QuestaoWebDAO;
import WebService.Questao_DesafioWebDAO;
import WebService.RespostaWebDAO;
import WebService.Resposta_Questao_DesafioWebDAO;
import WebService.RodadaWebDAO;
import WebService.Usuario_AlunoWebDAO;
import java.awt.Dimension;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class Tela_AdicionarRodada extends javax.swing.JDialog {

    Utilitarios u = new Utilitarios();
    String Data1 = "";
    String Data2 = "";
    String Data3 = "";
    String Data4 = "";
    String Data5 = "";
    String Data6 = "";
    Usuario_Token ut = Usuario_Token.getInstance();
    Rodada r = new Rodada();
    RodadaWebDAO rwdao = new RodadaWebDAO();
    Questao_Desafio qd = new Questao_Desafio();
    Questao_DesafioWebDAO qdwdao = new Questao_DesafioWebDAO();
    QuestaoWebDAO qwdao = new QuestaoWebDAO();
    RespostaWebDAO rewdao = new RespostaWebDAO();
    Resposta_Questao_DesafioWebDAO rqdwdao = new Resposta_Questao_DesafioWebDAO();
    EquipeWebDAO ewdao = new EquipeWebDAO();
    Equipe e = new Equipe();
    Usuario_Aluno ua = new Usuario_Aluno();
    Usuario_AlunoWebDAO uawdao = new Usuario_AlunoWebDAO();

    public Tela_AdicionarRodada(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        tf_MaterialApoio.setEditable(false);
        ta_questoes.setEnabled(false);
        BloquearPaineis();
    }

    public void Avancar() {

        u.bloqueiapainel(p_dados);
        u.liberapainel(painel_qst01);
        u.liberapainel(painel_qst02);
        u.liberapainel(painel_qst03);
        u.liberapainel(painel_qst04);
        u.liberapainel(painel_qst05);
        u.liberapainel(painel_qst06);
        u.liberapainel(painel_qst07);
        u.liberapainel(painel_qst08);
        u.liberapainel(painel_qst09);
        u.liberapainel(painel_qst10);

    }

    public void Voltar() {
        u.liberapainel(p_dados);
        BloquearPaineis();
    }

    public void BloquearPaineis() {
        u.bloqueiapainel(painel_qst01);
        u.bloqueiapainel(painel_qst02);
        u.bloqueiapainel(painel_qst03);
        u.bloqueiapainel(painel_qst04);
        u.bloqueiapainel(painel_qst05);
        u.bloqueiapainel(painel_qst06);
        u.bloqueiapainel(painel_qst07);
        u.bloqueiapainel(painel_qst08);
        u.bloqueiapainel(painel_qst09);
        u.bloqueiapainel(painel_qst10);
    }

    public void AdicionarRodada() {
        Rodada r = new Rodada();
        RodadaWebDAO rdao = new RodadaWebDAO();
    }

    public void LimparCampos() {

        tf_MaterialApoio.setText("");
        tf_QuantidadeTimes.setText("");
        df_Fase1.setDate(null);
        df_Fase2.setDate(null);
        df_Fase3.setDate(null);
        df_Fase4.setDate(null);
        df_Fase5.setDate(null);
        df_Fase6.setDate(null);
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
        ta_questaodesafio01.setText("");
        ta_questaodesafio02.setText("");
        ta_questaodesafio03.setText("");
        ta_questaodesafio04.setText("");
        ta_questaodesafio05.setText("");
        ta_questaodesafio06.setText("");
        ta_questaodesafio07.setText("");
        ta_questaodesafio08.setText("");
        ta_questaodesafio09.setText("");
        ta_questaodesafio10.setText("");
        cb_material.setSelected(false);

    }

    public boolean VerificarDatas() {

        boolean retorno = false;

        if (df_Fase1.getDate().compareTo(df_Fase2.getDate()) == 1) {
            JOptionPane.showMessageDialog(null, "A data da Fase 2 não pode ser antes da data da fase 1");
            df_Fase2.setDate(null);
        } else if (df_Fase1.getDate().compareTo(df_Fase3.getDate()) == 1) {
            JOptionPane.showMessageDialog(null, "A data da Fase 3 não pode ser antes da data da fase 1");
            df_Fase3.setDate(null);
        } else if (df_Fase1.getDate().compareTo(df_Fase4.getDate()) == 1) {
            JOptionPane.showMessageDialog(null, "A data da Fase 4 não pode ser antes da data da fase 1");
            df_Fase4.setDate(null);
        } else if (df_Fase2.getDate().compareTo(df_Fase3.getDate()) == 1) {
            JOptionPane.showMessageDialog(null, "A data da Fase 3 não pode ser antes da data da fase 2");
            df_Fase3.setDate(null);
        } else if (df_Fase2.getDate().compareTo(df_Fase4.getDate()) == 1) {
            JOptionPane.showMessageDialog(null, "A data da Fase 4 não pode ser antes da data da fase 2");
            df_Fase4.setDate(null);
        } else if (df_Fase3.getDate().compareTo(df_Fase4.getDate()) == 1) {
            JOptionPane.showMessageDialog(null, "A data da Fase 4 não pode ser antes da data da fase 3");
            df_Fase4.setDate(null);
        } else {
            retorno = true;
        }

        return retorno;
    }

    public void RecuperarDatas() {

        FormatarDatas fd = new FormatarDatas();
        Data1 = fd.FormatarData(df_Fase1);
        Data2 = fd.FormatarData(df_Fase2);
        Data3 = fd.FormatarData(df_Fase3);
        Data4 = fd.FormatarData(df_Fase4);
        Data5 = fd.FormatarData(df_Fase5);
        Data6 = fd.FormatarData(df_Fase6);

    }

    public void GerarCaixaDialogo() {

        caixaDialogoLoading.setPreferredSize(new Dimension(160, 180));
        Dimension tamanho = caixaDialogoLoading.getPreferredSize();
        Dimension tamanhoframe = getSize();
        java.awt.Point loc = getLocation();
        caixaDialogoLoading.setLocation(
                (tamanhoframe.width - tamanho.width) / 2 + loc.x,
                (tamanhoframe.height - tamanho.height) / 2 + loc.x);
        caixaDialogoLoading.setModal(true);
        caixaDialogoLoading.pack();
        caixaDialogoLoading.setLocationRelativeTo(null);
        caixaDialogoLoading.setVisible(true);

    }

    public ArrayList<Integer> GerarQuestaoDesafio(){
        
        ArrayList<Integer> listaIdRespostasDesafios = new ArrayList<>();
        Random gerador = new Random();
        int idSorteado = gerador.nextInt(10)+1;
        listaIdRespostasDesafios.add(idSorteado);
        
        while(listaIdRespostasDesafios.size()<3){
            idSorteado = gerador.nextInt(10)+1;
            if(!listaIdRespostasDesafios.contains(idSorteado)){
                listaIdRespostasDesafios.add(idSorteado);
            }
        }
        
        return listaIdRespostasDesafios;
    }

    public ArrayList<Integer> AdicionarListaEquipes(int quantidade, int ultimoidequipe, ArrayList<Integer> listaEquipesQueRespostas) {

        ArrayList<Integer> listaEquipes = new ArrayList<>();
        Random gerador = new Random();
        int max = quantidade + ultimoidequipe;
        int min = ultimoidequipe;
        int cont = 1;
        
        while (listaEquipes.size() < quantidade) {
            Integer num = gerador.nextInt(max - min) + min + 1;
            if (!listaEquipes.contains(num)) {
                if (num != cont + ultimoidequipe) {
                    listaEquipes.add(num);
                    cont++;
                } else if (listaEquipes.size() == (quantidade - 1)) {
                    listaEquipes.clear();
                    cont = 1;
                }
            }
        }
        
        int indice = 1;
        for (int a : listaEquipes) {
            int aux = ultimoidequipe + 1;

            for (int b = 0; b < quantidade; b++) {
                if (aux == a) {
                    listaEquipesQueRespostas.set(a - (ultimoidequipe + 1), indice + ultimoidequipe);
                    indice++;
                }
                aux++;
            }
        }
        return listaEquipes;
    }

    public ArrayList<Integer> CriarlistaEquipesQueRespostas(int quantidade, int ultimoidequipe) {

        ArrayList<Integer> listaEquipes = new ArrayList<>();

        for (int i = 0; i < quantidade; i++) {
            listaEquipes.add((ultimoidequipe + i) + 1);
        }
        return listaEquipes;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        caixaDialogoLoading = new javax.swing.JDialog();
        jLabel2 = new javax.swing.JLabel();
        p_dados = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        tf_MaterialApoio = new javax.swing.JTextField();
        bt_Selecionar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        tf_QuantidadeTimes = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        df_Fase1 = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        df_Fase2 = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        df_Fase3 = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        df_Fase4 = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        df_Fase5 = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        df_Fase6 = new com.toedter.calendar.JDateChooser();
        bt_cancelar = new javax.swing.JButton();
        bt_avancar = new javax.swing.JButton();
        cb_material = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jSeparator13 = new javax.swing.JSeparator();
        ta_questoes = new javax.swing.JTabbedPane();
        painel_qst01 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        ta_questaodesafio01 = new javax.swing.JTextArea();
        bt_voltar01 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        ta_gabarito01 = new javax.swing.JTextArea();
        jSeparator4 = new javax.swing.JSeparator();
        bt_avançar01 = new javax.swing.JButton();
        painel_qst02 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        ta_questaodesafio02 = new javax.swing.JTextArea();
        bt_voltar02 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        ta_gabarito02 = new javax.swing.JTextArea();
        jSeparator5 = new javax.swing.JSeparator();
        bt_avançar02 = new javax.swing.JButton();
        painel_qst03 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        ta_questaodesafio03 = new javax.swing.JTextArea();
        bt_voltar03 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        ta_gabarito03 = new javax.swing.JTextArea();
        jSeparator6 = new javax.swing.JSeparator();
        bt_avançar03 = new javax.swing.JButton();
        painel_qst04 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        ta_questaodesafio04 = new javax.swing.JTextArea();
        bt_voltar04 = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        ta_gabarito04 = new javax.swing.JTextArea();
        jSeparator7 = new javax.swing.JSeparator();
        bt_avançar04 = new javax.swing.JButton();
        painel_qst05 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        ta_questaodesafio05 = new javax.swing.JTextArea();
        bt_voltar05 = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        jScrollPane12 = new javax.swing.JScrollPane();
        ta_gabarito05 = new javax.swing.JTextArea();
        jSeparator8 = new javax.swing.JSeparator();
        bt_avançar05 = new javax.swing.JButton();
        painel_qst06 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jScrollPane13 = new javax.swing.JScrollPane();
        ta_questaodesafio06 = new javax.swing.JTextArea();
        bt_voltar06 = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        jScrollPane14 = new javax.swing.JScrollPane();
        ta_gabarito06 = new javax.swing.JTextArea();
        jSeparator9 = new javax.swing.JSeparator();
        bt_avançar06 = new javax.swing.JButton();
        painel_qst07 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jScrollPane15 = new javax.swing.JScrollPane();
        ta_questaodesafio07 = new javax.swing.JTextArea();
        bt_voltar07 = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        jScrollPane16 = new javax.swing.JScrollPane();
        ta_gabarito07 = new javax.swing.JTextArea();
        jSeparator10 = new javax.swing.JSeparator();
        bt_avançar07 = new javax.swing.JButton();
        painel_qst08 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jScrollPane17 = new javax.swing.JScrollPane();
        ta_questaodesafio08 = new javax.swing.JTextArea();
        bt_voltar08 = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        jScrollPane18 = new javax.swing.JScrollPane();
        ta_gabarito08 = new javax.swing.JTextArea();
        jSeparator11 = new javax.swing.JSeparator();
        bt_avançar08 = new javax.swing.JButton();
        painel_qst09 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jScrollPane19 = new javax.swing.JScrollPane();
        ta_questaodesafio09 = new javax.swing.JTextArea();
        bt_voltar09 = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        jScrollPane20 = new javax.swing.JScrollPane();
        ta_gabarito09 = new javax.swing.JTextArea();
        jSeparator12 = new javax.swing.JSeparator();
        bt_avançar09 = new javax.swing.JButton();
        painel_qst10 = new javax.swing.JPanel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ta_questaodesafio10 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        ta_gabarito10 = new javax.swing.JTextArea();
        bt_salvardados = new javax.swing.JButton();
        bt_voltar10 = new javax.swing.JButton();

        caixaDialogoLoading.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        caixaDialogoLoading.setModalExclusionType(java.awt.Dialog.ModalExclusionType.TOOLKIT_EXCLUDE);
        caixaDialogoLoading.setModalityType(java.awt.Dialog.ModalityType.TOOLKIT_MODAL);
        caixaDialogoLoading.setResizable(false);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/loading.gif"))); // NOI18N

        javax.swing.GroupLayout caixaDialogoLoadingLayout = new javax.swing.GroupLayout(caixaDialogoLoading.getContentPane());
        caixaDialogoLoading.getContentPane().setLayout(caixaDialogoLoadingLayout);
        caixaDialogoLoadingLayout.setHorizontalGroup(
            caixaDialogoLoadingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2)
        );
        caixaDialogoLoadingLayout.setVerticalGroup(
            caixaDialogoLoadingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        p_dados.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        bt_Selecionar.setText("SELECIONAR");
        bt_Selecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_SelecionarActionPerformed(evt);
            }
        });

        jLabel3.setText("Quantidade de Times:");

        tf_QuantidadeTimes.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        jLabel4.setText("Elaboração das Questões:");

        jLabel5.setText("Respostas das Questões:");

        jLabel6.setText("Resposta do Desafio:");

        jLabel7.setText("Correção das Respostas:");

        jLabel8.setText("Recurso:");

        jLabel9.setText("Ranking:");

        bt_cancelar.setText("CANCELAR");
        bt_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cancelarActionPerformed(evt);
            }
        });

        bt_avancar.setText("AVANÇAR");
        bt_avancar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_avancarActionPerformed(evt);
            }
        });

        jLabel1.setText("Material de Apoio:");

        jSeparator13.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout p_dadosLayout = new javax.swing.GroupLayout(p_dados);
        p_dados.setLayout(p_dadosLayout);
        p_dadosLayout.setHorizontalGroup(
            p_dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_dadosLayout.createSequentialGroup()
                .addGroup(p_dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(p_dadosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(p_dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(p_dadosLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(p_dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(tf_MaterialApoio, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(p_dadosLayout.createSequentialGroup()
                                        .addGap(19, 19, 19)
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cb_material)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(bt_Selecionar)))
                                .addGap(55, 55, 55)
                                .addComponent(jSeparator13, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(p_dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(p_dadosLayout.createSequentialGroup()
                                        .addGap(56, 56, 56)
                                        .addComponent(jLabel3))
                                    .addGroup(p_dadosLayout.createSequentialGroup()
                                        .addGap(36, 36, 36)
                                        .addComponent(bt_cancelar)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(p_dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tf_QuantidadeTimes, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(p_dadosLayout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(bt_avancar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jSeparator1)))
                    .addGroup(p_dadosLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(p_dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(p_dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(df_Fase3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(df_Fase2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(df_Fase1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(p_dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(p_dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel7)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, p_dadosLayout.createSequentialGroup()
                                    .addGap(78, 78, 78)
                                    .addComponent(jLabel8)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, p_dadosLayout.createSequentialGroup()
                                .addGap(79, 79, 79)
                                .addComponent(jLabel9)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(p_dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(df_Fase4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(df_Fase5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(df_Fase6, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(57, 57, 57)))
                .addContainerGap())
        );
        p_dadosLayout.setVerticalGroup(
            p_dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_dadosLayout.createSequentialGroup()
                .addGroup(p_dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(p_dadosLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(p_dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(tf_QuantidadeTimes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(p_dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bt_avancar)
                            .addComponent(bt_cancelar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(p_dadosLayout.createSequentialGroup()
                        .addGroup(p_dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(p_dadosLayout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(tf_MaterialApoio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(p_dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cb_material, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(bt_Selecionar)))
                            .addGroup(p_dadosLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jSeparator13, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(11, 11, 11)))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addGroup(p_dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(df_Fase1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(p_dadosLayout.createSequentialGroup()
                        .addGroup(p_dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(df_Fase4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(p_dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(p_dadosLayout.createSequentialGroup()
                                .addGroup(p_dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(df_Fase2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                                .addGroup(p_dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(df_Fase3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(p_dadosLayout.createSequentialGroup()
                                .addGroup(p_dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(df_Fase5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(p_dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(df_Fase6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );

        ta_questoes.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        ta_questoes.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N

        painel_qst01.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel12.setText("Questão Desafio 01:");

        ta_questaodesafio01.setColumns(20);
        ta_questaodesafio01.setRows(5);
        jScrollPane3.setViewportView(ta_questaodesafio01);

        bt_voltar01.setText("VOLTAR");
        bt_voltar01.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_voltar01ActionPerformed(evt);
            }
        });

        jLabel13.setText("Gabarito:");

        ta_gabarito01.setColumns(20);
        ta_gabarito01.setRows(5);
        jScrollPane4.setViewportView(ta_gabarito01);

        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);

        bt_avançar01.setText("AVANÇAR");
        bt_avançar01.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_avançar01ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painel_qst01Layout = new javax.swing.GroupLayout(painel_qst01);
        painel_qst01.setLayout(painel_qst01Layout);
        painel_qst01Layout.setHorizontalGroup(
            painel_qst01Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_qst01Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_qst01Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(painel_qst01Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_voltar01, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painel_qst01Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(painel_qst01Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_avançar01))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        painel_qst01Layout.setVerticalGroup(
            painel_qst01Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_qst01Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_qst01Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(bt_avançar01)
                    .addComponent(bt_voltar01))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painel_qst01Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator4)
                    .addComponent(jScrollPane3)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE))
                .addContainerGap())
        );

        ta_questoes.addTab("QST 01", painel_qst01);

        painel_qst02.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel14.setText("Questão Desafio 02:");

        ta_questaodesafio02.setColumns(20);
        ta_questaodesafio02.setRows(5);
        jScrollPane5.setViewportView(ta_questaodesafio02);

        bt_voltar02.setText("VOLTAR");
        bt_voltar02.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_voltar02ActionPerformed(evt);
            }
        });

        jLabel15.setText("Gabarito:");

        ta_gabarito02.setColumns(20);
        ta_gabarito02.setRows(5);
        jScrollPane6.setViewportView(ta_gabarito02);

        jSeparator5.setOrientation(javax.swing.SwingConstants.VERTICAL);

        bt_avançar02.setText("AVANÇAR");
        bt_avançar02.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_avançar02ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painel_qst02Layout = new javax.swing.GroupLayout(painel_qst02);
        painel_qst02.setLayout(painel_qst02Layout);
        painel_qst02Layout.setHorizontalGroup(
            painel_qst02Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_qst02Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_qst02Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(painel_qst02Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_voltar02, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painel_qst02Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(painel_qst02Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_avançar02))
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        painel_qst02Layout.setVerticalGroup(
            painel_qst02Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_qst02Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_qst02Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15)
                    .addComponent(bt_avançar02)
                    .addComponent(bt_voltar02))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painel_qst02Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator5)
                    .addComponent(jScrollPane5)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE))
                .addContainerGap())
        );

        ta_questoes.addTab("QST 02", painel_qst02);

        painel_qst03.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel16.setText("Questão Desafio 03:");

        ta_questaodesafio03.setColumns(20);
        ta_questaodesafio03.setRows(5);
        jScrollPane7.setViewportView(ta_questaodesafio03);

        bt_voltar03.setText("VOLTAR");
        bt_voltar03.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_voltar03ActionPerformed(evt);
            }
        });

        jLabel17.setText("Gabarito:");

        ta_gabarito03.setColumns(20);
        ta_gabarito03.setRows(5);
        jScrollPane8.setViewportView(ta_gabarito03);

        jSeparator6.setOrientation(javax.swing.SwingConstants.VERTICAL);

        bt_avançar03.setText("AVANÇAR");
        bt_avançar03.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_avançar03ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painel_qst03Layout = new javax.swing.GroupLayout(painel_qst03);
        painel_qst03.setLayout(painel_qst03Layout);
        painel_qst03Layout.setHorizontalGroup(
            painel_qst03Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_qst03Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_qst03Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(painel_qst03Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_voltar03, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painel_qst03Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(painel_qst03Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_avançar03))
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        painel_qst03Layout.setVerticalGroup(
            painel_qst03Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_qst03Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_qst03Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17)
                    .addComponent(bt_avançar03)
                    .addComponent(bt_voltar03))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painel_qst03Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator6)
                    .addComponent(jScrollPane7)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE))
                .addContainerGap())
        );

        ta_questoes.addTab("QST 03", painel_qst03);

        painel_qst04.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel18.setText("Questão Desafio 04:");

        ta_questaodesafio04.setColumns(20);
        ta_questaodesafio04.setRows(5);
        jScrollPane9.setViewportView(ta_questaodesafio04);

        bt_voltar04.setText("VOLTAR");
        bt_voltar04.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_voltar04ActionPerformed(evt);
            }
        });

        jLabel19.setText("Gabarito:");

        ta_gabarito04.setColumns(20);
        ta_gabarito04.setRows(5);
        jScrollPane10.setViewportView(ta_gabarito04);

        jSeparator7.setOrientation(javax.swing.SwingConstants.VERTICAL);

        bt_avançar04.setText("AVANÇAR");
        bt_avançar04.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_avançar04ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painel_qst04Layout = new javax.swing.GroupLayout(painel_qst04);
        painel_qst04.setLayout(painel_qst04Layout);
        painel_qst04Layout.setHorizontalGroup(
            painel_qst04Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_qst04Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_qst04Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(painel_qst04Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_voltar04, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painel_qst04Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(painel_qst04Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_avançar04))
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        painel_qst04Layout.setVerticalGroup(
            painel_qst04Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_qst04Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_qst04Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19)
                    .addComponent(bt_avançar04)
                    .addComponent(bt_voltar04))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painel_qst04Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator7)
                    .addComponent(jScrollPane9)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE))
                .addContainerGap())
        );

        ta_questoes.addTab("QST 04", painel_qst04);

        painel_qst05.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel20.setText("Questão Desafio 05:");

        ta_questaodesafio05.setColumns(20);
        ta_questaodesafio05.setRows(5);
        jScrollPane11.setViewportView(ta_questaodesafio05);

        bt_voltar05.setText("VOLTAR");
        bt_voltar05.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_voltar05ActionPerformed(evt);
            }
        });

        jLabel21.setText("Gabarito:");

        ta_gabarito05.setColumns(20);
        ta_gabarito05.setRows(5);
        jScrollPane12.setViewportView(ta_gabarito05);

        jSeparator8.setOrientation(javax.swing.SwingConstants.VERTICAL);

        bt_avançar05.setText("AVANÇAR");
        bt_avançar05.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_avançar05ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painel_qst05Layout = new javax.swing.GroupLayout(painel_qst05);
        painel_qst05.setLayout(painel_qst05Layout);
        painel_qst05Layout.setHorizontalGroup(
            painel_qst05Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_qst05Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_qst05Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(painel_qst05Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_voltar05, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painel_qst05Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(painel_qst05Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_avançar05))
                    .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        painel_qst05Layout.setVerticalGroup(
            painel_qst05Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_qst05Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_qst05Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21)
                    .addComponent(bt_avançar05)
                    .addComponent(bt_voltar05))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painel_qst05Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator8)
                    .addComponent(jScrollPane11)
                    .addComponent(jScrollPane12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE))
                .addContainerGap())
        );

        ta_questoes.addTab("QST 05", painel_qst05);

        painel_qst06.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel22.setText("Questão Desafio 06:");

        ta_questaodesafio06.setColumns(20);
        ta_questaodesafio06.setRows(5);
        jScrollPane13.setViewportView(ta_questaodesafio06);

        bt_voltar06.setText("VOLTAR");
        bt_voltar06.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_voltar06ActionPerformed(evt);
            }
        });

        jLabel23.setText("Gabarito:");

        ta_gabarito06.setColumns(20);
        ta_gabarito06.setRows(5);
        jScrollPane14.setViewportView(ta_gabarito06);

        jSeparator9.setOrientation(javax.swing.SwingConstants.VERTICAL);

        bt_avançar06.setText("AVANÇAR");
        bt_avançar06.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_avançar06ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painel_qst06Layout = new javax.swing.GroupLayout(painel_qst06);
        painel_qst06.setLayout(painel_qst06Layout);
        painel_qst06Layout.setHorizontalGroup(
            painel_qst06Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_qst06Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_qst06Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(painel_qst06Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_voltar06, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painel_qst06Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(painel_qst06Layout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_avançar06))
                    .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        painel_qst06Layout.setVerticalGroup(
            painel_qst06Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_qst06Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_qst06Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(jLabel23)
                    .addComponent(bt_avançar06)
                    .addComponent(bt_voltar06))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painel_qst06Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator9)
                    .addComponent(jScrollPane13)
                    .addComponent(jScrollPane14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE))
                .addContainerGap())
        );

        ta_questoes.addTab("QST 06", painel_qst06);

        painel_qst07.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel24.setText("Questão Desafio 07:");

        ta_questaodesafio07.setColumns(20);
        ta_questaodesafio07.setRows(5);
        jScrollPane15.setViewportView(ta_questaodesafio07);

        bt_voltar07.setText("VOLTAR");
        bt_voltar07.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_voltar07ActionPerformed(evt);
            }
        });

        jLabel25.setText("Gabarito:");

        ta_gabarito07.setColumns(20);
        ta_gabarito07.setRows(5);
        jScrollPane16.setViewportView(ta_gabarito07);

        jSeparator10.setOrientation(javax.swing.SwingConstants.VERTICAL);

        bt_avançar07.setText("AVANÇAR");
        bt_avançar07.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_avançar07ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painel_qst07Layout = new javax.swing.GroupLayout(painel_qst07);
        painel_qst07.setLayout(painel_qst07Layout);
        painel_qst07Layout.setHorizontalGroup(
            painel_qst07Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_qst07Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_qst07Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(painel_qst07Layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_voltar07, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painel_qst07Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(painel_qst07Layout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_avançar07))
                    .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        painel_qst07Layout.setVerticalGroup(
            painel_qst07Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_qst07Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_qst07Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(jLabel25)
                    .addComponent(bt_avançar07)
                    .addComponent(bt_voltar07))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painel_qst07Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator10)
                    .addComponent(jScrollPane15)
                    .addComponent(jScrollPane16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE))
                .addContainerGap())
        );

        ta_questoes.addTab("QST 07", painel_qst07);

        painel_qst08.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel26.setText("Questão Desafio 08:");

        ta_questaodesafio08.setColumns(20);
        ta_questaodesafio08.setRows(5);
        jScrollPane17.setViewportView(ta_questaodesafio08);

        bt_voltar08.setText("VOLTAR");
        bt_voltar08.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_voltar08ActionPerformed(evt);
            }
        });

        jLabel27.setText("Gabarito:");

        ta_gabarito08.setColumns(20);
        ta_gabarito08.setRows(5);
        jScrollPane18.setViewportView(ta_gabarito08);

        jSeparator11.setOrientation(javax.swing.SwingConstants.VERTICAL);

        bt_avançar08.setText("AVANÇAR");
        bt_avançar08.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_avançar08ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painel_qst08Layout = new javax.swing.GroupLayout(painel_qst08);
        painel_qst08.setLayout(painel_qst08Layout);
        painel_qst08Layout.setHorizontalGroup(
            painel_qst08Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_qst08Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_qst08Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(painel_qst08Layout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_voltar08, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painel_qst08Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(painel_qst08Layout.createSequentialGroup()
                        .addComponent(jLabel27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_avançar08))
                    .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        painel_qst08Layout.setVerticalGroup(
            painel_qst08Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_qst08Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_qst08Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(jLabel27)
                    .addComponent(bt_avançar08)
                    .addComponent(bt_voltar08))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painel_qst08Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator11)
                    .addComponent(jScrollPane17)
                    .addComponent(jScrollPane18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE))
                .addContainerGap())
        );

        ta_questoes.addTab("QST 08", painel_qst08);

        painel_qst09.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel28.setText("Questão Desafio 09:");

        ta_questaodesafio09.setColumns(20);
        ta_questaodesafio09.setRows(5);
        jScrollPane19.setViewportView(ta_questaodesafio09);

        bt_voltar09.setText("VOLTAR");
        bt_voltar09.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_voltar09ActionPerformed(evt);
            }
        });

        jLabel29.setText("Gabarito:");

        ta_gabarito09.setColumns(20);
        ta_gabarito09.setRows(5);
        jScrollPane20.setViewportView(ta_gabarito09);

        jSeparator12.setOrientation(javax.swing.SwingConstants.VERTICAL);

        bt_avançar09.setText("AVANÇAR");
        bt_avançar09.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_avançar09ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painel_qst09Layout = new javax.swing.GroupLayout(painel_qst09);
        painel_qst09.setLayout(painel_qst09Layout);
        painel_qst09Layout.setHorizontalGroup(
            painel_qst09Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_qst09Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_qst09Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(painel_qst09Layout.createSequentialGroup()
                        .addComponent(jLabel28)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_voltar09, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane19, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator12, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painel_qst09Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(painel_qst09Layout.createSequentialGroup()
                        .addComponent(jLabel29)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_avançar09))
                    .addComponent(jScrollPane20, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        painel_qst09Layout.setVerticalGroup(
            painel_qst09Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_qst09Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_qst09Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(jLabel29)
                    .addComponent(bt_avançar09)
                    .addComponent(bt_voltar09))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painel_qst09Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator12)
                    .addComponent(jScrollPane19)
                    .addComponent(jScrollPane20, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE))
                .addContainerGap())
        );

        ta_questoes.addTab("QST 09", painel_qst09);

        painel_qst10.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel10.setText("Questão Desafio 10:");

        jLabel11.setText("Gabarito:");

        ta_questaodesafio10.setColumns(20);
        ta_questaodesafio10.setRows(5);
        jScrollPane1.setViewportView(ta_questaodesafio10);

        ta_gabarito10.setColumns(20);
        ta_gabarito10.setRows(5);
        jScrollPane2.setViewportView(ta_gabarito10);

        bt_salvardados.setText("SALVAR");
        bt_salvardados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_salvardadosActionPerformed(evt);
            }
        });

        bt_voltar10.setText("VOLTAR");
        bt_voltar10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_voltar10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painel_qst10Layout = new javax.swing.GroupLayout(painel_qst10);
        painel_qst10.setLayout(painel_qst10Layout);
        painel_qst10Layout.setHorizontalGroup(
            painel_qst10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_qst10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_qst10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(painel_qst10Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_voltar10, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painel_qst10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(painel_qst10Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_salvardados, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        painel_qst10Layout.setVerticalGroup(
            painel_qst10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_qst10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_qst10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(bt_salvardados)
                    .addComponent(bt_voltar10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painel_qst10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator3)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE))
                .addContainerGap())
        );

        ta_questoes.addTab("QST 10", painel_qst10);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ta_questoes)
                    .addComponent(p_dados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(p_dados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ta_questoes, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bt_avancarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_avancarActionPerformed

        if (tf_QuantidadeTimes.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Informe a Quantidade de Times!");
        } else if (df_Fase1.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Informe a Data Limite da Fase 1!");
        } else if (df_Fase2.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Informe a Data Limite da Fase 2!");
        } else if (df_Fase3.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Informe a Data Limite da Fase 3!");
        } else if (df_Fase4.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Informe a Data Limite da Fase 4!");
        } else if (df_Fase5.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Informe a Data Limite da Fase 5!");
        } else if (df_Fase6.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Informe a Data Limite da Fase 6!");
        } else {

            if (cb_material.isSelected()) {
                if (tf_MaterialApoio.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Material de Apoio não selecionado!");
                } else {
                    Avancar();
                }
            } else {
                Avancar();
            }

        }
    }//GEN-LAST:event_bt_avancarActionPerformed

    private void bt_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cancelarActionPerformed

//            if (JOptionPane.showConfirmDialog(null, "Deseja Cancelar?", "Cancelar", 2) == 0) {
//                LimparCampos();
//                dispose();
//            }

 //DEFINIR EQUIPES RESPOSTA

                ArrayList<Integer> listaEquipesQueRespostas = CriarlistaEquipesQueRespostas(Integer.parseInt(tf_QuantidadeTimes.getText()), ewdao.BuscarUltimoId());
                ArrayList<Integer> listaEquipesParaRespostas = AdicionarListaEquipes(Integer.parseInt(tf_QuantidadeTimes.getText()), ewdao.BuscarUltimoId(), listaEquipesQueRespostas);
               

//ADICIONAR EQUIPES
                int cont = 1;

                while (listaEquipesParaRespostas.size() > 0) {

                    System.out.println("Adicionando a Equipe: "+listaEquipesParaRespostas.size());
                    System.out.println("------------------------------");
                    e.setEquipe_Para_Resposta(listaEquipesParaRespostas.get(0));
                    e.setEquipe_Que_Resposta(listaEquipesQueRespostas.get(0));
                    e.setNomeEquipe("Equipe " + cont);
                   
                    //PREENCHER EQUPES
                    ArrayList<Integer> listaQuestoes = new ArrayList<>();
                    ArrayList<Integer> listaRespostas = new ArrayList<>();
                    ArrayList<Integer> listaRespostasQuestaoDesafio = new ArrayList<>();
                    ArrayList<Integer> listaIdQuestaoDesafios = GerarQuestaoDesafio();
                    
                    for (int i = 0; i < 10; i++) {

                        //ADCIONAR QUESTÕES
                        Questao q = new Questao();
                        q.setCorpo_Questao("SEM CONTEUDO");
                        q.setGabarito("SEM CONTEUDO");
                        q.setQualificacao_Questao("SEM CONTEUDO");
                        qwdao.AdicionaQuestao(q);
                        listaQuestoes.add(qwdao.BuscarUltimoId());

                        //ADICIONAR RESPOSTA
                        Resposta re = new Resposta();
                        re.setCorpo_Resposta("SEM CONTEUDO");
                        re.setNota_Resposta("SEM CONTEUDO");
                        rewdao.AdicionaResposta(re);
                        listaRespostas.add(rewdao.BuscarUltimoId());

                    }
                    
                    //ADICIONAR RESPOSTA-DESAFIO 01
                        Resposta_Questao_Desafio rqd = new Resposta_Questao_Desafio();
                        rqd.setCorpo_Resposta("SEM CONTEUDO");
                        rqd.setNota_Questao_Desafio("SEM CONTEUDO");
                        rqdwdao.AdicionaRespostaQuestaoDesafio(rqd);
                        listaRespostasQuestaoDesafio.add(rqdwdao.BuscarUltimoId());
                    
                        
                    //ADICIONAR RESPOSTA-DESAFIO 02
                        rqd = new Resposta_Questao_Desafio();
                        rqd.setCorpo_Resposta("SEM CONTEUDO");
                        rqd.setNota_Questao_Desafio("SEM CONTEUDO");
                        rqdwdao.AdicionaRespostaQuestaoDesafio(rqd);
                        listaRespostasQuestaoDesafio.add(rqdwdao.BuscarUltimoId());
                        
                    //ADICIONAR RESPOSTA-DESAFIO 03
                        rqd = new Resposta_Questao_Desafio();
                        rqd.setCorpo_Resposta("SEM CONTEUDO");
                        rqd.setNota_Questao_Desafio("SEM CONTEUDO");
                        rqdwdao.AdicionaRespostaQuestaoDesafio(rqd);
                        listaRespostasQuestaoDesafio.add(rqdwdao.BuscarUltimoId());    
                    
                    //LER ARRAYS
                    e.setIdQuestao_Equipe01(listaQuestoes.get(0));
                    e.setIdQuestao_Equipe02(listaQuestoes.get(1));
                    e.setIdQuestao_Equipe03(listaQuestoes.get(2));
                    e.setIdQuestao_Equipe04(listaQuestoes.get(3));
                    e.setIdQuestao_Equipe05(listaQuestoes.get(4));
                    e.setIdQuestao_Equipe06(listaQuestoes.get(5));
                    e.setIdQuestao_Equipe07(listaQuestoes.get(6));
                    e.setIdQuestao_Equipe08(listaQuestoes.get(7));
                    e.setIdQuestao_Equipe09(listaQuestoes.get(8));
                    e.setIdQuestao_Equipe10(listaQuestoes.get(9));
                    e.setIdResposta_Equipe01(listaRespostas.get(0));
                    e.setIdResposta_Equipe02(listaRespostas.get(1));
                    e.setIdResposta_Equipe03(listaRespostas.get(2));
                    e.setIdResposta_Equipe04(listaRespostas.get(3));
                    e.setIdResposta_Equipe05(listaRespostas.get(4));
                    e.setIdResposta_Equipe06(listaRespostas.get(5));
                    e.setIdResposta_Equipe07(listaRespostas.get(6));
                    e.setIdResposta_Equipe08(listaRespostas.get(7));
                    e.setIdResposta_Equipe09(listaRespostas.get(8));
                    e.setIdResposta_Equipe10(listaRespostas.get(9));
                    e.setIdQuestao_Desafio01(listaIdQuestaoDesafios.get(0));
                    e.setIdQuestao_Desafio02(listaIdQuestaoDesafios.get(1));
                    e.setIdQuestao_Desafio03(listaIdQuestaoDesafios.get(2));
                    e.setIdResposta_Desafio01(listaRespostasQuestaoDesafio.get(0));
                    e.setIdResposta_Desafio02(listaRespostasQuestaoDesafio.get(1));
                    e.setIdResposta_Desafio03(listaRespostasQuestaoDesafio.get(2));
                    ewdao.AdicionaEquipe(e);
                    listaEquipesParaRespostas.remove(0);
                    listaEquipesQueRespostas.remove(0);

                    //ADICIONAR USUARIO ALUNO
                    ua.setEquipe_idEquipe(ewdao.BuscarUltimoId());
                    ua.setRodada_idRodada(rwdao.BuscarUltimoId());
                    ua.setUsuario("Equipe " + cont);
                    ua.setSenha("admin");
                    ua.setEmail("admin@equipe" + cont + "_rodada" + ua.getRodada_idRodada());
                    uawdao.AdicionarUsuarioAluno(ua);
                    cont++;
                }
                JOptionPane.showMessageDialog(null, "Salvo com Sucesso!");
 
    }//GEN-LAST:event_bt_cancelarActionPerformed

    private void bt_SelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_SelecionarActionPerformed
        JFileChooser arquivos = new JFileChooser("C:\\Users");
        UIManager.put("FileChooser.openButtonText", "Selecionar");
        SwingUtilities.updateComponentTreeUI(arquivos);
        int escolha = arquivos.showOpenDialog(this);
        if (escolha == 0) {
            File file = arquivos.getSelectedFile();
            tf_MaterialApoio.setText(file.getName());
        }
    }//GEN-LAST:event_bt_SelecionarActionPerformed

    private void bt_voltar01ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_voltar01ActionPerformed
        Voltar();
    }//GEN-LAST:event_bt_voltar01ActionPerformed

    private void bt_avançar01ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_avançar01ActionPerformed
        if (!ta_questaodesafio01.getText().equals("") && !ta_gabarito01.getText().equals("")) {
            ta_questoes.setEnabledAt(0, false);
            ta_questoes.setEnabledAt(1, true);
            ta_questoes.setSelectedIndex(1);
        } else {
            JOptionPane.showMessageDialog(null, "Questão 01 ou Gabarito 01, não podem estar vazio!");
        }
    }//GEN-LAST:event_bt_avançar01ActionPerformed

    private void bt_avançar02ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_avançar02ActionPerformed
        if (!ta_questaodesafio02.getText().equals("") && !ta_gabarito02.getText().equals("")) {
            ta_questoes.setEnabledAt(1, false);
            ta_questoes.setEnabledAt(2, true);
            ta_questoes.setSelectedIndex(2);
        } else {
            JOptionPane.showMessageDialog(null, "Questão 02 ou Gabarito 02, não podem estar vazio!");
        }
    }//GEN-LAST:event_bt_avançar02ActionPerformed

    private void bt_avançar03ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_avançar03ActionPerformed
        if (!ta_questaodesafio03.getText().equals("") && !ta_gabarito03.getText().equals("")) {
            ta_questoes.setEnabledAt(2, false);
            ta_questoes.setEnabledAt(2, true);
            ta_questoes.setSelectedIndex(3);
        } else {
            JOptionPane.showMessageDialog(null, "Questão 03 ou Gabarito 03, não podem estar vazio!");
        }
    }//GEN-LAST:event_bt_avançar03ActionPerformed

    private void bt_avançar04ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_avançar04ActionPerformed
        if (!ta_questaodesafio04.getText().equals("") && !ta_gabarito04.getText().equals("")) {
            ta_questoes.setEnabledAt(3, false);
            ta_questoes.setEnabledAt(3, true);
            ta_questoes.setSelectedIndex(4);
        } else {
            JOptionPane.showMessageDialog(null, "Questão 04 ou Gabarito 04, não podem estar vazio!");
        }
    }//GEN-LAST:event_bt_avançar04ActionPerformed

    private void bt_avançar05ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_avançar05ActionPerformed
        if (!ta_questaodesafio05.getText().equals("") && !ta_gabarito05.getText().equals("")) {
            ta_questoes.setEnabledAt(4, false);
            ta_questoes.setEnabledAt(4, true);
            ta_questoes.setSelectedIndex(5);
        } else {
            JOptionPane.showMessageDialog(null, "Questão 05 ou Gabarito 05, não podem estar vazio!");
        }
    }//GEN-LAST:event_bt_avançar05ActionPerformed

    private void bt_avançar06ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_avançar06ActionPerformed
        if (!ta_questaodesafio06.getText().equals("") && !ta_gabarito06.getText().equals("")) {
            ta_questoes.setEnabledAt(5, false);
            ta_questoes.setEnabledAt(5, true);
            ta_questoes.setSelectedIndex(6);
        } else {
            JOptionPane.showMessageDialog(null, "Questão 06 ou Gabarito 06, não podem estar vazio!");
        }
    }//GEN-LAST:event_bt_avançar06ActionPerformed

    private void bt_avançar07ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_avançar07ActionPerformed
        if (!ta_questaodesafio07.getText().equals("") && !ta_gabarito07.getText().equals("")) {
            ta_questoes.setEnabledAt(6, false);
            ta_questoes.setEnabledAt(6, true);
            ta_questoes.setSelectedIndex(7);
        } else {
            JOptionPane.showMessageDialog(null, "Questão 07 ou Gabarito 07, não podem estar vazio!");
        }
    }//GEN-LAST:event_bt_avançar07ActionPerformed

    private void bt_avançar08ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_avançar08ActionPerformed
        if (!ta_questaodesafio08.getText().equals("") && !ta_gabarito08.getText().equals("")) {
            ta_questoes.setEnabledAt(7, false);
            ta_questoes.setEnabledAt(7, true);
            ta_questoes.setSelectedIndex(8);
        } else {
            JOptionPane.showMessageDialog(null, "Questão 08 ou Gabarito 08, não podem estar vazio!");
        }
    }//GEN-LAST:event_bt_avançar08ActionPerformed

    private void bt_avançar09ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_avançar09ActionPerformed
        if (!ta_questaodesafio09.getText().equals("") && !ta_gabarito09.getText().equals("")) {
            ta_questoes.setEnabledAt(8, false);
            ta_questoes.setEnabledAt(8, true);
            ta_questoes.setSelectedIndex(9);
        } else {
            JOptionPane.showMessageDialog(null, "Questão 09 ou Gabarito 09, não podem estar vazio!");
        }
    }//GEN-LAST:event_bt_avançar09ActionPerformed

    private void bt_voltar02ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_voltar02ActionPerformed
        ta_questoes.setEnabledAt(1, false);
        ta_questoes.setEnabledAt(0, true);
        ta_questoes.setSelectedIndex(0);
    }//GEN-LAST:event_bt_voltar02ActionPerformed

    private void bt_voltar03ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_voltar03ActionPerformed
        ta_questoes.setEnabledAt(2, false);
        ta_questoes.setEnabledAt(1, true);
        ta_questoes.setSelectedIndex(1);
    }//GEN-LAST:event_bt_voltar03ActionPerformed

    private void bt_voltar04ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_voltar04ActionPerformed
        ta_questoes.setEnabledAt(3, false);
        ta_questoes.setEnabledAt(2, true);
        ta_questoes.setSelectedIndex(2);
    }//GEN-LAST:event_bt_voltar04ActionPerformed

    private void bt_voltar05ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_voltar05ActionPerformed
        ta_questoes.setEnabledAt(4, false);
        ta_questoes.setEnabledAt(3, true);
        ta_questoes.setSelectedIndex(3);
    }//GEN-LAST:event_bt_voltar05ActionPerformed

    private void bt_voltar06ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_voltar06ActionPerformed
        ta_questoes.setEnabledAt(5, false);
        ta_questoes.setEnabledAt(4, true);
        ta_questoes.setSelectedIndex(4);
    }//GEN-LAST:event_bt_voltar06ActionPerformed

    private void bt_voltar07ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_voltar07ActionPerformed
        ta_questoes.setEnabledAt(6, false);
        ta_questoes.setEnabledAt(5, true);
        ta_questoes.setSelectedIndex(5);
    }//GEN-LAST:event_bt_voltar07ActionPerformed

    private void bt_voltar08ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_voltar08ActionPerformed
        ta_questoes.setEnabledAt(7, false);
        ta_questoes.setEnabledAt(6, true);
        ta_questoes.setSelectedIndex(6);
    }//GEN-LAST:event_bt_voltar08ActionPerformed

    private void bt_voltar09ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_voltar09ActionPerformed
        ta_questoes.setEnabledAt(8, false);
        ta_questoes.setEnabledAt(7, true);
        ta_questoes.setSelectedIndex(7);
    }//GEN-LAST:event_bt_voltar09ActionPerformed

    private void bt_voltar10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_voltar10ActionPerformed
        ta_questoes.setEnabledAt(9, false);
        ta_questoes.setEnabledAt(8, true);
        ta_questoes.setSelectedIndex(8);
    }//GEN-LAST:event_bt_voltar10ActionPerformed

    private void bt_salvardadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_salvardadosActionPerformed

        if (!ta_questaodesafio10.getText().equals("") && !ta_gabarito10.getText().equals("")) {

            if (JOptionPane.showConfirmDialog(null, "Deseja Salvar?", "Salvar", 2) == 0) {

                if (cb_material.isSelected()) {
                    r.setMaterial(tf_MaterialApoio.getText());
                } else {
                    r.setMaterial("Sem material");
                }

                RecuperarDatas();
                r.setData_Fase1(Data1);
                r.setData_Fase2(Data2);
                r.setData_Fase3(Data3);
                r.setData_Fase4(Data4);
                r.setData_Fase5(Data5);
                r.setData_Fase6(Data6);
                r.setQuantidade_Times(Integer.parseInt(tf_QuantidadeTimes.getText()));
                r.setIdUsuario_Professor(ut.getId());

                //QUESTÃO 01
                qd.setCorpo_Questao(ta_questaodesafio01.getText());
                qd.setGabarito(ta_gabarito01.getText());
                qdwdao.AdicionaQuestaoDesafio(qd);
                r.setIdQuestao_Desafio01(qdwdao.BuscarUltimoId());

                //QUESTÃO 02
                qd.setCorpo_Questao(ta_questaodesafio02.getText());
                qd.setGabarito(ta_gabarito02.getText());
                qdwdao.AdicionaQuestaoDesafio(qd);
                r.setIdQuestao_Desafio02(qdwdao.BuscarUltimoId());

                //QUESTÃO 03
                qd.setCorpo_Questao(ta_questaodesafio03.getText());
                qd.setGabarito(ta_gabarito03.getText());
                qdwdao.AdicionaQuestaoDesafio(qd);
                r.setIdQuestao_Desafio03(qdwdao.BuscarUltimoId());

                //QUESTÃO 04
                qd.setCorpo_Questao(ta_questaodesafio04.getText());
                qd.setGabarito(ta_gabarito04.getText());
                qdwdao.AdicionaQuestaoDesafio(qd);
                r.setIdQuestao_Desafio04(qdwdao.BuscarUltimoId());

                //QUESTÃO 05
                qd.setCorpo_Questao(ta_questaodesafio05.getText());
                qd.setGabarito(ta_gabarito05.getText());
                qdwdao.AdicionaQuestaoDesafio(qd);
                r.setIdQuestao_Desafio05(qdwdao.BuscarUltimoId());

                //QUESTÃO 06
                qd.setCorpo_Questao(ta_questaodesafio06.getText());
                qd.setGabarito(ta_gabarito06.getText());
                qdwdao.AdicionaQuestaoDesafio(qd);
                r.setIdQuestao_Desafio06(qdwdao.BuscarUltimoId());

                //QUESTÃO 07
                qd.setCorpo_Questao(ta_questaodesafio07.getText());
                qd.setGabarito(ta_gabarito07.getText());
                qdwdao.AdicionaQuestaoDesafio(qd);
                r.setIdQuestao_Desafio07(qdwdao.BuscarUltimoId());

                //QUESTÃO 08
                qd.setCorpo_Questao(ta_questaodesafio08.getText());
                qd.setGabarito(ta_gabarito08.getText());
                qdwdao.AdicionaQuestaoDesafio(qd);
                r.setIdQuestao_Desafio08(qdwdao.BuscarUltimoId());

                //QUESTÃO 09
                qd.setCorpo_Questao(ta_questaodesafio09.getText());
                qd.setGabarito(ta_gabarito09.getText());
                qdwdao.AdicionaQuestaoDesafio(qd);
                r.setIdQuestao_Desafio09(qdwdao.BuscarUltimoId());

                //QUESTÃO 10
                qd.setCorpo_Questao(ta_questaodesafio10.getText());
                qd.setGabarito(ta_gabarito10.getText());
                qdwdao.AdicionaQuestaoDesafio(qd);
                r.setIdQuestao_Desafio10(qdwdao.BuscarUltimoId());

                //ADICIONAR RODADA
                rwdao.AdicionaRodada(r);
                
                //DEFINIR EQUIPES RESPOSTA

                ArrayList<Integer> listaEquipesQueRespostas = CriarlistaEquipesQueRespostas(Integer.parseInt(tf_QuantidadeTimes.getText()), ewdao.BuscarUltimoId());
                ArrayList<Integer> listaEquipesParaRespostas = AdicionarListaEquipes(Integer.parseInt(tf_QuantidadeTimes.getText()), ewdao.BuscarUltimoId(), listaEquipesQueRespostas);
               

                //ADICIONAR EQUIPES
                int cont = 1;

                while (listaEquipesParaRespostas.size() > 0) {

                    System.out.println("Adicionando a Equipe: "+listaEquipesParaRespostas.size());
                    System.out.println("------------------------------");
                    e.setEquipe_Para_Resposta(listaEquipesParaRespostas.get(0));
                    e.setEquipe_Que_Resposta(listaEquipesQueRespostas.get(0));
                    e.setNomeEquipe("Equipe " + cont);
                   
                    //PREENCHER EQUPES
                    ArrayList<Integer> listaQuestoes = new ArrayList<>();
                    ArrayList<Integer> listaRespostas = new ArrayList<>();
                    ArrayList<Integer> listaRespostasQuestaoDesafio = new ArrayList<>();
                    ArrayList<Integer> listaIdQuestaoDesafios = GerarQuestaoDesafio();
                    
                    for (int i = 0; i < 10; i++) {

                        //ADCIONAR QUESTÕES
                        Questao q = new Questao();
                        q.setCorpo_Questao("SEM CONTEUDO");
                        q.setGabarito("SEM CONTEUDO");
                        q.setQualificacao_Questao("SEM CONTEUDO");
                        qwdao.AdicionaQuestao(q);
                        listaQuestoes.add(qwdao.BuscarUltimoId());

                        //ADICIONAR RESPOSTA
                        Resposta re = new Resposta();
                        re.setCorpo_Resposta("SEM CONTEUDO");
                        re.setNota_Resposta("SEM CONTEUDO");
                        rewdao.AdicionaResposta(re);
                        listaRespostas.add(rewdao.BuscarUltimoId());

                    }
                    
                    //ADICIONAR RESPOSTA-DESAFIO 01
                        Resposta_Questao_Desafio rqd = new Resposta_Questao_Desafio();
                        rqd.setCorpo_Resposta("SEM CONTEUDO");
                        rqd.setNota_Questao_Desafio("SEM CONTEUDO");
                        rqdwdao.AdicionaRespostaQuestaoDesafio(rqd);
                        listaRespostasQuestaoDesafio.add(rqdwdao.BuscarUltimoId());
                    
                        
                    //ADICIONAR RESPOSTA-DESAFIO 02
                        rqd = new Resposta_Questao_Desafio();
                        rqd.setCorpo_Resposta("SEM CONTEUDO");
                        rqd.setNota_Questao_Desafio("SEM CONTEUDO");
                        rqdwdao.AdicionaRespostaQuestaoDesafio(rqd);
                        listaRespostasQuestaoDesafio.add(rqdwdao.BuscarUltimoId());
                        
                    //ADICIONAR RESPOSTA-DESAFIO 03
                        rqd = new Resposta_Questao_Desafio();
                        rqd.setCorpo_Resposta("SEM CONTEUDO");
                        rqd.setNota_Questao_Desafio("SEM CONTEUDO");
                        rqdwdao.AdicionaRespostaQuestaoDesafio(rqd);
                        listaRespostasQuestaoDesafio.add(rqdwdao.BuscarUltimoId());    
                    
                    //LER ARRAYS
                    e.setIdQuestao_Equipe01(listaQuestoes.get(0));
                    e.setIdQuestao_Equipe02(listaQuestoes.get(1));
                    e.setIdQuestao_Equipe03(listaQuestoes.get(2));
                    e.setIdQuestao_Equipe04(listaQuestoes.get(3));
                    e.setIdQuestao_Equipe05(listaQuestoes.get(4));
                    e.setIdQuestao_Equipe06(listaQuestoes.get(5));
                    e.setIdQuestao_Equipe07(listaQuestoes.get(6));
                    e.setIdQuestao_Equipe08(listaQuestoes.get(7));
                    e.setIdQuestao_Equipe09(listaQuestoes.get(8));
                    e.setIdQuestao_Equipe10(listaQuestoes.get(9));
                    e.setIdResposta_Equipe01(listaRespostas.get(0));
                    e.setIdResposta_Equipe02(listaRespostas.get(1));
                    e.setIdResposta_Equipe03(listaRespostas.get(2));
                    e.setIdResposta_Equipe04(listaRespostas.get(3));
                    e.setIdResposta_Equipe05(listaRespostas.get(4));
                    e.setIdResposta_Equipe06(listaRespostas.get(5));
                    e.setIdResposta_Equipe07(listaRespostas.get(6));
                    e.setIdResposta_Equipe08(listaRespostas.get(7));
                    e.setIdResposta_Equipe09(listaRespostas.get(8));
                    e.setIdResposta_Equipe10(listaRespostas.get(9));
                    e.setIdQuestao_Desafio01(listaIdQuestaoDesafios.get(0));
                    e.setIdQuestao_Desafio02(listaIdQuestaoDesafios.get(1));
                    e.setIdQuestao_Desafio03(listaIdQuestaoDesafios.get(2));
                    e.setIdResposta_Desafio01(listaRespostasQuestaoDesafio.get(0));
                    e.setIdResposta_Desafio02(listaRespostasQuestaoDesafio.get(1));
                    e.setIdResposta_Desafio03(listaRespostasQuestaoDesafio.get(2));
                    ewdao.AdicionaEquipe(e);
                    listaEquipesParaRespostas.remove(0);
                    listaEquipesQueRespostas.remove(0);

                    //ADICIONAR USUARIO ALUNO
                    ua.setEquipe_idEquipe(ewdao.BuscarUltimoId());
                    ua.setRodada_idRodada(rwdao.BuscarUltimoId());
                    ua.setUsuario("Equipe " + cont);
                    ua.setSenha("admin");
                    ua.setEmail("admin@equipe" + cont + "_rodada" + ua.getRodada_idRodada());
                    uawdao.AdicionarUsuarioAluno(ua);
                    cont++;
                }
                JOptionPane.showMessageDialog(null, "Salvo com Sucesso!");

                //LIMPAR CAMPOS
                LimparCampos();
                Voltar();
                ta_questoes.setEnabledAt(1, false);
                ta_questoes.setEnabledAt(0, true);
                ta_questoes.setSelectedIndex(0);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Questão 10 ou Gabarito 10, não podem estar vazio!");
        }


    }//GEN-LAST:event_bt_salvardadosActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Tela_AdicionarRodada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela_AdicionarRodada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela_AdicionarRodada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela_AdicionarRodada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Tela_AdicionarRodada dialog = new Tela_AdicionarRodada(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton bt_Selecionar;
    private javax.swing.JButton bt_avancar;
    private javax.swing.JButton bt_avançar01;
    private javax.swing.JButton bt_avançar02;
    private javax.swing.JButton bt_avançar03;
    private javax.swing.JButton bt_avançar04;
    private javax.swing.JButton bt_avançar05;
    private javax.swing.JButton bt_avançar06;
    private javax.swing.JButton bt_avançar07;
    private javax.swing.JButton bt_avançar08;
    private javax.swing.JButton bt_avançar09;
    private javax.swing.JButton bt_cancelar;
    private javax.swing.JButton bt_salvardados;
    private javax.swing.JButton bt_voltar01;
    private javax.swing.JButton bt_voltar02;
    private javax.swing.JButton bt_voltar03;
    private javax.swing.JButton bt_voltar04;
    private javax.swing.JButton bt_voltar05;
    private javax.swing.JButton bt_voltar06;
    private javax.swing.JButton bt_voltar07;
    private javax.swing.JButton bt_voltar08;
    private javax.swing.JButton bt_voltar09;
    private javax.swing.JButton bt_voltar10;
    private javax.swing.JDialog caixaDialogoLoading;
    private javax.swing.JCheckBox cb_material;
    private com.toedter.calendar.JDateChooser df_Fase1;
    private com.toedter.calendar.JDateChooser df_Fase2;
    private com.toedter.calendar.JDateChooser df_Fase3;
    private com.toedter.calendar.JDateChooser df_Fase4;
    private com.toedter.calendar.JDateChooser df_Fase5;
    private com.toedter.calendar.JDateChooser df_Fase6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane20;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JPanel p_dados;
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
    private javax.swing.JTextArea ta_questaodesafio01;
    private javax.swing.JTextArea ta_questaodesafio02;
    private javax.swing.JTextArea ta_questaodesafio03;
    private javax.swing.JTextArea ta_questaodesafio04;
    private javax.swing.JTextArea ta_questaodesafio05;
    private javax.swing.JTextArea ta_questaodesafio06;
    private javax.swing.JTextArea ta_questaodesafio07;
    private javax.swing.JTextArea ta_questaodesafio08;
    private javax.swing.JTextArea ta_questaodesafio09;
    private javax.swing.JTextArea ta_questaodesafio10;
    private javax.swing.JTabbedPane ta_questoes;
    private javax.swing.JTextField tf_MaterialApoio;
    private javax.swing.JFormattedTextField tf_QuantidadeTimes;
    // End of variables declaration//GEN-END:variables
}
