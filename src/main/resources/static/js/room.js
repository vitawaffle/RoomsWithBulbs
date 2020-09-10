const id = new URLSearchParams(window.location.search).get("id");

function loadRoom() {
    $.getJSON(`/rooms/${id}`, function (room) {
        document.title = room.name;
    });
}

window.onload = function () {
    loadRoom();
}
