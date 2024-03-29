package com.dev.creditScoreApplication.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.dev.creditScoreApplication.R
import com.dev.creditScoreApplication.models.CreditReportInfo
import kotlinx.android.synthetic.main.fragment_detail.*

class DetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    companion object {
        const val CREDIT_REPORT_INFO_DATA = "creditInfoData"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        back_button.setOnClickListener {
            findNavController().navigateUp()
        }

        //get data passed in bundle
        val bundle = arguments
        if(bundle != null) {
            //set details page data
            val creditReportInfo = bundle.getParcelable<CreditReportInfo>(CREDIT_REPORT_INFO_DATA)
            client_reference_value_text.text = creditReportInfo?.clientRef.toString()
            short_term_debt_limit_value.text =
                creditReportInfo?.currentShortTermDebt.toString()
            short_term_credit_limit_value.text =
                creditReportInfo?.currentShortTermCreditLimit.toString()
        }
    }
}