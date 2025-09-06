<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Survey Result</title>
        <link rel="stylesheet" href="styles/main.css">
    </head>
    <body>
        <div class="container">
            <h1>Thanks for completing our survey</h1>
            <p>Here is the information you submitted:</p>

            <div class="info-row">
                <span class="label">First Name:</span>
                <span class="value">${user.firstName}</span>
            </div>
            <div class="info-row">
                <span class="label">Last Name:</span>
                <span class="value">${user.lastName}</span>
            </div>
            <div class="info-row">
                <span class="label">Email:</span>
                <span class="value">${user.email}</span>
            </div>
            <div class="info-row">
                <span class="label">Date of Birth:</span>
                <span class="value">${user.dateOfBirth}</span>
            </div>
            <div class="info-row">
                <span class="label">How you heard:</span>
                <span class="value">${user.howHear}</span>
            </div>
            <div class="info-row">
                <span class="label">Receive updates:</span>
                <span class="value">${user.wantsUpdates ? "Yes" : "No"}</span>
            </div>
            
            <%-- Dùng thẻ c:if để kiểm tra nếu wantsUpdates là true thì mới hiển thị dòng Contact via --%>
            <c:if test="${user.wantsUpdates == true}">
                <div class="info-row">
                    <span class="label">Contact via:</span>
                    <span class="value">${user.contactVia}</span>
                </div>
            </c:if>

            <p>To submit another survey, click the button below.</p>

            <form action="" method="get">
                <input type="hidden" name="action" value="join">
                <button type="submit" class="submit-btn">Return to Survey</button>
            </form>
        </div>
    </body>
</html>