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
	<h1>ようこそ ${user.userName} さん！</h1>

	<div align="center">
		<table border="1">
			<CAPTION>ユーザー情報</CAPTION>
			<tr>
				<th bgcolor="#DDFFDD">ユーザーID</th>
				<td><input type="text" value="${requestScope.user.userId}"
					readonly="readonly" /></td>
			</tr>
			<tr>
				<th bgcolor="#DDFFDD">ユーザー名</th>
				<td><input type="text" value="${requestScope.user.userName}"
					readonly="readonly" /></td>
			</tr>
			<tr>
				<th bgcolor="#DDFFDD">ユーザー名(カナ)</th>
				<td><input type="text"
					value="${requestScope.user.userNameKana}" readonly="readonly" /></td>
			</tr>
			<tr>
				<th bgcolor="#DDFFDD">性別</th>
				<td><input type="text" value="${requestScope.user.userGender}"
					readonly="readonly" /></td>
			</tr>
			<tr>
				<th bgcolor="#DDFFDD">生年月日</th>
				<td><input type="date"
					value="${requestScope.user.userBirthDay}" readonly="readonly" /></td>
			</tr>
			<tr>
				<th bgcolor="#DDFFDD">郵便番号</th>
				<td><input type="text" value="${requestScope.user.userZip}"
					readonly="readonly" /></td>
			</tr>
			<tr>
				<th bgcolor="#DDFFDD">住所</th>
				<td><input type="text" value="${requestScope.user.userAddress}"
					readonly="readonly" /></td>
			</tr>
			<tr>
				<th bgcolor="#DDFFDD">電話番号</th>
				<td><input type="tel"
					value="${requestScope.user.userPhoneNumber}" readonly="readonly" /></td>
			</tr>
			<tr>
				<th bgcolor="#DDFFDD">メールアドレス</th>
				<td><input type="email"
					value="${requestScope.user.userMailAddress}" readonly="readonly" /></td>
			</tr>
		</table>
	</div>
</body>
</html>
