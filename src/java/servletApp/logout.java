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
import javax.servlet.http.HttpSession;


/**
 *
 * @author awdal
 */
public class logout extends HttpServlet {




    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //setup print writer to print text in the sccren
        PrintWriter out = response.getWriter();
        //setup the session
        HttpSession session = request.getSession();
        //get the session object
        //casting the session object as string 
        String username = (String)session.getAttribute("USER");
        //if the session is exist
        
        
        if(username != null){
            
            //selete session
            session.invalidate();
            
            //display the message of success delete
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title> Logout </title>");
            out.println("<link rel=\"stylesheet\" href=\"css/style.css\">");
            out.println("<link rel=\"shortcut icon\" type=\"image/svg\" href=\"images/web-icon.svg\">");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class=\"error-page error-msg\">");
            out.println("<h1>You have logged out successfully!</h1>");
            out.println("<h1>You'll redirect to home page after 3 second... </h1>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
            //we dont take this in the corse but i put it to make it mroe realistic
            //so if the user press logout button then the program display a mesage then after 3 second redirect the user to index.jsp
            response.setHeader("Refresh","3; index.jsp");
            //response.sendRedirect("index.jsp");
        
        }
        else{
            //if the session is not exist, then the user is trying to access the logout page from URL bar
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title> Logout </title>");
            out.println("<link rel=\"stylesheet\" href=\"css/style.css\"");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class=\"error-page error-msg\">");
            out.println("<h1>You can't access this page while you're not logged in!</h1>");
            out.println("<h1><a href=\"login.html\" style=\"color: #1e23fd;\" target=\"blank\">Login </a></h1>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        }

        
    }

}
