package com.hardik.covidindiatracker

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import mehdi.sakout.aboutpage.AboutPage
import mehdi.sakout.aboutpage.Element
import android.view.Gravity
import android.view.View
import android.widget.Toast

import java.util.Calendar;


class InfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val aboutPage : View
        aboutPage = AboutPage(this)
            .isRTL(false)
            .addItem(Element().setTitle("This app helps in tracking the Covid-19 cases in India."))
            .setDescription("App by Hardik Dua")
            .setImage(R.drawable.ic_hardik)
            .addItem(Element().setTitle("COVID-19 Tracker India"))
            .addItem(Element().setTitle("Version 1.0"))
            .addGroup("Connect With Me")
            .addEmail("hardikdua08@gmail.com")
            .addTwitter("Hardikdua08")
            .addWebsite("http://hardikdua.blogspot.com/")
            .addGitHub("hardik0899")
            .addItem(Element().setTitle("www.covid19india.org").setOnClickListener {
                val covid19India = Intent(Intent.ACTION_VIEW)
                covid19India.setData(Uri.parse("https://www.covid19india.org/"))
                startActivity(covid19India)
            })
            .addItem(getCopyRightsElement())
            .create()
        setContentView(aboutPage)
    }

    private fun getCopyRightsElement() : Element {
        val copyRightsElement = Element()
        val copyrights = String.format(getString(R.string.copy_right), Calendar.getInstance().get(Calendar.YEAR))
        copyRightsElement.setTitle(copyrights)
        copyRightsElement.setIconDrawable(R.drawable.about_icon_copy_right)
        copyRightsElement.setIconTint(mehdi.sakout.aboutpage.R.color.about_item_icon_color)
        copyRightsElement.setGravity(Gravity.CENTER)
        copyRightsElement.setOnClickListener{
            Toast.makeText(this, copyrights, Toast.LENGTH_SHORT).show()
        }
        return copyRightsElement
    }
}
