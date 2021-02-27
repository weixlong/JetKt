package com.wxl.xjg

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.wxl.common.life.LifecycleManager
import com.wxl.common.bean.UserBean
import com.wxl.common.life.ViewModelQuick
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var user: UserBean = UserBean()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        DataCache.put(user)

        LifecycleManager.manager.registerLiveData(user,this.lifecycle)

        ViewModelQuick.create(this, MainViewModel::class.java,this,main_text_view)

        user.observe(this, Observer {
            main_text_view.text = it.userName
        })

    }

}




