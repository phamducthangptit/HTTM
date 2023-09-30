document.getElementById('imageInput').addEventListener('change', function() {
    var selectedImage = document.getElementById('selectedImage');
    var file = this.files[0];
    if (file) {
        selectedImage.style.display = 'block';
        var reader = new FileReader();
        reader.onload = function(e) {
            selectedImage.src = e.target.result;
        }
        reader.readAsDataURL(file);
    }
});
