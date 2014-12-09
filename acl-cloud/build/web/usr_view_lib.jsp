 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>ACBN Libs</title>
        <meta name="keywords" content="magazine, theme, contact, web design, free templates, website templates, CSS, HTML" />
        <meta name="description" content="Magazine Theme is a free website template provided by templatemo.com for web designers and webmasters to use it for free in their web projects." />
        <link href="templatemo_style.css" rel="stylesheet" type="text/css" />

        <script language="javascript" type="text/javascript">
            function enableFields(state){
                document.getElementById("lib_name").disabled = state;
                document.getElementById("name").disabled = state;
                document.getElementById("email").disabled = state;
                document.getElementById("phone").disabled = state;
                document.getElementById("submit").disabled = state;
            }
            
            
            
            
        </script>

        <script type="text/javascript" src="js/jquery.min.js"></script>
        <link rel="stylesheet" href="css/slimbox2.css" type="text/css" media="screen" /> 
        <script type="text/JavaScript" src="js/slimbox2.js"></script> 

    </head>
   
   
    <body onload="enableFields(true)">

        <div id="templatemo_wrapper">
            <div id="templatemo_header">

                <div id="site_title"><h1><a href="#" rel="nofollow"> </a></h1></div>

                <div id="header_right">
                </div>

                <div class="cleaner"></div>
            </div>

            <div id="templatemo_menu">
                <ul>
                    <li><a href="usr_hme.html" >Home</a></li>
                    <li><a href="usr_lendings.html" >Lending Info</a></li>
                    <li><a href="usr_all_libs.html" class="current">Libraries</a></li>
                    <li><a href="usr_pre_booking.html">Pre Bookings</a></li>
                    <li><a href="usr_new_arrival.html">Arriving Books</a></li>
                    <li><a href="usr_account.html">Account</a></li>
                    <li><a href="LogoutServlet" >Log Out</a></li>
                </ul>     	
                <div id="search_box">
                    <form action="http://www.google.com/search" method="get">
                        <input type="text" value="Search" name="q" size="10" id="searchfield" title="searchfield" onfocus="clearText(this)" onblur="clearText(this)" />
                        <input type="submit" name="Search" value="" id="searchbutton" title="Search" />
                    </form>
                </div>
                <div class="cleaner"></div>
            </div> <!-- end of templatemo_menu -->

            <div id="templatemo_main">


                <div class="col_w960">

                    <div class="col_w450 float_l" style="height: 400px;">

                        <div id="contact_form">
                           
                            <h2>View Library</h2>
                            <form method="post" name="new_lib" action="EditLibServlet">  
                                <label for="author">Library :</label>
                                <input name="lib_name" type="text" required ="true" class="input_field" id="lib_name"  value="<%=libinfo.getLibName()%>"  maxlength="60" /> 
                                <input name="lib_id" type="hidden" class="input_field" id="lib-id"  value="<%=libinfo.getLibId()%>" maxlength="60" /> 
                                <div class="cleaner_h10"></div>  
                                <label for="author">Librarian Name:</label>
                                <input name="name" type="text" required ="true" class="input_field" id="name"  value="<%= libinfo.getName()%>" maxlength="60" /> 
                                <input name="username" type="hidden" class="input_field" id="username"  value="<%= libinfo.getUsername()%>" maxlength="60" /> 
                                <div class="cleaner_h10"></div>   

                                <label for="subject">Email:</label>
                                <input name="email" type="email"  required ="true" class="input_field" value="<%= libinfo.getEmail()%>"  id="email" maxlength="60" /> 
                                <div class="cleaner_h10"></div> 
                                <label for="subject">Phone:</label>
                                <input name="phone" type="number" pattern="[0-9]{10,10}" class="input_field" required ="true" value="<%=libinfo.getPhone()%>" id="phone" maxlength="60" /> 
                                <div class="cleaner_h10"></div>  

                            </form>

 
                        </div> 




                    </div>

                    <div class="col_w300 float_r">

                        <br/>
                        <h4> view Library</h4>

                    </div>

                    <div class="cleaner"></div>
                </div>

                <div class="cleaner"></div>
            </div> <!-- end of main -->

            <div id="templatemo_footer">

                <a class="copyright_style" href="#" title="obrazy"  >Copyright</a> © 2048 <a href="#">Your Company Name</a> | Designed by <a href="#" rel="nofollow" target="_parent">You</a>

            </div> <!-- end of templatemo_footer -->

        </div> <!-- end of wrapper -->


        <script type='text/javascript' src='js/logging.js'></script>
    </body>
    
</html>