//try to import
// const myModule = require('/Users/krauss/projects/work/coursera/java-programming/cs101/SimpleImage.js');

// import ".cs101/SimpleImage.js"

// Some notes
var x = 3
var y = x*x

function print(x) {
    console.log(x);
}

function square(x) {
    return x*x
}

// print(square(5))

for (var x of [1,2,3]) {
    print(square(x))
}

// Course try to make pxls yellow
// https://www.coursera.org/learn/duke-programming-web/supplement/XwS1Y/try-it-using-for-loops
var img = new SimpleImage(200,200);

function makeGreen(img) {
    for (var pixel of img.values()) {
        pixel.setGreen(255)
        pixel.setRed(255)
    }
}

function makeMagenta(img) {
    for (var pixel of img.values()) {
        pixel.setRed(255)
        pixel.setGreen(0)
        pixel.setBlue(255)
    }
}

// print(img);

makeGreen(img)

print(img);

makeMagenta(img)

print(img)


// Das hier funktioniert auch. Verstehe nicht warum meins vorhin nicht ging
var yellowImg = new SimpleImage (200,200);
print(yellowImg);

for (var pixel of yellowImg.values()){
    var newR = 255-pixel.getRed();
    pixel.setRed(newR);
    var newG = 255-pixel.getGreen();
    pixel.setGreen(newG);
}

print(yellowImg);

// Mein Code funktionierte anfangs nicht, da ich img.getGreen() probierte anstatt
// pixel.getGreen()
