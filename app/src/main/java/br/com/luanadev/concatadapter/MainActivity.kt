package br.com.luanadev.concatadapter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ConcatAdapter
import br.com.luanadev.concatadapter.databinding.ActivityMainBinding
import by.kirich1409.viewbindingdelegate.viewBinding

class MainActivity : AppCompatActivity() {

    private val binding by viewBinding {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val programmingLanguagesAdapter by lazy {ProgrammingLanguagesAdapter()}
    private val tipsAdapter by lazy {TipsAdapter ()}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        tipsAdapter.apply {
            gotItItemClickListener = {
                onDismissTips()
            }
        }

        binding.recyclerFeed.adapter = ConcatAdapter(tipsAdapter, programmingLanguagesAdapter)

        programmingLanguagesAdapter.submitList(programmingLanguages)
        tipsAdapter.submitList(tips)
    }

    private fun onDismissTips() {
        tipsAdapter.notifyItemRemoved(0)
    }
}
