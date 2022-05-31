<%@page import="com.laptrinhjava.dao.impl.test"%>
<%@page import="com.laptrinhjava.model.Product"%>
<%@page import="java.util.List"%>
<%@page import="com.laptrinhjava.service.IProductService"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
    <%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
    </head>
    <body>
        
            <%
            test t = new test();
            String pid = request.getParameter("exits");
            int amount = Integer.parseInt(pid);             
            List<Product> list = t.findNext4product(amount);
            for (Product o : list) 
            {%>
            <div class="sanpham col-lg-3 col-md-6">
            <div class="single-product">
                <img class="img-fluid" src="template/web/img/product/<%=o.getImage()%>" alt="">
                <div class="product-details">
                    <h6><%=o.getPname()%></h6>
                    <div class="price">
                        <h6><%out.print(o.getPrice());%></h6>
                        <h6 class="l-through"><%=o.getPrice()%></h6>
                    </div>
                    <div class="prd-bottom">

                        <a href="" class="social-info">
                            <span onclick="myFunction('<%=o.getId()%>', '<%=o.getPname()%>','<%=o.getImage()%>','<%=o.getPrice()%>');" class="ti-bag"></span>
                            <p class="hover-text">add to bag</p>
                        </a>
                        <a href="" class="social-info">
                            <span class="lnr lnr-heart"></span>
                            <p class="hover-text">Wishlist</p>
                        </a>
                        <a href="" class="social-info">
                            <span class="lnr lnr-sync"></span>
                            <p class="hover-text">compare</p>
                        </a>
                        <a href="singleProduct?pid=${o.id}" class="social-info">
                            <span class="lnr lnr-move"></span>
                            <p class="hover-text">view more</p>
                        </a>
                    </div>
                </div>
            </div>
        </div>	
        <%}%>


    </body>
</html>