<#include 'header.ftlh'>
<#include 'libraries.ftlh'>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/style.css" type="text/css">

    <title>Actors</title>
</head>
<body class="photo">
<@header/>
<section class="jumbotron text-center">
    <div class="container">
        <h2 class="jumbotron-heading">Actors</h2>
    </div>
</section>
<div class="container">
    <div class="row">
        <#list actors as a>
            <div class="col-md-3">
                <div class="card mb-2">
                    <a href="/star?actor_id=${a.id}"><img src="/img/${a.photo}" class="img-thumbnail" alt="..."></a>
                    <div class="card-body">
                        <ul class="list-unstyled text-center mb-2">
                            <li><a href="/star?actor_id=${a.id}" class="reg">${a.name}</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </#list>
    </div>
</div>
<@lib/>
</body>
</html>