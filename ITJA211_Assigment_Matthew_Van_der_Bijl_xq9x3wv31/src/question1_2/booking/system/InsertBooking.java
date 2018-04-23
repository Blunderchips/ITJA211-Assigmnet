package question1_2.booking.system;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Used to capture the data of a new booking.
 *
 * @author Matthew Van der Bijl - XQ9X3WV31
 */
public class InsertBooking extends JDialog implements ActionListener {

    private static boolean IS_RUNNING = false;

    private boolean hasSelected;

    //<editor-fold defaultstate="uncollapsed" desc="Input components">
    private final JLabel[] labels;
    private final JTextField[] inputs;

    private final JButton btnSubmit, btnClose;
    //</editor-fold>

    /**
     * Book data (Strings).
     */
    private String bookingDate, reference, ISBN, bookTitle, studentName, studentSurname;

    @SuppressWarnings("LeakingThisInConstructor")
    public InsertBooking(JFrame parent) {
        super(parent, "~ Insert Booking ~", true);
        super.setLocationRelativeTo(parent);

        if (InsertBooking.IS_RUNNING) {
            throw new RuntimeException("InsertBooking is already running.");
        } else {
            InsertBooking.IS_RUNNING = true;
        }

        JPanel panel = new JPanel(new GridLayout(0, 2));
        panel.setBorder(BorderFactory.createEtchedBorder());

        this.hasSelected = false;
        this.labels = new JLabel[]{
            new JLabel("Booking Date"),
            new JLabel("reference"),
            new JLabel("ISBN"),
            new JLabel("Book Title"),
            new JLabel("Student Name"),
            new JLabel("Student Surname")
        };
        this.inputs = new JTextField[labels.length];

        for (int i = 0; i < labels.length; i++) {
            panel.add(labels[i]);
            panel.add(inputs[i] = new JTextField(20));
        }

        this.btnSubmit = new JButton("Submit");
        this.btnSubmit.addActionListener(this);
        this.btnClose = new JButton("Close");
        this.btnClose.addActionListener(this);

        panel.add(btnSubmit);
        panel.add(btnClose);

        super.getContentPane().add(panel);

        super.pack();
        super.setResizable(false);
        super.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        super.setLocationRelativeTo(parent);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        switch (evt.getActionCommand()) {
            case "Submit": {
                this.hasSelected = true;

                this.bookingDate = this.inputs[0].getText();
                this.reference = this.inputs[1].getText();
                this.ISBN = this.inputs[2].getText();
                this.bookTitle = this.inputs[3].getText();
                this.studentName = this.inputs[4].getText();
                this.studentSurname = this.inputs[5].getText();

                this.dispose();
            }
            break;
            case "Close": {
                this.dispose();
            }
            break;
        }
    }

    public String getBookingDate() {
        return this.bookingDate;
    }

    public String getReference() {
        return this.reference;
    }

    public String getISBN() {
        return this.ISBN;
    }

    public String getBookTitle() {
        return this.bookTitle;
    }

    public String getStudentName() {
        return this.studentName;
    }

    public String getStudentSurname() {
        return this.studentSurname;
    }

    public boolean hasSelected() throws RuntimeException {
//        if (!IS_RUNNING) {
//            throw new RuntimeException("Closed without selection.");
//        }
        return this.hasSelected;
    }
}
