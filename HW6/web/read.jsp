<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="HW5CSS.css"
        <title></title>
    </head>
    
    <% String table = (String) request.getAttribute("table"); %>
    
    <body>
        <h1>States</h1>
        <%= table %>
        
        <a href="add">Add New State</a>
        <br> <br>
        <a href="search.jsp">Search States</a>
        
    </body>
</html>
