<#include 'header.ftlh'>
<#include 'libraries.ftlh'>
<#import "spring.ftl" as spring />

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <link rel="stylesheet" href="../css/style.css" type="text/css">

    <title><@spring.message 'star.page.star'/></title>
</head>
<body class="photo">
<@header/>
<div class="container film">
    <div class="row">
        <div class="col-12">
            <h2 class="name">${star.name}</h2>
        </div>
    </div>
    <div class="row">
        <div class="col-3">
            <img src="/img/${star.photo}" alt="..." class="img-thumbnail ">
        </div>

        <div class="col-9">
            <table class="table">
                <tbody>
                <tr>
                    <th scope="row"><@spring.message 'star.page.birthday'/></th>
                    <td>${star.birthday}</td>
                </tr>
                <tr>
                    <th scope="row"><@spring.message 'star.page.country'/></th>
                    <td>${star.country}</td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
<#--    <div class="row">-->
<#--        <h2 class="text-center">Films</h2>-->
<#--    </div>-->
<#--    <div class="row">-->
<#--        <div class="col-md-3">-->
<#--            <div class="card mb-2">-->
<#--                <a href="#"><img src="../../front/img/f1.jpg" class="img-thumbnail" alt="..."></a>-->
<#--            </div>-->
<#--        </div>-->
<#--    </div>-->
</div>
<@lib/>
</body>
</html>