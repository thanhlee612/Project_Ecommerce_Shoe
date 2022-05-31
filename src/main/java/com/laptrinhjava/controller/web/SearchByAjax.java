/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.laptrinhjava.controller.web;

import com.laptrinhjava.dao.impl.test;
import com.laptrinhjava.model.Product;
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
@WebServlet(name = "SearchByAjax", urlPatterns = {"/SearchByAjax"})
public class SearchByAjax extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SearchByAjax</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SearchByAjax at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String txtSA = request.getParameter("txtSearch");
        test t = new test();
        List<Product> list = t.searchByName(txtSA);
        PrintWriter out = response.getWriter();
        for (Product p : list) {
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
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
