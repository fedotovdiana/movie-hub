<#include 'header.ftlh'>
<#include 'libraries.ftlh'>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/style.css" type="text/css">

    <title>Sign up</title>
</head>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
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
            <form class="form-horizontal form" action="/signUp" method="post" enctype="multipart/form-data">
                <span class="heading">Sign up</span>
                <form>
                    <#--                    <input hidden="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">-->
                    <div class="form-group row">
                        <label for="staticName" class="col-sm-2 col-form-label">Name</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="staticName" name="name"
                                   placeholder="Enter name">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="staticEmail" class="col-sm-2 col-form-label">Login</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="staticEmail" name="login"
                                   placeholder="email@example.com">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="inputPassword" class="col-sm-2 col-form-label">Password</label>
                        <div class="col-sm-10">
                            <input type="password" class="form-control" id="inputPassword" name="password"
                                   placeholder="Password">
                        </div>
                    </div>
                    <div class="form-group row">
                        <input type="file" id="file" name="file" placeholder="Name..."/>
                        <input type="button" onclick="sendFile()" class="btn btn-primary mb-2" value="Ok"/>
                    </div>
                    <input type="hidden" id="photo" name="photo" value=" ">
                    <#--                    <div class="form-group row">-->
                    <#--                        <label for="FormControlFile" class="col-sm-2 col-form-label">Photo</label>-->
                    <#--                        <div class="col-sm-10">-->
                    <#--                            <input type="file" readonly class="form-control-file" name="photo" id="FormControlFile">-->
                    <#--                        </div>-->
                    <#--                    </div>-->
                    <#--                    <button type="submit" class="btn btn-primary mb-2">Sign up</button>-->
                    <input type="submit" class="btn btn-primary mb-2" value="Sign up">
                </form>
            </form>
        </div>
    </div>
</div>
<#--<@lib/>-->
</body>
</html>