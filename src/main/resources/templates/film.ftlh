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
    <#--        <script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.slim.min.js"-->
    <#--            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"-->
    <#--            crossorigin="anonymous"></script>-->
    <#--        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>-->
    <title>Film</title>
</head>
<body class="photo">
<@header/>
<script type="text/javascript">
    $(document).ready(function () {
        <#--$('#byn_add_comment').click(function () {-->
        <#--    $.ajax({-->
        <#--        type: "post",-->
        <#--        url: "/comment",-->
        <#--        dataType: "json",-->
        <#--        data: {-->
        <#--            "text": $('#text_comment').val(),-->
        <#--            "film_id": "${film.id}"-->
        <#--        },-->
        <#--        success: function (msg) {-->
        <#--            $('#table_comments').html(-->
        <#--                "<div class=\"col-sm-12\">" +-->
        <#--                "<div class=\"card\">" +-->
        <#--                "<div class=\"card-body\">" +-->
        <#--                "<div class=\"media-block\">" +-->
        <#--                "<div class=\"media-body\">" +-->
        <#--                "<div class=\"mar-btm\">" +-->
        <#--                "<a href=\"#\" class=\"btn-link text-semibold media-heading box-inline\">" + msg.user_name + "</a>" +-->
        <#--                "<p class=\"text-muted text-sm\"><i class=\"fa fa-mobile fa-lg\"></i>" + msg.date + "</p> " +-->
        <#--                "</div>" +-->
        <#--                " <p>" + $('#text_comment').val() + "</p> " +-->
        <#--                "</div> " +-->
        <#--                "</div>" +-->
        <#--                "</div>" +-->
        <#--                "</div>" +-->
        <#--                "</div>")-->
        <#--            //     "<tr><td>" + msg.user_name + "</td><td>" + $('#text_comment').val() + "</td><td>" + msg.date + "</td></tr>");-->
        <#--            $('#text_comment').val("");-->
        <#--        }-->
        <#--    });-->
        <#--});-->
        <#--$('#btn_add_to').click(function () {-->
        <#--    $.ajax({-->
        <#--        type: "post",-->
        <#--        url: "/film",-->
        <#--        data: {-->
        <#--            "input": $('#selector').val(),-->
        <#--            "film_id": "${film.id}"-->
        <#--        },-->
        <#--        success: function () {-->
        <#--            $('#selector').append("<#list checklists as c><option id=${c.name}>${c.name}</option></#list><option>" + $('#selector').val() + "</option>");-->
        <#--            $('#btn_add_to').attr("disabled", 'disabled');-->
        <#--        }-->
        <#--    });-->
        <#--});-->
        <#--$('#btn_add_to_new').click(function () {-->
        <#--    $.ajax({-->
        <#--        type: "post",-->
        <#--        url: "/creation",-->
        <#--        data: {-->
        <#--            "input": $('#text_new_ch').val(),-->
        <#--            "film_id": "${film.id}"-->
        <#--        },-->
        <#--        success: function () {-->
        <#--            $('#text_new_ch').val("");-->
        <#--            $('#btn_add_to_new').attr("disabled", 'disabled');-->
        <#--        }-->
        <#--    });-->
        <#--});-->
        $('#btn_like').click(function () {
            $.ajax({
                type: "post",
                url: "/like",
                data: {
                    "film_id": "${film.id}"
                },
                success: function () {
                    $('#btn_like').val((parseInt($('#btn_like').val()) + 1) + " likes");
                    $('#btn_like').attr("disabled", 'disabled');
                }
            });
        });
        $('#btn_dislike').click(function () {
            alert("Click");
            $.ajax({
                type: "post",
                url: "/dislike",
                data: {
                    "film_id": "${film.id}"
                },
                success: function () {
                    $('#btn_dislike').val((parseInt($('#btn_dislike').val()) + 1) + " dislikes");
                    $('#btn_dislike').attr("disabled", 'disabled');
                }
            });
        });
    });
