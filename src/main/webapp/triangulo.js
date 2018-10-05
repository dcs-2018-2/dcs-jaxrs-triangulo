$(document).ready(function () {
    $('#verificar').click(function () {
        $.ajax({
            url: '',
            method: '',
            success: function (data) {
                
            },
            statusCode: {
                404: function (xhr) {
                    
                }
            }
        });
    });
});
