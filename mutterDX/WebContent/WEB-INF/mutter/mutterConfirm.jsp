<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.MutterData" %>

<% MutterData data = (MutterData)session.getAttribute("data"); %>
<% String name = data.getName(); %>
<% String passCode = data.getPassCode(); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/mutterStyle.css">
<title>mutterConfirm.jsp</title>
</head>
<body>
<header>
    <jsp:include page="mutterHeader.jsp" />
</header>
<div id="content" align="center">
<table>
<tr>
  <th>
  <i>＊ Confirm ＊</i><br>
  <p class="message">このアカウントで よろしいですか？</p>
    </th>
</tr>
<tr>
  <td>
      <p class="input">Name: 　<%= name %> さん</p>
      <p class="input">Pass:　　<%= passCode %></p>
      <br>
      <p><a href="/mutterDX/MutterServlet?action=admit"><button><i>　ＯＫ　</i></button></a>&emsp;
      <a href="/mutterDX/MutterLoginServlet?action=init"><button><i>やり直し</i></button></a>
      </p>
  </td>
</tr>
</table>
</div>
<footer>
    <jsp:include page="mutterFooter.jsp" />
</footer>
</body>
</html>