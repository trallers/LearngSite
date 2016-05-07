<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Learning site</title>
    <meta charset="utf-8">
    <link rel="shortcut icon" href="/images/favicon.ico" type="image/x-icon">
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
            <a class="navbar-brand" href="index.jsp"><span>Learning portal</span></a>
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
                                    <h2>Learning site</h2>
                                    <p>Learn languages</p>
                                </div>
                            </div>
                            <div class="item">
                                <img src="images/slider2.jpg">
                                <div class="carousel-caption">
                                    <h2>Learning site</h2>
                                    <p>Increase skills</p>
                                </div>
                            </div>
                            <div class="item">
                                <img src="images/slider3.jpg">
                                <div class="carousel-caption">
                                    <h2>Learning site</h2>
                                    <p>Student.code()</p>
                                </div>
                            </div>
                        </div>
                        <a class="left carousel-control" role="button" href="#myCarousel" data-slide="prev"><i
                                class="icon-prev  fa fa-angle-left"></i></a>
                        <a class="right carousel-control" role="button" href="#myCarousel" data-slide="next"><i
                                class="icon-next fa fa-angle-right"></i></a>
                    </div>
                    <script type="text/javascript">
                        $(document).ready(function () {
                            $('#myCarousel').carousel({
                                interval: 7000
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
                <div class="col-md-4">
                    <img src="/images/java.jpg"
                         class="img-responsive">
                    <h2>Java</h2>
                    <p>Java is the foundation for virtually every type of
                        networked application and is the global standard
                        for developing and delivering embedded and mobile
                        applications, games, Web-based content, and enterprise
                        software. With more than 9 million developers worldwide,
                        Java enables you to efficiently develop, deploy and
                        use exciting applications and services.
                    </p>
                </div>
                <div class="col-md-4">
                    <img src="images/js.png"
                         class="img-responsive">
                    <h2>JavaScript</h2>
                    <p>JavaScript is a programming language used to make web pages interactive. It runs on your
                        visitor's computer and doesn't require constant downloads from your website. JavaScript is often
                        used to create polls and quizzes.
                    </p>
                </div>
                <div class="col-md-4">
                    <img src="images/net.png"
                         class="img-responsive">
                    <h2>.NET</h2>
                    <p>.NET is both a business strategy from Microsoft and its collection of programming support for
                        what are known as Web services, the ability to use the Web rather than your own computer for
                        various services. Microsoft's goal is to provide individual and business users with a seamlessly
                        interoperable and Web-enabled interface for applications and computing devices and to make
                        computing activities increasingly Web browser-oriented.
                    </p>
                </div>
            </div>
        </div>
    </div>

</content>
<footer class="navbar navbar-fixed-bottom">
    <div class="container">
        <div class="row">
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