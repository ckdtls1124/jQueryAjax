$('#submitBtn').on('click', ajaxFn);

function ajaxFn(){
const data={
    'username':$('#username').val(),
    'userpw':$('#userpw').val()
};

$.ajax({
type:'post',
url: '/ajax/register',
data:data,
success: function(res){
    if(res==1){
        alert('회원가입')
    } else{
        alert('회원가입 실패')
    }
}})}

$('#dupCheck').on('click', dupCheck);
function dupCheck(){
const data={'username':$('#username').val()};

$.ajax({
type: 'post',
url:'/ajax/dupCheck',
data:data,
success: function(res){
    if(res==1){
        alert('아이디가 이미 있습니다. 다른 아이디를 입력해주시기 바랍니다. ')
    } else {
        alert('아이디 사용 가능')
    }
}})}