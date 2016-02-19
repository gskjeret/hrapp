<!DOCTYPE html>
<%@ page contentType="text/html;charset=utf-8" import="java.sql.ResultSet"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252"/>
        <title>Employees</title>
        <link type="text/css" rel="stylesheet" href="resources/css/jdeveloper.css"/>
    </head>
    <body>
        <%@ page import="hrapp.DataHandler"%>
         
             <h2>Oracle Cloud HR Application</h2>
<img src="http://www.crayon.com/Content/images/logo.jpg">
<img src="http://www.mfrontiers.com/wp-content/uploads/2015/04/Oracle-Cloud-Logo-1.jpg">
       
        <h3>Employee Data</h3>
            <form action="employees.jsp">
            <jsp:useBean id="empsbean" class="hrapp.DataHandler" scope="session"/>
            Filter by employee name:
            <input type="text" name="query"/>
            <input type="submit" value="Filter"/>

            <%ResultSet rset;
String query = request.getParameter("query");
if (query != null)
    rset = empsbean.getEmployeesByName(query);
else
    rset = empsbean.getAllEmployees();
%>
            <table>
                <tr>
                    <td><h4>First Name</h4></td>
                    <td><h4>Last Name</h4></td>
                    <td><h4>Email</h4></td>
                    <td><h4>Job</h4></td>
                    <td><h4>Phone</h4></td>
                    <td><h4>Salary</h4></td>
                    <td>
                        <a href="insert.jsp">New Employee</a>
                    </td>
                </tr>
            <%while (rset.next ())
{
out.println("<tr>");
out.println("<td>" +
rset.getString("first_name") + "</td><td> " +
rset.getString("last_name") + "</td><td> " +
rset.getString("email") + "</td><td> " +
rset.getString("job_id") + "</td><td>" +
rset.getString("phone_number") + "</td><td>" +
rset.getDouble("salary") +
"</td><td> <a href=\"edit.jsp?empid=" + rset.getInt(1) +
"\">Edit</a> <a href=\"delete_action.jsp?empid=" +
rset.getInt(1) + "\">Delete</a></td>");
out.println("</tr>");
}%>
            </table></form>
    </body>
</html>