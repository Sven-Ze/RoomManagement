/**
 * Kurzbeschreibung
 *
 * @author  TODO
 * @since   2019-mm-dd
 * @version 1.0
 */


$(document).ready(function () {
    //loadRooms();
});

function loadRooms() {
    $
        .ajax({
            url: "./resource/room/list",
            dataType: "json",
            type: "GET"
        })
        .done(showRoom)
        .fail(function (xhr, status, errorThrown) {
            if (xhr.status == 404) {
                $("#nachricht").text("keine Räume vorhanden");
            }else {
                $("#nachricht").text("Fehler beim Lesen der Räume");
            }
        })
}

function showRoom(roomData) {
    $("#nachricht").val("");
    $("#roomList > tbody").html("");
    var tableData = "";
    $.each(roomData, function (id, room) {
        tableData += "<tr>";
        tableData += "<td>" + room.roomType + "</td>";
        tableData += "<td>" + room.grundflaeche + "</td>";
        tableData += "<td>" + room.besonderheiten + "</td>";
        tableData += "<td>" + room.kosten + "</td>";
        tableData += "</tr>";
    });
    $("#roomList > tbody").html(tableData);
}