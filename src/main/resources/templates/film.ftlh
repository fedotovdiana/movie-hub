<#include 'header.ftlh'>
<#import "spring.ftl" as spring />

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css" type="text/css">

    <script type="application/javascript" src="/webjars/jquery/3.4.1/jquery.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            $('#btn_add_to').click(function () {
                $.ajax({
                    type: "post",
                    url: "/checklists/add-to",
                    data: {
                        "name": $('#selector').val(),
                        "film_id": "${film.id}"
                    },
                    success: function () {
                        <#if user?has_content>
                        $('#selector').append("<#list checklists as c><option id=${c.name}>${c.name}</option></#list><option>" + $('#selector').val() + "</option>");
                        $('#btn_add_to').attr("disabled", 'disabled');
                        </#if>
                    }
                });
            });
            $('#btn_add_to_new').click(function () {
                $.ajax({
                    type: "post",
                    url: "/checklists/add-to-new",
                    data: {
                        "name": $('#text_new_ch').val(),
                        "film_id": "${film.id}"
                    },
                    success: function () {
                        $('#text_new_ch').val("");
                        $('#btn_add_to_new').attr("disabled", 'disabled');
                    }
                });
            });
            $('#btn_like').click(function () {
                $.ajax({
                    type: "post",
                    url: "/films/like",
                    data: {
                        "film_id": "${film.id}"
                    },
                    success: function () {
                        $('#btn_like').val((parseInt($('#btn_like').val()) + 1) + " <@spring.message 'likes'/>");
                        $('#btn_like').attr("disabled", 'disabled');
                    }
                });
            });
            $('#btn_dislike').click(function () {
                $.ajax({
                    type: "post",
                    url: "/films/dislike",
                    data: {
                        "film_id": "${film.id}"
                    },
                    success: function () {
                        alert("Click");
                        $('#btn_dislike').val((parseInt($('#btn_dislike').val()) + 1) + " <@spring.message 'dislikes'/>");
                        $('#btn_dislike').attr("disabled", 'disabled');
                    }
                });
            });
        });
    </script>
    <title>${film.name}</title>
</head>
<body class="photo">
<@header/>
<div class="container film">
    <div class="row">
        <div class="col-12">
            <h2 class="name">${film.name}</h2>
        </div>
    </div>
    <div class="row">
        <div class="col-3">
            <img src="/img/${film.photo}" alt="..." class="img-thumbnail ">
            <#if user?has_content>
                <div class="input-group">
                    <#if checklists?has_content>
                        <div>
                            <select class="custom-select" id="selector">
                                <option selected><@spring.message 'film.page.choose'/>
                                </option>
                                <#list checklists as c>
                                    <option id=${c.name}>${c.name}</option>
                                </#list>
                            </select>
                        </div>
                        <div>
                            <input type="button" class="btn btn-primary btn-pri" id="btn_add_to"
                                   value="<@spring.message 'film.page.add'/>"/>
                        </div>
                    </#if>
                    <div>
                        <hr>
                        <input type="text" class="form-control" id="text_new_ch" name="input"/>
                        <input type="hidden" name="film" value="${film.id}"/>
                        <input type="button" class="btn btn-primary btn-pri" id="btn_add_to_new"
                               value="<@spring.message 'film.page.toNew'/>"/>
                    </div>
                </div>
                <input type="button" class="btn btn-primary btn-pri" id="btn_like"
                       value="${likes} <@spring.message 'likes'/>">
                <input type="button" class="btn btn-primary btn-pri" id="btn_dislike"
                       value="${dislikes} <@spring.message 'dislikes'/>">
            </#if>
        </div>
        <div class="col-9">
            <table class="table">
                <tbody>
                <tr>
                    <th scope="row"><@spring.message 'film.page.release'/></th>
                    <td>${film.date}</td>
                </tr>
                <tr>
                    <th scope="row"><@spring.message 'film.page.country'/></th>
                    <td>${film.country}</td>
                </tr>
                <tr>
                    <th scope="row"><@spring.message 'header.producers'/></th>
                    <#list producers as p>
                        <td><a href="/producers/${p.id}" class="reg">${p.name}</a></td>
                    </#list>
                </tr>
                <tr>
                    <th scope="row"><@spring.message 'header.scriptwriters'/></th>
                    <#list scriptwriters as s>
                        <td><a href="/scriptwriters/${s.id}" class="reg">${s.name}</a></td>
                    </#list>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
    <div class="row">
        <h2 class="text-center"><@spring.message 'header.actors'/></h2>
    </div>
    <div class="row">
        <#list actors as a>
            <div class="col-md-3">
                <div class="card mb-2">
                    <a href="/actors/${a.id}"><img src="/img/${a.photo}" class="img-thumbnail" alt="..."></a>
                </div>
            </div>
        </#list>
    </div>
    <div class="row">
        <h2><@spring.message 'film.page.description'/></h2>
    </div>
    <div class="row">
        <div class="col-sm-12">
            <div class="card">
                <div class="card-body">
                    <p class="card-text">${film.text}</p>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <p></p>
    </div>
</div>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>
</html>
