package com.alexxpasta.simpletodo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import static com.alexxpasta.simpletodo.R.id.etNewItem;

public class EditItemActivity extends AppCompatActivity {
    private EditText etItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);

        String currentItemName = getIntent().getStringExtra(Constants.EXTRA_CURRENT_ITEM_NAME);
        etItem = (EditText) findViewById(R.id.etItem);
        etItem.setText(currentItemName);
        etItem.setSelection(etItem.getText().length());
    }

    public void onSave(View v) {
        String itemText = etItem.getText().toString();
        if (itemText.isEmpty()) {
            Toast.makeText(this, "Todo item should not be empty...", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent data = new Intent();
        data.putExtra(Constants.EXTRA_NEW_ITEM_NAME, itemText);
        data.putExtra(Constants.EXTRA_EDIT_ITEM_POSITION, getIntent().getIntExtra(Constants.EXTRA_EDIT_ITEM_POSITION, -1));
        setResult(RESULT_OK, data);
        finish();
    }
}
