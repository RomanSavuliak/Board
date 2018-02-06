/**
 * Created by Roman on 06.02.2018.
 */
//Init
init();
//Button Functions------------------------------------------
function init() {
    $(".button-backlog").on("click", function() {
        if (!($(this).closest(".backlog").length > 0)) {
            setToDoState($(this).parents(".input-group").get(0).data)
            $(this).parents(".input-group").appendTo(".backlog").css({
                "background-color": "",
                "border": ""
            });
        }
    });
    $(".button-progress").on("click", function() {
        if (!($(this).closest(".in-progress").length > 0)) {
            setInProgressState($(this).parents(".input-group").get(0).data)
            $(this).parents(".input-group").appendTo(".in-progress").css({
                "background-color": "#ffdfbc",
                "border": "none"
            });
        }
    });
    $(".button-done").on("click", function() {
        if (!($(this).closest(".done").length > 0)) {
            setDoneState($(this).parents(".input-group").get(0).data)
            $(this).parents(".input-group").appendTo(".done").css({
                "background-color": "#cfffd0",
                "border": "none"
            });
        }
    });

    $(".button-delete").on("click", function() {
        var id = $(this).parents(".input-group").get(0).data;
        $(this).parents(".input-group").remove();
        deleteTicket(id)
    });

    var placeholderDiv = document.createElement("div");
    var placeholderAtt = document.createAttribute("class");
    var taskDivAttVal = placeholderAtt.value = "placeholder";
    placeholderDiv.setAttributeNode(placeholderAtt);
}

function setToDoState(id) {
    var _csrf = $('meta[name=_csrf]').attr("content");
    $.ajax({
            type: 'GET',
            url: "/ticket/set/state/todo/id/" + id,
            headers: {
                'X-CSRF-TOKEN': _csrf
            },
            success: function () {
                return true;
            }
        }
    );
}

function setInProgressState(id) {
    var _csrf = $('meta[name=_csrf]').attr("content");
    $.ajax({
            type: 'GET',
            url: "/ticket/set/state/progress/id/" + id,
            headers: {
                'X-CSRF-TOKEN': _csrf
            },
            success: function () {
                console.log("Ticket set in-progress state")
                return true;
            }
        }
    );
}

function setDoneState(id) {
    var _csrf = $('meta[name=_csrf]').attr("content");
    $.ajax({
            type: 'GET',
            url: "/ticket/set/state/done/id/" + id,
            headers: {
                'X-CSRF-TOKEN': _csrf
            },
            success: function () {
                return true;
            }
        }
    );
}

function deleteTicket(id) {
    var _csrf = $('meta[name=_csrf]').attr("content");
    $.ajax({
            type: 'GET',
            url: "/ticket/remove/id/" + id,
            headers: {
                'X-CSRF-TOKEN': _csrf
            },
            success: function () {
                return true;
            }
        }
    );
}

function createTicket() {
    var _csrf = $('meta[name=_csrf]').attr("content");
    $.ajax({
        url: "/ticket/add/",
        method: 'POST',
        headers: {
            'X-CSRF-TOKEN': _csrf
        },
        contentType: 'application/json',
        data: JSON.stringify({
            name:$("#task").val(),
            description:$("#taskDesc").val()
        }),
        success: function (data) {
            addTicket($("#task").val(), $("#taskDesc").val(), "todo", data.id)
            console.log(data)
        },
    });
}

//Create Ticket------------------------------------------

$("#add-button").on("click", function() {
    createTicket();
});

function getTickets() {
    var _csrf = $('meta[name=_csrf]').attr("content");
    // console.log("loadTickets")
    $.ajax({
            type: 'GET',
            url: "/ticket/get/all",
            headers: {
                'X-CSRF-TOKEN': _csrf
            },
            success: function (data) {
                //    console.log(data)
                data.forEach(function (item, i) {
                    addTicket(item.name, item.description, item.state, item.id)
                });
            }
        }
    );
}

function addTicket(name, description, state, id) {

    var taskDiv = document.createElement("div");
    var taskSpan = document.createElement("span");
    var descriptionDiv = document.createElement("div");
    var buttonsDiv = document.createElement("div");
    var buttonBacklog = document.createElement("button");
    var buttonProgress = document.createElement("button");
    var buttonDone = document.createElement("button");
    var buttonDelete = document.createElement("button");

    var taskDivAtt = document.createAttribute("class");
    var buttonsDivAtt = document.createAttribute("class");
    var buttonBacklogAtt = document.createAttribute("class");
    var buttonProgressAtt = document.createAttribute("class");
    var buttonDoneAtt = document.createAttribute("class");
    var buttonDeleteAtt = document.createAttribute("class");

    var taskDivAttVal = taskDivAtt.value = "input-group overflow";
    var buttonsDivAttVal = buttonsDivAtt.value = "margin-top-10";
    var buttonBacklogAttVal = buttonBacklogAtt.value = "button button-backlog";
    var buttonProgressAttVal = buttonProgressAtt.value = "button button-progress";
    var buttonDoneAttVal = buttonDoneAtt.value = "button button-done";
    var buttonDeleteAttVal = buttonDeleteAtt.value = "button button-delete";

    taskDiv.setAttributeNode(taskDivAtt);
    buttonsDiv.setAttributeNode(buttonsDivAtt);
    buttonBacklog.setAttributeNode(buttonBacklogAtt);
    buttonProgress.setAttributeNode(buttonProgressAtt);
    buttonDone.setAttributeNode(buttonDoneAtt);
    buttonDelete.setAttributeNode(buttonDeleteAtt);

    var taskText = document.createTextNode(name);
    var descriptionText = document.createTextNode(description);

    var buttonBacklogText = document.createTextNode("Backlog");
    var buttonProgressText = document.createTextNode("In Progress");
    var buttonDoneText = document.createTextNode("Done");
    var buttonDeleteText = document.createTextNode("Delete");

    taskSpan.appendChild(taskText);
    descriptionDiv.appendChild(descriptionText);
    taskDiv.appendChild(taskSpan);
    taskDiv.appendChild(descriptionDiv);
    taskDiv.appendChild(buttonsDiv);
    buttonBacklog.appendChild(buttonBacklogText);
    buttonProgress.appendChild(buttonProgressText);
    buttonDone.appendChild(buttonDoneText);
    buttonDelete.appendChild(buttonDeleteText);
    buttonsDiv.appendChild(buttonBacklog);
    buttonsDiv.appendChild(buttonProgress);
    buttonsDiv.appendChild(buttonDone);
    buttonsDiv.appendChild(buttonDelete);
    taskDiv.data = id;

    switch (state) {
        case "todo":
            $('.backlog').append(taskDiv);
            break;
        case "in-progress":
            taskDiv.style.backgroundColor = '#ffdfbc';
            $('.in-progress').append(taskDiv);
            break;
        case "done":
            taskDiv.style.backgroundColor = '#cfffd0';
            $('.done').append(taskDiv);
            break;
        default:
    }

    init();
}

window.onload = function() {
    getTickets();
};