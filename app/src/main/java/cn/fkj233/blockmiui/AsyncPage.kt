package cn.fkj233.blockmiui

import cn.fkj233.ui.activity.annotation.BMPage
import cn.fkj233.ui.activity.data.BasePage
import cn.fkj233.ui.activity.fragment.MIUIFragment
import cn.fkj233.ui.activity.view.TextV

@BMPage("async", "Async")
class AsyncPage : BasePage() {
    init {
        skipLoadItem = true
    }

    override fun asyncInit(fragment: MIUIFragment) {
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

    override fun onCreate() {
        Text("ThisAsync")
        Text("ThisAsync2")
        Text("ThisAsync3")
        Text("ThisAsync4")
        Text("ThisAsync5")
        Text("ThisAsync6")
    }
}