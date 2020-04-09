<#include 'header.ftlh'>
<#include 'libraries.ftlh'>
<#import "spring.ftl" as spring />

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/style.css" type="text/css">

    <title><@spring.message 'signIn.page.signIn'/></title>
</head>
<body class="photo">
<@header/>
<div class="container">
    <div class="row">
        <div class="col-md-3"></div>
        <div class="col-md-offset-5 col-md-6">
            <form class="form-horizontal form" action="/signIn" method="post">
                <#--                <input hidden="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">-->
                <span class="heading"><@spring.message 'signIn.page.signIn'/></span>
                <#if error??><h5><@spring.message 'signIn.page.error'/></h5></#if>
                <div class="form-group help">
                    <input type="login" class="form-control" name="login" id="inputLogin" required
                           pattern="^([a-z0-9_-]+\.)*[a-z0-9_-]+@[a-z0-9_-]+(\.[a-z0-9_-]+)*\.[a-z]{2,6}$"
                           placeholder="<@spring.message 'signUp.page.login'/>">
                    <i class="fa fa-user"></i>
                </div>
                <div class="form-group help">
                    <input type="password" class="form-control" name="password" id="inputPassword"
                           placeholder="<@spring.message 'signUp.page.password'/>">
                    <i class="fa fa-lock"></i>
                    <a href="#" class="fa fa-question-circle"></a>
                </div>
                <div class="form-group">
                    <div class="main-checkbox">
                        <input type="checkbox" id="checkbox1" name="remember-me" checked/>
                        <label for="checkbox1"></label>
                    </div>
                    <span class="text"><@spring.message 'signIn.page.rememberMe'/></span>
                    <input type="submit" class="btn btn-b btn-default" value="<@spring.message 'signIn.page.signIn'/>">
                </div>
                <span class="heading"></span>
                <span><@spring.message 'signIn.page.dont.have.account'/><a href="/signUp"
                                                                           class="reg"> <@spring.message 'signUp.page.signUp'/></a></span>
            </form>
        </div>
    </div>
</div>
<@lib/>
</body>
</html>

<#--required pattern="^([a-z0-9_-]+\.)*[a-z0-9_-]+@[a-z0-9_-]+(\.[a-z0-9_-]+)*\.[a-z]{2,6}$"-->