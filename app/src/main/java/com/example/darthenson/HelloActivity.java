package com.example.darthenson;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HelloActivity extends AppCompatActivity {

    @InjectExtra String name;
    @InjectExtra String message;
    @InjectExtra boolean showToast;

    @BindView(R.id.textView2)
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        ButterKnife.bind(this);
        Dart.inject(this);

        textView.setText("YOUR NAME IS: " + name + "\\n YOUR MESSAGE:" + message);

        if (showToast) {
            Toast.makeText(this, "SHOW TOAST WAS SELECTED", Toast.LENGTH_SHORT).show();
        }

        setContentView(R.layout.activity_hello);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }


}