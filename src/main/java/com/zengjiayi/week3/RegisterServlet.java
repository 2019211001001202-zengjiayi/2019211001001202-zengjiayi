package com.zengjiayi.week3;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(
        urlPatterns = {"/register"}
)

public class RegisterServlet extends HttpServlet {
    Connection con=null;
    @Override
    public void init() throws ServletException {
        String driver=getServletConfig().getServletContext().getInitParameter("driver");
        String url=getServletConfig().getServletContext().getInitParameter("url");
        String username=getServletConfig().getServletContext().getInitParameter("username");
        String password=getServletConfig().getServletContext().getInitParameter("password");
        try {
            Class.forName(driver);
            con= DriverManager.getConnection(url,username,password);
            System.out.println("init()-->"+con);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String email=request.getParameter("email");
        String gender=request.getParameter("gender");
        String birthdate=request.getParameter("birthdate");

        String sql1="insert into usertable values(?,?,?,?,?)";
        PreparedStatement pstmt= null;
        try {
            pstmt = con.prepareStatement(sql1);
            pstmt.setString(1,username);
            pstmt.setString(2,password);
            pstmt.setString(3,email);
            pstmt.setString(4,gender);
            pstmt.setString(5,birthdate);
            pstmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        out.println("<html>");
        out.println("<head><title>Register</title></head>");
        out.println("<body>");
        out.println("<table>");
        out.println("<tr><td>ID</td><td>username</td><td>password</td><td>Email</td><td>Gender</td><td>Birthdate</td></tr>");
        String sql2="select * from usertable";
        ResultSet rs= null;
        try {
            rs = con.createStatement().executeQuery(sql2);
            while(rs.next()){
                int id=rs.getInt("id");
                String Username=rs.getString("username");
                String Password1=rs.getString("password");
                String Email=rs.getString("email");
                String Gender=rs.getString("gender");
                String Birthdate=rs.getString("birthdate");
                out.println("<tr><td>"+id+"</td><td>"+Username+"</td><td>"+Password1+"</td><td>"+Email+"</td><td>"+Gender+"</td><td>"+Birthdate+"</td></tr>");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");

    }

    @Override
    public void destroy() {
        super.destroy();
        try {
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}