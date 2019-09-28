<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<!DOCTYPE>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>THREE-IN('ω')ONLINE</title>

</head>
<body>
	<div align="center">
		<h1>ログインページ</h1>
		<form action="userLogin" method="post">
			<table style="border: none;">
				<tr>
					<th>ユーザーID</th>
					<td><input type="text" name="userId" required="required"/></td>
				</tr>
				<tr>
					<th>パスワード</th>
					<td><input type="password" name="password" required="required"/></td>
				</tr>
				<tr>
					<td colspan="2"><font color="#FF0000">${requestScope.errorMsg}</font></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="ログイン" /></td>
				</tr>
			</table>
		</form>
	</div>
	<div align="center">
		新規登録は<a href="userRegist.jsp">コチラ</a>
	</div>
</body>
</html>
