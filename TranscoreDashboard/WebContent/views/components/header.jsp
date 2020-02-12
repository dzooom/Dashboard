<%@page import="com.transcore.entity.User" %>


<div class="header" style="padding-top: 30px">
	<div style="float: right;">
	Welcome
			<%
				User user = (User)session.getAttribute("user");
				out.println(user.getUserName());
			%>!
			&nbsp; | &nbsp;
			
			<a href="${pageContext.request.contextPath}/logout?action=logout" >Logout</a>
	
		
	</div>
</div>