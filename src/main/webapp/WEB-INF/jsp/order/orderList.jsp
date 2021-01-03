<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<jsp:include page="../fragments/head.jsp" />
<body>

<div class="container">
    <jsp:include page="../fragments/bodyHeader.jsp" />

    <div>
        <div>
            <form class="navbar-form navbar-left" role="search">
                <div class="form-group">
                    <input type="text" name="memberName" class="form-class" placeholder="회원명" value="${orderSearch.memberName}">
                </div>
                <div class="form-group">
                    <select class="form-control" name="orderStatus">
                        <option value="">주문상태</option>
                        <option value="ORDER" <c:if test="${orderSearch.orderStatus eq 'ORDER'}">selected</c:if> >주문</option>
                        <option value="CANCEL" <c:if test="${orderSearch.orderStatus eq 'CANCEL'}">selected</c:if> >취소</option>
                    </select>
                </div>
                <button type="submit" class="btn btn-default">검색</button>
                <a href="/order" class="btn btn-primary" role="button">상품 생성</a>
            </form>
        </div>

        <table class="table table-scripted">
            <thead>
            <tr>
                <th>#</th>
                <th>회원명</th>
                <th>대표상품 이름</th>
                <th>대표상품 주문가격</th>
                <th>대표상품 주문수량</th>
                <th>상태</th>
                <th>일시</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${orders}" var="order">
                <tr>
                    <td>${order.id}</td>
                    <td>${order.member.name}</td>
                    <td>${order.orderItems[0].item.name}</td>
                    <td>${order.orderItems[0].orderPrice}</td>
                    <td>${order.orderItems[0].count}</td>
                    <td>${order.status}</td>
                    <td>${order.orderDate}</td>
                    <td>
                        <c:if test="${order.status == 'ORDER'}">
                        <a href="/orders/${order.id}/cancel"
                            class="btn btn-primary" role="button">주문취소</a>
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

    <jsp:include page="../fragments/footer.jsp" />

</div> <!-- container -->

</body>
</html>