package com.mw21.dcheroes.presentation.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.mw21.dcheroes.R
import com.mw21.dcheroes.data.model.dcheroes.Heroe
import com.mw21.dcheroes.data.model.selectedheroe.SelectedHeroe
import com.mw21.dcheroes.databinding.ActivityHomeBinding
import com.mw21.dcheroes.presentation.di.Injector
import com.mw21.dcheroes.presentation.selectedheroe.SelectedHeroeActivity
import javax.inject.Inject


class HomeActivity : AppCompatActivity(), OnItemClickListener {
    @Inject
    lateinit var factory: HomeViewModelFactory
    private lateinit var homeViewModel: HomeViewModel
    lateinit var binding: ActivityHomeBinding
    private lateinit var adapter: HomeAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        (application as Injector).createDcHeroesSubComponent()
            .inject(this)

        homeViewModel = ViewModelProvider(this,factory)
            .get(HomeViewModel::class.java)

        initRecyclerView()

    }

    private fun initRecyclerView(){
        binding.homeRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = HomeAdapter(this)
        binding.homeRecyclerView.adapter = adapter
            displayHeroes()
    }

    private fun displayHeroes() {
        binding.homeProgressBar.visibility = View.VISIBLE
        val responseLiveData = homeViewModel.getDcHeroes()
        responseLiveData.observe(this, Observer {
            Log.d("response", it.toString())
            if (it != null) {
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.homeProgressBar.visibility = View.GONE
            } else {
                binding.homeProgressBar.visibility = View.GONE
                Toast.makeText(this, "Error: No data", Toast.LENGTH_SHORT).show()
            }
        })
    }

    override fun onItemClick(heroe: Heroe) {
        val intent = Intent(this, SelectedHeroeActivity::class.java)
        intent.putExtra("path",heroe.id)
        startActivity(intent)

    }
}