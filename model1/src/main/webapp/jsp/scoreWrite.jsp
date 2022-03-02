<%@page import="testjava.ScoreDAO"%>
<%@page import="testjava.Scorebean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	
	String hak = request.getParameter("hak");
	String stuname = request.getParameter("stuname");
	int kor = Integer.parseInt(request.getParameter("kor"));
	int eng = Integer.parseInt(request.getParameter("eng"));
	int math = Integer.parseInt(request.getParameter("math"));
	int sumscore = kor + eng + math;
	int avgscore = sumscore/3;
	
	Scorebean bean = new Scorebean();
	bean.setHak(hak);
	bean.setStuname(stuname);
	bean.setKor(kor);
	bean.setEng(eng);
	bean.setMath(math);
	bean.setSumscore(sumscore);
	bean.setAvgscore(avgscore);
	
	ScoreDAO dao = new ScoreDAO();
	int result = dao.ScoreWrite(bean);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../script/scoreScript.js"></script>
<script type="text/javascript">
	window.onload = function() {
		if(<%=result > 0%>) {
			alert("성적 저장 성공");
			location.href = "scoreList.jsp?pg=1";
		} else {
			alert("성적 저장 실패");
			location.href = "scoreWriteForm.jsp";
		}
		
	}
</script>
</head>
<body>
</body>
</html>