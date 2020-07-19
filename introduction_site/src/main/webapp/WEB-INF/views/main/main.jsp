<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>

<style>
    html * {
        /* border:0.5px solid #ddd; */
    }
    body {
        font-size: 10px;
    }
    .header {
        width:100%;
    }
    .mainMenu {
        width: 100%;
        margin-top: 20%;
        text-align: center;
    }
    .circle {
        position: relative; 
        border-radius: 50%; 
        border:1px solid black;
    }
    .circle.mainBtn {
        width: 30%; 
        padding-top: 30%; 
        display: inline-block;
        margin: 0 5%;

    }
    .circle.mainBtn > .title {
        position: absolute;
        width: 100%;
        height: auto;
        top: 0%;
        text-align: center;
        font-size: 3em;
        margin-top: 45%;
        z-index: -1;
    }

    #adminLoginBtn {
        width: 10%;
        float: right;
    }
    #gnbBtn {
        width:5%;
        margin-left: 50%;
        margin-right: 50%;
    }
</style>
<html>
    <head>
        <meta charset="UTF-8">
        <title> main page </title>
        <!-- <link rel='stylesheet' type='text/css' media='screen' href='main.css'> -->
        <!-- <script src='main.js'></script> -->
    </head>
    
    <body>
        <div class=header>
            <img id="gnbBtn" src="images/gnbBtn.png" alt="전체 메뉴 버튼">
            <img id="adminLoginBtn" src="images/adminLoginBtn.png" alt="관리자 로그인 버튼">
        </div>
        <div class="mainMenu">
            <div class="circle mainBtn" onclick="goIntroduce('Me');">
                <div class="title">개인 프로필</div>
            </div>
            <div class="circle mainBtn" onclick="goIntroduce('Site');">
                <div class="title">사이트 소개</div>
            </div>
        </div>
    </body>
</html> 


<script text="javascript">
    function goIntroduce (kind) {
        location.href = "/introduce/" + kind;
    }
</script>