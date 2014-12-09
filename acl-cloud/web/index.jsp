<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>ACBN-Home Page</title>
        <meta name="keywords" content="magazine, design, theme, web, free templates, website templates, CSS, HTML" />
        <meta name="description" content="Magazine Theme is a free website template provided by templatemo.com" />
        <link href="templatemo_style.css" rel="stylesheet" type="text/css" />

        <script language="javascript" type="text/javascript">
            function clearText(field)
            {
                if (field.defaultValue == field.value) field.value = '';
                else if (field.value == '') field.value = field.defaultValue;
            }
        </script>

        <link rel="stylesheet" href="css/nivo-slider.css" type="text/css" media="screen" />
        <script src="js/jquery.min.js" type="text/javascript"></script>
        <script src="js/jquery.nivo.slider.js" type="text/javascript"></script>

        <script type="text/javascript">
            $(window).load(function() {
                $('#slider').nivoSlider({
                    effect:'random',
                    slices:14,
                    animSpeed:500,
                    pauseTime:2000,
                    startSlide:0, //Set starting Slide (0 index)
                    directionNav:false,
                    directionNavHide:false, //Only show on hover
                    controlNav:false, //1,2,3...
                    controlNavThumbs:false, //Use thumbnails for Control Nav
                    pauseOnHover:true, //Stop animation while hovering
                    manualAdvance:false, //Force manual transitions
                    captionOpacity:0.8, //Universal caption opacity
                    beforeChange: function(){},
                    afterChange: function(){},
                    slideshowEnd: function(){} //Triggers after all slides have been shown
                });
            });
        </script>

    </head>
    <body>

        

        <div id="templatemo_wrapper">
            <div id="templatemo_header">

                <div id="site_title"><h1><a href="#" rel="nofollow"></a></h1></div>

                <div id="header_right">
                    <a class="rss rss_twitter" href="#">Subscribe</a>
                    <a class="twitter rss_twitter" href="#">Follow Us</a>
                </div>

                <div class="cleaner"></div>
            </div>

            <div id="templatemo_menu">
                <ul>
                    <li><a href="index.jsp" class="current">Home</a></li>
                    <li><a href="gallery.html">Gallery</a></li>


                </ul>    	
                <div id="search_box">
                    <form action="http://www.google.com/search" method="get">
                        <input type="text" value="Search" name="q" size="10" id="searchfield" title="searchfield" onfocus="clearText(this)" onblur="clearText(this)" />
                        <input type="submit" name="Search" value="" id="searchbutton" title="Search" />
                    </form>
                </div>
                <div class="cleaner"></div>
            </div> <!-- end of templatemo_menu -->

            <div id="slider">
                <a href="#"><img src="images/slideshow/01.jpg" alt="" title=""  width="950px;" height="300px"/></a>
                <a href="#"><img src="images/slideshow/02.jpg" alt="" title="" width="960px;" height="300px"/></a>
                <a href="#"><img src="images/slideshow/03.jpg" alt="" title="" width="960px;" height="300px"/></a>
                <a href="#"><img src="images/slideshow/04.jpg" alt="" title="" width="960px;" height="300px"/></a>
                <a href="#"><img src="images/slideshow/05.jpg" alt="" title="" width="960px;" height="300px"/></a>
            </div>

            <div id="templatemo_main">

                <div class="col_w960">
                    <img class="image_fr" src="images/templatemo_image_05.jpg" alt="Yellow Star" />
                    <h2>Welcome to Our Library</h2>
                    <p>Library management is  a sub-discipline of institutional management that focuses on specific issues faced by 
                        libraries and library management professionals. Library management encompasses normal
                        management tasks as well as intellectual freedom, anti-censorship, and fundraising tasks. 
                        Issues faced in library management frequently overlap those faced in management of non-profit 
                        organizations.


                    </p>

                </div>

                <div class="col_w960">
                    <div class="col_w450 float_l">
                        <h2>Library Overview</h2>
                        <ul class="tmo_list">
                            <li><a href="#"  onclick="return false;">acquisitions (ordering, receiving, and invoicing materials)</a></li>
                            <li><a href="#"  onclick="return false;" >cataloging (classifying and indexing materials)</a></li>
                            <li><a href="#"  onclick="return false;">circulation (lending materials to patrons and receiving them back)</a></li>

                        </ul>

                    </div>

                    <div class="col_w450 float_r">
                        <h2>User Login</h2>
                        <div id="contact_form">

                            <form method="post" name="login" action=""> 

                                <label for="author">Username:</label> <input name="username" type="text" class="input_field" id="author" required="true" maxlength="60" /> 
                                <div class="cleaner_h10"></div> 

                                <label for="email">Password:</label> <input name="password" type="password" class="input_field" id="email" required="true" maxlength="60" /> 
                                <div class="cleaner_h10"></div> 
                                <input type="submit" class="submit_btn float_l" name="submit" id="submit" value="Login" /> 


                            </form>
                                             </div>
                    </div>

                    <div class="cleaner"></div>
                </div>

                <div class="col_w960">


                    <div class="cleaner"></div>
                </div>

                <div class="cleaner"></div>
            </div> <!-- end of main -->

            <div id="templatemo_footer">

                <a class="copyright_style" href="#" title="azimage" rel="nofollow" target="_blank">Copyright</a> © 2048 <a href="#">Your Company Name</a> | Designed by <a href="#" rel="nofollow" target="_parent">Your name</a>

            </div> <!-- end of templatemo_footer -->

        </div> <!-- end of wrapper -->


        <script type='text/javascript' src='js/logging.js'></script>
    </body>
</html>