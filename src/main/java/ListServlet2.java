import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "petList", urlPatterns = "/list2")
public class ListServlet2 extends HttpServlet {
        private final String DRIVER_NAME = "jdbc:derby:";
        private final String DATABASE_PATH = "../../db";
        private final String USERNAME = "annette";
        private final String PASSWORD = "annette";

        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        }

        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            // Declare outside the try/catch so the variables are in scope in the finally block
            Connection conn = null;
            Statement stmt = null;
            ResultSet rset = null;

            try {
                // Load the driver
                Class.forName("org.apache.derby.jdbc.EmbeddedDriver");

                // Find the absolute path of the database folder
                String absPath = getServletContext().getRealPath("/") + DATABASE_PATH;

                StringBuilder sql = new StringBuilder("SELECT petID, name, age, speciesnm");
                sql.append(" FROM pet");
                sql.append(" ORDER BY age"); // Don't end SQL with semicolon!

                // Create a connection
                conn = DriverManager.getConnection(DRIVER_NAME + absPath, USERNAME, PASSWORD);
                // Create a statement to execute SQL
                stmt = conn.createStatement();
                // Execute a SELECT query and get a result set
                rset = stmt.executeQuery(sql.toString());

                List<Pet> petList = new ArrayList<Pet>();

                // Loop while the result set has more rows
                while (rset.next()) {
                    Pet pet = new Pet();
                    pet.setId(rset.getInt(1));
                    pet.setName(rset.getString(2));
                    pet.setAge(rset.getInt(3));
                    pet.setSpecies(rset.getString(4));
                    petList.add(pet);
                }

                request.setAttribute("pets", petList);
                request.getRequestDispatcher("list2.jsp").forward(request, response);

            } catch (SQLException | ClassNotFoundException e) {
                // If there's an exception locating the driver, send IT as the response
                response.getWriter().print(e.getMessage());
                e.printStackTrace();
            } finally {
                edu.wctc.DatabaseUtils.closeAll(conn, stmt, rset);
            }
        }
}
