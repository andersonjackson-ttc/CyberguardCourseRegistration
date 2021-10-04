function menu() {
    var majorlist = document.getElementById("majorlist");
    document.getElementById("Favorite").value = majorlist.options[majorlist.selectedIndex].text;
  }