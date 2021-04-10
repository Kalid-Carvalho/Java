package br.com.sorveteria.tela;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import br.com.sorveteria.dal.ModuloConexao;
import javax.swing.JOptionPane;
//está linha abaixo importa recursos rs2xml.java
import net.proteanit.sql.DbUtils;

public class TelaCadastroCliente extends javax.swing.JInternalFrame {

    /*Criando variaveis especiais para conexão com o banco de dados
      PreparedStatement e ResultSet são frameworks do pacote java.sql
      e serve para preparar e executar as instruções sql
     */
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public TelaCadastroCliente() {
        initComponents();

        conexao = ModuloConexao.conector();
    }

    private void limpaTela() {
        //as linhas abaixo "Limpam" os campos
        txtCliPesquisa.setText(null);
        txtCliNome.setText(null);
        txtCliCod.setText(null);
        cboCliSetor.setSelectedItem("Selecionar");
    }

    private void adicionar() {
        String sql = "INSERT INTO tb_clientes(nome_cliente,setor)VALUES(?,?)";
        
        try {
            // parametros(número do campo na tabela que está sendo usada, conteudo que foi digitado)
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtCliNome.getText());          
            pst.setString(2, cboCliSetor.getSelectedItem().toString());

            if ((txtCliNome.getText().isEmpty()) || (cboCliSetor.getSelectedItem().equals("Selecionar"))) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios");
            } else {
                //As linhas abaixo adicionão a tabela tb_clientes os dados do usuário
                //A estrutura abaixo é usada para confirmar alteração dos dados na tabela
                int adicionado = pst.executeUpdate();
                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Usuário adicionado com sucesso !");
                    int continuar = JOptionPane.showConfirmDialog(null, "Deseja adicionar outro usuário? ", "Atenção !", JOptionPane.YES_NO_OPTION);
                    if (continuar == JOptionPane.YES_OPTION) {
                        limpaTela();
                        btnCliAdicionar.setEnabled(true);
                    } else {
                        limpaTela();
                        btnCliAdicionar.setEnabled(false);
                    }

                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    //método para pesquisar clientes pelo nome com filtro
    private void pesquisar_cliente() {
        String sql = "SELECT codigo_cliente as Código, nome_cliente as Nome, setor as Setor FROM tb_clientes where nome_cliente like ?";
        try {
            pst = conexao.prepareStatement(sql);
            //Passando o conteúdo da caixa de pesquisa para o ?
            //atenção ao % -  continuação da String sql
            pst.setString(1, txtCliPesquisa.getText() + "%");
            rs = pst.executeQuery();
            // A linha abaixo usa a rs2xml.jar para preencher a tabela
            tblClientes.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    //Método para setar os campos do formulário com o conteudo da tabela
    private void setar_campos() {
        int setar = tblClientes.getSelectedRow();
        txtCliCod.setText(tblClientes.getModel().getValueAt(setar, 0).toString());
        txtCliNome.setText(tblClientes.getModel().getValueAt(setar, 1).toString());
        cboCliSetor.setSelectedItem(tblClientes.getModel().getValueAt(setar, 2).toString());
        btnCliAdicionar.setEnabled(false);
    }

    //Método para alterar dados do cliente
    private void alterar() {
        String sql = "UPDATE tb_clientes SET nome_cliente=?, setor =? where codigo_cliente = ?";

        try {
            pst = conexao.prepareStatement(sql);

            //Coletando dados do usuário
            pst.setString(1, txtCliNome.getText());
            pst.setString(3, cboCliSetor.getSelectedItem().toString());
            pst.setString(4, txtCliCod.getText());

            //Validando se campos obrigatórios estão digitados corretamente
            if ((txtCliNome.getText().isEmpty()) || (cboCliSetor.getSelectedItem().equals("Selecionar"))) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios");
            } else {
                //As linhas abaixo atualiza a tabela tb_clientes com os dados do usuário
                //A estrutura abaixo é usada para confirmar alteração dos dados na tabela
                int adicionado = pst.executeUpdate();
                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Dados do cliente alterados com sucesso !");
                    limpaTela();
                    btnCliAdicionar.setEnabled(true);
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void remover() {
        String sql = "DELETE FROM tb_clientes where codigo_cliente=?";

        //Variavel vai armazenar tipo de dado referente a pergunta
        int removido = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir este Cliente?", "Atenção !", JOptionPane.YES_NO_OPTION);
        if (removido == JOptionPane.YES_OPTION) {
            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1, txtCliCod.getText());
                //Comando para excluir usuario
                int apagado = pst.executeUpdate();
                if (apagado > 0) {
                    JOptionPane.showMessageDialog(null, "Cliente excluído com sucesso.");
                    limpaTela();
                    btnCliAdicionar.setEnabled(true);
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
        txtCliNome = new javax.swing.JTextField();
        lblSetor = new javax.swing.JLabel();
        cboCliSetor = new javax.swing.JComboBox<>();
        btnCliAdicionar = new javax.swing.JButton();
        btnCliAlterar = new javax.swing.JButton();
        btnCliRemover = new javax.swing.JButton();
        txtCliPesquisa = new javax.swing.JTextField();
        lblCampoObrigatorio = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblClientes = new javax.swing.JTable();
        txtCliCod = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Cadastro Cliente");
        setToolTipText("");

        lblCodicoCliente.setText("Codigo cliente:");

        lblNome.setText("*Nome:");

        lblSetor.setText("*Setor:");

        cboCliSetor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecionar", "TI", "Expedição", "Almoxarifado", "Produção", "Qualidade", "Contabilidade", "RH", "Samsung", "Compras", "Negócios", "Piovan", "Engenharia" }));

        btnCliAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sorveteria/imagens/insert.png"))); // NOI18N
        btnCliAdicionar.setToolTipText("Adicionar usuário");
        btnCliAdicionar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCliAdicionar.setPreferredSize(new java.awt.Dimension(80, 80));
        btnCliAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCliAdicionarActionPerformed(evt);
            }
        });

        btnCliAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sorveteria/imagens/update.png"))); // NOI18N
        btnCliAlterar.setToolTipText("Alterar Usuário");
        btnCliAlterar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCliAlterar.setPreferredSize(new java.awt.Dimension(80, 80));
        btnCliAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCliAlterarActionPerformed(evt);
            }
        });

        btnCliRemover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sorveteria/imagens/delete.png"))); // NOI18N
        btnCliRemover.setToolTipText("Remover usuário");
        btnCliRemover.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCliRemover.setPreferredSize(new java.awt.Dimension(80, 80));
        btnCliRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCliRemoverActionPerformed(evt);
            }
        });

        txtCliPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCliPesquisaKeyReleased(evt);
            }
        });

        lblCampoObrigatorio.setText("*Campos obrigatórios");

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sorveteria/imagens/zoom.png"))); // NOI18N

        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblClientes);

        txtCliCod.setEnabled(false);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sorveteria/imagens/zoom.png"))); // NOI18N

        javax.swing.GroupLayout painelCadastroClienteLayout = new javax.swing.GroupLayout(painelCadastroCliente);
        painelCadastroCliente.setLayout(painelCadastroClienteLayout);
        painelCadastroClienteLayout.setHorizontalGroup(
            painelCadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelCadastroClienteLayout.createSequentialGroup()
                .addGroup(painelCadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelCadastroClienteLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtCliPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1408, 1408, 1408)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelCadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lblCampoObrigatorio)
                        .addGroup(painelCadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 585, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(painelCadastroClienteLayout.createSequentialGroup()
                                .addGroup(painelCadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(painelCadastroClienteLayout.createSequentialGroup()
                                        .addGap(97, 97, 97)
                                        .addComponent(btnCliAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(97, 97, 97)
                                        .addComponent(btnCliAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(painelCadastroClienteLayout.createSequentialGroup()
                                        .addGap(30, 30, 30)
                                        .addGroup(painelCadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblCodicoCliente)
                                            .addGroup(painelCadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(txtCliCod, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(lblNome, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addComponent(txtCliNome, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(painelCadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cboCliSetor, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblSetor)
                                    .addComponent(btnCliRemover, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
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
                        .addComponent(txtCliPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(painelCadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelCadastroClienteLayout.createSequentialGroup()
                        .addComponent(lblCodicoCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCliCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelCadastroClienteLayout.createSequentialGroup()
                        .addComponent(lblSetor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cboCliSetor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(16, 16, 16)
                .addComponent(lblNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtCliNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(painelCadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCliRemover, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelCadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnCliAdicionar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnCliAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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

    private void btnCliAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCliAdicionarActionPerformed
        //Método para adicionar usuário
        adicionar();
    }//GEN-LAST:event_btnCliAdicionarActionPerformed

    private void txtCliPesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCliPesquisaKeyReleased
        //O evento abaixo é do tipo enquanto for digitando em tempo real aparece os resultados
        pesquisar_cliente();
    }//GEN-LAST:event_txtCliPesquisaKeyReleased
    //evento que sera usado para setar campos da tabela(clicando com o mouse)
    private void tblClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClientesMouseClicked

        setar_campos();
    }//GEN-LAST:event_tblClientesMouseClicked

    private void btnCliAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCliAlterarActionPerformed
        // Evento onde altera os dados do usuário
        alterar();
    }//GEN-LAST:event_btnCliAlterarActionPerformed

    private void btnCliRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCliRemoverActionPerformed
        //Evento que exclui o usuário
        remover();
    }//GEN-LAST:event_btnCliRemoverActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCliAdicionar;
    private javax.swing.JButton btnCliAlterar;
    private javax.swing.JButton btnCliRemover;
    private javax.swing.JComboBox<String> cboCliSetor;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCampoObrigatorio;
    private javax.swing.JLabel lblCodicoCliente;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblSetor;
    private javax.swing.JPanel painelCadastroCliente;
    private javax.swing.JTable tblClientes;
    private javax.swing.JTextField txtCliCod;
    private javax.swing.JTextField txtCliNome;
    private javax.swing.JTextField txtCliPesquisa;
    // End of variables declaration//GEN-END:variables
}
