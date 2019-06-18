$(document).ready(function () {

    //가입 조건 모두 1이어야 submit전송
    var restric = {
        userId: 0,
        userPw: 0,
        userPw2: 0,
        name: 0,
        y: 0,
        gender: 0,
        telNum: 0,
        email: 1
    };

    //1월부터 12월 option 생성
    for (var i = 1; i <= 12; i++) {
        $('#m').append('<option>' + i + '</option>')
    }

    //누르면 초록색 테두리 생기는거
    $('.input').focus(function () {
        $(this).closest('.inputBox').css('border-color', '#08a600');
    });
    $('.input').focusout(function () {
        $(this).closest('.inputBox').css('border-color', '#dadada');
    });

    //필수 정보입니다 표시해주는거
    $('.necessary').focusout(function () {
        if ($(this).val().length < 1) {
            $(this).closest('.h4_content').find('h4').html('필수 정보입니다.').css('color', 'red');
            restric[$(this).attr('id')] = 0;
        };
    });
    //아이디 유효성 검증
    $('#userId').focusout(function () {
        //5~20자의 영문 소문자, 숫자와 특수기호(_),(-)만 사용 가능합니다.
        var pattern = /[a-z0-9_-]{5,20}/;
        if ($(this).val().length > 0) {
            if (pattern.test($(this).val()) && $(this).val().length < 21) {
                $(this).closest('.h4_content').find('h4').html('멋진 아이디네요!').css('color', '#08A600');
                restric[$(this).attr('id')] = 1;
            } else {
                $(this).closest('.h4_content').find('h4').html('5~20자의 영문 소문자, 숫자와 특수기호(_),(-)만 사용 가능합니다.').css('color', 'red');
                restric[$(this).attr('id')] = 0;
            };
        };
    });
    //비밀번호 유효성 검증
    $('#userPw').focusout(function () {
        //8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.
        var pattern = /([^\s\w]|[A-z0-9]){8,16}/;
        if ($(this).val().length > 0) {
            if (pattern.test($(this).val()) && $(this).val().length < 17) {
                $(this).closest('.h4_content').find('h4').html('');
                $('.pwimg').addClass('changed');
                $('#pwtext').html('안전').css('display', 'block').css('color', '#08A600');
                restric[$(this).attr('id')] = 1;
            } else {
                $(this).closest('.h4_content').find('h4').html('8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.').css('color', 'red');
                $('.pwimg').removeClass('changed').addClass('error');
                $('#pwtext').html('사용불가').css('display', 'block').css('color', 'red');
                restric[$(this).attr('id')] = 0;
            };
        } else {
            $('.pwimg').removeClass('changed').removeClass('error');
            $('#pwtext').css('display', 'none');
            restric[$(this).attr('id')] = 0;
        }
    });
    //비밀번호 재확인
    $('#userPw2').focusout(function () {
        if ($(this).val() == $('#userPw').val()) {
            $('.pwimg2').addClass('changed2');
            $(this).closest('.h4_content').find('h4').html('');
            restric[$(this).attr('id')] = 1;
        } else {
            $('.pwimg2').removeClass('changed2');
            $(this).val('');
            $(this).closest('.h4_content').find('h4').html('비밀번호가 일치하지 않습니다.').css('color', 'red');
            restric[$(this).attr('id')] = 0;
        }

    });
    //이름
    $('#name').focusout(function () {
        //한글과 영문 대 소문자를 사용하세요. (특수기호, 공백 사용 불가)
        var pattern = /[^가-힣A-z]/g;
        if ($(this).val().length > 0) {
            if (!pattern.test($(this).val())) {
                $(this).closest('.h4_content').find('h4').html('').css('color', '#08A600');
                restric[$(this).attr('id')] = 1;
            } else {
                $(this).closest('.h4_content').find('h4').html('한글과 영문 대 소문자를 사용하세요. (특수기호, 공백 사용 불가)').css('color', 'red');
                restric[$(this).attr('id')] = 0;
            };
        };
    });
    //생년월일
    $('#y,#m,#d').focusout(function () {
        //한글과 영문 대 소문자를 사용하세요. (특수기호, 공백 사용 불가)
        var patternY = /[^0-9]/g;
        if ($('#y').val().length == 4) {
            if (!patternY.test($('#y').val())) {
                if (!patternY.test($('#d').val()) && $('#d').val().length > 0) {
                    if ($('#m').val().length > 0) {
                        $(this).closest('.h4_content').find('h4').html('').css('color', '#08A600');
                        restric['y'] = 1;
                    } else {
                        $(this).closest('.h4_content').find('h4').html('생년월일을 다시 확인해주세요.').css('color', 'red');
                        restric['y'] = 0;
                    }
                } else {
                    $(this).closest('.h4_content').find('h4').html('태어난 일(날짜) 2자리를 정확하게 입력하세요.').css('color', 'red');
                    restric['y'] = 0;
                }

            } else {
                $(this).closest('.h4_content').find('h4').html('태어난 년도 4자리를 정확하게 입력하세요.').css('color', 'red');
                restric['y'] = 0;
            };
        } else {
            $(this).closest('.h4_content').find('h4').html('태어난 년도 4자리를 정확하게 입력하세요.').css('color', 'red');
            restric['y'] = 0;
        }
    });
    //성별
    $('#gender').focusout(function () {
        if ($(this).val().length > 0) {
            $(this).closest('.h4_content').find('h4').html('').css('color', '#08A600');
            restric[$(this).attr('id')] = 1;
        }
    });
    //이메일
    $('#email').focusout(function () {
        //이메일 정규식
        var pattern = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
        if ($(this).val().length > 0) {
            if (pattern.test($(this).val())) {
                $(this).closest('.h4_content').find('h4').html('').css('color', '#08A600');
                restric[$(this).attr('id')] = 1;
            } else {
                $(this).closest('.h4_content').find('h4').html('이메일 주소를 다시 확인해주세요.').css('color', 'red');
                restric[$(this).attr('id')] = 0;
            }
        } else {
            $(this).closest('.h4_content').find('h4').html('').css('color', '#08A600');
            restric[$(this).attr('id')] = 1;
        }
    });
    //전화번호
    $('#telNum').focusout(function () {
        if ($(this).val().length > 0) {
            $(this).closest('.h4_content').find('h4').html('').css('color', '#08A600');
            restric[$(this).attr('id')] = 1;
        }
    });
    //가입하기 버튼
    $('#join').submit(function () {
        var submit = 0;
        $.each(restric, function (index, item) {
            submit += item;
            if (item == 0) {
                $('#' + index).closest('.h4_content').find('h4').html('필수 정보입니다.').css('color', 'red');
            };
        });
        if (!(Object.keys(restric).length == submit)) {
            return false;
        } else {
            alert('가입 성공')
        }

    });

});
