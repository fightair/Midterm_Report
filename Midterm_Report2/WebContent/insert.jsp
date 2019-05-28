<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新增</title>
</head>
<style>
form {
	margin: 0 auto;
	width: 600px;
}

</style>
<body>
	<form name="insertMemberFormA" action="insert" method="POST">
		<table border="1">
			<thead>
				<tr>
					<th height="40" colspan="2" align="center">新增行政區</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td width="180" height="40">行政區編號:</td>
					<td width="600" height="40" align="left"><input id='num'
						style="text-align: left" name="town_id" value="${param.town_id}"
						pattern="1[0-9]{2}" type="text" size="20"> <font
						color='blue' size="-1">&nbsp;&nbsp;</font>
						<div style="color: #FF0000; font-size: 60%; display: inline">${ErrorMsg.id}${ErrorMsg.town_id}</div>
					</td>
				</tr>
				<tr>
					<td width="180" height="40">行政區名:</td>
					<td width="600" height="40" align="left"><input
						name="town_name" value="${param.town_name}" type="text" size="20">
						<div style="color: #FF0000; font-size: 60%; display: inline">${ErrorMsg.town_name}</div>
					</td>
				</tr>
				<tr>
					<td width="180" height="40">行政區戶數:</td>
					<td width="600" height="40" align="left"><input name="h_num"
						value="${param.h_num}" type="text" size="20">
						<div style="color: #FF0000; font-size: 60%; display: inline">${ErrorMsg.h_num}</div>
					</td>
				</tr>
				<tr>
					<td width="180" height="40">行政區人口數:</td>
					<td width="600" height="40" align="left"><input name="p_num"
						value="${param.p_num}" type="text" size="20">
						<div style="color: #FF0000; font-size: 60%; display: inline">${ErrorMsg.p_num}</div>
					</td>
				</tr>
				<tr>
					<td width="180" height="40">行政區男人口:</td>
					<td width="600" height="40" align="left"><input name="m_num"
						value="${param.m_num}" type="text" size="20">
						<div style="color: #FF0000; font-size: 60%; display: inline">${ErrorMsg.m_num}</div>
					</td>
				</tr>
				<tr>
					<td width="180" height="40">行政區女人口:</td>
					<td width="600" height="40" align="left"><input name="f_num"
						value="${param.f_num}" type="text" size="20">
						<div style="color: #FF0000; font-size: 60%; display: inline">${ErrorMsg.f_num}</div>
					</td>
				</tr>
				<tr>
					<td width="180" height="40">資料時間:</td>
					<td width="600" height="40" align="left"><input
						name="info_time" value="${param.info_time}" type="text" size="20"
						pattern="20[0-9]{2}"> <font
						color='blue' size="-1">&nbsp;&nbsp;格式為yyyy</font>
						<div style="color: #FF0000; font-size: x-small; display: inline">${ErrorMsg.info_time}</div>
					</td>
				</tr>
				<tr>
					<td height="50" colspan="2" align="center"><input
						type="submit" value="新增" name="新增"></td>
				</tr>
			</tbody>
		</table>
		<div style="color: #FF0000; display: inline">${ErrorMsg.exception}</div>
	</form>
</body>
</html>