package com.example.convertisseurunites;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class DistanceTab extends Fragment {

    RadioGroup directionGroupDist;
    RadioButton rbKmToMiles, rbMilesToKm;
    EditText inputDist;
    Button btnConvertirDist;
    TextView resultDist;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_distance, container, false);

        directionGroupDist = view.findViewById(R.id.directionGroupDist);
        rbKmToMiles        = view.findViewById(R.id.rbKmToMiles);
        rbMilesToKm        = view.findViewById(R.id.rbMilesToKm);
        inputDist          = view.findViewById(R.id.inputDist);
        btnConvertirDist   = view.findViewById(R.id.btnConvertirDist);
        resultDist         = view.findViewById(R.id.resultDist);

        btnConvertirDist.setOnClickListener(v -> {
            String rawInput = inputDist.getText().toString();
            if (TextUtils.isEmpty(rawInput)) {
                Toast.makeText(getContext(),
                        getString(R.string.err_empty),
                        Toast.LENGTH_SHORT).show();
                return;
            }
            double inputVal  = Double.parseDouble(rawInput);
            double converted = convertDistance(inputVal,
                    directionGroupDist.getCheckedRadioButtonId());
            resultDist.setText("→ " + String.format("%.2f", converted));
        });

        return view;
    }

    private double convertDistance(double inputVal, int checkedId) {
        if (checkedId == R.id.rbKmToMiles)
            return inputVal * 0.6214;
        else
            return inputVal / 0.6214;
    }
}