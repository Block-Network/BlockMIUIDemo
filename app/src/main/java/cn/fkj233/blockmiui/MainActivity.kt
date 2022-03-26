package cn.fkj233.blockmiui

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Switch
import android.widget.Toast
import cn.fkj233.ui.activity.MIUIActivity
import cn.fkj233.ui.activity.data.MIUIPopupData
import cn.fkj233.ui.activity.view.SpinnerV
import cn.fkj233.ui.activity.view.SwitchV
import cn.fkj233.ui.activity.view.TextSummaryV
import cn.fkj233.ui.activity.view.TextV
import cn.fkj233.ui.dialog.MIUIDialog
import cn.fkj233.ui.dialog.NewDialog

class MainActivity : MIUIActivity() {
    private val handler by lazy { Handler(Looper.getMainLooper()) }

    private val activity = this

    init {
        initView {
            registerMain("Home") {
                TextSummaryArrow(TextSummaryV("showTest", onClickListener = {
                    showFragment("test")
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
                TextSummaryArrow(TextSummaryV("test", tips = "summary", onClickListener = {}))
                TextSummaryWithSwitch(TextSummaryV("test", tips = "summary"), SwitchV("test12312312"))
                Author(getDrawable(R.mipmap.ic_launcher)!!, "Test", "Test123")
                Author(getDrawable(R.mipmap.ic_launcher)!!, "Test")
                TextWithSwitch(TextV("test"), SwitchV("test"))
                TextWithSpinner(TextV("Spinner"), SpinnerV(arrayListOf<MIUIPopupData>().apply {
                    add(MIUIPopupData("test") { showToast("select test") })
                    add(MIUIPopupData("test1") { showToast("select test1") })
                    add(MIUIPopupData("test2") { showToast("select test2") })
                    add(MIUIPopupData("test3") { showToast("select test3") })
                }, "test"))
                TextSummaryWithSpinner(TextSummaryV("Spinner", tips = "Summary"), SpinnerV(arrayListOf<MIUIPopupData>().apply {
                    add(MIUIPopupData("test") { showToast("select test") })
                    add(MIUIPopupData("test1") { showToast("select test1") })
                    add(MIUIPopupData("test2") { showToast("select test2") })
                    add(MIUIPopupData("test3") { showToast("select test3") })
                }, "test"))
                Line()
                TitleText("Title")
                TextSummaryArrow(TextSummaryV("test", tips = "summary"))
                Text("SeekbarWithText")
                SeekBarWithText("seekbar", 0, 100, 0)
                Line()
                TitleText("DataBinding")
                val binding = GetDataBinding(true) { view, flags, data ->
                    when (flags) {
                        1 -> (view as Switch).isEnabled = data as Boolean
                        2 -> view.visibility = if (data as Boolean) View.VISIBLE else View.GONE
                    }
                }
                TextWithSwitch(TextV("data-binding"), SwitchV("binding", dataBindingSend = binding.bindingSend))
                TextWithSwitch(TextV("test123"), SwitchV("test123", dataBindingRecv = binding.binding.getRecv(1)))
                TextSummaryArrow(TextSummaryV("test"), dataBindingRecv = binding.binding.getRecv(2))
            }

            registerMenu("Menu") {
                Text("ThisMenu")
                Text("ThisMenu")
                Text("ThisMenu")
                Text("ThisMenu")
                Text("ThisMenu")
                Text("ThisMenu")
                Text("ThisMenu")
                Text("ThisMenu")
                Text("ThisMenu")
                Text("ThisMenu")
                Text("ThisMenu")
                Text("ThisMenu")
                Text("ThisMenu")
                Text("ThisMenu")
                Text("ThisMenu")
                Text("ThisMenu")
                Text("ThisMenu")
            }

            register("test", "test") {
                Text("ThisTest")
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        setSP(getPreferences(0))
        super.onCreate(savedInstanceState)
    }

    fun showToast(string: String) {
        handler.post {
            Toast.makeText(this, string, Toast.LENGTH_LONG).show()
        }
    }
}