<#include 'header.ftlh'>
<#include 'libraries.ftlh'>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="css/bootstrap.min.css">/
    <link rel="stylesheet" href="css/style.css" type="text/css">
    <title>Sign in</title>
</head>
<body class="photo">
<@header/>
<div class="container">
    <div class="row">
        <div class="col-md-3"></div>
        <div class="col-md-offset-5 col-md-6">
            <form class="form-horizontal form" action="/signIn" method="post">
                <span class="heading">Sign in</span>
                <div class="form-group help">
                    <input type="login" class="form-control" name="login" id="inputLogin" required pattern="^([a-z0-9_-]+\.)*[a-z0-9_-]+@[a-z0-9_-]+(\.[a-z0-9_-]+)*\.[a-z]{2,6}$" placeholder="Login">
                    <i class="fa fa-user"></i>
                </div>
                <div class="form-group help">
                    <input type="password" class="form-control" name="password" id="inputPassword" placeholder="Password">
                    <i class="fa fa-lock"></i>
                    <a href="#" class="fa fa-question-circle"></a>
                </div>
                <div class="form-group">
                    <div class="main-checkbox">
                        <input type="checkbox" value="none" id="checkbox1" name="check"/>
                        <label for="checkbox1"></label>
                    </div>
                    <span class="text">Remember me</span>
                    <input type="submit" class="btn btn-b btn-default" value="Sign in">
                </div>
                <span class="heading"></span>
                <span>Don't have an account?  <a href="/signUp" class="reg">  Sign up</a></span>
            </form>
        </div>
    </div>
</div>
<@lib/>
</body>
</html>

<#--required pattern="^([a-z0-9_-]+\.)*[a-z0-9_-]+@[a-z0-9_-]+(\.[a-z0-9_-]+)*\.[a-z]{2,6}$"-->