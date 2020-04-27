<#include 'header.ftlh'>
<#include 'libraries.ftlh'>
<#import "spring.ftl" as spring />

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">


    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css" type="text/css">

    <title><@spring.message 'chat.page'/></title>
    <script
            src="https://code.jquery.com/jquery-3.4.1.js"
            integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
            crossorigin="anonymous"></script>
    <script>
        var webSocket;

        function connect() {
            webSocket = new WebSocket('ws://localhost/mychat');
            document.cookie = 'X-Authorization=' + '123456' + ';path=/';
            webSocket.onmessage = function receiveMessage(response) {
                let data = response['data'];
                let json = JSON.parse(data);
                $('#messagesList').first().after("<li>" + json['from'] + ' ' + json['text'] + "</li>")
            }
        }

        function sendMessage(text, pageId) {
            let message = {
                "text": text,
                "from": pageId
            };
            webSocket.send(JSON.stringify(message));
            $('#message').val("");
        }
    </script>
</head>
<body class="photo" onload="connect()">
<@header/>
<div class="container">
    <div class="row">
        <form class="form-horizontal profile">
            <h2 class="heading"><@spring.message 'chat.page'/></h2>
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-12">
                        <input name="message" id="message" placeholder="<@spring.message 'chat.enter'/>">
                        <button onclick="sendMessage($('#message').val(), '${user.name}')"><@spring.message 'chat.send'/></button>
                        <h4><@spring.message 'chat.messages'/></h4>
                        <ul id="messagesList"></ul>
                    </div>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>
