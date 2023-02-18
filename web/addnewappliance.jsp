<%-- 
    Document   : addnewappliance
    Created on : Feb 17, 2023, 4:26:32 AM
    Author     : awdal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

        <%
        //het the session of this user
        String username = (String)session.getAttribute("USER");
        //if there is session exist of this userm then diplay this page
        if(username != null){
    %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add New Home Appliance</title>
    <link rel="shortcut icon" type="image/svg" href="images/web-icon.svg">
    <link rel="stylesheet" href="css/style.css">
</head>


<body>
    <%
        //setup the browser cache, so that the browser cannot keep any cached data
        //we do this so the user not be able to see the previous page if the user logout
        response.setHeader("Pragma", "No-cache");
        response.setDateHeader("Expires", 0);
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    
    %>

    <nav>
        <div class="nav-bar">
            <div class="nav-home">
                <a href="index.jsp"><span class="orangeletter">Y</span>our <span class="orangeletter">H</span>ome<span
                        class="orangeletter"> :)</span></a>
            </div>
            <div class="nav-links">
                <ul>
                    <li><a href="index.jsp" class="links">Home</a></li>
                    <li><a href="addnewappliance.jsp" class="links link2">Add New Home Appliance</a></li>
                    <li><a href="browseAppliances" class="links">Browse All Appliances</a></li>
                    <li><a href="addfeedback.jsp" class="links">Feedback</a></li>
                    <li><a href="logout" class="links">Logout</a></li>
                </ul>
            </div>
        </div>
    </nav>
    

    <main class="page-layout">
        <h1 class="form-header">Add New Home Appliance</h1>
        <div class="form-layout">

            <form action="AddNewAppliances" method="post" onsubmit="return validateAddnewAppliance();">

                <div class="f-container">
                    <span class="lbl">Select the type: <span id="err-type" class="error"></span></span>
                    <div>
                        <label class="lblr">TV <input type="radio" name="type" value="tv" id="tv"></label>&nbsp; &nbsp;
                        &nbsp;
                        <label class="lblr">Washing Machine <input type="radio" name="type" value="washing machine"
                                id="wm"></label>
                        <label class="lblr">Refrigerator<input type="radio" name="type" value="refrigerator"
                                id="rf"></label>
                    </div>
                </div>

                <div class="f-container">
                    <label for="model" class="lbl">Select the model :<span id="err-model" class="error"></span></label>
                    <select name="model" id="model">
                        <option selected>Please select the item type...</option>
                        <option>Samsung AU8000 Series TV Monitor</option>
                        <option>BENQ 32 Inch HDR 2K IPS TV</option>
                        <option>LG WM3400CW Electric Front Load Washer</option>
                        <option>Samsung WF45A6400AV Smart Dial Front Load Washer</option>
                        <option>Kenmore 36 Side-by-Side Refrigerator</option>
                        <option>Anukis Compact Refrigerator 3.5 Cu Ft 2 Door Mini Fridge</option>
                        <option>RCA RFR786-RED 2 Door Apartment Size Refrigerator with Freezer</option>
                    </select>
                </div>

                <div class="f-container">
                    <label for="year" class="lbl">Select the year :<sup>*Optional</sup>: <span id="err-year"
                            class="error"></span></label>
                    <input type="number" name="year" id="year">
                </div>

                <div class="f-container">
                    <label for="manufacturer" class="lbl">Select the Manufacturer :<span id="err-manufacturer"
                            class="error"></span></label>
                    <select name="manufacturer" id="manufacturer">
                        <option selected>Please select the item manufacturer...</option>
                        <option>Samsung</option>
                        <option>BENQ</option>
                        <option>LG</option>
                        <option>Kenmore</option>
                        <option>Anukis</option>
                        <option>RCA</option>
                    </select>
                </div>

                <div class="f-container">
                    <label for="description" class="lbl">Description<sup>*Optional</sup> :<span id="err-description"
                            class="error"></span></label>
                    <input type="text" name="description" id="description">
                </div>

                <div class="f-container">
                    <label for="count" class="lbl">the Count :<span id="err-count" class="error"></span></label>
                    <input type="number" name="count" id="count">
                </div>

                <div class="f-container">
                    <label for="price" class="lbl">Price :<span id="err-price" class="error"></span></label>
                    <input type="number" name="price" id="price" step="any">
                </div>
                <div class="f-container">
                    <input type="submit" name="submit" id="submitbtn">
                </div>


            </form>

            <div class="discount"></div>
        </div>

        <footer>
            <div class="footer">
                <p>2023 &copy; YourHome. All Rights Reserved</p>
                <p>address : 8WJW+89 Mecca</p>
                <p>contact us : 0512345678</p>
            </div>
        </footer>
    </main>


    
    </body>      
    <script src="js/site.js"></script>

</html>   

        <%
        }
else{
    //if there is no session exist of this user, then redirect hem to home page
    response.sendRedirect("index.jsp");
    }
%>