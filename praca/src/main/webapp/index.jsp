<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Java Homework #1</title>
</head>
<body>
<form action="hello" method="get">
    <label>Kwota kredytu <input type="text" name="kredyt"/></label>
    <label>Ilosc rat <input type="text" name="raty"/></label>
    <label>Oprocentowanie <input type="text" name="oprocentowanie"/></label>
    <label>Oplata stala <input type="text" name="oplata"/></label>
    <label>Rodzaj rat
        <select name="rodzaj">
            <option name="stala">Stala</option>
            <option name="malejaca">Malejaca</option>
        </select>
    </label>

    <input type="submit" value="Wyslij"/>



</form>
</body>
</html>
