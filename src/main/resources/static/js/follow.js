$(document).ready(function() {
    var isFollowing = document.getElementById('isFl').value;
    if (isFollowing === 'true') {
        $('#Follow').hide();
        $('#unFollow').show();
    } else if(isFollowing === 'false'){
        $('#Follow').show();
        $('#unFollow').hide();
    } else if(isFollowing === 'nouser'){
        $('#Follow').show();
        $('#unFollow').hide();

    }
    $("#Follow").click(function(event){
            event.preventDefault();
            if(isFollowing === 'nouser'){
                window.location.href= '/login';
            }
    });
});

$(document).ready(function(){
    $("#Follow").click(function(event){
        event.preventDefault();
        var currentURL = window.location.href;
        var urlObject = new URL(currentURL);
        var movieId = urlObject.searchParams.get("id");
        $.ajax({
            type: 'POST',
            url: '/add-collection/' + movieId,
            contentType: 'application/json',
            success: function(data){
                $('#Follow').hide();
                $('#unFollow').show();
            },
            error: function(error){
                console.log(error)
            }
        });
    });
    $("#unFollow").click(function(event){
        event.preventDefault();
        var currentURL = window.location.href;
        var urlObject = new URL(currentURL);
        var movieId = urlObject.searchParams.get("id");
        $.ajax({
            type: 'POST',
            url: '/rmv-collection/' + movieId,
            contentType: 'application/json',
            success: function(data){
                $('#Follow').show();
                $('#unFollow').hide();
            },
            error: function(error){
                console.log(error)
            }
        });
    });
});