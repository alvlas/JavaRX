package utils

import android.util.JsonReader
import android.util.Log
import com.google.gson.Gson
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import java.io.IOException
import java.io.InputStreamReader
import java.net.URL
import java.util.*
import javax.net.ssl.HttpsURLConnection

/**
 * This function returns an prepared Observable
 */

class NetworkConnection {
    private val TAG = "NetworkUtils"
    private val currencyRatePairs: MutableMap<String, Double> = HashMap()

    fun responseOfConnection(): Map<String, Double>? {
        val link = "https://api.exchangeratesapi.io/latest"
        val o = createRequest(link)
                .map { Gson().fromJson(it, Feed::class.java) }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
        val request = o.subscribe({
            for (item in it.items) {
                Log.i(TAG, "responseOfConnection: $item ***")
            }
        }, {

        })

        return null
    }
}

class Feed(
        val items: ArrayList<FeedItem>
)
class FeedItem(
        rates: String,
        base: String
)

/*
{
"rates":
    {
    "CAD":1.5225,"HKD":9.3297,"ISK":152.1,"PHP":58.338,"DKK":7.4361,"HUF":363.7,"CZK":26.142,
            "AUD":1.5422,"RON":4.8762,"SEK":10.14,"IDR":17230.11,"INR":88.259,"BRL":6.8387,"RUB":88.6885,
            "HRK":7.5825,"JPY":128.58,"THB":36.401,"CHF":1.105,"SGD":1.6016,"PLN":4.5322,"BGN":1.9558,
            "TRY":8.8151,"CNY":7.784,"NOK":10.2555,"NZD":1.6565,"ZAR":18.1353,"USD":1.2028,"MXN":24.8772,
            "ILS":3.97,"GBP":0.86433,"KRW":1354.37,"MYR":4.8804
    },

"base":"EUR",
"date":"2021-03-02"
}
*/

