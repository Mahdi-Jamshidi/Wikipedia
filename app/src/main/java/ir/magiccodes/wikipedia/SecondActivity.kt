package ir.magiccodes.wikipedia

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import ir.magiccodes.wikipedia.data.ItemPost
import ir.magiccodes.wikipedia.databinding.ActivitySecondBinding
import ir.magiccodes.wikipedia.fragment.KEY_SEND_DATA_TO_SECOND_ACTIVITY

class SecondActivity : AppCompatActivity() {
    lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbarAsli)
        binding.collapsingMain.setExpandedTitleColor(
            ContextCompat.getColor(
                this,
                android.R.color.transparent
            )
        )
        supportActionBar!!.setHomeButtonEnabled(true)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        val dataPost = intent.getParcelableExtra<ItemPost>(KEY_SEND_DATA_TO_SECOND_ACTIVITY)
        if (dataPost != null) {

            showData(dataPost)
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
        }
        return true
    }

    private fun showData(itemPost: ItemPost) {

        Glide.with(this)
            .load(itemPost.imgUrl)
            .into(binding.imgDetail)

        binding.txtDetailTitle.text = itemPost.txtTitle
        binding.txtDetailSubtitle.text = itemPost.txtSubtitle
        binding.txtDetailText.text = itemPost.txtDetail

        binding.fabDetailOpenWikipedia.setOnClickListener {
            val url = "https://en.wikipedia.org/wiki/Main_Page"

            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        }

        binding.collapsingMain.title = itemPost.txtTitle
    }

}
