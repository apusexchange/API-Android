# APUS-ANDROID
ApusPayments is a plataform to make payments using criptocurrencies.
* Language: Java/Kotlin

[Documentation API (v0.0.1)](https://docs.apuspayments.com/)

## Examples of use
* Make a payments
* Make a recurring payments
* Search payments
* Cancel a payment
* Recharge of Crypto Balance

<hr>

## Configuration

Add it in your root build.gradle at the end of repositories:

```android
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

Add the dependency

```android
dependencies {
	        implementation 'com.github.apuspayments:API-Android:1.0.0'
}
```


* Call ApusPaymentAPI and choose environment:
     * true:SANDBOX
     * false:PRODUCTION
```android
   val apusPaymentAPI = ApusPaymentAPI(true)
```

* Set callback to handle the api function

```android
apusPaymentAPI.callback = {response->
            
}
``` 

## Make a payments

```android
apusPaymentAPI.start(MakePayment.Builder()
                .withAmount(10)
                .withBlockChain(BlockChain.Type.LTC)
                .withCurrency(Currency.Type.BRL)
                .withPanEncrypted("0866a6eaea5cb085e4cf6ef19296bf19647552dd5f96f1e530db3ae61837efe7")//or call withPan for encrypt pan with SDK 
                .withPassWordEncrypted("c66f1f34f49381e467d3abd43c77947f5d1dd362fd0eec6c2c1f27233ae9adf9")//or call withPassword for encrypt password with SDK
                .withVendorKey("5f5bdaed-f82b-4b82-b3f5-1d562633da5b")
                .build(),
                this)
```
<hr>

## Make a recurring payments

```android
 apusPaymentAPI.start(RecurringPayment.Builder()
                .withAmount(10)
                .withBlockChain(BlockChain.Type.LTC)
                .withCurrency(Currency.Type.BRL)
                .withPeriod(Period.M)
                .withPanEncrypted("0866a6eaea5cb085e4cf6ef19296bf19647552dd5f96f1e530db3ae61837efe7")
                .withPassWordEncrypted("03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4")
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
                .withPassWordEncrypted("03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4")
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
                .withPanEncrypted("0866a6eaea5cb085e4cf6ef19296bf19647552dd5f96f1e530db3ae61837efe7")
                .withPassWordEncrypted("03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4")
                .withVendorKey("5f5bdaed-f82b-4b82-b3f5-1d562633da5b")
                .build(),
                this)
```
<hr>

