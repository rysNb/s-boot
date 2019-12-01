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
                update Department info:
            </h1>
            <form action="http://localhost:6789/spspm/department/update" method="post">
                <table cellpadding="0" cellspacing="0" border="0"
                       class="form_table">
                    <tr>
                        <td valign="middle" align="right">
                            部门id:
                        </td>
                        <td valign="middle" align="left">
                            ${requestScope.department.id}
                            <input type="hidden" name="id" value="${requestScope.department.id}">
                        </td>
                    </tr>
                    <tr>
                        <td valign="middle" align="right">
                            部门编号:
                        </td>
                        <td valign="middle" align="left">
                            <input type="text" class="inputgri" name="code" value="${requestScope.department.code}"/>
                        </td>
                    </tr>
                    <tr>
                        <td valign="middle" align="right">
                            部门名称:
                        </td>
                        <td valign="middle" align="left">
                            <input type="text" class="inputgri" name="name" value="${requestScope.department.name}"/>
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
