import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;


class MyKeyListener_  implements KeyListener {


    @Override
    public void keyTyped(KeyEvent e) {
        char c = e.getKeyChar();

        if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
            e.consume();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}


class ElGamal extends JFrame implements ActionListener {
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JTextField tfB;
    private JLabel labelB;
    private JButton buttonComputePrimeB;
    private JButton buttonPublishKeysB;
    private JButton buttonSendMessage;
    private JLabel labelMessage;
    private JTextField textfieldMessage;
    private JTextArea labelprimeB;
    private JCheckBox checkPrime;
    private JTextArea sendTxtArea;

    //Bob's variables
    private JLabel bobLabel;
    private boolean bob = true;

    //Alice's variables
    private JLabel aliceLabel;
    private boolean alice = false;

    private JButton startButton;
    private JLabel label;
    private JLabel infos;
    private JToggleButton aliceORbob;
    private JLabel sender;
    boolean flag = true;
    public String name;

    //2nd panel
    private JLabel labelInfos;
    private JTextArea textAreaPanel2;
    private JTextArea textAreaPanel3;

    //3rd panel
    private JTextArea textAreaChat;
    private JScrollPane scrollPanel;

    private List<BigInteger> intList= new ArrayList<BigInteger>();

    public ElGamal(String el_gamal_algorithm){
        super();
        name = el_gamal_algorithm;
        initGui();
    }


    //Layout Window

