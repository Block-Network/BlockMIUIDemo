package cn.fkj233.blockmiui

import cn.fkj233.ui.activity.annotation.BMPage
import cn.fkj233.ui.activity.data.BasePage

@BMPage("test2", "Test2")
class Test2Page : BasePage() {
    override fun onCreate() {
        Text("ThisTest2")
        Text("ThisTest3")
    }
}