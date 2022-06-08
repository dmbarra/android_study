package com.androidstudy.ui.home

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.androidstudy.R
import com.androidstudy.ui.login.LoginFragment

class HomeFragment : Fragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    private val bundle = Bundle()
    private lateinit var viewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_home, container, false)

        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        val materialToolbar: Toolbar = rootView.findViewById(R.id.toolbar)
        (activity as AppCompatActivity).setSupportActionBar(materialToolbar)

        return rootView
    }

    override fun onCreateOptionsMenu(menu: Menu, menuInflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater)
        menuInflater.inflate(R.menu.toolbar_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.item_login_menu -> {
                replaceFragmentOnFrame(LoginFragment())
            }
            else -> {}
        }
        return super.onOptionsItemSelected(item)
    }

    private fun replaceFragmentOnFrame(fragment: Fragment) {
        fragment.arguments = bundle
        val fragmentTransaction = activity?.supportFragmentManager?.beginTransaction()
        if (fragmentTransaction != null) {
            fragmentTransaction.replace(R.id.frame_menu_layout, fragment)
            fragmentTransaction.commit()
        }
    }

}