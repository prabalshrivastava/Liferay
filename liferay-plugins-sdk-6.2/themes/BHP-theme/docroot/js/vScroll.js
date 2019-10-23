var scrollY = 0;
var distance = 21;
var speed = 4;
var lastPos;
var scrollPos;


function autoScrollTo(el) {
    var targ = document.getElementById(el);
    scrollPos = window.pageYOffset;
    var targetPos = document.getElementById(el).offsetTop;
    console.log(targ);
    toggleClass(targ, 'activePanel');


    if (scrollPos < targetPos) {
        scrollDown(el);
    } else {

        scrollUp(el);
    }
}

function scrollDown(el) {
    var currentY = window.pageYOffset;
    var targetY = document.getElementById(el).offsetTop;
    var animator = setTimeout('scrollDown(\'' + el + '\')', speed);

    console.log('CurrentY: ' + currentY);
    if (currentY < targetY && lastPos != currentY) {

        scrollY = currentY + distance;
        window.scroll(0, scrollY);

    } else {
        console.log('CurrentY: ' + currentY + ' -- STOP' + 'Target: ' + targetY);
        clearTimeout(animator);

    }


}

function scrollUp(el) {
    var currentY = window.pageYOffset;
    var targetY = document.getElementById(el).offsetTop;
    var animator = setTimeout('scrollUp(\'' + el + '\')', speed);

    console.log('CurrentY: ' + currentY);
    if (currentY > targetY && lastPos != currentY) {

        scrollY = currentY - distance;
        window.scroll(0, scrollY);

    } else {
        console.log('CurrentY: ' + currentY + ' -- STOP' + 'Target: ' + targetY);
        clearTimeout(animator);

    }


}

function back(el) {
    var currentY = window.pageYOffset;
    var targetY = document.getElementById(el).offsetTop;
    var animator = setTimeout('back(\'' + el + '\')', speed);

    console.log('CurrentY: ' + currentY);
    if (currentY > targetY && lastPos != currentY) {

        scrollY = currentY - distance;
        window.scroll(0, scrollY);

    } else {
        console.log('CurrentY: ' + currentY + ' -- STOP' + 'Target: ' + targetY);
        clearTimeout(animator);

    }

}
