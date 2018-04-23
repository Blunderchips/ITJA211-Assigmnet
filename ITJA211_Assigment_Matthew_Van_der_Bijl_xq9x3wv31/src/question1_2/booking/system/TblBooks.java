package question1_2.booking.system;

import java.awt.HeadlessException;
import java.sql.SQLException;

import static question1_2.booking.system.Tables.TBL_BOOKS;

/**
 * @author Matthew Van der Bijl - XQ9X3WV31
 */
public class TblBooks extends TableFrame {

    private static boolean IS_RUNNING = false;

    public TblBooks(BookingGUI parent) throws HeadlessException, SQLException,
            RuntimeException {
        super("~ Books Table ~", TBL_BOOKS, parent);

        if (TblBooks.IS_RUNNING) {
            throw new RuntimeException("Books Table is already running.");
        } else {
            TblBooks.IS_RUNNING = true;
        }
    }

    @Override
    public void dispose() {
        TblBooks.IS_RUNNING = false;
        super.dispose();
    }
}
