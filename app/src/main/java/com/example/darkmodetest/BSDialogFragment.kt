package com.example.darkmodetest

import android.app.Dialog
import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BSDialogFragment : BottomSheetDialogFragment() {

    val TAG = "BSDialog"

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return super.onCreateDialog(savedInstanceState).apply {
            setOnShowListener { dialogInterface ->
                val bottomSheetDialog = dialogInterface as BottomSheetDialog
                bottomSheetDialog.findViewById<ViewGroup>(R.id.design_bottom_sheet)?.let {
                    BottomSheetBehavior.from(it).apply {
                        state = BottomSheetBehavior.STATE_COLLAPSED
                        peekHeight = BottomSheetBehavior.PEEK_HEIGHT_AUTO
                    }
                    it.setBackgroundResource(android.R.color.transparent)
                }
            }
            setCanceledOnTouchOutside(true)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val value = TypedValue()
        context?.theme?.resolveAttribute(android.R.attr.textColorPrimary, value, true)
        Log.i(TAG,"textColorPrimary:$value")
        context?.theme?.resolveAttribute(android.R.attr.colorForeground, value, true)
        Log.i(TAG,"colorForeground:$value")
    }
}