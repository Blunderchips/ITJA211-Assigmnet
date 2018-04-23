package question1_2.booking.system;

/**
 * Used to identify tables.
 *
 * @author Matthew Van der Bijl - xq9x3wv31
 */
public enum Tables {

    TBL_STUDENTS("Students"), TBL_BOOKS("Books"),
    TBL_BOOKINGS("Bookings"), MINUS_ONE(null);

    Tables(String name) {
        this.name = name;
    }

    private final String name;

    @Override
    public String toString() {
        return this.name;
    }
}
