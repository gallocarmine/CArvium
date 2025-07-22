<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Checkout</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/account/checkout.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
</head>
<body>


<div class="checkout-container">

    <h2 class="checkout-title">Payment <i class="bi bi-credit-card"></i></h2>

    <form id="payment-form">

        <div class="form-row">
            <div class="half-width">
                <label for="card-name">Name of intestate</label>
                <input type="text" id="card-name" name="card-name" placeholder="Firstname Lastname" required>
            </div>
            <div class="half-width">
                <label for="card-number">Card Number</label>
                <input type="text" id="card-number" name="card-number" placeholder="1234 5678 9012 3456" maxlength="19" required>
            </div>
        </div>

        <div class="form-row">
            <div class="half-width">
                <label for="expiry">Expiration</label>
                <input type="text" id="expiry" name="expiry" placeholder="MM/AA" maxlength="5" required>
            </div>
            <div class="half-width">
                <label for="cvv">CVV</label>
                <input type="password" id="cvv" name="cvv" maxlength="3" placeholder="123" required>
            </div>
        </div>

        <div class="payment-methods">
            <div class="payment-option">
                <input type="radio" name="payment" id="paypal" value="paypal" checked>
                <label for="paypal">
                    <img src="${pageContext.request.contextPath}/images/shop/paypal.png" alt="PayPal">
                    PayPal
                </label>
            </div>

            <div class="payment-option">
                <input type="radio" name="payment" id="klarna" value="klarna">
                <label for="klarna">
                    <img src="${pageContext.request.contextPath}/images/shop/klarna.png" alt="Klarna">
                    Klarna
                </label>
            </div>

            <div class="payment-option">
                <input type="radio" name="payment" id="visa" value="visa">
                <label for="visa">
                    <img src="${pageContext.request.contextPath}/images/shop/visa.png" alt="Visa">
                    Visa
                </label>
            </div>

            <div class="payment-option">
                <input type="radio" name="payment" id="mastercard" value="mastercard">
                <label for="mastercard">
                    <img src="${pageContext.request.contextPath}/images/shop/mastercard.png" alt="Mastercard">
                    Mastercard
                </label>
            </div>
        </div>

        <div class="confirm-payment">
            <input type="submit" value="Confirm Payment" onclick="confirmPayment(); return false;" id="pay-button">
        </div>

    </form>

</div>


<script src="${pageContext.request.contextPath}/script/cartShop.js"></script>

</body>
</html>
