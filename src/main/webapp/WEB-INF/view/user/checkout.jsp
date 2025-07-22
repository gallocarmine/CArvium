<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Checkout</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
</head>
<body>

<div class="credit-card">
    <fieldset>
        <legend>
            Payment
            <i class="bi bi-credit-card"></i>
        </legend>

        <form id="payment-form">

            <label for="card-name">Name of intestate</label>
            <input type="text" id="card-name" name="card-name" placeholder="Firstname Lastname" required>

            <label for="card-number">Card Number</label>
            <input type="text" id="card-number" name="card-number" placeholder="1234 5678 9012 3456" maxlength="19"
                   required>

            <label for="expiry">Expiration</label>
            <input type="text" id="expiry" name="expiry" placeholder="MM/AA" maxlength="5" required>

            <label for="cvv">CVV</label>
            <input type="password" id="cvv" name="cvv" maxlength="3" placeholder="123" required>

        <div class="other-payment">

            <fieldset>
                <input type="radio" name="payment" id="paypal" value="paypal" checked>
                <label for="paypal">
                    PayPal
                    <img src="${pageContext.request.contextPath}/images/shop/paypal.png" alt="PayPal">
                </label>
            </fieldset>

            <fieldset>
                <input type="radio" name="payment" id="klarna" value="klarna">
                <label for="klarna">
                    Klarna
                    <img src="${pageContext.request.contextPath}/images/shop/klarna.png" alt="PayPal">
                </label>
            </fieldset>

            <fieldset>
                <input type="radio" name="payment" id="visa" value="visa">
                <label for="visa">
                    Visa
                    <img src="${pageContext.request.contextPath}/images/shop/visa.png" alt="PayPal">
                </label>
            </fieldset>

            <fieldset>
                <input type="radio" name="payment" id="mastercard" value="mastercard">
                <label for="mastercard">
                    Mastercard
                    <img src="${pageContext.request.contextPath}/images/shop/mastercard.png" alt="PayPal">
                </label>
            </fieldset>

        </div>

        <div class="confirm-payment">
            <input type="button" value="Confirm Payment" onclick="confirmPayment()" id="pay-button">
        </div>

        </form>
    </fieldset>
</div>


<script src="${pageContext.request.contextPath}/script/cartShop.js"></script>

</body>
</html>
