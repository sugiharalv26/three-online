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
	<h1>ユーザー新規登録</h1>
	<div>
		<font color="#FF0000">${requestScope.errorMsg}</font>
	</div>
	<div align="center">
		<form action="userRegist" method="post">
			<table border="1">
				<tr>
					<th bgcolor="#DDDDFF">項目名</th>
					<th bgcolor="#DDDDFF">入力形式</th>
					<th bgcolor="#DDDDFF">入力フィールド</th>
				</tr>
				<tr>
					<th bgcolor="#DDFFDD">ユーザーID(必須 半角英数字)</th>
					<th bgcolor="#DDFFDD">必須 半角英数字</th>
					<td><input type="text" name="userId" placeholder="THREEIN"
						required="required" /></td>
				</tr>
				<tr>
					<th bgcolor="#DDFFDD">パスワード</th>
					<th bgcolor="#DDFFDD">必須 半角英数字(4～8桁)</th>
					<td><input type="password" name="password" max="8" min="4"
						required="required" /></td>
				</tr>
				<tr>
					<th bgcolor="#DDFFDD">パスワード(確認用)</th>
					<th bgcolor="#DDFFDD">必須 半角英数字(4～8桁)</th>
					<td><input type="password" name="confirmPassword" max="8"
						min="4" required="required" /></td>
				</tr>
				<tr>
					<th bgcolor="#DDFFDD">ユーザー名</th>
					<th bgcolor="#DDFFDD">必須</th>
					<td><input type="text" name="userName" required="required"
						placeholder="三院太郎" /></td>
				</tr>
				<tr>
					<th bgcolor="#DDFFDD">ユーザー名(カナ)</th>
					<th bgcolor="#DDFFDD">必須 カナ入力</th>
					<td><input type="text" name="userNameKana" required="required"
						placeholder="スリーインタロウ" /></td>
				</tr>
				<tr>
					<th bgcolor="#DDFFDD">性別</th>
					<th bgcolor="#DDFFDD">必須</th>
					<td><input type="radio" name="gender" value="男"
						checked="checked" />男<br /> <input type="radio" name="gender"
						value="女" />女</td>
				</tr>
				<tr>
					<th bgcolor="#DDFFDD">生年月日</th>
					<th bgcolor="#DDFFDD">必須 日付形式</th>
					<td><input type="date" name="birthDay" required="required" /></td>
				</tr>
				<tr>
                    <th bgcolor="#DDFFDD">郵便番号</th>
                    <th bgcolor="#DDFFDD">必須 ハイフン込み</th>
                    <td><input type="text" name="zip" required="required"
                        placeholder="000-0000" /></td>
                </tr>
                <tr>
                    <th bgcolor="#DDFFDD">住所</th>
                    <th bgcolor="#DDFFDD">必須</th>
                    <td><input type="text" name="address" required="required"
                        placeholder="東京都江東区1-1-1" /></td>
                </tr>
                <tr>
                    <th bgcolor="#DDFFDD">電話番号</th>
                    <th bgcolor="#DDFFDD">ハイフン込み</th>
                    <td><input type="tel" name="phone"
                        placeholder="000-0000-0000" /></td>
                </tr>
                <tr>
                    <th bgcolor="#DDFFDD">メールアドレス</th>
                    <th bgcolor="#DDFFDD">アドレス形式</th>
                    <td><input type="email" name="mailAddress"
                        placeholder="three@three-in.com" /></td>
                </tr>
				<tr>
					<td colspan="3" align="center"><input type="submit" value="登録" /></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
