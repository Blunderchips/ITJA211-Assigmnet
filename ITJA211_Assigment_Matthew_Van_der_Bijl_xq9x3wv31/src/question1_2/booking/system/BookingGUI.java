package question1_2.booking.system;

import static question1_2.booking.system.Util.setTable;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import static question1_2.booking.system.Tables.*;

/**
 * <code>BookingGUI</code> Frame.
 *
 * @author Matthew Van der Bijl - XQ9X3WV31
 *
 * @see javax.swing.JFrame
 * @see java.awt.event.ActionListener
 * @see javax.swing.event.ListSelectionListener
 */
public class BookingGUI extends JFrame implements ActionListener, ListSelectionListener {

    private Connection conn;

    private JTable table;
    private JScrollPane tablePane;

    private final JTextArea txtMain;
    private final JTextArea txtBooks;
    private final JTextArea txtStudents;
    private final JTextArea txtBookings;
    private final JTabbedPane mainPannel;

    //<editor-fold defaultstate="collapsed" desc="Buttons">
    private final Button btnBooking;
    private final Button btnReturnBook;
    private final Button btnSearch;
    private final Button btnInsert;

    private final Button btnStudentsUpdate;
    private final Button btnStudentsInsert;
    private final Button btnStudentsSearch;
    private final Button btnStudentsDelete;

    private final Button btnBooksInsert;
    private final Button btnBooksSearch;
    private final Button btnBooksDelete;
    private final Button btnBooksUpdate;

    private final Button btnBookingsInsert;
    private final Button btnBookingsSearch;
    private final Button btnBookingsDelete;
    //</editor-fold>

