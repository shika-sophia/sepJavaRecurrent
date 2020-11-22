<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>

<% List<String> msgList = (List<String>) request.getAttribute("msgList"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/mutterStyle.css">
<title>mutterLogin.jsp</title>
</head>
<body>
<div id="upper">
<hr color="white" size="5">
<h1><i>・*＊ Mutter WebApplication ＊*・</i></h1>
<hr color="white" size="5">
</div>
<div id="content" align="center">
<table>
<tr>
  <th>
  <i>＊ Login ＊</i><br>
  <% if(msgList.isEmpty()){ %>
      <p class="message">ログインしてください</p>
  <% } else { %>
      <p class="errMsg">
      <% for(String msg : msgList){ %>
        <%= msg %><br>
      <% }//for msgList%>
      </p>
  <% }//if-else %>
  </th>
</tr>
<tr>
  <td>
    <form action="/sepJavaRecurrent/MutterLoginServlet" method="post">
      <p class="input">Name: <input type="text" name="name" size="10" required="required"></p>
      <p class="input">Pass:　<input type="password" name="pass" size="10" required="required"></p>
      <br>
      <p align="right"><button type="submit">Login</button>　　</p>
    </form>
</table>
</div>
</body>
</html>