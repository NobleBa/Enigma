$(document).ready(function() {
    $('#charadeForm1').submit(function(event) {
        event.preventDefault();
        var inputSolution1 = $('input[name="inputSolution1"]').val();
        var charadeId1 = $('input[name="charadeId1"]').val();
        inputSolution1 = removeSpecialChars(inputSolution1.trim().toUpperCase());
        $.ajax({
            type: 'POST',
            url: '/checkSolution',
            data: { inputSolution: inputSolution1, charadeId: charadeId1 },
            success: function(response) {
                $('#message1').text(response.message);
            }
        });
    });
    $('#charadeForm2').submit(function(event) {
        event.preventDefault();
        var inputSolution2 = $('input[name="inputSolution2"]').val();
        var charadeId2 = $('input[name="charadeId2"]').val();
        inputSolution2 = removeSpecialChars(inputSolution2.trim().toUpperCase());
        $.ajax({
            type: 'POST',
            url: '/checkSolution',
            data: { inputSolution: inputSolution2, charadeId: charadeId2 },
            success: function(response) {
                $('#message2').text(response.message);
            }
        });
    });
    $('#charadeForm3').submit(function(event) {
        event.preventDefault();
        var inputSolution3 = $('input[name="inputSolution3"]').val();
        var charadeId3 = $('input[name="charadeId3"]').val();
        inputSolution3 = removeSpecialChars(inputSolution3.trim().toUpperCase());
        $.ajax({
            type: 'POST',
            url: '/checkSolution',
            data: { inputSolution: inputSolution3, charadeId: charadeId3 },
            success: function(response) {
                $('#message3').text(response.message);
            }
        });
    });
});

function removeSpecialChars(text) {
    return text.normalize("NFD").replace(/[\u0300-\u036f]/g, "").replace(/-/g, '');
}