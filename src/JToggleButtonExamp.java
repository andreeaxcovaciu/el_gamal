
import java.awt.BorderLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JFrame;
import javax.swing.JToggleButton;

public class JToggleButtonExamp {

    // Main Method
    public static void main(String args[])
    {

        // create a frame and set title
        JFrame frame = new JFrame("Selecting Toggle");

        // set the default close operation of the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // create a ToggleButton
        JToggleButton toggleButton = new JToggleButton("Toggle Button");

        // ItemListener is notified whenever you clcik on the Button
        ItemListener itemListener = new ItemListener() {

            // itemStateChanged() method is nvoked automatically
            // whenever you click or unlick on the Button.
            public void itemStateChanged(ItemEvent itemEvent)
            {

                // event is generated in button
                int state = itemEvent.getStateChange();

                // if selected print selected in console
                if (state == ItemEvent.SELECTED) {
                    System.out.println("Selected");
                }
                else {

                    // else print deselected in console
                    System.out.println("Deselected");
                }
            }
        };

        // Attach Listeners
        toggleButton.addItemListener(itemListener);
        frame.add(toggleButton, BorderLayout.NORTH);
        frame.setSize(300, 125);
        frame.setVisible(true);
    }
}
