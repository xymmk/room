
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
        $(this).find("label[for='name']").html('员工姓名');
        $(this).find("label[for='username']").html('用户名');
        $(this).find("label[for='password']").html('密码');
        ////
        var name = $(this).find('input#name').val();
        var username = $(this).find('input#username').val();
        var password = $(this).find('input#password').val();
        if(name == '') {
            $(this).find("label[for='name']").append("<span style='display:none' class='red'> - 请输入你的员工姓名.</span>");
            $(this).find("label[for='name'] span").fadeIn('medium');
            return false;
        }
        if(username == '') {
            $(this).find("label[for='username']").append("<span style='display:none' class='red'> - 请设置登陆的用户名.</span>");
            $(this).find("label[for='username'] span").fadeIn('medium');
            return false;
        }
        if(password == '') {
            $(this).find("label[for='password']").append("<span style='display:none' class='red'> - 请设置登陆的密码.</span>");
            $(this).find("label[for='password'] span").fadeIn('medium');
            return false;
        }

    });


});


