const checkValidity =  =>  {
  console.log("test");
  let elem = document.getElementById(id);
  if (elem.value.length !== 0) {
    elem.setAttribute("aria-invalid", "false");
  } else {
    elem.setAttribute("aria-invalid", "true");
  }
}