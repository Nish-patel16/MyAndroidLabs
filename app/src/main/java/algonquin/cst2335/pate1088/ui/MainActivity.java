package algonquin.cst2335.pate1088.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import algonquin.cst2335.pate1088.data.MainViewModel;
import algonquin.cst2335.pate1088.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

    private MainViewModel model;
    private ActivityMainBinding variableBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        model = new ViewModelProvider(this).get(MainViewModel.class);

        variableBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(variableBinding.getRoot());

        TextView mytext = variableBinding.textview;
        Button mybutton = variableBinding.mybutton;
        EditText myedit = variableBinding.myedittext;
        CheckBox mycheckbox = variableBinding.checkbox;
        Switch mySwitch = variableBinding.Switch;
        RadioButton myradiobtn = variableBinding.Radio;
        ImageButton imageButton = variableBinding.myimagebutton;

        variableBinding.mybutton.setOnClickListener(click ->{
            model.editString.postValue(variableBinding.myedittext.getText().toString());
        });

        model.editString.observe(this, s -> {
            variableBinding.textview.setText("Your edit text has: " + s);
        });


        model.editBoolean.observe(this, selected -> {
            variableBinding.checkbox.setChecked(selected);
            variableBinding.Switch.setChecked(selected);
            variableBinding.Radio.setChecked(selected);

            String toast_message = "The value is now: " + selected;
            Toast.makeText(MainActivity.this, toast_message, Toast.LENGTH_SHORT).show();
        });

        mycheckbox.setOnCheckedChangeListener( (btn, isChecked) -> model.editBoolean.postValue(isChecked));

        mySwitch.setOnCheckedChangeListener( (btn, isChecked) -> model.editBoolean.postValue(isChecked));

        myradiobtn.setOnCheckedChangeListener( (btn, isChecked) -> model.editBoolean.postValue(isChecked));

        imageButton.setOnClickListener(v -> {
            int width = v.getWidth();
            int height = v.getHeight();

            String message = "The width = " + width + " and height = " + height;
            Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
        });

        }
    }
