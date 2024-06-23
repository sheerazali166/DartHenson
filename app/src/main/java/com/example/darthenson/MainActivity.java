package com.example.darthenson;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.nameEditText)
    EditText nameEditText;

    @BindView(R.id.messageEditText)
    EditText messageEditText;

    @BindView(R.id.checkbox)
    CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    // without test

    @OnClick(R.id.button)
    public void submit() {

        Intent intent = Henson.with(this)
                .gotoHelloAtivity()
                .message(messageEditText.getText().toString())
                .name(nameEditText.getText().toString())
                .showToast(checkBox.isChecked())
                .build();

        startActivity(intent);

    }

}