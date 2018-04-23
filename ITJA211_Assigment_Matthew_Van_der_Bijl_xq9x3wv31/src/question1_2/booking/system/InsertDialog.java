package question1_2.booking.system;

import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;

import static question1_2.booking.system.Tables.*;

/**
 * @author Matthew Van der Bijl - xq9x3wv31
 */
public class InsertDialog extends JDialog implements ActionListener {

    private Tables selection;

    private final JButton btnStudent;
    private final JButton btnBook;
    private final JButton btnBooking;

    /**
     * @param parent
     */
    @SuppressWarnings("LeakingThisInConstructor")
    public InsertDialog(Frame parent) {
        super(parent, "What would you like to insert?", true);
        //super.setUndecorated(true);

        this.selection = null;

        this.btnStudent = new JButton("Insert a student");
        this.btnBook = new JButton("Insert a book");
        this.btnBooking = new JButton("Insert a booking");

        this.btnStudent.addActionListener(this);
        this.btnBook.addActionListener(this);
        this.btnBooking.addActionListener(this);

        super.setLayout(new GridLayout(1, 1));
        super.getContentPane().add(btnStudent);
        super.getContentPane().add(btnBook);
        super.getContentPane().add(btnBooking);

        super.pack();
        super.setLocationRelativeTo(parent);
        super.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource().equals(btnStudent)) {
            this.selection = TBL_STUDENTS;
        } else if (evt.getSource().equals(btnBook)) {
            this.selection = TBL_BOOKS;
        } else if (evt.getSource().equals(btnBooking)) {
            this.selection = TBL_BOOKINGS;
        } else {
            return;
        }
        this.dispose();
    }

    public boolean isSelecting() {
        return selection == null;
    }

    public Tables getSelection() {
        return this.selection;
    }

    @Override
    public void dispose() {
        if (selection == null) {
            this.selection = MINUS_ONE;
        }
        super.dispose();
    }
}
