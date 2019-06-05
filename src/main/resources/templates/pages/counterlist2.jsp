<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <!-- Pas géniaux les imports mais de toute façon JSP c'est obsolète ! -->
    <c:import url="/layout/head.jsp">
        <c:param name="title" value="Counters" />
    </c:import>
    <body>
        <c:import url="/layout/header.jsp">
            <c:param name="title" value="Counters" />
        </c:import>
        <c:if test="${param.success}">
            <p class="success-message">
                 The counter has been created successfully!
            </p>
        </c:if>
        <p>
            <a class="btn" href="./createcounter.jsp">Create a counter</a>
        </p>
        <ul class="counter-ul">
            <c:forEach items="${counterList}" var="counter">
                <li class="counter-li">
                    <strong class="counter-li-title">${counter.title}</strong>
                </li>
            </c:forEach>
        </ul>
    </body>
</html>