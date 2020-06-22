(function($) {
  "use strict";
  // TOP Menu Sticky
  $(window).on("scroll", function() {
    var scroll = $(window).scrollTop();
    if (scroll < 400) {
      $("#sticky-header").removeClass("sticky");
      $("#back-top").fadeIn(500);
    } else {
      $("#sticky-header").addClass("sticky");
      $("#back-top").fadeIn(500);
    }
  });

  $("#browse_job").click(function() {
    $([document.documentElement, document.body]).animate(
      {
        scrollTop: $("#job_listing").offset().top
      },
      500
    );
  });
  
  $("#browse_job1").click(function() {
	    $([document.documentElement, document.body]).animate(
	      {
	        scrollTop: $("#job_listing1").offset().top
	      },
	      500
	    );
	  });
  
  $(document).ready(function() {
    // mobile_menu
    var menu = $("ul#navigation");
    if (menu.length) {
      menu.slicknav({
        prependTo: ".mobile_menu",
        closedSymbol: "+",
        openedSymbol: "-"
      });
    }

    var slider = $(".slider_active");
    if (slider.length) {
      slider.owlCarousel({
        loop: true,
        margin: 0,
        items: 1,
        autoplay: true,
        navText: [
          '<i class="ti-angle-left"></i>',
          '<i class="ti-angle-right"></i>'
        ],
        nav: true,
        dots: false,
        autoplayHoverPause: true,
        autoplaySpeed: 800,
        responsive: {
          0: {
            items: 1,
            nav: false
          },
          767: {
            items: 1,
            nav: false
          },
          992: {
            items: 1,
            nav: false
          },
          1200: {
            items: 1,
            nav: false
          },
          1600: {
            items: 1,
            nav: true
          }
        }
      });
    }

    // review-active
    var testmonial = $(".testmonial_active");
    if (testmonial.length) {
      testmonial.owlCarousel({
        loop: true,
        margin: 0,
        autoplay: true,
        navText: [
          '<i class="ti-angle-left"></i>',
          '<i class="ti-angle-right"></i>'
        ],
        nav: true,
        dots: false,
        autoplayHoverPause: true,
        autoplaySpeed: 800,
        responsive: {
          0: {
            items: 1,
            dots: false,
            nav: false
          },
          767: {
            items: 1,
            dots: false,
            nav: false
          },
          992: {
            items: 1,
            nav: true
          },
          1200: {
            items: 1,
            nav: true
          },
          1500: {
            items: 1
          }
        }
      });
    }

    // review-active
    var candidate = $(".candidate_active");
    if (candidate.length) {
      candidate.owlCarousel({
        loop: true,
        margin: 30,
        autoplay: true,
        navText: [
          '<i class="ti-angle-left"></i>',
          '<i class="ti-angle-right"></i>'
        ],
        nav: true,
        dots: false,
        autoplayHoverPause: true,
        autoplaySpeed: 800,
        responsive: {
          0: {
            items: 1,
            dots: false,
            nav: false
          },
          767: {
            items: 3,
            dots: false,
            nav: false
          },
          992: {
            items: 4,
            nav: true
          },
          1200: {
            items: 4,
            nav: true
          },
          1500: {
            items: 4
          }
        }
      });
    }
  });
})(jQuery);
