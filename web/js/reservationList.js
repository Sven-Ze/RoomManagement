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
        var reinigung = reservation.reinigtMieter ? "Mieter" : "Verwaltung";
        tableData += "<tr>";
        tableData += "<td>" + reservation.room.raumName + "</td>";
        tableData += "<td>" + reservation.von + " - " +reservation.bis + "</td>";
        tableData += "<td>" + reinigung + "</td>";
        tableData += "<td>" + reservation.mieter.mieterVorname + " " + reservation.mieter.mieterNachname + "</td>";
        tableData += "<td>" + reservation.mieter.telefon + "</td>";
        if (Cookies.get("userRole") == "verwaltung") {
            tableData += "<td><a href='./reservationEdit.html?reservationId=" + reservation.reservationId + "'>Ansehen</a></td>";
            tableData += "<td><a>Bearbeiten</a></td>";
            tableData += "<td><button type='button'>Löschen</button></td>";
        }
        else if(Cookies.get("userRole") == "hauswart"){
            tableData += "<td><a href='./reservationEdit.html?reservationId=" + reservation.reservationId + "'>Ansehen</a></td>";
            tableData += "<td>X</td>";
            tableData += "<td>X</td>";
        }
        else {
            tableData += "<td>X</td>";
            tableData += "<td>X</td>";
            tableData += "<td>X</td>";
        }
        tableData += "</tr>";
    });
    $("#reservationList > tbody").html(tableData);
}