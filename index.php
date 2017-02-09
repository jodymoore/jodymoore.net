<?php
require 'aws-autoloader.php';
?>
<!DOCTYPE html
        PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
         "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <title>Jody Moore</title>
    <link href="/css1/bootstrap.min.css" rel="stylesheet"/>
    <link href="/css1/bootstrap-theme.min.css" rel="stylesheet"/>
    <link href="/css1/styles.css" rel="stylesheet"/>

    <script type="text/javascript" src="public/js/jquery-1.8.0.min.js"></script> 
    <script type="text/javascript" src="public/js/jquery-1.10.2.min.js"></script>
    <script type="text/javascript" src="public/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="public/js/scripts.js"></script>
  </head>
  <body>
   <div id="top">
    <h1><font>Welcome to</font></h1> 
    <h1><font>JodyMoore.net</font></h1>
   </div>
   <div id="middle"> 
    <img id ="mimg" text-align="center" alt="creds"  src="img/myPic3.jpg"/>
   <nav class="nav nav-pills">
     <ul>
       <a href="start.php"><h3><font>DevOpsPage</font></h3></a>
     </ul>
   </nav>
   <div id="PAWS">
   <article>
   <header class="post-header">
     <h2 class="post-title">Powered By AWS</a></h2>
     <section>
       <p>
        This site is powered by a public facing L.A.M.P web server hosted on an Amazon Web Services Ec-2 instance deployed in a Virtual Private Cloud  for increased security. The site is Highly-Available and fault tolerent. 
       </p>
       <img id = "imgpaws"alt="paws"  src="img/paws.png" width="25%" height="25%" /> 
     </section>  
   </article>  
   </div>
   </div> 
   <div id="bottom">
     <img alt="creds"  src="img/CSA.jpg" width="10%" height="10%" />   
   </div>
  </body>
</html>