/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servletApp;

import com.sun.javafx.cursor.CursorType;
import com.sun.org.apache.xml.internal.resolver.Catalog;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.io.*;
import java.net.URL;
import java.text.*;
import java.sql.*;
import javax.servlet.http.HttpSession;
/**
 *
 * @author awdal
 */
public class AddFeddback extends HttpServlet {
    
    
    
    //all the code is  same as AddNewApplinances.java except the sql query!!
    //all the code is  same as AddNewApplinances.java except the sql query!!
    //all the code is  same as AddNewApplinances.java except the sql query!!
    //all the code is  same as AddNewApplinances.java except the sql query!!
    //all the code is  same as AddNewApplinances.java except the sql query!!
    //all the code is  same as AddNewApplinances.java except the sql query!!
    //all the code is  same as AddNewApplinances.java except the sql query!!
    
    
    static final String JDBC_DRIVER = "";
    static final String DB_URL = "";
    
    
    static final String USER = "root";
    static final String PASS = "";
    
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        //setup the browser cache, so that the browser cannot keep any cached data
        //we do this so the user not be able to see the previous page if the user logout
        response.setHeader("Pragma", "No-cache");
        response.setDateHeader("Expires", 0);
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        
        
        try{
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            String reqtype = request.getParameter("reqtype");
            String subject = request.getParameter("subject");
            String message = request.getParameter("message");
            
            //if there is no phone number then set phone to null
            if(phone.equals("")){
               phone = null;
            }
            
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title> process result </title>");
            out.println("<link rel=\"stylesheet\" href=\"css/style.css\">");
            out.println("<link rel=\"shortcut icon\" type=\"image/svg\" href=\"images/web-icon.svg\">");
            out.println("</head>");
            out.println("<body>");
            
            //setup the session
            HttpSession session = request.getSession();
            //get the session attribute and the casting it as string
            String username = (String)session.getAttribute("USER");
            
            //if there is a session set to this username
            if(username != null){
            //nav bar
            //here the navbar will contain the pages that the only loggedin users can access
            out.println("<nav>");
            out.println("<div class=\"nav-bar\">");
            out.println("<div class=\"nav-home\">");
            out.println("<a href=\"index.jsp\"><span class=\"orangeletter\">Y</span>our "
                    + "<span class=\"orangeletter\">H</span>ome<span\n" +
                        "class=\"orangeletter\"> :)</span></a>");
            out.println("</div>");
            out.println("<div class=\"nav-links\">");
            out.println("<ul>");
            out.println("<li><a href=\"index.jsp\" class=\"links\">Home</a></li>");
            out.println("<li><a href=\"addnewappliance.jsp\" class=\"links \">Add New Home Appliance</a></li>");
            out.println("<li><a href=\"browseAppliances\" class=\"links\">Browse All Appliances</a></li>");
            out.println("<li><a href=\"addfeedback.jsp\" class=\"links link4\">Feedback</a></li>");
            out.println("<li><a href=\"logout\" class=\"links\">Logout</a></li>");
            out.println("</ul>");
            out.println("</div>");
            out.println("</div>");
            out.println("</nav>");
            }
            else{
            //here the navbar will contain the pages that the public user can access    
            out.println("<nav>");
            out.println("<div class=\"nav-bar\">");
            out.println("<div class=\"nav-home\">");
            out.println("<a href=\"index.jsp\"><span class=\"orangeletter\">Y</span>our "
                    + "<span class=\"orangeletter\">H</span>ome<span\n" +
                        "class=\"orangeletter\"> :)</span></a>");
            out.println("</div>");
            out.println("<div class=\"nav-links\">");
            out.println("<ul>");
            out.println("<li><a href=\"index.jsp\" class=\"links\">Home</a></li>");
            out.println("<li><a href=\"login.html\" class=\"links \">Login</a></li>");
            out.println("<li><a href=\"register.html\" class=\"links\">Register</a></li>");
            out.println("<li><a href=\"addfeedback.jsp\" class=\"links link4\">Feedback</a></li>");
            out.println("</ul>");
            out.println("</div>");
            out.println("</div>");
            out.println("</nav>");
            //close the nav
            }
            
            //make a container 
            out.println("<div class=\"add-container\">");
            
            
            
            Class.forName(JDBC_DRIVER);
            //setup the connectoin to mysql server
            Connection connection = DriverManager.getConnection(DB_URL,USER,PASS);
            
            //setup the sql query
            String sqlQuery = "INSERT INTO feedback (name_, email,"
                    + " phone_number, request_type, subject_, "
                    + "message, creation_dateTime) VALUES (?, ?, ?, ?, "
                    + "?, ?, ?)";
            
            //setupjthe prepared statment for sql query
            PreparedStatement ps = connection.prepareStatement(sqlQuery);
            //replace the quistion mark in sqlquery with data
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, phone);
            ps.setString(4, reqtype);
            ps.setString(5, subject);
            ps.setString(6, message);

            //set the current date
            Date dNow = new Date( );
            SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
            String sqlDate = ft.format(dNow);
            ps.setString(7, sqlDate);
            
            //execute the sql query
            int k = ps.executeUpdate();
            
            //if data inserted successfuly then display a success message
            if(k == 1){
                out.println("<div class=\"currect-container\">");
                out.println("<div class=\"currect-sign\">");
                out.println("</div>");
                out.println("<p class=\"correct\"> Feedback have been sent successfully. </p>");
                out.println("<br>");
                out.println("</div>");
            }
            else{
                out.println("<div class=\"error-container\">");
                out.println("<div class=\"error-sign\">");
                out.println("</div>");
                out.println ("<p class=\"error\"> There was an error in adding the data! Try again. </p>");
                out.println("<a href=\"index.html\">Go Home</a>");
                out.println("</div>");
            }
            
            //footer
            out.println("<footer>");
            out.println("<div class=\"footer\">");
            out.println("<p>2023 &copy; YourHome. All Rights Reserved</p>");
            out.println("<p>address : 8WJW+89 Mecca</p>");
            out.println("<p>contact us : 0512345678</p>");
            out.println("</div>");
            out.println("</footer>");
            
            out.println("</div>");
            out.println("<hr />");
            out.println("</body>");
            out.println("</html>");
            
        }catch(Exception exceptionx){
            //handel mysql errors
            out.println ("<p> There is an error in your data :-> " + exceptionx + ""
                    + " try to re submit your data.</p>");
            out.println("</div>");
            out.println("<hr />");
            out.println("</body>");
            out.println("</html>");
        }
        finally{
            //close the writer
            out.close();
        }
    }
    
}
