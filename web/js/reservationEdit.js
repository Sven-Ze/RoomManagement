/**
 * view-controller for reservationEdit.html
 *
 * M426 - Room Management
 *
 * @author  Sven Zeindler
 */
$(document).ready(function () {
    loadReservation();
    loadRoom();
    loadMieter();

    /**
     * listener for submitting the form
     */
    $("#reservationEditForm").submit(saveReservation);

    /**
     * listener for button [abbrechen], redirects to roomlist
     */
    $("#cancel").click(function () {
        window.location.href = "./reservationList.html";
    });

});

function loadReservation() {
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

/**
 * sends the reservation data to the webservice
 * @param form the form being submitted
 */
function saveReservation(form) {
    form.preventDefault();
    var bookUUID = $("#reservationId").val();
    var url = "./resource/reservation/";
    var type = "";
    if (bookUUID) {
        url += "update";
        type = "PUT";
    } else {
        url += "create";
        type = "POST";
    }
    $
        .ajax({
            url: url,
            dataType: "text",
            type: type,
            data: $("#reservationEditForm").serialize(),
        })
        .done(function (jsonData) {
            window.location.href = "./reservationList.html";
        })
        .fail(function (xhr, status, errorThrown) {
            if (xhr.status == 404) {
                $("#message").text("Diese Reservation existiert nicht");
            } else {
                $("#message").text("Fehler beim Speichern der Reservation");
            }
        })
}

function showReservation(reservation) {
    $("#message").empty();
    $("#reservationId").val(reservation.reservationId);
    $("#mieter").val(reservation.mieter.mieterId);
    $("#room").val(reservation.room.roomId);
    $("#von").val(reservation.von);
    $("#bis").val(reservation.bis);
    $("#zusatzStruktur").val(reservation.zusatzStruktur);
    $("#reinigtMieter").val(reservation.reinigtMieter? 1: 0);

    if (Cookies.get("userRole") != "verwaltung") {
        $("#mieter, #room, #von, #bis, #zusatzStruktur,#reinigtMieter").prop("readonly", true);
        $("#save, #reset").prop("disabled", true);
    }
}

function loadMieter() {
    $
        .ajax({
            url: "./resource/mieter/list",
            dataType: "json",
            type: "GET"
        })
        .done(showMieter)
        .fail(function (xhr, status, errorThrown) {
            if (xhr.status == 404) {
                $("#message").text("Keine Mieter gefunden");
            } else {
                window.location.href = "./reservationList.html";
            }
        })
}

function showMieter(mieter) {

    $.each(mieter, function (mieterId, mieter) {
        $('#mieter').append($('<option>', {
            value: mieter.mieterId,
            text : mieter.mieterVorname + " " + mieter.mieterNachname
        }));
    });
}

function loadRoom() {
    $
        .ajax({
            url: "./resource/room/list",
            dataType: "json",
            type: "GET"
        })
        .done(showRoom)
        .fail(function (xhr, status, errorThrown) {
            if (xhr.status == 404) {
                $("#message").text("Keine Räume gefunden");
            } else {
                window.location.href = "./reservationList.html";
            }
        })
}

function showRoom(room) {

    $.each(room, function (roomId, room) {
        $('#room').append($('<option>', {
            value: room.roomId,
            text : room.raumName
        }));
    });
}