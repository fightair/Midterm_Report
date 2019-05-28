<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>成功</title>
</head>
<body>
<h1> ${ PeoBean.town_name } 成功</h1>
行政區名: ${ PeoBean.town_id }<br>
行政區名: ${ PeoBean.town_name }<br>
行政區戶數: ${ PeoBean.h_num }<br>
行政區人口數: ${ PeoBean.p_num }<br>
行政區男人口: ${ PeoBean.m_num }<br>
行政區女人口: ${ PeoBean.f_num }<br>
資料時間: ${ PeoBean.info_time }<br>
<a href="index.jsp">首頁</a>
</body>
</html>