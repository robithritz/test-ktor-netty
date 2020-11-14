<#-- @ftlvariable name="data" type="com.example.IndexData" -->
<html>
	<body>
	    <h1>Welcome, ${name}</h1>
		<ul>
		<#list data as item>
			<li>${item}</li>
		</#list>
		</ul>
	</body>
</html>
