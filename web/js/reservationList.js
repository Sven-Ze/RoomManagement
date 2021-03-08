/**
 * Kurzbeschreibung
 *
 * @author  TODO
 * @since   2019-mm-dd
 * @version 1.0
 */
$(document).ready(function () {
    loadReservations();

});

function loadReservations() {
    $
        .ajax({
            url: "./resource/reservation/list",
            dataType: "json",
            type: "GET"
        })
        .done(showReservation)
        .fail(function (xhr, status, errorThrown) {
            if (xhr.status == 404) {
                $("#nachricht").text("keine Reservationen vorhanden");
            }else {
                $("#nachricht").text("Fehler beim Lesen der Reservationen");
            }
        })
}

function showReservation(reservationData) {
    $("#nachricht").val("");
    $("#reservationList > tbody").html("");
    var tableData = "";
    $.each(reservationData, function (id, reservation) {
        tableData += "<tr>";
        tableData += "<td>" + reservation.name + "</td>";
        tableData += "<td>" + reservation.surname + "</td>";
        tableData += "<td>" + reservation.contact +"</td>";
        tableData += "<td>" + reservation.phoneNr + "</td>";
        tableData += "<td>" + reservation.mail + "</td>";
        tableData += "<td>" + reservation.startDate + "</td>";
        tableData += "<td>" + reservation.endDate + "</td>";
        tableData += "<td>" + reservation.receiveKey + "</td>";
        tableData += "<td>" + reservation.willBeCleaned + "</td>";
        tableData += "<td>" + reservation.wish + "</td>";
        tableData += "<td>" + reservation.note + "</td>";
        tableData += "<td>" + reservation.room.roomType + "</td>";
        tableData += "</tr>";
    });
    $("#reservationList > tbody").html(tableData);
}