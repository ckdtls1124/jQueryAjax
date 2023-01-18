$('#ajaxBtn').on('click', listShow);


function listShow(){
    $.ajax({
        type:'get',
        url: '/ajax/showLists',
        async: false,
        success: function(res){
            const rs=res; // It receives data from List<MemberDTO>
            let tag="";
            rs.forEach ( function(el, idx){
                tag=tag+"<tr>";
                    tag=tag+'<td><input class="idVal" name="idVal" value='+el.id+' readonly></td>';
                    tag=tag+"<td>"+el.username+"</td>";
                    tag=tag+"<td>"+el.userpw+"</td>";
                    tag=tag+'<td><input type="button" name="idBtn" class="idBtn" value="Detail"></td>';
                tag=tag+"</tr>";

            })
            $('#list tbody').html(tag);
        },
        error:function(){
            alert('전체 리스트 불러오기 실패')
        }
    })

}

//$('.idBtn').on('click', eachList);
//function eachList(){
//               const data={
//                          'id':$('.idVal').val()
//                      }
//                 $.ajax({
//                      type:'post',
//                      data: data,
//                      async: false,
//                      url: '/ajax/detailList',
//                      success: function(res){
//                          const rs=res; // It receives data from List<MemberDTO>
//                          let tag="";
//          //                rs.forEach ( function(el, idx){
//
//                              tag=tag+"<tr>";
//                                  tag=tag+"<td>"+rs.id+"</td>";
//                                  tag=tag+"<td>"+rs.username+"</td>";
//                                  tag=tag+"<td>"+rs.userpw+"</td>";
//                                  tag=tag+"<td>Delete</td>";
//                              tag=tag+"</tr>";
//
//          //                }
//          //                  )
//                          $('#list tbody').html(tag);
//                      },
//                      error:function(){
//                          alert('해당 회원 리스트 불러오기 실패')
//                      }
//                  })


//}



