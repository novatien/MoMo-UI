package com.notin.momotest.ui.fragment

import android.app.Activity
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.notin.momotest.R
import kotlinx.android.synthetic.main.fragment_momo.*


class FriendFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.fragment_friend, container, false)
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (context as Activity).window.statusBarColor = ContextCompat.getColor(activity as Context, R.color.white)
        (context as AppCompatActivity).setSupportActionBar(toolbar)
        (context as AppCompatActivity).supportActionBar!!.setDisplayShowTitleEnabled(false)

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_friend, menu)
    }
}