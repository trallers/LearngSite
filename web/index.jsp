<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Learning site</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script type="text/javascript" src="js/jquery-1.12.3.min.js"></script>
    <script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>

    <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet"
          type="text/css">
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="css/styles.css" rel="stylesheet" type="text/css">

</head>
<body>
<div class="navbar navbar-default navbar-inverse navbar-static-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-ex-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#"><span>Learning portal</span></a>
        </div>
        <div class="collapse navbar-collapse" id="navbar-ex-collapse">
            <ul class="nav navbar-nav navbar-right">
                <li class="active">
                    <a href="#">Home</a>
                </li>
                <li>
                    <a href="/register.jsp"><span class="glyphicon glyphicon-user"></span> Sign
                        Up</a>
                </li>
                <li>
                    <a href="/login.jsp"><span class="glyphicon glyphicon-log-in"></span> Login</a>
                </li>
            </ul>
        </div>
    </div>
</div>
<content class="container-fluid body-content">
    <div class="section">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div id="myCarousel" data-interval="false" class="carousel slide" data-ride="carousel">
                        <ol class="carousel-indicators">
                            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                            <li data-target="#myCarousel" data-slide-to="1"></li>
                            <li data-target="#myCarousel" data-slide-to="2"></li>
                        </ol>
                        <div class="carousel-inner" role="listbox">
                            <div class="item active">
                                <img src="images/slider1.jpg">
                                <div class="carousel-caption">
                                    <h2>Title</h2>
                                    <p>Description</p>
                                </div>
                            </div>
                            <div class="item">
                                <img src="images/slider2.jpg">
                                <div class="carousel-caption">
                                    <h2>Title2</h2>
                                    <p>Description2</p>
                                </div>
                            </div>
                            <div class="item">
                                <img src="images/slider3.jpg">
                                <div class="carousel-caption">
                                    <h2>Title3</h2>
                                    <p>Description3</p>
                                </div>
                            </div>
                        </div>
                        <a class="left carousel-control" role="button" href="#myCarousel" data-slide="prev"><i
                                class="icon-prev  fa fa-angle-left"></i></a>
                        <a class="right carousel-control" role="button" href="#myCarousel" data-slide="next"><i
                                class="icon-next fa fa-angle-right"></i></a>
                    </div>
                    <script type="text/javascript">
                        $(document).ready(function() {
                            $('#myCarousel').carousel({
                                interval: 2000
                            })
                        });
                    </script>
                </div>
            </div>
        </div>
    </div>

    <div class="section">
        <div class="container">
            <div class="row">
                <div class="col-md-12 text-center">
                    <p class="text-justify">Lorem ipsum dolor sit amet, consectetur adipisici elit, sed eiusmod tempor
                        incidunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis
                        nostrud</p>
                    <p class="text-justify">Lorem ipsum dolor sit amet, consectetur adipisici elit, sed eiusmod tempor
                        incidunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis
                        nostrud</p>
                    <p class="text-justify">Lorem ipsum dolor sit amet, consectetur adipisici elit, sed eiusmod tempor
                        incidunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis
                        nostrud</p>
                    <p class="text-justify">Lorem ipsum dolor sit amet, consectetur adipisici elit, sed eiusmod tempor
                        incidunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis
                        nostrud</p>

                </div>
            </div>
        </div>
    </div>
</content>
<footer class="navbar navbar-fixed-bottom">
    <div class="container">
        <div class="row">
            <hr>
            <div class="col-lg-12">
                <div class="col-md-8">
                    <a href="#">Terms of Service</a>|
                    <a href="#">Privacy</a>
                </div>
                <div class="col-md-4">
                    <p class="muted pull-right">© 2016 Trallers. All rights reserved</p>
                </div>
            </div>
        </div>
    </div>
</footer>


</body>
</html>