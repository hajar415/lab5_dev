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

public class TemperatureTab extends Fragment {

    RadioGroup directionGroupTemp;
    RadioButton rbCelsius, rbFahrenheit;
    EditText inputTemp;
    Button btnConvertir;
    TextView resultTemp;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_temp, container, false);

        directionGroupTemp = view.findViewById(R.id.directionGroupTemp);
        rbCelsius          = view.findViewById(R.id.rbCelsius);
        rbFahrenheit       = view.findViewById(R.id.rbFahrenheit);
        inputTemp          = view.findViewById(R.id.inputTemp);
        btnConvertir       = view.findViewById(R.id.btnConvertir);
        resultTemp         = view.findViewById(R.id.resultTemp);

        btnConvertir.setOnClickListener(v -> {
            String rawInput = inputTemp.getText().toString();
            if (TextUtils.isEmpty(rawInput)) {
                Toast.makeText(getContext(),
                        getString(R.string.err_empty),
                        Toast.LENGTH_SHORT).show();
                return;
            }
            double inputVal  = Double.parseDouble(rawInput);
            double converted = convertTemperature(inputVal,
                    directionGroupTemp.getCheckedRadioButtonId());
            resultTemp.setText("→ " + String.format("%.2f", converted));
        });

        return view;
    }

    private double convertTemperature(double inputVal, int checkedId) {
        if (checkedId == R.id.rbCelsius)
            return (inputVal * 1.8) + 32.0;
        else
            return (inputVal - 32.0) / 1.8;
    }
}