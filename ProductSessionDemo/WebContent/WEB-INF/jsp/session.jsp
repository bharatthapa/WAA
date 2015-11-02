<!DOCTYPE HTML>
<html>
<head>
<title>Session</title>
<style type="text/css">@import url(resource/css/main.css);</style>
</head>
<body>
<div id="global">
    <h2 style="text-align: center;">${appName }</h2>
    <h4>The session is here.</h4>
 
    <!-- Get parameter value displayed if from redirect-->
  ${redirectParamTest}<br>
  
  <!--Should  see the request attribute here IF from forward
       NOT displayed if from redirect-->
 requestAttribute is:   ${requestAttribute}<br>
  
  <form action="product" method="get">
           <input id="submit" type="submit"  
                value="Go to add Product">
</form>
  
 </body>
</html>