    private void initGui() {
        setLayout(new BorderLayout());
        jPanel1 = new JPanel();
        jPanel2 = new JPanel(new SpringLayout());


        jPanel3 = new JPanel();
       // jPanel3.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        jPanel3.setPreferredSize(new java.awt.Dimension(150, 300));
        jPanel3.setBorder(BorderFactory.createLineBorder(Color.black));
        jPanel3.setBackground(new Color(0, 0, 0));
        //Layout
        this.getContentPane().add(jPanel1, BorderLayout.NORTH);
        this.getContentPane().add(jPanel2, BorderLayout.CENTER);
        this.getContentPane().add(jPanel3, BorderLayout.SOUTH);


        //PANEL 1

        //START button

        jPanel1.setPreferredSize(new java.awt.Dimension(600, 800));
        jPanel1.setBackground(new Color(0,0,0));
        //start button
        startButton = new JButton("START");
        Font  f  = new Font(Font.SANS_SERIF,  Font.BOLD, 30);
        startButton.setBounds(150, 100, 300,50);
        startButton.setBackground(new Color(255,255,255));
        startButton.setFont(f);
        jPanel1.add(startButton);
        //infos label

        infos= new JLabel("El Gamal Algorithm");
        infos.setBounds(startButton.getX() + 50, 160, 200,50);
        infos.setFont(new Font(Font.SANS_SERIF,  Font.ITALIC, 20));
        infos.setForeground(new Color(255 ,255,255));
        jPanel1.add(infos);

        Icon imgIcon = new ImageIcon(this.getClass().getResource("start.gif"));
        label = new JLabel(imgIcon);
        label.setBounds(startButton.getX() - 50, 225, 400, 400); // You can use your own values
        jPanel1.add(label);
        startButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                pressedStartButton();
            }
        });

        //preferences jPanel2
        jPanel2.setPreferredSize(new java.awt.Dimension(148, 200));
        jPanel2.setBorder(BorderFactory.createLineBorder(Color.black));
        jPanel2.setBackground(new Color(236, 235, 213));
        //preferences jPanel3

        jPanel2.setVisible(false);
        jPanel3.setVisible(false);

        Insets insets = jPanel1.getInsets();
        //initial labels


        //Alice label
        aliceLabel = new JLabel("Alice");
        aliceLabel.setBounds(25 + insets.left, 65 + insets.top, 50, 25);
        jPanel1.add(aliceLabel);
        aliceLabel.setVisible(false);

        //Bob label
        bobLabel = new JLabel("Bob");
        bobLabel.setBounds(475 + insets.left, aliceLabel.getY(), 50, 25);
        bobLabel.setBorder(BorderFactory.createLineBorder(Color.red));
        jPanel1.add(bobLabel);
        bobLabel.setVisible(false);

        //PANEL 1

        //Values for Bob
        //q

        labelB = new JLabel("Enter a prime number:");
        labelB.setBounds(50, 100 + insets.top, 150, 25);
        tfB = new JTextField();
        tfB.setBounds(labelB.getX(), labelB.getY() + 25, 150, 25);
        jPanel1.add(labelB);
        labelB.setVisible(false);
        jPanel1.add(tfB);
        tfB.setVisible(false);
        tfB.addKeyListener(new MyKeyListener_());

        checkPrime= new JCheckBox("", false);
        checkPrime.setBounds(tfB.getX(),tfB.getY() + 30, 20,20);
        checkPrime.setVisible(false);
        checkPrime.setOpaque(false);
        jPanel1.add(checkPrime);

        labelprimeB = new JTextArea("Check the box if you want to take \na prime number automatically");
        labelprimeB.setBounds(checkPrime.getX() + 30, checkPrime.getY(), 180, 35);
        labelprimeB.setOpaque(false);
        labelprimeB.setEditable(false);
        labelprimeB.setVisible(false);

        jPanel1.add(labelprimeB);


                //Prime Number Button
        buttonComputePrimeB = new JButton("Compute");
        buttonComputePrimeB.setBounds(checkPrime.getX(), checkPrime.getY() + 50, 100, 25);
        buttonComputePrimeB.setBackground(new Color(255, 255, 255));
        buttonComputePrimeB.setBorder(BorderFactory.createLineBorder(Color.black));
        jPanel1.add(buttonComputePrimeB);
        buttonComputePrimeB.setVisible(false);


        //Toggle Button
        sender = new JLabel("Choose the message sender");
        sender.setBounds((aliceLabel.getX() + bobLabel.getX())/2 - 50, aliceLabel.getY() - 60, 200,25);
        jPanel1.add(sender);
        sender.setVisible(false);
        aliceORbob = new JToggleButton("Bob");
        aliceORbob.setBounds(sender.getX() + 10, sender.getY() + 25 , 125,25);
        aliceORbob.setBackground(new Color(255, 255, 255));
        jPanel1.add(aliceORbob);
        aliceORbob.setVisible(false);
        aliceORbob.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent itemEvent) { itemAliceORBob(itemEvent); }});

        //Publish Keys Button
        buttonPublishKeysB = new JButton("Publish Keys");
        buttonPublishKeysB.setBounds(buttonComputePrimeB.getX(), buttonComputePrimeB.getY() + 50, 100, 25);
        buttonPublishKeysB.setBackground(new Color(255, 255, 255));
        buttonPublishKeysB.setBorder(BorderFactory.createLineBorder(Color.black));
        jPanel1.add(buttonPublishKeysB);
        buttonPublishKeysB.setVisible(false);


        //Message field
        labelMessage = new JLabel("Message: ");
        textfieldMessage = new JTextField ("Type your message here!");

        labelMessage.setBounds(bobLabel.getX() - 100, labelB.getY(), 100, 25);
        jPanel1.add(labelMessage);
        labelMessage.setVisible(false);

        jPanel1.add(textfieldMessage);
        textfieldMessage.setBounds(labelMessage.getX(), tfB.getY(), 150, 25);
        textfieldMessage.setVisible(false);
        textfieldMessage.addKeyListener(new MyKeyListener_());

        //Send a Message Button
        buttonSendMessage = new JButton("Send");
        buttonSendMessage.setBounds(labelMessage.getX(), buttonPublishKeysB.getY(), 100, 25);
        buttonSendMessage.setBackground(new Color(255, 255, 255));
        buttonSendMessage.setBorder(BorderFactory.createLineBorder(Color.black));
        jPanel1.add(buttonSendMessage);
        buttonSendMessage.setVisible(false);


        sendTxtArea = new JTextArea("The message is too big, \nless or equal to 0. \nIt must be lower than q, \nbut bigger than 0");
        sendTxtArea.setBounds(textfieldMessage.getX(), textfieldMessage.getY() + 30, 180, 70);
        sendTxtArea.setOpaque(false);
        sendTxtArea.setEditable(false);
        sendTxtArea.setVisible(false);

        jPanel1.add(sendTxtArea);

        jPanel1.setLayout(null);

        //PANEL 2


        SpringLayout layout = new SpringLayout();
        jPanel2.setLayout(layout);
        labelInfos = new JLabel("What is happening inside the algorithm?");
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER,labelInfos, 100, SpringLayout.SOUTH, jPanel2);
        layout.putConstraint(SpringLayout.VERTICAL_CENTER,labelInfos, 8, SpringLayout.NORTH, jPanel2);
        labelInfos.setVisible(false);
        jPanel2.add(labelInfos);

        textAreaPanel2 = new JTextArea("Waiting for Alice\n         to send cripting details...",7, 17);
        textAreaPanel2.setBorder(BorderFactory.createLineBorder(Color.black));
        textAreaPanel2.setVisible(false);

        layout.putConstraint(SpringLayout.SOUTH,textAreaPanel2, 150, SpringLayout.NORTH, labelInfos);
        layout.putConstraint(SpringLayout.EAST,textAreaPanel2, 200, SpringLayout.SOUTH, labelInfos);
        jPanel2.add(textAreaPanel2);
        textAreaPanel2.setEditable(false);


        textAreaPanel3 = new JTextArea("Waiting for " + aliceORbob.getText() + " \n         to send the message...",7, 17);
        textAreaPanel3.setBorder(BorderFactory.createLineBorder(Color.black));
        textAreaPanel3.setVisible(false);


        layout.putConstraint(SpringLayout.NORTH,textAreaPanel3, 35, SpringLayout.NORTH, labelInfos);
        layout.putConstraint(SpringLayout.WEST,textAreaPanel3, 200, SpringLayout.SOUTH, textAreaPanel2);
        jPanel2.add(textAreaPanel3);
        textAreaPanel3.setEditable(false);


        //PANEL 3

       // middlePanel=new JPanel();
        jPanel3.setBorder(new TitledBorder(new EtchedBorder(), "Chat Area"));

        // create the middle panel components

        textAreaChat = new JTextArea(10, 45);
        Font  f2  = new Font(Font.SANS_SERIF,  Font.BOLD, 12);
        textAreaChat.setFont(f2);
        textAreaChat.setEditable(false); // set textArea non-editable
        scrollPanel = new JScrollPane(textAreaChat);
        scrollPanel.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPanel.setVisible(false);
        jPanel3.add(scrollPanel);

        //ACTIONS

        buttonComputePrimeB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 pressedButtonToCompute(tfB,buttonPublishKeysB);
               // String s = String.valueOf(tfB.getText());

            }
        });

        checkPrime.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkPrime.isSelected()){
                    tfB.setEditable(false);
                    tfB.setText(checkPr());
                }
                else if (!checkPrime.isSelected()){tfB.setEditable(true);}
            }
        });
        buttonPublishKeysB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { intList = pressedButtonPublish(tfB);
            buttonSendMessage.setVisible(true);
                // int s = pressedButtonPublish(tfB);
                if (alice == true){
            textAreaPanel2.setText(bobLabel.getText() + " is sending cripting details...\n\n" +
                    bobLabel.getText() + "'s private key: " + intList.get(2) +
                    "\nPrime number q : " + intList.get(0)+
                    "\nGenerator alpha : " + intList.get(1) +
                    "\nh : " + intList.get(3));}


                else if (bob == true){
                    textAreaPanel2.setText(aliceLabel.getText() + " is sending cripting details...\n\n" +
                            aliceLabel.getText() + "'s private key: " + intList.get(2) +
                            "\nPrime number q : " + intList.get(0)+
                            "\nGenerator alpha : " + intList.get(1) +
                            "\nh : " + intList.get(3));
                }
               }});

        buttonSendMessage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<BigInteger> list;
                BigInteger m = BigInteger.valueOf(Long.parseLong(textfieldMessage.getText()));
                int m1= m.compareTo(intList.get(0));
                int m2 = m.compareTo(BigInteger.valueOf(0));
                if ((m2 == 0) || (m2 == -1) || (m1 == 0) || (m1 == 1)) {textfieldMessage.setText("0"); sendTxtArea.setVisible(true); }
                else {sendTxtArea.setVisible(false);
                    list = cripting(textfieldMessage,intList);

                    if (alice == true){
                    textAreaPanel3.setText(aliceORbob.getText() + " is sending the cripted message...\n\n" +
                            aliceORbob.getText() + "'s cripted message: " +
                            "\nC = (C1,C2): (" + list.get(0)+ "," + list.get(1) + ")" +
                            "\nk : " + list.get(2));}
                    else if (bob == true) {
                        textAreaPanel3.setText(aliceORbob.getText() + " is sending the cripted message...\n\n" +
                                aliceORbob.getText() + "'s cripted message: " +
                                "\nC = (C1,C2): (" + list.get(0)+ "," + list.get(1) + ")" +
                                "\nk : " + list.get(2));}

                   BigInteger message  ;
                    message = decript(list, intList);
                    if (alice == true){

                        textAreaChat.setText(textAreaChat.getText() + "\n"+ "<html><font color=\"red\">"+ aliceORbob.getText() + "</font></html>:" + message);
                    }
                    else if (bob == true){

                        textAreaChat.setText(textAreaChat.getText() + "\n"+ aliceORbob.getText() + ":" + message);
                    }

                }


            }});



        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        validate();
        setSize(600, 800);
    }


    //  FUNCTIONALITY
    //computing the prime number


        protected boolean primeNr(int nr) {

            if (nr == 4) flag = false;
            if (nr <= 1) flag = false;
            else for (int i = 2; i < nr/2; i++) {
                if (nr % i == 0) {
                    flag = false;
                    break;}}

        return flag;
    }



    protected boolean pressedButtonToCompute(JTextField jTextField, JButton button){
        try{  int nr = Integer.parseInt(jTextField.getText());
           primeNr(nr);

            if(!flag) {jTextField.setText("It is not a prime number!"); button.setVisible(false); flag = true;}
            else  {button.setVisible(true); flag = true;}


            } catch (NumberFormatException ex) {
            }
        return flag;
    }

    protected void pressedStartButton(){
        startButton.setVisible(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(100, 300));
        jPanel1.setBorder(BorderFactory.createLineBorder(Color.black));
        label.setVisible(false);
        infos.setVisible(false);
        jPanel1.setBackground(new Color(236, 235, 223));
        jPanel2.setVisible(true);
        jPanel3.setVisible(true);
        tfB.setVisible(true);
        buttonComputePrimeB.setVisible(true);
        labelB.setVisible(true);
        aliceLabel.setVisible(true);
        bobLabel.setVisible(true);
        aliceORbob.setVisible(true);
        sender.setVisible(true);
        buttonPublishKeysB.setVisible(false);
        labelMessage.setVisible(true);
        textfieldMessage.setVisible(true);
        checkPrime.setVisible(true);
        labelprimeB.setVisible(true);
        textAreaPanel3.setVisible(true);
        textAreaPanel2.setVisible(true);
        labelInfos.setVisible(true);
        scrollPanel.setVisible(true);
    }

    protected void itemAliceORBob(ItemEvent ie){
        Insets insets = jPanel1.getInsets();
        // event is generated in button
        int state = ie.getStateChange();

        // if selected print selected in console
        if (state == ItemEvent.SELECTED) {
            aliceORbob.setText("Alice");
            bobLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder());
            aliceLabel.setBorder(BorderFactory.createLineBorder(Color.red));
            labelB.setBounds(bobLabel.getX() - 100, 100 + insets.top, 150, 25);
            tfB.setBounds(labelB.getX(), labelB.getY() + 25, 150, 25);
            checkPrime.setBounds(tfB.getX(),tfB.getY() + 30, 20,15);
            buttonComputePrimeB.setBounds(checkPrime.getX(), checkPrime.getY() + 50, 100, 25);
            buttonPublishKeysB.setBounds(buttonComputePrimeB.getX(), buttonComputePrimeB.getY() + 50, 100, 25);
            buttonPublishKeysB.setVisible(false);
            labelMessage.setBounds(50, 100 + insets.top,100, 25);
            textfieldMessage.setBounds(labelMessage.getX(), tfB.getY(), 150, 25);
            buttonSendMessage.setBounds(labelMessage.getX(), buttonPublishKeysB.getY(), 100, 25);

            labelprimeB.setBounds(checkPrime.getX() + 30, checkPrime.getY(), 180, 35);
            sendTxtArea.setBounds(textfieldMessage.getX(), textfieldMessage.getY() + 30, 180, 35);
            textAreaPanel2.setText("Waiting for Bob\n        to send cripting details...");
            textAreaPanel3.setText("Waiting for " + aliceORbob.getText() + "\n        to send the message...");
            alice = true;
            bob = false;

        }
        else {
            aliceORbob.setText("Bob");
            aliceLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder());
            bobLabel.setBorder(BorderFactory.createLineBorder(Color.red));
            labelB.setBounds(50, 100 + insets.top, 150, 25);
            tfB.setBounds(labelB.getX(), labelB.getY() + 25, 150, 25);
            checkPrime.setBounds(tfB.getX(),tfB.getY() + 30, 20,15);
            labelprimeB.setBounds(checkPrime.getX() + 30, checkPrime.getY(), 180, 35);
            buttonComputePrimeB.setBounds(checkPrime.getX(), checkPrime.getY() + 50, 100, 25);
            buttonPublishKeysB.setBounds(buttonComputePrimeB.getX(), buttonComputePrimeB.getY() + 50, 100, 25);
            buttonPublishKeysB.setVisible(false);
            labelMessage.setBounds(bobLabel.getX() - 100, labelB.getY(), 100, 25);
            textfieldMessage.setBounds(labelMessage.getX(), tfB.getY(), 150, 25);
            buttonSendMessage.setBounds(labelMessage.getX(), buttonPublishKeysB.getY(), 100, 25);

            //labelprimeB.setBounds(checkPrime.getX() + 30, checkPrime.getY(), 180, 35);
            sendTxtArea.setBounds(textfieldMessage.getX(), textfieldMessage.getY() + 30, 180, 35);
            textAreaPanel2.setText("Waiting for Alice\n        to send cripting details...");
            textAreaPanel3.setText("Waiting for " + aliceORbob.getText() + "\n        to send the message...");
            alice = false;
            bob = true;

        }
    }


    protected String checkPr(){
        String line = new String();
        try
        {
            StringBuffer sb=new StringBuffer();    //constructs a string buffer with no characters

            Path path = Paths.get("primes-to-100k.txt");
            int nr = (int) (Math.random() * (Files.readAllLines(path).size() - 2) + 2);
            line = Files.readAllLines(path).get(nr);
            if((line)!=null)
            {
                sb.append(line);      //appends line to string buffer
                sb.append("\n");     //line feed
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        return line;
    }
    public  ArrayList<BigInteger> try100(BigInteger q) {
        int o = 1;
        int k;
        ArrayList<BigInteger> roots = new ArrayList<>();
        int z = 0;



        for (int r = 2; r < q.longValue(); r++) {
            k = (int) Math.pow(r, o);
            k %= q.longValue();
            while (k > 1) {
                o++;
                k *= r;
                k %= q.longValue();
            }
            if (o == (q.longValue() - 1)) {
                roots.add(BigInteger.valueOf(r));
                z++;
            }
            o = 1;
        }

        for (int y = 0; y < z; y++) {
            System.out.print(roots.get(y) + ", ");
        }
        return roots;
    }

    protected List<BigInteger> pressedButtonPublish(JTextField txtText){
        List<BigInteger> list = new ArrayList<>();
        int min = 2;
        long s;
        BigInteger alpha;
        BigInteger h;
        BigInteger q;

        List<BigInteger> array;
        try {
            q = BigInteger.valueOf(Long.parseLong(txtText.getText()));

            int max = q.intValue() - 1;
            System.out.println("qx=" + q);
            //int max = 50;
            s = (long) (Math.random() * (max - min + 1) + min);
            // s1 = 2;
            System.out.println("s=" + s);
            array = try100(q);

            alpha = array.get((int) (Math.random() * (array.size()- min -2 ) + min));

            System.out.println("a=" + alpha);
            BigInteger h1p = power(alpha,s);
            h =h1p.mod(q);
            System.out.println("h=" + h);
            list.add( q);
            list.add( BigInteger.valueOf(s));
            list.add(alpha);
            list.add( h);
        }catch(NumberFormatException ex){};
        return list;

    }

    public  List<BigInteger> cripting (JTextField jtf2, List<BigInteger> listC){
        BigInteger c11;
        BigInteger c12;
        BigInteger k;
        BigInteger m;
        List<BigInteger> list = new ArrayList<>();
        try {
            m = BigInteger.valueOf(Long.parseLong(jtf2.getText()));

            int max = listC.get(0).intValue() - 1;

            k = BigInteger.valueOf((long) (Math.random() * max + 1));
            System.out.println("k= " +k );
            BigInteger c11p = power(listC.get(2),k.longValue());
            c11 = c11p.mod(listC.get(0));

            BigInteger c12p = power(listC.get(3),k.longValue());

            System.out.println("c12p=" + c12p);

            System.out.println("m=" + m);
            BigInteger c12pp = m.multiply(c12p);
            System.out.println("c12pp " + c12pp);
            c12 =c12pp.mod(listC.get(0));

            list.add(c11);
            list.add(c12);
            list.add(k);
        }catch(NumberFormatException | IndexOutOfBoundsException e ){}
        System.out.println("c1,c2:" +list);
        return list;
    }



    public BigInteger decript(List<BigInteger> list, List<BigInteger> list2){
        System.out.println("c1 =" + list2.get(0) + "; c2=" + list2.get(1) + "; q = " + list.get(0) + " s=" + list.get(1));
        BigInteger c1 = list.get(0);
        BigInteger c2 = list.get(1);
        BigInteger q =  list2.get(0);
        BigInteger s = list2.get(1);
        BigInteger m ;
        BigInteger intermidiator = power(c1,s.longValue());
        System.out.println("intermidiator: " + intermidiator);

        BigInteger intermidiator2 = intermidiator.mod(q);
        System.out.println("intermidiator2: " + intermidiator2);

        BigInteger intermidiator3 = power(intermidiator2, (q.longValue()-2));
        System.out.println("intermidiator3: " + intermidiator3);
        BigInteger mp = c2.multiply(intermidiator3);
        m =mp.mod(q);
        System.out.println("list =" +list + "\nlist2 ="+list2);
        System.out.println("mD: " + m );
        //int compare = m.compareTo(BigInteger.valueOf(122));

       // if( compare != 0) {System.out.println("NU E DECRIPTAT COREEEEEEEEECT!!!!!!!!!!!!!!!!!");};
        return m;
    }

    //used
    public BigInteger power (BigInteger base, long exponent){

        BigInteger result = BigInteger.valueOf(1);

        while (exponent != 0)
        {
            result =result.multiply(new BigInteger(String.valueOf(base)));
            --exponent;
        }
        return result;
    }

        @Override
    public void actionPerformed(ActionEvent e) {

    }
}

public class WindowUX {
    public static void main(String[] args) {
        ElGamal frame = new ElGamal("El Gamal Algorithm");
        frame.setVisible(true);
        frame.setResizable(false);

    }
}
