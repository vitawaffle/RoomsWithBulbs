const nameInput = $("#name");
const countriesSelect = $("#countries");
const createButton = $("#create");
const roomsList = $("#rooms");

function loadCountries() {
    countriesSelect.html("");
    $.getJSON("/countries", function (countries) {
        countries.forEach(country => {
            countriesSelect.append(`<option value="${country.id}">${country.name}</option>`);
        });
    });
}

function loadRooms() {
    roomsList.html("");
    $.getJSON("/rooms", function (rooms) {
        rooms.forEach(room => {
            roomsList.append(`<li>${room.name} (${room.country.name})</li>`);
        });
    });
}

function createRoom() {
    $.getJSON(`/countries/${countriesSelect.val()}`, function (country) {
        $.ajax({
            type: "POST",
            url: "/rooms",
            data: JSON.stringify({
                name: nameInput.val(),
                country: country
            }),
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            complete: function (jqXHR) {
                switch (jqXHR.status) {
                    case 201:
                        alert("Created!");
                        loadRooms();
                        break;
                    default:
                        alert("Error of creation!");
                }
            }
        });
    });
}

createButton.click(function () {
    createRoom();
});

window.onload = function () {
    loadCountries();
    loadRooms();
}
