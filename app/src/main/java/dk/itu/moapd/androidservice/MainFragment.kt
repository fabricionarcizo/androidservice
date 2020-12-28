package dk.itu.moapd.androidservice

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment(), View.OnClickListener {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        start_button.setOnClickListener(this)
        stop_button.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        if (view.id == R.id.start_button)
            Intent(context, AudioService::class.java).also {
                activity!!.startService(it)
            }
        else if (view.id == R.id.stop_button)
            Intent(context, AudioService::class.java).also {
                activity!!.stopService(it)
            }
    }

}
