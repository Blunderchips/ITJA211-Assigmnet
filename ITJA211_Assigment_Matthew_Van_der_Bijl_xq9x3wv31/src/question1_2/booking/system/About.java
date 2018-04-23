package question1_2.booking.system;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import javax.swing.JFrame;
import javax.swing.JTextArea;

/**
 *
 * @author Matthew Van der Bijl - XQ9X3WV31
 */
public class About extends JFrame {

    public About(Component parent) throws HeadlessException {
        super("~ About ~");

        super.setLayout(new GridLayout(1, 1));
        super.getContentPane().add(new JTextArea(
                "~ ITJA211 Assigment - Matthew Van der Bijl (xq9x3wv31) ~ \n\n"
                + "This Library Booking System is a program designed to help in "
                + "the administarive running and managment of a Libary.\n\n"
        ));

        super.pack();
        super.setResizable(true);
        super.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        super.setLocationRelativeTo(parent);
    }
}
