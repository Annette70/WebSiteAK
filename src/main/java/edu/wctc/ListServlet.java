package edu.wctc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@WebServlet(name = "ListServlet" , urlPatterns = "/list1")
public class ListServlet extends HttpServlet {
    private final String DRIVER_NAME = "jdbc:derby:";
    private final String DATABASE_PATH = "../../db";
    private final String USERNAME = "annette";
    private final String PASSWORD = "annette";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = null;
        ResultSet rset = null;
        Statement stmt = null;

        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");

            String absPath = getServletContext().getRealPath("/") + DATABASE_PATH;
            conn = DriverManager.getConnection(DRIVER_NAME + absPath, USERNAME, PASSWORD);
            stmt = conn.createStatement();
            rset = stmt.executeQuery("SELECT petID, speciesnm FROM pet");
            StringBuilder html = new StringBuilder("<html><body>");

            while (rset.next()) {
                int id = rset.getInt("petID");
                String nm = rset.getString(2);
                html.append("<p>").append(id).append(",").append(nm).append("</p>");
            }

            html.append("</body></html>");

            response.getWriter().print(html.toString());

        } catch (SQLException | ClassNotFoundException ex) {
            response.getWriter().print(ex.getMessage());
            ex.printStackTrace();

        } finally {
            DatabaseUtils.closeAll(conn, stmt, rset);
        }
    }
}