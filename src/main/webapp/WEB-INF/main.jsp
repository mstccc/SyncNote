
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>简易记事本</title>
    <script src="static/jquery-3.6.3.min.js">
    </script>
    <link rel="stylesheet" type="text/css" href="static/css/demo.css"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script>
        //改变背景字体颜色
        function changeColor(bgcolor) {  //通过点击事件改变body的背景颜色
            document.body.style.background = bgcolor;
        }

        function boxColor(boxcolor){  //通过点击事件改变文本框的背景颜色
            document.getElementById('box2').style.background = boxcolor;
        }

        function textColor(textcolor){//通过点击事件改变文字的颜色
            document.getElementById('box2').style.color = textcolor;
        }

        var a = true; //按钮的状态改变以及改变颜色的颜色参数
        function button1() {
            if(a){
                changeColor('black');
                boxColor('#736F6E');
                textColor("white");
                a=false;
            }else{
                changeColor('white');
                boxColor('white');
                textColor("black");
                a=true;
            }
        }


        //页面加载事件
        window.onload = function () {
            //全局变量，记录本次访问的路径后缀
            path = "${pageContext.request.getAttribute("path")}";
            $.ajax({
                url:"${pageContext.request.contextPath}/firstRequest",
                type:"post",
                data: {"url":path},
                dataType:"text",
                success:function (result){
                    //回调函数
                    //将请求获得的数据显示在文本框里
                    $("#box2").val(result);
                }
            });
        }

        //上传内容
        //键盘按下后的抬起事件
        //为防止频繁发送请求，故每一次发送请求之前都判断内容是否被修改。
        // 事先准备全局变量strData1保存文本框的原始数据，每一次触发键盘事件后，则获取实时的文本框数据与原始数据判断，不同，则发请求
        strData1 = $("#box2").val;
        document.onkeyup = function(){
            var strData2 = $("#box2").val();
            if (strData1 != strData2){
                    $.ajax({
                        url:"${pageContext.request.contextPath}/normalRequest",
                        type:"post",
                        data:{"strData":strData2, "url":path},
                        dataType:"json"
                    })
                    //每次发送请求后，将当前数据赋值为原始数据
                    strData1 = strData2;
            }
        }

    </script>
</head>
<body>
<button class="button" onclick="button1()">切换夜间模式</button> <!-- 切换夜间模式的按钮 -->

<div class="box">
    <textarea id="box2"  style="resize: none;" rows="100%"></textarea> <!--自适应文本框-->
</div>

</body>
</html>

