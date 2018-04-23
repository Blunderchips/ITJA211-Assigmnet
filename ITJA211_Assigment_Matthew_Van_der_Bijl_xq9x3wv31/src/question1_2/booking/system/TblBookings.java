package question1_2.booking.system;

import java.awt.HeadlessException;
import java.sql.SQLException;

import static question1_2.booking.system.Tables.TBL_BOOKINGS;

/**
 * @author Matthew Van der Bijl - XQ9X3WV31
 */
public class TblBookings extends TableFrame {

    private static boolean IS_RUNNING = false;

    public TblBookings(BookingGUI parent) throws HeadlessException, SQLException,
            RuntimeException {
        super("~ Bookings Table ~", TBL_BOOKINGS, parent);

        if (TblBookings.IS_RUNNING) {
            throw new RuntimeException("Bookings Table is already running.");
        } else {
            TblBookings.IS_RUNNING = true;
        }
    }

    @Override
    public void dispose() {
        TblBookings.IS_RUNNING = false;
        super.dispose();
    }
}
