<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>刪除</title>
</head>
<body>
	<form name="deleteForm" action="delete" method="POST">
		<table border="1">
			<thead>
				<tr>
					<th height="40" colspan="2" align="center">刪除行政區</th>
				</tr>
				<tr>
					<td width="180" height="40">行政區編號:</td>
					<td width="600" height="40" align="left"><input id='num'
						style="text-align: left" name="town_id" value="${param.town_id}"
						type="text" size="20">
						<div style="color: #FF0000; font-size: 60%; display: inline">${ErrorMsg.id}${ErrorMsg.town_id}</div>
					</td>
				</tr>
				<tr>
					<td height="50" colspan="2" align="center"><input
						type="submit" value="刪除" name="刪除"></td>
				</tr>
			</tbody>
		</table>
		<div style="color: #FF0000; display: inline">${ErrorMsg.exception}</div>
		
</body>
</html>