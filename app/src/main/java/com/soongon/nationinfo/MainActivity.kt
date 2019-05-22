package com.soongon.nationinfo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val items: List<Nation> = getDataFromSource()

        nationRecyclerView.layoutManager = LinearLayoutManager(this)
        nationRecyclerView.adapter = NationAdapter(items)
    }

    private fun getDataFromSource(): List<Nation> {
        return listOf(
            Nation(R.drawable.l_flag_argentina, "아르헨티나", "부에노스아이레스"),
            Nation(R.drawable.l_flag_belgium, "벨기에", "브뤼셀"),
            Nation(R.drawable.l_flag_brazil, "브라질", "브라질리아"),
            Nation(R.drawable.l_flag_canada, "캐나다", "오타와"),
            Nation(R.drawable.l_flag_brazil, "브라질", "브라질리아"),
            Nation(R.drawable.l_flag_china, "중국", "북경"),
            Nation(R.drawable.l_flag_croatia, "크로아티아", "브라질리아"),
            Nation(R.drawable.l_flag_czech, "체코", "프라하"),
            Nation(R.drawable.l_flag_germany, "독일", "베를린"),
            Nation(R.drawable.l_flag_ghana, "가나", "브라질리아"),
            Nation(R.drawable.l_flag_greece, "그리스", "브라질리아"),
            Nation(R.drawable.l_flag_korea, "대한민국", "서울"),
            Nation(R.drawable.l_flag_norway, "노르웨이", "브라질리아"),
            Nation(R.drawable.l_flag_united_states, "미국", "워싱턴")
        )
    }
}
