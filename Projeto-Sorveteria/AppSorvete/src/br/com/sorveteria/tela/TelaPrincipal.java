package br.com.sorveteria.tela;

import java.awt.Desktop;
import java.text.DateFormat;
import java.util.Date;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;


public class TelaPrincipal extends javax.swing.JFrame {

    public TelaPrincipal() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        lblUsuario = new javax.swing.JLabel();
        lblData = new javax.swing.JLabel();
        menuVendasSorvete = new javax.swing.JMenuBar();
        menModulo = new javax.swing.JMenu();
        menModuloUsuario = new javax.swing.JMenu();
        ItemCadastroUsuário = new javax.swing.JMenuItem();
        menModuloClientes = new javax.swing.JMenu();
        itemCadastroClientes = new javax.swing.JMenuItem();
        menModuloSorvetes = new javax.swing.JMenu();
        itemCadastrarSorvetes = new javax.swing.JMenuItem();
        itemVenderSorvete = new javax.swing.JMenuItem();
        itemPagarSorvete = new javax.swing.JMenuItem();
        menRelatorio = new javax.swing.JMenu();
        menRelatorioSorvete = new javax.swing.JMenuItem();
        menRelatorioCliente = new javax.swing.JMenuItem();
        menAjuda = new javax.swing.JMenu();
        menAjudaSobre = new javax.swing.JMenuItem();
        menOpcoes = new javax.swing.JMenu();
        menOpcoesSair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sorveteria - Tela Principal");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jDesktopPane1.setPreferredSize(new java.awt.Dimension(610, 495));

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 610, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 496, Short.MAX_VALUE)
        );

        lblUsuario.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblUsuario.setText("Usuário");

        lblData.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblData.setText("Data");

        menModulo.setText("Módulos");

        menModuloUsuario.setText("Usuário");
        menModuloUsuario.setEnabled(false);

        ItemCadastroUsuário.setText("Cadastrar Usuário");
        ItemCadastroUsuário.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemCadastroUsuárioActionPerformed(evt);
            }
        });
        menModuloUsuario.add(ItemCadastroUsuário);

        menModulo.add(menModuloUsuario);

        menModuloClientes.setText("Clientes");
        menModuloClientes.setEnabled(false);

        itemCadastroClientes.setText("Cadastrar Clientes");
        itemCadastroClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCadastroClientesActionPerformed(evt);
            }
        });
        menModuloClientes.add(itemCadastroClientes);

        menModulo.add(menModuloClientes);

        menModuloSorvetes.setText("Sorvetes");

        itemCadastrarSorvetes.setText("Cadastrar Sorvetes");
        itemCadastrarSorvetes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCadastrarSorvetesActionPerformed(evt);
            }
        });
        menModuloSorvetes.add(itemCadastrarSorvetes);

        itemVenderSorvete.setText("Vender Sorvete");
        itemVenderSorvete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemVenderSorveteActionPerformed(evt);
            }
        });
        menModuloSorvetes.add(itemVenderSorvete);

        itemPagarSorvete.setText("Pagar Sorvete");
        menModuloSorvetes.add(itemPagarSorvete);

        menModulo.add(menModuloSorvetes);

        menuVendasSorvete.add(menModulo);

        menRelatorio.setText("Relatório");

        menRelatorioSorvete.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, java.awt.event.InputEvent.ALT_MASK));
        menRelatorioSorvete.setText("Sorvete");
        menRelatorioSorvete.setEnabled(false);
        menRelatorio.add(menRelatorioSorvete);

        menRelatorioCliente.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, java.awt.event.InputEvent.ALT_MASK));
        menRelatorioCliente.setText("Cliente");
        menRelatorioCliente.setEnabled(false);
        menRelatorioCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menRelatorioClienteActionPerformed(evt);
            }
        });
        menRelatorio.add(menRelatorioCliente);

        menuVendasSorvete.add(menRelatorio);

        menAjuda.setText("Ajuda");

        menAjudaSobre.setText("Sobre");
        menAjudaSobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menAjudaSobreActionPerformed(evt);
            }
        });
        menAjuda.add(menAjudaSobre);

        menuVendasSorvete.add(menAjuda);

        menOpcoes.setText("Opções");

        menOpcoesSair.setText("Sair");
        menOpcoesSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menOpcoesSairActionPerformed(evt);
            }
        });
        menOpcoes.add(menOpcoesSair);

        menuVendasSorvete.add(menOpcoes);

        setJMenuBar(menuVendasSorvete);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUsuario)
                    .addComponent(lblData))
                .addGap(0, 94, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(lblUsuario)
                .addGap(18, 18, 18)
                .addComponent(lblData)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(805, 558));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        //Botando data para aparecer automatico quando iniciar o sistema
        Date data = new Date();
        DateFormat formatador = DateFormat.getDateInstance(DateFormat.SHORT);
        lblData.setText(formatador.format(data));
    }//GEN-LAST:event_formWindowActivated

    private void menRelatorioClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menRelatorioClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menRelatorioClienteActionPerformed

    private void menOpcoesSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menOpcoesSairActionPerformed
        //Exibe uma caixa de diálogo
        int sair = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair?", "Atenção !", JOptionPane.YES_NO_OPTION);
        if (sair == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_menOpcoesSairActionPerformed

    private void menAjudaSobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menAjudaSobreActionPerformed
        TelaSobre sobre = new TelaSobre();
        sobre.setVisible(true);
    }//GEN-LAST:event_menAjudaSobreActionPerformed

    private void ItemCadastroUsuárioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemCadastroUsuárioActionPerformed
        TelaCadastroUsuario usuario = new TelaCadastroUsuario();
        usuario.setVisible(true);
        jDesktopPane1.add(usuario);
    }//GEN-LAST:event_ItemCadastroUsuárioActionPerformed

    private void itemCadastroClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCadastroClientesActionPerformed
        //Ao clicar abrir tela de cadastro de usuário
        TelaCadastroCliente cliente = new TelaCadastroCliente();
        cliente.setVisible(true);
        jDesktopPane1.add(cliente);
    }//GEN-LAST:event_itemCadastroClientesActionPerformed

    private void itemVenderSorveteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemVenderSorveteActionPerformed
        TelaVendaSorvete sorvete = new TelaVendaSorvete();
        sorvete.setVisible(true);
        jDesktopPane1.add(sorvete);
    }//GEN-LAST:event_itemVenderSorveteActionPerformed

    private void itemCadastrarSorvetesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCadastrarSorvetesActionPerformed
        TelaCadastroSorvete telaSorv = new TelaCadastroSorvete();
        telaSorv.setVisible(true);
        jDesktopPane1.add(telaSorv);              
    }//GEN-LAST:event_itemCadastrarSorvetesActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //Método que invoca a tela
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem ItemCadastroUsuário;
    private javax.swing.JMenuItem itemCadastrarSorvetes;
    private javax.swing.JMenuItem itemCadastroClientes;
    private javax.swing.JMenuItem itemPagarSorvete;
    private javax.swing.JMenuItem itemVenderSorvete;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel lblData;
    public static javax.swing.JLabel lblUsuario;
    private javax.swing.JMenu menAjuda;
    private javax.swing.JMenuItem menAjudaSobre;
    private javax.swing.JMenu menModulo;
    public static javax.swing.JMenu menModuloClientes;
    private javax.swing.JMenu menModuloSorvetes;
    public static javax.swing.JMenu menModuloUsuario;
    private javax.swing.JMenu menOpcoes;
    private javax.swing.JMenuItem menOpcoesSair;
    private javax.swing.JMenu menRelatorio;
    public static javax.swing.JMenuItem menRelatorioCliente;
    public static javax.swing.JMenuItem menRelatorioSorvete;
    private javax.swing.JMenuBar menuVendasSorvete;
    // End of variables declaration//GEN-END:variables
}
