<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<title>Twitter Search</title>
</head>
<body>
	<h1>Twitter Search</h1>
	<table>
		<tr>
			<td>
				<form action="http://localhost:8080/tweets/" method="POST">
				<input type="text" name="searchText" id="searchText" />
				<input type="submit" name="search" value="Search" >
				</form>
			</td>
		</tr>
	</table>
	<table>
		<tr>
			<td>User</td>
			<td>Text</td>
			<td>Hashtags</td>
			<td>Location</td>
		<tr>
			<c:forEach items="${tweets}" var="tweet">
				<tr>
					<td>
					<a href="/tweets/userprofile?screenName=${tweet.user.screen_name}"><img src="${tweet.user.profile_image_url}"/>${tweet.user.screen_name}</a>
					</td>
<%-- 					<td><c:choose> --%>
<%-- 							<c:when test="${empty fn:trim(tweet.user.url)}"> --%>
<%--         						<a href="/tweets/userprofile?screenName=${tweet.user.screen_name}"></a><img src="${tweet.user.profile_image_url}"/>${tweet.user.screen_name} --%>
<%--    							 </c:when> --%>
<%-- 							<c:otherwise> --%>
<%-- 								<a href="https://twitter.com/${tweet.user.screen_name}"><img src="${tweet.user.profile_image_url}"/>${tweet.user.screen_name}</a> --%>
<%-- 							</c:otherwise> --%>
<%-- 						</c:choose></td> --%>
					<td>${tweet.text}</td>
					<td>
						<c:if test="${fn:length(tweet.entities.hashtags) gt 0}" >
							<c:forEach items="${tweet.entities.hashtags}" var="hashtag">
								<a href="/tweets/hashtag?q=${hashtag.text}">${hashtag.text}</a>
							</c:forEach>
						</c:if>
					</td>
					<td>
						<a href="/tweets/location?q=${tweet.user.location}">${tweet.user.location}</a>
					</td>
				<tr>	
			</c:forEach>
	</table>
</body>
</html>
