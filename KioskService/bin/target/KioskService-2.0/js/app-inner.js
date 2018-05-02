
function makeNewPosition() {



    // Get viewport dimensions (remove the dimension of the div)

    var h = $(window).height() - 270;

    var w = $(window).width() - 270;



    var nh = Math.floor(Math.random() * h);

    var nw = Math.floor(Math.random() * w);



    return [nh, nw];



}




function calcSpeed(prev, next) {



    var x = Math.abs(prev[1] - next[1]);

    var y = Math.abs(prev[0] - next[0]);



    var greatest = x > y ? x : y;



    var speedModifier = 0.1;



    var speed = Math.ceil(greatest / speedModifier);



    return speed;



}





/* Slide out */



$(document).ready(function() {



    $('a.panel').click(function () {



        $('a.panel').removeClass('selected');

        $(this).addClass('selected');

        

        current = $(this);

        

        $('#wrapper').scrollTo($(this).attr('href'), 800);      

        

        return false;

    });



    $(window).resize(function () {

        resizePanel();

    });



    $(".innercartoon").click(function(e) {

        $(".bubble").slideToggle("slow");

        e.preventDefault();

    });



  
    

    

});



function resizePanel() {



    width = $(window).width();

    height = $(window).height();



    mask_width = width * $('.item').length;

        

    $('#debug').html(width  + ' ' + height + ' ' + mask_width);

        

    $('#wrapper, .item').css({width: width, height: height});

    $('#mask').css({width: mask_width, height: height});

    $('#wrapper').scrollTo($('a.selected').attr('href'), 0);

        

}
$(document).ready(function () {

    $(".regular").slick({
        dots: false,
        infinite: true,
        slidesToShow: 4,
        slidesToScroll: 4
    });


    $(".showone").slick({
        dots: false,
        infinite: true,
        slidesToShow: 1,
        slidesToScroll: 1
    });


});
