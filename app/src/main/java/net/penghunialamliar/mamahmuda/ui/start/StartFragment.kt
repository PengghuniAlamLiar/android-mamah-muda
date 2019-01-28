package net.penghunialamliar.mamahmuda.ui.start

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.start_fragment.*
import net.penghunialamliar.mamahmuda.R

class StartFragment : Fragment() {

    companion object {
        fun newInstance() = StartFragment()
    }

    private lateinit var viewModel: StartViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.start_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(StartViewModel::class.java)

        // Create the observer which updates the UI.
        val message = Observer<String> { newName ->
            // Update the UI, in this case, a TextView.
            message.text = newName
        }

        // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
        viewModel.data.observe(this, message)
    }

}
