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
    let socket = new SockJS("/rooms-with-bulbs");
    stompClient = Stomp.over(socket);
    stompClient.connect({
        "test_header": "test 666"
    }, function (frame) {

        /* Start of debug section */
        console.log(`Connected: ${frame}`);
        /* End of debug section */

        stompClient.subscribe(`/topic/room/${id}`, function (data) {

            /* Start of debug section */
            console.log(JSON.parse(data.body));
            /* End of debug section */

            updateRoom(JSON.parse(data.body));
        }, function () {});
    });
}

function disconnect() {

    /* Start of debug section */
    console.log("Disconnected");
    /* End of debug section */

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
