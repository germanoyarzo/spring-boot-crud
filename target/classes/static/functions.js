function remove(id){
    swal({
      title: "Are you sur to deletee?",
      text: "Once deleted, you will not be able to recover this imaginary file!",
      icon: "warning",
      buttons: true,
      dangerMode: true,
    })
    .then((OK) => {
      if (OK) {
        $.ajax({
            url:"/delete/"+id,
            success: function(res){
                console.log(res);
            }
        })
        swal("Poof! Your imaginary file has been deleted!", {
          icon: "success",
        }).then((ok)=>{
            if(ok){
                location.href="/listar";
            }
        });
      } else {
        swal("Your imaginary file is safe!");
      }
    });
}