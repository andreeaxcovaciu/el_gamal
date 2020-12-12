//1. Scrie?i o aplica?ie Java folosind biblioteca Swing în cadrul careia sunt afi?ate 3 componente de tip
//checkbox (JCheckBox), 3 componente de tip radio button (JRadioButton) ?i 3 componente de tip drop-down
//list (JComboBox). Selec?iile facute de utilizator vor fi afi?ate într-un câmp de tip eticheta (JLabel).
//Manuela-Ioana Csoma   manuela.csoma@yahoo.com
//08.12.2018

//clasa MyFrame
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Month;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

class MyFramexx extends JFrame {
    public JCheckBox check1, check2, check3;
    public JRadioButton radio1, radio2, radio3;
    public JComboBox combo1, combo2, combo3;
    public JLabel label1, label2, label3, label;
    public String[] days = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15",
            "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
    public String[] months = {"Ianuarie", "Februarie", "Martie", "Aprilie", "Mai", "Iunie", "Iulie",
            "August", "Septembrie", "Octombrie", "Noiembrie", "Decembrie"};
    public String[] years = {"2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018"};
    public String plecare, sosire, zi, luna, an;

    public MyFramexx(String title)
    {
        super(title);

        setLayout(null);

        //instantiere obiecte
        check1 = new JCheckBox("Cluj-Napoca");
        check2 = new JCheckBox("Sibiu");
        check3 = new JCheckBox("Bucuresti");
        radio1 = new JRadioButton("Cluj-Napoca");
        radio2 = new JRadioButton("Sibiu");
        radio3 = new JRadioButton("Bucuresti");
        combo1 = new JComboBox(days);
        combo2 = new JComboBox(months);
        combo3 = new JComboBox(years);
        label1 = new JLabel("Plecare: ");
        label2 = new JLabel("Sosire: ");
        label3 = new JLabel("Data: ");
        label = new JLabel();

        //adaugare ActionListener la fiecare buton
        check1.addActionListener(new MyActionListener(this));
        check2.addActionListener(new MyActionListener(this));
        check3.addActionListener(new MyActionListener(this));
        radio1.addActionListener(new MyActionListener(this));
        radio2.addActionListener(new MyActionListener(this));
        radio3.addActionListener(new MyActionListener(this));
        combo1.addActionListener(new MyActionListener(this));
        combo2.addActionListener(new MyActionListener(this));
        combo3.addActionListener(new MyActionListener(this));

        //plasarea obiectelor in Frame
        label1.setBounds(30, 10, 100, 20);
        check1.setBounds(100, 10, 100, 20);
        check2.setBounds(240, 10, 100, 20);
        check3.setBounds(350, 10, 100, 20);

        label2.setBounds(30, 50, 100, 20);
        radio1.setBounds(100, 50, 100, 20);
        radio2.setBounds(240, 50, 100, 20);
        radio3.setBounds(350, 50, 100, 20);

        label3.setBounds(30, 100, 100, 20);
        combo1.setBounds(100, 100, 100, 20);
        combo2.setBounds(225, 100, 100, 20);
        combo3.setBounds(350, 100, 100, 20);

        //adaugarea obiectelor in Frame
        add(label1);
        add(check1);
        add(check2);
        add(check3);
        add(label2);
        add(radio1);
        add(radio2);
        add(radio3);
        add(label3);
        add(combo1);
        add(combo2);
        add(combo3);

        label.setBounds(80, 150, 450, 20);
        add(label);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //inchiderea frame-ului
        setSize(500, 300); //setare dimensiune
        setVisible(true); //setare vizibilitate
    }

    public void setLabelText(String s) //functie pentru adaugarea textului in eticheta
    {
        label.invalidate(); //ajustarea dimensiunii etichetei
        label.setText(s);
        validate();
    }
}




class MyActionListener implements ActionListener {
    MyFramexx myframe; //obiect de tip MyFrame

    public MyActionListener(MyFramexx frame) //constructor
    {
        myframe = frame;
    }

    public void actionPerformed(ActionEvent e) {
        //daca unul din cele 3 CheckBox-uri este selectat, textul este stocat in atributul plecare
        //daca unul din cele 3 RadioButton-uri este selectat, textul este stocat in atributul sosire
        //data este preluata din cele 3 ComboBox-uri si stocata in atributele zi, luna si an
        if(myframe.check1.isSelected())
            myframe.plecare = myframe.check1.getText();
        if(myframe.check2.isSelected())
            myframe.plecare = myframe.check2.getText();
        if(myframe.check3.isSelected())
            myframe.plecare = myframe.check3.getText();
        if(myframe.radio1.isSelected())
            myframe.sosire = myframe.radio1.getText();
        if(myframe.radio2.isSelected())
            myframe.sosire = myframe.radio2.getText();
        if(myframe.radio3.isSelected())
            myframe.sosire = myframe.radio3.getText();
        myframe.zi = myframe.combo1.getSelectedItem().toString();
        myframe.luna = myframe.combo2.getSelectedItem().toString();
        myframe.an = myframe.combo3.getSelectedItem().toString();

        //plecarea, sosirea si data sunt afisate in eticheta
        myframe.setLabelText("Plecare: " + myframe.plecare + "   Sosire: " + myframe.sosire + "   Data: " + myframe.zi + "/" + myframe.luna + "/" + myframe.an);
    }
}


//clasa Test
public class ex1_l9_ela {
    public static void main(String[] args) {
        MyFramexx frame = new MyFramexx("My Frame");
    }
}
