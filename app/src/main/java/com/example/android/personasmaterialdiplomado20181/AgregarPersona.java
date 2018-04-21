package com.example.android.personasmaterialdiplomado20181;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

import static com.example.android.personasmaterialdiplomado20181.Metodos.fotoAleatoria;

public class AgregarPersona extends AppCompatActivity {
    private EditText txtCedula,txtNombre,txtApellido;
    private Spinner cmbSexo;
    private ArrayAdapter<String> adapter;
    private String opc[];
    private ArrayList<Integer> fotos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_persona);
        txtCedula = findViewById(R.id.txtCedula);
        txtNombre = findViewById(R.id.txtNombre);
        txtApellido = findViewById(R.id.txtApellido);
        cmbSexo = findViewById(R.id.cmbSexo);

        opc = this.getResources().getStringArray(R.array.sexo);
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,opc);
        cmbSexo.setAdapter(adapter);
        fotos.add(R.drawable.images2);
        fotos.add(R.drawable.images3);
    }

    public void guardar(View v){
        String ced,nom,ape;
        int sex,foto;
        foto = fotoAleatoria(fotos);
        ced = txtCedula.getText().toString();
        nom = txtNombre.getText().toString();
        ape = txtApellido.getText().toString();
        sex = cmbSexo.getSelectedItemPosition();

        Persona p = new Persona(foto,ced,nom,ape,sex);
        p.guardar();

        Snackbar.make(v,getResources().getString(R.string.mensajeGuardado),Snackbar.LENGTH_SHORT)
                .setAction("Action",null).show();

        limpiar();
    }

    public void limpiar(){
        txtCedula.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
        cmbSexo.setSelection(0);
        txtCedula.requestFocus();
    }

    public void limpiar(View v){
        limpiar();
    }
}
