
jQuery(document).ready(function() {

    /*
        Background slideshow
    */
    $.backstretch([
      "img/backgrounds/1.jpg"
    , "img/backgrounds/2.jpg"
    , "img/backgrounds/3.jpg"
    ], {duration: 3000, fade: 750});

    /*
        Tooltips
    */
    $('.links a.home').tooltip();
    $('.links a.blog').tooltip();

    /*
        Form validation
    */
    $('.register form').submit(function(){
        $(this).find("label[for='name']").html('Ա������');
        $(this).find("label[for='username']").html('�û���');
        $(this).find("label[for='password']").html('����');
        ////
        var name = $(this).find('input#name').val();
        var username = $(this).find('input#username').val();
        var password = $(this).find('input#password').val();
        if(name == '') {
            $(this).find("label[for='name']").append("<span style='display:none' class='red'> - ���������Ա������.</span>");
            $(this).find("label[for='name'] span").fadeIn('medium');
            return false;
        }
        if(username == '') {
            $(this).find("label[for='username']").append("<span style='display:none' class='red'> - �����õ�½���û���.</span>");
            $(this).find("label[for='username'] span").fadeIn('medium');
            return false;
        }
        if(password == '') {
            $(this).find("label[for='password']").append("<span style='display:none' class='red'> - �����õ�½������.</span>");
            $(this).find("label[for='password'] span").fadeIn('medium');
            return false;
        }

    });


});


