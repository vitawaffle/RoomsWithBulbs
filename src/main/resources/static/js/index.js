const nameInput = $("#name");
const countriesSelect = $("#countries");
const createButton = $("#create");
const roomsList = $("#rooms");

function loadCountries() {
    $.getJSON("/countries", function (countries) {
        countries.forEach(country => {
            countriesSelect.append(`<option value="${country.alpha2}">${country.name}</option>`);
        });
    });
}

window.onload = function () {
    loadCountries();
}
