


//TEXT EFFECTS

 var TxtRotate = function(el, toRotate, period) {
            this.toRotate = toRotate;
            this.el = el;
            this.loopNum = 0;
            this.period = parseInt(period, 10) || 2000;
            this.txt = '';
            this.tick();
            this.isDeleting = false;
        };

        TxtRotate.prototype.tick = function() {
            var i = this.loopNum % this.toRotate.length;
            var fullTxt = this.toRotate[i];

            if (this.isDeleting) {
                this.txt = fullTxt.substring(0, this.txt.length - 1);
            } else {
                this.txt = fullTxt.substring(0, this.txt.length + 1);
            }

            this.el.innerHTML = '<span class="wrap">' + this.txt + '</span>';

            var that = this;
            var delta = 300 - Math.random() * 100;

            if (this.isDeleting) {
                delta /= 2;
            }

            if (!this.isDeleting && this.txt === fullTxt) {
                delta = this.period;
                this.isDeleting = true;
            } else if (this.isDeleting && this.txt === '') {
                this.isDeleting = false;
                this.loopNum++;
                delta = 500;
            }

            setTimeout(function() {
                that.tick();
            }, delta);
        };

        window.onload = function() {
            var elements = document.getElementsByClassName('txt-rotate');
            for (var i = 0; i < elements.length; i++) {
                var toRotate = elements[i].getAttribute('data-rotate');
                var period = elements[i].getAttribute('data-period');
                if (toRotate) {
                    new TxtRotate(elements[i], JSON.parse(toRotate), period);
                }
            }
            // INJECT CSS
            var css = document.createElement("style");
            css.type = "text/css";
            css.innerHTML = ".txt-rotate > .wrap { border-right: 0.05em solid #ffc200;  }";
            document.body.appendChild(css);
        };







//OBJECT FIT

if ('objectFit' in document.documentElement.style === false) {
    document.addEventListener('DOMContentLoaded', function() {
        Array.prototype.forEach.call(document.querySelectorAll('img[data-object-fit]'), function(image) {
            (image.runtimeStyle || image.style).background = 'url("' + image.src + '") no-repeat 50%/' + (image.currentStyle ? image.currentStyle['object-fit'] : image.getAttribute('data-object-fit'));

            image.src = 'data:image/svg+xml,%3Csvg xmlns=\'http://www.w3.org/2000/svg\' width=\'' + image.width + '\' height=\'' + image.height + '\'%3E%3C/svg%3E';
        });
    });
}

//MOBILE NINJA SLIDER


//MOBILE VIEW SLIDER



//SLIDER
    (function() {
        var bannerImg = document.querySelectorAll('#panel2slider li'),
            btLeft = document.querySelector('#left'),
            btRight = document.querySelector('#right'),
            currentImg = 0;

        function initBanner() {
            resetBanner();

            bannerImg[0].style.display = 'block';
        }

        btLeft.addEventListener('click', function() {
            if (currentImg === 0) {
                currentImg = bannerImg.length;
            }

            toLeft();
        }, false);

        btRight.addEventListener('click', function() {
            if (currentImg === bannerImg.length - 1) {
                currentImg = -1;
            }

            toRight();
        }, false);

        function toLeft(operation) {
            resetBanner();
            bannerImg[currentImg - 1].style.display = 'block';
            currentImg--;
        }

        function toRight() {
            resetBanner();
            bannerImg[currentImg + 1].style.display = 'block';
            currentImg++;
        }

        function resetBanner() {
            for (var i = 0; i < bannerImg.length; i++) {
                bannerImg[i].style.display = 'none';
            }
        }

        initBanner();
    })();

    //SLIDER2

     (function() {
        var bannerSlide = document.querySelectorAll('#panel3slider li'),
            arLeft = document.querySelector('#left1'),
            arRight = document.querySelector('#right1'),
            currentSlide = 0;

        function initSlide() {
            resetSlide();

            bannerSlide[0].style.display = 'block';
        }

        arLeft.addEventListener('click', function() {
            if (currentSlide === 0) {
                currentSlide = bannerSlide.length;
            }

            toLeft();
        }, false);

        arRight.addEventListener('click', function() {
            if (currentSlide === bannerSlide.length - 1) {
                currentSlide = -1;
            }

            toRight();
        }, false);

        function toLeft(operation) {
            resetSlide();
            bannerSlide[currentSlide - 1].style.display = 'block';
            currentSlide--;
        }

        function toRight() {
            resetSlide();
            bannerSlide[currentSlide + 1].style.display = 'block';
            currentSlide++;
        }

        function resetSlide() {
            for (var i = 0; i < bannerSlide.length; i++) {
                bannerSlide[i].style.display = 'none';
            }
        }

        initSlide();
    })();

