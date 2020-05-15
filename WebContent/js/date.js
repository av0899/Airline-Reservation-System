$("#date").datepicker({
  onSelect: function(date) {
    $(".date").find("h4").text(date);
  }
});