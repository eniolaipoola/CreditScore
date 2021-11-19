package com.dev.creditscoreapplication.ui

import android.os.Bundle
import android.text.SpannableStringBuilder
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.dev.creditscoreapplication.R
import kotlinx.android.synthetic.main.fragment_home.*
import com.dev.creditscoreapplication.models.Result
import com.dev.creditscoreapplication.utils.hide
import com.dev.creditscoreapplication.utils.show
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private val viewModel by viewModels<HomeViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    private fun setUpObservers() {
        viewModel.creditScoreState.observe(viewLifecycleOwner, { result ->
            when (result) {
                is Result.Error -> {
                    //show error message
                    val message = result.error
                    Toast.makeText(activity?.applicationContext, message,
                        Toast.LENGTH_LONG).show()
                }

                is Result.Success -> {
                    loader.hide()
                    //update donut view
                    val creditScoreData = result.value
                    val score = creditScoreData.creditReportInfo.score
                    val maximumScore = creditScoreData.creditReportInfo.maxScoreValue

                    credit_score_donut_view.calculateSweepAngle(
                        score.toFloat(),
                        maximumScore.toFloat()
                    )

                    val spannable = SpannableStringBuilder(
                        "Your credit score is $score out of $maximumScore")
                    //spannable.setSpan()
                    credit_score_donut_view.setText("Your credit score is $score out of $maximumScore")

                }

                is Result.Loading -> {
                    //show loader
                    if(result.loading){
                        loader.show()
                    } else {
                        loader.hide()
                    }
                }
            }
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.fetchRemoteCreditScoreData()
        viewModel.getCreditScoreData()

        credit_score_donut_view.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeToDetail()
            findNavController().navigate(action)
        }

        setUpObservers()

    }
}


//write test for donut-view and api call simulation
//design detail page
//display credit score information on detail page
//write ui tests for detail page
