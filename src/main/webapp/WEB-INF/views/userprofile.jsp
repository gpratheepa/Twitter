<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>User Profile</title>
</head>
<body>
	<h1>User Profile</h1>

	<table>

		<tr>
			<td>Screen Name</td>
			<td>
					${userDetail.screen_name}
			<td>
		<tr>
		<tr>
			<td>
				Profile Image Url
			</td>
			<td>
				${userDetail.profile_image_url}
			</td>
		</tr>
		<tr>
			<td>
				User URL
			</td>
			<td>
				${userDetail.url}
			</td>
		</tr>
		<tr>
			<td>
				User Description
			</td>
			<td>
				${userDetail.description}
			</td>
		</tr>
	</table>
	
	<h1>User Tweets</h1>
	<table>
		<tr>
			<td>User</td>
			<td>Text</td>
			<td>Hashtags</td>
			<td>Location</td>
		<tr>
			<c:forEach items="${userTweets}" var="tweet">
				<tr>
					<td><c:choose>
							<c:when test="${empty fn:trim(tweet.user.url)}">
        						<img src="${tweet.user.profile_image_url}"/>${tweet.user.screen_name}
   							 </c:when>
							<c:otherwise>
								<a href="https://twitter.com/${tweet.user.screen_name}"><img src="${tweet.user.profile_image_url}"/>${tweet.user.screen_name}</a>
							</c:otherwise>
						</c:choose></td>
					<td>${tweet.text}</td>
					<td>
						<c:if test="${fn:length(tweet.entities.hashtags) gt 0}" >
							<c:forEach items="${tweet.entities.hashtags}" var="hashtag">
								${hashtag.text}
							</c:forEach>
						</c:if>
					</td>
					<td>
						${tweet.user.location}
					</td>
				<tr>	
			</c:forEach>
	</table>
</body>
</html>