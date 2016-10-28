<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="HW5CSS.css">
        <title></title>
    </head>
    
    <body>
        <h1>Add New State </h1>
        
        <form name="addForm" action="addState" method="get">
            <table>   
                <tr>
            <td>State Name</td>
            <td><input type="text" name="stateName" value="" /></td>
                </tr>
                
                <tr>
            <td>Year Founded</td>
            <td><input type="text" name="yearFounded" value="" /></td>
            </tr>
            
                <tr>
            <td>Population</td>
            <td><input type="text" name="population" value="" /></td>
                </tr>
                
                <tr>
            <td>Age</td>
            <td><input type="text" name="age" value="" /></td>
                </tr>
            
            </table>
            
            <input type="reset" name="reset" value="Clear"/>
            <input type="submit" name="submit" value="Submit"/>
        </form>
        
    </body>
    
    
    
    
    
</html>
