package com.example.sharedexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText et_save;
    String shared = "file";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_save = (EditText)findViewById(R.id.et_save);
        SharedPreferences sharedPreferences = getSharedPreferences(shared, 0);
        // 변경된 내용이 저장된 preference에 있는 내용을 반환
        String value = sharedPreferences.getString("lee", "");
        et_save.setText(value);

    }
    // 해당 액티비티를 벗어났을 때 생명주기가 파괴되는데 호출하는 함수
    // 액티비티를 벗어 났을 때 데이터를 고유하게 저장하고 다시 액티비티가 생성될 때 그 데이터를 불러오도록 하기위함
    @Override
    protected void onDestroy() {
        super.onDestroy();
        SharedPreferences sharedPreferences = getSharedPreferences(shared, 0);
        // 해당 파일의 데이터를 불러올 때 써야하는 함수
        SharedPreferences.Editor editor = sharedPreferences.edit();
        // editText에 쓴 내용을 value에 저장
        String value = et_save.getText().toString();
        editor.putString("lee", value);
        // sharedPreferences에 저장 되어있는 내용을 업데이트
        editor.commit();
    }
}