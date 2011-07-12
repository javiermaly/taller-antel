/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AltaTicket_.java
 *
 * Created on 04/07/2011, 10:23:14 AM
 */
package gui;

import com.terminal.Funciones;
import com.terminal.Manager;
import com.terminal.Ticket;
import java.util.Calendar;
import javax.swing.JOptionPane;

/**
 *
 * @author e043468
 */
public class AltaTicket_ extends javax.swing.JFrame {

    /** Creates new form AltaTicket_ */
    public AltaTicket_() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTxtMatricula = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTxtMinutos = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        dateChooserCombo1 = new datechooser.beans.DateChooserCombo();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jTxtHoraInicio = new javax.swing.JTextField();
        jTxtMinInicio = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Venta Ticket Estacionamiento");
        setResizable(false);

        jLabel1.setText("Matricula:");

        jTxtMatricula.setName("jTxtMatricula"); // NOI18N
        jTxtMatricula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtMatriculaActionPerformed(evt);
            }
        });

        jLabel2.setText("Tiempo a contratar:");

        jTxtMinutos.setMaximumSize(new java.awt.Dimension(4, 4));
        jTxtMinutos.setMinimumSize(new java.awt.Dimension(0, 0));
        jTxtMinutos.setName("jTxtMinutos"); // NOI18N

        jLabel3.setText("Fecha:");

        dateChooserCombo1.setCurrentView(new datechooser.view.appearance.AppearancesList("Swing",
            new datechooser.view.appearance.ViewAppearance("custom",
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(0, 0, 0),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(0, 0, 0),
                    new java.awt.Color(0, 0, 255),
                    true,
                    true,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(0, 0, 255),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(128, 128, 128),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.LabelPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(0, 0, 0),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.LabelPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(0, 0, 0),
                    new java.awt.Color(255, 0, 0),
                    false,
                    false,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                (datechooser.view.BackRenderer)null,
                false,
                true)));
    dateChooserCombo1.setNothingAllowed(false);
    dateChooserCombo1.setWeekStyle(datechooser.view.WeekDaysStyle.FULL);
    dateChooserCombo1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

    jLabel4.setText("Id Venta: ");

    jButton1.setText("Aceptar");
    jButton1.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton1ActionPerformed(evt);
        }
    });

    jLabel6.setText("Inicio:");

    jLabel7.setText("Hora");

    jLabel8.setText("Minuto");

    jLabel9.setBackground(new java.awt.Color(255, 0, 0));
    jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    jLabel9.setEnabled(false);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addComponent(jButton1)
                    .addGap(90, 90, 90))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel4)
                        .addComponent(jLabel2)
                        .addComponent(jLabel1)
                        .addComponent(jLabel3)
                        .addComponent(jLabel6))
                    .addGap(44, 44, 44)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTxtMinutos, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTxtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(dateChooserCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTxtHoraInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel8)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTxtMinInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(34, 34, 34)
                            .addComponent(jLabel5)))
                    .addGap(31, 31, 31))))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addGap(45, 45, 45)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel1)
                .addComponent(jTxtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jTxtMinutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel2))
            .addGap(18, 18, 18)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(jLabel3)
                .addComponent(dateChooserCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel6)
                .addComponent(jLabel7)
                .addComponent(jTxtHoraInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel8)
                .addComponent(jTxtMinInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel4)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(7, 7, 7)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel5)
                .addComponent(jButton1))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTxtMatriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtMatriculaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtMatriculaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    	Manager m= new Manager();
        if (jTxtMatricula.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Error, Matricula incorrecta", "Matricula", JOptionPane.ERROR_MESSAGE);
        } else if (jTxtMinutos.getText().equals("") || Funciones.validarNumero(jTxtMinutos.getText()) == false) {
            JOptionPane.showMessageDialog(null, "Error, ingrese o verifique el tiempo a contratar, deben ser minutos", "Tiempo a contratar", JOptionPane.ERROR_MESSAGE);
        } else if (jTxtHoraInicio.getText().equals("") || Funciones.validarNumero(jTxtHoraInicio.getText()) == false||0>Integer.parseInt(jTxtHoraInicio.getText())||23<Integer.parseInt(jTxtHoraInicio.getText())) {
            JOptionPane.showMessageDialog(null, "Error, ingrese o verifique la Hora de Inicio", "Hora de Inicio", JOptionPane.ERROR_MESSAGE);
        } else if (jTxtMinInicio.getText().equals("") || Funciones.validarNumero(jTxtMinInicio.getText()) == false||0>Integer.parseInt(jTxtMinInicio.getText())||59<Integer.parseInt(jTxtMinInicio.getText())) {
            JOptionPane.showMessageDialog(null, "Error, ingrese o verifique los minutos de Inicio", "Minutos de Inicio", JOptionPane.ERROR_MESSAGE);


        } else {
            cal = dateChooserCombo1.getSelectedDate();
            dura = Integer.parseInt(jTxtMinutos.getText().toString());
           
            fechaVenta = cal;
            fechaVenta.set(Calendar.HOUR_OF_DAY, Integer.parseInt(jTxtHoraInicio.getText()));
            fechaVenta.set(Calendar.MINUTE, Integer.parseInt(jTxtMinInicio.getText()));
            fechaVenta.set(Calendar.SECOND,00);
            



            System.out.println(jTxtMatricula.getText().toString() + "#" + Funciones.calendar2String(cal, true) + "#" + dura);
            try {
                t = m.altaTicket(jTxtMatricula.getText().toString(), fechaVenta, dura);
            } catch (Exception e) {

                JOptionPane.showMessageDialog(null, "Hubo un problema con la venta. Intente mas tarde.", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            if (!t.getFechaVenta().equals("")) {
                jLabel9.setVisible(true);
                jLabel9.enable(true);
                jLabel9.setText(t.getIdVenta());


            } else {
                JOptionPane.showMessageDialog(null, "Hubo un problema con la venta. Intente mas tarde.", "Venta", JOptionPane.ERROR_MESSAGE);
                jTxtMatricula.setText("");
                jTxtMinutos.setText("");
                dateChooserCombo1.setCurrent(Calendar.getInstance());
            }
            repaint();
            this.setVisible(true);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new AltaTicket_().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private datechooser.beans.DateChooserCombo dateChooserCombo1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTxtHoraInicio;
    private javax.swing.JTextField jTxtMatricula;
    private javax.swing.JTextField jTxtMinInicio;
    private javax.swing.JTextField jTxtMinutos;
    // End of variables declaration//GEN-END:variables
    private Ticket t;
  
    Calendar cal = null;
    String fecha = "";
    String calend = "";
    int dura;
    Calendar fechaVenta = null;
}
