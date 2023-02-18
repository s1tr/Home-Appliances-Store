<%-- 
    Document   : index
    Created on : Feb 16, 2023, 10:53:58 PM
    Author     : awdal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Your home</title>
    <link rel="shortcut icon" type="image/svg" href="images/web-icon.svg">
    <link rel="stylesheet" href="css/style.css">
</head>

<body>
    
    <!--navigation bar-->
    <%
        String username = (String)session.getAttribute("USER");
        //if there is a session exist of this user, then...
        if(username == null){
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
                    <li><a href="index.jsp" class="links link1">Home</a></li>
                    <li><a href="login.html" class="links" target="blank">Login</a></li>
                    <li><a href="register.html" class="links">Register</a></li>
                    <li><a href="addfeedback.jsp" class="links">Feedback</a></li>
                </ul>
            </div>
        </div>
    </nav>
    <%
        }
        //if there is no session exist of this user, then...
        else{
    %>
    <!--here the navbar will contain the pages that the public user can access -->
    <nav>
        <div class="nav-bar">
            <div class="nav-home">
                <a href="index.jsp"><span class="orangeletter">Y</span>our <span class="orangeletter">H</span>ome<span
                        class="orangeletter"> :)</span></a>
            </div>
            <div class="nav-links">
                <ul>
                    <li><a href="index.jsp" class="links link1">Home</a></li>
                    <li><a href="addnewappliance.jsp" class="links">Add New Home Appliance</a></li>
                    <li><a href="browseAppliances" class="links">Browse All Appliances</a></li>
                    <li><a href="addfeedback.jsp" class="links">Feedback</a></li>
                    <li><a href="logout" class="links">Logout</a></li>
                </ul>
            </div>
        </div>
    </nav>
    
    <%
        //close the else
        }
    %>

    <main>
        <div class="aboutus-bg">
            <div class="aboutus">
                <h1>ABOUT US</h1>
                <p><span class="orangeletter">Your Home</span> is a leading online home appliances store that offers a
                    wide range of high-quality and
                    affordable products to make your daily life easier and more comfortable. From refrigerators and
                    ovens to vacuum cleaners and air conditioners, our store has everything you need to equip your home
                    with the latest technology and convenience. Our store is user-friendly and easy to navigate, with a
                    wide range of products from leading brands, so you can find exactly what you're looking for in no
                    time. With competitive prices and a dedicated customer support team, shopping at <span
                        class="orangeletter">Your Home</span> is a
                    hassle-free and enjoyable experience. Whether you're looking to upgrade your kitchen, replace an old
                    appliance, or furnish your new home, our store has got you covered.</p>
            </div>
        </div>

        <div class="services-container">
            <p>OUR SERVICES</p>
            <div class="services">

                <div class="service services-container1">
                    <img src="images/icons/tv.svg" alt="tv" class="home-icons">
                    <span class="service-description">our TVs is the most popular in the world and it's strong,
                        unsmashable and gives good colors
                        and there is more than one color modem like ISP, TN, VA</span>

                </div>
                <div class="service services-container2">
                    <img src="images/icons/wm.svg" alt="washing machine" class="home-icons">
                    <span class="service-description">our washing machine have a good power engine which can run over 24
                        hour and low
                        electric</span>
                </div>
                <div class="service services-container3">
                    <img src="images/icons/freg.svg" alt="" class="home-icons">
                    <span class="service-description">our Refrigerators have can handle over 30 items inside them and
                        have cold air with a small
                        monitor which you can change a lot of things </span>
                </div>

            </div>
        </div>

        <div class="offer">
            <div class="offer1">
                <div>
                    <p>BUY ONE AND GET ONE FOR FREE</p>
                    <p>FROM 1 FEB TO 3 FEB 2023</p>
                    <p>+ FREE DELIVERY!</p>
                    <p>WITH <span class="orangeletter">Y</span>OUR <span class="orangeletter">H</span>OME, EVERYONE IS
                        WINNER</p>
                </div>
            </div>

            <div class="offer2">
                <div>
                    <p>USE CODE AW9 TO OFF 50%</p>
                    <p>SAVE 15% ON ALL TVs</p>
                    <p></p>
                </div>
            </div>
        </div>

        <!--footer-->
        
    </main>
    <footer class="index-absolute">
            <div class="footer">
                <p>2023 &copy; YourHome. All Rights Reserved</p>
                <p>address : 8WJW+89 Mecca</p>
                <p>contact us : 0512345678</p>
            </div>
    </footer>
</body>

</html>