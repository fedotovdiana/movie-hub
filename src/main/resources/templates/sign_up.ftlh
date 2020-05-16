<#include 'header.ftlh'>
<#include 'libraries.ftlh'>
<#import "spring.ftl" as spring />

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/style.css" type="text/css">

    <title><@spring.message 'signUp.page.signUp'/></title>
</head>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<style>
    .error {
        color: #ff0000;
    }
</style>

<body class="photo">
<@header/>
<div class="container">
    <script>
        function sendFile() {
            // данные для отправки
            let formData = new FormData();
            // забрал файл из input
            let files = ($('#file'))[0]['files'];
            // добавляю файл в formData
            [].forEach.call(files, function (file, i, files) {
                formData.append("file", file);
            });

            $.ajax({
                type: "POST",
                url: "/files",
                data: formData,
                processData: false,
                contentType: false
            })
                .done(function (response) {
                    let fileUrl = 'http://localhost/files/' + response;
                    $('#photo').attr('value', '' + fileUrl);
                })
                .fail(function () {
                    alert('Error')
                });
        }
    </script>
    <div class="row">
        <div class="col-md-3"></div>
        <div class="col-md-offset-5 col-md-6">
            <@spring.bind "form"/>
            <form class="form-horizontal form" action="/signUp" method="post">
                <span class="heading"><@spring.message 'signUp.page.signUp'/></span>
                <#--                <form>-->
                <input hidden="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                <div class="form-group row">
                    <label for="staticName"
                           class="col-sm-2 col-form-label"><@spring.message 'signUp.page.name'/></label>
                    <div class="col-sm-10">
                        <#--                            <input type="text" class="form-control" id="staticName" name="name"-->
                        <#--                                   placeholder="<@spring.message 'signUp.page.name'/>">-->
                        <@spring.formInput "form.name"/>
                        <br>
                        <@spring.showErrors "<br>", "error"/>
                    </div>
                </div>
                <div class="form-group row">
                    <label for="staticEmail"
                           class="col-sm-2 col-form-label"><@spring.message 'signUp.page.login'/></label>
                    <div class="col-sm-10">
                        <#--                            <input type="text" class="form-control" id="staticEmail" name="login"-->
                        <#--                                   placeholder="<@spring.message 'signUp.page.login'/>">-->
                        <@spring.formInput "form.login"/>
                        <br>
                        <@spring.showErrors "<br>", "error"/>
                    </div>
                </div>
                <div class="form-group row">
                    <label for="inputPassword"
                           class="col-sm-2 col-form-label"><@spring.message 'signUp.page.password'/></label>
                    <div class="col-sm-10">
                        <@spring.formInput "form.password"/>
                        <#--                            <input type="password" class="form-control" id="inputPassword" name="password"-->
                        <#--                                   placeholder="<@spring.message 'signUp.page.password'/>">-->
                    </div>
                </div>
                <div class="form-group row">
                    <input type="file" id="file" name="file" placeholder="<@spring.message 'signUp.page.name'/>"/>
                    <input type="button" onclick="sendFile()" class="btn btn-primary mb-2"
                           value="<@spring.message 'signUp.page.ok'/>"/>
                </div>
                <input type="hidden" id="photo" name="photo" value=" ">

                <input type="submit" class="btn btn-primary mb-2" value="<@spring.message 'signUp.page.signUp'/>">
                <#--                </form>-->
                <#list spring.status.errorMessages as error>
                    <span class="has-error">${error} </span>
                </#list>
            </form>
        </div>
    </div>
</div>
<#--<@lib/>-->
</body>
</html>