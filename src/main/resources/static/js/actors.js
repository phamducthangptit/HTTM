var name;
var gender;
var birthday;
var country;
var describe;
var image;

$(document).ready(function() {
            $(".update").click(function() {
                var id =  parseInt($(this).data("value"));
                            //console.log(id);
                getActorInfo(id);
                console.log(name);
                $(".update-actor").fadeIn(300); // Hiển thị form

            });
            $("#add-close-switch").click(function() {
                $(".update-actor").fadeOut(300); // Ẩn form
            });

            $("#add-ep-form").submit(function(e){
                 e.preventDefault();
                 var name1 = document.getElementById('nameActor').value;

                 var birthday1 = document.getElementById('birthdayActor').value;
                 var country1 = document.getElementById('countryActor').value;
                 var describe1 = document.getElementById('describeActor').value;
                 var image1 = $("#imageFile")[0].files[0];
                 var gender1 = $('input[name="gender"]:checked').val();
                 var formData = new FormData(this);
                 if (name == name1 && birthday == birthday1 && country == country1 && describe == describe1 && gender == gender1 && image1 == undefined) {
                    console.log("Bạn chưa thay đổi gì");
                    alert("Bạn chưa thay đổi thông tin diễn viên.")
                 } else {
                    console.log("Bạn đã thay đổi");

                    console.log(formData);

                     $.ajax({
                         url: 'http://localhost:8080/actors/postAPI',
                         method: 'POST',
                         data: formData,
                         contentType: false,
                         processData: false,
                         success: function (data) {
                            if (data == 1) {
                                location.reload(true);
                            }
                         },
                         error: function (error) {
                             console.log(error);
                         }
                     })
                    console.log(image1);
                 }

            });
        });
function getActorInfo(id) {

            $.ajax({
                url: "http://localhost:8080/actors/getAPI?id="+id, // Thay thế bằng URL thực tế của API bạn muốn truy cập
                method: 'GET',
                dataType: 'json',
                success: function(data) {
                    document.getElementById('idActor').setAttribute('value', data.person_id);
                    document.getElementById('nameActor').setAttribute('value', data.name_actor);

                    console.log(data.person_id);
                    if (data.gender == 0) {
                        document.getElementById('male').setAttribute('checked', true);
                    }
                    if (data.gender == 1) {
                        document.getElementById('female').setAttribute('checked', true);
                    }
                    document.getElementById('birthdayActor').setAttribute('value', data.day_of_birth);
                    document.getElementById('countryActor').setAttribute('value', data.name_country);
                    document.getElementById('describeActor').setAttribute('value', data.describe);
                    document.getElementById('imageName').setAttribute('value', data.image);
                    document.getElementById('imagePreview').style.backgroundImage = 'url(' + '../../img/actors/'+data.image + ')';
                    name = document.getElementById('nameActor').getAttribute('value');
                    birthday = document.getElementById('birthdayActor').getAttribute('value');
                    country = document.getElementById('countryActor').getAttribute('value');
                    describe = document.getElementById('describeActor').getAttribute('value');
                    gender = $('input[name="gender"]:checked').val();

                },
                error: function() {

                }
            });
}

function previewImage(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();

            reader.onload = function(e) {
                // Đặt hình ảnh xem trước vào phần tử có id là "imagePreview"
                document.getElementById('imagePreview').style.backgroundImage = 'url(' + e.target.result + ')';
            }

            reader.readAsDataURL(input.files[0]); // Đọc dữ liệu hình ảnh dưới dạng URL
        }
    }

