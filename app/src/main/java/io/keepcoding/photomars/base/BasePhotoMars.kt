package io.keepcoding.photomars.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment


abstract class BasePhotoMars {

    abstract class BaseActivity : AppCompatActivity() {

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(getXmlLayout())

            initValues()
            initListeners()
        }

        abstract fun getXmlLayout() : Int
        abstract fun initValues()
        abstract fun initListeners()
    }

    abstract class BaseFragment : Fragment() {

        override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
            return inflater.inflate(getXmlLayout(), container, false)
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)

            initValues()
            initListeners()
        }

        abstract fun getXmlLayout() : Int
        abstract fun initValues()
        abstract fun initListeners()
    }
}