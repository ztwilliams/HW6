<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.States" %>
<% States state = (States) request.getAttribute("state"); %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="HW5CSS.css">
        <title>Update State</title>
    </head>
    
    <body>
        
         <h1>Update A State Record</h1>
        
        <form name="updateForm" action="updateState" method="get">
            
            <table class="update">
                
            <tr>
                <td class="right">State ID</td>
                <td><input type="text" name="stateID" value="<%= state.getStateID() %>" readonly/></td>
            </tr>
            
            <tr>
                <td class="right">State Name</td>
                <td><input type="text" name="stateName" value="<%= state.getStateName() %>" /></td>
            </tr>
            
            <tr>
                <td class="right">Year Founded</td>
                <td><input type="text" name="yearFounded" value="<%= state.getYearFounded() %>" /></td>
            </tr>
            
            <tr>
                <td class="right">Population</td>
                <td><input type="text" name="population" value="<%= state.getPopulation() %>" /></td>
            </tr>
            
            <tr>
                <td class="right">Age</td>
                <td><input type="text" name="age" value="<%= state.getAge() %>" /></td>
            </tr>
            
            </table>
            <br>
            <input type="reset" name="reset" value="Clear"/>
            <input type="submit" name="submit" value="Update"/>
            
            
        </form>
         
    </body>
</html>
