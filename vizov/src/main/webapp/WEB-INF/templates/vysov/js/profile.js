$(document).ready(function () {

function successCallback(response) {
    var user = response;
        $('#username').text(user.userName + ' [Comrade]');

        response.completedChallenges.forEach(challenge => {

            if (challenge.id < 4) {
                $('#level1-list').append("<li>" + challenge + "</li>");
            }

            if (challenge.id > 3 && challenge.id < 8) {
                $('#level2-list').append("<li>" + challenge + "</li>");
            }

            if (challenge.id > 7) {
                $('#level3-list').append("<li>" + challenge + "</li>");
            }


        });
}

function errorCallback(request, status, error) {
   console.log("not ok")
}

// perform an ajax http get request
$.ajax({
    url: 'http://localhost:8080/vizov/api/profile/1',
    async: true,
    success: successCallback,
    error: errorCallback
});
});