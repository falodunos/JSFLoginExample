<%-- 
    Document   : login
    Created on : Oct 21, 2019, 10:04:21 AM
    Author     : Olugbenga.Falodun
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>

<f:view>
    <html>
        <head><title>JSF Simple Login Example</title></head>
        <body>
        <h:form>
            <table>
                <tr>
                    <td><h:outputText value="Enter Login ID: " /></td>
                <td><h:inputText id="userName"
                                 value="#{loginBean.userName}" />
                </td>
                </tr>
                <tr>
                    <td><h:outputText value="Enter Password: " /></td>
                <td><h:inputSecret id="password"
                                   value="#{loginBean.password}" />
                </td>
                </tr>
                <tr>
                    <td> </td>
                    <td><h:commandButton value="Login"
                                     action="#{loginBean.checkValidUser}"/>
                </td>
                </tr>
            </table>
        </h:form>
        </body>
    </html>
</f:view>