<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>TEST</title>
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function() {
            $('#call').click(function ()
            {
                $.ajax({
                    type: "post",
                    url: "/test", //here you can use servlet,jsp, etc
                    data: "input=" +$('#ip').val(),
                    success: function(msg){
                        $('#output').append(msg);
                    }
                });
            });

        });
    </script>
</head>
<body>
    input:<input id="ip" type="text" name="" value="" /><br></br>
    output:<input id="op" type="text" name="" value="" /><br></br>
    <input type="button" value="Call JSP" name="Call JSP" id="call"/>
    <div id="output"></div>
</body>
</html>