
package campus_bite;

import java.awt.print.PrinterException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.sql.DriverManager;
import java.sql.*;


public class MenuPage extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(MenuPage.class.getName());

    private double total = 0.0;
    private int x = 0;
    private double tax = 0.0;
    private String username;
    private Object math;
    private String buildOrderSummary() {

    StringBuilder sb = new StringBuilder();

    sb.append("Customer: ").append(username).append("\n");
    sb.append("================================\n");
    sb.append("Item\tQty\tPrice\n");

    if (jCheckBox1.isSelected())
        sb.append(jLabel20.getText()).append("\t")
          .append(jSpinner1.getValue()).append("\t")
          .append((int)jSpinner1.getValue() * 100).append("\n");

    if (jCheckBox2.isSelected())
        sb.append(jLabel14.getText()).append("\t")
          .append(jSpinner2.getValue()).append("\t")
          .append((int)jSpinner2.getValue() * 150).append("\n");

    if (jCheckBox4.isSelected())
        sb.append(jLabel25.getText()).append("\t")
          .append(jSpinner3.getValue()).append("\t")
          .append((int)jSpinner3.getValue() * 100).append("\n");

    if (jCheckBox5.isSelected())
        sb.append(jLabel33.getText()).append("\t")
          .append(jSpinner4.getValue()).append("\t")
          .append((int)jSpinner4.getValue() * 300).append("\n");

    if (jCheckBox6.isSelected())
        sb.append(jLabel40.getText()).append("\t")
          .append(jSpinner5.getValue()).append("\t")
          .append((int)jSpinner5.getValue() * 220).append("\n");

    if (jCheckBox7.isSelected())
        sb.append(jLabel66.getText()).append("\t")
          .append(jSpinner6.getValue()).append("\t")
          .append((int)jSpinner6.getValue() * 120).append("\n");

    if (jCheckBox8.isSelected())
        sb.append(jLabel72.getText()).append("\t")
          .append(jSpinner7.getValue()).append("\t")
          .append((int)jSpinner7.getValue() * 200).append("\n");

    if (jCheckBox9.isSelected())
        sb.append(jLabel78.getText()).append("\t")
          .append(jSpinner8.getValue()).append("\t")
          .append((int)jSpinner8.getValue() * 200).append("\n");

    if (jCheckBox10.isSelected())
        sb.append(jLabel84.getText()).append("\t")
          .append(jSpinner9.getValue()).append("\t")
          .append((int)jSpinner9.getValue() * 100).append("\n");

    if (jCheckBox11.isSelected())
        sb.append(jLabel101.getText()).append("\t")
          .append(jSpinner10.getValue()).append("\t")
          .append((int)jSpinner10.getValue() * 120).append("\n");

    if (jCheckBox12.isSelected())
        sb.append(jLabel90.getText()).append("\t")
          .append(jSpinner11.getValue()).append("\t")
          .append((int)jSpinner11.getValue() * 20).append("\n");

    if (jCheckBox13.isSelected())
        sb.append(jLabel96.getText()).append("\t")
          .append(jSpinner12.getValue()).append("\t")
          .append((int)jSpinner12.getValue() * 80).append("\n");

    sb.append("================================\n");
    sb.append("Subtotal: ").append(total).append("\n");
    sb.append("Tax: ").append(tax).append("\n");
    sb.append("Total: ").append(total + tax).append("\n");

    return sb.toString();
}
    public MenuPage(String username1) {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
         this.username = username1;
         
        init();
    }
 public final void init(){
     setTime();
       
    }
    public boolean qtyIsZero(int qty){
        if(qty==0){
            JOptionPane.showMessageDialog(null,"Please increase the item quantity");
            return false;
        }
          return true;
          }
    
    public void reset(){
        
        jButtonTotal.setEnabled(true);
        jSpinner1.setValue(0);
        
        jSpinner2.setValue(0);
        jSpinner3.setValue(0);
        jSpinner4.setValue(0);
        jSpinner5.setValue(0);
        jSpinner6.setValue(0);
        jSpinner7.setValue(0);
        jSpinner8.setValue(0);
        jSpinner9.setValue(0);
        jSpinner10.setValue(0);
        jSpinner11.setValue(0);
        jSpinner12.setValue(0);
        jTextFieldTax.setText("0.0");
        jTextFieldSubTotal.setText("0.0");
        jTextFieldTotal.setText("0.0");
        jTextArea2.setText("");
        jCheckBox1.setSelected(false);
        jCheckBox2.setSelected(false);
        jCheckBox4.setSelected(false);
        jCheckBox5.setSelected(false);
        jCheckBox6.setSelected(false);
        jCheckBox7.setSelected(false);
        jCheckBox8.setSelected(false);
        jCheckBox9.setSelected(false);
        
        jCheckBox10.setSelected(false);
        jCheckBox11.setSelected(false);
        jCheckBox12.setSelected(false);
        jCheckBox13.setSelected(false);
    
        
    }
    public void dudute(){
        jTextFieldTax.setText(String.valueOf(tax));
        jTextFieldSubTotal.setText(String.valueOf(total));
        jTextFieldTotal.setText(String.valueOf(total+tax));
        
    }
    public void gettax(double t){
    if(t <= 20){
        tax = 0.5;
    }
    else if(t <= 40){
        tax = 1.0;
    }
    else if(t <= 60){
        tax = 2.0;
    }
    else if(t <= 80){
        tax = 3.0;
    }
    else if(t <= 100){
        tax = 4.0;
    }
    else if(t <= 150){
        tax = 8.0;
    }
    else if(t <= 200){
        tax = 10.0;
    }
    else{
        tax = 15.0;
    }
}
    public void setTime(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        System.getLogger(MenuPage.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
                    }
                    Date date = new Date();
                    SimpleDateFormat tf = new SimpleDateFormat("h: mm: ss aa");
                    SimpleDateFormat df = new SimpleDateFormat("EEEE, dd-MMM-yyyy");
                    String dateStr = df.format(date);
                    jtextDate.setText(dateStr); 
                    String time = tf.format(date);
                    jtextTime1.setText(time);
                }
            }
        }).start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSpinner1 = new javax.swing.JSpinner();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jSpinner2 = new javax.swing.JSpinner();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jSpinner3 = new javax.swing.JSpinner();
        jCheckBox4 = new javax.swing.JCheckBox();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jSpinner4 = new javax.swing.JSpinner();
        jCheckBox5 = new javax.swing.JCheckBox();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jCheckBox6 = new javax.swing.JCheckBox();
        jSpinner5 = new javax.swing.JSpinner();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jCheckBox7 = new javax.swing.JCheckBox();
        jSpinner6 = new javax.swing.JSpinner();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jCheckBox8 = new javax.swing.JCheckBox();
        jSpinner7 = new javax.swing.JSpinner();
        jLabel71 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jCheckBox9 = new javax.swing.JCheckBox();
        jSpinner8 = new javax.swing.JSpinner();
        jLabel77 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        jCheckBox10 = new javax.swing.JCheckBox();
        jSpinner9 = new javax.swing.JSpinner();
        jLabel83 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        jCheckBox11 = new javax.swing.JCheckBox();
        jSpinner10 = new javax.swing.JSpinner();
        jLabel89 = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        jLabel92 = new javax.swing.JLabel();
        jLabel93 = new javax.swing.JLabel();
        jLabel94 = new javax.swing.JLabel();
        jCheckBox12 = new javax.swing.JCheckBox();
        jSpinner11 = new javax.swing.JSpinner();
        jLabel95 = new javax.swing.JLabel();
        jLabel96 = new javax.swing.JLabel();
        jLabel97 = new javax.swing.JLabel();
        jSpinner12 = new javax.swing.JSpinner();
        jLabel98 = new javax.swing.JLabel();
        jLabel100 = new javax.swing.JLabel();
        jCheckBox13 = new javax.swing.JCheckBox();
        jLabel101 = new javax.swing.JLabel();
        jLabel102 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jButtonBack = new javax.swing.JButton();
        jButtonRest = new javax.swing.JButton();
        jButtonReceipt = new javax.swing.JButton();
        jButtonTotal = new javax.swing.JButton();
        jtextDate = new javax.swing.JLabel();
        jtextTime1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jTextFieldTax = new javax.swing.JTextField();
        jTextFieldSubTotal = new javax.swing.JTextField();
        jTextFieldTotal = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel17 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSpinner1.setModel(new javax.swing.SpinnerNumberModel(0, 0, 50, 1));
        getContentPane().add(jSpinner1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 240, 100, 30));

        jCheckBox1.addActionListener(this::jCheckBox1ActionPerformed);
        getContentPane().add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 270, -1, -1));

        jCheckBox2.addActionListener(this::jCheckBox2ActionPerformed);
        getContentPane().add(jCheckBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 280, -1, -1));

        jSpinner2.setModel(new javax.swing.SpinnerNumberModel(0, 0, 50, 1));
        getContentPane().add(jSpinner2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 250, 70, 30));

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(153, 51, 0));
        jLabel13.setText("Rs. 150");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 230, -1, -1));

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel14.setText("Palak");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 200, -1, -1));

        jLabel19.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(153, 51, 0));
        jLabel19.setText("Rs. 100");
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 220, -1, -1));

        jLabel20.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel20.setText("Daal Chawal");
        getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 190, -1, -1));

        jLabel25.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel25.setText("Daal Fry");
        getContentPane().add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 200, -1, -1));

        jLabel26.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(153, 51, 0));
        jLabel26.setText("Rs. 100");
        getContentPane().add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 230, -1, -1));

        jSpinner3.setModel(new javax.swing.SpinnerNumberModel(0, 0, 50, 1));
        getContentPane().add(jSpinner3, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 250, 80, 30));

        jCheckBox4.addActionListener(this::jCheckBox4ActionPerformed);
        getContentPane().add(jCheckBox4, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 280, -1, -1));

        jLabel33.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel33.setText("Beef curry");
        getContentPane().add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 190, -1, -1));

        jLabel34.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(153, 51, 0));
        jLabel34.setText("Rs. 300");
        getContentPane().add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 220, -1, -1));

        jSpinner4.setModel(new javax.swing.SpinnerNumberModel(0, 0, 50, 1));
        getContentPane().add(jSpinner4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 240, 80, 30));

        jCheckBox5.addActionListener(this::jCheckBox5ActionPerformed);
        getContentPane().add(jCheckBox5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 270, -1, -1));

        jLabel36.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel36.setText("Product");
        getContentPane().add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 440, -1, -1));

        jLabel37.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel37.setText("Quantity");
        getContentPane().add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 460, -1, -1));

        jLabel38.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel38.setText("Purchase");
        getContentPane().add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 490, -1, -1));

        jCheckBox6.addActionListener(this::jCheckBox6ActionPerformed);
        getContentPane().add(jCheckBox6, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 490, -1, -1));

        jSpinner5.setModel(new javax.swing.SpinnerNumberModel(0, 0, 50, 1));
        getContentPane().add(jSpinner5, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 460, 80, 30));

        jLabel39.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(153, 51, 0));
        jLabel39.setText("Rs. 220");
        getContentPane().add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 440, -1, -1));

        jLabel40.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel40.setText("Chicken curry");
        getContentPane().add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 410, -1, -1));

        jLabel43.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel43.setText("Product");
        getContentPane().add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 220, -1, -1));

        jLabel55.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel55.setText("Product");
        getContentPane().add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 230, -1, -1));

        jLabel56.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel56.setText("Quantity");
        getContentPane().add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 250, -1, -1));

        jLabel57.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel57.setText("Purchase");
        getContentPane().add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 270, -1, -1));

        jLabel51.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel51.setText("Product");
        getContentPane().add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 230, -1, -1));

        jLabel52.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel52.setText("Quantity");
        getContentPane().add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 250, -1, -1));

        jLabel53.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel53.setText("Purchase");
        getContentPane().add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 270, -1, -1));

        jLabel59.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel59.setText("Product");
        getContentPane().add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 220, -1, -1));

        jLabel60.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel60.setText("Quantity");
        getContentPane().add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 240, -1, -1));

        jLabel61.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel61.setText("Purchase");
        getContentPane().add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 270, -1, -1));

        jLabel47.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel47.setText("Product");
        getContentPane().add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 220, -1, -1));

        jLabel48.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel48.setText("Quantity");
        getContentPane().add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 250, -1, -1));

        jLabel49.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel49.setText("Purchase");
        getContentPane().add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 270, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/campus_bite/Images/Beef.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 90, 170, 120));

        jLabel62.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel62.setText("Product");
        getContentPane().add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 430, -1, -1));

        jLabel63.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel63.setText("Quantity");
        getContentPane().add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 450, -1, -1));

        jLabel64.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel64.setText("Purchase");
        getContentPane().add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 480, -1, -1));

        jCheckBox7.addActionListener(this::jCheckBox7ActionPerformed);
        getContentPane().add(jCheckBox7, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 480, -1, -1));

        jSpinner6.setModel(new javax.swing.SpinnerNumberModel(0, 0, 50, 1));
        getContentPane().add(jSpinner6, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 450, 80, 30));

        jLabel65.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel65.setForeground(new java.awt.Color(153, 51, 0));
        jLabel65.setText("Rs. 120");
        getContentPane().add(jLabel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 430, -1, -1));

        jLabel66.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel66.setText("Mix vegetable");
        getContentPane().add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 400, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/campus_bite/Images/Daal_chawal.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 100, 170, 90));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/campus_bite/Images/Mix vegtable.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 320, 150, 90));

        jLabel68.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel68.setText("Product");
        getContentPane().add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 420, -1, -1));

        jLabel69.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel69.setText("Quantity");
        getContentPane().add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 440, -1, -1));

        jLabel70.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel70.setText("Purchase");
        getContentPane().add(jLabel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 470, -1, -1));

        jCheckBox8.addActionListener(this::jCheckBox8ActionPerformed);
        getContentPane().add(jCheckBox8, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 470, -1, -1));

        jSpinner7.setModel(new javax.swing.SpinnerNumberModel(0, 0, 50, 1));
        getContentPane().add(jSpinner7, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 440, 80, 30));

        jLabel71.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel71.setForeground(new java.awt.Color(153, 51, 0));
        jLabel71.setText("Rs. 200");
        getContentPane().add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 420, -1, -1));

        jLabel72.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel72.setText("Keema with roti");
        getContentPane().add(jLabel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 390, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/campus_bite/Images/Keema.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 330, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/campus_bite/Images/Chicken.png"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 330, -1, -1));

        jLabel74.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel74.setText("Product");
        getContentPane().add(jLabel74, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 430, -1, -1));

        jLabel75.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel75.setText("Quantity");
        getContentPane().add(jLabel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 450, -1, -1));

        jLabel76.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel76.setText("Purchase");
        getContentPane().add(jLabel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 480, -1, -1));

        jCheckBox9.addActionListener(this::jCheckBox9ActionPerformed);
        getContentPane().add(jCheckBox9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 480, -1, -1));

        jSpinner8.setModel(new javax.swing.SpinnerNumberModel(0, 0, 50, 1));
        getContentPane().add(jSpinner8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 450, 80, 30));

        jLabel77.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel77.setForeground(new java.awt.Color(153, 51, 0));
        jLabel77.setText("Rs. 170");
        getContentPane().add(jLabel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 430, -1, -1));

        jLabel78.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel78.setText("Saag with makai");
        getContentPane().add(jLabel78, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 400, -1, -1));

        jLabel80.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel80.setText("Product");
        getContentPane().add(jLabel80, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 650, -1, -1));

        jLabel81.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel81.setText("Quantity");
        getContentPane().add(jLabel81, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 670, -1, -1));

        jLabel82.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel82.setText("Purchase");
        getContentPane().add(jLabel82, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 700, -1, -1));

        jCheckBox10.addActionListener(this::jCheckBox10ActionPerformed);
        getContentPane().add(jCheckBox10, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 700, -1, -1));

        jSpinner9.setModel(new javax.swing.SpinnerNumberModel(0, 0, 50, 1));
        getContentPane().add(jSpinner9, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 670, 80, 30));

        jLabel83.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel83.setForeground(new java.awt.Color(153, 51, 0));
        jLabel83.setText("Rs. 100");
        getContentPane().add(jLabel83, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 650, -1, -1));

        jLabel84.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel84.setText("Chana Masala");
        getContentPane().add(jLabel84, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 620, -1, -1));

        jLabel86.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel86.setText("Product");
        getContentPane().add(jLabel86, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 640, -1, -1));

        jLabel87.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel87.setText("Quantity");
        getContentPane().add(jLabel87, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 660, -1, -1));

        jLabel88.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel88.setText("Purchase");
        getContentPane().add(jLabel88, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 690, -1, -1));

        jCheckBox11.addActionListener(this::jCheckBox11ActionPerformed);
        getContentPane().add(jCheckBox11, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 690, -1, -1));

        jSpinner10.setModel(new javax.swing.SpinnerNumberModel(0, 0, 50, 1));
        getContentPane().add(jSpinner10, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 660, 80, 30));

        jLabel89.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel89.setForeground(new java.awt.Color(153, 51, 0));
        jLabel89.setText("Rs. 80");
        getContentPane().add(jLabel89, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 640, -1, -1));

        jLabel90.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel90.setText("Salad");
        getContentPane().add(jLabel90, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 620, -1, -1));

        jLabel92.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel92.setText("Product");
        getContentPane().add(jLabel92, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 640, -1, -1));

        jLabel93.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel93.setText("Quantity");
        getContentPane().add(jLabel93, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 660, -1, -1));

        jLabel94.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel94.setText("Purchase");
        getContentPane().add(jLabel94, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 690, -1, -1));

        jCheckBox12.addActionListener(this::jCheckBox12ActionPerformed);
        getContentPane().add(jCheckBox12, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 690, -1, -1));

        jSpinner11.setModel(new javax.swing.SpinnerNumberModel(0, 0, 50, 1));
        getContentPane().add(jSpinner11, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 660, 80, 30));

        jLabel95.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel95.setForeground(new java.awt.Color(153, 51, 0));
        jLabel95.setText("Rs. 20");
        getContentPane().add(jLabel95, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 640, -1, -1));

        jLabel96.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel96.setText("Chapati");
        getContentPane().add(jLabel96, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 620, -1, -1));

        jLabel97.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel97.setText("Quantity");
        getContentPane().add(jLabel97, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 670, -1, -1));

        jSpinner12.setModel(new javax.swing.SpinnerNumberModel(0, 0, 50, 1));
        getContentPane().add(jSpinner12, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 660, 80, 30));

        jLabel98.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel98.setForeground(new java.awt.Color(153, 51, 0));
        jLabel98.setText("Rs. 120");
        getContentPane().add(jLabel98, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 640, -1, -1));

        jLabel100.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel100.setText("Purchase");
        getContentPane().add(jLabel100, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 690, -1, -1));

        jCheckBox13.addActionListener(this::jCheckBox13ActionPerformed);
        getContentPane().add(jCheckBox13, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 690, -1, -1));

        jLabel101.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel101.setText("Luki curry");
        getContentPane().add(jLabel101, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 620, -1, -1));

        jLabel102.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel102.setText("Product");
        getContentPane().add(jLabel102, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 650, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/campus_bite/Images/Saag.png"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 320, -1, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/campus_bite/Images/Luki.png"))); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 540, 130, 70));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/campus_bite/Images/Channa.png"))); // NOI18N
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 530, -1, 80));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/campus_bite/Images/salad.png"))); // NOI18N
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 540, -1, 80));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/campus_bite/Images/Roti.png"))); // NOI18N
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 550, 90, 60));

        jButtonBack.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/campus_bite/Images/Back.png"))); // NOI18N
        jButtonBack.setText("Back");
        jButtonBack.addActionListener(this::jButtonBackActionPerformed);
        getContentPane().add(jButtonBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 730, -1, 40));

        jButtonRest.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jButtonRest.setText("Rest");
        jButtonRest.addActionListener(this::jButtonRestActionPerformed);
        getContentPane().add(jButtonRest, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 730, -1, 40));

        jButtonReceipt.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jButtonReceipt.setText("Comfirm order");
        jButtonReceipt.addActionListener(this::jButtonReceiptActionPerformed);
        getContentPane().add(jButtonReceipt, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 730, -1, 40));

        jButtonTotal.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jButtonTotal.setText("Total");
        jButtonTotal.addActionListener(this::jButtonTotalActionPerformed);
        getContentPane().add(jButtonTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 730, -1, 40));

        jtextDate.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        getContentPane().add(jtextDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 730, 210, 30));

        jtextTime1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        getContentPane().add(jtextTime1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 730, 210, 30));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextFieldTax.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jTextFieldTax.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldTax.setText("0.0");
        jPanel1.add(jTextFieldTax, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 650, 160, -1));

        jTextFieldSubTotal.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jTextFieldSubTotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldSubTotal.setText("0.0");
        jPanel1.add(jTextFieldSubTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 680, 160, -1));

        jTextFieldTotal.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jTextFieldTotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldTotal.setText("0.0");
        jPanel1.add(jTextFieldTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 710, 160, -1));

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel15.setText("Total");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 710, -1, -1));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel12.setText("Sub Total");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 680, -1, -1));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel11.setText("Tax");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 650, -1, -1));

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 258, 450));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 490, -1, 130));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel17.setText("Address & Contact");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 0, 270, 770));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/campus_bite/Images/BackgroundMenu.png"))); // NOI18N
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 770));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    
     public void CampusBites(){
         int productId = 15020 + (int)(Math.random()*80800);
    jTextArea2.setText(
        "**************** Campus Bite **************\n" +
        "      Time: " + jtextTime1.getText() + "\n" +
        "      Date: " + jtextDate.getText() + "\n" +
        "      Product Id: "+ productId +
        "\n********************************************"+ "\nItem Name \t       qty\t "+"Price(pkr)\n");
}
    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        int qty = Integer.parseInt(jSpinner1.getValue().toString());
       if(qtyIsZero(qty)&&jCheckBox1.isSelected()){
           x++;
           if(x==1){
               CampusBites();
           }
           double price = qty*100;
           total += price;
           gettax(total);
           jTextArea2.setText(jTextArea2.getText()+ x +"." + jLabel20.getText()+"\t        "+qty+"\t"+price+"\n");  
           dudute();
       }
       else{
            jCheckBox1.setSelected(false);
       }
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
         int qty = Integer.parseInt(jSpinner2.getValue().toString());
       if(qtyIsZero(qty)&&jCheckBox2.isSelected()){
           x++;
           if(x==1){
               CampusBites();
           }
           double price = qty*150;
           total += price;
           gettax(total);
           jTextArea2.setText(jTextArea2.getText()+ x +"." + jLabel14.getText()+"\t        "+ qty +"\t"+price+"\n");
           dudute();
           
           
       }
       else{
            jCheckBox2.setSelected(false);
       }
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void jCheckBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox4ActionPerformed
         int qty = Integer.parseInt(jSpinner3.getValue().toString());
       if(qtyIsZero(qty)&&jCheckBox4.isSelected()){
           x++;
           if(x==1){
               CampusBites();
           }
           double price = qty*100;
           total += price;
           gettax(total);
           jTextArea2.setText(jTextArea2.getText()+ x +"." + jLabel25.getText()+"\t        "+ qty +"\t"+price+"\n");
           dudute();
           
           
       }
       else{
            jCheckBox4.setSelected(false);
       }
    }//GEN-LAST:event_jCheckBox4ActionPerformed

    private void jCheckBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox5ActionPerformed
     int qty = Integer.parseInt(jSpinner4.getValue().toString());
       if(qtyIsZero(qty)&&jCheckBox5.isSelected()){
           x++;
           if(x==1){
               CampusBites();
           }
           double price = qty*300;
           total += price;
           gettax(total);
           jTextArea2.setText(jTextArea2.getText()+ x +"." + jLabel33.getText()+"\t        "+ qty +"\t"+price+"\n");
           dudute();
           
           
       }
       else{
            jCheckBox5.setSelected(false);
       }
    }//GEN-LAST:event_jCheckBox5ActionPerformed

    private void jCheckBox6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox6ActionPerformed
         int qty = Integer.parseInt(jSpinner5.getValue().toString());
       if(qtyIsZero(qty)&&jCheckBox6.isSelected()){
           x++;
           if(x==1){
               CampusBites();
           }
           double price = qty*220;
           total += price;
           gettax(total);
           jTextArea2.setText(jTextArea2.getText()+ x +"." + jLabel40.getText()+"\t        "+ qty +"\t"+price+"\n");
           dudute();
           
           
       }
       else{
            jCheckBox6.setSelected(false);
       }
    }//GEN-LAST:event_jCheckBox6ActionPerformed

    private void jCheckBox7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox7ActionPerformed
         int qty = Integer.parseInt(jSpinner6.getValue().toString());
       if(qtyIsZero(qty)&&jCheckBox7.isSelected()){
           x++;
           if(x==1){
               CampusBites();
           }
           double price = qty*120;
           total += price;
           gettax(total);
           jTextArea2.setText(jTextArea2.getText()+ x +"." + jLabel66.getText()+"\t        "+ qty +"\t"+price+"\n");
           dudute();
           
           
       }
       else{
            jCheckBox7.setSelected(false);
       }
    }//GEN-LAST:event_jCheckBox7ActionPerformed

    private void jCheckBox8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox8ActionPerformed
        int qty = Integer.parseInt(jSpinner7.getValue().toString());
       if(qtyIsZero(qty)&&jCheckBox8.isSelected()){
           x++;
           if(x==1){
               CampusBites();
           }
           double price = qty*200;
           total += price;
           gettax(total);
           jTextArea2.setText(jTextArea2.getText()+ x +"." + jLabel72.getText()+"\t        "+ qty +"\t"+price+"\n");
           dudute();
           
           
       }
       else{
            jCheckBox8.setSelected(false);
       }
    }//GEN-LAST:event_jCheckBox8ActionPerformed

    private void jCheckBox9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox9ActionPerformed
          int qty = Integer.parseInt(jSpinner8.getValue().toString());
       if(qtyIsZero(qty)&&jCheckBox9.isSelected()){
           x++;
           if(x==1){
               CampusBites();
           }
           double price = qty*200;
           total += price;
           gettax(total);
           jTextArea2.setText(jTextArea2.getText()+ x +"." + jLabel78.getText()+"\t        "+ qty +"\t"+price+"\n");
           dudute();
       }
       else{
              jCheckBox9.setSelected(false);
       }
    }//GEN-LAST:event_jCheckBox9ActionPerformed

    private void jCheckBox10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox10ActionPerformed
          int qty = Integer.parseInt(jSpinner9.getValue().toString());
       if(qtyIsZero(qty)&&jCheckBox10.isSelected()){
           x++;
           if(x==1){
               CampusBites();
           }
           double price = qty*100;
           total += price;
           gettax(total);
           jTextArea2.setText(jTextArea2.getText()+ x +"." + jLabel84.getText()+"\t        "+ qty +"\t"+price+"\n");
           dudute();
       }
       else{
              jCheckBox10.setSelected(false);
       }
    }//GEN-LAST:event_jCheckBox10ActionPerformed

    private void jCheckBox11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox11ActionPerformed
           int qty = Integer.parseInt(jSpinner10.getValue().toString());
       if(qtyIsZero(qty)&&jCheckBox11.isSelected()){
           x++;
           if(x==1){
               CampusBites();
           }
           double price = qty*120;
           total += price;
           gettax(total);
           jTextArea2.setText(jTextArea2.getText()+ x +"." + jLabel101.getText()+"\t        "+ qty +"\t"+price+"\n");
           dudute();
       }
       else{
              jCheckBox11.setSelected(false);
       }
    }//GEN-LAST:event_jCheckBox11ActionPerformed

    private void jCheckBox12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox12ActionPerformed
             int qty = Integer.parseInt(jSpinner11.getValue().toString());
       if(qtyIsZero(qty)&&jCheckBox12.isSelected()){
           x++;
           if(x==1){
               CampusBites();
           }
           double price = qty*20;
           total += price;
           jTextArea2.setText(jTextArea2.getText()+ x +"." + jLabel90.getText()+"\t        "+ qty +"\t"+price+"\n");
           dudute();
       }
       else{
              jCheckBox12.setSelected(false);
       }
    }//GEN-LAST:event_jCheckBox12ActionPerformed

    private void jCheckBox13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox13ActionPerformed
             int qty = Integer.parseInt(jSpinner12.getValue().toString());
       if(qtyIsZero(qty)&&jCheckBox13.isSelected()){
           x++;
           if(x==1){
               CampusBites();
           }
           double price = qty*80;
           total += price;
           
           jTextArea2.setText(jTextArea2.getText()+ x +"." + jLabel96.getText()+"\t        "+ qty +"\t"+price+"\n");
           dudute();
       }
       else{
              jCheckBox13.setSelected(false);
       }
    }//GEN-LAST:event_jCheckBox13ActionPerformed

    private void jButtonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBackActionPerformed
        
        new loginpage().setVisible(true);
        
    }//GEN-LAST:event_jButtonBackActionPerformed

    private void jButtonRestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRestActionPerformed
        
        reset();
    }//GEN-LAST:event_jButtonRestActionPerformed


    
    private void jButtonReceiptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReceiptActionPerformed
        

        if(total != 0){
        try {
            jTextArea2.print();
        } catch (PrinterException ex) {
            System.getLogger(MenuPage.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        }else{
          JOptionPane.showMessageDialog(null,"you haven't select any order yet");
          
       
        }      
        try {
    Class.forName("com.mysql.cj.jdbc.Driver");

    Connection con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/javaproject_campusbite",
        "root",
        ""
    );

    String sql = "INSERT INTO orders (customer_name, items, total) VALUES (?, ?, ?)";
    PreparedStatement ps = con.prepareStatement(sql);

  
    ps.setString(1, username);

    
    ps.setString(2, buildOrderSummary());

    ps.setDouble(3, total + tax);

    ps.executeUpdate();

    JOptionPane.showMessageDialog(this, "Order Saved Successfully!");

} catch (Exception e) {
    e.printStackTrace();
}
    }//GEN-LAST:event_jButtonReceiptActionPerformed

    private void jButtonTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTotalActionPerformed
        if(total==0.0){
            JOptionPane.showMessageDialog(null,"You haven't select any item, yet");
        }else{
            jTextArea2.setText(jTextArea2.getText()+
             " \n"+"*********************************************\n"
            +"Tax: \t\t"+tax+ "\n"
            +"Sub Total \t\t"+total+"\n"
            +"Total \t\t"+(total+tax)
           +"\n\n\"****************Thank you***************\n\"\n"
            );
            jTextArea2.setText(jTextArea2.getText()+ "Address\n" +jTextArea1.getText()+"\n");       
        }
    }//GEN-LAST:event_jButtonTotalActionPerformed

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new MenuPage("Guest").setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBack;
    private javax.swing.JButton jButtonReceipt;
    private javax.swing.JButton jButtonRest;
    private javax.swing.JButton jButtonTotal;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox10;
    private javax.swing.JCheckBox jCheckBox11;
    private javax.swing.JCheckBox jCheckBox12;
    private javax.swing.JCheckBox jCheckBox13;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JCheckBox jCheckBox7;
    private javax.swing.JCheckBox jCheckBox8;
    private javax.swing.JCheckBox jCheckBox9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JSpinner jSpinner10;
    private javax.swing.JSpinner jSpinner11;
    private javax.swing.JSpinner jSpinner12;
    private javax.swing.JSpinner jSpinner2;
    private javax.swing.JSpinner jSpinner3;
    private javax.swing.JSpinner jSpinner4;
    private javax.swing.JSpinner jSpinner5;
    private javax.swing.JSpinner jSpinner6;
    private javax.swing.JSpinner jSpinner7;
    private javax.swing.JSpinner jSpinner8;
    private javax.swing.JSpinner jSpinner9;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextFieldSubTotal;
    private javax.swing.JTextField jTextFieldTax;
    private javax.swing.JTextField jTextFieldTotal;
    private javax.swing.JLabel jtextDate;
    private javax.swing.JLabel jtextTime1;
    // End of variables declaration//GEN-END:variables

   
}
