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
 * Used to capture the data of a new book.
 *
 * @author Matthew Van der Bijl - XQ9X3WV31
 */
public class InsertBook extends JDialog implements ActionListener {

    private static boolean IS_RUNNING = false;

    private boolean hasSelected;
    private final BookingGUI parent;

    //<editor-fold defaultstate="uncollapsed" desc="Input components">
    private final JLabel[] labels;
    private final JTextField[] inputs;

    private final JButton btnSubmit, btnClose;
    //</editor-fold>

    /**
     * Book data (Strings).
     */
    private String bookTitle, isbn, author, category, publisher;
    private String year, edition, numCopies; // integers

    @SuppressWarnings("LeakingThisInConstructor")
    public InsertBook(BookingGUI parent) throws HeadlessException, RuntimeException {
        super(parent, "~ Insert Book ~", true);

        if (InsertBook.IS_RUNNING) {
            throw new RuntimeException("InsertBook is already running.");
        } else {
            InsertBook.IS_RUNNING = true;
        }

        JPanel panel = new JPanel(new GridLayout(0, 2));
        panel.setBorder(BorderFactory.createEtchedBorder());

        this.parent = parent;
        this.hasSelected = false;
        this.labels = new JLabel[]{
            new JLabel("Title"),
            new JLabel("ISBN"),
            new JLabel("Author"),
            new JLabel("Year Published"),
            new JLabel("Edition"),
            new JLabel("Category"),
            new JLabel("Publisher"),
            new JLabel("Number of Copies")
        };

        this.inputs = new JTextField[labels.length];

        for (int i = 0;
                i < labels.length;
                i++) {
            panel.add(labels[i]);
            panel.add(inputs[i] = new JTextField(20));
        }

        this.btnSubmit = new JButton("Submit");

        this.btnSubmit.addActionListener(
                this);

        this.btnClose = new JButton("Close");

        this.btnClose.addActionListener(
                this);

        panel.add(btnSubmit);

        panel.add(btnClose);

        super.getContentPane()
                .add(panel);

        super.pack();

        super.setResizable(
                false);
        super.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        super.setLocationRelativeTo(parent);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        switch (evt.getActionCommand()) {
            case "Submit": {
                this.hasSelected = true;

                this.bookTitle = this.inputs[0].getText();
                this.isbn = this.inputs[1].getText();
                this.author = this.inputs[2].getText();
                this.year = this.inputs[3].getText();
                this.edition = this.inputs[4].getText();
                this.category = this.inputs[5].getText();
                this.publisher = this.inputs[6].getText();
                this.numCopies = this.inputs[7].getText();

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
    public void dispose() throws RuntimeException {
        InsertBook.IS_RUNNING = false;
        super.dispose();
    }

    public boolean hasSelected() throws RuntimeException {
//        if (!IS_RUNNING) {
//            throw new RuntimeException("Closed without selection.");
//        }
        return this.hasSelected;
    }

    public String getBookTitle() {
        return this.bookTitle;
    }

    public String getISBN() {
        return this.isbn;
    }

    public String getYearPublished() {
        return this.year;
    }

    public String getEdition() {
        return this.edition;
    }

    public String getCategory() {
        return this.category;
    }

    public String getPublisher() {
        return this.publisher;
    }

    public String getNumCopies() {
        return this.numCopies;
    }

    public String getAuthor() {
        return this.author;
    }
}
