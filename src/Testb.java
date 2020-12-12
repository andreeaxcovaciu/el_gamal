//3. Scrie?i o aplica?ie Java ce include un formular de înregistrare ca ?i student la un curs online. 
//Formularul include informa?ii referitoare la nume, prenume, an de studii, facultatea, finan?are taxa/buget
//?i cursul dorit. Anul de studii, facultatea ?i cursul sunt disponibile ca ?i lista de op?iuni, iar
//finan?area este de tip checkbox. Într-un câmp de tip TextArea afi?a?i informa?ia completata de student
//ca urmare a apasarii butonului de înregistrare. 
//Manuela-Ioana Csoma   manuela.csoma@yahoo.com
//02.12.2018

//clasa MyFrame
import java.awt.BorderLayout;

import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

class MyFramey extends JFrame {
    JPanel panel1, panel2, panel3; //frame-ul este impartit in 3 panel-uri
    Label nume, prenume, an, facultate, finantare, curs; //primul panel contine label-urile
    TextField n, p; //al doilea panel contine campurile aferente label-urilor
    JComboBox<String> a, fac, c;
    JCheckBox f1, f2;
    JButton inregistrare; //al treilea panel contine butonul pentru inregistrare si TextArea
    JTextArea text;
    String finantarea; //atribut pentru stocarea raspunsurilor din CheckBox-uri

    MyFramey(String title)
    {
        super(title);

        panel1 = new JPanel(); //setarea primului panel in partea stanga a frame-ului
        this.getContentPane().add(panel1, BorderLayout.WEST);
        panel1.setPreferredSize(new java.awt.Dimension(200, 350));

        panel1.setLayout(new GridLayout(6, 1)); //layout de tip Grid: 6 randuri si 1 coloana
        nume = new Label("Nume: "); //instantiere label-uri
        prenume = new Label("Prenume: ");
        an = new Label("An de studii: ");
        facultate = new Label("An de studii: ");
        finantare = new Label("Finantare: ");
        curs = new Label("Curs dorit: ");

        panel1.add(nume); //adaugare label-uri in primul panel
        panel1.add(prenume);
        panel1.add(an);
        panel1.add(facultate);
        panel1.add(finantare);
        panel1.add(curs);

        panel2 = new JPanel(); //setarea celui de-al doilea panel in partea dreapta a frame-ului
        this.getContentPane().add(panel2, BorderLayout.EAST);
        panel2.setPreferredSize(new java.awt.Dimension(250, 350));

        panel2.setLayout(new GridLayout(7, 1, 100, 35)); //layout de tip Grid: 7 randuri, 1 coloana, distanta dinte coloane 100 si distanta dintre randuri 15
        n = new TextField(30); //instantiere campurie aferente label-urilor
        p = new TextField(30);
        a = new JComboBox<String>();
        a.addItem("I"); //adaugare elemente in ComboBox
        a.addItem("II");
        a.addItem("III");
        a.addItem("IV");
        fac = new JComboBox<String>();
        fac.addItem("Facultatea de Electronica, Telecomunicatii si Tehnologia Informatiei"); //adaugare elemente in ComboBox
        fac.addItem("Facultatea de Automatica si Calculatoare");
        fac.addItem("Facultatea de Inginerie Electrica");
        f1 = new JCheckBox();
        f1.setText("Buget"); //adaugare text in CheckBox
        f2 = new JCheckBox();
        f2.setText("Taxa"); //adaugare text in CheckBox
        c =new JComboBox<String>();
        c.addItem("Ingineria programarii"); //adaugare elemente in ComboBox
        c.addItem("Teoria semnalelor");
        c.addItem("Circuite electronice fundamentale");

        panel2.add(n); //adaugarea campurilor TextField, ComboBox si CheckBox in cel de-al doilea panel
        panel2.add(p);
        panel2.add(a);
        panel2.add(fac);
        panel2.add(f1);
        panel2.add(f2);
        panel2.add(c);

        panel3 = new JPanel();  //setarea celui de-al treilea panel in partea de jos a frame-ului
        this.getContentPane().add(panel3, BorderLayout.SOUTH);
        panel3.setPreferredSize(new java.awt.Dimension(500, 300));

        panel3.setLayout(null); //layout null
        inregistrare = new JButton("INREGISTRARE"); //instantierea butonului inregistrare
        text = new JTextArea(10, 50); //adaugare TextArea cu 10 randuri si 50 coloane

        panel3.add(inregistrare); //adaugarea butonului inregistrare in cel de-al treilea panel
        inregistrare.setBounds(151, 50, 150, 30);
        inregistrare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inregistrareApasat(e);
            }
        }); //adaugare ActionListener() pentru acest buton

        panel3.add(text); //adaugare TextArea in cel de-al treilea panel
        text.setBounds(25, 100, 500, 170);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //inchiderea frame-ului
        setSize(550, 700); //setare dimensiune
        setVisible(true); //setare vizibilitate
    }

    protected void inregistrareApasat(ActionEvent e) //evenimetul declansat la apasarea butonului inregistrare
    {
        if(f1.isSelected()) //daca primul CheckBox e selectat, atunci atributul finantarea = "Buget"
        {
            finantarea = "Buget";
        }
        if(f2.isSelected()) //daca al doilea CheckBox e selectat, atunci atributul finantarea = "Taxa"
        {
            finantarea = "Taxa";
        }

        //se preia textul de la fiecare camp din panel2 si se adauga in TextArea din panel3
        text.setText("Formular de inscriere" + "\nNume: " + n.getText() +
                "\nPrenume: " + p.getText() +
                "\nAnul: " + a.getSelectedItem().toString() +
                "\nFacultatea: " + fac.getSelectedItem().toString() +
                "\nFinantare: " + finantarea +
                "\nCursul: " + c.getSelectedItem().toString());
    }
}


//clasa Test
public class Testb {
    public static void main(String[] args) {
        MyFramey frame = new MyFramey("MyFrame"); //instantiere obiect de tip MyFrame
    }
}

