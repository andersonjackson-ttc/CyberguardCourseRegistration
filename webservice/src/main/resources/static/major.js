console.log(1);
var done=false;

function getMajorList() {
  urlString = "/major";
  $.ajax({method: "GET", url: urlString, dataType: 'json'})
    .done(function(response)  {
      // response = JSON.stringify(response);
      //alert((JSON.stringify(response)));
      majorDropDown = $("#myDropdown");
     if(done==false)
     {
          $.each((response), function(index, major){
          console.log(1);
          $("<a href='#'>").val(major.id).text(major.name).appendTo(majorDropDown);
          done=true;
        });
      }
      
    })
    .fail(function(){
      alert("Error connecting to the server");
    })
    .always(function(){
     
    })
  ;
}


/* When the user clicks on the button,
toggle between hiding and showing the dropdown content */
function myFunction() {
  document.getElementById("myDropdown").classList.toggle("show");
}

// Close the dropdown menu if the user clicks outside of it
window.onclick = function(event) {
  if (!event.target.matches('.dropbtn')) {
    var dropdowns = document.getElementsByClassName("dropdown-content");
    var i;
    for (i = 0; i < dropdowns.length; i++) {
      var openDropdown = dropdowns[i];
      if (openDropdown.classList.contains('show')) {
        openDropdown.classList.remove('show');
      }
    }
  }
}



