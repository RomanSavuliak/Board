<!DOCTYPE html>
<html lang="en" >
<head>
    <meta name="_csrf" content="${_csrf.token}"/>
    <meta name="_csrf_header" content="${_csrf.headerName}"/>
    <meta charset="UTF-8">
    <title>Agile Board</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div ng-app="BoardApp">
    <div>
        <div class="form">
            <h1>Agile Board</h1>
            <input type="text" placeholder="Ticket name" id="task" />
            <b/>
            <input type="text" placeholder="Ticket description" id="taskDesc" />
            <button class="button" id="add-button">Add Task</button>
        </div>
        <div class="flex">
            <div class="agile-board backlog">
                <h2>To Do</h2>
            </div>
            <div class="agile-board in-progress">
                <h2>In progress</h2>
            </div>
            <div class="agile-board done">
                <h2>Done</h2>
            </div>
        </div>
    </div>
    <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
    <script src='https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.3.14/angular.min.js'></script>
    <script  src="js/index.js"></script>
</body>
</html>
