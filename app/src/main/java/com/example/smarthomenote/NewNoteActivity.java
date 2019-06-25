package com.example.smarthomenote;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.example.smarthomenote.model.Note;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class NewNoteActivity extends AppCompatActivity {

    EditText etTitle;
    EditText etDescription;
    EditText etPriority;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new__note_);

        etTitle = findViewById(R.id.etTitle);
        etDescription = findViewById(R.id.etDescription);
        etPriority = findViewById(R.id.etPriority);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.save_note_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.save:
                saveNote();
                return true;
                default:
                    return super.onOptionsItemSelected(item);
        }

    }

    private void saveNote() {


        String Title = etTitle.getText().toString();
        String Description = etDescription.getText().toString();
        int Priority =  Integer.parseInt(etPriority.getText().toString());


        if (Title.trim().isEmpty() || Description.trim().isEmpty()){

            Toast.makeText(this, "Please Insert title and Description", Toast.LENGTH_SHORT).show();
            return;
        }

        CollectionReference notebookRef = FirebaseFirestore.getInstance()
                .collection("NoteBook");

        notebookRef.add(new Note(Title,Description,Priority));
        Toast.makeText(this, "Note Added", Toast.LENGTH_SHORT).show();
        finish();

    }
}
