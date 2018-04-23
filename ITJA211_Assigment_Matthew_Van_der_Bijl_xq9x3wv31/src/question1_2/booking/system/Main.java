package question1_2.booking.system;

/**
 * Used to start the program.
 *
 * @author Matthew 'siD' Van der Bijl
 */
public final class Main {

    /**
     * Main method of the program. Responsible for stating the program.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BookingGUI main = new BookingGUI(null); // create a new frame
        main.setVisible(true);                  // make it visible
    }
}
