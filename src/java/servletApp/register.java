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
import java.security.MessageDigest;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author awdal
 */
public class register extends HttpServlet {


    // store the mysql driver and URL to get access to the database
    static final String JDBC_DRIVER = "";
    static final String DB_URL = "";
    
    // store the mysql root user name and password
    static final String USER = "root";
    static final String PASS = "";
    
    // call do post method to send the request data to the server
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // set the file content type
        response.setContentType("text/html;charset=UTF-8");
        
        // set the writer for displaying the text
        PrintWriter out = response.getWriter();
        
        try {
            //get the parameter of from the form
            String name = request.getParameter("fullname");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String hashed_password = md5(password);
            

            
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
            out.println("<li><a href=\"login.html\" class=\"links\">Login</a></li>");
            out.println("<li><a href=\"register.html\" class=\"links link3\">Register</a></li>");
            out.println("<li><a href=\"addfeedback.jsp\" class=\"links\">Feedback</a></li>");
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
            String sqlQuery = "INSERT INTO USERS (fullname, username, password_, "
                    + "Creation_DateTime) values(?,?,?,?)";
            //the sql query that will get the emails
            String getemail = "SELECT username FROM USERS";
            
            //setup the prepared statemnt for geting the emails
            PreparedStatement ps1 = connection.prepareStatement(getemail);
            //setup the result set for all emails
            ResultSet result = ps1.executeQuery();
            //while there is a data the username field....
            while(result.next()){
                //if the email we get it from database equal the user email then ptint error message
                if(result.getString("username").equals(email)){
                    out.println("<div class=\"error-container\">");
                    out.println("<div class=\"error-sign\">");
                    out.println("</div>");
                    out.println ("<p class=\"error-reg\"> The email is already exist try another email !</p>");
                    out.println("<a href=\"register.html\">Register</a>");
                    out.println("</div>");
                    // here if we do not stop the program and let it execute the code below then the databads will incremant the userid by 1 even if the data will be not stores
                    return;
                }
            }
            
            //setup prepared statment for insert sql query 
            PreparedStatement ps = connection.prepareStatement(sqlQuery);
            
            // insert the data in database
            ps.setString(1, name);
            ps.setString(2, email);
            //insert the encripted password
            ps.setString(3, hashed_password);
            
            //get the current date
            Date dNow = new Date();
            SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
            String sqlDate = ft.format(dNow);
            ps.setString(4, sqlDate);
            
            //execute the sql query
            int k = ps.executeUpdate();
            
            //if k == 1, then the data is inserted in database
            if(k == 1){
                // is success, display the successfully message
                out.println("<div class=\"currect-container\">");
                out.println("<div class=\"currect-sign\">");
                out.println("</div>");
                out.println("<p class=\"correct\"> successfully registered. </p>");
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
            
            
            
            
        } catch (Exception e) {
            //handle the error of inserting data
            out.println ("<p> There is an error in your data :-> " + e + ""
                    + " try to re submit your data.</p>");
            out.println("</div>");
            out.println("<hr />");
            out.println("</body>");
            out.println("</html>");
            
            
    }}
    
    //setup the function for hashing password
    public static String md5(String pass){
        String md5 = null;
        if(pass ==  null)
            return null;
        try {
            MessageDigest digest = MessageDigest.getInstance("md5");
            digest.update(pass.getBytes(), 0, pass.length());
            md5 = new BigInteger(1, digest.digest()).toString(16);
        }
        catch(NoSuchAlgorithmException e) {
            //handel the error of md5 algorithm
            e.printStackTrace();
        }
        //return the hashed password
        return md5;
    }



}
