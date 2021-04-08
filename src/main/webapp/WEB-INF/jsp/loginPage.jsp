<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"
    %>
<head>
<title>Spring Boot Security Hello</title>
</head>
<body>
  <h2>Spring Boot Security Hello</h2>
  <h3><%out.println(request.getParameter("message") != null ? request.getParameter("message") : "");%></h3>
  <form name='login-form' action="/perform_login" method='POST'>
    <table>
      <tr>
        <td>Username:</td>
        <td><input type='text' name='username' value=''></td>
      </tr>
      <tr>
        <td>Password:</td>
        <td><input type='password' name='password' /></td>
      </tr>
      <tr>
        <td><input name="submit" type="submit" value="submit" /></td>
      </tr>
    </table>
  </form>
</body>
</html>