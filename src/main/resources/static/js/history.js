document.addEventListener('DOMContentLoaded', function() {
      const videoElement = document.getElementById('player');
      let watchedTime = 0;

    videoElement.addEventListener('timeupdate', function() {
    watchedTime = videoElement.currentTime;
  });

  window.addEventListener('beforeunload', function(event) {
        var currentURL = window.location.href;
        var urlObject = new URL(currentURL);
        var movieId = urlObject.searchParams.get("id");
        var episode = urlObject.searchParams.get("episode");
        if(episode === '') episode = 1;
        $.ajax({
            type: 'POST',
            url: '/save-history/' + movieId + '/' + episode + '/' + watchedTime,
            contentType: 'application/json',
            success: function(data){
            },
            error: function(error){
                console.log(error)
            }
        });

        event.preventDefault();
        event.returnValue = '';
  });
});
$(document).ready(function(){
        var currentURL = window.location.href;
        var urlObject = new URL(currentURL);
        var movieId = urlObject.searchParams.get("id");
        var episode = urlObject.searchParams.get("episode");
        if(episode === '') episode = 1;
        $.ajax({
            type: 'POST',
            url: '/find-history/' + movieId + '/' + episode,
            contentType: 'application/json',
            success: function(data){
                if(data === 0){
                    $('#popUp').modal('hide');
                } else{
                    var minute = Math.floor(data / 60);
                    var second = data - minute * 60;
                    $('#popUp .modal-body p').text('Last time you watched, you watched until ' + minute + ':' + second  + '. Do you want to continue watching?');
                    $('#popUp').modal('show');
                    $("#keepWatching").click(function(event){
                        var video = $('#player')[0];
                        $('#popUp').modal('hide');
                        video.currentTime = data;
                        $(video).on('canplay', function() {
                            video.play();
                        });
                    });
                    $("#close").click(function(event){
                        $.ajax({
                            type: 'POST',
                            url: '/delete-history/' + movieId + '/' + episode,
                            contentType: 'application/json',
                            success:function(data){
                            },
                            error: function(error){
                                console.log(error)
                            }
                        });
                    });
                }
            },
            error: function(error){
                console.log(error)
            }
        });
});
