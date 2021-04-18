/**
 * view-controller for reservationList.html
 *
 * M426 - Room Management
 *
 * @author  Sven Zeindler
 */
$(document).ready(function () {
    loadAcceptedReservations();
    loadPendingReservations();

});

function loadAcceptedReservations() {
    $
        .ajax({
            url: "./resource/reservation/listAccepted",
            dataType: "json",
            type: "GET"
        })
        .done(showAcceptedReservation)
        .fail(function (xhr, status, errorThrown) {
            if (xhr.status == 404) {
                $("#nachricht").text("keine Reservationen vorhanden");
            }else {
                $("#nachricht").text("Fehler beim Lesen der Reservationen");
            }
        })
}


function getFile() {
    var reservationId = $.urlParam('reservationId');
    if (reservationId !== null && reservationId != -1) {
        $
            .ajax({
                url: "./resource/reservation/read?reservationId=" + reservationId,
                dataType: "json",
                type: "GET"
            })
            .done(showReservation)
            .fail(function (xhr, status, errorThrown) {
                if (xhr.status == 403) {
                    window.location.href = "./login.html";
                } else if (xhr.status == 404) {
                    $("#message").text("Keine Reservation gefunden");
                } else {
                    window.location.href = "./reservationList.html";
                }
            })
    }
}


function showAcceptedReservation(reservationData) {
    $("#nachricht").val("");
    $("#reservationAcceptedList > tbody").html("");
    var tableData = "";
    $.each(reservationData, function (id, reservation) {
        var reinigung = reservation.reinigtMieter ? "Mieter" : "Verwaltung";
        tableData += "<tr>";
        tableData += "<td>" + reservation.room.raumName + "</td>";
        tableData += "<td>" + reservation.von + " - " +reservation.bis + "</td>";
        tableData += "<td>" + reinigung + "</td>";
        tableData += "<td>" + reservation.mieter.mieterVorname + " " + reservation.mieter.mieterNachname + "</td>";
        tableData += "<td>" + reservation.mieter.telefon + "</td>";
        tableData += "</tr>";
    });
    $("#reservationAcceptedList > tbody").html(tableData);
}

function loadPendingReservations() {
    $
        .ajax({
            url: "./resource/reservation/listPending",
            dataType: "json",
            type: "GET"
        })
        .done(showPendingReservation)
        .fail(function (xhr, status, errorThrown) {
            if (xhr.status == 404) {
                $("#nachricht").text("keine Reservationen vorhanden");
            }else {
                $("#nachricht").text("Fehler beim Lesen der Reservationen");
            }
        })
}

function showPendingReservation(reservationData) {
    $("#nachricht").val("");
    $("#reservationPendingList > tbody").html("");
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
            tableData += "<td><button type='button'>Datei</button></td>";
        }
        else if(Cookies.get("userRole") == "hauswart"){
            tableData += "<td><a href='./reservationEdit.html?reservationId=" + reservation.reservationId + "'>Ansehen</a></td>";
            tableData += "<td>X</td>";
            tableData += "<td>X</td>";
            tableData += "<td>X</td>";
        }
        else {
            tableData += "<td>X</td>";
            tableData += "<td>X</td>";
            tableData += "<td>X</td>";
            tableData += "<td>X</td>";

        }
        tableData += "</tr>";
    });
    $("#reservationPendingList > tbody").html(tableData);
}