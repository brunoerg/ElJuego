/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whacamole;

import javax.swing.JFrame;

/**
 *
 * @author usuario
 */
public class Best extends javax.swing.JFrame {

    /**
     * Creates new form Best
     */
    public Best() {
        initComponents();
        setSize(600,340);
        this.setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ElJuegoDAO dao = new ElJuegoDAO();
        dao.oMelhor();
        lbUsername.setText("Melhor jogador: " + dao.nome_melhor);
        lbPontuacao.setText(Integer.toString(dao.melhor_pontuacao));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbUsername = new javax.swing.JLabel();
        lbPontuacao = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/back.PNG"))); // NOI18N
        jLabel1.setText("Melhor Jogador");

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        lbUsername.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbUsername.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbUsername.setText("Melhor jogador");
        lbUsername.setToolTipText("");
        lbUsername.setName("lbUsername"); // NOI18N
        getContentPane().add(lbUsername);
        lbUsername.setBounds(230, 150, 150, 30);

        lbPontuacao.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbPontuacao.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPontuacao.setText("Pontuação");
        lbPontuacao.setName("lbPontuacao"); // NOI18N
        getContentPane().add(lbPontuacao);
        lbPontuacao.setBounds(270, 190, 70, 15);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Tente fazer melhor!");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(250, 220, 130, 30);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/back.PNG"))); // NOI18N
        getContentPane().add(jLabel6);
        jLabel6.setBounds(-20, -30, 650, 380);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Best.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Best.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Best.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Best.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Best().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lbPontuacao;
    private javax.swing.JLabel lbUsername;
    // End of variables declaration//GEN-END:variables
}
