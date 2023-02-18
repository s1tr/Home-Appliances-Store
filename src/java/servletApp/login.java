/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servletApp;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import javax.servlet.http.HttpSession;


/**
 *
 * @author awdal
 */
public class login extends HttpServlet {
    
    
    // call do post method to send the request data to the server
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //setup the print writer to display text in the screen
        PrintWriter out = response.getWriter();
        
        //take an opject from register class to call md5 algorithm
        register reg = new register();
        
        //get the parameter from the form
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        // pass the passeord to md5 algorithm to get the encrypted password from original password
        String hashed_password = reg.md5(password);
        
        // if the eamil and password in the database...
        if(isLoginValid(username,hashed_password)){
                //then create session for this user
                HttpSession session = request.getSession();
                //set the attribute of the session
                session.setAttribute("USER", username);
                //redirect the user to the homepage with logged user permissions
                response.sendRedirect("index.jsp");
        }
        else{
            //response.sendRedirect("login.html");
            System.out.println("here is error");
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title> browse the result </title>");
            out.println("<link rel=\"stylesheet\" href=\"css/style.css\">");
            out.println("<link rel=\"shortcut icon\" type=\"image/svg\" href=\"images/web-icon.svg\">");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class=\"error-page error-msg\">");
            out.println("<h1>Soory password or email is wrong!</h1>");
            out.println("<h1><a href=\"login.html\" style=\"color: #1e23fd;\">Login </a></h1>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        }

    }

    //function for check the user login process
    public boolean isLoginValid(String uname,String pass){
        
        try {
             
            // store the mysql driver and URL to get access to the database
            String JDBC_DRIVER = "";
            String DB_URL = "";
    
            // store the mysql root user name and password
            String USER = "root";
            String PASS = "";
            
            Class.forName(JDBC_DRIVER);
            
            //setup the connection to mysql server
            Connection connection = DriverManager.getConnection(DB_URL,USER,PASS);
            
            //setup the sql query for gitting the email and password
            String sqlQuery = "select username,password_ from users where username=? and password_=?";
            
            //setup the prepared statment to pass the sql query
            PreparedStatement ps = connection.prepareStatement(sqlQuery);
            
            //replace the quistion mark in sql prepared statement with values
            ps.setString(1, uname);
            ps.setString(2, pass);
            
            //excute the sql query
            ResultSet rs = ps.executeQuery();

            //if thete is data then return true
            if(rs.next()){
                return true;
            }
            else{
                return false;
            }            
        }
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
        

}