    /**
     * @param parent the parent of <code>this</code> window
     * @throws HeadlessException
     */
    @SuppressWarnings("LeakingThisInConstructor")
    public BookingGUI(Component parent) throws HeadlessException {
        super("~ Libary Booking System ~");

        this.mainPannel = new JTabbedPane();
        this.txtMain = new JTextArea();
        this.txtMain.setEditable(false);

        this.txtBooks = new JTextArea();
        this.txtBooks.setEditable(false);

        this.txtStudents = new JTextArea();
        this.txtStudents.setEditable(false);

        this.txtBookings = new JTextArea();
        this.txtBookings.setEditable(false);

        //<editor-fold defaultstate="collapsed" desc="Buttons">
        this.btnBooking = new Button("Reserve a Book", "btnBooking", "Click to make a booking", this);
        this.btnReturnBook = new Button("Return a book", "btnReturnBook", "Click to return a book", this);
        this.btnSearch = new Button("Search", "btnSearch", "Click to search the database", this);
        this.btnInsert = new Button("Insert", "btnInsert", "Click to a new a record", this);

        this.btnStudentsInsert = new Button("Insert", "btnStudentsInsert", "Click to Insert a new Student", this);
        this.btnStudentsDelete = new Button("Delete", "btnStudentsDelete", "Click to Delete a Student", this);
        this.btnStudentsUpdate = new Button("Update", "btnStudentsUpdate", "Click to Update a Student", this);
        this.btnStudentsSearch = new Button("Search", "btnStudentsSearch", "Click to Search for a Student", this);

        this.btnBooksInsert = new Button("Insert", "btnBooksInsert", "Click to Insert new a Book", this);
        this.btnBooksDelete = new Button("Delete", "btnBooksDelete", "Click to Delete a Book", this);
        this.btnBooksUpdate = new Button("Update", "btnBooksUpdate", "Click to Update a Book", this);
        this.btnBooksSearch = new Button("Search", "btnBooksSearch", "Click to Search for a Book", this);

        this.btnBookingsInsert = new Button("Insert", "btnBookingsInsert", "Click to Insert new a Booking", this);
        this.btnBookingsDelete = new Button("Delete", "btnBookingsDelete", "Click to Delete a Booking", this);
        this.btnBookingsSearch = new Button("Search", "btnBookingsSearch", "Click to Search for a Booking", this);
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="File Bar">
        final BookingGUI bookingGUI = this; // for anonymous passing

        JMenuBar menuBar = new JMenuBar();
        JMenu file = new JMenu("File");
        file.addActionListener(this);

        JMenuItem menuAbout = new JMenuItem("About") {

            @Override
            public String getName() {
                return "menuAbout";
            }
        };
        menuAbout.addActionListener((ActionEvent evt) -> {
            new About(bookingGUI).setVisible(true);
        });
        file.add(menuAbout);

        JMenuItem menuClose = new JMenuItem("Close") {

            @Override
            public String getName() {
                return "menuClose";
            }
        };
        menuClose.addActionListener((ActionEvent evt) -> {
            if (JOptionPane.showConfirmDialog(bookingGUI, "Are you sure you want to "
                    + "close the program?", "Are you sure?", JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE) == 0) {
                dispose();
                System.exit(0);
            }
        });
        file.add(menuClose);

        JMenu tables = new JMenu("Tables");
        tables.addActionListener(this);
        JMenuItem menuTblStudents = new JMenuItem("Students Table") {

            @Override
            public String getName() {
                return "menuTblStudents";
            }
        };
        menuTblStudents.addActionListener((evt) -> {
            try {
                new TblStudents(BookingGUI.this).setVisible(true);
            } catch (SQLException sqle) {
                sqle.printStackTrace(System.err);
                JOptionPane.showMessageDialog(this, sqle.getMessage(), sqle.getClass()
                        .getSimpleName(), JOptionPane.ERROR_MESSAGE);
            } catch (RuntimeException ignore) {
            }
        });
        tables.add(menuTblStudents);

        JMenuItem menuTblBooks = new JMenuItem("Books Table") {

            @Override
            public String getName() {
                return "menuTblBooks";
            }
        };
        menuTblBooks.addActionListener((evt) -> {
            try {
                new TblBooks(BookingGUI.this).setVisible(true);
            } catch (SQLException sqle) {
                sqle.printStackTrace(System.err);
                JOptionPane.showMessageDialog(this, sqle.getMessage(), sqle.getClass()
                        .getSimpleName(), JOptionPane.ERROR_MESSAGE);
            } catch (RuntimeException ignore) {
            }
        });
        tables.add(menuTblBooks);

        JMenuItem menuTblBookings = new JMenuItem("Bookings Table") {

            @Override
            public String getName() {
                return "menuTblBookings";
            }
        };
        menuTblBookings.addActionListener((evt) -> {
            try {
                new TblBookings(BookingGUI.this).setVisible(true);
            } catch (SQLException sqle) {
                sqle.printStackTrace(System.err);
                JOptionPane.showMessageDialog(this, sqle.getMessage(), sqle.getClass()
                        .getSimpleName(), JOptionPane.ERROR_MESSAGE);
            } catch (RuntimeException ignore) {
            }
        });
        tables.add(menuTblBookings);

        menuBar.add(file);
        menuBar.add(tables);
        super.setJMenuBar(menuBar);
        //</editor-fold>

        this.dbConnection();

        super.setSize(16 * 75, 9 * 75); // 16 x 9 resolution

        JPanel studentsOptionsPannel = new JPanel(new GridLayout(0, 1));
        studentsOptionsPannel.setBorder(BorderFactory.createTitledBorder("Students"));
        JPanel studentsCRUDPanel = new JPanel(new GridLayout(0, 3));
        for (JButton btn : new JButton[]{
            btnStudentsInsert, btnStudentsUpdate, btnStudentsDelete
        }) {
            btn.addActionListener(this);
            studentsCRUDPanel.add(btn);
        }
        studentsOptionsPannel.add(studentsCRUDPanel);
        this.btnStudentsSearch.addActionListener(this);
        studentsOptionsPannel.add(btnStudentsSearch);

        JPanel booksOptionsPannel = new JPanel(new GridLayout(0, 1));
        booksOptionsPannel.setBorder(BorderFactory.createTitledBorder("Books"));
        JPanel booksCRUDPanel = new JPanel(new GridLayout(0, 3));
        for (JButton btn : new JButton[]{
            btnBooksInsert, btnBooksUpdate, btnBooksDelete
        }) {
            btn.addActionListener(this);
            booksCRUDPanel.add(btn);
        }
        booksOptionsPannel.add(booksCRUDPanel);
        this.btnBooksSearch.addActionListener(this);
        booksOptionsPannel.add(btnBooksSearch);

        JPanel bookingsOptionsPannel = new JPanel(new GridLayout(0, 1));
        bookingsOptionsPannel.setBorder(BorderFactory.createTitledBorder("Bookings"));
        JPanel bookingsCRUDPanel = new JPanel(new GridLayout(0, 2));
        for (JButton btn : new JButton[]{
            btnBookingsInsert, btnBookingsDelete
        }) {
            btn.addActionListener(this);
            bookingsCRUDPanel.add(btn);
        }
        bookingsOptionsPannel.add(bookingsCRUDPanel);
        this.btnBookingsSearch.addActionListener(this);
        bookingsOptionsPannel.add(btnBookingsSearch);

        JPanel optionsPannel = new JPanel(new GridLayout(0, 2));
        optionsPannel.setBorder(BorderFactory.createTitledBorder("Main"));
        for (JButton btn : new JButton[]{
            btnInsert, btnSearch, btnBooking, btnReturnBook
        }) {
            btn.addActionListener(this);
            optionsPannel.add(btn);
        }

        JPanel helpPanel = new JPanel(new GridLayout(1, 1));
        helpPanel.setBorder(BorderFactory.createEtchedBorder());
        helpPanel.add(new JScrollPane(txtMain));

        JPanel pnlMain = new JPanel(new GridLayout(0, 1));
        pnlMain.setName("Main");
        pnlMain.add(helpPanel);
        pnlMain.add(optionsPannel);

        JPanel pnlStudents = new JPanel(new GridLayout(0, 1));
        pnlStudents.setName("Students");
        pnlStudents.add(txtStudents);
        pnlStudents.add(studentsOptionsPannel);

        JPanel pnlBooks = new JPanel(new GridLayout(0, 1));
        pnlBooks.setName("Books");
        pnlBooks.add(txtBooks);
        pnlBooks.add(booksOptionsPannel);

        JPanel pnlBookings = new JPanel(new GridLayout(0, 1));
        pnlBookings.setName("Bookings");
        pnlBookings.add(txtBookings);
        pnlBookings.add(bookingsOptionsPannel);

        // super.add(tablePane);
        mainPannel.add(pnlMain);
        mainPannel.add(pnlStudents);
        mainPannel.add(pnlBooks);
        mainPannel.add(pnlBookings);
        this.refreshTable();

        super.add(mainPannel);
        super.add(tablePane);

        super.setResizable(false);
        super.setLayout(new GridLayout(0, 2));
        super.setLocationRelativeTo(parent);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    /**
     * Used to connect to the database.
     */
    private void dbConnection() {
        System.out.println("dbConnection");
        try {
            this.conn = DriverManager.getConnection(
                    "jdbc:derby://127.0.0.1:1527/LibaryBookingSystem", "nbuser", "nbuser"
            );
        } catch (SQLException sqle) {
            sqle.printStackTrace(System.err);
            JOptionPane.showMessageDialog(this, sqle.getMessage(), sqle.getClass()
                    .getSimpleName(), JOptionPane.ERROR_MESSAGE);
            System.exit(2);
        }
    }

    /**
     * Used for updating books.
     */
    private void refreshTable() {
        try {
            Statement stmt = conn.createStatement();

            if (tablePane != null) {
                this.tablePane.removeAll();
                super.remove(tablePane);
            }

            this.table = new JTable(setTable(stmt.executeQuery("SELECT * FROM Bookings")));
            this.table.getSelectionModel().addListSelectionListener(this);
            this.tablePane = new JScrollPane(table);
            this.tablePane.setBorder(BorderFactory.createEtchedBorder());

            //studentsPannel.add(tablePane);
            stmt.close();
        } catch (SQLException sqle) {
            sqle.printStackTrace(System.err);
            JOptionPane.showMessageDialog(this, sqle.getMessage(), sqle.getClass()
                    .getSimpleName(), JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Used to return reserved books.
     */
    private void returnBook() {
        String ref = JOptionPane.showInputDialog(this, "Please Enter the unique booking reference:",
                "What is theunique booking reference for the transaction?", JOptionPane.QUESTION_MESSAGE);
        if (ref == null || ref.equals("")) {
            return; // well ok then...
        }
        System.out.println("reference: " + ref);
        try {
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(String.format("SELECT * FROM Bookings WHERE reference = '%s'", ref));
            if (rs.next()) {
                if (JOptionPane.showConfirmDialog(this, String.format("Are you returning %s?", rs.getString("bookTitle")),
                        "Is this your book?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) != 0) {
                    return;
                }
            }

            String returnBook = String.format("UPDATE Books set numCopies = numCopies + 1 WHERE isbn = '%s'", rs.getString("ISBN"));
            String removeBooking = String.format("DELETE FROM Bookings WHERE reference = '%s'", ref);
            if (stmt.execute(returnBook) && stmt.execute(removeBooking)) {
                new SQLException("An error has occured.").printStackTrace(System.err);
                JOptionPane.showMessageDialog(this, "An error occured.",
                        "Error.", JOptionPane.ERROR_MESSAGE);
            } else {
                System.out.println("The book has been returned.");
                JOptionPane.showMessageDialog(this, "The has been returned.",
                        "Sucsess!", JOptionPane.PLAIN_MESSAGE);
            }

            rs.close();
            stmt.close();

            // update table:
            this.refreshTable();
            super.revalidate();
            super.repaint();
            // -- 
        } catch (SQLException sqle) {
            if (sqle.getMessage().equals("Invalid operation at current cursor position")) {
                System.err.println(sqle);
                JOptionPane.showMessageDialog(this, String.format("No booking "
                        + "with the refrenece number '%s' was found.", ref),
                        "No record found.", JOptionPane.ERROR_MESSAGE);
                return;
            }

            sqle.printStackTrace(System.err);
            JOptionPane.showMessageDialog(this, sqle.getMessage(), sqle.getClass()
                    .getSimpleName(), JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Used to call the different search messages.
     */
    private void dbSearch() {
        System.out.println("dbSearch");

        String selection = JOptionPane.showInputDialog(this,
                "Pleae enter: 'student', 'book' or 'booking'",
                "What would you like to search for?", JOptionPane.QUESTION_MESSAGE);
        if (selection == null || selection.equals("")) {
            return; // clicked on the button by mistake prehaps
        }
        switch (selection.toLowerCase()) {
            case "student":
                this.searchStudent();
                break;
            case "book":
                this.searchBooks();
                break;
            case "bootking":
                this.searchBooking();
                break;
            default:
                JOptionPane.showMessageDialog(this, "Pleae enter: 'student', "
                        + "'book' or 'booking'", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * USed to search for a book.
     */
    private String searchBooks(String row, String value) {
        System.out.printf("Searching: book for %s by %s.\n", value, row);

        try {
            boolean found = false;
            StringBuilder output = new StringBuilder();

            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(String.format("SELECT * FROM Books WHERE %s = '%s'", row, value));
            if (rs.next()) {
                found = true;
                output.append("Title: ").append(rs.getString("title")).append("\n");
                output.append("ISBN Number: ").append(rs.getString("ISBN")).append("\n");
                output.append("Author: ").append(rs.getString("author")).append("\n");
                output.append("Year Published: ").append(rs.getString("yearPublished")).append("\n");
                output.append("Edition: ").append(rs.getString("edition")).append("\n");
                output.append("Category: ").append(rs.getString("category")).append("\n");
                output.append("Publisher: ").append(rs.getString("publisher")).append("\n");
                output.append("Number of Copies: ").append(rs.getString("numCopies")).append("\n");

                this.txtBooks.setText(output.toString());
            }
            rs.close();

            if (!found) {
                System.err.println("No results found.");
                JOptionPane.showMessageDialog(this, String.format("No book with "
                        + "the %s '%s' was found.", row, value), "No record found.",
                        JOptionPane.ERROR_MESSAGE);
            }

            stmt.close();
            return output.toString();
        } catch (SQLException sqle) {
            sqle.printStackTrace(System.err);
            JOptionPane.showMessageDialog(this, sqle.getMessage(), sqle.getClass()
                    .getSimpleName(), JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    /**
     * Used to search for a student.
     */
    private String searchStudent(String row, String value) {
        System.out.printf("Searching: Students for %s by %s.\n", value, row);

        try {
            boolean found = false;
            StringBuilder output = new StringBuilder();

            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(String.format("SELECT * FROM Students WHERE %s = '%s'", row, value));
            if (rs.next()) {
                found = true;

                output.append("Title: ").append(rs.getString("title")).append("\n");
                output.append("Student Number: ").append(rs.getString("studentNumber")).append("\n");
                output.append("First name: ").append(rs.getString("firstName")).append("\n");
                output.append("Surname: ").append(rs.getString("surname")).append("\n");
                output.append("Cell Number: ").append(rs.getString("cellNumber")).append("\n");
                output.append("Address: ").append(rs.getString("address")).append("\n");
                output.append("\n").append("\n").append("\n");

                // this.txtStudents.setText(output.toString());
            }
            rs.close();

            if (!found) {
                System.err.println("No results found.");
                JOptionPane.showMessageDialog(this, String.format("No student with "
                        + "the %s '%s' was found.", row, value), "No record found.",
                        JOptionPane.ERROR_MESSAGE);
            }

            stmt.close();

            return output.toString();
        } catch (SQLException sqle) {
            sqle.printStackTrace(System.err);
            JOptionPane.showMessageDialog(this, sqle.getMessage(), sqle.getClass()
                    .getSimpleName(), JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    /**
     * Used to search for a booking.
     */
    private String searchBooking(String row, String value) {
        System.out.printf("Searching: Bookings for %s by %s.\n", value, row);

        try {
            boolean found = false;
            StringBuilder output = new StringBuilder();

            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(String.format("SELECT * FROM Bookings WHERE %s = '%s'", row, value));
            if (rs.next()) {
                found = true;
                output.append("Booking Date: ").append(rs.getString("bookingDate")).append("\n");
                output.append("Reference: ").append(rs.getString("reference")).append("\n");
                output.append("ISBN of Book: ").append(rs.getString("ISBN")).append("\n");
                output.append("Book Title: ").append(rs.getString("bookTitle")).append("\n");
                output.append("Student Name: ").append(rs.getString("studentName")).append("\n");
                output.append("Student surname: ").append(rs.getString("studentSurname")).append("\n");
                output.append("\n").append("\n").append("\n");

                // this.txtStudents.setText(output.toString());
            }
            rs.close();

            if (!found) {
                System.err.println("No results found.");
                JOptionPane.showMessageDialog(this, String.format("No Booking with "
                        + "the %s '%s' was found.", row, value), "No record found.",
                        JOptionPane.ERROR_MESSAGE);
            }

            stmt.close();

            return output.toString();
        } catch (SQLException sqle) {
            sqle.printStackTrace(System.err);
            JOptionPane.showMessageDialog(this, sqle.getMessage(), sqle.getClass()
                    .getSimpleName(), JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    /**
     * Used to call the different insert methods.
     */
    @SuppressWarnings("empty-statement")
    private void dbInsert() {
        System.out.println("dbInsert");

        InsertDialog dailog = new InsertDialog(this);
        dailog.setVisible(true);
        while (dailog.isSelecting());

        Tables selection;
        System.out.println(selection = dailog.getSelection());

        switch (selection) {
            case TBL_BOOKINGS: {
                this.booking();
            }
            break;
            case TBL_BOOKS: {
                this.insertBook();
            }
            break;
            case TBL_STUDENTS: {
                this.insertStudent();
            }
            break;
        }
    }

    /**
     * Used to insert a Book record.
     */
    @SuppressWarnings("empty-statement")
    private void insertBook() {
        if (JOptionPane.showConfirmDialog(this, "Are you sure you want to insert "
                + "a new Book?", "Are you sure?", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE) == 0) {

            InsertBook book;
            try {
                book = new InsertBook(this);
                book.setVisible(true);
                while (!book.hasSelected());
            } catch (RuntimeException ex) {
                System.err.println(ex);
                return;
            }

            String title = book.getBookTitle();
            String ISBN = book.getISBN();
            String author = book.getAuthor();
            String category = book.getCategory();
            String publisher = book.getPublisher();
            String _yearPublished = book.getYearPublished();
            String _edition = book.getEdition();
            String _numCopies = book.getNumCopies();

            while (title == null || title.equals("")) {
                title = JOptionPane.showInputDialog(this, "Please Enter the title of the new book:",
                        "What is the title of the new book?", JOptionPane.QUESTION_MESSAGE);
            }

            while (ISBN == null || ISBN.equals("")) {
                ISBN = JOptionPane.showInputDialog(this, "Please Enter the ISBN number of the new book:",
                        "What is the ISBN number of the new book?", JOptionPane.QUESTION_MESSAGE);
                if (ISBN.length() != 16) {
                    ISBN = "invalid"; // break loop below on first pass
                }
                for (char c : ISBN.replaceAll("-", "").toCharArray()) {
                    if (!Character.isDigit(c)) {
                        System.err.println("Invalid ISBN number: " + ISBN);
                        JOptionPane.showMessageDialog(this, "Please Enter a valid "
                                + "ISBN number.", "Invalid ISBN number.", HEIGHT);
                        ISBN = null;
                        break;
                    }
                }
            }

            while (author == null || author.equals("")) {
                author = JOptionPane.showInputDialog(this, "Please Enter the author of the new book:",
                        "What is the author of the new book?", JOptionPane.QUESTION_MESSAGE);
            }

            int yearPublished = -1;
            while (yearPublished <= -1) {
                try {
                    if (_yearPublished == null || _yearPublished.equals("")) {
                        _yearPublished = JOptionPane.showInputDialog(this, "Please Enter the year "
                                + "in which the new book was published:",
                                "What year was the new book published?", JOptionPane.QUESTION_MESSAGE);
                    }
                    yearPublished = Integer.parseInt(_yearPublished);
                } catch (NumberFormatException nfe) {
                    _yearPublished = null;

                    System.err.println(nfe);
                    JOptionPane.showMessageDialog(this, "Please enter a valid year",
                            "Invalid Input.", JOptionPane.ERROR_MESSAGE);
                }
            }

            int edition = -1;
            while (edition <= -1) {
                try {
                    if (_edition == null || _edition.equals("")) {
                        _edition = JOptionPane.showInputDialog(this, "Please Enter the edition "
                                + "of the new book:", "What is the edition of the new book?", JOptionPane.QUESTION_MESSAGE).
                                replaceAll("st", "").replaceAll("nd", "").replaceAll("rd", "");
                    }

                    edition = Integer.parseInt(_edition);
                } catch (NumberFormatException nfe) {
                    _edition = null;

                    System.err.println(nfe);
                    JOptionPane.showMessageDialog(this, "Please enter a valid edition",
                            "Invalid Input.", JOptionPane.ERROR_MESSAGE);
                }
            }

            while (category == null || category.equals("")) {
                category = JOptionPane.showInputDialog(this, "Please enter the "
                        + "category that the new books belong to:",
                        "What is the category of the new book?", JOptionPane.QUESTION_MESSAGE);
            }

            while (publisher == null || publisher.equals("")) {
                publisher = JOptionPane.showInputDialog(this, "Please enter the "
                        + "publisher of the new books:",
                        "What is the publisher of the new book?", JOptionPane.QUESTION_MESSAGE);
            }

            int numCopies = -1;
            while (numCopies <= -1) {
                try {
                    if (_numCopies == null || _numCopies.equals("")) {
                        _numCopies = JOptionPane.showInputDialog(this,
                                "Please enter the number of copies are there:",
                                "How many copies of the new book are there?", JOptionPane.QUESTION_MESSAGE);
                    }

                    numCopies = Integer.parseInt(_numCopies);
                } catch (NumberFormatException nfe) {
                    _numCopies = null;

                    System.err.println(nfe);
                    JOptionPane.showMessageDialog(this, "Please enter a valid edition",
                            "Invalid Input.", JOptionPane.ERROR_MESSAGE);
                }
            }

            String q = String.format("INSERT INTO Books (title, ISBN, author, yearPublished, edition, category, publisher, numCopies) "
                    + "VALUES ('%s', '%s', '%s', %d, %d, '%s', '%s', %d)", title, ISBN, author, yearPublished, edition, category, publisher, numCopies);
            System.out.println(q);

            try {
                Statement stmt = conn.createStatement();
                if (stmt.execute(q)) {
                    JOptionPane.showMessageDialog(this, "An error occured",
                            "Error.", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "The new book has been inserted.",
                            "Sucsess!", JOptionPane.PLAIN_MESSAGE);
                }
                stmt.close();
            } catch (SQLException sqle) {
                sqle.printStackTrace(System.err);
                JOptionPane.showMessageDialog(this, sqle.getMessage(), sqle.getClass()
                        .getSimpleName(), JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * Used to insert a Student record.
     */
    @SuppressWarnings("empty-statement")
    private void insertStudent() {
        if (JOptionPane.showConfirmDialog(this, "Are you sure you want to inset a "
                + "new Student?", "Are you sure?", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE) == 0) {

            InsertStudent student;
            try {
                student = new InsertStudent(this);
                student.setVisible(true);
                while (!student.hasSelected());
            } catch (RuntimeException ex) {
                System.err.println(ex);
                return;
            }

            String title = student.getStudentTitle();
            String studentNumber = student.getStudentNumber();
            String firstName = student.getFirstName();
            String surname = student.getSurname();
            String cellNumber = student.getCellNumber();
            String address = student.getAddress();

            while (title == null || title.equals("")) {
                title = JOptionPane.showInputDialog(this, "Please Enter the Student's title:",
                        "What is the student's title?", JOptionPane.QUESTION_MESSAGE);
            }

            while (studentNumber == null) {
                studentNumber = JOptionPane.showInputDialog(this, "Please Enter the Student's students number:",
                        "What is the student's student number?", JOptionPane.QUESTION_MESSAGE);
                if (studentNumber.length() != 10) {
                    System.err.println("Invalid student number: " + studentNumber);
                    JOptionPane.showMessageDialog(this, "Please ensure that the "
                            + "student number has 10 characters",
                            "Invalid Student Number.", JOptionPane.ERROR_MESSAGE);
                    studentNumber = null;
                }
            }

            while (firstName == null || firstName.equals("")) {
                firstName = JOptionPane.showInputDialog(this, "Please Enter the Student's first name:",
                        "What is the student's first name?", JOptionPane.QUESTION_MESSAGE);
            };

            while (surname == null || surname.equals("")) {
                surname = JOptionPane.showInputDialog(this, "Please Enter the Student's surname:",
                        "What is the student's surname?", JOptionPane.QUESTION_MESSAGE);
            }

            while (cellNumber == null) {
                cellNumber = JOptionPane.showInputDialog(this, "Please Enter the Student's cell number:",
                        "What is the student's cell number?", JOptionPane.QUESTION_MESSAGE);
                if (cellNumber.length() != 10) {
                    System.err.println("Invalid cell number: " + cellNumber);
                    JOptionPane.showMessageDialog(this, "Please ensure that the "
                            + "cell number has only 10 characters",
                            "Invalid Cell Number.", JOptionPane.ERROR_MESSAGE);
                    cellNumber = null;
                } else {
                    for (char c : cellNumber.toCharArray()) {
                        if (!Character.isDigit(c)) {
                            System.err.println("Invalid cell number: " + cellNumber);
                            JOptionPane.showMessageDialog(this, "Please ensure that the "
                                    + "cell number only has numbers",
                                    "Invalid Cell Number.", JOptionPane.ERROR_MESSAGE);
                            cellNumber = null;
                            break; // break loop
                        }
                    }
                }
            }

            while (address == null || address.equals("")) {
                address = JOptionPane.showInputDialog(this, "Please Enter the Student's address:",
                        "What is the student's address?", JOptionPane.QUESTION_MESSAGE);
            }

            String q = String.format("INSERT INTO Students (title, studentNumber, firstName, surname, cellNumber, address) "
                    + "VALUES ('%s', '%s', '%s', '%s', '%s', '%s')", title, studentNumber, firstName, surname, cellNumber, address);
            System.out.println(q);

            try {
                Statement stmt = conn.createStatement();
                if (stmt.execute(q)) {
                    JOptionPane.showMessageDialog(this, "An error occured",
                            "Error.", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "The new student has been inserted.",
                            "Sucsess!", JOptionPane.PLAIN_MESSAGE);
                }
                stmt.close();
            } catch (SQLException sqle) {
                sqle.printStackTrace(System.err);
                JOptionPane.showMessageDialog(this, sqle.getMessage(), sqle.getClass()
                        .getSimpleName(), JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * Overridden to close database connection on close.
     */
    @Override
    public void dispose() {
        try {
            this.conn.close(); // close database connection
        } catch (SQLException sqle) {
            sqle.printStackTrace(System.err);
            JOptionPane.showMessageDialog(this, sqle.getMessage(), sqle.getClass()
                    .getSimpleName(), JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
        super.dispose();
    }

    @Override
    @SuppressWarnings("empty-statement")
    public void actionPerformed(ActionEvent evt) {
        if (!(evt.getSource() instanceof JButton)) {
            return; // only need to deal with JButtons
        }
        switch (((Component) evt.getSource()).getName()) {
            case "menuClose": {
                if (JOptionPane.showConfirmDialog(this, "Are you sure you want "
                        + "to close the program?", "Are you sure?", JOptionPane.YES_NO_OPTION) == 0) {
                    super.dispose();
                    System.exit(0);
                }
            }
            break;
            case "btnStudentsSearch": {
                this.searchStudent();
            }
            break;
            case "btnBooksSearch": {
                this.searchBooks();
            }
            break;
            case "btnBookingsSearch": {
                this.searchBooking();
            }
            break;
            case "btnSearch": {
                SearchDialog dailog = new SearchDialog(this);
                dailog.setVisible(true);
                while (dailog.isSelecting());

                Tables selection;
                System.out.println(selection = dailog.getSelection());

                switch (selection) {
                    case TBL_BOOKINGS: {
                        this.searchBooking();
                    }
                    break;
                    case TBL_BOOKS: {
                        this.searchBooks();
                    }
                    break;
                    case TBL_STUDENTS: {
                        this.searchStudent();
                    }
                    break;
                }
            }
            break;
            case "btnBooksInsert": {
                this.insertBook();
            }
            break;
            case "btnStudentsInsert": {
                this.insertStudent();
            }
            break;
            case "btnBookingsDelete":
            case "btnReturnBook": {
                this.returnBook();
            }
            break;
            case "btnInsert": {
                this.dbInsert();
            }
            case "btnBookingsInsert":
            case "btnBooking": {
                this.booking();
            }
            break;
            case "btnBooksDelete": {
                this.deleteBook();
            }
            break;
            case "btnBooksUpdate": {
                this.updateBook();
            }
            break;
            case "btnStudentsDelete": {
                this.deleteStudent();
            }
            break;
            case "btnStudentsUpdate": {
                this.updateStudent();
            }
            break;
        }
    }

    /**
     * Used to update the display text.
     *
     * @param evt
     */
    @Override
    public void valueChanged(ListSelectionEvent evt) {
        final int pk = Integer.parseInt(table.getModel().getValueAt(
                table.getSelectedRow(), 0).toString()); // get PK from table

        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(String.format("SELECT * FROM Bookings WHERE id = %d", pk));
            if (rs.next()) {
                StringBuilder output = new StringBuilder();
                output.append("ID: ").append(rs.getString("id")).append("\n");
                output.append("Booking Data: ").append(rs.getString("bookingDate")).append("\n");
                output.append("ISBN: ").append(rs.getString("bookTitle")).append("\n");
                output.append("Student Name: ").append(rs.getString("studentName")).append("\n");
                output.append("Student Surname").append(rs.getString("studentSurname")).append("\n");

                this.txtBookings.setText(output.toString());
            }
            rs.close();
            stmt.close();
        } catch (SQLException sqle) {
            sqle.printStackTrace(System.err);
            JOptionPane.showMessageDialog(this, sqle.getMessage(), sqle.getClass()
                    .getSimpleName(), JOptionPane.ERROR_MESSAGE);
        }
    }

    public Connection getConnection() {
        return this.conn;
    }

    private void searchStudent() {
        String str = JOptionPane.showInputDialog(this, "Please enter: 'first name', "
                + "'surname' or 'student number'", "What would you like to search by?", JOptionPane.QUESTION_MESSAGE);
        if (str == null || str.equals("")) {
            return;
        }

        String row; // to row to search
        switch (str.toLowerCase()) {
            case "first name":
                row = "firstName";
                break;
            case "surname":
                row = "surname";
                break;
            case "student number":
                row = "studentNumber";
                break;
            default:
                JOptionPane.showMessageDialog(this, "Please enter: 'first name', "
                        + "'last name' or 'student number'", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                return;
        }

        String value = JOptionPane.showInputDialog(this, String.format("Pleae enter the %s "
                + "of the student you wish to search for:", str),
                "What student would you like to search for?", JOptionPane.QUESTION_MESSAGE);
        if (value == null || value.equals("")) {
            return;
        }

        this.txtStudents.setText(searchStudent(row, value));
    }

    private void searchBooks() {
        String str = JOptionPane.showInputDialog(this, "Please enter: 'title' or "
                + "'ISBN'", "What would you like to search by?",
                JOptionPane.QUESTION_MESSAGE);
        if (str == null || str.equals("")) {
            return;
        }

        String row; // to row to search
        switch (str.toLowerCase()) {
            case "title":
                row = "title";
                break;
            case "isbn":
                row = "ISBN";
                break;
            default:
                JOptionPane.showMessageDialog(this, "Please enter: 'title' or "
                        + "'ISBN'", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                return;
        }

        String value = JOptionPane.showInputDialog(this, String.format("Pleae enter the %s "
                + "of the book you wish to search for:", str),
                "What book would you like to search for?", JOptionPane.QUESTION_MESSAGE);
        if (value == null || value.equals("")) {
            return;
        }
        this.txtBooks.setText(searchBooks(row, value));
    }

    private void searchBooking() {
        String value = JOptionPane.showInputDialog(this, "Please enter: the reference number of the booking:",
                "What booking are you looking for?",
                JOptionPane.QUESTION_MESSAGE);
        if (value == null || value.equals("")) {
            return;
        }

        this.txtBookings.setText(searchBooking("reference", value));
    }

    /**
     * Used for reserving books.
     */
    @SuppressWarnings("empty-statement")
    private void booking() {
        InsertBooking booking;
        try {
            booking = new InsertBooking(this);
            booking.setVisible(true);
            while (!booking.hasSelected());
        } catch (RuntimeException ex) {
            System.err.println(ex);
            return;
        }

        String bookingDate = booking.getBookingDate();
        String reference = booking.getReference();
        String ISBN = booking.getISBN();
        String bookTitle = booking.getBookTitle();
        String studentName = booking.getStudentName();
        String studentSurname = booking.getStudentSurname();

        String q1 = String.format("INSERT INTO Bookings (bookingDate, reference, ISBN, bookTitle, studentName, studentSurname) "
                + "VALUES ('%s', '%s', '%s', '%s', '%s', '%s')", bookingDate, reference, ISBN, bookTitle, studentName, studentSurname);
        System.out.println(q1);

        String q2 = String.format("UPDATE Books SET numCopies = numCopies - 1 WHERE ISBN='%s'", ISBN);
        System.out.println(q2);

        try {
            Statement stmt = conn.createStatement();

            if (stmt.execute(q1) && stmt.execute(q2)) {
                JOptionPane.showMessageDialog(this, "An error occured",
                        "Error.", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "The new booking has been inserted.",
                        "Sucsess!", JOptionPane.PLAIN_MESSAGE);
            }
            stmt.close();
        } catch (SQLException sqle) {
            sqle.printStackTrace(System.err);
            JOptionPane.showMessageDialog(this, sqle.getMessage(), sqle.getClass()
                    .getSimpleName(), JOptionPane.ERROR_MESSAGE);
        }

        this.refreshTable();
    }

    /**
     * TOOD.
     */
    private void updateBook() {
        if (JOptionPane.showConfirmDialog(this, "Are you sure you want to updates "
                + "a book?", "Are you sure?", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE) == 0) {

            String ISBN = JOptionPane.showInputDialog(this, "Please enter "
                    + "the ISBN number of the book you wish to update:",
                    "What is the student number?", JOptionPane.QUESTION_MESSAGE);
            String column = JOptionPane.showInputDialog(this, "What column "
                    + "would you like to update?", "What would you like to update?",
                    JOptionPane.QUESTION_MESSAGE);
            String newValue = JOptionPane.showInputDialog(this, String.format(
                    "Please enter the new value for %s:", column), "What is the new value?",
                    JOptionPane.QUESTION_MESSAGE);

            String q = String.format("UPDATE Books SET %s = '%s' WHERE ISBN = '%s'",
                    column, newValue, ISBN);
            System.out.println(q);

            try {
                Statement stmt = conn.createStatement();

                if (stmt.execute(q)) {
                    JOptionPane.showMessageDialog(this, "An error occured",
                            "Error.", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "The book has been updated.",
                            "Sucsess!", JOptionPane.PLAIN_MESSAGE);
                }
                stmt.close();
            } catch (SQLException sqle) {
                sqle.printStackTrace(System.err);
                JOptionPane.showMessageDialog(this, sqle.getMessage(), sqle.getClass()
                        .getSimpleName(), JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void deleteBook() {
        if (JOptionPane.showConfirmDialog(this, "Are you sure you want to delete "
                + "a book?", "Are you sure", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE) == 0) {
            String ISBN = JOptionPane.showInputDialog(this, "Please enter "
                    + "the ISBN of the book you wish to delete",
                    "What is the ISBN number?", JOptionPane.QUESTION_MESSAGE);

            String q = String.format("DELETE FROM Books WHERE ISBN = '%s'", ISBN);
            System.out.println(q);

            try {
                Statement stmt = conn.createStatement();

                if (stmt.execute(q)) {
                    JOptionPane.showMessageDialog(this, "An error occured",
                            "Error.", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "The Book has been deleted.",
                            "Sucsess!", JOptionPane.PLAIN_MESSAGE);
                }
                stmt.close();
            } catch (SQLException sqle) {
                sqle.printStackTrace(System.err);
                JOptionPane.showMessageDialog(this, sqle.getMessage(), sqle.getClass()
                        .getSimpleName(), JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void updateStudent() {
        if (JOptionPane.showConfirmDialog(this, "Are you sure you want to update "
                + "a student?", "Are you sure", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE) == 0) {
            String studentNumber = JOptionPane.showInputDialog(this, "Please enter "
                    + "the student number of the student you wish to delete",
                    "What is the student number?", JOptionPane.QUESTION_MESSAGE);
            String column = JOptionPane.showInputDialog(this, "What column "
                    + "would you like to update?", "What would you like to update?",
                    JOptionPane.QUESTION_MESSAGE);
            String newValue = JOptionPane.showInputDialog(this, String.format(
                    "Please enter the new value for %s:", column), "What is the new value?",
                    JOptionPane.QUESTION_MESSAGE);

            String q = String.format("UPDATE Students SET %s = '%s' WHERE studentNumber = '%s'",
                    column, newValue, studentNumber);
            System.out.println(q);

            try {
                Statement stmt = conn.createStatement();

                if (stmt.execute(q)) {
                    JOptionPane.showMessageDialog(this, "An error occured",
                            "Error.", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "The student has been deleted.",
                            "Sucsess!", JOptionPane.PLAIN_MESSAGE);
                }
                stmt.close();
            } catch (SQLException sqle) {
                sqle.printStackTrace(System.err);
                JOptionPane.showMessageDialog(this, sqle.getMessage(), sqle.getClass()
                        .getSimpleName(), JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void deleteStudent() {
        if (JOptionPane.showConfirmDialog(this, "Are you sure you want to delete "
                + "a student?", "Are you sure", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE) == 0) {
            String studentNumber = JOptionPane.showInputDialog(this, "Please enter "
                    + "the student number of the student you wish to delete",
                    "What is the student number?", JOptionPane.QUESTION_MESSAGE);

            String q = String.format("DELETE FROM Students WHERE studentNumber = '%s'", studentNumber);
            System.out.println(q);

            try {
                Statement stmt = conn.createStatement();

                if (stmt.execute(q)) {
                    JOptionPane.showMessageDialog(this, "An error occured",
                            "Error.", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "The student has been deleted.",
                            "Sucsess!", JOptionPane.PLAIN_MESSAGE);
                }
                stmt.close();
            } catch (SQLException sqle) {
                sqle.printStackTrace(System.err);
                JOptionPane.showMessageDialog(this, sqle.getMessage(), sqle.getClass()
                        .getSimpleName(), JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
