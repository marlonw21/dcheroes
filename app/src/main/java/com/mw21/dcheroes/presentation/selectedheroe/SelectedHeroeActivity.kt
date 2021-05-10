package com.mw21.dcheroes.presentation.selectedheroe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.content.res.AppCompatResources
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import com.mw21.dcheroes.R
import com.mw21.dcheroes.data.model.selectedheroe.SelectedHeroe
import com.mw21.dcheroes.databinding.ActivitySelectedHeroeBinding
import com.mw21.dcheroes.presentation.di.Injector
import javax.inject.Inject

class SelectedHeroeActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: SelectedHeroeViewModelFactory
    private lateinit var selectedHeroeViewModel: SelectedHeroeViewModel
    lateinit var binding: ActivitySelectedHeroeBinding
    lateinit var selectedHeroe: SelectedHeroe
    var isSaved = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bundle = intent.extras
        val path = bundle?.getString("path")
        binding = DataBindingUtil.setContentView(this, R.layout.activity_selected_heroe)
        (application as Injector).createSelectedHeroeSubComponent()
            .inject(this)
        selectedHeroeViewModel = ViewModelProvider(this, factory)
            .get(SelectedHeroeViewModel::class.java)


        binding.floatingActionButton.setOnClickListener {
      //      Log.d("Object", selectedHeroe.toString())
     //       Snackbar.make(binding.root, "TEst", Snackbar.LENGTH_SHORT).show()
            if (isSaved){
                //Delete from database
                selectedHeroeViewModel.deleteHeroFromDB(path.toString())
                binding.floatingActionButton.setImageDrawable(AppCompatResources.getDrawable(this,R.drawable.ic_unsaved))
                Snackbar.make(binding.root, "Hero deleted", Snackbar.LENGTH_SHORT).show()
                isSaved = false

         //       Log.d("Hero", "is saved")
            }else{
                selectedHeroeViewModel.saveHeroToDB(selectedHeroe)
       //         Log.d("RESULT FROM DB ", result.toString())
                //Validar si el objeto fue guardado y mostrar aviso en un mensaje
                binding.floatingActionButton.setImageDrawable(AppCompatResources.getDrawable(this,R.drawable.ic_saved))
                Snackbar.make(binding.root, "Hero Saved", Snackbar.LENGTH_SHORT).show()
                isSaved = true
            }

        }

        val responseDB = selectedHeroeViewModel.getSelectedHeroeFromDB(path.toString())
        responseDB.observe(this, Observer {
            Log.d("RESPONSE DB", it.toString())
            if (it != null){
                isSaved = true
                binding.floatingActionButton.setImageDrawable(AppCompatResources.getDrawable(this,R.drawable.ic_saved))
                getHeoreFromDB(it)
                selectedHeroe = it
            }else{
                isSaved = false
                getHeroe(path.toString())
            }
        })
    }

    private fun getHeroe(path: String) {
        binding.selectedHeroProgressBar.visibility = View.VISIBLE
        val responseLiveData = selectedHeroeViewModel.getSelectedHeroe(path)
        responseLiveData.observe(this, Observer {
         //   Log.d("reponse", it.toString())
            if(it != null){
                binding.ivError.visibility = View.GONE
                binding.tvError.visibility = View.GONE
                binding.floatingActionButton.isClickable = true
                binding.floatingActionButton.visibility = View.VISIBLE
                binding.selectedHeroProgressBar.visibility = View.GONE
                binding.tvName.text = it?.name
                binding.tvHeroName.text = it?.hero_name
                binding.tvDescription.text = it?.description
                Glide.with(binding.imageView2.context).load(it?.img_heroe).into(binding.imageView2)
                selectedHeroe = it
            }else{
                binding.selectedHeroProgressBar.visibility = View.GONE
                binding.ivError.visibility = View.VISIBLE
                binding.tvError.visibility = View.VISIBLE
            }
        })
    }

    private fun getHeoreFromDB(selectedHeroe: SelectedHeroe?){
        binding.ivError.visibility = View.GONE
        binding.tvError.visibility = View.GONE
        binding.floatingActionButton.isClickable = true
        binding.floatingActionButton.visibility = View.VISIBLE
        binding.selectedHeroProgressBar.visibility = View.GONE
        binding.tvName.text = selectedHeroe?.name
        binding.tvHeroName.text = selectedHeroe?.hero_name
        binding.tvDescription.text = selectedHeroe?.description
        Glide.with(binding.imageView2.context).load(selectedHeroe?.img_heroe).into(binding.imageView2)
        //selectedHeroe = selectedHeroe
    }
}