package com.wxl.xjg

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.wxl.common.life.LifecycleManager
import com.wxl.common.bean.UserBean
import com.wxl.common.life.ViewModelQuick

class MainActivity : AppCompatActivity() {

    var user: UserBean = UserBean()
    lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.main_text_view)

        DataCache.put(user)

        LifecycleManager.manager.registerLiveData(user,this.lifecycle)

        ViewModelQuick.create(this, MainViewModel::class.java,this,textView)

        user.observe(this, Observer {
            textView.text = it.userName
        })

    }

}




