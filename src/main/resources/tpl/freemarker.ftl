<!DOCTYPE html>
<html lang="en" style="background: #fff">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <style>
        .card {
            float: left;
            width: 25%;
            box-sizing: border-box;
        }

        .card > .item {
            transition: .5s all;
            cursor: pointer;
            margin: 10px;
            border: 1px solid #ccc;
            /*border-top: 6px solid #;*/
        }

        .card > .item .title {
            margin: 0;
            padding: 15px 0;
            text-align: center;
            color: #fff;
            /*border-bottom: 1px dashed #ccc;*/
            transition: 1s all;
        }

        .card > .item:hover {
            /*background: #333;*/
            /*color: #fff;*/
            transform: translateY(-8px);
            transition: all .25s ease-in-out;
            box-shadow: 0 25px 60px -20px rgba(155, 165, 163, .45);
        }

        .card > .item:hover .title {
            background: #333;
            color: #fff;
        }

        @media screen and (max-width: 767px) {
            .card {
                float: left;
                width: 50%;
                box-sizing: border-box;
            }
        }

    </style>
</head>
<body>
<div>
    <#include "./header.html">
    <div style="margin:0 15px">
        <!--<h1 style="padding-left:10px;text-align: center">-->
        <!--<span style="font-size: 2em">Use Erupt tpl draw</span>-->
        <!--</h1>-->
        <#list map?keys as key>
            <div class="card">
                <div class="item">
                    <p class="title" style="background: ${color[key_index]}">${key}</p>
                    <p style="text-align: center;font-size: 2.2em;color: ${color[key_index]}">${map[key]}</p>
                </div>
            </div>
        </#list>
    </div>
</div>
</body>
</html>