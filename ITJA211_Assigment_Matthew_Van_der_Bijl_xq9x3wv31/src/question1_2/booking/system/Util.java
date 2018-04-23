package question1_2.booking.system;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 * Holds odd methods that multiple classes need to call.
 *
 * @author Matthew Van der Bijl - XQ9X3WV31
 */
public final class Util {

    /**
     * Convert a <code>ResultSet</code> to a <code>DefaultTableModel</code>.
     *
     * @param rs the result set to be converted to a table
     * @return the constructed table
     * @throws SQLException thrown if an error occurs
     */
    // http://stackoverflow.com/questions/10620448/most-simple-code-to-populate-jtable-from-resultset
    public static DefaultTableModel setTable(ResultSet rs) throws SQLException {
        ResultSetMetaData metaData = rs.getMetaData();

        // names of columns
        Vector<String> columnNames = new Vector<>();
        int cnt = metaData.getColumnCount();
        for (int i = 1; i <= cnt; i++) {
            columnNames.add(metaData.getColumnName(i));
        }

        // data of the table
        Vector<Vector<Object>> data = new Vector<>();
        while (rs.next()) {
            Vector<Object> vector = new Vector<>();
            for (int i = 1; i <= cnt; i++) {
                vector.add(rs.getObject(i));
            }
            data.add(vector);
        }

        return new DefaultTableModel(data, columnNames);
    }
}
