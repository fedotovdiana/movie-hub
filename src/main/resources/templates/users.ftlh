<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <script type="application/javascript" src="webjars/jquery/3.4.1/jquery.min.js"></script>
    <title>Document</title>
</head>
<body>
<div>
    <table>
        <tr>
            <th>Имя</th>
            <th>email</th>
        </tr>
        <#list users as user>
            <tr>
                <td>${user.name}</td>
                <td>${user.login}</td>
                <td><a href="/users/${user.id}">Посмотреть</a></td>
            </tr>
        </#list>
    </table>
    <!-- AJAX-->
    <p><input id="query" oninput="f()"/></p>
    <div id="result"></div>

    <script type="application/javascript">
        function f() {
            if ($("#query").val().length >= 1) {
                $.ajax({
                    url: "/users/search",
                    data: {"name": $("#query").val()},
                    dataType: "json",
                    success: function (data) {
                        if (data.length > 0) {
                            $("#result").html("");
                            $("#result").append("<table>\n" +
                                "        <tr>\n" +
                                "            <th>Имя</th>\n" +
                                "            <th>email</th>\n" +
                                "        </tr>");
                            $.each(data, function (key, value) {
                                $("#result").append(" <tr>\n" +
                                    " <td>" + value['name'] + "</td>\n" +
                                    " <td>" + value['login'] + "</td>\n" +
                                    "</tr>");
                            });
                            $("#result").append("<table>");
                        } else {
                            $("#result").html("Users not found");
                        }
                    }
                })
            } else {
                $("#result").html("");
            }
        }
    </script>
    <!-- AJAX-->
</div>
</body>

