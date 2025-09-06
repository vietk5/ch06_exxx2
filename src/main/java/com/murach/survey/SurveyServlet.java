package com.murach.survey;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.murach.business.User;

@WebServlet("/survey")
public class SurveyServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String url = "/index.html";
        String action = request.getParameter("action");

        if (action == null) {
            action = "join";
        }

        if (action.equals("join")) {
            url = "/index.html";
        } else if (action.equals("add")) {
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");
            String dateOfBirth = request.getParameter("dateOfBirth");
            String howHear = request.getParameter("howHear");
            String wantsUpdatesParam = request.getParameter("receive_announcements");
            String emailOKParam = request.getParameter("send_email");
            String contactVia = request.getParameter("contact_method");

            boolean wantsUpdates = wantsUpdatesParam != null;
            boolean emailOK = emailOKParam != null;

            // Logic mới: Nếu người dùng chọn "unwanted_updates", đặt wantsUpdates thành false
            if ("unwanted_updates".equals(contactVia)) {
                wantsUpdates = false;
                contactVia = null; 
            }

            User user = new User();
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setEmail(email);
            user.setDateOfBirth(dateOfBirth);
            user.setHowHear(howHear);
            user.setWantsUpdates(wantsUpdates);
            user.setEmailOK(emailOK);
            user.setContactVia(contactVia);

            request.setAttribute("user", user);
            url = "/survey.jsp";
        }

        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}