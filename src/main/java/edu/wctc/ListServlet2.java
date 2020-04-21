package edu.wctc;
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
        Connection conn = null;
        Statement stmt = null;
        ResultSet rset = null;

        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");

            String absPath = getServletContext().getRealPath("/") + DATABASE_PATH;

            StringBuilder sql = new StringBuilder("Select petID, name, age, speciesnm");
            sql.append(" From pet");
            sql.append(" Order by age");

            conn = DriverManager.getConnection(DRIVER_NAME + absPath, USERNAME, PASSWORD);
            stmt = conn.createStatement();
            rset = stmt.executeQuery(sql.toString());
            StringBuilder html = new StringBuilder("<html><body>");

            List<Pet> petList = new ArrayList<Pet>();

            while (rset.next()) {
                Pet pet = new Pet();
                pet.setId(rset.getInt(1));
                pet.setName(rset.getString(2));
                pet.setAge(rset.getInt(3));
                pet.setSpecies(rset.getString(4));
                petList.add(pet);
            }

            while (rset.next()) {
                int id = rset.getInt("petID");
                html.append("<p>").append(id).append(",").append(id).append("</p>");
                String nm = rset.getString(2);
                html.append("<p>").append(id).append(",").append(nm).append("</p>");
                int age = rset.getInt(3);
                html.append("<p>").append(id).append(",").append(age).append("</p>");
                String species =rset.getString(4);
                html.append("<p>").append(id).append(",").append(species).append("</p>");
            }

            html.append("</body></html>");
            request.setAttribute("pets", petList);
            request.getRequestDispatcher("list2.jsp").forward(request, response);

        } catch (SQLException | ClassNotFoundException e) {
            response.getWriter().print(e.getMessage());
            e.printStackTrace();
        } finally {
            DatabaseUtils.closeAll(conn, stmt, rset);
        }
    }
}
