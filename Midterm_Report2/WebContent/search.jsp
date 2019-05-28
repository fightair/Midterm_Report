<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>查詢</title>
</head>
<body>
	<form name="searchForm" action="search" method="POST">
		<table border="1">
			<thead>
				<tr>
					<th height="40" colspan="2" align="center">查詢行政區</th>
				</tr>
				<tr>
					<td width="180" height="40">行政區編號:</td>
					<td width="600" height="40" align="left"><input id='num'
						pattern="1[0-9]{2}" style="text-align: left" name="town_id" value="${param.town_id}"
						type="text" size="20"> 
						<div style="color: #FF0000; font-size: 60%; display: inline">${ErrorMsg.town_id} ${ErrorMsg.id}</div>
					</td>
				</tr>
				<tr>
					<td height="50" colspan="2" align="center"><input
						type="submit" value="查詢" name="查詢"></td>
				</tr>
			</tbody>
		</table>
		<div style="color: #FF0000; display: inline">${ErrorMsg.exception}</div>
	</form>
</body>
</html>