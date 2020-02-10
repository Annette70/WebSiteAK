import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "SearchServlet", urlPatterns = "/search")
public class SearchServlet extends HttpServlet {
    private final String DRIVER_NAME = "jdbc:derby:";
    private final String DATABASE_PATH = "../../db";
    private final String SCHEMA = "annette";
    private final String PASSWORD = "annette";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rset = null;

        try {
            String searchTerm = request.getParameter("speciesnm");

            // Load the driver
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");

            // Find the absolute path of the database folder
            String absPath = getServletContext().getRealPath("/") + DATABASE_PATH;

            // Build the query as a String
            StringBuilder sql = new StringBuilder("select name, age, speciesnm");
            sql.append("from pet");
            sql.append("where speciesnm = ?"); // Don't end SQL with semicolon!

            // Create a connection
            conn = DriverManager.getConnection(DRIVER_NAME + absPath, SCHEMA, PASSWORD);
            // Create a statement to execute SQL
            pstmt = conn.prepareStatement(sql.toString());
            // Fill the prepared statement params
            pstmt.setString(1, searchTerm);
            // Execute a SELECT query and get a result set
            rset = pstmt.executeQuery();

            // Create a StringBuilder for ease of appending strings
            StringBuilder output = new StringBuilder();

            // HTML to create a simple web page
            output.append("<html><head><link type='text/css' rel='stylesheet' href='css/style.css'></head>");
            output.append("<body>");

            // Start the table
            output.append("<table>");
            // Start a row
            output.append("<tr>");
            // Add the headers
            output.append("<th>Name</th><th>Age</th><th>Favorite Toy</th>");
            // End the row
            output.append("</tr>");

            // Loop while the result set has more rows
            while (rset.next()) {
                // Start a row
                output.append("<tr>");
                // Get the first string (the pet name) from each record
                String petName = rset.getString(1);
                // Add a cell with the info
                output.append("<td>" + petName + "</td>");

                // Get the rest of the pet data and append likewise
                String name = rset.getString(2);
                output.append("<td>" + name + "</td>");
                int age = rset.getInt(3);
                output.append("<td>" + age + "</td>");
                String speciesName = rset.getString(4);
                output.append("<td>" + speciesName + "</td>");


                // End the row
                output.append("</tr>");
            }

            // Close all those opening tags
            output.append("</table></body></html>");

            // Send the HTML as the response
            response.setContentType("text/html");
            response.getWriter().print(output.toString());

        } catch (SQLException | ClassNotFoundException e) {
            // If there's an exception locating the driver, send it as the response
            response.getWriter().print(e.getMessage());
            e.printStackTrace();
        } finally {
            edu.wctc.DatabaseUtils.closeAll(conn, pstmt, rset);
        }
    }
}