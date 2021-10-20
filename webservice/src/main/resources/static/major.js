var done=false;
var submit = document.getElementById('submit');



function getMajorList() {
  if(done==false)
  {
  urlString = "/major";
  $.ajax({method: "GET", url: urlString, dataType: 'json'})
    .done(function(response)  {
      // response = JSON.stringify(response);
      //alert((JSON.stringify(response)));
      majorDropDown = $("#myDropdown");
      var appenddata1 = "";

        for (var i = 0; i < response.length; i++) {
            appenddata1 += "<option value = '" + response[i].id + " '>" + response[i].major_Name + " </option>";
        }
        $("#myDropdown").append(appenddata1);
        done=true;
      
      
    })
    .fail(function(){
      alert("Error connecting to the server");
    })
    .always(function(){
    
    })
  ;
  }
}

// window.onload = function()
// {
//     submit.addEventListener('click', newTable, false);
    
// }

function newTable(){
    clearcontent('table');
    var checkbox = '<tr><td id="boxCourse"><input type="checkbox" class="taking"></td>';
    var table = ' <table><tr><th id="boxCourse"></th><th id="textCourse">Course Id</th><th id="textCourse">Course Name</th></tr>';
    table += checkbox + '<td id="textCourse">ABC-123</td><td id="textCourse">The Alphabet</td></tr></table>';
    
    document.getElementById('table').innerHTML = table;
        
    
}

function getCourses() {

  urlString = "/courses?major=7+";
  $.ajax({method: "GET", url: urlString, dataType: 'json'})
    .done(function(response)  {
      // response = JSON.stringify(response);
      //alert((JSON.stringify(response)));
      table = $("#table");
      var appenddata1 = "";

        for (var i = 0; i < response.length; i++) {
            for (var j=0; j<= i; j++)
            {

            }
          //appenddata1 += "<td value = '" + response[i].id + " '>" + response[i].major_Name + " </option>";
        }
        $("#myDropdown").append(appenddata1);
        done=true;
      
      
    })
    .fail(function(){
      alert("Error connecting to the server");
    })
    .always(function(){
    
    })
  ;
  }












