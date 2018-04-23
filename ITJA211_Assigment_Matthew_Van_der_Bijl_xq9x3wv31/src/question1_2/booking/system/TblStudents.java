package question1_2.booking.system;

import java.awt.HeadlessException;
import java.sql.SQLException;

import static question1_2.booking.system.Tables.TBL_STUDENTS;

/**
 * @author Matthew Van der Bijl - XQ9X3WV31
 */
public class TblStudents extends TableFrame {

    private static boolean IS_RUNNING = false;

    public TblStudents(BookingGUI parent) throws HeadlessException, SQLException,
            RuntimeException {
        super("~ Students Table ~", TBL_STUDENTS, parent);

        if (TblStudents.IS_RUNNING) {
            throw new RuntimeException("Students Table is already running.");
        } else {
            TblStudents.IS_RUNNING = true;
        }
    }

    @Override
    public void dispose() {
        TblStudents.IS_RUNNING = false;
        super.dispose();
    }
}
