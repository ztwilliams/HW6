<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="HW5CSS.css"
        <title></title>
    </head>
    
    <body>
        <h1>Add New State </h1>
        
        <form name="addForm" action="addState" method="get">
            <label>State Name</label>
            <input type="text" name="stateName" value="" />
            <br>
            <label>Year Founded</label>
            <input type="text" name="yearFounded" value="" />
            <br>
            <label>Population</label>
            <input type="text" name="population" value="" />
            <br>
            <label>Age</label>
            <input type="text" name="age" value="" />
            <br>
            <input type="submit" name="submit" value="Submit"/>
        </form>
        
    </body>
    
    
    
    
    
</html>
