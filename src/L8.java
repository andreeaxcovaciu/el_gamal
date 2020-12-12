

import java.awt.*;
import java.awt.event.*;
import java.util.Random;

class MyCanvas extends Canvas implements MouseListener {

    int width, height;
    int[] x = new int[400];
    int[] y = new int[400];


    public MyCanvas()
    {
        this.setSize(new Dimension(400, 400));
        this.setBackground(new Color(125, 125, 125));

        Random rand = new Random();

        for(int i = 0; i < 26; i++)
        {
            x[i] = rand.nextInt(400);
            y[i] = rand.nextInt(400);
            width = 30;
            height = 30;
        }

        this.addMouseListener(this);
    }

    public void paint(Graphics g){
        for(int i = 0; i < 26; i++)
        {
            Random rand1 = new Random();
            char c = (char)(rand1.nextInt(26) + 'a');
            String s = Character.toString(c);

            g.drawRect(x[i], y[i], width, height);

            g.drawString(s, x[i], y[i]);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }
}



class MyFrame extends Frame implements WindowListener {
    MyCanvas canvas;
    Label label;
    Button b1;

    MyFrame(String title){
        super(title);

        setLayout(new FlowLayout());

        canvas = new MyCanvas();
        label = new Label("Label");



        add(canvas);
        add(label);

        this.addWindowListener(this);

        setSize(500, 500);
        setVisible(true);
    }

    @Override
    public void windowOpened(WindowEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(1);

    }

    @Override
    public void windowClosed(WindowEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void windowIconified(WindowEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void windowActivated(WindowEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        // TODO Auto-generated method stub

    }

}

class Testy{
    public static void main(String...strings){
        MyFrame frame = new MyFrame("Aplicatie butoane");
    }
}
