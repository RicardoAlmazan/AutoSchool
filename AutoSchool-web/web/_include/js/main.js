jQuery(function ($) {

    var TheReal = window.theReal || {};

    /* ==================================================
     Navegación Móvil
     ================================================== */
    var mobileMenuClone = $('#menu').clone().attr('id', 'navigation-mobile');

    TheReal.mobileNav = function () {
        var windowWidth = $(window).width();

        if (windowWidth <= 979) {
            if ($('#mobile-nav').length > 0) {
                mobileMenuClone.insertAfter('#menu');
                $('#navigation-mobile #menu-nav').attr('id', 'menu-nav-mobile');
            }
        } else {
            $('#navigation-mobile').css('display', 'none');
            if ($('#mobile-nav').hasClass('open')) {
                $('#mobile-nav').removeClass('open');
            }
        }
    }

    TheReal.listenerMenu = function () {
        $('#mobile-nav').on('click', function (e) {
            $(this).toggleClass('open');

            if ($('#mobile-nav').hasClass('open')) {
                $('#navigation-mobile').slideDown(500, 'easeOutExpo');
            } else {
                $('#navigation-mobile').slideUp(500, 'easeOutExpo');
            }
            e.preventDefault();
        });

        $('#menu-nav-mobile a').on('click', function () {
            $('#mobile-nav').removeClass('open');
            $('#navigation-mobile').slideUp(350, 'easeOutExpo');
        });
    }


    /* ==================================================
     Slider
     ================================================== */

    TheReal.slider = function () {
        $.supersized({
            // Funcionalidad
            slideshow: 1,
            autoplay: 1,
            start_slide: 1,
            stop_loop: 0,
            random: 0,
            slide_interval: 12000,
            transition: 1,
            transition_speed: 300,
            new_window: 1,
            pause_hover: 0,
            keyboard_nav: 1,
            performance: 1,
            image_protect: 1,
            // Tamaño y posición						   
            min_width: 0,
            min_height: 0,
            vertical_center: 1,
            horizontal_center: 1,
            fit_always: 0,
            fit_portrait: 1,
            fit_landscape: 0,
            // Componentes							
            slide_links: 'blank',
            thumb_links: 0,
            thumbnail_navigation: 0, // Thumbnail navigation
            slides: [// Imagenes
                {image: '_include/img/slider-images/image01.jpg', title: '<div class="slide-content">Techno - Dev</br>\n\
                                                </div>', thumb: '', url: ''},
                {image: '_include/img/slider-images/image02.jpg', title: '<div class="slide-content">Techno - Dev</br>\n\
                                                </div>', thumb: '', url: ''},
                {image: '_include/img/slider-images/image03.jpg', title: '<div class="slide-content">Techno - Dev</br>\n\
                                                </div>', thumb: '', url: ''}

            ],
            // Opciones de tema	
            progress_bar: 0, // Temporizador para cada slide
            mouse_scrub: 0

        });

    }


    /* ==================================================
     Navegación Fix
     ================================================== */

    TheReal.nav = function () {
        $('.sticky-nav').waypoint('sticky');
    }


    /* ==================================================
     Trabajos
     ================================================== */

    TheReal.filter = function () {
        if ($('#projects').length > 0) {
            var $container = $('#projects');

            $container.imagesLoaded(function () {
                $container.isotope({
                    // options
                    animationEngine: 'best-available',
                    itemSelector: '.item-thumbs',
                    layoutMode: 'fitRows'
                });
            });


            // Filtro click
            var $optionSets = $('#options .option-set'),
                    $optionLinks = $optionSets.find('a');

            $optionLinks.click(function () {
                var $this = $(this);

                if ($this.hasClass('selected')) {
                    return false;
                }
                var $optionSet = $this.parents('.option-set');
                $optionSet.find('.selected').removeClass('selected');
                $this.addClass('selected');


                var options = {},
                        key = $optionSet.attr('data-option-key'),
                        value = $this.attr('data-option-value');

                value = value === 'false' ? false : value;
                options[ key ] = value;
                if (key === 'layoutMode' && typeof changeLayoutMode === 'function') {

                    changeLayoutMode($this, options)
                } else {

                    $container.isotope(options);
                }

                return false;
            });
        }
    }


    /* ==================================================
     FancyBox
     ================================================== */

    TheReal.fancyBox = function () {
        if ($('.fancybox').length > 0 || $('.fancybox-media').length > 0 || $('.fancybox-various').length > 0) {

            $(".fancybox").fancybox({
                padding: 0,
                beforeShow: function () {
                    this.title = $(this.element).attr('title');
                    this.title = '<h4>' + this.title + '</h4>' + '<p>' + $(this.element).parent().find('img').attr('alt') + '</p>';
                },
                helpers: {
                    title: {type: 'inside'},
                }
            });

            $('.fancybox-media').fancybox({
                openEffect: 'none',
                closeEffect: 'none',
                helpers: {
                    media: {}
                }
            });
        }
    }


    /* ==================================================
     Contáctanos
     ================================================== */

    TheReal.contactForm = function () {
        $("#contact-submit").on('click', function () {
            $contact_form = $('#contact-form');

            var fields = $contact_form.serialize();

            $.ajax({
                type: "POST",
                url: "_include/php/contact.php",
                data: fields,
                dataType: 'json',
                success: function (response) {

                    if (response.status) {
                        $('#contact-form input').val('');
                        $('#contact-form textarea').val('');
                    }

                    $('#response').empty().html(response.html);
                }
            });
            return false;
        });
    }


    /* ==================================================
     Twitter Feed
     ================================================== */

    TheReal.tweetFeed = function () {

        var valueTop = -64; // Margin Top

        $("#ticker").tweet({
            modpath: '_include/js/twitter/',
            username: "The_Real_Techno",
            page: 1,
            avatar_size: 0,
            count: 10,
            template: "{text}{time}",
            filter: function (t) {
                return !/^@\w+/.test(t.tweet_raw_text);
            },
            loading_text: "loading ..."
        }).bind("loaded", function () {
            var ul = $(this).find(".tweet_list");
            var ticker = function () {
                setTimeout(function () {
                    ul.find('li:first').animate({marginTop: valueTop + 'px'}, 500, 'linear', function () {
                        $(this).detach().appendTo(ul).removeAttr('style');
                    });
                    ticker();
                }, 5000);
            };
            ticker();
        });

    }


    /* ==================================================
     Menú
     ================================================== */

    TheReal.menu = function () {
        $('#menu-nav, #menu-nav-mobile').onePageNav({
            currentClass: 'current',
            changeHash: false,
            scrollSpeed: 750,
            scrollOffset: 30,
            scrollThreshold: 0.5,
            easing: 'easeOutExpo',
            filter: ':not(.external)'
        });
    }

    /* ==================================================
     Siguiente sección.
     ================================================== */

    TheReal.goSection = function () {
        $('#nextsection').on('click', function () {
            $target = $($(this).attr('href')).offset().top - 30;

            $('body, html').animate({scrollTop: $target}, 750, 'easeOutExpo');
            return false;
        });
    }

    /* ==================================================
     GoUp
     ================================================== */

    TheReal.goUp = function () {
        $('#goUp').on('click', function () {
            $target = $($(this).attr('href')).offset().top - 30;

            $('body, html').animate({scrollTop: $target}, 750, 'easeOutExpo');
            return false;
        });
    }


    /* ==================================================
     Volver arriba
     ================================================== */

    TheReal.scrollToTop = function () {
        var windowWidth = $(window).width(),
                didScroll = false;

        var $arrow = $('#back-to-top');

        $arrow.click(function (e) {
            $('body,html').animate({scrollTop: "0"}, 750, 'easeOutExpo');
            e.preventDefault();
        })

        $(window).scroll(function () {
            didScroll = true;
        });

        setInterval(function () {
            if (didScroll) {
                didScroll = false;

                if ($(window).scrollTop() > 1000) {
                    $arrow.css('display', 'block');
                } else {
                    $arrow.css('display', 'none');
                }
            }
        }, 250);
    }

    /* ==================================================
     Redes sociales.
     ================================================== */

    TheReal.utils = function () {

        $('.item-thumbs').bind('touchstart', function () {
            $(".active").removeClass("active");
            $(this).addClass('active');
        });

        $('.image-wrap').bind('touchstart', function () {
            $(".active").removeClass("active");
            $(this).addClass('active');
        });

        $('#social ul li').bind('touchstart', function () {
            $(".active").removeClass("active");
            $(this).addClass('active');
        });

    }

    /* ==================================================
     Acordeon
     ================================================== */

    TheReal.accordion = function () {
        var accordion_trigger = $('.accordion-heading.accordionize');

        accordion_trigger.delegate('.accordion-toggle', 'click', function (event) {
            if ($(this).hasClass('active')) {
                $(this).removeClass('active');
                $(this).addClass('inactive');
            } else {
                accordion_trigger.find('.active').addClass('inactive');
                accordion_trigger.find('.active').removeClass('active');
                $(this).removeClass('inactive');
                $(this).addClass('active');
            }
            event.preventDefault();
        });
    }

    /* ==================================================
     Toggle
     ================================================== */

    TheReal.toggle = function () {
        var accordion_trigger_toggle = $('.accordion-heading.togglize');

        accordion_trigger_toggle.delegate('.accordion-toggle', 'click', function (event) {
            if ($(this).hasClass('active')) {
                $(this).removeClass('active');
                $(this).addClass('inactive');
            } else {
                $(this).removeClass('inactive');
                $(this).addClass('active');
            }
            event.preventDefault();
        });
    }

    /* ==================================================
     Tooltip
     ================================================== */

    TheReal.toolTip = function () {
        $('a[data-toggle=tooltip]').tooltip();
    }


    /* ==================================================
     Iniciar
     ================================================== */

    TheReal.slider();

    $(document).ready(function () {

        // Precargar
        $('body').jpreLoader({
            splashID: "#jSplash",
            showSplash: true,
            showPercentage: true,
            autoClose: true,
            splashFunction: function () {
                $('#circle').delay(250).animate({'opacity': 1}, 500, 'linear');
            }
        });

        TheReal.nav();
        TheReal.mobileNav();
        TheReal.listenerMenu();
        TheReal.menu();
        TheReal.goSection();
        TheReal.goUp();
        TheReal.filter();
        TheReal.fancyBox();
        TheReal.contactForm();
        TheReal.tweetFeed();
        TheReal.scrollToTop();
        TheReal.utils();
        TheReal.accordion();
        TheReal.toggle();
        TheReal.toolTip();
    });

    $(window).resize(function () {
        TheReal.mobileNav();
    });

});
