<html>
        <head>
        <link href="/webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
        <title>Login Page</title>
        </head>

        <body>
            <h2>Welcome to the login page!<h2>
            <div>
                <pre>${errorMessage}</pre>
                <form method="post">
                    Name: <input type="text" name="name">
                    Password: <input type="text" name="password">
                    <input type="submit" class="btn btn-success">
                </form>
            </div>
            <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
            <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
        </body>
</html>