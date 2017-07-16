<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="zh-cn">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title>后台管理中心</title>
<link rel="stylesheet" href="${ctx}/css/pintuer.css">
<link rel="stylesheet" href="${ctx}/css/admin.css">
<script src="${ctx}/js/jquery.js"></script>
</head>
<body style="background-color: #f2f9fd;">
	<div class="header bg-main">
		<div class="logo margin-big-left fadein-top">
			<h1>
				<img src="${ctx}/images/y.jpg" class="radius-circle rotate-hover"
					height="50" alt="" />后台管理中心
			</h1>
		</div>
		<div class="head-r">
			&nbsp;&nbsp;<a class="button button-little bg-red" href="login.html"><span
				class="icon-power-off"></span> 退出登录</a>
		</div>
	</div>
	<div class="leftnav">
		<div class="leftnav-title">
			<strong><span class="icon-list"></span>菜单列表</strong>
		</div>
		<div id="userMenu">
		
		</div>
	</div>
	<script type="text/javascript">
		$(function() {
			$(".leftnav h2").click(function() {
				$(this).next().slideToggle(200);
				$(this).toggleClass("on");
			})
			$(".leftnav ul li a").click(function() {
				$("#a_leader_txt").text($(this).text());
				$(".leftnav ul li a").removeClass("on");
				$(this).addClass("on");
			})
		});
	</script>
	<div class="admin">
		<iframe scrolling="auto" rameborder="0" src="${ctx }/info"
			name="right" width="100%" height="100%"></iframe>
	</div>
	<div style="text-align: center;"></div>
</body>


<script type="text/javascript">
	$(function(){
		$.ajax({
			url:"${ctx}/menu/findMenu",
			type:"POST",
			dataType:"json",
			success: function(res){
				var menuStr = '';
				for(i=0;i<res.length;i++){
					var top = res[i];
					menuStr += '<h2>';
					menuStr += '<span class="icon-user"></span>'+top.menuname;
					menuStr += '</h2>';
					menuStr += '<ul style="display: block">';
					for(j=0;j<top.children.length;j++){
						menuStr += '<li><a href="'+top.children[j].menuurl+'" target="right">';
						menuStr += '<span class="icon-caret-right"></span>'+top.children[j].menuname+'</a>';
						menuStr +='</li>';
						
					}
					menuStr += '</ul>';
				}
				$("#userMenu").html(menuStr);
			}
		});
	})


</script>
</html>