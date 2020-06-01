<%@ page isErrorPage="true" %>  
<script>
function redirect(elem){
    elem.setAttribute("action","contactDisplay.jsp");
    elem.submit();
}
</script>
  
<h3>Sorry an exception occured!</h3>  
  
Exception is: <%= exception %>

<form id="main" method="post" name="main" action="" onsubmit="redirect(this);">
    <input type="submit" name="Back"/> 
</form>


