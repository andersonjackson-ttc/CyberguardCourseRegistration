function menu() {
    var majorlist = document.getElementById("majorlist");
    document.getElementById("Favorite").value = majorlist.options[majorlist.selectedIndex].text;
  }

window.onload = function()
{
    var btnMajor = document.getElementById('btnMajor');
    
    btnMajor.addEventListener('click', newTable, false);
    
}

function newTable(){
    clearcontent('table');
    var checkbox = '<tr><td id="boxCourse"><input type="checkbox" class="taking"></td>';
    var table = ' <table><tr><th id="boxCourse"></th><th id="textCourse">Course Id</th><th id="textCourse">Course Name</th></tr>';
    table += checkbox + '<td id="textCourse">ABC-123</td><td id="textCourse">The Alphabet</td></tr></table>';
    
    document.getElementById('table').innerHTML = table;
        
    
}
function getCourses() {
    urlString = " ";
    $.ajax({method: "GET", url: urlString, dataType: 'json'})
    .done(function(response){
      JSON.stringify(response);
      alert((JSON.stringify(response)));
      courseTable = $("#courses");
      $.each((response), function(index, course){
        console.log(1);
        $("<td>").val(course.id).text(course.name).appendTo(courseTable);
      });
    })
    .fail(function(){
      alert("Error connecting to the server");
    })
    .always(function(){
    
    })
    ;
  }

function clearcontent(elementID) {
            document.getElementById(elementID).innerHTML = "";
        }
