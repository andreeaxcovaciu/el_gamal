
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


class Test3 {
    public static void main(String[] args) {
        Window win= new Window();
    }
}

class Window extends JFrame implements ItemListener {

    JTextArea ta= new JTextArea(2,25);
    JComboBox <String>combo1= new JComboBox<String>();

    public Window(){
        super ("ComboBox test");
        setSize(400,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        Container ca= getContentPane();
        ca.setBackground(Color.lightGray);
        FlowLayout flm= new FlowLayout();
        ca.setLayout(flm);
        combo1.addItemListener(this);
        combo1.addItem("JTest 1");
        combo1.addItem("JTest 2");
        ca.add(combo1);
        ca.add(ta);
        setContentPane(ca);
    }
    public void itemStateChanged(ItemEvent ev){
        String str = ev.getItem().toString();
        ta.setText(str);
    }
}//Window
