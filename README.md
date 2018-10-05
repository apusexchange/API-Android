# APUS-ANDROID

ApusPayments is a plataform to make payments using criptocurrencies.

* Language: Java/Kotlin

[Documentation API](https://docs.apuspayments.com/)

## Examples of use

* [x] Payments by card.
* [x] Recurring payments.
* [x] Cancel payment.
* [x] Consult payments.
* [x] Cryptocurrency recharge.

<hr>

## Configuration

Add it in your root build.gradle at the end of repositories:

```java
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

Add the dependency

```java
dependencies {
    implementation 'com.github.apuspayments:API-Android:1.0.0'
}
```

* Call ApusPaymentAPI and choose environment:
     * SANDBOX
     * PRODUCTION

```java
val apusPaymentAPI = ApusPaymentAPI(Environment.SANBOX)
```

* Set callback to handle the API function

```java
apusPaymentAPI.callback = {response->
            
}
``` 

## Make a payments

```java
apusPaymentAPI.start(MakePayment.Builder()
.withAmount(10)
.withBlockChain(BlockChain.Type.LTC)
.withCurrency(Currency.Type.BRL)
.withPan("9999999999999999")
.withPassWord("1234")
.withVendorKey("5f5bdaed-f82b-4b82-b3f5-1d562633da5b")
.build(),
this)
```
<hr>

## Make a recurring payments

```java
 apusPaymentAPI.start(RecurringPayment.Builder()
.withAmount(10)
.withBlockChain(BlockChain.Type.LTC)
.withCurrency(Currency.Type.BRL)
.withPeriod(Period.M)
.withPan("9999999999999999")
.withPassWord("1234")
.withVendorKey("5f5bdaed-f82b-4b82-b3f5-1d562633da5b")
.build(),
this)
```
<hr>

## Search payments

```android
apusPaymentAPI.start(SearchPayment.Builder()
.withBlockchain(BlockChain.Type.LTC)
.withCurrency(Currency.Type.BRL)
.withTxId("2bf779e2a311c2629df977b0bb105879411fd71f5839972c4ed1d3278f80170f")
.withVendorKey("5f5bdaed-f82b-4b82-b3f5-1d562633da5b")
.build(),
this)
```
<hr>

## Cancel a payment

```android
 apusPaymentAPI.start(CancelPayment.Builder()
.withPassWord("1234")
.withVendorKey("5f5bdaed-f82b-4b82-b3f5-1d562633da5b")
.withTxId("2bf779e2a311c2629df977b0bb105879411fd71f5839972c4ed1d3278f80170f")
.build(),
this)
```
<hr>

## Recharge of Crypto Balance

```android
apusPaymentAPI.start(RechargeCryptoBalance.Builder()
.withAmount(10)
.withBlockChain(BlockChain.Type.LTC)
.withCurrency(Currency.Type.BRL)
.withPan("9999999999999999")
.withPassWord("1234")
.withVendorKey("5f5bdaed-f82b-4b82-b3f5-1d562633da5b")
.build(),
this)
```
<hr>

