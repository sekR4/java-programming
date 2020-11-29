function someConditions(x) {
    if (x > 0) {
        console.log("I feel good :).");
    } else {
        console.log("I feel bad :)");
    }
}

someConditions(1)
someConditions(-3)

// https://www.coursera.org/learn/duke-programming-web/supplement/xApiL/programming-exercise-modifying-images

// PART I

var img = new SimpleImage("hilton.jpg")

function make_red(img) {
    for (var pixel of img.values()) {
        if (pixel.getX() < img.getWidth()/3) {
            pixel.setRed(255)
        }
    }
}

function make_green(img) {
    for (var pixel of img.values()) {
        if (pixel.getX() > img.getWidth()/3 && pixel.getX() < img.getWidth()*(2/3)) {
            pixel.setGreen(255)
        }
    }
}

function make_blue(img) {
    for (var pixel of img.values()) {
        if (pixel.getX() > img.getWidth()*(2/3)) {
            pixel.setBlue(255)
        }
    }
}


make_red(img)
make_green(img)
make_blue(img)

print(img)

// PART I official solution:
var img = new SimpleImage("hilton.jpg")

w = img.getWidth();

for (var pixel of img.values()) {
     x = pixel.getX();
     if (x < w/3) {
          pixel.setRed(255);
     }
     if (x >= w/3 && x < 2*w/3) {
          pixel.setGreen(255);
     }
     if (x >= 2*w/3 && x <= w) {
          pixel.setBlue(255);
     }
}
print(img)
// PART II

var img = new SimpleImage("eastereggs.jpg")

print(img)

function swapRedGreen(img) {
    for (var pixel of img.values()) {
        var oldRed = pixel.getRed();
        pixel.setRed(pixel.getGreen());
        pixel.setGreen(oldRed);
    }
}

swapRedGreen(img)
print(img)

// PART III
var img = new SimpleImage("duke_blue_devil.png")

function make_the_devil_yellow(img) {
    for (var pixel of img.values()) {
        // find blue
        if ((pixel.getRed()===0) && (pixel.getGreen()==51) && (pixel.getBlue()==227)) {
            // change to yellow
            pixel.setRed(255);
            pixel.setGreen(255);
            pixel.setBlue(0);
        }
    }

}
make_the_devil_yellow(img)
print(img)
