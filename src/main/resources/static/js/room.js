const id = new URLSearchParams(window.location.search).get("id");
const switchLightButton = $("#switchLight");
const lightStatusText = $("#lightStatus");

let stompClient = null;

function updateRoom(room) {
    lightStatusText.html(room.light ? "on" : "off");
    switchLightButton.html(room.light ? "Off" : "On");
}

function loadRoom() {
    $.getJSON(`/rooms/${id}`, function (room) {
        document.title = room.name;
        updateRoom(room);
    });
}

function connect() {
    let socket = new SockJS(`/rooms-with-bulbs`);
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        stompClient.subscribe(`/topic/room/${id}`, function (data) {
            updateRoom(JSON.parse(data.body));
        });
    }, function () {
        alert("Door is closed for you.");
        window.location = "/";
    });
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
}

function switchLight() {
    stompClient.send(`/app/switchLight/${id}`, {}, {});
}

switchLightButton.click(function () {
    switchLight();
});

window.onload = function () {
    loadRoom();
    connect();
}
