<%@page import="com.laptrinhjava.model.Product"%>
<%@page import="java.util.List"%>
<%@page import="com.laptrinhjava.dao.impl.test"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
    <head>    
        <meta charset="UTF-8">
          <title>Shoe</title>
    </head>
    <body>
        <%
            response.setContentType("text/html;charset=UTF-8");
            request.setCharacterEncoding("UTF-8");
            String tname = request.getParameter("txt");
            test t = new test();
            List<Product> list = t.searchByName(tname);
            request.setAttribute("txtS", tname);
            request.setAttribute("product", list);
            request.getRequestDispatcher("/demo.jsp").forward(request, response);
        %>
    </body>
</html>
