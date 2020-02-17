package edu.wctc;
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
    private final String USERNAME = "annette";
    private final String PASSWORD = "annette";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rset = null;

        try {
            String searchTerm = request.getParameter("speciesnm");

            //Load driver
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");

            //Find the absolute path of the database folder
            String absPath = getServletContext().getRealPath("/") + DATABASE_PATH;

            //Build the query as a String
            StringBuilder sql = new StringBuilder("select petID, name, age, speciesnm");
            sql.append("from pet");
            sql.append("where speciesnm = ?");

            //Create a connection
            conn = DriverManager.getConnection(DRIVER_NAME + absPath, USERNAME, PASSWORD);
            //Create a statement to execute SQL
            pstmt = conn.prepareStatement(sql.toString());
            //Fill in the prepared statement parameters
            pstmt.setString(1, searchTerm);
            //Execute a Select query and get a result set
            rset = pstmt.executeQuery();

            StringBuilder output = new StringBuilder();

            //Create web page
            output.append("<html><head><link type='text/css' rel='stylesheet' href='css/style.css'></head>");
            output.append("<body>");

            //Start the table
            output.append("<table>");
            output.append("<tr>");
            output.append("<th>PetID</th><th>Name</th><th>Age</th><th>Favorite Toy</th>");
            output.append("</tr>");

            //Loop while the result set has more rows
            while (rset.next()) {
                output.append("<tr>");
                int petID = rset.getInt(1);
                output.append("<td>" + petID + "</td>");

                String petName = rset.getString(2);
                output.append("<td>" + petName + "</td>");

                int age = rset.getInt(3);
                output.append("<td>" + age + "</td>");

                String speciesName = rset.getString(4);
                output.append("<td>" + speciesName + "</td>");

                output.append("</tr>");
            }

            output.append("</table></body></html>");

            //Send HTML as the response
            response.setContentType("text/html");
            response.getWriter().print(output.toString());

        } catch (SQLException | ClassNotFoundException e) {
            response.getWriter().print(e.getMessage());
            e.printStackTrace();
        } finally {
            DatabaseUtils.closeAll(conn, pstmt, rset);
        }
    }
}