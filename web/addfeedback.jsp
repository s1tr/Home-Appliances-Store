<%-- 
    Document   : addfeedback
    Created on : Feb 17, 2023, 4:36:59 AM
    Author     : awdal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <%
        response.setHeader("Pragma", "No-cache");
        response.setDateHeader("Expires", 0);
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    %>

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Feedback</title>
    <link rel="shortcut icon" type="image/svg" href="images/web-icon.svg">
    <link rel="stylesheet" href="css/style.css">
</head>

<body>

    <%
        //get the session object and casting it to string
        String username = (String)session.getAttribute("USER");
        //if there is a session exist of this user, then...
        if(username != null){
        %>
    <!--here the navbar will contain the pages that the only loggedin users can access-->
    <nav>
        <div class="nav-bar">
            <div class="nav-home">
                <a href="index.jsp"><span class="orangeletter">Y</span>our <span class="orangeletter">H</span>ome<span
                        class="orangeletter"> :)</span></a>
            </div>
            <div class="nav-links">
                <ul>
                    <li><a href="index.jsp" class="links">Home</a></li>
                    <li><a href="addnewappliance.jsp" class="links">Add New Home Appliance</a></li>
                    <li><a href="browseAppliances" class="links">Browse All Appliances</a></li>
                    <li><a href="addfeedback.jsp" class="links link3">Feedback</a></li>
                    <li><a href="logout" class="links">Logout</a></li>
                </ul>
            </div>
        </div>
    </nav>
    <%
        }
        //if there is no session exist of this user, then...
        else{
    %>
    <!--here the navbar will contain the pages that the public user can access-->   
    <nav>
        <div class="nav-bar">
            <div class="nav-home">
                <a href="index.jsp"><span class="orangeletter">Y</span>our <span class="orangeletter">H</span>ome<span
                        class="orangeletter"> :)</span></a>
            </div>
            <div class="nav-links">
                <ul>
                    <li><a href="index.jsp" class="links">Home</a></li>
                    <li><a href="login.html" class="links" target="blank">Login</a></li>
                    <li><a href="register.html" class="links">Register</a></li>
                    <li><a href="addfeedback.jsp" class="links link3">Feedback</a></li>
                </ul>
            </div>
        </div>
    </nav>
    
    <%
        //end of else
        }
    %>


    <main class="page-layout">
        <h1 class="form-header">Add Feedback</h1>
        <div class="form-layout">

            <form action="AddFeddback" method="post" onsubmit="return validateFeedback()">



                <div class="f-container">
                    <label for="name" class="lbl">Name :<span id="err-name" class="error"></span></label>
                    <input type="text" name="name" id="name" placeholder="Enter your name">
                </div>

                <div class="f-container">
                    <label for="email" class="lbl">Email :<span id="err-email" class="error"></span></label>
                    <input type="email" name="email" id="email" placeholder="Enter your email">
                </div>

                <div class="f-container">
                    <label for="phone" class="lbl">Phone Number :<span id="err-phone" class="error"></span></label>
                    <input type="text" name="phone" id="phone"
                        placeholder="Enter your phone number like : 055** or 96655**">
                </div>

                <div class="f-container">
                    <label for="reqtype" class="lbl">Request Type :<span id="err-reqtype" class="error"></span></label>
                    <input type="text" name="reqtype" id="reqtype" placeholder="Enter your Request type">
                </div>

                <div class="f-container">
                    <label for="subject" class="lbl">Subject :<span id="err-subject" class="error"></span></label>
                    <input type="text" name="subject" id="subject" placeholder="Enter your subject">
                </div>

                <div class="f-container">
                    <label for="message" class="lbl">Message :<span id="err-message" class="error"></span></label>
                    <textarea name="message" id="message" cols="30" rows="10"
                        placeholder="Write your message..."></textarea>
                </div>

                <div class="f-container">
                    <input type="submit" name="submit" id="submitbtn">
                </div>




            </form>
            <div class="feedback-image"></div>
        </div>
    </main>
    
    <footer>
            <div class="footer">
                <p>2023 &copy; YourHome. All Rights Reserved</p>
                <p>address : 8WJW+89 Mecca</p>
                <p>contact us : 0512345678</p>
            </div>
        </footer>

</body>
<script src="js/site.js"></script>

</html>
