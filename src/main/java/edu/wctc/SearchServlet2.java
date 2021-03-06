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

@WebServlet(name = "SearchServlet2", urlPatterns = "/emojistore/search2")
public class SearchServlet2 extends HttpServlet {
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

            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");

            String absPath = getServletContext().getRealPath("/") + DATABASE_PATH;

            StringBuilder sql = new StringBuilder("select pet.speciesnm, pet.age, favoriteToy ");
            sql.append("from pet ");
            sql.append("join petDetail on (pet.petID = petDetail.petID) ");
            sql.append("where pet.speciesnm = ?");

            conn = DriverManager.getConnection(DRIVER_NAME + absPath, USERNAME, PASSWORD);
            pstmt = conn.prepareStatement(sql.toString());
            pstmt.setString(1, searchTerm);
            rset = pstmt.executeQuery();

            List<Pet> petList = new ArrayList<Pet>();

            while (rset.next()) {
                Pet pet = new Pet();
                pet.setName(rset.getString(1));
                pet.setAge(rset.getInt(2));

                PetDetail detail = new PetDetail();
                pet.setDetail(detail);

                detail.setFavoriteToy(rset.getString(3));
                petList.add(pet);
            }

            request.setAttribute("pets", petList);
            request.getRequestDispatcher("search2.jsp").forward(request, response);

        } catch (SQLException | ClassNotFoundException e) {
            response.getWriter().print(e.getMessage());
            e.printStackTrace();
        } finally {
            DatabaseUtils.closeAll(conn, pstmt, rset);
        }
    }
}
