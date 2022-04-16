package cn.fkj233.blockmiui

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Switch
import android.widget.Toast
import cn.fkj233.ui.activity.MIUIActivity
import cn.fkj233.ui.activity.data.AsyncInit
import cn.fkj233.ui.activity.data.DefValue
import cn.fkj233.ui.activity.fragment.MIUIFragment
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
            registerMain("Home", false) {
                TextSummaryArrow(TextSummaryV("showTest", onClickListener = {
                    showFragment("test")
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
                TextSummaryArrow(TextSummaryV("test", tips = "summary", onClickListener = {}))
                TextSummaryWithSwitch(TextSummaryV("test", tips = "summary"), SwitchV("test12312312"))
                Author(getDrawable(R.mipmap.ic_launcher)!!, "Test", "Test123")
                Author(getDrawable(R.mipmap.ic_launcher)!!, "Test")
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
                val binding = GetDataBinding(object : DefValue {
                    override fun getValue(): Any {
                        return safeSP.getBoolean("binding", false)
                    }
                }) { view, flags, data ->
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

            register("async", "Async", true) {
                async = object: AsyncInit {
                    override val skipLoadItem: Boolean = true

                    override fun onInit(fragment: MIUIFragment) {
                        fragment.showLoading()
                        Thread.sleep(1000)
                        fragment.addItem(TextV("Test"))
                        Thread.sleep(1000)
                        fragment.addItem(TextV("Test1"))
                        Thread.sleep(1000)
                        fragment.addItem(TextV("Test2"))
                        Thread.sleep(1000)
                        fragment.addItem(TextV("Test3"))
                        Thread.sleep(1000)
                        fragment.closeLoading()
                        fragment.initData()
                    }
                }
                Text("ThisAsync")
                Text("ThisAsync2")
                Text("ThisAsync3")
                Text("ThisAsync4")
                Text("ThisAsync5")
                Text("ThisAsync6")
            }

            register("test", "test", false) {
                Text("ThisTest")
                Text("ThisTest1")
                TextSummaryArrow(TextSummaryV("showTest2", onClickListener = {
                    showFragment("test2")
                }))
                val binding = GetDataBinding(object : DefValue {
                    override fun getValue(): Any {
                        return safeSP.getBoolean("binding123", false)
                    }
                }) { view, flags, data ->
                    when (flags) {
                        1 -> (view as Switch).isEnabled = data as Boolean
                        2 -> view.visibility = if (data as Boolean) View.VISIBLE else View.GONE
                    }
                }
                TextWithSwitch(TextV("data-binding"), SwitchV("binding123", dataBindingSend = binding.bindingSend))
                TextWithSwitch(TextV("test123123"), SwitchV("test123123", dataBindingRecv = binding.binding.getRecv(1)))
                TextSummaryArrow(TextSummaryV("test"), dataBindingRecv = binding.binding.getRecv(2))
            }

            register("test2", "test2", true) {
                Text("ThisTest2")
                Text("ThisTest3")
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        setSP(getPreferences(0))
        super.onCreate(savedInstanceState)
    }

    private fun showToast(string: String) {
        handler.post {
            Toast.makeText(this, string, Toast.LENGTH_LONG).show()
        }
    }
}