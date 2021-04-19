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

    $("#allReservationForm").on("click", "#delete", function () {
        if (confirm("Wollen Sie diese Reservation wirklich löschen?")) {
            deleteReservation(this.value);
        }
    });

    $("#reservationForm").on("click", "#delete", function () {
        if (confirm("Wollen Sie diese Reservation wirklich löschen?")) {
            deleteReservation(this.value);
        }
    });

    $("#reservationForm").on("click", "#file", function () {
        if (confirm("Wollen Sie dieses File wirklich erstellen?")) {
            getFile(this.value);
        }
    });

});

function loadAcceptedReservations() {
    $
        .ajax({
            url: "./resource/reservation/list",
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

/**
 * send delete request for a reservation
 * @param reservationId
 */
function deleteReservation(reservationId) {
    $
        .ajax({
            url: "./resource/reservation/delete?reservationId=" + reservationId,
            dataType: "text",
            type: "DELETE",
        })
        .done(function (data) {
            loadProjekt();
            $("#message").text("Reservation gelöscht");

        })
        .fail(function (xhr, status, errorThrown) {
            $("#message").text("Fehler beim Löschen der Reservation");
        })
}


function getFile(reservationId) {
        $
            .ajax({
                url: "./resource/reservation/getFile?reservationId=" + reservationId,
                dataType: "text",
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
        tableData += "<td>" + reservation.mieter.telefon + "</td>"
        tableData += "<td>" + reservation.status + "</td>";
        if (Cookies.get("userRole") == "verwaltung") {
            tableData += "<td><a href='./reservationEdit.html?reservationId=" + reservation.reservationId + "'>Ansehen</a></td>";
            tableData += "<td><a href='./reservationEdit.html?reservationId=" + reservation.reservationId + "'>Bearbeiten</a></td>";
            tableData += "<td><button type='button' id='delete' value='" + reservation.reservationId + "'>Löschen</button></td>";
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
        tableData += "<td>" + reservation.status + "</td>";
        if (Cookies.get("userRole") == "verwaltung") {
            tableData += "<td><a href='./reservationEdit.html?reservationId=" + reservation.reservationId + "'>Ansehen</a></td>";
            tableData += "<td><a href='./reservationEdit.html?reservationId=" + reservation.reservationId + "'>Bearbeiten</a></td>";
            tableData += "<td><button type='button' id='delete' value='" + reservation.reservationId + "'>Löschen</button></td>";
            tableData += "<td><button type='button' id='file' value='" + reservation.reservationId + "'>Datei</button></td>";
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