<%--
  Created by IntelliJ IDEA.
  User: wupengfei
  Date: 2019/12/31
  Time: 12:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
</head>
<body>
<a>可行</a>
<input type="button" value="list" id="list">
<input type="button" value="数组" id="shuzu">
<input type="button" value="实体array" id="array">
<h2>修改</h2>
<script>
    //list
    $("#list").click(function () {
        var formData = {};
        $.ajax({
            type: 'GET',
            url: "/account/findList",
            data: formData,
            success: function (data) {
                console.log(data)
            }
        })
    });

    //数组
    $("#shuzu").click(function () {
        var formData = {mine: ['a', 'b', 'c']};
        $.ajax({
            type: 'POST',
            url: "/account/shuzu",
            data: formData,
            traditional: true,
            success: function (data) {
                console.log(data)
            }
        })
    });

    //实体array
    $("#array").click(function () {
        var formData = {
            name: '中国建设银行',
            money: 100.00,
            personsList: JSON.stringify([{name: 'Linda', age: 12}, {name: 'zhangsan', age: 14}])
        };
        $.ajax({
            type: 'POST',
            url: "/account/array",
            data: formData,
            dataType: 'json',
            success: function (data) {
                console.log(data)
            }
        })
    });


</script>
</body>
</html>
