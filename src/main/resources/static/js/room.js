const id = new URLSearchParams(window.location.search).get("id");

function setTitle() {
    $.getJSON(`/rooms/${id}`, function (room) {
        document.title = room.name;
    });
}

window.onload = function () {
    setTitle();
}
