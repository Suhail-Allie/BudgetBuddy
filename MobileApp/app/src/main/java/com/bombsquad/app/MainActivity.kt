package com.bombsquad.app

import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private val navy = Color.rgb(23,37,84); private val blue = Color.rgb(37,99,235); private val bg = Color.rgb(244,247,251)
    private lateinit var root: LinearLayout
    private fun tv(text:String,size:Float=16f,bold:Boolean=false):TextView=TextView(this).apply{this.text=text;textSize=size;setTextColor(Color.rgb(23,32,51));if(bold)setTypeface(null,1);setPadding(0,8,0,8)}
    private fun btn(text:String, action:()->Unit)=Button(this).apply{this.text=text;setOnClickListener{action()};isAllCaps=false}
    override fun onCreate(b:Bundle?){super.onCreate(b);showLogin()}
    private fun base():LinearLayout{root=LinearLayout(this).apply{orientation=LinearLayout.VERTICAL;setBackgroundColor(bg);setPadding(20,20,20,20)};return root}
    private fun showLogin(){val r=base(); val space=Space(this);r.addView(space,LinearLayout.LayoutParams(1,40));r.addView(tv("BOMB SQUAD",30f,true));r.addView(tv("Client Management & Project Tracking",16f));r.addView(Space(this),LinearLayout.LayoutParams(1,25));val email=EditText(this).apply{hint="Email";inputType=33};r.addView(email,LinearLayout.LayoutParams(-1,-2));val pass=EditText(this).apply{hint="Password";inputType=129};r.addView(pass,LinearLayout.LayoutParams(-1,-2));r.addView(btn("Login"){showDashboard()},LinearLayout.LayoutParams(-1,-2));r.addView(tv("Forgot password?",14f));r.addView(btn("Create Account"){Toast.makeText(this,"Registration screen",Toast.LENGTH_SHORT).show()});setContentView(r)}
    private fun header(title:String):LinearLayout{val h=LinearLayout(this).apply{gravity=Gravity.CENTER_VERTICAL};val t=tv(title,26f,true);h.addView(t,LinearLayout.LayoutParams(0,-2,1f));h.addView(btn("🔔"){showNotifications()});return h}
    private fun showDashboard(){val r=base();r.addView(header("Dashboard"));r.addView(tv("Welcome back!",16f));val row=LinearLayout(this).apply{orientation=LinearLayout.HORIZONTAL};row.addView(stat("3","Active Projects"),LinearLayout.LayoutParams(0,-2,1f));row.addView(stat("2","Invoices"),LinearLayout.LayoutParams(0,-2,1f));r.addView(row);r.addView(tv("My Projects",20f,true));r.addView(project("Website Redesign","70%","In Progress"));r.addView(project("Mobile App","45%","Planning"));r.addView(tv("Recent Notifications",20f,true));r.addView(tv("✓ Milestone completed\n$ Invoice generated\n↑ Document uploaded",15f));r.addView(nav());setContentView(r)}
    private fun stat(n:String,label:String)=LinearLayout(this).apply{orientation=LinearLayout.VERTICAL;setPadding(12,12,12,12);addView(tv(n,28f,true));addView(tv(label,13f))}
    private fun project(name:String,p:String,status:String)=LinearLayout(this).apply{orientation=LinearLayout.VERTICAL;setPadding(15,10,15,10);addView(tv(name,17f,true));addView(tv("$status   •   $p",13f));addView(btn("View Project"){showProjectDetails()})}
    private fun nav():LinearLayout=LinearLayout(this).apply{gravity=Gravity.CENTER;addView(btn("Home"){showDashboard()});addView(btn("Projects"){showProjects()});addView(btn("Invoices"){showInvoices()});addView(btn("Profile"){showProfile()})}
    private fun showProjects(){val r=base();r.addView(header("Projects"));r.addView(tv("Track your active and completed projects."));r.addView(project("Website Redesign","70%","In Progress"));r.addView(project("Mobile App","45%","Planning"));r.addView(project("Client Portal","90%","On Track"));r.addView(nav());setContentView(r)}
    private fun showProjectDetails(){val r=base();r.addView(header("Project Details"));r.addView(tv("Website Redesign",24f,true));r.addView(tv("Acme Retail • Project #PRJ-001"));r.addView(tv("Progress: 70%",18f,true));r.addView(tv("Milestones",20f,true));r.addView(tv("✓ Requirements approved\n✓ UI/UX completed\n◉ Development in progress\n○ Testing\n○ Deployment"));r.addView(tv("Documents",20f,true));r.addView(tv("Project Brief.pdf\nUI Designs.fig"));r.addView(nav());setContentView(r)}
    private fun showInvoices(){val r=base();r.addView(header("Invoices"));r.addView(tv("INV-0024",20f,true));r.addView(tv("Website Redesign • R31,500 • Due 20 Sep 2026"));r.addView(tv("Pending",14f));r.addView(btn("View Invoice"){Toast.makeText(this,"Invoice details",Toast.LENGTH_SHORT).show()});r.addView(tv("INV-0023",20f,true));r.addView(tv("Mobile App • R45,000 • Due 30 Sep 2026"));r.addView(tv("Paid",14f));r.addView(nav());setContentView(r)}
    private fun showNotifications(){val r=base();r.addView(header("Notifications"));r.addView(tv("✓  Milestone completed\nUI/UX milestone for Website Redesign was completed."));r.addView(tv("$  Invoice available\nINV-0024 has been generated."));r.addView(tv("!  Project update\nMobile App progress changed to 45%."));r.addView(nav());setContentView(r)}
    private fun showProfile(){val r=base();r.addView(header("Profile & Settings"));r.addView(tv("Account",20f,true));r.addView(tv("Demo User\nclient@example.com\nRole: Client"));r.addView(CheckBox(this).apply{text="Email notifications";isChecked=true});r.addView(CheckBox(this).apply{text="Project milestone alerts";isChecked=true});r.addView(btn("Save Changes"){Toast.makeText(this,"Changes saved",Toast.LENGTH_SHORT).show()});r.addView(nav());setContentView(r)}
}
