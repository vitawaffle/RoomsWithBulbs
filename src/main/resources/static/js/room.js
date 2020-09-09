function getRequestParam(name) {
    return new URLSearchParams(window.location.search).get(name);
}

function loadRoom() {
    $.ajax({
        type: "GET",
        url: `/rooms/${getRequestParam("id")}`,
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        complete: function (jqXHR) {
            switch (jqXHR.status) {
                case 200:
                    alert("Loaded!");
                    break;
                case 403:
                    alert("This room is not available!");
                    break;
                default:
            }
        }
    });
}

window.onload = function () {
    loadRoom();
}
