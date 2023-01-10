package cn.fkj233.blockmiui

import android.view.View
import android.widget.Switch
import cn.fkj233.ui.activity.MIUIActivity
import cn.fkj233.ui.activity.annotation.BMPage
import cn.fkj233.ui.activity.data.BasePage
import cn.fkj233.ui.activity.view.SwitchV
import cn.fkj233.ui.activity.view.TextSummaryV
import cn.fkj233.ui.activity.view.TextV

@BMPage("test", "Test")
class TestPage : BasePage() {
    override fun onCreate() {
        Text("ThisTest")
        Text("ThisTest1")
        TextSummaryArrow(TextSummaryV("showTest2", onClickListener = {
            showFragment("test2")
        }))
        val binding = GetDataBinding({ MIUIActivity.safeSP.getBoolean("binding123", false) }) { view, flags, data ->
            when (flags) {
                1 -> (view as Switch).isEnabled = data as Boolean
                2 -> view.visibility = if (data as Boolean) View.VISIBLE else View.GONE
            }
        }
        TextWithSwitch(TextV("data-binding"), SwitchV("binding123", dataBindingSend = binding.bindingSend))
        TextWithSwitch(TextV("test123123"), SwitchV("test123123", dataBindingRecv = binding.binding.getRecv(1)))
        TextSummaryArrow(TextSummaryV("test"), dataBindingRecv = binding.binding.getRecv(2))
        Text("Radio")
        RadioView("radio") {
            add("radio1", "1")
            add("radio2", "2")
            add("radio3", "3")
            add("radio4", "4")
            add("radio5", "5")
        }
    }
}