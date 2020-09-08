const nameInput = $("#name");
const countriesSelect = $("#countries");
const createButton = $("#create");
const roomsList = $("#rooms");

function loadCountries() {
    countriesSelect.html("");
    $.getJSON("/countries", function (countries) {
        countries.forEach(country => {
            countriesSelect.append(`<option value="${country}">${country}</option>`);
        });
    });
}

function loadRooms() {
    roomsList.html("");
    $.getJSON("/rooms", function (rooms) {
        rooms.forEach(room => {
            roomsList.append(`<li><a href="/rooms/${room.name}">${room.name} (${room.country})</a></li>`);
        });
    });
}

function createRoom() {
    $.ajax({
        type: "POST",
        url: "/rooms",
        data: JSON.stringify({
            name: nameInput.val(),
            country: countriesSelect.val()
        }),
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        complete: function (jqXHR) {
            switch (jqXHR.status) {
                case 201:
                    alert("Created!");
                    loadRooms();
                    break;
                case 400:
                    alert("Error!");
                    break;
                default:
            }
        }
    });
}

createButton.click(function () {
    createRoom();
});

window.onload = function () {
    loadCountries();
    loadRooms();
}
