const id = new URLSearchParams(window.location.search).get("id");

let stompClient = null;

function connect() {
    let socket = new SockJS("/rooms-with-bulbs");
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        /* Start of debug section */
        console.log(`Connected: ${frame}`);
        /* End of debug section */

        stompClient.subscribe(`/topic/room/${id}`, function (room) {
            /* Start of debug section */
            console.log(JSON.parse(room.body));
            /* End of debug section */
        });
    });
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }

    /* Start of debug section */
    console.log("Disconnected");
    /* End of debug section */
}

function switchLight() {
    stompClient.send(`/app/switchLight/${id}`, {}, {});
}

function loadRoom() {
    $.getJSON(`/rooms/${id}`, function (room) {
        document.title = room.name;
    });
}

window.onload = function () {
    loadRoom();
}
