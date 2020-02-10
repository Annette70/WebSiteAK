import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "SearchServlet", urlPatterns = "/search")
public class SearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rset = null;
        String speciesName = request.getParameter("Species");

        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");

            String absPath = getServletContext().getRealPath("/") + "../../db";

            conn = DriverManager.getConnection("jdbc:derby:" + absPath,
                    "annette",
                    "annette");

            String sql = "select Name, Age, Species from Pet where Species = ?";
            stmt = conn.prepareStatement(sql);

            stmt.setString(1, speciesName);

            rset = stmt.executeQuery();
            StringBuilder sb = new StringBuilder("<html><body>");

            sb.append("<ul>");

            while (rset.next()) {
                sb.append("<li>");

                String name = rset.getString("Name");
                int age = rset.getInt("Age");
                String species = rset.getString(3);

                sb.append(name + ", " + age + ", " + species);

                sb.append("</li>");
            }

            sb.append("</ul>");

            sb.append("</body></html>");

            response.setContentType("text.html");

            response.getWriter().print(sb.toString());

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(conn, stmt, rset);
        }

    }

    // Connection constants for use by all servlets
    public static final String DRIVER_NAME = "jdbc:derby:";
    public static final String DATABASE_PATH = "db";
    public static final String USERNAME = "annette";
    public static final String PASSWORD = "annette";

    public static void closeAll(Connection conn, Statement stmt, ResultSet rset) {
        if (rset != null) {
            try {
                rset.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
