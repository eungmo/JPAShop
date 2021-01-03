<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<jsp:include page="../fragments/head.jsp" />
<body>

<div class="container">
    <jsp:include page="../fragments/bodyHeader.jsp" />

    <div>
        <!-- <a href="/items/new" class="btn btn-primary" role="button">상품 생성</a> -->
        <table class="table table-scripted">
            <thead>
            <tr>
                <th>#</th>
                <th>이름</th>
                <th>도시</th>
                <th>주소</th>
                <th>우편번호</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${members}" var="member">
                <tr>
                    <td>${member.id}</td>
                    <td>${member.name}</td>
                    <td>${member.address.city}</td>
                    <td>${member.address.street}</td>
                    <td>${member.address.zipcode}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

    <jsp:include page="../fragments/footer.jsp" />

</div> <!-- container -->

</body>
</html>