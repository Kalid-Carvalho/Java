package br.com.sorveteria.tela;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import br.com.sorveteria.dal.ModuloConexao;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

public class TelaCadastroSorvete extends javax.swing.JInternalFrame {

    /*Criando variaveis especiais para conexão com o banco de dados
      PreparedStatement e ResultSet são frameworks do pacote java.sql
      e serve para preparar e executar as instruções sql
     */
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public TelaCadastroSorvete() {
        initComponents();

        conexao = ModuloConexao.conector();
    }

    private void limpaTela() {
        //as linhas abaixo "Limpam" os campos
        txtSorvCod.setText(null);
        txtSorvDescricao.setText(null);
        txtSorvPesquisa.setText(null);
        txtSorvPreco.setText(null);
    }

    private void adicionar() {
        String sql = "INSERT INTO tb_sorvetes(descricao,preco)VALUES(?,?)";

        try {
            // parametros( numero do campo na tabela que está sendo usada, conteudo que foi digitado)
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtSorvDescricao.getText());
            pst.setString(2, txtSorvPreco.getText());

            if ((txtSorvDescricao.getText().isEmpty()) || (txtSorvPreco.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios");
            } else {
                //As linhas abaixo adicionão a tabela tb_clientes os dados do usuário
                //A estrutura abaixo é usada para confirmar alteração dos dados na tabela
                int adicionado = pst.executeUpdate();
                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Sorvete cadastrado com sucesso !");
                    int continuar = JOptionPane.showConfirmDialog(null, "Deseja cadastrar outro sabor? ", "Atenção !", JOptionPane.YES_NO_OPTION);
                    if (continuar == JOptionPane.YES_OPTION) {
                        limpaTela();
                        btnSorvAdicionar.setEnabled(true);
                    } else {
                        limpaTela();
                        btnSorvAdicionar.setEnabled(false);
                    }

                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    //método para pesquisar sorvetes pelo nome com filtro
    private void pesquisar_sorvete() {
        String sql = "SELECT codigo_sorvete as Código, descricao as Descrição, preco as Preço FROM tb_sorvetes WHERE descricao like ?";
        try {
            pst = conexao.prepareStatement(sql);
            //Passando o conteúdo da caixa de pesquisa para o ?
            //atenção ao % -  continuação da String sql
            pst.setString(1, txtSorvPesquisa.getText() + "%");
            rs = pst.executeQuery();
            // A linha abaixo usa a rs2xml.jar para preencher a tabela
            tblSorvetes.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    //Método para setar os campos do formulário com o conteudo da tabela
    private void setar_campos() {
        int setar = tblSorvetes.getSelectedRow();
        txtSorvCod.setText(tblSorvetes.getModel().getValueAt(setar, 0).toString());
        txtSorvDescricao.setText(tblSorvetes.getModel().getValueAt(setar, 1).toString());
        txtSorvPreco.setText(tblSorvetes.getModel().getValueAt(setar, 2).toString());
        btnSorvAdicionar.setEnabled(false);
    }
    
    //Método para alterar dados do cliente
    private void alterar() {
        String sql = "UPDATE tb_sorvetes SET descricao=?, preco=? where codigo_sorvete = ?";

        try {
            pst = conexao.prepareStatement(sql);

            //Coletando dados do usuário
            pst.setString(1, txtSorvDescricao.getText());
            pst.setString(2, txtSorvPreco.getText());
            pst.setString(3, txtSorvCod.getText());

            //Validando se campos obrigatórios estão digitados corretamente
            if ((txtSorvDescricao.getText().isEmpty()) || (txtSorvPreco.getText().isEmpty())) {
            } else {
                //As linhas abaixo atualiza a tabela tb_clientes com os dados do usuário
                //A estrutura abaixo é usada para confirmar alteração dos dados na tabela
                int adicionado = pst.executeUpdate();
                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Dados do sorvete alterados com sucesso !");
                    limpaTela();
                    btnSorvAdicionar.setEnabled(true);
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    private void remover() {
        String sql = "DELETE FROM tb_sorvetes where codigo_sorvete=?";

        //Variavel vai armazenar tipo de dado referente a pergunta
        int removido = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir este sorvete?", "Atenção !", JOptionPane.YES_NO_OPTION);
        if (removido == JOptionPane.YES_OPTION) {
            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1, txtSorvCod.getText());
                //Comando para excluir usuario
                int apagado = pst.executeUpdate();
                if (apagado > 0) {
                    JOptionPane.showMessageDialog(null, "sorvete excluído com sucesso.");
                    limpaTela();
                    btnSorvAdicionar.setEnabled(true);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelCadastroCliente = new javax.swing.JPanel();
        lblCodicoCliente = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        txtSorvDescricao = new javax.swing.JTextField();
        lblMatricula = new javax.swing.JLabel();
        btnSorvAdicionar = new javax.swing.JButton();
        btnSorvAlterar = new javax.swing.JButton();
        btnSorvRemover = new javax.swing.JButton();
        txtSorvPesquisa = new javax.swing.JTextField();
        lblCampoObrigatorio = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSorvetes = new javax.swing.JTable();
        txtSorvCod = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtSorvPreco = new javax.swing.JFormattedTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Cadastro Sorvetes");

        lblCodicoCliente.setText("Código Sorvete");

        lblNome.setText("*Descrição");

        lblMatricula.setText("*Preço R$:");

        btnSorvAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sorveteria/imagens/insert.png"))); // NOI18N
        btnSorvAdicionar.setToolTipText("Adicionar usuário");
        btnSorvAdicionar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSorvAdicionar.setPreferredSize(new java.awt.Dimension(80, 80));
        btnSorvAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSorvAdicionarActionPerformed(evt);
            }
        });

        btnSorvAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sorveteria/imagens/update.png"))); // NOI18N
        btnSorvAlterar.setToolTipText("Alterar Usuário");
        btnSorvAlterar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSorvAlterar.setPreferredSize(new java.awt.Dimension(80, 80));
        btnSorvAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSorvAlterarActionPerformed(evt);
            }
        });

        btnSorvRemover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sorveteria/imagens/delete.png"))); // NOI18N
        btnSorvRemover.setToolTipText("Remover usuário");
        btnSorvRemover.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSorvRemover.setPreferredSize(new java.awt.Dimension(80, 80));
        btnSorvRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSorvRemoverActionPerformed(evt);
            }
        });

        txtSorvPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSorvPesquisaKeyReleased(evt);
            }
        });

        lblCampoObrigatorio.setText("*Campos obrigatórios");

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sorveteria/imagens/zoom.png"))); // NOI18N

        tblSorvetes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblSorvetes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSorvetesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSorvetes);

        txtSorvCod.setEnabled(false);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sorveteria/imagens/zoom.png"))); // NOI18N

        try {
            txtSorvPreco.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#.##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout painelCadastroClienteLayout = new javax.swing.GroupLayout(painelCadastroCliente);
        painelCadastroCliente.setLayout(painelCadastroClienteLayout);
        painelCadastroClienteLayout.setHorizontalGroup(
            painelCadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelCadastroClienteLayout.createSequentialGroup()
                .addGroup(painelCadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelCadastroClienteLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtSorvPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1408, 1408, 1408)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelCadastroClienteLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(painelCadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSorvDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(painelCadastroClienteLayout.createSequentialGroup()
                                .addGroup(painelCadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblCodicoCliente)
                                    .addGroup(painelCadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtSorvCod, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblNome, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(44, 44, 44)
                                .addGroup(painelCadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblMatricula)
                                    .addComponent(txtSorvPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(painelCadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lblCampoObrigatorio)
                        .addGroup(painelCadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelCadastroClienteLayout.createSequentialGroup()
                                .addGap(97, 97, 97)
                                .addComponent(btnSorvAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(97, 97, 97)
                                .addComponent(btnSorvAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(84, 84, 84)
                                .addComponent(btnSorvRemover, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 585, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painelCadastroClienteLayout.setVerticalGroup(
            painelCadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelCadastroClienteLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(painelCadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelCadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblCampoObrigatorio, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtSorvPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(painelCadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodicoCliente)
                    .addComponent(lblMatricula))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelCadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSorvCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSorvPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtSorvDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(painelCadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSorvRemover, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelCadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnSorvAdicionar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSorvAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(36, 36, 36))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painelCadastroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 596, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelCadastroCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setBounds(0, 0, 610, 495);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSorvAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSorvAdicionarActionPerformed
        //Método para adicionar usuário
        adicionar();
    }//GEN-LAST:event_btnSorvAdicionarActionPerformed

    private void btnSorvAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSorvAlterarActionPerformed
        // Evento onde altera os dados do usuário
        alterar();
    }//GEN-LAST:event_btnSorvAlterarActionPerformed

    private void btnSorvRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSorvRemoverActionPerformed
        //Evento que exclui o usuário
        remover();
    }//GEN-LAST:event_btnSorvRemoverActionPerformed

    private void txtSorvPesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSorvPesquisaKeyReleased
        //O evento abaixo é do tipo enquanto for digitando em tempo real aparece os resultados
        pesquisar_sorvete();
    }//GEN-LAST:event_txtSorvPesquisaKeyReleased

    private void tblSorvetesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSorvetesMouseClicked

        setar_campos();
    }//GEN-LAST:event_tblSorvetesMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSorvAdicionar;
    private javax.swing.JButton btnSorvAlterar;
    private javax.swing.JButton btnSorvRemover;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCampoObrigatorio;
    private javax.swing.JLabel lblCodicoCliente;
    private javax.swing.JLabel lblMatricula;
    private javax.swing.JLabel lblNome;
    private javax.swing.JPanel painelCadastroCliente;
    private javax.swing.JTable tblSorvetes;
    private javax.swing.JTextField txtSorvCod;
    private javax.swing.JTextField txtSorvDescricao;
    private javax.swing.JTextField txtSorvPesquisa;
    private javax.swing.JFormattedTextField txtSorvPreco;
    // End of variables declaration//GEN-END:variables
}
