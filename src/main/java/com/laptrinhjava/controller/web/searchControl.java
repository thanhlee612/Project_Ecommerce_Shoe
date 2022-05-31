/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.laptrinhjava.controller.web;

import com.laptrinhjava.model.Product;
import com.laptrinhjava.service.IProductService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "searchControl", urlPatterns = {"/searchControl"})
public class searchControl extends HttpServlet {

    private IProductService productService;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
      
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String txt = request.getParameter("txtSearch");
        List<Product> list = productService.searchByname(txt);
        request.setAttribute("txtS", txt);
        PrintWriter out = response.getWriter();
        list.forEach(p -> {
            out.println("   <div class=\"sanpham col-lg-3 col-md-6\">\n"
                    + "                                <div class=\"single-product\">\n"
                    + "                                    <img class=\"img-fluid\" src=\"template/web/img/product/" + p.getImage() + "\" alt=\"\">\n"
                    + "                                    <div class=\"product-details\">\n"
                    + "                                        <h6>" + p.getPname() + "</h6>\n"
                    + "                                        <div class=\"price\">\n"
                    + "                                            <h6>" + p.getPrice() + "</h6>\n"
                    + "                                            <h6 class=\"l-through\">$210.00</h6>\n"
                    + "                                        </div>\n"
                    + "                                        <div class=\"prd-bottom\">\n"
                    + "\n"
                    + "                                            <a href=\"\" class=\"social-info\">\n"
                    + "                                                <span class=\"ti-bag\"></span>\n"
                    + "                                                <p class=\"hover-text\">add to bag</p>\n"
                    + "                                            </a>\n"
                    + "                                            <a href=\"\" class=\"social-info\">\n"
                    + "                                                <span class=\"lnr lnr-heart\"></span>\n"
                    + "                                                <p class=\"hover-text\">Wishlist</p>\n"
                    + "                                            </a>\n"
                    + "                                            <a href=\"\" class=\"social-info\">\n"
                    + "                                                <span class=\"lnr lnr-sync\"></span>\n"
                    + "                                                <p class=\"hover-text\">compare</p>\n"
                    + "                                            </a>\n"
                    + "                                            <a href=\"singleProduct?pid=" + p.getId() + "\" class=\"social-info\">\n"
                    + "                                                <span class=\"lnr lnr-move\"></span>\n"
                    + "                                                <p class=\"hover-text\">view more</p>\n"
                    + "                                            </a>\n"
                    + "                                        </div>\n"
                    + "                                    </div>\n"
                    + "                                </div>\n"
                    + "                            </div>  ");
        });
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
