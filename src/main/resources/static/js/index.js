const nameInput = $("#name");
const countriesSelect = $("#countries");
const createButton = $("#create");
const roomsList = $("#rooms");
const refreshButton = $("#refresh");

function loadCountries() {
    $.getJSON("/countries", function (countries) {
        let html = "";
        countries.forEach(country => {
            html += `<option value="${country.id}">${country.name}</option>`;
        });
        countriesSelect.html(html);
    });
}

function loadRooms() {
    $.getJSON("/rooms", function (rooms) {
        let html = "";
        rooms.forEach(room => {
            html += `<li><a href="/room?id=${room.id}">${room.name} (${room.country.name})</a></li>`;
        });
        roomsList.html(html);
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

refreshButton.click(function () {
    loadRooms();
});

window.onload = function () {
    loadCountries();
    loadRooms();
}
