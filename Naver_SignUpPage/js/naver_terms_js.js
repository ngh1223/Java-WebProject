 $(document).ready(function () {
     //체크박스 모두 동의 선택 > 아래 전부 체크됨
     //해제 > 아래 전부 해제
     $('#chk_all').on('click', function () {
         if ($(this).prop('checked')) {
             $('.chk').prop('checked', true);
         } else {
             $('.chk').prop('checked', false);
         }
     });
     //체크박스 아래꺼 전부 선택> 위에 모두동의 체크됨
     //하나라도 해제 > 위에 모두동의 체크해제
     $('.chk').on('click', function () {
         if (!$(this).prop('checked')) {
             $('#chk_all').prop('checked', false);
         } else if ($('.chk').length == $('.chk:checked').length) {
             $('#chk_all').prop('checked', true);
         }
     });

     //동의안하고 동의 버튼 누르면 빨간글씨 생김
     $('#join_form').submit(function () {
         if (!$('#termsService').prop('checked') || !$('#terms2').prop('checked')) {
             $('#disagree').css('display', 'block');
             return false;
         }

     });

 });
