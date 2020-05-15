<!DOCTYPE html>
<html>
<head>
	<title>Airline Reservation System</title>
    <link rel="stylesheet" type="text/css" href="css\main-page.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  
    <script src="js\automate-slideshow.js" type="text/javascript"></script>
    <style type="text/css">
    *{margin: 0;padding:0px}

                .header{
                    width: 100%;
                    background-color: none;
                    height: 60px;
                }

                .showLeft{
                   text-shadow: none !important;
                    color:#fff !important;
                    padding:10px;
                }

                .icons li {
                    background: none repeat scroll 0 0 #fff;
                    height: 7px;
                    width: 7px;
                    line-height: 0;
                    list-style: none outside none;
                    margin-right: 15px;
                    margin-top: 3px;
                    vertical-align: top;
                    border-radius:50%;
                    pointer-events: none;
                    border-color: black;
                    background-color: black;
                }
    
    .btn-left {
                    left: 0.4em;
                }

                .btn-right {
                    right: 0.4em;
                }

                .btn-left, .btn-right {
                    position: absolute;
                    top: 0.24em;
                }

                .dropbtn {
                    
                    
                    color: white;
                    font-size: 16px;
                    border: none;
                    cursor: pointer;
                }

                .dropbtn:hover, .dropbtn:focus {
                  
                }

                .dropdown {
                    position: absolute;
                    display: inline-block;
                    right: 0.4em;
                }

                .dropdown-content {
                    display: none;
                    position: relative;
                    margin-top: 60px;
                    background-color: #f9f9f9;
                    min-width: 160px;
                    overflow: auto;
                    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
                    z-index: 1;
                }

                .dropdown-content a {
                    color: black;
                    padding: 12px 16px;
                    text-decoration: none;
                    display: block;
                }

                .dropdown a:hover {background-color: #f1f1f1}

                .show {display:block;}

            </style>
            <script>
                function changeLanguage(language) {
                    var element = document.getElementById("url");
                    element.value = language;
                    element.innerHTML = language;
                }

                function showDropdown() {
                    document.getElementById("myDropdown").classList.toggle("show");
                }

                // Close the dropdown if the user clicks outside of it
                window.onclick = function(event) {
                    if (!event.target.matches('.dropbtn')) {
                        var dropdowns = document.getElementsByClassName("dropdown-content");
                        var i;
                        for (i = 0; i < dropdowns.length; i++) {
                            var openDropdown = dropdowns[i];
                            if (openDropdown.classList.contains('show')) {
                                openDropdown.classList.remove('show');
                            }
                        }
                    }
                }
            </script>
    
    

</head>
<body>
	<div class="menu" name="menubar">
		<img src="images\logo2.png" id="special">
		<span id="Build" style="font-size:xx-large;font-family:sans-serif;margin-right:29%;text-decoration:underline">Fly In The Air</span>
			<button class="btn btn-primary active"  ><a href="signup.jsp" style="text-decoration:none;color:white;" target="_blank">SignUp</a></button>
		<button class="btn btn-primary disabled"><a href="signin.jsp" style="text-decoration:none;color:white" target="_blank">SignIn</a></button>
		<div class="header">

                <!-- three dot menu -->
                <div class="dropdown">
                    <!-- three dots -->
                    <ul class="dropbtn icons btn-right showLeft" style="margin-top:-70px;" onclick="showDropdown()">
                        <li></li>
                        <li></li>
                        <li></li>
                    </ul>
                    <!-- menu -->
                    <div id="myDropdown" class="dropdown-content">
                        <a href="index.jsp">Book a Ticket</a>
                        <a href="index1.jsp">Cancel Ticket</a>
                        <a href="index2.jsp">My Bookings</a>
                        <a href="index3.jsp">Admin Login</a>
                    </div>
                </div>

            </div>
		
		
	</div>
	<script type="text/javascript">
		var k=1;
	</script>
<div class="container">
   <img class="mySlides" src="images\flight1.jpg">
   <img class="mySlides" src="images\flight2.jpg">
   <img class="mySlides" src="images\flight3.jpg">
   <img class="mySlides" src="images\flight4.jpg">
   <img class="mySlides" src="images\flight5.jpg">
</div>
  <div class="circles" style="margin-left:45%;margin-top:13px;">
  	<div class="dot" id="c1" onclick="crctpic(k)"></div>
  	<div id="c2" class="dot" onclick="crctpic(k+1)"></div>
  	<div id="c3" class="dot" onclick="crctpic(k+2)"></div>
  	<div id="c4" class="dot" onclick="crctpic(k+3)"></div>
  	<div id="c5" class="dot" onclick="crctpic(k+4)"></div>
  </div>
  <script type="text/javascript">
  var myIndex = 0;
  carousel();
  	</script>
</body>
</html>