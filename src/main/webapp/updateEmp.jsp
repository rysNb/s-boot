<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page pageEncoding="utf-8" isELIgnored="false" contentType="text/html; utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>update Emp</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/css/style.css"/>
</head>

<body>
<div id="wrap">
    <div id="top_content">
        <div id="header">
            <div id="rightheader">
                <p>
                    2009/11/20
                    <br/>
                </p>
            </div>
            <div id="topheader">
                <h1 id="title">
                    <a href="#">Main</a>
                </h1>
            </div>
            <div id="navigation">
            </div>
        </div>
        <div id="content">
            <p id="whereami">
            </p>
            <h1>
                update Emp info:
            </h1>
            <form action="http://localhost:6789/spspm/emp/update" method="post" ENCTYPE="multipart/form-data">
                <table cellpadding="0" cellspacing="0" border="0"
                       class="form_table">
                    <tr>
                        <td valign="middle" align="right">
                            id:
                        </td>
                        <td valign="middle" align="left">
                            ${requestScope.employee.id}
                            <input type="hidden" name="id" value="${requestScope.employee.id}">
                        </td>
                    </tr>
                    <tr>
                        <td valign="middle" align="right">
                            头像:
                        </td>
                        <td valign="middle" align="left">
                            <input type="hidden" value="${requestScope.employee.src}" name="src">
                            <img width="40px" height="40px"
                                 src="http://localhost:6666/spspm/upload/${requestScope.employee.src}" alt=""/>
                            <input type="file" name="aa"/>
                        </td>
                    </tr>
                    <tr>
                        <td valign="middle" align="right">
                            用户名:
                        </td>
                        <td valign="middle" align="left">
                            <input type="text" class="inputgri" name="name" value="${requestScope.employee.name}"/>
                        </td>
                    </tr>
                    <tr>
                        <td valign="middle" align="right">
                            工资:
                        </td>
                        <td valign="middle" align="left">
                            <input type="text" class="inputgri" name="salary" value="${requestScope.employee.salary}"/>
                        </td>
                    </tr>
                    <tr>
                        <td valign="middle" align="right">
                            年龄:
                        </td>
                        <td valign="middle" align="left">
                            <input type="text" class="inputgri" name="age" value="${requestScope.employee.age}"/>
                        </td>
                    </tr>
                    <tr>
                        <td valign="middle" align="right">
                            部门:
                        </td>
                        <td valign="middle" align="left">
                            <select name="department">
                                <c:forEach items="${sessionScope.departments}" var="dep">
                                    <c:if test="${requestScope.employee.department==dep.name}">
                                        <option selected="selected"
                                                value="${dep.name}">${requestScope.employee.department}</option>
                                    </c:if>
                                    <c:if test="${requestScope.employee.department!=dep.name}">
                                        <option value="${dep.name}">${dep.name}</option>
                                    </c:if>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                </table>
                <p>
                    <input type="submit" class="button" value="修改"/>
                </p>
            </form>
        </div>
    </div>
    <div id="footer">
        <div id="footer_bg">
            ABC@126.com
        </div>
    </div>
</div>
</body>
</html>
