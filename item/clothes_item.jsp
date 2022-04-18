<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/itemList.css">
<script type="text/javascript" src="../script/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
		function layout(clothes) {
			clothes.forEach(cloth => {
				let template ='
				<div id="item">
					<img alt=22${item_name} src=33${item_image1}>
					<label>11${item_details}</label>
				</div>
				'
				$('#clothes').append(template);
			});
		};
</script>
</head>
<body>
	<main>
		<div class="container3"></div>
	</main>
</body>
</html>