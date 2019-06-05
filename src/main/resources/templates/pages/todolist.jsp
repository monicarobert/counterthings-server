<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <!-- Pas géniaux les imports mais de toute façon JSP c'est obsolète ! -->
    <c:import url="/layout/head.jsp">
        <c:param name="title" value="Musiques" />
    </c:import>
    <body>
        <c:import url="/layout/header.jsp">
            <c:param name="title" value="Musiques" />
        </c:import>
        <c:if test="${param.success}">
            <p class="success-message">
                 La todo a bien été créée !
            </p>
        </c:if>
        <p>
            <a class="btn" href="./createtodo.jsp">Créer une todo</a>
        </p>
        <ul class="todo-ul">
            <c:forEach items="${todoList}" var="todo">
                <li class="todo-li">
                    <strong class="todo-li-title">${todo.title}</strong>
                </li>
            </c:forEach>
        </ul>
    </body>
</html>
