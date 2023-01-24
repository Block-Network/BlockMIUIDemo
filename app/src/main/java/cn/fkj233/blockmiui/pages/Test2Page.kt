package cn.fkj233.blockmiui.pages

import cn.fkj233.ui.activity.annotation.BMPage
import cn.fkj233.ui.activity.data.BasePage

@BMPage("test2", "Test2", hideMenu = false)
class Test2Page : BasePage() {
    override fun onCreate() {
        Text("ThisTest2")
        Text("ThisTest3")
    }
}