
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;


class Sample2Frame extends JFrame {

    private JPanel jPanel1;
    private JCheckBox jCheckBox3;
    private JCheckBox jCheckBox2;
    private JCheckBox jCheckBox1;
    private JButton jButton2;
    private JButton jButton1;

    private Sample2Panel jPanel2;

    private int r = 0;
    private int g = 0;
    private int b = 0;

    private int pas = 10;

    public Sample2Frame() {
        super();
        initGUI();
    }

    private void initGUI() {
        try {

            setLayout(new BorderLayout());


            jPanel1 = new JPanel();
            this.getContentPane().add(jPanel1, BorderLayout.WEST);
            jPanel1.setPreferredSize(new java.awt.Dimension(148, 266));

            jButton2 = new JButton();
            jPanel1.add(jButton2);
            jButton2.setText("+++");
            jButton2.setPreferredSize(new java.awt.Dimension(95, 26));

            jButton2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    button2Apasat(evt);
                }
            });


            jButton1 = new JButton();
            jPanel1.add(jButton1);
            jButton1.setText("---");
            jButton1.setPreferredSize(new java.awt.Dimension(95, 26));

            jButton1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    button1Apasat(evt);
                }
            });


            jCheckBox1 = new JCheckBox();
            jPanel1.add(jCheckBox1);
            jCheckBox1.setText("rosu");
            jCheckBox1.setPreferredSize(new java.awt.Dimension(98, 25));
            jCheckBox1.setSelected(true);


            jCheckBox2 = new JCheckBox();
            jPanel1.add(jCheckBox2);
            jCheckBox2.setText("verde");
            jCheckBox2.setPreferredSize(new java.awt.Dimension(97, 23));
            jCheckBox2.setSelected(true);


            jCheckBox3 = new JCheckBox();
            jPanel1.add(jCheckBox3);
            jCheckBox3.setText("albastru");
            jCheckBox3.setPreferredSize(new java.awt.Dimension(100, 24));
            jCheckBox3.setSelected(true);


            jPanel2 = new Sample2Panel();
            this.getContentPane().add(jPanel2, BorderLayout.CENTER);
            jPanel2.setPreferredSize(new java.awt.Dimension(255, 266));

            jPanel2.seteazaCuloare(r, g, b);
            jPanel2.repaint();

            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            pack();
            setSize(400, 300);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void button2Apasat(ActionEvent evt) {
        if (jCheckBox1.isSelected() && r + pas < 256)
            r += pas;
        if (jCheckBox2.isSelected() && g + pas < 256)
            g += pas;
        if (jCheckBox3.isSelected() && b + pas < 256)
            b += pas;
        redeseneaza();
    }

    private void button1Apasat(ActionEvent evt) {
        if (jCheckBox1.isSelected() && r - pas > -1)
            r -= pas;
        if (jCheckBox2.isSelected() && g - pas > -1)
            g -= pas;
        if (jCheckBox3.isSelected() && b - pas > -1)
            b -= pas;
        redeseneaza();
    }

    private void redeseneaza(){
        jPanel2.seteazaCuloare(r, g, b);
        jPanel2.repaint();
    }
}




class Sample2Panel extends JPanel {

    private int albastru;
    private int verde;
    private int rosu;

    public void seteazaCuloare(int rosu, int verde, int albastru){
        this.rosu = rosu;
        this.verde = verde;
        this.albastru = albastru;
    }

    public void paint(Graphics g) {
        super.paint(g);

        g.setColor(new Color(rosu, verde, albastru));

        g.fillOval(0, 0, getWidth(), getHeight());
    }
}


class Testx {
    public static void main(String[] args) {
        Sample2Frame frame = new Sample2Frame();
        frame.setVisible(true);
    }
}
