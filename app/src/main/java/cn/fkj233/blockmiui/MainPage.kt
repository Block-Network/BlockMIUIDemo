package cn.fkj233.blockmiui

import android.view.View
import android.widget.Switch
import cn.fkj233.blockmiui.MainActivity.Companion.showToast
import cn.fkj233.ui.activity.MIUIActivity
import cn.fkj233.ui.activity.annotation.BMMainPage
import cn.fkj233.ui.activity.data.BasePage
import cn.fkj233.ui.activity.view.SpinnerV
import cn.fkj233.ui.activity.view.SwitchV
import cn.fkj233.ui.activity.view.TextSummaryV
import cn.fkj233.ui.activity.view.TextV
import cn.fkj233.ui.dialog.MIUIDialog
import cn.fkj233.ui.dialog.NewDialog

@BMMainPage("Home")
class MainPage : BasePage() {
    override fun onCreate() {
        TextSummaryArrow(TextSummaryV("showTest", onClickListener = {
            showFragment("test")
        }))
        TextSummaryArrow(TextSummaryV("showTest2", onClickListener = {
            showFragment("test2")
        }))
        TextSummaryArrow(TextSummaryV("showAsyncTest", onClickListener = {
            showFragment("async")
        }))
        TextSummaryArrow(TextSummaryV("showTest2", onClickListener = {
            NewDialog(activity) {
                setTitle("Test")
                setMessage("TestMessage")
                Button("1") {
                    dismiss()
                }
                Button("2") {
                    dismiss()
                }
                Button("3") {
                    dismiss()
                }
                Button("4", cancelStyle = true) {
                    dismiss()
                }
            }.show()
        }))
        TextSummaryArrow(TextSummaryV("showDialog", onClickListener = {
            MIUIDialog(activity) {
                setTitle("Test")
                setMessage("TestMessage")
                setEditText("", "test")
                setLButton("Cancel") {
                    dismiss()
                }
                setRButton("OK") {
                    dismiss()
                }
            }.show()
        }))
        TextSummary("TextSummary", tips="This is a TextSummary")
        TextSummaryArrow(TextSummaryV("test", tips = "summary", onClickListener = {}))
        TextSummaryWithSwitch(TextSummaryV("test", tips = "summary"), SwitchV("test12312312"))
        Author(activity.getDrawable(R.mipmap.ic_launcher)!!, "Test", "Test123")
        Author(activity.getDrawable(R.mipmap.ic_launcher)!!, "Test")
        TextWithSwitch(TextV("test"), SwitchV("test"))
        TextWithSpinner(TextV("Spinner"), SpinnerV("test") {
            add("test") { showToast("select test") }
            add("test1") { showToast("select test1") }
            add("test2") { showToast("select test2") }
            add("test3") { showToast("select test3") }
            add("test4") { showToast("select test4") }
            add("test5") { showToast("select test5") }
            add("test6") { showToast("select test6") }
            add("test7") { showToast("select test7") }
            add("test8") { showToast("select test8") }
            add("test9") { showToast("select test9") }
            add("test10") { showToast("select test10") }
            add("test11") { showToast("select test11") }
            add("test12") { showToast("select test12") }
            add("test13") { showToast("select test13") }
            add("test14") { showToast("select test14") }
        })
        TextSummaryWithSpinner(TextSummaryV("Spinner", tips = "Summary"), SpinnerV("test12312323123123123123123") {
            add("test12312323123123123123123") { showToast("select test") }
            add("test1") { showToast("select test1") }
            add("test2") { showToast("select test2") }
            add("test3") { showToast("select test3") }
        })
        Line()
        TitleText("Title")
        TextSummaryArrow(TextSummaryV("test", tips = "summary"))
        Text("SeekbarWithText")
        SeekBarWithText("seekbar", 0, 100, 0)
        Line()
        TitleText("DataBinding")
        val binding = GetDataBinding({ MIUIActivity.safeSP.getBoolean("binding", false) }) { view, flags, data ->
            when (flags) {
                1 -> (view as Switch).isEnabled = data as Boolean
                2 -> view.visibility = if (data as Boolean) View.VISIBLE else View.GONE
            }
        }
        TextWithSwitch(TextV("data-binding"), SwitchV("binding", dataBindingSend = binding.bindingSend))
        TextWithSwitch(TextV("test123"), SwitchV("test123", dataBindingRecv = binding.getRecv(1)))
        TextSummaryArrow(TextSummaryV("test"), dataBindingRecv = binding.getRecv(2))
    }
}