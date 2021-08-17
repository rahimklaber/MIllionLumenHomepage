package me.rahimklaber.millionlumen

import io.kvision.core.*
import io.kvision.html.div
import io.kvision.panel.vPanel

const val aboutTest = """
    <div><h2 id='about'><span>About</span></h2>
    <p><span>This project is based on </span>
        <a href='http://www.milliondollarhomepage.com/'><span><b>The Million Dollar Homepage</b></span></a>
        <span>.  Like the Milion Dollar Homepage, this project allows users to buy areas of 10 by 10 pixels. Currently, one pixel costs 0.1 XLM.</span>
    </p>
    <h2>How it works</h2>
    <p>
        First, the image is uploaded to IPFS. Afterwards, a transaction is created with "millionlumen" the memo. The first operation
        of the transaction is a payment to the project address. The second operation is a managedata operation with the IPFS hash as the name and
        the dimensions and coordinates of the image as the value.
    </p>
    <p>
        When the website Loads, It requests all transactions to the project address that have "millionlumen" as the memo.
        After verifying the transactions, the images are loaded from information in the managedata operation.
    </p>
    
    <p>
       Created by <a href='https://github.com/rahimklaber'><span><b>Rahim Klabér</b></span></a>.
    </p>
</div>

"""


fun Container.about() = vPanel {
    div(rich = true, content = aboutTest) {
        style {
            color = Color("white")
        }
    }
    style {
        border = Border(CssSize(1, UNIT.px), BorderStyle.SOLID, Color.name(Col.LIGHTGRAY))
        padding = CssSize(10, UNIT.px)
        width = CssSize(1000, UNIT.px)
        color = Color("white")
    }
}