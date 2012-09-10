<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>${title}</title>
</head>
<body>

<form method="post" action="play" >
<p>${errormsg}</p>
<p> enter name: <input type='text' name='name' value='' /></p>
<p> I want play: </p>
<ul>
<li>play X: <input type="radio" value="true" name='${link}' /></li>
<li>play Y: <input type="radio" value="false" name='${link}' /></li>
</ul>
<input type='hidden' value='${token}' name='${link}' />
<input type='submit' value='Submit' />
</form>

</body>
</html>