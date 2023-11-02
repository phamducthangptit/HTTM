// Lấy tất cả các phần tử li có class là icon_archive_alt
var lis = document.querySelectorAll("li.icon_archive_alt");
var selected = []; // dùng để lấy ra danh sách các nút được chọn
var id;
// Duyệt qua từng phần tử li
for (var i = 0; i < lis.length; i++) {
  // Lấy phần tử li hiện tại
  var li = lis[i];

  // Thêm sự kiện click cho phần tử li
  li.addEventListener("click", function() {
    // Lấy phần tử con a của li
    var a = this.querySelector("a");
    // Lấy giá trị của thuộc tính href của a
    var href = a.getAttribute("href");
    var query = href.split("?")[1];

    // Tách query theo dấu & và lấy phần đầu tiên
    var param = query.split("&")[0];

    // Tách param theo dấu = và lấy phần thứ hai
    id = param.split("=")[1];
    // In ra đường link trên console
    console.log(href);
    $.ajax({
        type: 'POST',
        url: '/find-episode-delete-movie/' + id,
        contentType: 'application/json',
        success: function(data){
            if(data.length != 0){ // neeus có nhiều hơn 1 tập thì xử lí xóa
                $('#popUp').modal('show');
                selected = []
                createButtons(data);
            } else { // chưa có tập nào thì xóa phim
                $('#popUp1').modal('show');
                $("#deleteEpisodeMovie1").click(function(event){
                    $('#popUp1').modal('hide');
                    $.ajax({
                        type: 'POST',
                        url : '/delete-movie/' + id,
                        contentType: 'application/json',
                        success: function(data){
                            window.location.href = window.location.href; // load lai trang
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
}

// Hàm này sẽ tạo các nút bấm từ 1 đến data
function createButtons(data) {

  // Lấy phần tử div có id là modal-body
  var modalBody = document.getElementById("modal-body");

  // Xóa nội dung cũ của modal-body
  modalBody.innerHTML = "";

  // Duyệt qua từng số từ 1 đến data
  for (var i = 0; i < data.length; i++) {
    // Tạo một phần tử button mới
    let button = document.createElement("button");

    // Gán giá trị và nội dung cho button là số i
    button.value = data[i];
    button.textContent = "Tập " + data[i];
    button.setAttribute("class", "site-btn");
    button.setAttribute("style", "margin: 10px;");
    button.setAttribute("name", "name");
    // Thêm sự kiện click cho button
    button.addEventListener("click", function() {
      // In ra giá trị của button trên console
      console.log(this.value);
      this.style.setProperty("background", "black");
      selected.push(button.value);
    });
    // Thêm button vào modal-body
    modalBody.appendChild(button);
  }
}

$("#deleteEpisodeMovie").click(function(event){
    $('#popUp').modal('hide');
    if(selected.length > 0){ // nếu đã chọn 1 trong những nút bất kì
        $.ajax({
            type: 'POST',
            url: '/delete-episode/' + id,
            data: JSON.stringify(selected),
            contentType: 'application/json',
            dataType: "json",
            success: function(data){
                window.location.href = window.location.href; // load lai trang
            },
            error: function(error){
                console.log(error)
            }
        });
    }
});
