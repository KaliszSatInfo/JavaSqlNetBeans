package oauh.projekt.druhy.rocnik;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class DatabaseTableCreation extends javax.swing.JFrame {
    public boolean Allowed = true;
    private String databaseName;
    private String tableName;

    public String getDatabaseName() {
        return databaseName;
    }
    public String getTableName() {
        return tableName;
    }

    public void CreateDatabase() {
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost/", "root", "");
             Statement stat = con.createStatement()
        ) {
            databaseName = jTextField1.getText();
            if (!databaseName.isEmpty()) {
                String sql = "CREATE DATABASE " + databaseName;
                stat.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Database created successfully");
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }
    public void CreateTable() {
         databaseName = jTextField1.getText();
         tableName = jTextField2.getText();
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost/" + databaseName, "root", "");
             Statement stat = con.createStatement()
        ) {
            String sql = "CREATE TABLE " + tableName +
                    "(id INTEGER not NULL, " +
                    "first_name VARCHAR(255), " +
                    "last_name VARCHAR(255)) ";
            stat.execute(sql);
            JOptionPane.showMessageDialog(null, "Table created successfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

        public DatabaseTableCreation() {
            initComponents();
        }

    private void initComponents() {

            jButton1 = new javax.swing.JButton();
            jButton2 = new javax.swing.JButton();
            jTextField1 = new javax.swing.JTextField();
            jTextField2 = new javax.swing.JTextField();

            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

            jButton1.setText("Add Database");
            jButton1.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton1ActionPerformed(evt);
                }
            });

            jButton2.setText("Add Table ");
            jButton2.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton2ActionPerformed(evt);
                }
            });

            jTextField1.setText("");
            jTextField1.setPreferredSize(new Dimension(50, 20));

            jTextField2.setText("");
            jTextField2.setPreferredSize(new Dimension(50, 20));

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                    .addGap(9, 9, 9)
                                                    .addComponent(jButton1))
                                            .addGroup(layout.createSequentialGroup()
                                                    .addGap(17, 17, 17)
                                                    .addComponent(jButton2)))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addContainerGap(14, Short.MAX_VALUE))
            );
            layout.setVerticalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                    .addGap(20, 20, 20)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jButton1)
                                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jButton2)
                                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(15, 15, 15))
            );

            pack();
        }// </editor-fold>

        private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
            CreateDatabase();
        }

        private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
            CreateTable();
            JavaSql javaSql = new JavaSql(databaseName, tableName);


        }
        public static void main(String[] args) {
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new DatabaseTableCreation().setVisible(true);
                }
            });
        }

        // Variables declaration - do not modify
        private javax.swing.JButton jButton1;
        private javax.swing.JButton jButton2;
        private static javax.swing.JTextField jTextField1;
        private static javax.swing.JTextField jTextField2;
        // End of variables declaration
}
