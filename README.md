### Ecommerce API's
* GET : http://localhost:8080/api/v1/product
<img src="get-api.png" alt="App Screenshot" style="border: 1px solid black; border-radius: 10px; width: 400px;" />

* POST : http://localhost:8080/api/v1/product
  <img src="post-api.png" alt="App Screenshot" style="border: 1px solid black; border-radius: 10px; width: 400px;" />

### Payment steps
* Razorpay integration (https://razorpay.com/docs/api/payments/payment-links/create-standard/)
* Get a payment link for order id (with the help of payment gateway) ⇒ navigate in UI (Navigation page)
* Outcome of payment page : `Success` ⇒ PG received money `Failure` ⇒ all other possibilities (Callback URL/Redirect URL)
* If payment is not completed within session or just in time, Razorpay/Stripe will call Webhook API (make sure to change endpoint regularly)

* Payment request ⇒ Gets payment URL
  <img src="payment-request.png" alt="App Screenshot" style="border: 1px solid black; border-radius: 10px; width: 400px;" />

* Opening payment URL ⇒ Able to make payments
  <img src="payment-link.png" alt="App Screenshot" style="border: 1px solid black; border-radius: 10px; width: 400px;" />

* Stripe integration (https://docs.stripe.com/api/payment-link)
  <img src="stripe-request.png" alt="App Screenshot" style="border: 1px solid black; border-radius: 10px; width: 400px;" />
  <img src="stripe-link.png" alt="App Screenshot" style="border: 1px solid black; border-radius: 10px; width: 400px;" />

* For any of these events, Stripe will invoke webhook API (use ngrok for safe tunnel instead of direct expose of payment status API's)
  <img src="webhook-register.png" alt="App Screenshot" style="border: 1px solid black; border-radius: 10px; width: 400px;" />

* TODO: reconcile API to handle any missed payments