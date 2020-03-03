<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Check Payment</title>
</head>
<body>
<h3>Confirmation</h3>
Confirm your information:
<br>
Credit card number: ${bindingCredit.cardNumber}
<br>
Name on card: ${bindingCredit.name}
<br>
Expiration date: ${bindingCredit.expirationDate}
<br>
Confirmation code: ${bindingCredit.confirmationCode}
</body>
</html>
