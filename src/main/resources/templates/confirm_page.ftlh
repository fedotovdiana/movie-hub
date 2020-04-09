<#import "spring.ftl" as spring />
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title><@spring.message 'confirm.page.confirm'/></title>
</head>
<body>
<#if isConfirmed == true>
    <h1><@spring.message 'confirm.page.confirmed'/></h1>
    <h3><a href="/signIn" class="reg"> <@spring.message 'signIn.page.signIn'/></a></h3>
<#else>
    <h1><@spring.message 'confirm.page.error'/></h1>
</#if>
</body>
</html>