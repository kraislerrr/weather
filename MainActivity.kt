package com.example.weather

import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val webView: WebView = findViewById(R.id.webView)
        val webViewrp: WebView = findViewById(R.id.webViewrp)
        val spinner: Spinner = findViewById(R.id.spinner)

        val items = arrayOf("Anapa airport weather archive", "Sochi airport weather archive", "Stavropol airport weather archive", "St. Petersburg airport weather archive")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, items)

        spinner.adapter = adapter

        var selected = spinner.selectedItem

        webView.settings.javaScriptEnabled = true
        webViewrp.settings.javaScriptEnabled = true


        webViewrp.getSettings().setUserAgentString("Mozilla/5.0 (X11; U; Linux i686; en-US; rv:1.9.0.4) Gecko/20100101 Firefox/4.0");
        webViewrp.setInitialScale(120);
        webViewrp.setWebViewClient(object : WebViewClient() {
            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                val script = "document.getElementById('TabInfo').scrollIntoView();"
                webViewrp.evaluateJavascript(script, null)
            }})
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                when (position) {
                    1 -> {
                        webView.loadUrl("https://earth.nullschool.net/#current/wind/surface/level/orthographic=-319.26,43.40,2923/loc=40.323,43.296")
                        webViewrp.loadUrl("https://rp5.ru/%D0%90%D1%80%D1%85%D0%B8%D0%B2_%D0%BF%D0%BE%D0%B3%D0%BE%D0%B4%D1%8B_%D0%B2_%D0%A1%D0%BE%D1%87%D0%B8,_%D0%B8%D0%BC._%D0%92._%D0%98._%D0%A1%D0%B5%D0%B2%D0%B0%D1%81%D1%82%D1%8C%D1%8F%D0%BD%D0%BE%D0%B2%D0%B0_(%D0%B0%D1%8D%D1%80%D0%BE%D0%BF%D0%BE%D1%80%D1%82),_METAR")
                    }
                    2 -> {
                        webView.loadUrl("https://earth.nullschool.net/#current/wind/surface/level/orthographic=-318.48,44.78,2537/loc=41.543,44.513")
                        webViewrp.loadUrl("https://rp5.ru/%D0%90%D1%80%D1%85%D0%B8%D0%B2_%D0%BF%D0%BE%D0%B3%D0%BE%D0%B4%D1%8B_%D0%B2_%D0%A1%D1%82%D0%B0%D0%B2%D1%80%D0%BE%D0%BF%D0%BE%D0%BB%D0%B5,_%D0%B8%D0%BC._%D0%90._%D0%92._%D0%A1%D1%83%D0%B2%D0%BE%D1%80%D0%BE%D0%B2%D0%B0_(%D0%B0%D1%8D%D1%80%D0%BE%D0%BF%D0%BE%D1%80%D1%82),_METAR")
                    }
                    3 -> {
                        webView.loadUrl("https://earth.nullschool.net/#current/wind/surface/level/orthographic=-330.17,59.10,2042/loc=30.271,59.934")
                        webViewrp.loadUrl("https://rp5.ru/%D0%90%D1%80%D1%85%D0%B8%D0%B2_%D0%BF%D0%BE%D0%B3%D0%BE%D0%B4%D1%8B_%D0%B2_%D0%9F%D1%83%D0%BB%D0%BA%D0%BE%D0%B2%D0%BE_(%D0%B0%D1%8D%D1%80%D0%BE%D0%BF%D0%BE%D1%80%D1%82),_METAR")
                    }
                    else -> {
                        webView.loadUrl("https://earth.nullschool.net/#current/wind/surface/level/orthographic=-321.59,44.81,5146/loc=37.310,44.892")
                        webViewrp.loadUrl("https://rp5.ru/%D0%90%D1%80%D1%85%D0%B8%D0%B2_%D0%BF%D0%BE%D0%B3%D0%BE%D0%B4%D1%8B_%D0%B2_%D0%90%D0%BD%D0%B0%D0%BF%D0%B5,_%D0%B8%D0%BC._%D0%92._%D0%9A._%D0%9A%D0%BE%D0%BA%D0%BA%D0%B8%D0%BD%D0%B0%D0%BA%D0%B8_(%D0%B0%D1%8D%D1%80%D0%BE%D0%BF%D0%BE%D1%80%D1%82),_METAR")
                    }
                }

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Handle the case when nothing is selected
            }
        }

    }
}