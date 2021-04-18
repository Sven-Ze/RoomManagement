/**
 * view-controller for login.html
 *
 * M426 - RoomManagement
 *
 * @author  Sven Zeindler
 */

/**
 * register listeners
 */
$(document).ready(function () {

    /**
     * listener for submitting the form sends the login data to the web service
     */
    $("#loginForm").submit(login);

    /**
     * listener for button Abmelden
     */
    $("#logoff").click(logoff);

});

/**
 * sends the login-request
 * @param form the form with the email/password
 */
function login(form) {
    form.preventDefault();
    $.ajax({
        url:"./resource/user/login",
        dataType: "text",
        type: "POST",
        data: $("#loginForm").serialize()
    })
        .done (function (jsonData) {
            window.location.href = "./roomList.html";
        })
        .fail(function (xhr, status, errorThrown) {
            if (xhr.status = 404){
                $("#message").text("Username/Passwort falsch");
            } else {
                $("#message").text("Es ist ein Fehler aufgetreten");
            }

        })
}

/**
 * sends the logoff-request
 */
function logoff() {
    $
        .ajax({
            url: "./resource/user/logout",
            dataType: "text",
            type: "DELETE"
        })
        .done(function (jsonData) {
            window.location.href = "./login.html";
        })
        .fail(function (xhr, status, errorThrown) {

            $("#message").text("Es ist ein Fehler aufgetreten");

        })
}