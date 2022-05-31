<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <title>JSP Page</title>
    </head>
    <body>
      <input type="number" id="ip1"/>
      <input type="submit" id="sub"/>
      <div id="div1"></div>
      
     <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script> 
      <script>
          $("#sub").click(function(){
           var amount = $("#ip1").val();
           $.get("/Project_Ecommerce_Shoe/LoadMore",{exits: amount}, function(data){
              $("#div1").append(data);
           });
//            $.post("loadmore.jsp",{exits: amount}, function(data){
//              $("#div1").append(data);
//           });
           
          });
      </script>
    </body>
</html>
