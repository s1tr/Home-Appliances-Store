/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servletApp;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpSession;

/**
 *
 * @author awdal
 */
public class browseAppliances extends HttpServlet {

    //setup the mysql driver and url
    static final String JDBC_DRIVER = "";
    static final String DB_URL = "";
    
    //set the username and password of mysql server 
    static final String USER = "root";
    static final String PASS = "";
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //set page content type
        response.setContentType("text/html;charset=UTF-8");
        //setup the print writer to display data the page
        PrintWriter out = response.getWriter();
        
        //setup the session
        HttpSession session = request.getSession();
        //geting the session object and then casting it as string 
        String username = (String)session.getAttribute("USER");
        
        //setup the browser cache, so that the browser cannot keep any cached data
        //we do this so the user not be able to see the previous page if the user logout
        response.setHeader("Pragma", "No-cache");
        response.setDateHeader("Expires", 0);
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        
        //check if the user session is exist
        if(username != null){
        try{
            //if ture, then execute the code below
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title> browse the result </title>");
            out.println("<link rel=\"stylesheet\" href=\"css/style.css\">");
            out.println("<link rel=\"shortcut icon\" type=\"image/svg\" href=\"images/web-icon.svg\">");
            out.println("</head>");
            out.println("<body>");
            
            //nav bar
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
            out.println("<li><a href=\"addnewappliance.jsp\" class=\"links\">Add New Home Appliance</a></li>");
            out.println("<li><a href=\"browseAppliances\" class=\"links link3\">Browse All Appliances</a></li>");
            out.println("<li><a href=\"addfeedback.jsp\" class=\"links\">Feedback</a></li>");
            out.println("<li><a href=\"logout\" class=\"links\">Logout</a></li>");
            out.println("</ul>");
            out.println("</div>");
            out.println("</div>");
            out.println("</nav>");
            //close the nav bar
            
            //make a container for table
            out.println("<div class=\"table-container\">");
            out.println("<h1> Home Appliance Data </h1>");
            out.println("<br>");
            
            
            Class.forName (JDBC_DRIVER);
            
            
            Connection connection = DriverManager.getConnection (DB_URL, USER, PASS);
            
            
            // all the code above is same as AddNewAppliances.java and AddFeedback.java
            // all the code above is same as AddNewAppliances.java and AddFeedback.java
            // all the code above is same as AddNewAppliances.java and AddFeedback.java
            // all the code above is same as AddNewAppliances.java and AddFeedback.java
            // all the code above is same as AddNewAppliances.java and AddFeedback.java
            
            
            // the query is select, so to display the database record, not to insert
            String sqlQuery = "select * from addappliance";
            
            PreparedStatement ps  =  connection.prepareStatement(sqlQuery);
            
            // execute the query and save the sql table data in result variable
            ResultSet result = ps.executeQuery();
            
            // if the table is empty, means no data found in the table
            if ( ! result.isBeforeFirst()) { 
                out.println("<p class=\"no-data\"> NO Data Found </p>");
            }
            else{
                // if record found, start creating the table 
                out.println("<table border='1' class=\"table\">");
                // print the table header
                out.println("<tr> <th> ID </th> <th> Type </th> <th> Model </th> <th> Year </th>"
                        + "<th> Manufacturer </th> <th> Count </th> <th> Price_per_Unit </th>"
                        + " <th> Creation_DateTime </th> </tr>");
                // while there is a data in the table
                while(result.next()){
                    // table row
                    out.println("<tr>");
                    
                    // each loop means one row
                    out.println("<td>"+result.getInt("id"));
                    out.println("<td>"+result.getString("type_"));
                    out.println("<td>"+result.getString("model"));
                    out.println("<td>"+result.getInt("year_"));
                    out.println("<td>"+result.getString("manufacturer"));
                    out.println("<td>"+result.getInt("count"));
                    out.println("<td>"+result.getInt("price_per_unit"));
                    out.println("<td>"+result.getTimestamp("Creation_DateTime"));
                    
                    // end of table row
                    out.println("</tr>");
                }
                // close the table
                 out.println("</table>");
                 
            }
            
            // close the connection to mysql
            connection.close();
            
        }
        
        // catch the error, and display inside code
        catch (Exception exception) {
            
            out.println ("<p class=\"error\"> There was an error exception meesage: " + exception + "</p>");

            
        }finally {
           
            // close the body,html tag
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
            out.close();
        }
        
        
        }else{
            //if the user session is not exist the redirect hem to home page
            response.sendRedirect("index.jsp");
        }
        
        
    }

}
