<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Login Success</title>
</head>
<body>
<section>
<h3>Hi <%= request.getAttribute("user") %>, Login Success</h3>
<a href="/MyFirstWeb/login.html">Login page</a>
</section>
</body>
</html>