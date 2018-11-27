<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Title</title>
</head>
<#include "/base.ftl">
<body>
left

<ul>
	<li><a href="#" >系统管理</a>

		<ul>
			<li><a href="${basePath}/system/user/userPage" target="iframeContent">用户管理</a></li>
            <li><a href="${basePath}/system/role/rolePage" target="iframeContent">角色管理</a></li>
            <li><a href="${basePath}/system/perm/permPage" target="iframeContent">权限管理</a></li>


		</ul>

	</li>
</ul>




</body>

</html>