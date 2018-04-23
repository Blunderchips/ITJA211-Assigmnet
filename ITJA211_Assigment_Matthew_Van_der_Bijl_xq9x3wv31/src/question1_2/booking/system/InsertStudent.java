package question1_2.booking.system;

import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Used to capture the data of a new student.
 *
 * @author Matthew Van der Bijl - XQ9X3WV31
 */
public class InsertStudent extends JDialog implements ActionListener {

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
    private String studentTitle, studentNumber, firstName, surname, cellNumber, address;

    @SuppressWarnings("LeakingThisInConstructor")
    public InsertStudent(BookingGUI parent) throws HeadlessException, RuntimeException {
        super(parent, "~ Insert Student ~", true);

        if (InsertStudent.IS_RUNNING) {
            throw new RuntimeException("InsertStudent is already running.");
        } else {
            InsertStudent.IS_RUNNING = true;
        }

        JPanel panel = new JPanel(new GridLayout(0, 2));
        panel.setBorder(BorderFactory.createEtchedBorder());

        this.hasSelected = false;
        this.labels = new JLabel[]{
            new JLabel("Title"),
            new JLabel("Student Number"),
            new JLabel("First Name"),
            new JLabel("Surname"),
            new JLabel("Cell Number"),
            new JLabel("Address")
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

                this.studentTitle = this.inputs[0].getText();
                this.studentNumber = this.inputs[1].getText();
                this.firstName = this.inputs[2].getText();
                this.surname = this.inputs[3].getText();
                this.cellNumber = this.inputs[4].getText();
                this.address = this.inputs[5].getText();

                this.dispose();
            }
            break;
            case "Close": {
                this.dispose();
            }
            break;
        }
    }

    @Override
    public void dispose() {
        InsertStudent.IS_RUNNING = false;
        super.dispose();
    }

    public boolean hasSelected() throws RuntimeException {
//        if (!IS_RUNNING) {
//            throw new RuntimeException("Closed without selection.");
//        }
        return this.hasSelected;
    }

    public String getStudentTitle() {
        return this.studentTitle;
    }

    public String getStudentNumber() {
        return this.studentNumber;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getSurname() {
        return this.surname;
    }

    public String getCellNumber() {
        return this.cellNumber;
    }

    public String getAddress() {
        return this.address;
    }
}
