var done=false;
var submit = document.getElementById('submit');
var courseLink = "";


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
      
      clearcontent('table');
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

window.onload = function()
{
    var btnMajor = document.getElementById('btnMajor');
    
    btnMajor.addEventListener('click', getCourses, false);
    
}

function newTable(){
    clearcontent('table');
    var checkbox = '<tr><td id="boxCourse"><input type="checkbox" class="taking"></td>';
    var table = ' <table><tr><th id="boxCourse"></th><th id="textCourse">Course Id</th><th id="textCourse">Course Name</th></tr>';
    table += checkbox + '<td id="textCourse">ABC-123</td><td id="textCourse">The Alphabet</td></tr></table>';
    
    document.getElementById('table').innerHTML = table;
        
    
}


//get the id of the dropdown
function Class(str)
{
  courseLink = "/courses?major="+str.toString()+"+";
  //courseLink =+ "/courses?majors=" /*+ str.toString()*/;
  //alert(courseLink);
}

function getCourses() {

  $.ajax({method: "GET", url: courseLink, dataType: 'json'})
    .done(function(response)  {
      // response = JSON.stringify(response);
      //alert((JSON.stringify(response)));
      table = $("#table");
      var appenddata1 = "";



      // for (var i = 0; i < response.length; i++) {
      //     appenddata1 += "<tr>";
      //       for (var j=0; j< i+1; j++)
      //       {
      //         appenddata1+= "<td id='boxCourse'><input type='checkbox' class='taking'>" + "</td>" + response[i].course_ID+"</td>" + "<td>"+ response[i].course_Name + "</td>";
      //       }
          
      //   }
      //   appenddata1 += "</tr>"
      //   table.append(appenddata1);


      appenddata1+="<table>"
      appenddata1 += "<tr><th id='boxCourse'></th><th id='textCourse'>Course Id</th><th id='textCourse'>Course Name</th></tr>"
      clearcontent('table');

      for (var j=0; j< response.length; j++)
      {
        appenddata1+= "<tr><td id='boxCourse'><input type='checkbox' class='taking'></td>" + "<td id='textCourse'>" + response[j].course_ID+ "</td>" + "<td id='textCourse'>"+ response[j].course_Name + "</td></tr>";
      }
      appenddata1+="</table>"
      table.append(appenddata1);
  




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












