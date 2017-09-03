<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Student</title>
    <base href="/">
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/resources/css/bootstrap-theme.min.css"/>
    <link rel="stylesheet" href="/resources/css/custom.css"/>
</head>
<body ng-app="demoApp">

<div class="container">

    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="#">
                </a>
            </div>
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li class="active"><a ng-href="/">Home</a></li>
                    <li><a ng-href="edit">Add Student</a></li>
                </ul>
            </div>
        </div>
    </nav>
    <hr>

    <div id="root" ng-view>
    </div>
</div>



<script type="text/javascript" src="/resources/js/angular.js"></script>
<script type="text/javascript" src="/resources/js/angular-route.js"></script>
<script type="text/javascript" src="/resources/js/app.js"></script>
<script type="text/javascript" src="/resources/js/route.js"></script>
<script type="text/javascript" src="/resources/js/controllers/StuListController.js"></script>
<script type="text/javascript" src="/resources/js/controllers/StuEditController.js"></script>

<script type="text/javascript" src="/resources/js/jquery.min.js"></script>
<script type="text/javascript" src="/resources/js/bootstrap.min.js"></script>
</body>
</html>