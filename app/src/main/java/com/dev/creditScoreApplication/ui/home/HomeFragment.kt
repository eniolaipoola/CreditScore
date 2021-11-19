package com.dev.creditScoreApplication.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.dev.creditScoreApplication.R
import com.dev.creditScoreApplication.models.CreditReportInfo
import kotlinx.android.synthetic.main.fragment_home.*
import com.dev.creditScoreApplication.models.Result
import com.dev.creditScoreApplication.utils.hide
import com.dev.creditScoreApplication.utils.show
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private val viewModel by viewModels<HomeViewModel>()
    lateinit var creditReportInfo: CreditReportInfo

    companion object {
        const val CREDIT_REPORT_INFO_DATA = "creditInfoData"
    }

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

                    creditReportInfo = creditScoreData.creditReportInfo

                    credit_score_donut_view.calculateSweepAngle(
                        score.toFloat(),
                        maximumScore.toFloat()
                    )

                    accountStatusValue.text = result.value.accountIDVStatus
                    personaTypeValue.text = result.value.personaType
                    credit_score_donut_view.setText(
                        "Your credit score is",
                        score.toString(),"out of $maximumScore")

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
            val bundle = Bundle()
            bundle.putParcelable(CREDIT_REPORT_INFO_DATA, creditReportInfo)
            findNavController().navigate(R.id.detailFragment, bundle)
        }

        setUpObservers()

    }
}