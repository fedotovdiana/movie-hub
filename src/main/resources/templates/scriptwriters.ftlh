<#include 'header.ftlh'>
<#include 'libraries.ftlh'>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/style.css" type="text/css">

    <title>Scripwriters</title>
</head>
<body class="photo">
<@header/>
<section class="jumbotron text-center">
    <div class="container">
        <h2 class="jumbotron-heading">Scripwriters</h2>
    </div>
</section>
<div class="container">
    <div class="row">
        <#list scriptwriters as s>
            <div class="col-md-3">
                <div class="card mb-2">
                    <a href="/star?scr_id=${s.id}"><img src="/img/${s.photo}" class="img-thumbnail" alt="..."></a>
                    <div class="card-body">
                        <ul class="list-unstyled text-center mb-2">
                            <li><a href="/star?scr_id=${s.id}" class="reg">${s.name}</a></li>
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