</script>
<div class="container film">
    <div class="row">
        <div class="col-12">
            <h2 class="name">${film.name}</h2>
        </div>
    </div>
    <div class="row">
        <div class="col-3">
            <img src="/img/${film.photo}" alt="..." class="img-thumbnail ">
            <div class="input-group">
                <#if checklists?has_content>
                    <div>
                        <select class="custom-select" id="selector">
                            <option selected>Choose...</option>
                            <#list checklists as c>
                                <option id=${c.name}>${c.name}</option>
                            </#list>
                        </select>
                    </div>
                    <div>
                        <input type="button" class="btn btn-primary btn-pri" id="btn_add_to" value="Add to checklist"/>
                    </div>
                </#if>
                <div>
                    <hr>
                    <input type="text" class="form-control" id="text_new_ch" name="input"/>
                    <input type="hidden" name="film" value="${film.id}"/>
                    <input type="button" class="btn btn-primary btn-pri" id="btn_add_to_new" value="To new checklist"/>
                </div>
            </div>
            <input type="button" class="btn btn-primary btn-pri" id="btn_like" value="${likes} likes">
            <input type="button" class="btn btn-primary btn-pri" id="btn_dislike" value="${dislikes} dislikes">
        </div>
    </div>
    <#--        <div class="col-9">-->
    <#--            <table class="table">-->
    <#--                <tbody>-->
    <#--                <tr>-->
    <#--                    <th scope="row">Release date:</th>-->
    <#--                    <td>${film.date}</td>-->
    <#--                </tr>-->
    <#--                <tr>-->
    <#--                    <th scope="row">Country:</th>-->
    <#--                    <td>${film.country}</td>-->
    <#--                </tr>-->
    <#--                <tr>-->
    <#--                    <th scope="row">Categories:</th>-->

    <#--                    <td>-->
    <#--                        <#list categories as c>${c.name} </#list>-->
    <#--                    </td>-->

    <#--                </tr>-->
    <#--                <tr>-->
    <#--                    <th scope="row">Producers:</th>-->
    <#--                    <#list producers as p>-->
    <#--                        <td><a href="/star?producer_id=${p.id}" class="reg">${p.name}</a></td>-->
    <#--                    </#list>-->
    <#--                </tr>-->
    <#--                <tr>-->
    <#--                    <th scope="row">Scriptwriters:</th>-->
    <#--                    <#list scriptwriters as s>-->
    <#--                        <td><a href="/star?scr_id=${s.id}" class="reg">${s.name}</a></td>-->
    <#--                    </#list>-->
    <#--                </tr>-->
    <#--                </tbody>-->
    <#--            </table>-->
    <#--        </div>-->
    <#--    </div>-->
    <#--    <div class="row">-->
    <#--        <h2 class="text-center">Actors</h2>-->
    <#--    </div>-->
    <#--    <div class="row">-->
    <#--        <#list actors as a>-->
    <#--            <div class="col-md-3">-->
    <#--                <div class="card mb-2">-->
    <#--                    <a href="/star?actor_id=${a.id}"><img src="../../front/img/${a.photo}" class="img-thumbnail"-->
    <#--                                                          alt="..."></a>-->
    <#--                </div>-->
    <#--            </div>-->
    <#--        </#list>-->
    <#--    </div>-->
    <#--    <div class="row">-->
    <#--        <h2> Description </h2>-->
    <#--    </div>-->
    <#--    <div class="row">-->
    <#--        <div class="col-sm-12">-->
    <#--            <div class="card">-->
    <#--                <div class="card-body">-->
    <#--                    <p class="card-text">${film.text}</p>-->
    <#--                </div>-->
    <#--            </div>-->
    <#--        </div>-->
    <#--    </div>-->
    <#--    <div class="row">-->
    <#--        <p></p>-->
    <#--    </div>-->
    <#--    <div class="row">-->
    <#--        <h2>Comments</h2>-->
    <#--    </div>-->
    <#--    <#list comments as c>-->
    <#--        <div class="row" id="table_comments">-->
    <#--        </div>-->
    <#--        <div class="row">-->
    <#--            <div class="col-sm-12">-->
    <#--                <div class="card">-->
    <#--                    <div class="card-body">-->
    <#--                        <div class="media-block">-->
    <#--                            <div class="media-body">-->
    <#--                                <div class="mar-btm">-->
    <#--                                    <a href="#" class="btn-link text-semibold media-heading box-inline">${c.user}</a>-->
    <#--                                    <p class="text-muted text-sm"><i class="fa fa-mobile fa-lg"></i> ${c.date}</p>-->
    <#--                                </div>-->
    <#--                                <p>${c.text}</p>-->
    <#--                            </div>-->
    <#--                        </div>-->
    <#--                    </div>-->
    <#--                </div>-->
    <#--            </div>-->
    <#--        </div>-->
    <#--    </#list>-->
    <#--    <#if (user?has_content)>-->
    <#--        <div class="row">-->
    <#--            <div class="col-md-12">-->
    <#--                <div class="panel">-->
    <#--                    <div class="panel-body">-->
    <#--                        <textarea class="form-control" id="text_comment" rows="2" placeholder="Add comment"></textarea>-->
    <#--                        <div class="mar-top clearfix">-->
    <#--                            <button class="btn btn-sm btn-primary pull-right" id="byn_add_comment" type="submit"><i-->
    <#--                                        class="fa fa-pencil fa-fw"></i>Add-->
    <#--                            </button>-->
    <#--                        </div>-->
    <#--                    </div>-->
    <#--                </div>-->
    <#--            </div>-->
    <#--        </div>-->
    <#--    </#if>-->
</div>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>
</html>
