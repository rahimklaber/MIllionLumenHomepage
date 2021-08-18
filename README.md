# MIllionLumenHomepage
![Capture](https://user-images.githubusercontent.com/21971137/129623295-21fea187-f8a2-4c77-b684-12e8765ae03a.PNG)
## About
This project allows users to buy pixels in 10 by 10 increments at 0.1 XLM per pixel. Inspired by [The Million Dollar Homepage](http://www.milliondollarhomepage.com/).
## How it works
First, the image is uploaded to IPFS. Afterwards, a transaction is created with "millionlumen" the memo. The first operation of the transaction is a payment to the project address. The second operation is a managedata operation with the IPFS hash as the name and the dimensions and coordinates of the image as the value. the last operation is another managedata operation to delete the data entry created with the previous operation.

When the website Loads, It requests all transactions to the project address that have "millionlumen" as the memo. After verifying the transactions, the images are loaded from information in the managedata operation.

## Development

`./gradlew browserDevelopmentRun --continuous` running the project in development mode with hot reload.
`./gradlew browserProductionWebpack` for building a production build in the build/distributions directory.
