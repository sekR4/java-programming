function upload() {
    // Prototype
    // var fileinput = document.getElementById('finput');
    // var filename = fileinput.value;
    // alert("You chose " + filename)

    // real upload
    var imgcanvas = document.getElementById('canvas')
    var fileinput = document.getElementById('finput')
    var image = new SimpleImage(fileinput)
    image.drawTo(imgcanvas)
}
