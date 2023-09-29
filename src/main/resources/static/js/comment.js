const textarea = document.getElementById('txtComment');
const submitButton = document.getElementById('newComment');

                // Sử dụng sự kiện 'input' để kiểm tra khi có thay đổi trong textarea
textarea.addEventListener('input', function() {
                    // Kiểm tra nếu textarea không trống thì bật nút submit, ngược lại tắt nút submit
      if (textarea.value.trim() !== '') {
         submitButton.removeAttribute('disabled');
      } else {
         submitButton.setAttribute('disabled', 'disabled');
      }
});

$(document).ready(function () {

             var comment = {};
             $('#newComment').click(function (e) {
                 e.preventDefault();
                 var queryString = window.location.search;
                 var urlParams = new URLSearchParams(queryString);
                 var id = urlParams.get('id');
                 var ratingContainer = document.querySelector('.rating');
                 comment.movie_id = id;
                 comment.comment = $('#txtComment').val();
                 comment.value = $('#ratingValue').val();
                 var bookJSON = JSON.stringify(comment);
                 $.ajax({
                     url: 'http://localhost:8080/movie/CMApi?id=1',
                     method: 'POST',
                     data: bookJSON,
                     contentType: "application/json; charset=utf-8",
                     success: function () {
                         //alert('Saved successfully!');
                         console.log(comment);
                     },
                     error: function (error) {
                         alert(error);
                     }
                 })
             })
         });

        $(document).ready(function() {
            var currentPage = parseInt($("#currentPage").val());
            $(document).on("click", "a.page1", function(e) {

                var newValue = parseInt($(this).data("value"));
                currentPage = newValue;

                var page = $(this).data("value");
                var dataFromModel =document.getElementById('totalPageEl').getAttribute('data-value');
                var urlSearchParams = new URLSearchParams(window.location.search);
                var id = urlSearchParams.get("id");
                alert(dataFromModel);

                buildPagination(currentPage, dataFromModel);
                refreshComments(id,currentPage*6,6);
                $("#currentPage").val(currentPage);
                if (page !== undefined) {
                    e.preventDefault();
                }
            });
    });


        function refreshComments(id,start,size) {

            $.ajax({
                url: "http://localhost:8080/movie/CMApi?id="+id+"&start="+start+"&size="+size, // Thay thế bằng URL thực tế của API bạn muốn truy cập
                method: 'GET',
                dataType: 'json',
                success: function(data) {
                    // Xử lý dữ liệu từ API và hiển thị dưới dạng danh sách bình luận
                    $("#commentList").empty();

                    console.log(data)
                    // Duyệt qua danh sách bình luận và tạo các phần tử HTML tương ứng
                    $.each(data,function(index,comment) {
                        var commentItem = $('<div class="anime__review__item">');
                        commentItem.html('<div class="anime__review__item__pic">' +
                            '<img src="../img/user/' + comment.avatar + '" alt=""></div>' +
                            '<div class="anime__review__item__text"><h6>' + comment.name + ' - <span>' + comment.day_cm + '</span>' +
                            '<div class="rating">' + generateStars(comment.value) + '</div></h6>' +
                            '<p>' + comment.comment + '</p></div>');

                        // Thêm phần tử bình luận vào danh sách
                        $("#commentList").append(commentItem);
                    });
                },
                error: function() {
                    // Xử lý lỗi nếu có
                    var commentListContainer = $('#commentList');
                    commentListContainer.empty();
                    commentListContainer.text('Lỗi khi truy cập API.');
                }
            });
        }
         function buildPagination(currentPage, totalPage) {

            var paginationContainer = $("#paginationContainer");

            paginationContainer.empty();

            var previousLink = $('<a>');
            previousLink.attr('class', currentPage == 0 ? 'disabled' : 'page1');
            previousLink.attr('data-value', currentPage - 1);
            previousLink.html('<i class="fa fa-angle-double-left"></i>');
            paginationContainer.append(previousLink);
            if (currentPage > 1) {
                var dot1 = $('<a>');
                dot1.attr('class', 'page1');
                dot1.attr('data-value', 1);
                dot1.attr('href', 'javascript:void(0);');
                dot1.html('1');
                paginationContainer.append(dot1);
                var dots = $('<a>');
                dot2.attr('class', 'disabled');
                dot2.html('...');
                paginationContainer.append(dot2);
            }

            var startPage = (currentPage - 1 > 0) ? currentPage - 1: 0;
            var endPage = (totalPage - 1 > currentPage +1 )? currentPage+1 : totalPage -1;
            for (var i = startPage; i <= endPage; i++) {
                var tmp = $('<div>');
                var pageLink = $('<a>');
                pageLink.attr('class', currentPage == i ? 'current-page page1' : 'page1');
                pageLink.attr('data-value', i);
                pageLink.attr('href', 'javascript:void(0);');
                pageLink.html(i + 1);

                // Thêm nút phân trang vào container
                tmp.append(pageLink);
                paginationContainer.append(tmp);
            }
            if (currentPage < totalPage - 2) {
                var dot2 = $('<a>');
                dot2.attr('class', 'disabled');
                dot2.html('...');
                paginationContainer.append(dot2);
                var dot1 = $('<a>');
                dot1.attr('class', 'page1');
                dot1.attr('data-value', totalPage-1);
                dot1.attr('href', 'javascript:void(0);');
                dot1.html(totalPage);
                paginationContainer.append(dot1);

            }
            var afterLink = $('<a>');
            afterLink.attr('class', currentPage == totalPage - 1 ? 'disabled' : 'page1');
            afterLink.attr('data-value', currentPage + 1);
            afterLink.html('<i class="fa fa-angle-double-right"></i>');
            paginationContainer.append(afterLink);
        }
        function generateStars(rating) {
            var stars = '';
            var fullStars = Math.floor(rating);

            for (var i = 0; i < fullStars; i++) {
                stars += '<a href="javascript:void(0);"><i class="fa fa-star"></i></a>';
            }

            for (var i =fullStars ; i < 5; i++) {
                stars += '<a href="javascript:void(0);"><i class="fa fa-star-o"></i></a>';
            }

            return stars;
}

const stars = document.querySelectorAll('.star1');
        const ratingContainer = document.querySelector('.rating1');

        stars.forEach(star => {
            star.addEventListener('click', () => {
                const value = parseInt(star.getAttribute('data-value'));
                    //ratingInput.value = value;
                    const inputElement = document.getElementById('ratingValue'); // Thay 'yourInputId' bằng ID thật của ô input
                    inputElement.value = value;
                // Chuyển các ngôi sao trước đó thành 'fa-star'
                stars.forEach(prevStar => {
                    const prevValue = parseInt(prevStar.getAttribute('data-value'));
                    const icon = prevStar.querySelector('i');
                    if (prevValue <= value) {
                        icon.classList.remove('fa-star-o');
                        icon.classList.add('fa-star');
                    } else {
                        icon.classList.remove('fa-star');
                        icon.classList.add('fa-star-o');
                    }
                });

                // Lưu giá trị vào thuộc tính 'data-rating' của container
                //ratingContainer.setAttribute('data-rating', value);
            });
        });
