package com.laptrinhjava.controller.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laptrinhjava.model.Product;
import com.laptrinhjava.service.IProductService;

@WebServlet("/LoadMore")
public class LoadMore extends HttpServlet {

    private static final long serialVersionUID = 1L;
    @Inject
    private IProductService productService;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/html;charset=UTF-8");
        String pid = request.getParameter("exits");
        int amount = Integer.parseInt(pid);
        List<Product> list = productService.findNext4Product(amount);
        PrintWriter out = response.getWriter();
        list.forEach(p -> {
            out.println("   <div class=\"sanpham col-lg-3 col-md-6\">\n"
                    + "                                <div class=\"single-product\">\n"
                    + "                                    <img class=\"img-fluid\" src=\"template/web/img/product/"+p.getImage()+"\" alt=\"\">\n"
                    + "                                    <div class=\"product-details\">\n"
                    + "                                        <h6>"+p.getPname()+"</h6>\n"
                    + "                                        <div class=\"price\">\n"
                    + "                                            <h6>"+p.getPrice()+"</h6>\n"
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
                    + "                                            <a href=\"singleProduct?pid="+p.getId()+"\" class=\"social-info\">\n"
                    + "                                                <span class=\"lnr lnr-move\"></span>\n"
                    + "                                                <p class=\"hover-text\">view more</p>\n"
                    + "                                            </a>\n"
                    + "                                        </div>\n"
                    + "                                    </div>\n"
                    + "                                </div>\n"
                    + "                            </div>  ");
        });

    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/html;charset=UTF-8");

    }

}
