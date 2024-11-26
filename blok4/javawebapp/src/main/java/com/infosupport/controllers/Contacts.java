package com.infosupport.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

// @WebServlet("contacts") // or in web.xml
public class Contacts extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        writer.println("""
                    [
                        {
                          "id": 4,
                          "firstName": "Sam From Tomcat",
                          "surname": "Smith",
                          "email": "sam.smith@music.com"
                        },
                        {
                          "id": 8,
                          "firstName": "Frank",
                          "surname": "Muscles",
                          "email": "frank@muscles.com"
                        },
                        {
                          "id": 16,
                          "firstName": "Ramon",
                          "surname": "Arnhem",
                          "email": "ram@n.nl"
                        },
                        {
                          "id": 17,
                          "firstName": "Bram",
                          "surname": "Janssens",
                          "email": "s.a.janssens@gmail.com"
                        }
                    ]
                """.trim().replaceAll("\n", "").replaceAll("\r", ""));
        // super.doGet(req, resp);
    }
}
