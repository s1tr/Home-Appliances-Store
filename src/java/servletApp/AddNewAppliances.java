package servletApp;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.text.*;
import java.sql.*;



/**
 *
 * @author awdal
 */

public class AddNewAppliances extends HttpServlet {
    
    // store the mysql driver and URL to get access to the database
    static final String JDBC_DRIVER = "";
    static final String DB_URL = "";
    
    // store the mysql root user name and password
    static final String USER = "root";
    static final String PASS = "";
    
    // call do post method to send the request data to the server
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // set the file content type
        response.setContentType("text/html;charset=UTF-8");
        // set the writer for displaying the text
        PrintWriter out = response.getWriter();
        
        
        try{
            //get the parameter of the form
            String type = request.getParameter("type");
            String model = request.getParameter("model");
            String year = request.getParameter("year");
            String manufacturer = request.getParameter("manufacturer");
            String description = request.getParameter("description");
            String count = request.getParameter("count");
            String price = request.getParameter("price");
            
            
            // the year most be null to store it to the database
            if(year.equals("")){
                year = null;
            }
            
            
            // print the html in the screen as a response
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title> process result </title>");
            //to access the css file that is in the (Web page) file.
            // so here i don't find another way to access the css file except that way
            out.println("<link rel=\"stylesheet\" href=\"css/style.css\">");
            out.println("<link rel=\"shortcut icon\" type=\"image/svg\" href=\"images/web-icon.svg\">");
            out.println("</head>");
            out.println("<body>");
            
            // navigation bar, this will be the same as other navs
            out.println("<nav>");
            out.println("<div class=\"nav-bar\">");
            out.println("<div class=\"nav-home\">");
            out.println("<a href=\"index.jsp\"><span class=\"orangeletter\">Y</span>our "
                    + "<span class=\"orangeletter\">H</span>ome<span\n" +
                        "class=\"orangeletter\"> :)</span></a>");
            out.println("</div>");
            out.println("<div class=\"nav-links\">");
            out.println("<ul>");
            // the links in the nav bar 
            out.println("<li><a href=\"index.jsp\" class=\"links\">Home</a></li>");
            out.println("<li><a href=\"addnewappliance.jsp\" class=\"links link2\">Add New Home Appliance</a></li>");
            out.println("<li><a href=\"browseAppliances\" class=\"links\">Browse All Appliances</a></li>");
            out.println("<li><a href=\"addfeedback.html\" class=\"links\">Feedback</a></li>");
            out.println("<li><a href=\"logout\" class=\"links\">Logout</a></li>");
            out.println("</ul>");
            out.println("</div>");
            out.println("</div>");
            out.println("</nav>");
            
            
            //new container to display the message that we get in the response
            out.println("<div class=\"add-container\">");
            
            
            
            Class.forName(JDBC_DRIVER);
            
            //establish the connection to the database by give the database: user,password
            Connection connection = DriverManager.getConnection(DB_URL,USER,PASS);
            
            // the sql query that will go to the database
            String sqlQuery = "INSERT INTO addappliance (type_, model, year_,"
                    + " manufacturer, description_, count, "
                    + "price_per_unit, Creation_DateTime) VALUES (?, ?, ?, ?, "
                    + "?, ?, ?, ?)";

            //precompiled the sql query and stored it in a PreparedStatement object
            PreparedStatement ps = connection.prepareStatement(sqlQuery);
            //set the parameters values of the sql query
            ps.setString(1, type);
            ps.setString(2, model);
            ps.setString(3, year);
            ps.setString(4, manufacturer);
            ps.setString(5, description);
            ps.setString(6, count);
            ps.setString(7, price);
            
            // get the current date to store it to sql creation_date variable
            Date dNow = new Date( );
            SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
            String sqlDate = ft.format(dNow);
            ps.setString(8, sqlDate);
            
            
            // execute the sql query, id the returned value is 1 that means data stored currectly, 0 means error occurde
            int k = ps.executeUpdate();
            
            if(k == 1){
                // is success, display the successfully message
                out.println("<div class=\"currect-container\">");
                out.println("<div class=\"currect-sign\">");
                out.println("</div>");
                out.println("<p class=\"correct\"> Data successfully added. </p>");
                out.println("<br>");
                out.println("</div>");
            }
            else{
                // is not success, display the error message
                out.println("<div class=\"error-container\">");
                out.println("<div class=\"error-sign\">");
                out.println("</div>");
                out.println ("<p class=\"error\"> There was an error in adding the data! Try again. </p>");
                out.println("<a href=\"index.html\">Go Home</a>");
                out.println("</div>");
            }
            
            // print the footer
            out.println("<footer>");
            out.println("<div class=\"footer\">");
            out.println("<p>2023 &copy; YourHome. All Rights Reserved</p>");
            out.println("<p>address : 8WJW+89 Mecca</p>");
            out.println("<p>contact us : 0512345678</p>");
            out.println("</div>");
            out.println("</footer>");
            
            // close the body,html tags
            out.println("</div>");
            out.println("<hr />");
            out.println("</body>");
            out.println("</html>");
            
            // is error happens, display the error message
        }catch(Exception exceptionx){
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
