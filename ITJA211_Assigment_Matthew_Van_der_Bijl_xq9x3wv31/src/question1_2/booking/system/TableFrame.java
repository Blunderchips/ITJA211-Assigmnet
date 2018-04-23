package question1_2.booking.system;

import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import static question1_2.booking.system.Util.setTable;

/**
 * Parent of all table frames. Extends JFrame.
 *
 * @author Matthew Van der Bijl - XQ9X3WV31
 *
 * @see question1_2.booking.system.TblBookings
 * @see question1_2.booking.system.TblStudents
 * @see question1_2.booking.system.TblBooks
 */
public abstract class TableFrame extends JFrame {

    // varibles
    private final JTable table;
    private final JScrollPane tablePane;

    /**
     * @param title The title of the frame
     * @param table the table to be displayed
     * @param parent the parent frame of the tables
     */
    public TableFrame(String title, Tables table, BookingGUI parent) throws HeadlessException,
            SQLException {
        super(title);
        super.setLayout(new GridLayout(1, 1));

        Statement stmt = parent.getConnection().createStatement();
        this.table = new JTable(setTable(stmt.executeQuery(String.format(
                "SELECT * FROM %s", table.toString()))));
        this.tablePane = new JScrollPane(this.table);

        super.getContentPane().add(tablePane);
        super.pack();
        super.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        super.setLocationRelativeTo(parent);
    }
}
