package com.soongon.nationinfo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_nation_detail.*
import java.io.InputStream
import java.io.InputStreamReader

class NationDetailActivity : AppCompatActivity() {

    companion object {
        val EXTRA_NATION_NAME = "nationName"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nation_detail)

        val nation = intent.getStringExtra(EXTRA_NATION_NAME)
        val data = getDataFromName(nation)
        flagImageView.setImageResource(getResourceId(nation))
        initView(data)
    }

    private fun getDataFromName(selected: String): NationDetail? {
        val gson: Gson = GsonBuilder().create()
        val inputStream: InputStream = assets.open("nation_data.json")
        val reader: InputStreamReader = InputStreamReader(inputStream)
        val details: NationDetails = gson.fromJson(reader, NationDetails::class.java)

        for (data in details.data) {
            if (selected.equals(data.name)) {
                return data
            }
        }
        return null
    }

    private fun getResourceId(selected: String): Int {
        var resourceId: Int = 0

        when(selected) {
            "벨기에" -> {
                resourceId = R.drawable.l_flag_belgium
            }
            "아르헨티나" -> {
                resourceId = R.drawable.l_flag_argentina
            }
            "브라질" -> {
                resourceId = R.drawable.l_flag_brazil
            }
            "캐나다" -> {
                resourceId = R.drawable.l_flag_canada
            }
            "중국" -> {
                resourceId = R.drawable.l_flag_china
            }
            else -> {
                resourceId = 0
            }
        }

        return resourceId
    }

    private fun initView(data: NationDetail?) {
        nameTextView.text = data?.name
        capitalTextView.text = data?.capital
        volumeTextView.text = data?.volume
        weatherTextView.text = data?.weather
        locationTextView.text = data?.location
        languageTextView.text = data?.language
    }
}
